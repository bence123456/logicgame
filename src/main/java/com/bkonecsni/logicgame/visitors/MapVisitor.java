package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.bkonecsni.logicgame.exceptions.SizeNotValidException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import map.mapBaseVisitor;
import map.mapParser;
import map.mapParser.TileContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapVisitor extends mapBaseVisitor<List<Tile>> {

    private GameDefinition gameDefinition;

    public MapVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public List<Tile> visitMap(mapParser.MapContext ctx) {
        List<Tile> tiles = new ArrayList<>();

        for (TileContext tileContext : ctx.tile()) {
            visitTile(tileContext, tiles);
        }

        return tiles;
    }

    private void visitTile(mapParser.TileContext tileContext, List<Tile> tiles) {
        Tile tile = new Tile();

        visitType(tileContext.type(), tile);
        visitPosition(tileContext.position(), tile);
        visitSize(tileContext.size(), tile);
        visitItemList(tileContext.itemList(), tile);

        tiles.add(tile);
    }

    private void visitType(mapParser.TypeContext typeContext, Tile tile) {
        String typeString = typeContext.T().getText() + typeContext.NUMBER().getText();
        Map<String, Type> typesMap = gameDefinition.getTypesMap();

        if (!typesMap.containsKey(typeString)) {
            throw new NoSuchTypeException(typeString);
        }

        Type type = typesMap.get(typeString);
        tile.setType(type);
    }

    private void visitPosition(mapParser.PositionContext positionContext, Tile tile) {
        int positionX = Integer.parseInt(positionContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(positionContext.NUMBER(1).getText());

        Point position = new Point(positionX, positionY);
        tile.setPosition(position);
    }

    private void visitSize(mapParser.SizeContext sizeContext, Tile tile) {
        if (sizeContext != null) {
            Point size = getSize(sizeContext, tile);
            tile.setSize(size);
        } else {
            Point defaultSize = new Point(40,40);
            tile.setSize(defaultSize);
        }
    }

    private Point getSize(mapParser.SizeContext sizeContext, Tile tile) {
        int positionX = Integer.parseInt(sizeContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(sizeContext.NUMBER(1).getText());

        if (positionX < 1 || positionY < 1) {
            throw new SizeNotValidException(positionX + ", " + positionY);
        }

        return new Point(positionX, positionY);
    }

    private void visitItemList(mapParser.ItemListContext itemListContext, Tile tile) {
        List<Item> itemList = new ArrayList<>();

        visitColor(itemListContext.color(), itemList);
        for (mapParser.ItemContext itemContext : itemListContext.item()) {
            visitItem(itemContext, itemList);
        }

        tile.setItemList(itemList);
    }

    private void visitColor(mapParser.ColorContext colorContext, List<Item> itemList) {
        Item colorItem = ParserUtil.createItem(colorContext.COLOR().getText(), gameDefinition);
        itemList.add(colorItem);
    }

    private void visitItem(mapParser.ItemContext itemContext, List<Item> itemList) {
        Item colorItem = ParserUtil.createItem(itemContext.getChild(1).getText(), gameDefinition);
        itemList.add(colorItem);
    }
}
