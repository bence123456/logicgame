package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.exceptions.CommonValidationException;
import com.bkonecsni.logicgame.exceptions.NoSuchValidationMethodException;
import org.apache.commons.lang3.StringUtils;
import validation.validationParser.*;

import java.lang.reflect.Method;
import java.util.*;

import static com.bkonecsni.logicgame.visitors.validation.SupportedOperator.*;
import static com.bkonecsni.logicgame.visitors.validation.SupportedType.*;

public class ValidationVisitorHelper {

    private Map<String, SupportedType> definedVariablesTypeMap = new HashMap();

    void visitForLoop(ForStatementContext ctx, StringBuilder sb) {
        String type = ctx.type().getText();
        checkIfTypeSupported(type);

        String varName = ctx.varName().get(0).getText();
        definedVariablesTypeMap.put(varName, SupportedType.fromString(type));

        String listVarName = ctx.varName().get(1).getText();
        checkIfVariableDeclared(listVarName);
        if (!definedVariablesTypeMap.get(listVarName).equals(SupportedType.LIST)) {
            throw new CommonValidationException("Must loop through a list in this kind of for loop!");
        }

        sb.append(type + " " + varName + " : " + listVarName);
    }

    void visitIncrementialForLoop(ForStatementContext ctx, StringBuilder sb, VariableDeclarationContext variableDeclarationContext) {
        String varName = ctx.varName().get(0).getText();
        checkVarNameInFor(variableDeclarationContext, varName);

        sb.append(varName);
        sb.append(ctx.INCORDESC());
    }

    void appendFuncName(FuncContext funcContext, StringBuilder sb, String funcName) {
        if (funcContext.ID() != null) {
            String varName = funcContext.ID().getText();
            checkIfVariableDeclared(varName);
            sb.append(varName + ".");
        }

        sb.append(funcName).append(funcContext.LP().getText());
    }

