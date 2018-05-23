package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.ValidationMethodParameterException;
import org.apache.commons.lang3.StringUtils;
import validation.validationBaseVisitor;
import validation.validationParser;

import java.util.List;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;

public class ValidationVisitor extends validationBaseVisitor<String> {

    private SimpleValidationHelper simpleValidationHelper;

    private GameDefinition gameDefinition;

    public ValidationVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        this.simpleValidationHelper = new SimpleValidationHelper(gameDefinition);
    }

    public String visitValidation(validationParser.ValidationContext validationContext) {
        String validationCode;

        if (validationContext.statementList() != null) {
            validationCode = visitList(validationContext.statementList().statement(), "\n");
            indent(validationCode);
        } else {
            validationCode = createSimpleValidationCode(validationContext);
        }

        return createValidationClassCode(validationCode);
    }

    private String createSimpleValidationCode(validationParser.ValidationContext validationContext) {
        String validationCode = null;

        try {
            validationCode = simpleValidationHelper.createValidationCode(validationContext);
        } catch (ValidationMethodParameterException e) {
            e.printStackTrace();
        }

        return validationCode;
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

    /// COMPLEX
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

    public String visitFunc(validationParser.FuncContext ctx) {
        // TODO!!  common methods in ValidationBase, check if exists?
        return visitChildren(ctx);
    }

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

}
