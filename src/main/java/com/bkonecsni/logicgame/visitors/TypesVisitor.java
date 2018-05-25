package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import types.typesBaseVisitor;
import types.typesParser;
import types.typesParser.*;

import java.util.*;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.*;

public class TypesVisitor extends typesBaseVisitor<Map<String, String>> {

    private GameDefinition gameDefinition;

    public TypesVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public Map<String, String> visitTypes(TypesContext typesContext) {
        Map<String, String> typeCodeList = new HashMap<>();
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        for (TypedeclContext typedeclContext : typesContext.typedecl()) {
            String typeName = "Type" + typedeclContext.typehead().NUMBER().getText();
            if (definedTypes.contains(typeName)) {
                throw new TypeAlreadyDefinedException(typeName);
            }

            String tileCode = createTileCode(typedeclContext, typeName);

            definedTypes.add(typeName);
            typeCodeList.put(typeName, tileCode);
        }

        return typeCodeList;
    }

    private String createTileCode(TypedeclContext typedeclContext, String typeName) {
        String initCode = createInitCode(typedeclContext);

        String className = typeName + "Tile";
        if (initCode != null && !initCode.isEmpty()) {
            return createTileCodeForPlayableType(className, initCode);
        } else {
            return createTileCodeForUnMutableType(className);
        }
    }


    private String createInitCode(TypedeclContext typedeclContext) {
        TypedefContext typedefContext = typedeclContext.typedef();

        if (typedefContext != null) {
            LoopContext loopContext = typedefContext.loop();
            return (loopContext != null) ? visitLoopDeclaration(loopContext) : visitTypedefDeclaration(typedefContext);
        }

        return "";
    }

    private String visitLoopDeclaration(LoopContext loopContext) {
        StringBuilder sb = new StringBuilder();
        sb.append(D_TAB + "this.typeStatementList = Arrays.asList(\n");

        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
        List<String> itemList = createItemCreationStringListFromLoop(loopContext, gameDefinition);
        sb.append(createTypeStatementListFromLoop(itemIndex, itemList));

        sb.append("\n" + D_TAB + ");");
        return sb.toString();

    }

    private List<String> createItemCreationStringListFromLoop(LoopContext loopContext, GameDefinition gameDefinition) {
        List<String> itemCreationStringList = new ArrayList<>();

        for (typesParser.ItemContext itemContext : loopContext.params().item()) {
            String itemCreationString = ParserUtil.getItemCreationString(itemContext.getText(), gameDefinition);
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
                sb.append(",\n");
            }
        }

        return sb.toString();
    }

    private String visitTypedefDeclaration(TypedefContext typedefContext) {
        StringBuilder sb = new StringBuilder();
        sb.append(D_TAB + "this.typeStatementList = Arrays.asList(\n");

        boolean isFirst = true;
        for (TypestatementContext typestatementContext : typedefContext.typestatement()) {
            if (isFirst) {
                sb.append(T_TAB + createTypeStatement(gameDefinition, typestatementContext));
                isFirst = false;
            } else {
                sb.append(",\n" + T_TAB + createTypeStatement(gameDefinition, typestatementContext));
            }
        }

        sb.append("\n" + D_TAB + ");");
        return sb.toString();
    }

    private String createTypeStatement(Integer itemIndex, List<String> itemCreationStringList, int conditionIndex, int updateIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append(T_TAB + "new TypeStatement(");

        sb.append("Arrays.asList(");
        sb.append(parseCondition(itemIndex, itemCreationStringList.get(conditionIndex)));
        sb.append("), Arrays.asList(");
        sb.append(parseUpdate(itemIndex, itemCreationStringList.get(updateIndex)));

        sb.append("))");
        return sb.toString();
    }

    private String createTypeStatement(GameDefinition gameDefinition, TypestatementContext typestatementContext) {
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
        for (UpdatestatementContext updatestatementContext : typestatementContext.updatestatement()) {
            sb.append(parseUpdate(gameDefinition, updatestatementContext, firstUpdate));
            firstUpdate =false;
        }
        sb.append("))");

        return sb.toString();
    }

    private String parseUpdate(GameDefinition gameDefinition, UpdatestatementContext updatestatementContext, boolean firstUpdate) {
        StringBuilder sb = new StringBuilder();
        if (!firstUpdate) {
            sb.append(", ");
        }

        Integer itemToUpdateIndex = Integer.parseInt(updatestatementContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(updatestatementContext.item().getText(), gameDefinition);
        sb.append(parseUpdate(itemToUpdateIndex, itemCreationString));

        return sb.toString();
    }

    private String parseCondition(GameDefinition gameDefinition, ConditionContext conditionContext, boolean firstCondition) {
        StringBuilder sb = new StringBuilder();
        if (!firstCondition) {
            sb.append(", ");
        }

        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(conditionContext.item().getText(), gameDefinition);
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

    private String createTileCodeForPlayableType(String className, String initCode) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "TileBase", false);
        appendConstructor(sb, className);

        appendOverride(sb);
        sb.append(TAB + "public void init() {\n" + initCode + "\n" + TAB + "}\n\n");
        appendOverride(sb);
        sb.append(TAB + "public boolean isUnmutableType() {\n" + D_TAB + "return false;\n" + TAB + "}\n\n" + "}\n\n");

        return sb.toString();
    }

    private String createTileCodeForUnMutableType(String className) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "UnMutableTile", true);
        appendConstructor(sb, className);
        sb.append("}\n\n");

        return sb.toString();
    }

    private void appendImportsAndClassHeader(StringBuilder sb, String className, String parentClassName, boolean unMutable) {
        sb.append("package gamecode." + gameDefinition.getGameName() + ".types;\n\n");
        appendImports(sb, unMutable);
        sb.append("public class " + className + " extends " + parentClassName + " {\n\n");
    }

    private void appendConstructor(StringBuilder sb, String className) {
        sb.append(TAB + "public " + className +"(Point position, Point size, List<Item> itemList) {\n" +
                D_TAB + "super(position, size, itemList);\n" +
                TAB + "}\n\n");
    }

    private void appendOverride(StringBuilder sb) {
        sb.append(TAB + "@Override\n");
    }

    private void appendImports(StringBuilder sb, boolean unMutable) {
        String importString = unMutable ? "import com.bkonecsni.logicgame.domain.map.UnMutableTile;\n" +
                                             "import com.bkonecsni.logicgame.domain.common.Item;\n\n" +
                                             "import java.awt.Point;\n" + "import java.util.List;\n\n" :

                                             "import com.bkonecsni.logicgame.domain.common.Item;\n" +
                                             "import com.bkonecsni.logicgame.domain.map.TileBase;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.TypeStatement;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.equation.Condition;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.equation.Update;\n\n" +
                                             "import java.awt.Color;\n" + "import java.awt.Point;\n" +
                                             "import java.util.Arrays;\n" + "import java.util.List;\n\n";

        sb.append(importString);
    }
}