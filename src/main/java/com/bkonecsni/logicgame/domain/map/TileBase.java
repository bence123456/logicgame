package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.TypeStatement;

import java.awt.Point;
import java.util.Comparator;
import java.util.List;

public abstract class TileBase {

    protected Point position;

    protected Point size;

    protected List<Item> itemList;

    protected List<TypeStatement> typeStatementList;

    public TileBase(Point position, Point size, List<Item> itemList) {
        this.position = position;
        this.size = size;
        this.itemList = itemList;
        init();
    }

    public abstract void init();

    public abstract boolean isUnmutableType();

    public static Comparator<TileBase> getColumnNrComparator() {
        return (tile1, tile2) -> {
            int tile1Column = tile1.getPosition().y;
            int tile2Column = tile2.getPosition().y;

            return tile2Column - tile1Column;
        };
    }

    public static Comparator<TileBase> getRowNrComparator() {
        return (tile1, tile2) -> {
            int tile1Row = tile1.getPosition().x;
            int tile2Row = tile2.getPosition().x;

            return tile2Row - tile1Row;
        };
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

    public List<TypeStatement> getTypeStatementList() {
        return typeStatementList;
    }
}