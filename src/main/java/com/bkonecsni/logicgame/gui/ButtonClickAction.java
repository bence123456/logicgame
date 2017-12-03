package com.bkonecsni.logicgame.gui;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.statehandler.StateHandler;
import com.bkonecsni.logicgame.validation.ValidationHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class ButtonClickAction extends AbstractAction {

    private StateHandler stateHandler;
    private ValidationHandler validationHandler;
    private GameDefinition gameDefinition;
    private Map<JButton, Tile> buttonTileMap;

    public ButtonClickAction(Map<JButton, Tile> buttonTileMap, GameDefinition gameDefinition) {
        this.buttonTileMap = buttonTileMap;
        this.gameDefinition = gameDefinition;
        this.stateHandler = new StateHandler();
        this.validationHandler = new ValidationHandler();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();
        Tile actualTile = buttonTileMap.get(buttonSource);

        stateHandler.act(actualTile);

        List<Item> itemList = actualTile.getItemList();
        if (itemList.size() == 2) {
            Item item = itemList.get(1);
            ImageIcon icon = gameDefinition.getSymbolsMap().get(item.getSymbol());
            buttonSource.setIcon(icon);
        } else if (itemList.size() == 1) {
            buttonSource.setIcon(null);
        }

    }
}
