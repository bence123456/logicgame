package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.apache.commons.lang3.StringUtils;
import validation.validationBaseVisitor;
import validation.validationParser;

import java.util.List;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;

public class ValidationVisitor extends validationBaseVisitor<String> {

    private GameDefinition gameDefinition;

    public ValidationVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    public String visitValidation(validationParser.ValidationContext validationContext) {
        validationParser.StatementListContext statementListContext = validationContext.statementList();
        String validationCode;

        if (simpleValidation(statementListContext)) {
            validationCode = createSimpleValidationCode(statementListContext);
        } else {
            validationCode= visitStatementList(statementListContext);
            indent(validationCode);
        }

        return createValidationClassCode(validationCode);
    }

    private boolean simpleValidation(validationParser.StatementListContext statementListContext) {
        List<validationParser.StatementContext> statementContextList = statementListContext.statement();
        return statementContextList.size() == 1 && statementContextList.get(0).returnStatement() != null;
    }

    private String createSimpleValidationCode(validationParser.StatementListContext statementListContext) {
        validationParser.ReturnStatementContext returnStatementContext = statementListContext.statement(0).returnStatement();
        List<validationParser.ExpressionContext> expressionContexts = returnStatementContext.multipleExpression().expression();

        StringBuilder sb = new StringBuilder();
        sb.append("return ");



        for (validationParser.ExpressionContext expressionContext : expressionContexts) {
            sb.append(visitFunc(expressionContext.func()));
        }

        return sb.append(";").toString();
    }

    public String visitFunc(validationParser.FuncContext funcContext) {
        StringBuilder sb = new StringBuilder();
        if (funcContext.NEG() != null) {
            sb.append("!");
        }

        String funcname = funcContext.funcname().getText();
    }

    public String visitMultipleExpression(validationParser.MultipleExpressionContext ctx) {

    }

    public String visitModifyStatement(validationParser.ModifyStatementContext ctx) {

    }

    public String visitStatementList(validationParser.StatementListContext context) {
        return visitList(context.statement(), "\n");
    }

    public String visitBlock(validationParser.BlockContext context) {
        String statements = visitStatementList(context.statementList());
        indent(statements);
        return "\n{ " + statements + "\n}";
    }

    public String visitVariableDeclaration(validationParser.VariableDeclarationContext context) {
        String varAndTypeName = getVarNameAndType(context);

        // declaration
        if (context.expression() == null) {
            return varAndTypeName + ";";
        }

        // definition
        String expression = visitExpression(context.expression());
        return varAndTypeName + " = " +  expression + ";";
    }

    public String visitAssignmentStatement(validationParser.AssignmentStatementContext context) {
        String varName = context.varName().getText();
        String expression = visitExpression(context.expression());

        return varName + " = " + expression + ";";
    }

//    public String visitFunc(validationParser.FuncContext ctx) {
//        // TODO!!  common methods in ValidationBase, check if exists?
//        return visitChildren(ctx);
//    }

    public String visitIfStatement(validationParser.IfStatementContext context) {
        String result = "if (" + visitExpression(context.expression()) + ") ";
        result += visitBlock(context.block());

        return result;
    }

    public String visitExpression(validationParser.ExpressionContext context) {
        // TODO: complex expressions (operations)
        return context.getChild(0).getText();
    }

    private String getVarNameAndType(validationParser.VariableDeclarationContext context) {
        String varName = context.varName().getText();

        // var
        if (context.typeName() == null) {
            validationParser.ExpressionContext expr = context.expression();

            if (expr.NUMBER() != null)
                return "int " + varName;

            if (expr.STRING() != null)
                return "String " + varName;

            if (expr.BOOL() != null)
                return "boolean " + varName;

            // TODO: item, own types?
            // TODO: variable types from symbol table
            return "UNKNOWN " + varName;
        }

        String typeName = context.typeName().getText();

        // not var
        return typeName + " " + varName;
    }

    private String visitList(List<validationParser.StatementContext> tree, String separator) {
        String result = "";

        for (int i = 0; i < tree.size(); i++) {
            if (i > 0) {
                result += separator;
            }
            result += visit(tree.get(i));
        }

        return result;
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

}
