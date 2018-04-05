package com.bkonecsni.logicgame.statehandler;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Update;
import com.bkonecsni.logicgame.domain.types.equation.Condition;

import java.util.ArrayList;
import java.util.List;

public class StateHandler {

    public void act(TileBase actualTile) {
        List<Item> itemList = actualTile.getItemList();

        actualTile.onClick();

//        List<TypeStatement> typeStatementList = actualTile.getTypeStatementList();
//
//        List<Update> updateList = findUpdateList(itemList, typeStatementList);
//        for (Update update : updateList) {
//            update.execute(itemList);
//        }
    }

    private List<Update> findUpdateList(List<Item> itemList, List<TypeStatement> typeStatementList) {
        List<Update> updateList = new ArrayList<>();

        for (TypeStatement typeStatement : typeStatementList) {
            if (areAllConditionMatch(itemList, typeStatement)) {
                updateList = typeStatement.getUpdateList();
                break;
            }
        }

        return updateList;
    }

    private boolean areAllConditionMatch(List<Item> itemList, TypeStatement typeStatement){
        boolean areAllConditionMatch = true;

        for (Condition condition : typeStatement.getConditionList()) {
            if (!condition.isConditionMatch(itemList)) {
                areAllConditionMatch = false;
                break;
            }
        }

        return areAllConditionMatch;
    }

}
