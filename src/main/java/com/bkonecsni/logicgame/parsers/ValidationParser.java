package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;
import com.bkonecsni.logicgame.visitors.ValidationVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.LooseContext;
import validation.validationParser.ValidationContext;
import validation.validationParser.WinContext;

import java.util.List;

public class ValidationParser implements IParser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        ValidationContext validationContext = getValidationContext(input);
        ValidationVisitor validationVisitor = new ValidationVisitor(gameDefinition);

        createWinStatements(gameDefinition, validationContext, validationVisitor);
        createLooseStatements(gameDefinition, validationContext, validationVisitor);
    }

    private void createWinStatements(GameDefinition gameDefinition, ValidationContext validationContext, ValidationVisitor validationVisitor) {
        for (WinContext winContext : validationContext.win()) {
            ValidationStatement winStatement = validationVisitor.visitWin(winContext);
            gameDefinition.getWinStatementList().add(winStatement);
        }
    }

    private void createLooseStatements(GameDefinition gameDefinition, ValidationContext validationContext, ValidationVisitor validationVisitor) {
        boolean looseDefined = false;
        for (LooseContext looseContext : validationContext.loose()) {
            ValidationStatement looseStatement = validationVisitor.visitLoose(looseContext);
            gameDefinition.getLooseStatementList().add(looseStatement);
            looseDefined = true;
        }

        defineLooseStatementsIfNecessary(gameDefinition, looseDefined);
    }

    private void defineLooseStatementsIfNecessary(GameDefinition gameDefinition, boolean looseDefined) {
        if (!looseDefined) {
            List<ValidationStatement> looseStatementList = gameDefinition.getLooseStatementList();
            for (ValidationStatement winStatement : gameDefinition.getWinStatementList()) {
                boolean looseExpectedValue = !winStatement.getExpectedValue();
                ValidationStatement looseStatement = new ValidationStatement(winStatement.getMethodName(), winStatement.getMethodParams(), looseExpectedValue);
                looseStatementList.add(looseStatement);
            }
        }
    }

    private ValidationContext getValidationContext(CharStream validationInput) {
        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);
        return validationParser.validation();
    }
}
