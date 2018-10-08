package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class ButtonClickAction extends AbstractAction {

    private GameDefinition gameDefinition;
    private Map<JButton, TileBase> buttonTileMap;
    private LevelBase map;

    public ButtonClickAction(Map<JButton, TileBase> buttonTileMap, GameDefinition gameDefinition, LevelBase map) {
        this.buttonTileMap = buttonTileMap;
        this.gameDefinition = gameDefinition;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();
        TileBase actualTile = buttonTileMap.get(buttonSource);

        handleActionEvent(actualTile);

        validate();
    }

    private void handleActionEvent(TileBase actualTile) {
        actualTile.handleState();

        for (JButton button : buttonTileMap.keySet()) {
            TileBase tileBase = buttonTileMap.get(button);
            List<Item> itemList = tileBase.getItemList();
            Color color = itemList.get(0).getColor();
            button.setBackground(color);

            Item item = tileBase.getItem(1);
            ImageIcon icon = gameDefinition.getIcon(item);
            button.setIcon(icon);
        }
    }

    private void validate() {
        ValidationBase validationHandler = gameDefinition.getValidationHandler();

        if (validationHandler.areWinConditionsApply()) {
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
