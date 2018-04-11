package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import types.typesBaseVisitor;
import types.typesParser;

import java.util.*;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.*;

public class TypesVisitor extends typesBaseVisitor<Map<String, String>> {

    private GameDefinition gameDefinition;

    public TypesVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public Map<String, String> visitTypes(typesParser.TypesContext typesContext) {
        Map<String, String> typeCodeList = new HashMap<>();
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        for (typesParser.TypedeclContext typedeclContext : typesContext.typedecl()) {
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

    private String createTileCode(typesParser.TypedeclContext typedeclContext, String typeName) {
        String onClickCode = createOnClickCode(typedeclContext);

        String className = typeName + "Tile";
        if (onClickCode != null && !onClickCode.isEmpty()) {
            return createTileCodeForPlayableType(className, onClickCode);
        } else {
            return createTileCodeForUnMutableType(className);
        }
    }


    private String createOnClickCode(typesParser.TypedeclContext typedeclContext) {
        typesParser.TypedefContext typedefContext = typedeclContext.typedef();

        if (typedefContext != null) {
            typesParser.LoopContext loopContext = typedefContext.loop();
            return (loopContext != null) ? visitLoopDeclaration(loopContext) : visitTypedefDeclaration(typedefContext);
        }

        return "";
    }

    private String visitLoopDeclaration(typesParser.LoopContext loopContext) {
//        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
//        List<Item> itemList = createItemListFromLoop(loopContext, gameDefinition);
//
//        return createTypeStatementListFromLoop(itemIndex, itemList);
        return null;
    }

    private List<Item> createItemListFromLoop(typesParser.LoopContext loopContext, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();

        for (typesParser.ItemContext itemContext : loopContext.params().item()) {
            Item item = ParserUtil.createItem(itemContext.getText(), gameDefinition);
            itemList.add(item);
        }

        return itemList;
    }

    private List<TypeStatement> createTypeStatementListFromLoop(Integer itemIndex, List<Item> itemList) {
        List<TypeStatement> typeStatementList = new ArrayList<>();
        int numberOfItems = itemList.size();

        for (int i = 0; i < numberOfItems; i++) {
            if (i == numberOfItems - 1) {
                TypeStatement typeStatement = createTypeStatement(itemIndex, itemList, i, 0);
                typeStatementList.add(typeStatement);
            } else {
                TypeStatement typeStatement = createTypeStatement(itemIndex, itemList, i, i+1);
                typeStatementList.add(typeStatement);
            }
        }

        return typeStatementList;
    }

    private String visitTypedefDeclaration(typesParser.TypedefContext typedefContext) {
        StringBuilder sb = new StringBuilder();
        boolean firstStatement = true;

        for (typesParser.TypestatementContext typestatementContext : typedefContext.typestatement()) {
            if (firstStatement) {
                sb.append(D_TAB + createTypeStatement(gameDefinition, typestatementContext));
                firstStatement = false;
            } else {
                sb.append(SPACE + "else " + createTypeStatement(gameDefinition, typestatementContext));
            }
        }

        return sb.toString();
    }

    private TypeStatement createTypeStatement(Integer itemIndex, List<Item> itemList, int conditionIndex, int updateIndex) {
        List<Condition> conditionList = Arrays.asList(new Condition(itemIndex, itemList.get(conditionIndex)));
        List<Update> updateList = Arrays.asList(new Update(itemIndex, itemList.get(updateIndex)));

        return new TypeStatement(conditionList, updateList);
    }

    private String createTypeStatement(GameDefinition gameDefinition, typesParser.TypestatementContext typestatementContext) {
        StringBuilder sb = new StringBuilder();

        for (typesParser.ConditionContext conditionContext : typestatementContext.condition()) {
            parseCondition(gameDefinition, conditionContext, sb);
        }

        for (typesParser.UpdatestatementContext updatestatementContext : typestatementContext.updatestatement()) {
            parseUpdate(gameDefinition, updatestatementContext, sb);
        }

        return sb.toString();
    }

    private void parseUpdate(GameDefinition gameDefinition, typesParser.UpdatestatementContext updatestatementContext, StringBuilder sb) {
        Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(updatestatementContext.item().getText(), gameDefinition);

        sb.append(T_TAB + "Item oldItem = itemList.get("+ itemToUpdateIndex + ");\n" + T_TAB + "itemList.remove(oldItem);\n");
        if (itemCreationString != null) {
            sb.append(T_TAB + "itemList.add("+ itemCreationString +");\n");
        }
        sb.append(D_TAB + "}");
    }

    private void parseCondition(GameDefinition gameDefinition, typesParser.ConditionContext conditionContext, StringBuilder sb) {
        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(conditionContext.item().getText(), gameDefinition);

        if (itemCreationString == null) {
            sb.append("if (itemList.get("+ comparableItemIndex + ") == null) {\n");
        } else {
            sb.append("if (itemList.get("+ comparableItemIndex + ").equals("+ itemCreationString +")) {\n");
        }
    }

    private String createTileCodeForPlayableType(String className, String onClickCode) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "TileBase", false);
        appendConstructor(sb, className);

        appendOverride(sb);
        sb.append(TAB + "public void onClick() {\n" + onClickCode + "\n" + TAB + "}\n\n");
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
        String importForParent = unMutable ? "import com.bkonecsni.logicgame.domain.map.UnMutableTile;\n" :
                                             "import com.bkonecsni.logicgame.domain.map.TileBase;\n";

        sb.append(importForParent + "import com.bkonecsni.logicgame.domain.common.Item;\n\n" +
                "import java.awt.Point;\n" +
                "import java.awt.Color;\n" +
                "import java.util.List;\n\n");
    }
}