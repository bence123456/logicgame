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
        String initCode = createInitCode(typedeclContext);

        String className = typeName + "Tile";
        if (initCode != null && !initCode.isEmpty()) {
            return createTileCodeForPlayableType(className, initCode);
        } else {
            return createTileCodeForUnMutableType(className);
        }
    }


    private String createInitCode(typesParser.TypedeclContext typedeclContext) {
        typesParser.TypedefContext typedefContext = typedeclContext.typedef();

        if (typedefContext != null) {
            typesParser.LoopContext loopContext = typedefContext.loop();
            return (loopContext != null) ? visitLoopDeclaration(loopContext) : visitTypedefDeclaration(typedefContext);
        }

        return "";
    }

    private String visitLoopDeclaration(typesParser.LoopContext loopContext) {
        StringBuilder sb = new StringBuilder();

        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
        List<Item> itemList = createItemListFromLoop(loopContext, gameDefinition);

        return "";
        //return createTypeStatementListFromLoop(itemIndex, itemList);
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
        sb.append(D_TAB + "this.typeStatementList = Arrays.asList(\n");


        // TODO: create common method for this kind of code generation (arrays.aslist)
        boolean isFirst = true;
        for (typesParser.TypestatementContext typestatementContext : typedefContext.typestatement()) {
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

    private TypeStatement createTypeStatement(Integer itemIndex, List<Item> itemList, int conditionIndex, int updateIndex) {
        List<Condition> conditionList = Arrays.asList(new Condition(itemIndex, itemList.get(conditionIndex)));
        List<Update> updateList = Arrays.asList(new Update(itemIndex, itemList.get(updateIndex)));

        return new TypeStatement(conditionList, updateList);
    }

    private String createTypeStatement(GameDefinition gameDefinition, typesParser.TypestatementContext typestatementContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("new TypeStatement(");
        boolean firstCondition = true;
        boolean firstUpdate = true;

        sb.append("Arrays.asList(");
        for (typesParser.ConditionContext conditionContext : typestatementContext.condition()) {
            sb.append(parseCondition(gameDefinition, conditionContext, firstCondition));
            firstCondition = false;
        }

        sb.append("), Arrays.asList(");
        for (typesParser.UpdatestatementContext updatestatementContext : typestatementContext.updatestatement()) {
            sb.append(parseUpdate(gameDefinition, updatestatementContext, firstUpdate));
            firstUpdate =false;
        }
        sb.append("))");

        return sb.toString();
    }

    private String parseUpdate(GameDefinition gameDefinition, typesParser.UpdatestatementContext updatestatementContext, boolean firstUpdate) {
        StringBuilder sb = new StringBuilder();
        if (!firstUpdate) {
            sb.append(", ");
        }

        Integer itemToUpdateIndex = Integer.parseInt(updatestatementContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(updatestatementContext.item().getText(), gameDefinition);
        sb.append("new Update(" + itemToUpdateIndex + ", " + itemCreationString + ")");

        return sb.toString();
    }

    private String parseCondition(GameDefinition gameDefinition, typesParser.ConditionContext conditionContext, boolean firstCondition) {
        StringBuilder sb = new StringBuilder();
        if (!firstCondition) {
            sb.append(", ");
        }

        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().NUMBER().getText());
        String itemCreationString = ParserUtil.getItemCreationString(conditionContext.item().getText(), gameDefinition);
        sb.append("new Condition(" + comparableItemIndex + ", " + itemCreationString + ")");

        return sb.toString();
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
        String importForParent = unMutable ? "import com.bkonecsni.logicgame.domain.map.UnMutableTile;\n" +
                                             "import com.bkonecsni.logicgame.domain.common.Item;\n\n" :

                                             "import com.bkonecsni.logicgame.domain.common.Item;\n" +
                                             "import com.bkonecsni.logicgame.domain.map.TileBase;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.TypeStatement;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.equation.Condition;\n" +
                                             "import com.bkonecsni.logicgame.domain.types.equation.Update;\n\n";

        String arraysImport = unMutable ? "" : "import java.util.Arrays;\n";

        sb.append(importForParent + "import java.awt.Color;\n" + "import java.awt.Point;\n" +
                arraysImport + "import java.util.List;\n\n");
    }
}