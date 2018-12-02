package com.bkonecsni.logicgame.parsers.util;

import com.bkonecsni.logicgame.runner.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import org.apache.commons.lang3.StringUtils;

public class ParserUtil {

    public static String getItemCreationString(String itemAsString, GameDefinition gameDefinition) {
        String itemCreationString = null;

        if (StringUtils.isNumeric(itemAsString)) {
            itemCreationString = "Item.createWithIntValue(" + Integer.valueOf(itemAsString) + ")";
        } else if(itemAsString.startsWith("&") || itemAsString.length() == 1) {
            Character charItem = StringUtils.removeFirst(itemAsString, "&").charAt(0);
            itemCreationString = "Item.createWithCharValue('" + charItem + "')";        } else if(itemAsString.startsWith("S")) {
            if (!gameDefinition.getSymbolsMap().containsKey(itemAsString)) {
                throw new NoSuchSymbolException(itemAsString);
            }
            itemCreationString = "Item.createWithSymbol(\"" + itemAsString + "\")";
        } else if(itemAsString.startsWith("#")) {
            itemCreationString = "Item.createWithColor(\"" + itemAsString + "\")";
        }

        return itemCreationString;
    }
}
