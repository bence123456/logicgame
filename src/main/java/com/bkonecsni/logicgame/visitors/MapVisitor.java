package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.bkonecsni.logicgame.exceptions.SizeNotValidException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import map.mapBaseVisitor;
import map.mapParser;
import map.mapParser.TileContext;

import java.util.Set;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.*;

public class MapVisitor extends mapBaseVisitor<String> {

    private GameDefinition gameDefinition;

    public MapVisitor(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
    }

    @Override
    public String visitMap(mapParser.MapContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(TAB + "public void init() {\n");
        sb.append(D_TAB + "this.tileList = Arrays.asList(\n");

        boolean isFirst = true;
        for (TileContext tileContext : ctx.tile()) {
            if (isFirst) {
                sb.append(T_TAB + visitTile(tileContext));
                isFirst = false;
            } else {
                sb.append(",\n" + T_TAB + visitTile(tileContext));
            }
        }

        sb.append("\n" + D_TAB + ");\n");
        sb.append(TAB + "}\n\n");

        return sb.toString();
    }

    @Override
    public String visitTile(mapParser.TileContext tileContext) {
        StringBuilder sb = new StringBuilder();

        String typeString = visitType(tileContext.type());
        sb.append("new Tile_" + typeString + "(");
        sb.append(visitPosition(tileContext.position()) + ", ");
        sb.append(visitSize(tileContext.size()) + ", ");
        sb.append(visitItemList(tileContext.itemList()));
        sb.append(")");

        return sb.toString();
    }

    @Override
    public String visitType(mapParser.TypeContext typeContext) {
        String typeString = typeContext.T().getText() + typeContext.NUMBER().getText();
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        if (!definedTypes.contains(typeString)) {
            throw new NoSuchTypeException(typeString);
        }

        return typeString;
    }

    @Override
    public String visitPosition(mapParser.PositionContext positionContext) {
        int positionX = Integer.parseInt(positionContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(positionContext.NUMBER(1).getText());

        return "new Point(" + positionX + "," + positionY + ")";
    }

    @Override
    public String visitSize(mapParser.SizeContext sizeContext) {
        if (sizeContext != null) {
            return "new Point(" + getSize(sizeContext) + ")";
        } else {
            return "new Point(40,40)";
        }
    }

    @Override
    public String visitItemList(mapParser.ItemListContext itemListContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("Arrays.asList(");

        sb.append(ParserUtil.getItemCreationString(itemListContext.color().COLOR().getText(), gameDefinition));
        for (mapParser.ItemContext itemContext : itemListContext.item()) {
            String itemCreationString = ParserUtil.getItemCreationString(itemContext.getChild(1).getText(), gameDefinition);
            sb.append(", " + itemCreationString);
        }
        sb.append(")");

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
}
