package com.bkonecsni.logicgame.validation.scrapers;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapersValidationHelper {

    public boolean isSkylineCorrectForEveryRowAndColumn(GameMap map, List<Item> methodParams) {
        Map<Tile, List<Tile>> skylineTilesMap = createSkylineTilesMap(map);

        for (Tile skylineTile : skylineTilesMap.keySet()) {
            int skylineNumber = skylineTile.getItemList().get(1).getIntValue();
            int numberOfVisibleSkyscrapers = getNumberOfVisibleSkyscrapers(skylineTilesMap.get(skylineTile));

            if (skylineNumber != numberOfVisibleSkyscrapers) {
                return false;
            }
        }

        return true;
    }

    private int getNumberOfVisibleSkyscrapers(List<Tile> tilesForSkyline) {
        int numberOfVisibleSkyscrapers = 1;
        Tile actualTile = tilesForSkyline.get(0);

        for (int i=1; i<tilesForSkyline.size(); i++) {
            Tile nextTile = tilesForSkyline.get(i);

            if (actualTile.getItemList().get(1).getIntValue() <  nextTile.getItemList().get(1).getIntValue()) {
                numberOfVisibleSkyscrapers++;
                actualTile = nextTile;
            }
        }

        return numberOfVisibleSkyscrapers;
    }

    private Map<Tile, List<Tile>> createSkylineTilesMap(GameMap map) {
        int nrOfPlayableColums = map.getPlayableColumnNumber();
        int nrOfPlayableRows = map.getPlayableRowNumber();
        int firstPlayableColumnIndex = map.getFirstPlayableColumnIndex();
        int firstPlayableRowIndex = map.getFirstPlayableRowIndex();

        Map<Tile, List<Tile>> skylineTilesMap = new HashMap<>();

        addTopSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addBottomSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addLeftSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);
        addRightSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineTilesMap);

        return skylineTilesMap;
    }

    private void addTopSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                       int firstPlayableRowIndex, Map<Tile, List<Tile>> skylineTilesMap) {

        for (int i=firstPlayableColumnIndex; i<nrOfPlayableColums; i++) {
            Tile topSkyline = map.getTile(0, i);
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableRowIndex; j<nrOfPlayableRows; j++) {
                Tile tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(topSkyline, tilesForSkyline);
        }
    }

    private void addBottomSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                          int firstPlayableRowIndex, Map<Tile, List<Tile>> skylineTilesMap) {

        for (int i=firstPlayableColumnIndex; i<nrOfPlayableColums; i++) {
            Tile bottomSkyline = map.getTile(nrOfPlayableRows, i);
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableRows-1; j>=firstPlayableRowIndex; j--) {
                Tile tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(bottomSkyline, tilesForSkyline);
        }
    }

    private void addLeftSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                        int firstPlayableRowIndex, Map<Tile, List<Tile>> skylineTilesMap) {

        for (int i=firstPlayableRowIndex; i<nrOfPlayableRows; i++) {
            Tile leftSkyline = map.getTile(i, 0);
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableColumnIndex; j<nrOfPlayableColums; j++) {
                Tile tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(leftSkyline, tilesForSkyline);
        }
    }

    private void addRightSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                         int firstPlayableRowIndex, Map<Tile, List<Tile>> skylineTilesMap) {

        for (int i=firstPlayableRowIndex; i<nrOfPlayableRows; i++) {
            Tile rightSkyline = map.getTile(i, nrOfPlayableColums);
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableColums-1; j>=firstPlayableColumnIndex; j--) {
                Tile tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            skylineTilesMap.put(rightSkyline, tilesForSkyline);
        }
    }
}
