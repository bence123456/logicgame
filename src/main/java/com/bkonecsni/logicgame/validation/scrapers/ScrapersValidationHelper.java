package com.bkonecsni.logicgame.validation.scrapers;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.map.LevelBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapersValidationHelper {

    public boolean isSkylineCorrectForEveryRowAndColumn(LevelBase map, List<Item> methodParams) {
        return isSkylineCorrectForEveryRowAndColumn(map, true);
    }

    public boolean isSumSkylineCorrectForEveryRowAndColumn(LevelBase map, List<Item> methodParams) {
        return isSkylineCorrectForEveryRowAndColumn(map, false);
    }

    public boolean isSkylineCorrectForEveryRowAndColumn(LevelBase map, boolean shouldIncrementWithOne) {
        Map<TileBase, List<TileBase>> skylineTilesMap = createSkylineTilesMap(map);

        for (TileBase skylineTile : skylineTilesMap.keySet()) {
            int skylineNumber = skylineTile.getItemList().get(1).getIntValue();
            int visibleSkyscrapersNumber = getVisibleSkyscrapersNumber(skylineTilesMap.get(skylineTile), shouldIncrementWithOne);

            if (skylineNumber != visibleSkyscrapersNumber) {
                return false;
            }
        }

        return true;
    }

    private int getVisibleSkyscrapersNumber(List<TileBase> tilesForSkyline, boolean shouldIncrementWithOne) {
        TileBase actualTile = tilesForSkyline.get(0);
        int visibleSkyscrapersNumber = shouldIncrementWithOne ? 1 : actualTile.getItemList().get(1).getIntValue();

        for (int i=1; i<tilesForSkyline.size(); i++) {
            TileBase nextTile = tilesForSkyline.get(i);
            Integer nextTileIntValue = nextTile.getItemList().get(1).getIntValue();

            if (actualTile.getItemList().get(1).getIntValue() < nextTileIntValue) {
                int increment = shouldIncrementWithOne ? 1 : nextTileIntValue;
                visibleSkyscrapersNumber += increment;
                actualTile = nextTile;
            }
        }

        return visibleSkyscrapersNumber;
    }

    private Map<TileBase, List<TileBase>> createSkylineTilesMap(LevelBase map) {
        int nrOfPlayableColums = map.getPlayableColumnNumber();
        int nrOfPlayableRows = map.getPlayableRowNumber();
        int firstPlayableColumnIndex = map.getFirstPlayableColumnIndex();
        int firstPlayableRowIndex = map.getFirstPlayableRowIndex();

        Map<TileBase, List<TileBase>> skylineTilesMap = new HashMap<>();

        addTopSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addBottomSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addLeftSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addRightSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);

        return skylineTilesMap;
    }

    private void addTopSkylineWrappers(LevelBase map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                       int firstPlayableRowIndex, Map<TileBase, List<TileBase>> skylineTilesMap) {

        for (int i=firstPlayableColumnIndex; i<nrOfPlayableColums; i++) {
            TileBase topSkyline = map.getTile(0, i);
            List<TileBase> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableRowIndex; j<nrOfPlayableRows; j++) {
                TileBase tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(topSkyline, tilesForSkyline);
        }
    }

    private void addBottomSkylineWrappers(LevelBase map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                          int firstPlayableRowIndex, Map<TileBase, List<TileBase>> skylineTilesMap) {

        for (int i=firstPlayableColumnIndex; i<nrOfPlayableColums; i++) {
            TileBase bottomSkyline = map.getTile(nrOfPlayableRows, i);
            List<TileBase> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableRows-1; j>=firstPlayableRowIndex; j--) {
                TileBase tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(bottomSkyline, tilesForSkyline);
        }
    }

    private void addLeftSkylineWrappers(LevelBase map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                        int firstPlayableRowIndex, Map<TileBase, List<TileBase>> skylineTilesMap) {

        for (int i=firstPlayableRowIndex; i<nrOfPlayableRows; i++) {
            TileBase leftSkyline = map.getTile(i, 0);
            List<TileBase> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableColumnIndex; j<nrOfPlayableColums; j++) {
                TileBase tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(leftSkyline, tilesForSkyline);
        }
    }

    private void addRightSkylineWrappers(LevelBase map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                         int firstPlayableRowIndex, Map<TileBase, List<TileBase>> skylineTilesMap) {

        for (int i=firstPlayableRowIndex; i<nrOfPlayableRows; i++) {
            TileBase rightSkyline = map.getTile(i, nrOfPlayableColums);
            List<TileBase> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableColums-1; j>=firstPlayableColumnIndex; j--) {
                TileBase tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(rightSkyline, tilesForSkyline);
        }
    }
}
