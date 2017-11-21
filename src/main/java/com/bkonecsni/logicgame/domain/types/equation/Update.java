package com.bkonecsni.logicgame.domain.types.equation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class Update {

    private Integer itemToUpdateIndex;

    private Item newItem;

    public Update(Integer itemToUpdateIndex, Item newItem) {
        this.itemToUpdateIndex = itemToUpdateIndex;
        this.newItem = newItem;
    }

    public void execute(List<Item> itemList) {
        Item oldItem = itemList.get(itemToUpdateIndex);

        // ItemList(x) = empty
        if (newItem == null) {
            itemList.remove(oldItem);
        } else {
            oldItem.replaceFields(newItem);
        }
    }

    public Integer getItemToUpdateIndex() {
        return itemToUpdateIndex;
    }

    public void setItemToUpdateIndex(Integer itemToUpdateIndex) {
        this.itemToUpdateIndex = itemToUpdateIndex;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
}
