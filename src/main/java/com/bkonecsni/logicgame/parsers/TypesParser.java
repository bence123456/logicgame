package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import types.typesLexer;
import types.typesParser.*;
import types.typesParser;


import java.util.ArrayList;
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
            List<TypeStatement> typeStatementList = createTypeStatementList(typeChild.getChild(1),  gameDefinition);
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

    private List<TypeStatement> createTypeStatementList(ParseTree typeChild, GameDefinition gameDefinition) {
        TypedefContext typedefContext = (TypedefContext) typeChild;

        List<TypeStatement> typeStatementList = new ArrayList<>();

        for (ParseTree typedef : typedefContext.children) {
            TypestatementContext typestatementContext = (TypestatementContext) typedef;
            TypeStatement typeStatement = new TypeStatement();
            List<Condition> conditionList = new ArrayList<>();
            List<Update> updateList = new ArrayList<>();

            for (ParseTree statement : typestatementContext.children) {
                if (statement instanceof ConditionContext) {
                    parseCondition(gameDefinition, typeStatement, conditionList, (ConditionContext) statement);
                }
                if (statement instanceof UpdatestatementContext) {
                    parseUpdate(gameDefinition, typeStatement, updateList, (UpdatestatementContext) statement);
                }
            }
            typeStatement.setUpdateList(updateList);
            typeStatement.setConditionList(conditionList);
            typeStatementList.add(typeStatement);
        }

        return typeStatementList;
    }

    private void parseUpdate(GameDefinition gameDefinition, TypeStatement typeStatement, List<Update> updateList, UpdatestatementContext updatestatementContext) {
        Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().children.get(1).getText());
        Item newItem = createItem(updatestatementContext.item().getText(), gameDefinition);
        Update update = new Update(itemToUpdateIndex, newItem);

        updateList.add(update);
    }

    private void parseCondition(GameDefinition gameDefinition, TypeStatement typeStatement, List<Condition> conditionList, ConditionContext conditionContext) {
        Integer comparableItemIndex = Integer.parseInt(conditionContext.parens_nr().getChild(1).getText());
        Item itemToCompare = createItem(conditionContext.item().getText(), gameDefinition);
        Condition condition = new Condition(comparableItemIndex, itemToCompare);

        conditionList.add(condition);
    }
}
