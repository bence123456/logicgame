package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.exceptions.NoSuchValidationMethodException;
import com.bkonecsni.logicgame.exceptions.ValidationMethodParameterException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import com.bkonecsni.logicgame.validation.ValidationUtil;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.T_TAB;

public class SimpleValidationVisitor {

    private GameDefinition gameDefinition;

    public SimpleValidationVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

//    public String visitValidation(simple_validationParser.ValidationContext validationContext) {
//        String validationCode = null;
//
//        try {
//            validationCode = createSimpleValidationCode(validationContext);
//        } catch (ValidationMethodParameterException e) {
//            e.printStackTrace();
//        }
//
//        return createValidationClassCode(validationCode);
//    }
//
//    public String createSimpleValidationCode(simple_validationParser.ValidationContext validationContext) throws ValidationMethodParameterException {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("return ");
//
//        createValidationCode(validationContext, stringBuilder);
//
//        stringBuilder.append(";\n");
//        return stringBuilder.toString();
//    }
//
//    private void createValidationCode(simple_validationParser.ValidationContext validationContext, StringBuilder stringBuilder)
//            throws ValidationMethodParameterException {
//
//        boolean isFirst = true;
//
//        for (simple_validationParser.WinContext winContext : validationContext.win()) {
//            simple_validationParser.FuncContext funcContext = winContext.func();
//            String methodName = getMethodName(funcContext);
//            List<String> methodParams = getMethodParams(funcContext.params(), gameDefinition, methodName);
//            String negation = Boolean.parseBoolean(winContext.BOOL().getText()) ? "" : "!";
//
//            if (isFirst) {
//                stringBuilder.append(negation + methodName + "(" + StringUtils.join(methodParams, ',') + ")");
//                isFirst = false;
//            } else {
//                stringBuilder.append(" && \n" + T_TAB + negation + methodName + "(" + StringUtils.join(methodParams, ',') + ")");
//            }
//        }
//    }
//
//    private String getMethodName(simple_validationParser.FuncContext funcContext) {
//        String methodName = funcContext.funcname().getText();
//        List<String> validationMethodNames = getValidationMethodNames();
//
//        if (!validationMethodNames.contains(methodName)) {
//            throw new NoSuchValidationMethodException(methodName);
//        }
//
//        return methodName;
//    }
//
//    private List<String> getMethodParams(simple_validationParser.ParamsContext paramsContext, GameDefinition gameDefinition,
//                                         String methodName) throws ValidationMethodParameterException {
//
//        List<Class> paramTypes = ValidationUtil.getValidationFuncNameParamsMap().get(methodName);
//        List<simple_validationParser.ParamContext> paramContexts = paramsContext.param();
//
//        checkParamTypesAndSize(paramsContext, methodName, paramTypes, paramContexts);
//
//        List<String> itemList = createItemList(gameDefinition, paramTypes, paramContexts);
//
//        return itemList;
//    }
//
//    private List<String> createItemList(GameDefinition gameDefinition, List<Class> paramTypes,
//                                        List<simple_validationParser.ParamContext> paramContexts) throws ValidationMethodParameterException {
//
//        List<String> itemList = new ArrayList<>();
//
//        for (int i=0; i<paramContexts.size(); i++) {
//            Class paramType = paramTypes.get(i);
//            TerminalNode number = paramContexts.get(i).NUMBER();
//            String itemContextText = number == null ? paramContexts.get(i).item().getChild(1).getText() : number.getText();
//
//            if (paramType.equals(Item.class)) {
//                addItemParamToList(gameDefinition, itemList, itemContextText);
//            } else if (paramType.equals(Integer.class)) {
//                addIntParamToList(itemList, i, itemContextText);
//            }
//        }
//
//        return itemList;
//    }
//
//    private void checkParamTypesAndSize(simple_validationParser.ParamsContext paramsContext, String methodName, List<Class> paramTypes,
//                                        List<simple_validationParser.ParamContext> paramContexts) throws ValidationMethodParameterException {
//
//        if (paramsContext == null && !paramTypes.isEmpty() || paramsContext != null && paramContexts.size() != paramTypes.size()) {
//            throw new ValidationMethodParameterException("Number of paramaters in " + methodName + " does not have the expected size!");
//        }
//    }

    private void addItemParamToList(GameDefinition gameDefinition, List<String> itemList, String itemContextText) throws ValidationMethodParameterException {
        String itemCreationString = ParserUtil.getItemCreationString(itemContextText, gameDefinition);
        if (itemCreationString == null) {
            throw new ValidationMethodParameterException("Item parameter is invalid! Declare it based on the rules.");
        }
        itemList.add(itemCreationString);
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
