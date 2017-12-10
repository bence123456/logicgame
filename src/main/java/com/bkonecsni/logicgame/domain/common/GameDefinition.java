package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDefinition {

    private Map<String, ImageIcon> symbolsMap = new HashMap<>();

    private Map<String, Type> typesMap = new HashMap<>();

    private Map<String, GameMap> maps = new HashMap<>();

    private List<ValidationStatement> winStatementList = new ArrayList<>();
    private List<ValidationStatement> looseStatementList = new ArrayList<>();

    private Map<Integer, ImageIcon> numberIconMap = new HashMap<>();

    public GameDefinition() { }

    public ImageIcon getIcon(Item item) {
        Integer intValue = item.getIntValue();

        if (intValue != null) {
            return this.getNumberIconMap().get(intValue);
        } else {
            return this.getSymbolsMap().get(item.getSymbol());
        }
    }

    public Map<String, ImageIcon> getSymbolsMap() {
        return symbolsMap;
    }

    public void setSymbolsMap(Map<String, ImageIcon> symbolsMap) {
        this.symbolsMap = symbolsMap;
    }

    public Map<String, Type> getTypesMap() {
        return typesMap;
    }

    public void setTypesMap(Map<String, Type> typesMap) {
        this.typesMap = typesMap;
    }

    public Map<String, GameMap> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, GameMap> maps) {
        this.maps = maps;
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

    public Map<Integer, ImageIcon> getNumberIconMap() {
        return numberIconMap;
    }

    public void setNumberIconMap(Map<Integer, ImageIcon> numberIconMap) {
        this.numberIconMap = numberIconMap;
    }
}
