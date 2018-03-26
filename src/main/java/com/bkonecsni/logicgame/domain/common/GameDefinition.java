package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;

import javax.swing.*;
import java.util.*;

public class GameDefinition {

    private Map<String, ImageIcon> symbolsMap = new HashMap<>();

    private Set<String> definedTypes = new HashSet<>();

    private Map<String, LevelBase> maps = new HashMap<>();

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

    public Set<String> getDefinedTypes() {
        return definedTypes;
    }

    public void setDefinedTypes(Set<String> definedTypes) {
        this.definedTypes = definedTypes;
    }

    public Map<String, LevelBase> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, LevelBase> maps) {
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
