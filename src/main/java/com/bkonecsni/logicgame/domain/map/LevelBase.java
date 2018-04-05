package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class LevelBase {

    protected List<TileBase> tileList;

    public abstract void init();

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

    public List<TileBase> getTileList() {
        return tileList;
    }

    public void setTileList(List<TileBase> tileList) {
        this.tileList = tileList;
    }
}
