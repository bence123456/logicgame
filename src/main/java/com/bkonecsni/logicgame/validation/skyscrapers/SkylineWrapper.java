package com.bkonecsni.logicgame.validation.skyscrapers;

import com.bkonecsni.logicgame.domain.map.Tile;

import java.util.List;

public class SkylineWrapper {

    private Integer skylineNumber;

    private List<Tile> tilesForSkyline;

    public SkylineWrapper(Integer skylineNumber, List<Tile> tilesForSkyline) {
        this.skylineNumber = skylineNumber;
        this.tilesForSkyline = tilesForSkyline;
    }

    public Integer getSkylineNumber() {
        return skylineNumber;
    }

    public void setSkylineNumber(Integer skylineNumber) {
        this.skylineNumber = skylineNumber;
    }

    public List<Tile> getTilesForSkyline() {
        return tilesForSkyline;
    }

    public void setTilesForSkyline(List<Tile> tilesForSkyline) {
        this.tilesForSkyline = tilesForSkyline;
    }
}
