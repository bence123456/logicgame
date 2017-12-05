package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;

import java.awt.*;
import java.util.ArrayList;
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
            if (getRowNumber(tile) == row && getColumnNumber(tile) == column) {
                return tile;
            }
        }

        return null;
    }

    public List<Tile> getTilesFromRow(int rowNumber) {
        List<Tile> tilesInRow = new ArrayList<>();

        for (Tile tile : tileList) {
            if (getRowNumber(tile) == rowNumber) {
                tilesInRow.add(tile);
            }
        }

        return tilesInRow;
    }

    public List<Tile> getTilesFromColumn(int columnNumber) {
        List<Tile> tilesInColumn = new ArrayList<>();

        for (Tile tile : tileList) {
            if (getColumnNumber(tile) == columnNumber) {
                tilesInColumn.add(tile);
            }
        }

        return tilesInColumn;
    }

    public List<Color> getColorList() {
        List<Color> colors = new ArrayList<>();

        for (Tile tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (!colors.contains(tileColor)) {
                colors.add(tileColor);
            }
        }

        return colors;
    }

    public List<Tile> getTilesForColor(Color color) {
        List<Tile> tiles = new ArrayList<>();

        for (Tile tile : tileList) {
            Color tileColor = tile.getItemList().get(0).getColor();
            if (tileColor.equals(color)) {
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
            if (tile.getItemList().contains(item)) {
                tilesWithGivenItem.add(tile);
            }
        }

        return tilesWithGivenItem;
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

        if (tile != null) {
            tiles.add(tile);
        }
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
