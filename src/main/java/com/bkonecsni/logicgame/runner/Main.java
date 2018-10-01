package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.gui.LogicGameGui;

import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        LogicGame logicGame = new LogicGame();
        List<GameDefinition> gameDefinitions = logicGame.parse();

        EventQueue.invokeLater(() -> {
            LogicGameGui logicGameGui = new LogicGameGui(gameDefinitions.get(0));
            logicGameGui.setVisible(true);
        });
    }
}
