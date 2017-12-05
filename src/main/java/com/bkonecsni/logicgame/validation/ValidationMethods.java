package com.bkonecsni.logicgame.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationMethods {

    public boolean numberOfItemsInAllRow(GameMap map, List<Item> methodParams) {
        Item item = methodParams.get(0);
        int expectedNumber = methodParams.get(1).getIntValue();

        int numberOfRows = map.getRowNumber();

        for (int i=0; i<numberOfRows; i++) {
            int numberOfItemsInRow = 0;
            for (Tile tileInRow : map.getTilesFromRow(i)) {
                if (tileInRow.getItemList().contains(item)) {
                    numberOfItemsInRow++;
                }
            }

            if (numberOfItemsInRow != expectedNumber) {
                return false;
            }
        }

        return true;
}

    public boolean numberOfItemsInAllColumn(GameMap map, List<Item> methodParams) {
        Item item = methodParams.get(0);
        int expectedNumber = methodParams.get(1).getIntValue();

        int numberOfColumns = map.getColumnNumber();

        for (int i=0; i<numberOfColumns; i++) {
            int numberOfItemsInColumn = 0;
            for (Tile tileInColumn : map.getTilesFromColumn(i)) {
                if (tileInColumn.getItemList().contains(item)) {
                    numberOfItemsInColumn++;
                }
            }

            if (numberOfItemsInColumn != expectedNumber) {
                return false;
            }
        }

        return true;
    }

    public boolean numberOfItemsInAllAreaWithSameColor(GameMap map, List<Item> methodParams) {
        Item item = methodParams.get(0);
        int expectedNumber = methodParams.get(1).getIntValue();

        Map<Color, List<Tile>> colorAreaTilesMap = createColorAreaTilesMap(map);

        for (Color color : colorAreaTilesMap.keySet()) {
            int numberOfItemsInColorArea = 0;

            for (Tile tile : colorAreaTilesMap.get(color)) {
                if (tile.getItemList().contains(item)) {
                    numberOfItemsInColorArea++;
                }
            }

            if (numberOfItemsInColorArea != expectedNumber) {
                return false;
            }
        }

        return true;
    }

    public boolean twoNeighbouringSymbolsExists(GameMap map, List<Item> methodParams) {
        Item symbolItem = methodParams.get(0);
        List<Tile> tilesWithGivenItem = map.getTilesWithGivenItem(symbolItem);

        for (Tile tile : tilesWithGivenItem) {
            List<Tile> neighbourTiles = map.getNeighboursForTile(tile);
            for (Tile neighbourTile : neighbourTiles) {
                if (neighbourTile.getItemList().contains(symbolItem)) {
                    return false;
                }
            }
        }

        return true;
    }

    private Map<Color, List<Tile>> createColorAreaTilesMap(GameMap map) {
        Map<Color, List<Tile>> colorAreaTilesMap = new HashMap<>();
        List<Color> colorList = map.getColorList();

        for (Color color : colorList) {
            List<Tile> tilesForcolor = map.getTilesForColor(color);
            colorAreaTilesMap.put(color, tilesForcolor);
        }

        return colorAreaTilesMap;
    }


}
