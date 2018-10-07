package com.bkonecsni.logicgame.listeners;

import com.bkonecsni.logicgame.domain.map.CommonComplexTile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import javafx.collections.ListChangeListener;

public class ItemListChangeListener implements ListChangeListener {

    private ValidationBase validationBase;

    private TileBase tile;

    public ItemListChangeListener(ValidationBase validationBase, TileBase tile) {
        this.validationBase = validationBase;
        this.tile = tile;
    }

    @Override
    public void onChanged(Change c) {
        LevelBase modifiedMap = createNewMap(c);
        overrideMapProperty(modifiedMap);
    }

    private LevelBase createNewMap(Change c) {
        LevelBase map = validationBase.getMap();
        map.setItemListForTile(tile.getPosition(), c.getList());

        return map;
    }

    private void overrideMapProperty(LevelBase map) {
        validationBase.setMap(map);

        if (tile instanceof CommonComplexTile) {
            ((CommonComplexTile) tile).setMap(map);
        }
    }
}
