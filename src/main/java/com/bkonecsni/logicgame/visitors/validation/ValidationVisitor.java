package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.CommonValidationException;
import com.bkonecsni.logicgame.exceptions.NoSuchValidationMethodException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import validation.validationBaseVisitor;
import validation.validationParser;
import validation.validationParser.*;

import java.lang.reflect.Method;
import java.util.*;

import static com.bkonecsni.logicgame.visitors.validation.SupportedOperator.*;
import static com.bkonecsni.logicgame.visitors.validation.SupportedType.*;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;

public class ValidationVisitor extends validationBaseVisitor<String> {

    private GameDefinition gameDefinition;

    private Map<String, SupportedType> definedVariablesTypeMap = new HashMap();

    public ValidationVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public String visitValidation(ValidationContext validationContext) {
        StatementListContext statementListContext = validationContext.statementList();
        checkIfLastStatementIsReturn(statementListContext);

        String validationCode = visitStatementList(statementListContext);
        indent(validationCode);

        return createValidationClassCode(validationCode);
    }

    @Override
    public String visitStatementList(StatementListContext context) {
        return visitList(context.statement(), "\n");
    }

    @Override
    public String visitBlock(validationParser.BlockContext context) {
        String statements = visitStatementList(context.statementList());
        indent(statements);
        return " {\n" + TAB + statements + "\n}\n";
    }

