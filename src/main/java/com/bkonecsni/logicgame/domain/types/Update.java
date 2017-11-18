package com.bkonecsni.logicgame.domain.types;

import com.bkonecsni.logicgame.domain.common.Item;

public class Update {

    private Item itemToUpdate;

    private Item newItem;

    public Update(Item itemToUpdate, Item newItem) {
        this.itemToUpdate = itemToUpdate;
        this.newItem = newItem;
    }

    public Item getItemToUpdate() {
        return itemToUpdate;
    }

    public void setItemToUpdate(Item itemToUpdate) {
        this.itemToUpdate = itemToUpdate;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
}
