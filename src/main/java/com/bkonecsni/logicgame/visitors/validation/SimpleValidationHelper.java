package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.exceptions.NoSuchValidationMethodException;
import com.bkonecsni.logicgame.exceptions.ValidationMethodParameterException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import com.bkonecsni.logicgame.validation.ValidationUtil;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import validation.validationParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.T_TAB;

public class SimpleValidationHelper {

    private GameDefinition gameDefinition;

    public SimpleValidationHelper(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    public String createValidationCode(validationParser.ValidationContext validationContext) throws ValidationMethodParameterException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("return ");

        createValidationCode(validationContext, stringBuilder);

        stringBuilder.append(";\n");
        return stringBuilder.toString();
    }

    private void createValidationCode(validationParser.ValidationContext validationContext, StringBuilder stringBuilder)
            throws ValidationMethodParameterException {

        boolean isFirst = true;

        for (validationParser.FuncContext funcContext : validationContext.func()) {
            String methodName = getMethodName(funcContext);
            List<String> methodParams = getMethodParams(funcContext.params(), gameDefinition, methodName);
            String negation = Boolean.parseBoolean(funcContext.BOOL().getText()) ? "" : "!";

            if (isFirst) {
                stringBuilder.append(negation + methodName + "(" + StringUtils.join(methodParams, ',') + ")");
                isFirst = false;
            } else {
                stringBuilder.append(" && \n" + T_TAB + negation + methodName + "(" + StringUtils.join(methodParams, ',') + ")");
            }
        }
    }

    private String getMethodName(validationParser.FuncContext funcContext) {
        String methodName = funcContext.funcname().getText();
        List<String> validationMethodNames = getValidationMethodNames();

        if (!validationMethodNames.contains(methodName)) {
            throw new NoSuchValidationMethodException(methodName);
        }

        return methodName;
    }

    private List<String> getMethodParams(validationParser.ParamsContext paramsContext, GameDefinition gameDefinition,
                                         String methodName) throws ValidationMethodParameterException {

        List<Class> paramTypes = ValidationUtil.getValidationFuncNameParamsMap().get(methodName);
        List<validationParser.ParamContext> paramContexts = paramsContext.param();

        checkParamTypesAndSize(paramsContext, methodName, paramTypes, paramContexts);

        List<String> itemList = createItemList(gameDefinition, paramTypes, paramContexts);

        return itemList;
    }

    private List<String> createItemList(GameDefinition gameDefinition, List<Class> paramTypes,
                                        List<validationParser.ParamContext> paramContexts) throws ValidationMethodParameterException {

        List<String> itemList = new ArrayList<>();

        for (int i=0; i<paramContexts.size(); i++) {
            Class paramType = paramTypes.get(i);
            TerminalNode number = paramContexts.get(i).NUMBER();
            String itemContextText = number == null ? paramContexts.get(i).item().getText().replace(" ", "") : number.getText();

            if (paramType.equals(Item.class)) {
                addItemParamToList(gameDefinition, itemList, itemContextText);
            } else if (paramType.equals(Integer.class)) {
                addIntParamToList(itemList, i, itemContextText);
            }
        }

        return itemList;
    }

    private void checkParamTypesAndSize(validationParser.ParamsContext paramsContext, String methodName, List<Class> paramTypes,
                                        List<validationParser.ParamContext> paramContexts) throws ValidationMethodParameterException {

        if (paramsContext == null && !paramTypes.isEmpty() || paramsContext != null && paramContexts.size() != paramTypes.size()) {
            throw new ValidationMethodParameterException("Number of paramaters in " + methodName + " does not have the expected size!");
        }
    }

    private void addItemParamToList(GameDefinition gameDefinition, List<String> itemList, String itemContextText) throws ValidationMethodParameterException {
        if (itemContextText.startsWith("item:")) {
            String itemCreationString = ParserUtil.getItemCreationString(itemContextText.substring(5), gameDefinition);
            if (itemCreationString == null) {
                throw new ValidationMethodParameterException("Item parameter is invalid! Declare it based on the rules.");
            }
            itemList.add(itemCreationString);
        } else {
            throw new ValidationMethodParameterException("Item parameter is in incorrect format! Use 'item: [item text]'");
        }
    }

    private void addIntParamToList(List<String> itemList, int i, String itemContextText) throws ValidationMethodParameterException {
        try {
            Integer.parseInt(itemContextText);
        } catch (NumberFormatException e) {
            throw  new ValidationMethodParameterException(i + ". parameter should be an integer!");
        }

        itemList.add(itemContextText);
    }

    private List<String> getValidationMethodNames() {
        Set<String> validationMethodNamesSet = ValidationUtil.getValidationFuncNameParamsMap().keySet();
        return new ArrayList<>(validationMethodNamesSet);
    }
}
