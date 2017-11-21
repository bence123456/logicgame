package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import org.apache.commons.lang3.StringUtils;

public class CommonParser {

    protected Item createItem(String itemAsString, GameDefinition gameDefinition) {
        Item item = null;

        if (StringUtils.isNumeric(itemAsString)) {
            item = new Item(null, Integer.valueOf(itemAsString), null, null);
        } else if(itemAsString.length() == 1) {
            item = new Item(itemAsString.charAt(0), null, null, null);
        } else if(itemAsString.startsWith("S")) {
            if (!gameDefinition.getSymbolsMap().containsKey(itemAsString)) {
                throw new NoSuchSymbolException(itemAsString);
            }
            item = new Item(null, null, itemAsString, null);
        } else if(itemAsString.startsWith("#")) {
            item = new Item(null, null, null, Integer.parseInt(itemAsString.substring(1), 16));
        }

        return item;
    }
}
