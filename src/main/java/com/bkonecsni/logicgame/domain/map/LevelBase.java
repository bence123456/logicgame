package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.validation.ValidationBase;

import java.util.List;

public abstract class LevelBase {

    protected List<TileBase> tileList;

    private ValidationBase validationHandler;

    public abstract void init();

    public boolean isValid() {
        return validationHandler.areWinConditionsApply();
    }

    public int getRowNumber() {
        return validationHandler.getRowNumber();
    }

    public int getColumnNumber() {
        return validationHandler.getColumnNumber();
    }

    public TileBase getTile(int row, int column) {
        return validationHandler.getTile(row, column);
    }

    public List<TileBase> getTileList() {
        return tileList;
    }

    public void setValidationHandler(ValidationBase validationHandler) {
        validationHandler.setTileList(tileList);
        this.validationHandler = validationHandler;
    }
}
