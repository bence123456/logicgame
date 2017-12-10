package com.bkonecsni.logicgame.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.validation.skyscrapers.SkyscrapersValidationHelper;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationMethods {

    private SkyscrapersValidationHelper skyscrapersValidationHelper = new SkyscrapersValidationHelper();

    public boolean numberOfItemsInAllRow(GameMap map, List<Item> methodParams) {
        int paramsSize = methodParams.size();
        int expectedNumber = methodParams.get(paramsSize-1).getIntValue();

        for (int i=0; i<paramsSize-1; i++) {
            Item item = methodParams.get(i);
            int numberOfPlayableRows = map.getPlayableRowNumber();
            int firstPlayableRowIndex = map.getFirstPlayableColumnIndex();

            for (int j=firstPlayableRowIndex; j<=numberOfPlayableRows; j++) {
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
            int numberOfColumns = map.getPlayableColumnNumber();
            int firstPlayableColumnIndex = map.getFirstPlayableColumnIndex();

            for (int j=firstPlayableColumnIndex; j<=numberOfColumns; j++) {
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
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSkylineCorrectForEveryRowAndColumn(GameMap map, List<Item> methodParams) {
        return skyscrapersValidationHelper.isSkylineCorrectForEveryRowAndColumn(map, methodParams);
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
