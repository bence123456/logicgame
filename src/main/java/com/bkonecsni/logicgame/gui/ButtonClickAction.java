package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.statehandler.StateHandler;
import com.bkonecsni.logicgame.validation.ValidationHandler;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class ButtonClickAction extends AbstractAction {

    private StateHandler stateHandler;
    private ValidationHandler validationHandler;
    private GameDefinition gameDefinition;
    private Map<JButton, Tile> buttonTileMap;
    private GameMap map;

    public ButtonClickAction(Map<JButton, Tile> buttonTileMap, GameDefinition gameDefinition, GameMap map) {
        this.buttonTileMap = buttonTileMap;
        this.gameDefinition = gameDefinition;
        this.map = map;
        this.stateHandler = new StateHandler();
        this.validationHandler = new ValidationHandler();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();
        Tile actualTile = buttonTileMap.get(buttonSource);

        handleActionEvent(buttonSource, actualTile);

        validate();
    }

    private void handleActionEvent(JButton buttonSource, Tile actualTile) {
        stateHandler.act(actualTile);

        List<Item> itemList = actualTile.getItemList();
        if (itemList.size() == 2) {
            Item item = itemList.get(1);
            ImageIcon icon = gameDefinition.getIcon(item);
            buttonSource.setIcon(icon);
        } else if (itemList.size() == 1) {
            buttonSource.setIcon(null);
        }
    }

    private void validate() {
        boolean valid = false;

        try {
            valid = validationHandler.isValid(map, gameDefinition.getWinStatementList());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (valid) {
            JEditorPane editorPane = createEditorPane();
            JOptionPane.showMessageDialog(null, editorPane);
        }
    }

    private JEditorPane createEditorPane() {
        JEditorPane editorPane = new JEditorPane("text/html", "<html><body> You're winner!" +
                " <a href=\"https://en.wikipedia.org/wiki/Big_Rigs:_Over_the_Road_Racing#Reception_and_legacy\"> " +
                "(c) Big Rigs: Over the Road Racing </a> </body></html>");

        editorPane.addHyperlinkListener(e -> {
            if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        editorPane.setEditable(false);
        return editorPane;
    }
}
