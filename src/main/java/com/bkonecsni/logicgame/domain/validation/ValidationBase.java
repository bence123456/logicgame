package com.bkonecsni.logicgame.domain.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ValidationBase {

    private List<TileBase> tileList;

    public abstract boolean areWinConditionsApply();

    public int getRowNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getColumnNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        return tmpTiles.get(0).getPosition().y + 1;
    }

    public int getPlayableRowNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getPlayableColumnNumber() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().y + 1;
    }

    public int getFirstPlayableColumnIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().y;
    }

    public int getFirstPlayableRowIndex() {
        List<TileBase> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        TileBase lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().x;
    }

    public TileBase getTile(int row, int column) {
        for (TileBase tile : tileList) {
            if (getRowNumber(tile) == row && getColumnNumber(tile) == column) {
                return tile;
            }
        }

        return null;
    }

    public List<TileBase> getTilesFromRow(int rowNumber) {
        List<TileBase> tilesInRow = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (getRowNumber(tile) == rowNumber && !tile.isUnmutableType()) {
                tilesInRow.add(tile);
            }
        }

        return tilesInRow;
    }

    public List<TileBase> getTilesFromColumn(int columnNumber) {
        List<TileBase> tilesInColumn = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (getColumnNumber(tile) == columnNumber && !tile.isUnmutableType()) {
                tilesInColumn.add(tile);
            }
        }

        return tilesInColumn;
    }

    public List<Color> getColorList() {
        List<Color> colors = new ArrayList<>();

        for (TileBase tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (!colors.contains(tileColor) && !tile.isUnmutableType()) {
                colors.add(tileColor);
            }
        }

        return colors;
    }

    public List<TileBase> getTilesForColor(Color color) {
        List<TileBase> tiles = new ArrayList<>();

        for (TileBase tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (tileColor.equals(color) && !tile.isUnmutableType()) {
                tiles.add(tile);
            }
        }

        return tiles;
    }

    public List<TileBase> getNeighboursForTile(TileBase tile) {
        List<TileBase> tiles = new ArrayList<>();

        addNeighboursToListIfExists(tile, tiles);

        return tiles;
    }

    public List<TileBase> getTilesWithGivenItem(Item item) {
        List<TileBase> tilesWithGivenItem = new ArrayList<>();

        for (TileBase tile : tileList) {
            if (tile.getItemList().contains(item) && !tile.isUnmutableType()) {
                tilesWithGivenItem.add(tile);
            }
        }

        return tilesWithGivenItem;
    }

    public boolean numberOfItemsInAllRow(Item item, int expectedNumber) {
            int numberOfRows = getRowNumber();
            int numberOfPlayableRows = getPlayableRowNumber();
            int firstPlayableRowIndex = getFirstPlayableColumnIndex();
            int lastIndex = numberOfRows == numberOfPlayableRows ? numberOfRows : numberOfPlayableRows;

            for (int j=firstPlayableRowIndex; j<lastIndex; j++) {
                if (!isAreaValid(getTilesFromRow(j), item, expectedNumber)) {
                    return false;
                }
            }

        return true;
    }

    public boolean numberOfItemsInAllColumn(Item item, int expectedNumber) {
            int numberOfColumns = getColumnNumber();
            int numberOfPlayableColumns = getPlayableColumnNumber();
            int firstPlayableColumnIndex = getFirstPlayableColumnIndex();
            int lastIndex = numberOfColumns == numberOfPlayableColumns ? numberOfColumns : numberOfPlayableColumns;

            for (int j=firstPlayableColumnIndex; j<lastIndex; j++) {
                if (!isAreaValid(getTilesFromColumn(j), item, expectedNumber)) {
                    return false;
                }
            }

        return true;
    }

    public boolean numberOfItemsInAllAreaWithSameColor(Item item, int expectedNumber) {
        Map<Color, List<TileBase>> colorAreaTilesMap = createColorAreaTilesMap();

        for (Color color : colorAreaTilesMap.keySet()) {
            if (!isAreaValid(colorAreaTilesMap.get(color), item, expectedNumber)) {
                return false;
            }
        }

        return true;
    }

    public boolean twoNeighbouringSymbolsExists(Item symbolItem) {
        List<TileBase> tilesWithGivenItem = getTilesWithGivenItem(symbolItem);

        for (TileBase tile : tilesWithGivenItem) {
            List<TileBase> neighbourTiles =  getNeighboursForTile(tile);
            for (TileBase neighbourTile : neighbourTiles) {
                if (neighbourTile.getItemList().contains(symbolItem)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean neighboursHaveCorrectNumberOfItems(Item item) {
        for (TileBase tile : tileList) {
            if (tile.isUnmutableType()) {
                int expectedNrOfItems = tile.getItemList().get(1).getIntValue();
                int actualNrOfItems = 0;

                for (TileBase unMutableTileNeighbour : getNeighboursForTile(tile)) {
                    if (unMutableTileNeighbour.getItemList().contains(item)) {
                        actualNrOfItems++;
                    }
                }

                if (expectedNrOfItems != actualNrOfItems) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isAreaValid(List<TileBase> tiles, Item item, int expectedNumber) {
        int numberOfItems = 0;

        for (TileBase tile : tiles) {
            if (tile.getItemList().contains(item)) {
                numberOfItems++;
            }
        }

        return numberOfItems == expectedNumber;
    }

    private Map<Color, List<TileBase>> createColorAreaTilesMap() {
        Map<Color, List<TileBase>> colorAreaTilesMap = new HashMap<>();
        List<Color> colorList = getColorList();

        for (Color color : colorList) {
            List<TileBase> tilesForcolor = getTilesForColor(color);
            colorAreaTilesMap.put(color, tilesForcolor);
        }

        return colorAreaTilesMap;
    }

    private void removeTilesWithBorderType(List<TileBase> tmpTiles) {
        tmpTiles.removeIf(actualTile -> actualTile.isUnmutableType());
    }

    private void addNeighboursToListIfExists(TileBase tile, List<TileBase> tiles) {
        int rowNr = getRowNumber(tile);
        int columnNr = getColumnNumber(tile);

        addNeighbourToListIfExists(rowNr, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr, columnNr+1, tiles);

        addNeighbourToListIfExists(rowNr-1, columnNr, tiles);
        addNeighbourToListIfExists(rowNr+1, columnNr, tiles);

        addNeighbourToListIfExists(rowNr-1, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr-1, columnNr+1, tiles);

        addNeighbourToListIfExists(rowNr+1, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr+1, columnNr+1, tiles);
    }

    private void addNeighbourToListIfExists(int row, int column, List<TileBase> tiles) {
        TileBase tile = getTile(row, column);

        if (tile != null && !tile.isUnmutableType()) {
            tiles.add(tile);
        }
    }

    private List<TileBase> getSortedTilesBasedOnRow() {
        List<TileBase> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(TileBase.getRowNrComparator());

        return tmpTiles;
    }

    private List<TileBase> getSortedTilesBasedOnColumn() {
        List<TileBase> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(TileBase.getColumnNrComparator());

        return tmpTiles;
    }

    private int getRowNumber(TileBase tile) {
        return tile.getPosition().x;
    }

    private int getColumnNumber(TileBase tile) {
        return tile.getPosition().y;
    }

    public void setTileList(List<TileBase> tileList) {
        this.tileList = tileList;
    }
}
