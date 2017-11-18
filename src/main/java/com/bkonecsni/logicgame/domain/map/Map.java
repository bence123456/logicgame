package com.bkonecsni.logicgame.domain.map;

import java.util.List;

public class Map {

    private List<Tile> tileList;

    public Map(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }
}
