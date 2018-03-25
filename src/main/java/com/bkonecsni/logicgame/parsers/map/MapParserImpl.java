package com.bkonecsni.logicgame.parsers.map;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.visitors.MapVisitor;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MapParserImpl implements MapParser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition, String levelKey, String gameName) {
        MapContext mapContext = getMapContext(input);
        MapVisitor visitor = new MapVisitor(gameDefinition);

        String tiles = visitor.visitMap(mapContext);

        PrintWriter out = null;
        try {
            out = new PrintWriter("generated/games/"+ gameName +"/"+ gameName +".txt");
//            out = new PrintWriter("generated/games/parks/parks.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println(tiles);
        out.close();

        GameMap gameMap = null;//new GameMap(tiles);
        gameDefinition.getMaps().put(levelKey, gameMap);
    }

    private MapContext getMapContext(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        return mapParser.map();
    }
}