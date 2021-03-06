package com.bkonecsni.logicgame.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.validation.scrapers.ScrapersValidationHelper;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationMethods {

    private ScrapersValidationHelper scrapersValidationHelper = new ScrapersValidationHelper();

    public boolean numberOfItemsInAllRow(GameMap map, List<Item> methodParams) {
        int paramsSize = methodParams.size();
        int expectedNumber = methodParams.get(paramsSize-1).getIntValue();

        for (int i=0; i<paramsSize-1; i++) {
            Item item = methodParams.get(i);
            int numberOfRows = map.getRowNumber();
            int numberOfPlayableRows = map.getPlayableRowNumber();
            int firstPlayableRowIndex = map.getFirstPlayableColumnIndex();
            int lastIndex = numberOfRows == numberOfPlayableRows ? numberOfRows : numberOfPlayableRows;

            for (int j=firstPlayableRowIndex; j<lastIndex; j++) {
                if (!isAreaValid(map.getTilesFromRow(j), item, expectedNumber)) {
                    return false;
                }
            }
        }

        return true;
}

    public boolean numberOfItemsInAllColumn(GameMap map, List<Item> methodParams) {
        int paramsSize = methodParams.size();
        int expectedNumber = methodParams.get(paramsSize-1).getIntValue();

        for (int i=0; i<paramsSize-1; i++) {
            Item item = methodParams.get(i);
            int numberOfColumns = map.getColumnNumber();
            int numberOfPlayableColumns = map.getPlayableColumnNumber();
            int firstPlayableColumnIndex = map.getFirstPlayableColumnIndex();
            int lastIndex = numberOfColumns == numberOfPlayableColumns ? numberOfColumns : numberOfPlayableColumns;

            for (int j=firstPlayableColumnIndex; j<lastIndex; j++) {
                if (!isAreaValid(map.getTilesFromColumn(j), item, expectedNumber)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean numberOfItemsInAllAreaWithSameColor(GameMap map, List<Item> methodParams) {
        Item item = methodParams.get(0);
        int expectedNumber = methodParams.get(1).getIntValue();
        Map<Color, List<Tile>> colorAreaTilesMap = createColorAreaTilesMap(map);

        for (Color color : colorAreaTilesMap.keySet()) {
            if (!isAreaValid(colorAreaTilesMap.get(color), item, expectedNumber)) {
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
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isSkylineCorrectForEveryRowAndColumn(GameMap map, List<Item> methodParams) {
        return scrapersValidationHelper.isSkylineCorrectForEveryRowAndColumn(map, methodParams);
    }

    public boolean isSumSkylineCorrectForEveryRowAndColumn(GameMap map, List<Item> methodParams) {
        return scrapersValidationHelper.isSumSkylineCorrectForEveryRowAndColumn(map, methodParams);
    }

    public boolean neighboursHaveCorrectNumberOfItems(GameMap map, List<Item> methodParams) {
        Item item = methodParams.get(0);

        for (Tile tile : map.getTileList()) {
            if (tile.getType().isUnmutableType()) {
                int expectedNrOfItems = tile.getItemList().get(1).getIntValue();
                int actualNrOfItems = 0;

                for (Tile unMutableTileNeighbour : map.getNeighboursForTile(tile)) {
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

    private Map<Tile, List<Tile>> getUnMutableTileNeighbourTilesMap(GameMap map) {
        return null;
    }

    private boolean isAreaValid(List<Tile> tiles, Item item, int expectedNumber) {
        int numberOfItems = 0;

        for (Tile tile : tiles) {
            if (tile.getItemList().contains(item)) {
                numberOfItems++;
            }
        }

        return numberOfItems == expectedNumber;
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
