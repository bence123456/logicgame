package com.bkonecsni.logicgame.domain.map;

import java.awt.*;
import java.util.List;

public class GameMap {

    private List<Tile> tileList;

    public GameMap(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public int getRowNumber() {
        tileList.sort(Tile.getRowNrComparator());
        return tileList.get(0).getPosition().x + 1;
    }

    public int getColumnNumber() {
        tileList.sort(Tile.getColumnNrComparator());
        return tileList.get(0).getPosition().y + 1;
    }

    public Tile getTile(int row, int column) {
        for (Tile tile : tileList) {
            Point tilePosition = tile.getPosition();
            if (tilePosition.x == row && tilePosition.y == column) {
                return tile;
            }
        }

        return null;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }
}
