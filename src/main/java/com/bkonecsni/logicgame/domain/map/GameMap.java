package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameMap {

    private List<Tile> tileList;

    public GameMap(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public int getRowNumber() {
        List<Tile> tmpTiles = getSortedTilesBasedOnRow();
        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getColumnNumber() {
        List<Tile> tmpTiles = getSortedTilesBasedOnColumn();
        return tmpTiles.get(0).getPosition().y + 1;
    }

    public int getPlayableRowNumber() {
        List<Tile> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().x + 1;
    }

    public int getPlayableColumnNumber() {
        List<Tile> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        return tmpTiles.get(0).getPosition().y + 1;
    }


    public int getFirstPlayableColumnIndex() {
        List<Tile> tmpTiles = getSortedTilesBasedOnColumn();
        removeTilesWithBorderType(tmpTiles);

        Tile lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().y;
    }

    public int getFirstPlayableRowIndex() {
        List<Tile> tmpTiles = getSortedTilesBasedOnRow();
        removeTilesWithBorderType(tmpTiles);

        Tile lastTile = tmpTiles.get(tmpTiles.size()-1);

        return lastTile.getPosition().x;
    }

    public Tile getTile(int row, int column) {
        for (Tile tile : tileList) {
            if (getRowNumber(tile) == row && getColumnNumber(tile) == column) {
                return tile;
            }
        }

        return null;
    }

    public List<Tile> getTilesFromRow(int rowNumber) {
        List<Tile> tilesInRow = new ArrayList<>();

        for (Tile tile : tileList) {
            if (getRowNumber(tile) == rowNumber && !isBorderTile(tile)) {
                tilesInRow.add(tile);
            }
        }

        return tilesInRow;
    }

    public List<Tile> getTilesFromColumn(int columnNumber) {
        List<Tile> tilesInColumn = new ArrayList<>();

        for (Tile tile : tileList) {
            if (getColumnNumber(tile) == columnNumber && !isBorderTile(tile)) {
                tilesInColumn.add(tile);
            }
        }

        return tilesInColumn;
    }

    public List<Color> getColorList() {
        List<Color> colors = new ArrayList<>();

        for (Tile tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (!colors.contains(tileColor) && !isBorderTile(tile)) {
                colors.add(tileColor);
            }
        }

        return colors;
    }

    public List<Tile> getTilesForColor(Color color) {
        List<Tile> tiles = new ArrayList<>();

        for (Tile tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (tileColor.equals(color) && !isBorderTile(tile)) {
                tiles.add(tile);
            }
        }

        return tiles;
    }

    public List<Tile> getNeighboursForTile(Tile tile) {
        List<Tile> tiles = new ArrayList<>();

        addNeighboursToListIfExists(tile, tiles);

        return tiles;
    }

    public List<Tile> getTilesWithGivenItem(Item item) {
        List<Tile> tilesWithGivenItem = new ArrayList<>();

        for (Tile tile : tileList) {
            if (tile.getItemList().contains(item) && !isBorderTile(tile)) {
                tilesWithGivenItem.add(tile);
            }
        }

        return tilesWithGivenItem;
    }

    private void removeTilesWithBorderType(List<Tile> tmpTiles) {
        tmpTiles.removeIf(actualTile -> actualTile.getType().isBorderType());
    }

    private boolean isBorderTile(Tile tile) {
        return tile.getType().isBorderType();
    }

    private void addNeighboursToListIfExists(Tile tile, List<Tile> tiles) {
        int rowNr = getRowNumber(tile);
        int columnNr = getColumnNumber(tile);

        addNeighbourToListIfExists(rowNr, columnNr-1, tiles);
        addNeighbourToListIfExists(rowNr, columnNr+1, tiles);

        addNeighbourToListIfExists(columnNr, rowNr+1, tiles);
        addNeighbourToListIfExists(columnNr, rowNr+1, tiles);

        addNeighbourToListIfExists(columnNr-1, rowNr-1, tiles);
        addNeighbourToListIfExists(columnNr-1, rowNr+1, tiles);

        addNeighbourToListIfExists(columnNr+1, rowNr-1, tiles);
        addNeighbourToListIfExists(columnNr+1, rowNr+1, tiles);
    }

    private void addNeighbourToListIfExists(int row, int column, List<Tile> tiles) {
        Tile tile = getTile(row, column);

        if (tile != null && !isBorderTile(tile)) {
            tiles.add(tile);
        }
    }

    private List<Tile> getSortedTilesBasedOnRow() {
        List<Tile> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(Tile.getRowNrComparator());

        return tmpTiles;
    }

    private List<Tile> getSortedTilesBasedOnColumn() {
        List<Tile> tmpTiles = new ArrayList<>();
        tmpTiles.addAll(tileList);
        tmpTiles.sort(Tile.getColumnNrComparator());

        return tmpTiles;
    }

    private int getRowNumber(Tile tile) {
        return tile.getPosition().x;
    }

    private int getColumnNumber(Tile tile) {
        return tile.getPosition().y;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }
}
