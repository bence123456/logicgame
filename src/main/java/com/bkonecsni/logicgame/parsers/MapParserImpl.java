package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.visitors.MapVisitor;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class MapParserImpl implements Parser {

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition) {
        MapContext mapContext = getMapContext(input);
        MapVisitor visitor = new MapVisitor(gameDefinition);

        return visitor.visitMap(mapContext);
    }

    private MapContext getMapContext(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        return mapParser.map();
    }
}