package com.bkonecsni.logicgame.parsers.util;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import org.apache.commons.lang3.StringUtils;

public class ParserUtil {

    public static String getItemCreationString(String itemAsString, GameDefinition gameDefinition) {
        String itemCreationString = null;

        if (StringUtils.isNumeric(itemAsString)) {
            itemCreationString = "Item.createWithIntValue(" + Integer.valueOf(itemAsString) + ")";
        } else if(itemAsString.length() == 1) {
            itemCreationString = "Item.createWithCharValue('" + itemAsString.charAt(0) + "')";
        } else if(itemAsString.startsWith("S")) {
            if (!gameDefinition.getSymbolsMap().containsKey(itemAsString)) {
                throw new NoSuchSymbolException(itemAsString);
            }
            itemCreationString = "Item.createWithSymbol(\"" + itemAsString + "\")";
        } else if(itemAsString.startsWith("#")) {
            String colorCreationString = getColorCreationString(itemAsString);
            itemCreationString = "Item.createWithColor(" + colorCreationString + ")";
        }

        return itemCreationString;
    }

    public static String getColorCreationString(String itemAsString) {
        String stringColor;

        if (itemAsString.length() == 4) {
            char digit1 = itemAsString.charAt(1);
            char digit2 = itemAsString.charAt(2);
            char digit3 = itemAsString.charAt(3);

            stringColor = "#" + digit1 + digit1 + digit2 + digit2 + digit3 + digit3;
        } else {
            stringColor = itemAsString;
        }

        Integer r = Integer.valueOf(stringColor.substring(1, 3), 16);
        Integer g = Integer.valueOf(stringColor.substring(3, 5), 16);
        Integer b = Integer.valueOf(stringColor.substring(5, 7), 16);

        return "new Color(" + r + ", " + g + ", " + b + ")";
    }
}
