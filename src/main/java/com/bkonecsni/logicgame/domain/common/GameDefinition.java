package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDefinition {

    private Map<String, String> symbolsMap = new HashMap<>();

    private Map<String, Type> typesMap = new HashMap<>();

    private List<Tile> map = new ArrayList<>();

    private List<ValidationStatement> winStatementList = new ArrayList<>();
    private List<ValidationStatement> looseStatementList = new ArrayList<>();

    public GameDefinition() { }

    public Map<String, String> getSymbolsMap() {
        return symbolsMap;
    }

    public void setSymbolsMap(Map<String, String> symbolsMap) {
        this.symbolsMap = symbolsMap;
    }

    public Map<String, Type> getTypesMap() {
        return typesMap;
    }

    public void setTypesMap(Map<String, Type> typesMap) {
        this.typesMap = typesMap;
    }

    public List<Tile> getMap() {
        return map;
    }

    public void setMap(List<Tile> map) {
        this.map = map;
    }

    public List<ValidationStatement> getWinStatementList() {
        return winStatementList;
    }

    public void setWinStatementList(List<ValidationStatement> winStatementList) {
        this.winStatementList = winStatementList;
    }

    public List<ValidationStatement> getLooseStatementList() {
        return looseStatementList;
    }

    public void setLooseStatementList(List<ValidationStatement> looseStatementList) {
        this.looseStatementList = looseStatementList;
    }
}