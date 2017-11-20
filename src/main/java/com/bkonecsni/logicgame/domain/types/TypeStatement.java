package com.bkonecsni.logicgame.domain.types;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class TypeStatement {

    private int comparableItemIndex;

    private Item itemToCompare;

    private List<Update> updateList;

    public TypeStatement(int comparableItemIndex, Item itemToCompare, List<Update> updateList) {
        this.comparableItemIndex = comparableItemIndex;
        this.itemToCompare = itemToCompare;
        this.updateList = updateList;
    }

    public TypeStatement() { }

    public boolean isApplicable(List<Item> itemList) {
        if (itemList.size() - 1 < comparableItemIndex) {
            // handle ItemList(x) == empty case
            return itemToCompare == null;
        }
        Item comparableItem = itemList.get(comparableItemIndex);

        return comparableItem.equals(itemToCompare);
    }

    public int getComparableItemIndex() {
        return comparableItemIndex;
    }

    public void setComparableItemIndex(int comparableItemIndex) {
        this.comparableItemIndex = comparableItemIndex;
    }

    public Item getItemToCompare() {
        return itemToCompare;
    }

    public void setItemToCompare(Item itemToCompare) {
        this.itemToCompare = itemToCompare;
    }

    public List<Update> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<Update> updateList) {
        this.updateList = updateList;
    }
}
