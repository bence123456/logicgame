package com.bkonecsni.logicgame.domain.tiles;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.types.Type;

import java.util.List;

public class Tile<T extends Type> {

    private T type;

    private Point position;

    private Point size;

    private List<Item> itemList;

    public Tile(T type, Point position, Point size, List<Item> itemList) {
        this.type = type;
        this.position = position;
        this.size = size;
        this.itemList = itemList;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
