package com.bkonecsni.logicgame.parsers.map;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.parsers.CommonParser;
import com.bkonecsni.logicgame.visitors.MapVisitor;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

public class MapParserImpl extends CommonParser implements MapParser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition, String levelKey) {
        MapContext mapContext = getMapContext(input);
        MapVisitor visitor = new MapVisitor(gameDefinition);

        List<Tile> tiles = visitor.visitMap(mapContext);

        GameMap gameMap = new GameMap(tiles);
        gameDefinition.getMaps().put(levelKey, gameMap);
    }

    private MapContext getMapContext(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        return mapParser.map();
    }
}