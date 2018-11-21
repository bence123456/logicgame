package com.bkonecsni.logicgame.runner;

import java.util.*;

public class GameDefinition {

    private String gameName;

    private Map<String, String> symbolsMap = new HashMap<>();

    private Set<String> definedTypes = new HashSet<>();

    public GameDefinition(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Map<String, String> getSymbolsMap() {
        return symbolsMap;
    }

    public Set<String> getDefinedTypes() {
        return definedTypes;
    }
}
