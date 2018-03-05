package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import types.typesBaseVisitor;
import types.typesParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypesVisitor extends typesBaseVisitor<List<TypeStatement>> {

    private GameDefinition gameDefinition;

    public TypesVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public List<TypeStatement> visitLoop(typesParser.LoopContext loopContext) {
        Integer itemIndex = Integer.valueOf(loopContext.parens_nr().NUMBER().getText());
        List<Item> itemList = createItemListFromLoop(loopContext, gameDefinition);

        return createTypeStatementListFromLoop(itemIndex, itemList);
    }

    @Override
    public List<TypeStatement> visitTypedef(typesParser.TypedefContext typedefContext) {
        List<TypeStatement> typeStatementList = new ArrayList<>();

        for (typesParser.TypestatementContext typestatementContext : typedefContext.typestatement()) {
            TypeStatement typeStatement = createTypeStatement(gameDefinition, typestatementContext);
            typeStatementList.add(typeStatement);
        }

        return typeStatementList;
    }

    private List<Item> createItemListFromLoop(typesParser.LoopContext loopContext, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();

        for (typesParser.ItemContext itemContext : loopContext.params().item()) {
            Item item = ParserUtil.createItem(itemContext.getChild(0).getText(), gameDefinition);
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

    private TypeStatement createTypeStatement(GameDefinition gameDefinition, typesParser.TypestatementContext typestatementContext) {
        List<Condition> conditionList = new ArrayList<>();
        List<Update> updateList = new ArrayList<>();

        for (typesParser.UpdatestatementContext updatestatementContext : typestatementContext.updatestatement()) {
            Update update = parseUpdate(gameDefinition, updatestatementContext);
            updateList.add(update);
        }

        for (typesParser.ConditionContext conditionContext : typestatementContext.condition()) {
            Condition condition = parseCondition(gameDefinition, conditionContext);
            conditionList.add(condition);
        }

        return new TypeStatement(conditionList, updateList);
    }

    private Update parseUpdate(GameDefinition gameDefinition, typesParser.UpdatestatementContext updatestatementContext) {
        Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().NUMBER().getText());
        Item newItem = ParserUtil.createItem(updatestatementContext.item().getText(), gameDefinition);
        return new Update(itemToUpdateIndex, newItem);
    }

    private Condition parseCondition(GameDefinition gameDefinition, typesParser.ConditionContext conditionContext) {
        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().NUMBER().getText());
        Item itemToCompare = ParserUtil.createItem(conditionContext.item().getText(), gameDefinition);
        return new Condition(comparableItemIndex, itemToCompare);
    }
}