package com.bkonecsni.logicgame.visitors.util;

import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;

public class VisitorUtil {

    public static final String BASE_DIR = "com.bkonecsni.logicgame.gamecode.";
    public static final String BASE_PACKAGE = "package " + BASE_DIR;
    public static final String BASE_IMPORT = "import " + BASE_DIR;

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

    public static String formatJavaCode(String stringToFormat) {
        CompilationUnit compilationUnit = null;

        try {
            compilationUnit = JavaParser.parse(new ByteArrayInputStream(stringToFormat.getBytes()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return compilationUnit.toString();
    }
}
