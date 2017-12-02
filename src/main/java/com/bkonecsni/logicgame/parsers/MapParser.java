package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.bkonecsni.logicgame.visitors.mapVisitor;

import map.mapLexer;
import map.mapParser;
import map.mapParser.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseMap(input, gameDefinition);
    }

    private void parseMap(CharStream mapInput, GameDefinition gameDefinition) {
        MapContext mapContext = getMapContext(mapInput);
        mapVisitor visitor = new mapVisitor();
        visitor.visit(mapContext);

        for (ParseTree tileChild : mapContext.children) {
            parseTile(gameDefinition, (TileContext) tileChild);
        }
    }

    private MapContext getMapContext(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        return mapParser.map();
    }

    private void parseTile(GameDefinition gameDefinition, TileContext tileChild) {
        TileContext tileContext = tileChild;
        Tile tile = new Tile();
        boolean sizeDefined = false;

        for (ParseTree tileElement : tileContext.children){
            if (tileElement instanceof TypeContext) {
                handleType((TypeContext) tileElement, tile, gameDefinition);
            }
            if (tileElement instanceof PositionContext) {
                handlePosition((PositionContext) tileElement, tile);
            }
            if (tileElement instanceof SizeContext) {
                handleSize((SizeContext) tileElement, tile);
                sizeDefined = true;
            }
            if (tileElement instanceof ItemListContext) {
                handleItemList((ItemListContext) tileElement, tile, gameDefinition);
            }
        }

        setDefaultSizeIfNecessary(tile, sizeDefined);

        gameDefinition.getMap().add(tile);
    }

    private void setDefaultSizeIfNecessary(Tile tile, boolean sizeDefined) {
        if (!sizeDefined) {
            Point defaultSize = new Point(1,1);
            tile.setSize(defaultSize);
        }
    }

    private  void handleType(TypeContext typeContext, Tile tile, GameDefinition gameDefinition) {
        String typeString = typeContext.children.get(0).getText() + typeContext.children.get(1).getText();
        Map<String, Type> typesMap = gameDefinition.getTypesMap();

        if (!typesMap.containsKey(typeString)) {
            throw new NoSuchTypeException(typeString);
        }
        Type type = typesMap.get(typeString);
        tile.setType(type);
    }

    private  void handlePosition(PositionContext positionContext, Tile tile) {
        int positionX = Integer.parseInt(positionContext.children.get(1).getText());
        int positionY = Integer.parseInt(positionContext.children.get(3).getText());

        Point position = new Point(positionX, positionY);
        tile.setPosition(position);
    }

    private  void handleSize(SizeContext sizeContext, Tile tile) {
        int sizeX = Integer.parseInt(sizeContext.children.get(2).getText());
        int sizeY = Integer.parseInt(sizeContext.children.get(4).getText());

        Point size = new Point(sizeX, sizeY);
        tile.setSize(size);
    }

    private  void handleItemList(ItemListContext itemListContext, Tile tile, GameDefinition gameDefinition) {
        List<Item> itemList = new ArrayList<>();
        for (ParseTree itemContext : itemListContext.children) {
            if (itemContext instanceof ItemContext) {
                Item item = createItem(((ItemContext) itemContext).children.get(1).getText(), gameDefinition);
                itemList.add(item);
            }
            if (itemContext instanceof ColorContext) {
                Item item = createItem(((ColorContext) itemContext).children.get(1).getText(), gameDefinition);
                itemList.add(item);
            }
        }
        tile.setItemList(itemList);
    }
}