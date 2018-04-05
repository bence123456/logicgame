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

public class TypesVisitor extends typesBaseVisitor<String> {

    private GameDefinition gameDefinition;

    public TypesVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public String visitTypes(typesParser.TypesContext typesContext) {
        Set<String> definedTypes = gameDefinition.getDefinedTypes();
        StringBuilder sb = new StringBuilder();

        for (typesParser.TypedeclContext typedeclContext : typesContext.typedecl()) {
            String typeName = "Type" + typedeclContext.typehead().NUMBER().getText();
            if (definedTypes.contains(typeName)) {
                throw new TypeAlreadyDefinedException(typeName);
            }

            String onClickCode = createOnClickCode(typedeclContext);
            if (onClickCode != null && !onClickCode.isEmpty()) {
                createTileCode(sb, typeName, onClickCode);
            } else {
                createTileCodeForUnMutableType(sb, typeName);
            }

            definedTypes.add(typeName);
        }

        return sb.toString();
    }

    @Override
    public String visitTypedef(typesParser.TypedefContext typedefContext) {
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

    @Override
    public String visitLoop(typesParser.LoopContext loopContext) {
//        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
//        List<Item> itemList = createItemListFromLoop(loopContext, gameDefinition);
//
//        return createTypeStatementListFromLoop(itemIndex, itemList);
        return null;
    }

    private void createTileCode(StringBuilder sb, String typeName, String onClickCode) {
        String className = typeName + "Tile";
        sb.append("class " + className + " extends TileBase {\n\n");
        appendConstructor(sb, className);

        appendOverrite(sb);
        sb.append(TAB + "public void onClick() {\n" + onClickCode + "\n" + TAB + "}\n\n");
        appendOverrite(sb);
        sb.append(TAB + "public boolean isUnmutableType() {\n" + D_TAB + "return false;\n" + TAB + "}\n\n" + "}\n\n");
    }

    private void createTileCodeForUnMutableType(StringBuilder sb, String typeName) {
        String className = typeName + "Tile";
        sb.append("class " + className + " extends UnMutableTile {\n\n");
        appendConstructor(sb, className);
        sb.append("}\n\n");
    }

    private String createOnClickCode(typesParser.TypedeclContext typedeclContext) {
        typesParser.TypedefContext typedefContext = typedeclContext.typedef();

        if (typedefContext != null) {
            typesParser.LoopContext loopContext = typedefContext.loop();
            return (loopContext != null) ? visitLoop(loopContext) : visitTypedef(typedefContext);
        }

        return "";
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

    private void appendConstructor(StringBuilder sb, String className) {
        sb.append(TAB + "public " + className +"(Point position, Point size, List<Item> itemList) {\n" +
                D_TAB + "super(position, size, itemList);\n" +
                TAB + "}\n\n");
    }

    private void appendOverrite(StringBuilder sb) {
        sb.append(TAB + "@Override\n");
    }
}