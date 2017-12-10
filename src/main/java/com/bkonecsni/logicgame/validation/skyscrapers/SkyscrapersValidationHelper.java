package com.bkonecsni.logicgame.validation.skyscrapers;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import java.util.ArrayList;
import java.util.List;

public class SkyscrapersValidationHelper {

    public boolean isSkylineCorrectForEveryRowAndColumn(GameMap map, List<Item> methodParams) {
        List<SkylineWrapper> skylineWrappers = createSkylineWrappers(map);

        for (SkylineWrapper skylineWrapper : skylineWrappers) {
            int skylineNumber = skylineWrapper.getSkylineNumber();
            int numberOfVisibleSkyscrapers = getNumberOfVisibleSkyscrapers(skylineWrapper);

            if (skylineNumber != numberOfVisibleSkyscrapers) {
                return false;
            }
        }

        return true;
    }

    private int getNumberOfVisibleSkyscrapers(SkylineWrapper skylineWrapper) {
        int numberOfVisibleSkyscrapers = 1;
        List<Tile> tilesForSkyline = skylineWrapper.getTilesForSkyline();
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

    private List<SkylineWrapper> createSkylineWrappers(GameMap map) {
        int nrOfPlayableColums = map.getPlayableColumnNumber();
        int nrOfPlayableRows = map.getPlayableRowNumber();
        int firstPlayableColumnIndex = map.getFirstPlayableColumnIndex();
        int firstPlayableRowIndex = map.getFirstPlayableRowIndex();

        List<SkylineWrapper> skylineWrappers = new ArrayList<>();

        addTopSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineWrappers);
        addBottomSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineWrappers);
        addLeftSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineWrappers);
        addRightSkylineWrappers(map, nrOfPlayableColums, nrOfPlayableRows, firstPlayableColumnIndex, firstPlayableRowIndex, skylineWrappers);

        return skylineWrappers;
    }

    private void addTopSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                       int firstPlayableRowIndex, List<SkylineWrapper> skylineWrappers) {

        for (int i=firstPlayableColumnIndex; i<=nrOfPlayableColums; i++) {
            int topSkyline = map.getTile(0, i).getItemList().get(1).getIntValue();
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableRowIndex; j<=nrOfPlayableRows; j++) {
                Tile tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            SkylineWrapper skylineWrapper = new SkylineWrapper(topSkyline, tilesForSkyline);
            skylineWrappers.add(skylineWrapper);
        }
    }

    private void addBottomSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                          int firstPlayableRowIndex, List<SkylineWrapper> skylineWrappers) {

        for (int i=firstPlayableColumnIndex; i<=nrOfPlayableColums; i++) {
            int bottomSkyline = map.getTile(nrOfPlayableRows+1, i).getItemList().get(1).getIntValue();
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableRows; j>=firstPlayableRowIndex; j--) {
                Tile tile = map.getTile(j, i);
                tilesForSkyline.add(tile);
            }

            SkylineWrapper skylineWrapper = new SkylineWrapper(bottomSkyline, tilesForSkyline);
            skylineWrappers.add(skylineWrapper);
        }
    }

    private void addLeftSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                        int firstPlayableRowIndex, List<SkylineWrapper> skylineWrappers) {

        for (int i=firstPlayableRowIndex; i<=nrOfPlayableRows; i++) {
            int leftSkyline = map.getTile(i, 0).getItemList().get(1).getIntValue();
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=firstPlayableColumnIndex; j<=nrOfPlayableColums; j++) {
                Tile tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            SkylineWrapper skylineWrapper = new SkylineWrapper(leftSkyline, tilesForSkyline);
            skylineWrappers.add(skylineWrapper);
        }
    }

    private void addRightSkylineWrappers(GameMap map, int nrOfPlayableColums, int nrOfPlayableRows, int firstPlayableColumnIndex,
                                         int firstPlayableRowIndex, List<SkylineWrapper> skylineWrappers) {

        for (int i=firstPlayableRowIndex; i<=nrOfPlayableRows; i++) {
            int rightSkyline = map.getTile(i, nrOfPlayableColums+1).getItemList().get(1).getIntValue();
            List<Tile> tilesForSkyline = new ArrayList<>();

            for (int j=nrOfPlayableColums; j>=firstPlayableColumnIndex; j--) {
                Tile tile = map.getTile(i, j);
                tilesForSkyline.add(tile);
            }

            SkylineWrapper skylineWrapper = new SkylineWrapper(rightSkyline, tilesForSkyline);
            skylineWrappers.add(skylineWrapper);
        }
    }
}
