package com.bkonecsni.logicgame.domain.common;

import com.bkonecsni.logicgame.domain.map.LevelBase;

import javax.swing.*;
import java.util.*;

public class GameDefinition {

    private String gameName;

    private Map<String, ImageIcon> symbolsMap = new HashMap<>();

    private Set<String> definedTypes = new HashSet<>();

    private Map<String, LevelBase> maps = new HashMap<>();

    private Map<Integer, ImageIcon> numberIconMap = new HashMap<>();

    public GameDefinition(String gameName) {
        this.gameName = gameName;
    }

    public ImageIcon getIcon(Item item) {
        Integer intValue = item.getIntValue();

        if (intValue != null) {
            return this.getNumberIconMap().get(intValue);
        } else {
            return this.getSymbolsMap().get(item.getSymbol());
        }
    }

    public String getGameName() {
        return gameName;
    }

    public Map<String, ImageIcon> getSymbolsMap() {
        return symbolsMap;
    }

    public Set<String> getDefinedTypes() {
        return definedTypes;
    }

    public Map<String, LevelBase> getMaps() {
        return maps;
    }

    public Map<Integer, ImageIcon> getNumberIconMap() {
        return numberIconMap;
    }

}
