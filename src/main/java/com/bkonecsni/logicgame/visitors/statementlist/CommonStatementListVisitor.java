package com.bkonecsni.logicgame.visitors.statementlist;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import org.antlr.v4.runtime.tree.TerminalNode;
import statementlist.statementListBaseVisitor;
import statementlist.statementListParser.*;

import java.lang.reflect.Method;
import java.util.List;

public class CommonStatementListVisitor extends statementListBaseVisitor<String> {

    protected CommonStatementListVisitorHelper helper;

    protected GameDefinition gameDefinition;

    public CommonStatementListVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        helper = new CommonStatementListVisitorHelper();
    }

    @Override
    public String visitStatementList(StatementListContext statementListContext) {
       return visitStatements(statementListContext);
    }

    @Override
    public String visitBlock(BlockContext context) {
        String statements = visitStatements(context.statementList());
        return " {" + statements + "}";
    }

    @Override
    public String visitStatement(StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDeclaration(VariableDeclarationContext context) {
        String varAndTypeName = helper.getVarNameAndType(context);

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
    public String visitReturnStatement(ReturnStatementContext ctx) {
        String statement = ctx.BOOL() != null ? ctx.BOOL().getText() : visitMultipleExpression(ctx.multipleExpression());
        return "return " + statement + ";";
    }

    @Override
    public String visitIfStatement(IfStatementContext context) {
        helper.checkSemiColonExistanceInIfStatement(context);
        StringBuilder sb = new StringBuilder();

        sb.append("if (" + visitBoolStatement(context.boolStatement()) + ") ");
        sb.append(visitBlock(context.block()));
        sb.append(visitElseStatement(context.elseStatement()));

        return sb.toString();
    }

    @Override
    public String visitElseStatement(ElseStatementContext context) {
        StringBuilder sb = new StringBuilder();

        if (context != null) {
            sb.append("else ");
            sb.append(visitBlock(context.block()));
        }

        return sb.toString();
    }

    @Override
    public String visitModifyStatement(ModifyStatementContext ctx) {
        return visitMultipleExpression(ctx.multipleExpression()) + ";";
    }

    @Override
    public String visitForStatement(ForStatementContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("for (");

        VariableDeclarationContext variableDeclarationContext = ctx.variableDeclaration();
        if (variableDeclarationContext != null) {
            sb.append(visitVariableDeclaration(variableDeclarationContext));
            sb.append(visitBoolStatement(ctx.boolStatement()));
            helper.visitIncrementialForLoop(ctx, sb, variableDeclarationContext);
        } else {
            helper.visitForLoop(ctx, sb);
        }

        return sb.append(")").append(visitBlock(ctx.block())).toString();
    }

    @Override
    public String visitBoolStatement(BoolStatementContext ctx) {
        return visitMultipleExpression(ctx.multipleExpression()) + (ctx.SCOLON() != null ? ";" : "");
    }

    @Override
    public String visitExpression(ExpressionContext context) {
        String expressionText = "";

        if (context.func() != null) {
            expressionText = visitFunc(context.func());
        } else if (context.varName() != null) {
            expressionText = visitVarName(context.varName());
        } else if (context.BOOL() != null || context.NUMBER() != null || context.STRING() != null) {
            expressionText = context.getChild(0).getText();
        }

        return " " + expressionText;
    }

    @Override
    public String visitOperator(OperatorContext ctx) {
        return " " + ctx.getText();
    }

    @Override
    public String visitFunc(FuncContext funcContext) {
        StringBuilder sb = new StringBuilder();

        String funcName = funcContext.funcname().getText();
        String className = helper.getClassName(funcContext);
        Method method = helper.getMethod(funcContext, funcName, className);

        if (funcContext.NEG() != null) {
            helper.checkIfReturnTypeIsBool(method);
            sb.append("!");
        }

        helper.appendFuncName(funcContext, sb, funcName);

        if (funcContext.params() != null) {
            sb.append(visitParams(funcContext.params()));
        }

        sb.append(funcContext.RP().getText());

        return sb.toString();
    }

    @Override
    public String visitParams(ParamsContext ctx) {
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
    public String visitParam(ParamContext ctx) {
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

        helper.checkIfVariableDeclared(paramName);

        return paramName;
    }

    @Override
    public String visitVarName(VarNameContext ctx) {
        String varName = ctx.getText();

        helper.checkIfVariableDeclared(varName);

        return " " + varName;
    }

    protected String visitStatements(StatementListContext context) {
        helper.putMapAsDefinedVariable();
        StringBuilder stringBuilder = new StringBuilder();

        for (StatementContext statementContext : context.statement()) {
            stringBuilder.append(visitStatement(statementContext));
        }

        return stringBuilder.toString();
    }

    private String visitMultipleExpression(MultipleExpressionContext ctx, int expressionsSize) {
        StringBuilder sb = new StringBuilder();
        ExpressionContext firstExpression = ctx.expression(0);
        SupportedType leftExpressionReturnType = null;

        for (int i=1; i<expressionsSize; i++) {
            leftExpressionReturnType = appendExpression(ctx, sb, firstExpression, leftExpressionReturnType, i);
        }

        return sb.toString();
    }

    private SupportedType appendExpression(MultipleExpressionContext ctx, StringBuilder sb, ExpressionContext firstExpression, SupportedType leftExpressionReturnType, int i) {
        ExpressionContext rightExpression = ctx.expression(i);
        SupportedType rightExpressionReturnType = helper.getExpressionReturnType(rightExpression);
        OperatorContext operatorContext = ctx.operator(i - 1);
        SupportedOperator operator = helper.getSupportedOperator(operatorContext);

        if (i == 1) {
            leftExpressionReturnType = helper.getExpressionReturnType(firstExpression);
        } else {
            leftExpressionReturnType = helper.getExpressionReturnType(leftExpressionReturnType, rightExpressionReturnType, operator);
        }

        helper.checkIfOperatorApplicable(leftExpressionReturnType, operator);

        if (i == 1) {
            sb.append(visitExpression(firstExpression));
        }

        sb.append(visitOperator(operatorContext));
        sb.append(visitExpression(rightExpression));

        return leftExpressionReturnType;
    }

}
