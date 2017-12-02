package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import types.typesLexer;
import types.typesParser.*;
import types.typesParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TypesParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseTypes(input, gameDefinition);
    }

    private void parseTypes(CharStream typesInput, GameDefinition gameDefinition) {
        TypesContext typesContext = getTypesContext(typesInput);

        Map<String, Type> typesMap = gameDefinition.getTypesMap();
        typesMap.put("Type0", new Type());

        for (ParseTree typeChild : typesContext.children) {
            String typeName = "Type" + typeChild.getChild(0).getChild(1).getText();
            if (typesMap.containsKey(typeName)) {
                throw new TypeAlreadyDefinedException(typeName);
            }

            TypedefContext typedefContext = (TypedefContext) typeChild.getChild(1);
            List<TypeStatement> typeStatementList = createTypeStatements(typedefContext,  gameDefinition);

            Type type = new Type(typeStatementList);
            typesMap.put(typeName, type);
        }
    }

    private TypesContext getTypesContext(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);
        return typesParser.types();
    }

    private List<TypeStatement> createTypeStatements(TypedefContext typeDefContext, GameDefinition gameDefinition) {
        List<TypeStatement> typeStatementList = new ArrayList<>();
        ParseTree typedefChild = typeDefContext.getChild(0);

        if (typedefChild instanceof LoopContext) {
            typeStatementList = createTypeStatementListFromLoop((LoopContext) typedefChild, gameDefinition);
        } else {
            typeStatementList = createTypeStatementList(typeDefContext,  gameDefinition);
        }

        return typeStatementList;
    }

    private List<TypeStatement> createTypeStatementListFromLoop(LoopContext loopContextContext, GameDefinition gameDefinition) {
        Integer itemIndex = Integer.valueOf(loopContextContext.getChild(1).getChild(1).getText());
        List<Item> itemList = createItemListFromLoop(loopContextContext, gameDefinition);

        return createTypeStatementListFromLoop(itemIndex, itemList);
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

    private List<Item> createItemListFromLoop(LoopContext loopContextContext, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();
        ParamsContext paramsContext = (ParamsContext) loopContextContext.getChild(5);

        for (ParseTree parseTree : paramsContext.children) {
            if (parseTree instanceof ItemContext) {
                Item item = createItem(parseTree.getChild(0).getText(), gameDefinition);
                itemList.add(item);
            }
        }

        return itemList;
    }

    private List<TypeStatement> createTypeStatementList(TypedefContext typedefContext, GameDefinition gameDefinition) {
        List<TypeStatement> typeStatementList = new ArrayList<>();

        for (ParseTree typedef : typedefContext.children) {
            TypestatementContext typestatementContext = (TypestatementContext) typedef;
            TypeStatement typeStatement = new TypeStatement();
            List<Condition> conditionList = new ArrayList<>();
            List<Update> updateList = new ArrayList<>();

            for (ParseTree statement : typestatementContext.children) {
                if (statement instanceof ConditionContext) {
                    parseCondition(gameDefinition, conditionList, (ConditionContext) statement);
                }
                if (statement instanceof UpdatestatementContext) {
                    parseUpdate(gameDefinition, updateList, (UpdatestatementContext) statement);
                }
            }
            typeStatement.setUpdateList(updateList);
            typeStatement.setConditionList(conditionList);
            typeStatementList.add(typeStatement);
        }

        return typeStatementList;
    }

    private void parseUpdate(GameDefinition gameDefinition, List<Update> updateList, UpdatestatementContext updatestatementContext) {
        Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().children.get(1).getText());
        Item newItem = createItem(updatestatementContext.item().getText(), gameDefinition);
        Update update = new Update(itemToUpdateIndex, newItem);

        updateList.add(update);
    }

    private void parseCondition(GameDefinition gameDefinition, List<Condition> conditionList, ConditionContext conditionContext) {
        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().getChild(1).getText());
        Item itemToCompare = createItem(conditionContext.item().getText(), gameDefinition);
        Condition condition = new Condition(comparableItemIndex, itemToCompare);

        conditionList.add(condition);
    }
}
