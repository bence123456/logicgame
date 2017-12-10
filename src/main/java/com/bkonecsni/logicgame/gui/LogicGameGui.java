package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LogicGameGui extends JFrame {

    private static final int BUTTON_SIZE_MULTIPLIER = 50;

    private JPanel panel;

    private ButtonClickAction buttonClickAction;

    private Map<JButton, Tile> buttonTileMap;

    public LogicGameGui(GameDefinition gameDefinition) {
        GameMap map = gameDefinition.getMaps().get("level1");
        int rows = map.getRowNumber();
        int columns = map.getColumnNumber();

        createUIPanel(rows, columns);

        addTiles(map, rows, columns);

        addButtonListener(gameDefinition, map);

        pack();
        setTitle("Logic game");
    }

    private void createUIPanel(int rows, int columns) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));
        buttonTileMap = new HashMap<>();

        add(panel, BorderLayout.CENTER);
    }

    private void addTiles(GameMap map, int rows, int columns) {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                JButton button = new JButton();
                Tile tile = map.getTile(i,j);
                Color color = tile.getItemList().get(0).getColor();
                button.setBackground(color);
                Point size = tile.getSize();
                button.setPreferredSize(new Dimension(size.x* BUTTON_SIZE_MULTIPLIER, size.y * BUTTON_SIZE_MULTIPLIER));

                buttonTileMap.put(button, tile);
                panel.add(button);
            }
        }
    }

    private void addButtonListener(GameDefinition gameDefinition, GameMap map) {
        buttonClickAction = new ButtonClickAction(buttonTileMap, gameDefinition, map);
        for (JButton button : buttonTileMap.keySet()) {
            button.addActionListener(buttonClickAction);
        }
    }

}
