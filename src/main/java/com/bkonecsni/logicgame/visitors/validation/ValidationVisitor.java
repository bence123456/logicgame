package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.runner.GameDefinition;
import com.bkonecsni.logicgame.exceptions.CommonValidationException;
import com.bkonecsni.logicgame.visitors.statementlist.CommonStatementListVisitor;
import com.bkonecsni.logicgame.visitors.statementlist.SupportedType;
import statementlist.statementListParser.*;

import java.util.List;

public class ValidationVisitor extends CommonStatementListVisitor {

    private ValidationClassCodeCreator codeCreator;

    public ValidationVisitor(GameDefinition gameDefinition) {
        super(gameDefinition);
        codeCreator = new ValidationClassCodeCreator();
    }

    @Override
    public String visitStatementList(StatementListContext statementListContext) {
        ReturnStatementContext returnStatementContext = getReturnStatement(statementListContext);
        checkIfLastStatementIsReturn(returnStatementContext);

        String validationCode = visitStatements(statementListContext);
        checkIfReturnStatementTypeIsBool(returnStatementContext);

        return codeCreator.createValidationClassCode(validationCode, gameDefinition);
    }

    private ReturnStatementContext getReturnStatement(StatementListContext statementListContext) {
        List<StatementContext> statementContextList = statementListContext.statement();
        int statementsSize = statementContextList.size();

        return statementContextList.get(statementsSize - 1).returnStatement();
    }

    private void checkIfLastStatementIsReturn(ReturnStatementContext returnStatementContext) {
        if (returnStatementContext == null) {
            throw new CommonValidationException("Validation code must end with a return statement!");
        }
    }

    private void checkIfReturnStatementTypeIsBool(ReturnStatementContext returnStatementContext) {
        if (returnStatementContext.BOOL() == null) {
            List<ExpressionContext> expressionList = returnStatementContext.multipleExpression().expression();
            int expressionSize = expressionList.size();
            ExpressionContext lastExpression = expressionList.get(expressionSize - 1);

            SupportedType lastExpressionReturnType = helper.getExpressionReturnType(lastExpression);
            if (!SupportedType.BOOL.equals(lastExpressionReturnType)) {
                throw new CommonValidationException("Last is expression in the return statement is not BOOL!");
            }
        }
    }

}