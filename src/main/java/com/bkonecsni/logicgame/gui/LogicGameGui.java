package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;

import javax.swing.*;
import java.awt.*;

public class LogicGameGui extends JFrame {

    private JPanel panel;

    public LogicGameGui(GameDefinition gameDefinition) {
        GameMap map = gameDefinition.getMaps().get("level1");
        int rows = map.getRowNumber();
        int columns = map.getColumnNumber();

        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));

        add(panel, BorderLayout.CENTER);

        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                Button button = new Button();
                Tile tile = map.getTile(i,j);
                Color color = tile.getItemList().get(0).getColor();
                button.setBackground(color);
                panel.add(button);
            }
        }

        pack();
        setTitle("Logic game");
    }

}
