package com.bkonecsni.logicgame.main;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.map.Map;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.domain.types.BorderType;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.Update;
import com.bkonecsni.logicgame.domain.validation.LooseStatement;
import com.bkonecsni.logicgame.domain.validation.Validation;
import com.bkonecsni.logicgame.domain.validation.WinStatement;
import com.bkonecsni.logicgame.exceptions.NoSuchSymbolException;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.sun.javafx.css.Rule;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.apache.commons.lang3.StringUtils;
import symbols.symbolsLexer;
import symbols.symbolsParser;
import symbols.symbolsParser.SymbolsContext;
import types.typesLexer;
import types.typesParser;
import types.typesParser.TypesContext;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.ValidationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static java.util.Map<String, String> symbolsMap = new HashMap<>();
    //private static List<Symbol> symbolList = new ArrayList<>();

    //private static List<Type> typeList = new ArrayList<>();
    private static java.util.Map<String, Type> typesMap = new HashMap<>();

    private static List<Tile> map = new ArrayList<>();

    private static List<WinStatement> winStatementList = new ArrayList<>();
    private static List<LooseStatement> looseStatementList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        CharStream symbolsInput = CharStreams.fromFileName("games/parks/parks_symbols.txt");
        parseSymbols(symbolsInput);

        CharStream typesInput = CharStreams.fromFileName("games/parks/parks_types.txt");
        parseTypes(typesInput);

        CharStream mapInput = CharStreams.fromFileName("games/parks/maps/parks_level1.txt");
        parseMap(mapInput);

        CharStream validationInput = CharStreams.fromFileName("games/parks/parks_validation.txt");

        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);
        ValidationContext validationContext = validationParser.validation();
    }

    private static void parseSymbols(CharStream symbolsInput) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symblosParser = new symbolsParser(symbolsTokens);
        SymbolsContext symbolsContext = symblosParser.symbols();

        for (ParseTree symbolChild : symbolsContext.children) {
            String symbolName = symbolChild.getChild(0).getText();
            String symbolPath = symbolChild.getChild(2).getText();
            symbolsMap.put(symbolName, symbolPath);
        }
    }

    private static void parseTypes(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);
        TypesContext typesContext = typesParser.types();

        typesMap.put("Type0", new BorderType());
        for (ParseTree typeChild : typesContext.children) {
            String typeName = "Type" + typeChild.getChild(0).getChild(1).getText();
            List<TypeStatement> typeStatementList = createTypeStatementList(typeChild.getChild(1));
            Type type = new Type(typeStatementList);
            typesMap.put(typeName, type);
        }
    }

    private static void parseMap(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        MapContext mapContext = mapParser.map();

        for (ParseTree tileChild : mapContext.children) {
            mapParser.TileContext tileContext = (map.mapParser.TileContext) tileChild;
            Tile tile = new Tile();
            boolean sizeDefined = false;

            for (ParseTree tileElement : tileContext.children){
                if (tileElement instanceof map.mapParser.TypeContext) {
                    handleType((map.mapParser.TypeContext) tileElement, tile);
                }
                if (tileElement instanceof map.mapParser.PositionContext) {
                    handlePosition((map.mapParser.PositionContext) tileElement, tile);
                }
                if (tileElement instanceof map.mapParser.SizeContext) {
                    handleSize((map.mapParser.SizeContext) tileElement, tile);
                    sizeDefined = true;
                }
                if (tileElement instanceof map.mapParser.ItemListContext) {
                    handleItemList((map.mapParser.ItemListContext) tileElement, tile);
                }
            }

            if (!sizeDefined) {
                Point defaultSize = new Point(1,1);
                tile.setSize(defaultSize);
            }

            map.add(tile);
        }


    }

    private static List<TypeStatement> createTypeStatementList(ParseTree typeChild) {
        typesParser.TypedefContext typedefContext = (typesParser.TypedefContext) typeChild;

        List<TypeStatement> typeStatementList = new ArrayList<>();

        for (ParseTree typedef : typedefContext.children) {
            typesParser.TypestatementContext typestatementContext = (typesParser.TypestatementContext) typedef;
            TypeStatement typeStatement = new TypeStatement();

            for (ParseTree statement : typestatementContext.children) {
                if (statement instanceof typesParser.Parens_nrContext) {
                    int comparableItemIndex = Integer.parseInt(statement.getChild(1).getText());
                    typeStatement.setComparableItemIndex(comparableItemIndex);
                }
                if (statement instanceof typesParser.ItemContext) {
                    Item item = createItem(statement.getText());
                    typeStatement.setItemToCompare(item);
                }
                if (statement instanceof typesParser.UpdatestatementContext) {
                    List<Update> updateList = new ArrayList<>();
                    typesParser.UpdatestatementContext updatestatementContext = (typesParser.UpdatestatementContext) statement;

                    Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().children.get(1).getText());
                    Item newItem = createItem(updatestatementContext.item().getText());
                    Update update = new Update(itemToUpdateIndex, newItem);
                    updateList.add(update);
                    typeStatement.setUpdateList(updateList);
                }
            }
            typeStatementList.add(typeStatement);
        }

        return typeStatementList;
    }

    public static Item createItem(String itemAsString) {
        Item item = null;

        if (StringUtils.isNumeric(itemAsString)) {
            item = new Item(null, Integer.valueOf(itemAsString), null, null);
        } else if(itemAsString.length() == 1) {
            item = new Item(itemAsString.charAt(0), null, null, null);
        } else if(itemAsString.startsWith("S")) {
            if (!symbolsMap.containsKey(itemAsString)) {
                throw new NoSuchSymbolException(itemAsString);
            }
            item = new Item(null, null, itemAsString, null);
        } else if(itemAsString.startsWith("#")) {
            item = new Item(null, null, null, Integer.parseInt(itemAsString.substring(1), 16));
        }

        return item;
    }

    public static void handleType(mapParser.TypeContext typeContext, Tile tile) {
        String typeString = typeContext.children.get(0).getText() + typeContext.children.get(1).getText();
        if (!typesMap.containsKey(typeString)) {
            throw new NoSuchTypeException(typeString);
        }
        Type type = typesMap.get(typeString);
        tile.setType(type);
    }

    public static void handlePosition(mapParser.PositionContext positionContext, Tile tile) {
        int positionX = Integer.parseInt(positionContext.children.get(1).getText());
        int positionY = Integer.parseInt(positionContext.children.get(3).getText());

        Point position = new Point(positionX, positionY);
        tile.setPosition(position);
    }

    public static void handleSize(mapParser.SizeContext sizeContext, Tile tile) {
        int sizeX = Integer.parseInt(sizeContext.children.get(2).getText());
        int sizeY = Integer.parseInt(sizeContext.children.get(4).getText());

        Point size = new Point(sizeX, sizeY);
        tile.setSize(size);
    }

    public static void handleItemList(mapParser.ItemListContext itemListContext, Tile tile) {
        List<Item> itemList = new ArrayList<>();
        for (ParseTree itemContext : itemListContext.children) {
            if (itemContext instanceof mapParser.ItemContext) {
                Item item = createItem(((mapParser.ItemContext) itemContext).children.get(1).getText());
                itemList.add(item);
            }
            if (itemContext instanceof mapParser.ColorContext) {
                Item item = createItem(((mapParser.ColorContext) itemContext).children.get(1).getText());
                itemList.add(item);
            }
        }
        tile.setItemList(itemList);
    }
}
