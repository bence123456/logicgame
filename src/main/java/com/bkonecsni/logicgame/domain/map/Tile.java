package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.Type;

import java.awt.Point;
import java.util.Comparator;
import java.util.List;

public class Tile {

    private Type type;

    private Point position;

    private Point size;

    private List<Item> itemList;

    public Tile(Point position, Point size, List<Item> itemList) {
        this.position = position;
        this.size = size;
        this.itemList = itemList;
    }

    public static Comparator<Tile> getColumnNrComparator() {
        return (tile1, tile2) -> {
            int tile1Column = tile1.getPosition().y;
            int tile2Column = tile2.getPosition().y;

            return tile2Column - tile1Column;
        };
    }

    public static Comparator<Tile> getRowNrComparator() {
        return (tile1, tile2) -> {
            int tile1Row = tile1.getPosition().x;
            int tile2Row = tile2.getPosition().x;

            return tile2Row - tile1Row;
        };
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
