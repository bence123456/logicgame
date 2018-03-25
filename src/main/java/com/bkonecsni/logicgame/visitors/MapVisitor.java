package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.bkonecsni.logicgame.exceptions.SizeNotValidException;
import map.mapBaseVisitor;
import map.mapParser;
import map.mapParser.TileContext;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.bkonecsni.logicgame.visitors.TypesVisitor.TAB;

public class MapVisitor extends mapBaseVisitor<String> {

    private GameDefinition gameDefinition;

    private Set<String> definedTileTypes = new HashSet<>();

    public MapVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public String visitMap(mapParser.MapContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("package generated.games.parks;\n\n");

        for (TileContext tileContext : ctx.tile()) {
            visitTile(tileContext, sb);
        }

        return sb.toString();
    }

    private void visitTile(mapParser.TileContext tileContext, StringBuilder sb) {
        String typeString = visitType(tileContext.type());

        if (!definedTileTypes.contains(typeString)) {
            sb.append("public class Tile_"+ typeString +" implements ITile {\n\n");
            sb.append(TAB + "private Point position; \n\n" + TAB + "private Point size; \n\n" +
                    TAB + "private List<Item> itemList; \n\n");

            sb.append(TAB + "public void onClick() {\n" + gameDefinition.getTypesMap().get(typeString) + "\n" + TAB + "}\n\n");
            appendGettersSetters(sb);
            definedTileTypes.add(typeString);
        }
    }

    public String visitType(mapParser.TypeContext typeContext) {
        String typeString = typeContext.T().getText() + typeContext.NUMBER().getText();
        Map<String, String> typesMap = gameDefinition.getTypesMap();

        if (!typesMap.containsKey(typeString)) {
            throw new NoSuchTypeException(typeString);
        }

        return typeString;
    }

    public String visitPosition(mapParser.PositionContext positionContext) {
        int positionX = Integer.parseInt(positionContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(positionContext.NUMBER(1).getText());

        return positionX + "," + positionY;
    }

    public String visitSize(mapParser.SizeContext sizeContext) {
        if (sizeContext != null) {
            return getSize(sizeContext);
        } else {
            return "40,40";
        }
    }

    public String visitItemList(mapParser.ItemListContext itemListContext) {
        StringBuilder sb = new StringBuilder();

        sb.append(itemListContext.color().COLOR().getText());
        for (mapParser.ItemContext itemContext : itemListContext.item()) {
            sb.append("," + itemContext.getChild(1).getText());
        }

        return sb.toString();
    }

    private String getSize(mapParser.SizeContext sizeContext) {
        int positionX = Integer.parseInt(sizeContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(sizeContext.NUMBER(1).getText());

        if (positionX < 1 || positionY < 1) {
            throw new SizeNotValidException(positionX + ", " + positionY);
        }

        return positionX + "," + positionY;
    }

    private void appendGettersSetters(StringBuilder sb) {
        sb.append(TAB + "public Point getPosition() { return position; }\n\n" +
                TAB + "public void setPosition(Point position) { this.position = position; }\n\n" +
                TAB + "public Point getSize() {return size; }\n\n" +
                TAB + "public void setSize(Point size) { this.size = size; }\n\n" +
                TAB + "public List<Item> getItemList() {return itemList; }\n\n" +
                TAB + "public void setItemList(List<Item> itemList) { this.itemList = itemList; }\n\n" + "}\n\n\n");
    }

}
