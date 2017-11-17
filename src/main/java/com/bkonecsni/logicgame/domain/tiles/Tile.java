package com.bkonecsni.logicgame.domain.tiles;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class Tile {

    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
