package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.CommonValidationException;
import com.bkonecsni.logicgame.visitors.util.SupportedOperator;
import com.bkonecsni.logicgame.visitors.util.SupportedType;
import org.apache.commons.lang3.StringUtils;
import validation.validationBaseVisitor;
import validation.validationParser;
import validation.validationParser.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bkonecsni.logicgame.visitors.util.SupportedOperator.*;
import static com.bkonecsni.logicgame.visitors.util.SupportedType.*;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;

public class ValidationVisitor extends validationBaseVisitor<String> {

    private GameDefinition gameDefinition;

    private List<String> definedVariables = new ArrayList<>();

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
        return "\n{ " + statements + "\n}";
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
    public String visitModifyStatement(ModifyStatementContext ctx) {
        return null;
    }

    @Override
    public String visitMultipleExpression(MultipleExpressionContext ctx) {
        int expressionsSize = ctx.getChildCount();

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
        String result = "if (" + visitBoolStatement(context.boolStatement()) + ") ";
        result += visitBlock(context.block());

        return result;
    }

    @Override
    public String visitForStatement(validationParser.ForStatementContext ctx) {
        return null;
    }

    @Override
    public String visitBoolStatement(validationParser.BoolStatementContext ctx) {
        return null;
    }

    @Override
    public String visitExpression(ExpressionContext context) {
        // TODO: complex expressions (operations)
        return " " + context.getChild(0).getText();
    }

    @Override
    public String visitType(validationParser.TypeContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitOperator(validationParser.OperatorContext ctx) {
        return " " + ctx.getText();
    }

    @Override
    public String visitFunc(FuncContext funcContext) {
        StringBuilder sb = new StringBuilder();
        if (funcContext.NEG() != null) {
            sb.append("!");
        }

        String funcname = funcContext.funcname().getText();

        return funcname;
    }

    @Override
    public String visitParams(validationParser.ParamsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitParam(validationParser.ParamContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitItem(validationParser.ItemContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMparam(validationParser.MparamContext ctx) {
        return visitChildren(ctx);
    }

    private String visitList(List<StatementContext> tree, String separator) {
        String result = "";

        for (int i = 0; i < tree.size(); i++) {
            if (i > 0) {
                result += separator;
            }
            result += visit(tree.get(i));
        }

        return result;
    }

    private String visitMultipleExpression(MultipleExpressionContext ctx, int expressionsSize) {
        StringBuilder sb = new StringBuilder();
        ExpressionContext firstExpression = ctx.expression(0);

        for (int i=1; i<expressionsSize; i++) {
            ExpressionContext rightExpression = ctx.expression(i);
            SupportedType rightExpressionReturnType = getExpressionReturnType(rightExpression);
            OperatorContext operatorContext = ctx.operator(i - 1);
            SupportedOperator operator = getSupportedOperator(operatorContext);

            SupportedType leftExpressionReturnType = null;
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
            supportedType = getExpressionReturnType(expressionContext.varName());
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
        return null;
    }

    private SupportedType getExpressionReturnType(VarNameContext varNameContext){
        return null;
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
        if (definedVariables.contains(varName)) {
            throw new CommonValidationException("Variable name: " + varName + " is already in use!");
        }
        definedVariables.add(varName);

        String typeName = context.typeName().getText();
        if (SupportedType.fromString(typeName) == null) {
            throw new CommonValidationException(typeName + " type is not supported! Supported types: " + listSupportedTypes());
        }

        return typeName + " " + varName;
    }

    private void checkIfLastStatementIsReturn(StatementListContext statementListContext) {
        List<StatementContext> statementContextList = statementListContext.statement();
        int statementsSize = statementContextList.size();

        if (statementContextList.get(statementsSize-1).returnStatement() == null) {
            throw new CommonValidationException("Validation code must end with a return statement!");
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
                "import com.bkonecsni.logicgame.domain.validation.ValidationBase;\n\n");
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
}
