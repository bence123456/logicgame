package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.*;

import java.util.ArrayList;
import java.util.List;

public class ValidationParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseValidation(input, gameDefinition);
    }

    private void parseValidation(CharStream validationInput, GameDefinition gameDefinition) {
        ValidationContext validationContext = getValidationContext(validationInput);

        boolean looseDefined = false;
        for (ParseTree validationChild : validationContext.children) {
            if (validationChild instanceof WinContext) {
                ValidationStatement winStatement = parseValidationContext((ParserRuleContext) validationChild, gameDefinition);
                gameDefinition.getWinStatementList().add(winStatement);
            }
            if (validationChild instanceof LooseContext) {
                ValidationStatement looseStatement = parseValidationContext((ParserRuleContext) validationChild, gameDefinition);
                gameDefinition.getLooseStatementList().add(looseStatement);
                looseDefined = true;
            }
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

    private ValidationStatement parseValidationContext(ParserRuleContext validationContext, GameDefinition gameDefinition) {
        FuncContext funcContext = (FuncContext) validationContext.children.get(0);

        String methodName = getMethodName(funcContext);
        List<Item> methodParams = getMethodParams(funcContext.children.get(2), gameDefinition);
        boolean expectedValue = Boolean.parseBoolean(validationContext.children.get(2).getText());

        return new ValidationStatement(methodName, methodParams, expectedValue);
    }

    private String getMethodName(FuncContext funcContext) {
        return funcContext.children.get(0).getText();
    }

    private List<Item> getMethodParams(ParseTree parseTree, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();

        if (parseTree instanceof ParamsContext) {
            for (ParseTree child : ((ParamsContext) parseTree).children) {
                if (child instanceof ItemContext) {
                    String itemAsString = ((ItemContext) child).children.get(0).getText();
                    Item item = createItem(itemAsString, gameDefinition);
                    itemList.add(item);
                }
            }
        }

        return itemList;
    }

    private ValidationContext getValidationContext(CharStream validationInput) {
        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);
        return validationParser.validation();
    }
}
