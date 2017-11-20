package com.bkonecsni.logicgame.domain.types;

import com.bkonecsni.logicgame.domain.common.Item;

public class Update {

    private Integer itemToUpdateIndex;

    private Item newItem;

    public Update(Integer itemToUpdateIndex, Item newItem) {
        this.itemToUpdateIndex = itemToUpdateIndex;
        this.newItem = newItem;
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
