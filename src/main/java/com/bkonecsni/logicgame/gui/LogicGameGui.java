package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LogicGameGui extends JFrame {

    private JPanel panel;

    private ButtonClickAction buttonClickAction;

    private Map<JButton, Tile> buttonTileMap;

    public LogicGameGui(GameDefinition gameDefinition) {
        GameMap map = gameDefinition.getMaps().get("level1");
        int rows = map.getRowNumber();
        int columns = map.getColumnNumber();

        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));
        buttonTileMap = new HashMap<>();

        add(panel, BorderLayout.CENTER);

        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                JButton button = new JButton();
                Tile tile = map.getTile(i,j);
                Color color = tile.getItemList().get(0).getColor();
                button.setBackground(color);

                buttonTileMap.put(button, tile);
                panel.add(button);
            }
        }

        buttonClickAction = new ButtonClickAction(buttonTileMap, gameDefinition);
        for (JButton button : buttonTileMap.keySet()) {
            button.addActionListener(buttonClickAction);
        }

        pack();
        setTitle("Logic game");
    }

}
