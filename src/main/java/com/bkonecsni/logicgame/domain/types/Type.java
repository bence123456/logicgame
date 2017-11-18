package com.bkonecsni.logicgame.domain.types;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.Tile;

import java.util.Collections;
import java.util.List;

public class Type {

    private List<TypeStatement> typeStatementList;

    public Type(List<TypeStatement> typeStatementList) {
        this.typeStatementList = typeStatementList;
    }

    public void act(Tile tile){
        List<Item> itemList = tile.getItemList();
        List<Update> updateList = findUpdateList(itemList);

        for (Update update : updateList) {
            executeUpdate(update, itemList);
        }
    }

    private List<Update> findUpdateList(List<Item> itemList) {
        List<Update> updateList = Collections.EMPTY_LIST;

        for (TypeStatement typeStatement : typeStatementList) {
            if (typeStatement.isApplicable(itemList)) {
                updateList = typeStatement.getUpdateList();
                break;
            }
        }

        return updateList;
    }

    private void executeUpdate(Update update, List<Item> itemList) {
        Item oldItem = update.getItemToUpdate();
        Item newItem = update.getNewItem();

        // ItemList(x) = empty
        if (newItem == null) {
            itemList.remove(oldItem);
        } else {
            oldItem.replaceFields(newItem);
        }
    }

    public List<TypeStatement> getTypeStatementList() {
        return typeStatementList;
    }

    public void setTypeStatementList(List<TypeStatement> typeStatementList) {
        this.typeStatementList = typeStatementList;
    }

}
