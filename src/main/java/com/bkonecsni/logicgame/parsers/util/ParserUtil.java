package com.bkonecsni.logicgame.parsers.util;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;

public class ParserUtil {

    public static String getItemCreationString(String itemAsString, GameDefinition gameDefinition) {
        String itemCreationString = null;

        if (StringUtils.isNumeric(itemAsString)) {
            itemCreationString = "new Item(null, " + Integer.valueOf(itemAsString) + ", null, null)";
        } else if(itemAsString.length() == 1) {
            itemCreationString = "new Item(" + itemAsString.charAt(0) + ", null, null, null)";
        } else if(itemAsString.startsWith("S")) {
            if (!gameDefinition.getSymbolsMap().containsKey(itemAsString)) {
                throw new NoSuchSymbolException(itemAsString);
            }
            itemCreationString = "new Item(null, null, " + itemAsString + ", null)";
        } else if(itemAsString.startsWith("#")) {
            String color = getColorCreatiionString(itemAsString);
            itemCreationString = "new Item(null, null, null, " + color + ")";
        }

        return itemCreationString;
    }

    public static String getColorCreatiionString(String itemAsString) {
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

    public static Item createItem(String itemAsString, GameDefinition gameDefinition) {
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
            Color color = getColor(itemAsString);
            item = new Item(null, null, null, color);
        }

        return item;
    }

    public static Color getColor(String itemAsString) {
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

        return new Color(r, g, b);
    }
}
