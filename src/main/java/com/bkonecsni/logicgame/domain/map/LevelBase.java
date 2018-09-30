package com.bkonecsni.logicgame.domain.map;

import java.util.List;

public abstract class LevelBase {

    protected List<TileBase> tileList;

    public abstract void init();

    public List<TileBase> getTileList() {
        return tileList;
    }
}
