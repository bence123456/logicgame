package com.bkonecsni.logicgame.visitors.types;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import types.typesBaseVisitor;
import types.typesParser.*;

import java.util.*;

public class TypesVisitor extends typesBaseVisitor<Map<String, String>> {

    private GameDefinition gameDefinition;

    private TypesClassCodeCreator typesClassCodeCreator;

    public TypesVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        typesClassCodeCreator = new TypesClassCodeCreator(gameDefinition);
    }

    @Override
    public Map<String, String> visitTypes(TypesContext typesContext) {
        Map<String, String> typeCodeList = new HashMap<>();
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        for (TypeDeclarationContext typedeclContext : typesContext.typeDeclaration()) {
            String typeName = "Type" + typedeclContext.typeHeader().NUMBER().getText();
            if (definedTypes.contains(typeName)) {
                throw new TypeAlreadyDefinedException(typeName);
            }

            String tileCode = createTileCode(typedeclContext, typeName);

            definedTypes.add(typeName);
            typeCodeList.put(typeName, tileCode);
        }

        return typeCodeList;
    }

    private String createTileCode(TypeDeclarationContext typedeclContext, String typeName) {
        TypeDefinitionContext typedefContext = typedeclContext.typeDefinition();
        String className = typeName + "Tile";
        String tileJavaCode;

        if (typedefContext != null) {
            tileJavaCode = createPlayableTileCode(typedefContext, className);
        } else {
            tileJavaCode = typesClassCodeCreator.createTileCodeForUnMutableType(className);
        }

        return VisitorUtil.formatJavaCode(tileJavaCode);
    }

    private String createPlayableTileCode(TypeDefinitionContext typedefContext, String className) {
        String initCode = createInitCode(typedefContext);
        return typesClassCodeCreator.createTileCodeForCommonPlayableType(className, initCode);
    }

    private String createInitCode(TypeDefinitionContext typedefContext) {
        LoopContext loopContext = typedefContext.loop();
        return (loopContext != null) ? visitLoopDeclaration(loopContext) : visitTypedefDeclaration(typedefContext);
    }

    private String visitLoopDeclaration(LoopContext loopContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("this.typeStatementList = Arrays.asList(");

        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
        List<String> itemList = createItemCreationStringListFromLoop(loopContext, gameDefinition);
        sb.append(createTypeStatementListFromLoop(itemIndex, itemList));
        sb.append(");");

        return sb.toString();
    }

    private List<String> createItemCreationStringListFromLoop(LoopContext loopContext, GameDefinition gameDefinition) {
        List<String> itemCreationStringList = new ArrayList<>();

        for (ItemContext itemContext : loopContext.params().item()) {
            String itemCreationString = VisitorUtil.getItemCreationString(itemContext.getText(), gameDefinition);
            itemCreationStringList.add(itemCreationString);
        }

        return itemCreationStringList;
    }

    private String createTypeStatementListFromLoop(Integer itemIndex, List<String> itemCreationStringList) {
        StringBuilder sb = new StringBuilder();
        int numberOfItems = itemCreationStringList.size();

        for (int i = 0; i < numberOfItems; i++) {
            if (i == numberOfItems - 1) {
                sb.append(createTypeStatement(itemIndex, itemCreationStringList, i, 0));
            } else {
                sb.append(createTypeStatement(itemIndex, itemCreationStringList, i, i+1));
                sb.append(",");
            }
        }

        return sb.toString();
    }

    private String visitTypedefDeclaration(TypeDefinitionContext typedefContext) {
        String typeDefString = null;
        List<TypeStatementContext> typestatementContextList = typedefContext.typeStatement();

        StringBuilder sb = new StringBuilder();
        sb.append("this.typeStatementList = Arrays.asList(");
        sb.append(visitTypeStatements(typestatementContextList));

        typeDefString = sb.append(");").toString();

        return typeDefString;
    }

    private String visitTypeStatements(List<TypeStatementContext> typestatementContextList) {
        StringBuilder sb = new StringBuilder();

        boolean isFirst = true;
        for (TypeStatementContext typestatementContext : typestatementContextList) {
            if (isFirst) {
                sb.append(createTypeStatement(gameDefinition, typestatementContext));
                isFirst = false;
            } else {
                sb.append("," + createTypeStatement(gameDefinition, typestatementContext));
            }
        }

        return sb.toString();
    }

    private String createTypeStatement(Integer itemIndex, List<String> itemCreationStringList, int conditionIndex, int updateIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("new TypeStatement(");

        sb.append("Arrays.asList(");
        sb.append(parseCondition(itemIndex, itemCreationStringList.get(conditionIndex)));
        sb.append("), Arrays.asList(");
        sb.append(parseUpdate(itemIndex, itemCreationStringList.get(updateIndex)));

        sb.append("))");
        return sb.toString();
    }

    private String createTypeStatement(GameDefinition gameDefinition, TypeStatementContext typestatementContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("new TypeStatement(");
        boolean firstCondition = true;
        boolean firstUpdate = true;

        sb.append("Arrays.asList(");
        for (ConditionContext conditionContext : typestatementContext.condition()) {
            sb.append(parseCondition(gameDefinition, conditionContext, firstCondition));
            firstCondition = false;
        }

        sb.append("), Arrays.asList(");
        for (UpdateStatementContext updatestatementContext : typestatementContext.updateStatement()) {
            sb.append(parseUpdate(gameDefinition, updatestatementContext, firstUpdate));
            firstUpdate =false;
        }
        sb.append("))");

        return sb.toString();
    }

    private String parseUpdate(GameDefinition gameDefinition, UpdateStatementContext updatestatementContext, boolean firstUpdate) {
        StringBuilder sb = new StringBuilder();
        if (!firstUpdate) {
            sb.append(", ");
        }

        Integer itemToUpdateIndex = Integer.parseInt(updatestatementContext.parens_nr().NUMBER().getText());
        String itemCreationString = VisitorUtil.getItemCreationString(updatestatementContext.item().getText(), gameDefinition);
        sb.append(parseUpdate(itemToUpdateIndex, itemCreationString));

        return sb.toString();
    }

    private String parseCondition(GameDefinition gameDefinition, ConditionContext conditionContext, boolean firstCondition) {
        StringBuilder sb = new StringBuilder();
        if (!firstCondition) {
            sb.append(", ");
        }

        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().NUMBER().getText());
        String itemCreationString = VisitorUtil.getItemCreationString(conditionContext.item().getText(), gameDefinition);
        sb.append(parseCondition(comparableItemIndex, itemCreationString));

        return sb.toString();
    }

    private String parseCondition(Integer itemToUpdateIndex, String itemCreationString) {
        return parseEquation(itemToUpdateIndex, itemCreationString, "new Condition(");
    }

    private String parseUpdate(Integer comparableItemIndex, String itemCreationString) {
        return parseEquation(comparableItemIndex, itemCreationString, "new Update(");
    }

    private String parseEquation(Integer leftItemIndex, String itemCreationString, String constructorString) {
        return constructorString + leftItemIndex + ", " + itemCreationString + ")";
    }
}