    SupportedType getExpressionReturnType(ExpressionContext expressionContext) {
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

    SupportedType getExpressionReturnType(SupportedType leftReturnType, SupportedType rightReturnType, SupportedOperator operator){
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

    SupportedType getExpressionReturnType(FuncContext funcContext){
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

    List<Class<?>> getParamTypes(ParamsContext paramsContext) {
        List<Class<?>> paramTypes = new ArrayList<>();

        if (paramsContext != null) {
            for (ParamContext paramContext : paramsContext.param()) {
                if (paramContext.NUMBER() != null) {
                    paramTypes.add(INT.getClazz());
                } else if (paramContext.item() != null) {
                    paramTypes.add(ITEM.getClazz());
                } else if (paramContext.mparam() != null) {
                    String paramName = paramContext.getText();
                    checkIfVariableDeclared(paramName);
                    Class<?> clazz = definedVariablesTypeMap.get(paramName).getClazz();
                    paramTypes.add(clazz);
                }
            }
        }

        return paramTypes;
    }

    SupportedOperator getSupportedOperator(OperatorContext operatorContext) {
        String operatorText = operatorContext.getText();
        SupportedOperator supportedOperator = SupportedOperator.fromString(operatorText);

        checkIfOperatorSupported(operatorText, supportedOperator);

        return supportedOperator;
    }

    String getVarNameAndType(VariableDeclarationContext context) {
        String varName = context.varName().getText();
        String typeName = context.typeName().getText();

        String type = getType(context.typeName());
        checkIfTypeSupported(type);
        checkIfVariableIsUsed(varName);
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

    String getType(TypeNameContext typeNameContext) {
        if (typeNameContext.listType() != null) {
            return "List";
        }

        return typeNameContext.type().getText();
    }

    String getClassName(FuncContext funcContext) {
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

    Method getMethod(FuncContext funcContext, String funcName, String className) {
        List<Class<?>> paramTypes = getParamTypes(funcContext.params());
        Class<?> clazz = loadClass(className);

        Method method;
        try {
            method = loadMethod(clazz, funcName, paramTypes);
        } catch (NoSuchMethodException e) {
            method = loadMethodWithObjectParamType(clazz, funcName, paramTypes);
        }

        return method;
    }

    private Method loadMethodWithObjectParamType(Class<?> clazz, String funcName, List<Class<?>> originalParamTypes) {
        List<Class<?>> paramTypes = Arrays.asList(Object.class);

        try {
            return loadMethod(clazz, funcName, paramTypes);
        } catch (NoSuchMethodException e) {
            String availableMethods = listAvailableMethods(clazz.getMethods());
            throw new NoSuchValidationMethodException(funcName, createParamTypesString(originalParamTypes), availableMethods);
        }
    }

    Method loadMethod(Class<?> clazz, String funcname, List<Class<?>> paramTypes) throws NoSuchMethodException {
        Class<?>[] paramTypesArray = paramTypes.toArray(new Class<?>[paramTypes.size()]);

        Method method = clazz.getMethod(funcname, paramTypesArray);

        return method;
    }

    Class<?> loadClass(String className) {
        Class<?> clazz = null;

        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return clazz;
    }

    ReturnStatementContext getReturnStatement(StatementListContext statementListContext) {
        List<StatementContext> statementContextList = statementListContext.statement();
        int statementsSize = statementContextList.size();

        return statementContextList.get(statementsSize - 1).returnStatement();
    }

    void checkIfLastStatementIsReturn(ReturnStatementContext returnStatementContext) {
        if (returnStatementContext == null) {
            throw new CommonValidationException("Validation code must end with a return statement!");
        }
    }

    void checkIfReturnStatementTypeIsBool(ReturnStatementContext returnStatementContext) {
        if (returnStatementContext.BOOL() == null) {
            List<ExpressionContext> expressionList = returnStatementContext.multipleExpression().expression();
            int expressionSize = expressionList.size();
            ExpressionContext lastExpression = expressionList.get(expressionSize - 1);

            SupportedType lastExpressionReturnType = getExpressionReturnType(lastExpression);
            if (!SupportedType.BOOL.equals(lastExpressionReturnType)) {
                throw new CommonValidationException("Last is expression in the return statement is not BOOL!");
            }
        }
    }

    void checkIfReturnTypeIsBool(Method method) {
        if (!method.getReturnType().equals(boolean.class)) {
            throw new CommonValidationException("Operator '!' can only be used before methods with boolean return type!");
        }
    }

    void checkSemiColonExistanceInIfStatement(IfStatementContext context) {
        if (context.boolStatement().SCOLON() != null) {
            throw new CommonValidationException("Semi colon is forbidden in if statement!");
        }
    }

    void checkIfVariableIsUsed(String varName) {
        if (definedVariablesTypeMap.containsKey(varName)) {
            throw new CommonValidationException("Variable name: " + varName + " is already in use!");
        }
    }

    void checkIfVariableDeclared(String variableName) {
        if (!definedVariablesTypeMap.containsKey(variableName)) {
            throw new CommonValidationException(variableName + " variable is not declared!");
        }
    }

    void checkIfOperatorApplicable(SupportedType leftExpressionReturnType, SupportedOperator operator) {
        List<SupportedOperator> supportedOperators = leftExpressionReturnType.getSupportedOperators();
        if (!supportedOperators.contains(operator)) {
            throw new CommonValidationException(operator.getStringValue() + " operator can not be applied between " + leftExpressionReturnType
                    + " types. Available operators: " + listSupportedOperators((SupportedOperator[]) supportedOperators.toArray()));
        }
    }

    private void checkIfOperatorSupported(String operatorText, SupportedOperator supportedOperator) {
        if (supportedOperator == null) {
            throw new CommonValidationException(operatorText + " operator is not supported! Supported operators: "
                    + listSupportedOperators(SupportedOperator.values()));
        }
    }

    private void checkVarNameInFor(VariableDeclarationContext variableDeclarationContext, String varName) {
        if (!variableDeclarationContext.varName().getText().equals(varName)) {
            throw new CommonValidationException("Variable name in for statement must be the declared one!");
        }
    }

    void checkIfTypeSupported(String type) {
        if (SupportedType.fromString(type) == null) {
            throw new CommonValidationException(type + " type is not supported! Supported types: " + listSupportedTypes());
        }
    }

    String listSupportedTypes() {
        String supportedTypes = "";
        for (SupportedType supportedType : SupportedType.values()) {
            supportedTypes += supportedType.toString() + ", ";
        }

        return StringUtils.removeEnd(supportedTypes, ", ");
    }

    String listSupportedOperators(SupportedOperator[] supportedOperators) {
        String supportedOperatorsString = "";
        for (SupportedOperator supportedOperator : supportedOperators) {
            supportedOperatorsString += supportedOperator.getStringValue() + ", ";
        }

        return StringUtils.removeEnd(supportedOperatorsString, ", ");
    }

    String createParamTypesString(List<Class<?>> paramTypes) {
        String paramTypesString = "";
        for (Class<?> clazz : paramTypes) {
            paramTypesString += clazz.toString() + ", ";
        }

        return StringUtils.removeEnd(paramTypesString, ", ");
    }

    String listAvailableMethods(Method[] methods) {
        String availableMethods = "";
        for (Method method : methods) {
            availableMethods += method.getName() + ", ";
        }

        return StringUtils.removeEnd(availableMethods, ", ");
    }
}
