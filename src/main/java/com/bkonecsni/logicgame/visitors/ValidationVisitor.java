package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;
import com.bkonecsni.logicgame.exceptions.NoSuchValidationMethodException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import com.bkonecsni.logicgame.validation.ValidationMethods;
import validation.validationBaseVisitor;
import validation.validationParser;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ValidationVisitor extends validationBaseVisitor<ValidationStatement> {

    private GameDefinition gameDefinition;

    public ValidationVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public ValidationStatement visitWin(validationParser.WinContext winContext) {
        validationParser.FuncContext funcContext = winContext.func();

        String methodName = getMethodName(funcContext);
        List<Item> methodParams = getMethodParams(funcContext.params(), gameDefinition);
        boolean expectedValue = Boolean.parseBoolean(winContext.BOOL().getText());

        return new ValidationStatement(methodName, methodParams, expectedValue);
    }

    @Override
    public ValidationStatement visitLoose(validationParser.LooseContext looseContext) {
        validationParser.FuncContext funcContext = looseContext.func();

        String methodName = getMethodName(funcContext);
        List<Item> methodParams = getMethodParams(funcContext.params(), gameDefinition);
        boolean expectedValue = Boolean.parseBoolean(looseContext.BOOL().getText());

        return new ValidationStatement(methodName, methodParams, expectedValue);
    }

    private String getMethodName(validationParser.FuncContext funcContext) {
        String methodName = funcContext.funcname().getText();

        List<String> validationMethodNames = getValidationMethodNames();

        if (!validationMethodNames.contains(methodName)) {
            throw new NoSuchValidationMethodException(methodName);
        }

        return methodName;
    }

    private List<Item> getMethodParams(validationParser.ParamsContext paramsContext, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();

        if (paramsContext != null) {
            for (validationParser.ItemContext itemContext : paramsContext.item()) {
                String itemAsString = itemContext.getText();
                Item item = ParserUtil.createItem(itemAsString, gameDefinition);
                itemList.add(item);
            }
        }

        return itemList;
    }

    private List<String> getValidationMethodNames() {
        Method[] validationMethods = ValidationMethods.class.getMethods();
        List<String> validationMethodNames = new ArrayList<>();

        for (Method validationMethod : validationMethods) {
            validationMethodNames.add(validationMethod.getName());
        }

        return validationMethodNames;
    }
}