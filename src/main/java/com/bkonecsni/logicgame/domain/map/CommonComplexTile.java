package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.types.equation.Condition;

import java.awt.*;
import java.util.List;

public abstract class CommonComplexTile extends TileBase {

    private LevelBase map;

    private List<Condition> conditionList;

    public CommonComplexTile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
    }

    @Override
    public boolean isUnmutableType() {
        return false;
    }

    public LevelBase getMap() {
        return map;
    }

    public void setMap(LevelBase map) {
        this.map = map;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }
}