    @Override
    public String visitStatement(validationParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDeclaration(VariableDeclarationContext context) {
        String varAndTypeName = getVarNameAndType(context);

        if (context.multipleExpression() == null) {
            return varAndTypeName + ";";
        }

        String multipleExpression = visitMultipleExpression(context.multipleExpression());
        return varAndTypeName + " = " +  multipleExpression + ";";
    }

    @Override
    public String visitAssignmentStatement(AssignmentStatementContext context) {
        String varName = context.varName().getText();
        String expression = visitMultipleExpression(context.multipleExpression());

        return varName + " = " + expression + ";";
    }

    @Override
    public String visitMultipleExpression(MultipleExpressionContext ctx) {
        int expressionsSize = ctx.expression().size();

        if (expressionsSize == 1) {
            return visitExpression(ctx.expression(0));
        } else {
            return visitMultipleExpression(ctx, expressionsSize);
        }
    }

    @Override
    public String visitReturnStatement(validationParser.ReturnStatementContext ctx) {
        String statement = ctx.BOOL() != null ? ctx.BOOL().getText() : visitMultipleExpression(ctx.multipleExpression());
        return "return " + statement + ";";
    }

    @Override
    public String visitIfStatement(IfStatementContext context) {
        if (context.boolStatement().SCOLON() != null) {
            throw new CommonValidationException("Semi colon is forbidden in if statement!");
        }

        String result = "if (" + visitBoolStatement(context.boolStatement()) + ") ";
        result += visitBlock(context.block());

        return result;
    }

    @Override
    public String visitModifyStatement(ModifyStatementContext ctx) {
        return visitMultipleExpression(ctx.multipleExpression()) + ";";
    }

    @Override
    public String visitForStatement(validationParser.ForStatementContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("for (");

        VariableDeclarationContext variableDeclarationContext = ctx.variableDeclaration();
        if (variableDeclarationContext != null) {
            sb.append(visitVariableDeclaration(variableDeclarationContext));
            sb.append(visitBoolStatement(ctx.boolStatement()));

            String varName = ctx.varName().get(0).getText();
            if (!variableDeclarationContext.varName().getText().equals(varName)) {
                throw new CommonValidationException("Variable name in for statement must be the declared one!");
            }

            sb.append(varName);
            sb.append(ctx.INCORDESC());
        } else {
            String type = ctx.type().getText();
            checkType(type);

            String varName = ctx.varName().get(0).getText();
            definedVariablesTypeMap.put(varName, SupportedType.fromString(type));

            String listVarName = ctx.varName().get(1).getText();
            checkIfVariableDeclared(listVarName);
            if (!definedVariablesTypeMap.get(listVarName).equals(SupportedType.LIST)) {
                throw new CommonValidationException("Must loop through a list in this kind of for loop!");
            }

            sb.append(type + " " + varName + " : " + listVarName);
        }

        return sb.append(")").append(visitBlock(ctx.block())).toString();
    }

    @Override
    public String visitBoolStatement(validationParser.BoolStatementContext ctx) {
        return visitMultipleExpression(ctx.multipleExpression()) + (ctx.SCOLON() != null ? ";" : "");
    }

    @Override
    public String visitExpression(ExpressionContext context) {
        String expressionText = "";

        if (context.func() != null) {
            expressionText = visitFunc(context.func());
        } else if (context.varName() != null) {
            expressionText = visitVarName(context.varName());
        } else if (context.BOOL() != null | context.NUMBER() != null | context.STRING() != null) {
            expressionText = context.getChild(0).getText();
        }

        return " " + expressionText;
    }

    @Override
    public String visitOperator(validationParser.OperatorContext ctx) {
        return " " + ctx.getText();
    }

    @Override
    public String visitFunc(FuncContext funcContext) {
        StringBuilder sb = new StringBuilder();

        String funcName = funcContext.funcname().getText();
        String className = getClassName(funcContext);
        Method method = getMethod(funcContext, funcName, className);

        if (funcContext.NEG() != null) {
            if (!method.getReturnType().equals(boolean.class)) {
                throw new CommonValidationException("Operator '!' can only be used before methods with boolean return type!");
            }
            sb.append("!");
        }

        return getFuncCodeString(funcContext, sb, funcName);
    }

    @Override
    public String visitParams(validationParser.ParamsContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<ParamContext> paramContextList = ctx.param();

        sb.append(visitParam(paramContextList.get(0)));
        for (int i = 1; i< paramContextList.size(); i++) {
            sb.append(", ");
            sb.append(visitParam(paramContextList.get(i)));
        }

        return sb.toString();
    }

    @Override
    public String visitParam(validationParser.ParamContext ctx) {
        TerminalNode number = ctx.NUMBER();

        if (number != null) {
            return number.getText();
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitItem(ItemContext ctx) {
        return ParserUtil.getItemCreationString(ctx.getChild(1).getText(), gameDefinition);
    }

    @Override
    public String visitMparam(MparamContext ctx) {
        String paramName = ctx.getText();

        checkIfVariableDeclared(paramName);

        return paramName;
    }

    @Override
    public String visitVarName(validationParser.VarNameContext ctx) {
        String varName = ctx.getText();

        checkIfVariableDeclared(varName);

        return " " + varName;
    }

    private String visitList(List<StatementContext> tree, String separator) {
        String result = "";

        for (int i = 0; i < tree.size(); i++) {
            if (i > 0) {
                result += separator;
            }
            result += TAB + visit(tree.get(i));
        }

        return result;
    }

    private String getClassName(FuncContext funcContext) {
        String className;

        if (funcContext.ID() != null) {
            String varName = funcContext.ID().getText();
            checkIfVariableDeclared(varName);

            className = definedVariablesTypeMap.get(varName).getClazz().getName();
        } else {
            className = "com.bkonecsni.logicgame.domain.validation.ValidationBase";
        }

        return className;
    }

    private Method getMethod(FuncContext funcContext, String funcName, String className) {
        List<Class<?>> paramTypes = getParamTypes(funcContext.params());

        Class<?> clazz = loadClass(className);
        try {
            return loadMethod(clazz, funcName, paramTypes);
        } catch (NoSuchMethodException e) {
            String availableMethods = listAvailableMethods(clazz.getMethods());
            throw new NoSuchValidationMethodException(funcName, createParamTypesString(paramTypes), availableMethods);
        }
    }

    private Method loadMethod(Class<?> clazz, String funcname, List<Class<?>> paramTypes) throws NoSuchMethodException {
        Class<?>[] paramTypesArray = paramTypes.toArray(new Class<?>[paramTypes.size()]);

        Method method = clazz.getMethod(funcname, paramTypesArray);

        return method;
    }

    private Class<?> loadClass(String className) {
        Class<?> clazz = null;

        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return clazz;
    }

    private String getFuncCodeString(FuncContext funcContext, StringBuilder sb, String funcName) {
        if (funcContext.ID() != null) {
            String varName = funcContext.ID().getText();
            checkIfVariableDeclared(varName);
            sb.append(varName + ".");
        }

        sb.append(funcName).append(funcContext.LP().getText());

        if (funcContext.params() != null) {
            sb.append(visitParams(funcContext.params()));
        }

        sb.append(funcContext.RP().getText());

        return sb.toString();
    }

    private String visitMultipleExpression(MultipleExpressionContext ctx, int expressionsSize) {
        StringBuilder sb = new StringBuilder();
        ExpressionContext firstExpression = ctx.expression(0);
        SupportedType leftExpressionReturnType = null;

        for (int i=1; i<expressionsSize; i++) {
            ExpressionContext rightExpression = ctx.expression(i);
            SupportedType rightExpressionReturnType = getExpressionReturnType(rightExpression);
            OperatorContext operatorContext = ctx.operator(i - 1);
            SupportedOperator operator = getSupportedOperator(operatorContext);

            if (i == 1) {
                leftExpressionReturnType = getExpressionReturnType(firstExpression);
            } else {
                leftExpressionReturnType = getExpressionReturnType(leftExpressionReturnType, rightExpressionReturnType, operator);
            }

            List<SupportedOperator> supportedOperators = leftExpressionReturnType.getSupportedOperators();
            if (!supportedOperators.contains(operator)) {
                throw new CommonValidationException(operator.getStringValue() + "operator can not be applied between " + leftExpressionReturnType
                        + " types. Available operators: " + listSupportedOperators((SupportedOperator[]) supportedOperators.toArray()));
            }

            if (i == 1) {
                sb.append(visitExpression(firstExpression));
            }
            sb.append(visitOperator(operatorContext));
            sb.append(visitExpression(rightExpression));
        }

        return sb.toString();
    }

    private SupportedType getExpressionReturnType(ExpressionContext expressionContext) {
        SupportedType supportedType = null;

        if (expressionContext.STRING() != null) {
            supportedType = STRING;
        } else if (expressionContext.BOOL() != null) {
            supportedType = BOOL;
        } else if (expressionContext.NUMBER() != null) {
            supportedType = INT;
        } else if (expressionContext.func() != null) {
            supportedType = getExpressionReturnType(expressionContext.func());
        } else if (expressionContext.varName() != null) {
            supportedType = definedVariablesTypeMap.get(expressionContext.varName().getText());
        }

        return supportedType;
    }

    private SupportedType getExpressionReturnType(SupportedType leftReturnType, SupportedType rightReturnType, SupportedOperator operator){
        if (leftReturnType.equals(rightReturnType)) {
            SupportedType returnType = leftReturnType;

            if (leftReturnType.equals(INT)) {
                List<SupportedOperator> sameReturnTypeIntOperators = Arrays.asList(PLUS, MINUS, PLUSEQUALS, MINUSEQUALS);
                returnType = sameReturnTypeIntOperators.contains(operator) ? INT : BOOL;
            }

            return returnType;
        } else {
            String message = "Two expressions have different return type, operator can only be applied between expressions with same return type!" +
                    " Left: " + leftReturnType.toString() + ", right: " + rightReturnType.toString();
            throw new CommonValidationException(message);
        }
    }

    private SupportedType getExpressionReturnType(FuncContext funcContext){
        String className = getClassName(funcContext);
        Method method = getMethod(funcContext, funcContext.funcname().getText(), className);

        Class<?> methodReturnType = method.getReturnType();
        String returnTypeString = methodReturnType.getName();

        SupportedType returnType;
        if (methodReturnType.equals(Integer.class)) {
            returnType = SupportedType.INT;
        } else {
            returnType = SupportedType.fromString(returnTypeString);
        }

        if (returnType == null) {
            throw new CommonValidationException("Incorrect return type: " + returnTypeString +
                    "Expression return type should be one of the supported types: " + listSupportedTypes());
        }

        return returnType;
    }

    private List<Class<?>> getParamTypes(ParamsContext paramsContext) {
        List<Class<?>> paramTypes = new ArrayList<>();

        if (paramsContext != null) {
            for (ParamContext paramContext : paramsContext.param()) {
                if (paramContext.NUMBER() != null) {
                    paramTypes.add(INT.getClazz());
                } else if (paramContext.item() != null) {
                    paramTypes.add(ITEM.getClazz());
                } else if (paramContext.mparam() != null) {
                    Class<?> clazz = definedVariablesTypeMap.get(visitMparam(paramContext.mparam())).getClazz();
                    paramTypes.add(clazz);
                }
            }
        }

        return paramTypes;
    }

    private SupportedOperator getSupportedOperator(OperatorContext operatorContext) {
        String operatorText = operatorContext.getText();
        SupportedOperator supportedOperator = SupportedOperator.fromString(operatorText);

        if (supportedOperator == null) {
            throw new CommonValidationException(operatorText + " operator is not supported! Supported operators: "
                    + listSupportedOperators(SupportedOperator.values()));
        }

        return supportedOperator;
    }

    private String getVarNameAndType(VariableDeclarationContext context) {
        String varName = context.varName().getText();
        String typeName = context.typeName().getText();

        String type = getType(context.typeName());
        checkType(type);
        if (definedVariablesTypeMap.containsKey(varName)) {
            throw new CommonValidationException("Variable name: " + varName + " is already in use!");
        }
        SupportedType supportedType = SupportedType.fromString(type);
        definedVariablesTypeMap.put(varName, supportedType);

        if (supportedType.equals(LIST)) {
            MultipleExpressionContext multipleExpressionContext = context.multipleExpression();
            if (multipleExpressionContext != null) {
                ExpressionContext firstExpression = multipleExpressionContext.expression(0);
                if (firstExpression.varName() == null && firstExpression.func() == null) {
                    throw new CommonValidationException("Lists can only be declared with function call or variable assignment, other assignments are forbidden!");
                }
                return "List<" + context.typeName().listType().type().getText() + "> " + varName;
            } else {
                return "List<" + context.typeName().listType().type().getText() + "> " + varName + " = new ArrayList();";
            }
        }

        return typeName + " " + varName;
    }

    private String getType(TypeNameContext typeNameContext) {
        if (typeNameContext.listType() != null) {
            return "List";
        }

        return typeNameContext.type().getText();
    }

    private void checkIfLastStatementIsReturn(StatementListContext statementListContext) {
        List<StatementContext> statementContextList = statementListContext.statement();
        int statementsSize = statementContextList.size();

        if (statementContextList.get(statementsSize-1).returnStatement() == null) {
            throw new CommonValidationException("Validation code must end with a return statement!");
        }
        // TODO check return type
    }

    private void checkIfVariableDeclared(String variableName) {
        if (!definedVariablesTypeMap.containsKey(variableName)) {
            throw new CommonValidationException(variableName + " variable is not declared!");
        }
    }

    private void checkType(String type) {
        if (SupportedType.fromString(type) == null) {
            throw new CommonValidationException(type + " type is not supported! Supported types: " + listSupportedTypes());
        }
    }

    private void indent(String string) {
        if (string != null) {
            string.concat("\t");
            string.replace("\n", "\n\t");
        }
    }

    private String createValidationClassCode(String statements) {
        StringBuilder sb = new StringBuilder();

        String gameName = gameDefinition.getGameName();
        sb.append("package gamecode." + gameName + ".validation;\n\n");

        appendImport(sb);
        sb.append("public class " + StringUtils.capitalize(gameName) + "Validation extends ValidationBase {\n\n");
        sb.append(TAB + "public boolean areWinConditionsApply() {\n");

        sb.append(D_TAB + statements + TAB + "}\n}");

        return sb.toString();
    }

    private void appendImport(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.Item;\n" +
                "import com.bkonecsni.logicgame.domain.map.TileBase;\n" +
                "import com.bkonecsni.logicgame.domain.validation.ValidationBase;\n\n" +
                "import java.awt.Color;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.List;\n"
        );
    }

    private String listSupportedTypes() {
        String supportedTypes = "";
        for (SupportedType supportedType : SupportedType.values()) {
            supportedTypes += supportedType.toString() + ", ";
        }

        return StringUtils.removeEnd(supportedTypes, ", ");
    }

    private String listSupportedOperators(SupportedOperator[] supportedOperators) {
        String supportedOperatorsString = "";
        for (SupportedOperator supportedOperator : supportedOperators) {
            supportedOperatorsString += supportedOperator.getStringValue() + ", ";
        }

        return StringUtils.removeEnd(supportedOperatorsString, ", ");
    }

    private String createParamTypesString(List<Class<?>> paramTypes) {
        String paramTypesString = "";
        for (Class<?> clazz : paramTypes) {
            paramTypesString += clazz.toString() + ", ";
        }

        return StringUtils.removeEnd(paramTypesString, ", ");
    }

    private String listAvailableMethods(Method[] methods) {
        String availableMethods = "";
        for (Method method : methods) {
            availableMethods += method.getName() + ", ";
        }

        return StringUtils.removeEnd(availableMethods, ", ");
    }
}
