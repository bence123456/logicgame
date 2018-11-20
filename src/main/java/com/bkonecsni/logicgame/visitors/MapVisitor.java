package com.bkonecsni.logicgame.visitors;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchTypeException;
import com.bkonecsni.logicgame.exceptions.SizeNotValidException;
import com.bkonecsni.logicgame.parsers.util.ParserUtil;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import map.mapBaseVisitor;
import map.mapParser;
import map.mapParser.*;

import java.util.Set;

public class MapVisitor extends mapBaseVisitor<String> {

    private GameDefinition gameDefinition;
    private String className;

    public MapVisitor(GameDefinition gameDefinition, String className) {
        this.gameDefinition = gameDefinition;
        this.className = className;
    }

    @Override
    public String visitMap(MapContext ctx) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb);
        appendInit(ctx, sb);
        appendClosingBrackets(sb);

        return VisitorUtil.formatJavaCode(sb.toString());
    }

    @Override
    public String visitTile(TileContext tileContext) {
        StringBuilder sb = new StringBuilder();

        String typeString = visitType(tileContext.type());
        sb.append("new " + typeString + "Tile (");
        sb.append(visitPosition(tileContext.position()) + ", ");
        sb.append(visitSize(tileContext.size()) + ", ");
        sb.append(visitItemList(tileContext.itemList()));
        sb.append(")");

        return sb.toString();
    }

    @Override
    public String visitType(TypeContext typeContext) {
        String typeString = typeContext.T().getText() + typeContext.NUMBER().getText();
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        if (!definedTypes.contains(typeString)) {
            throw new NoSuchTypeException(typeString);
        }

        return typeString;
    }

    @Override
    public String visitPosition(PositionContext positionContext) {
        int positionX = Integer.parseInt(positionContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(positionContext.NUMBER(1).getText());

        return "new Point(" + positionX + "," + positionY + ")";
    }

    @Override
    public String visitSize(SizeContext sizeContext) {
        if (sizeContext != null) {
            return "new Point(" + getSize(sizeContext) + ")";
        } else {
            return "new Point(40,40)";
        }
    }

    @Override
    public String visitItemList(ItemListContext itemListContext) {
        StringBuilder sb = new StringBuilder();
        sb.append("new ArrayList(Arrays.asList(");

        sb.append(ParserUtil.getItemCreationString(itemListContext.color().COLOR().getText(), gameDefinition));
        for (mapParser.ItemContext itemContext : itemListContext.item()) {
            String itemCreationString = ParserUtil.getItemCreationString(itemContext.getChild(1).getText(), gameDefinition);
            sb.append(", " + itemCreationString);
        }
        sb.append("))");

        return sb.toString();
    }

    private String getSize(SizeContext sizeContext) {
        int positionX = Integer.parseInt(sizeContext.NUMBER(0).getText());
        int positionY = Integer.parseInt(sizeContext.NUMBER(1).getText());

        if (positionX < 1 || positionY < 1) {
            throw new SizeNotValidException(positionX + ", " + positionY);
        }

        return positionX + "," + positionY;
    }

    private void appendInit(MapContext ctx, StringBuilder sb) {
        sb.append("public void init() {");
        sb.append("this.tileList = Arrays.asList(");

        boolean isFirst = true;
        for (TileContext tileContext : ctx.tile()) {
            if (isFirst) {
                sb.append(visitTile(tileContext));
                isFirst = false;
            } else {
                sb.append("," + visitTile(tileContext));
            }
        }
    }

    private void appendImportsAndClassHeader(StringBuilder sb) {
        sb.append("package gamecode." + gameDefinition.getGameName() + ".levels;");
        appendImports(sb);
        sb.append("public class " + className + " extends LevelBase {");
    }

    private void appendClosingBrackets(StringBuilder sb) {
        sb.append(");}}");
    }

    private void appendImports(StringBuilder sb) {
        for (String type: gameDefinition.getDefinedTypes()) {
            sb.append("import gamecode." + gameDefinition.getGameName() + ".types." + type + "Tile;");
        }

        sb.append("import com.bkonecsni.logicgame.domain.map.LevelBase;" +
                "import com.bkonecsni.logicgame.domain.common.Item;" +
                "import com.bkonecsni.logicgame.domain.common.Point;" +
                "import java.util.ArrayList;" +
                "import java.util.Arrays;");
    }
}
