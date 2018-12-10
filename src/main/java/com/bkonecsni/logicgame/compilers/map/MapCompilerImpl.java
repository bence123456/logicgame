package com.bkonecsni.logicgame.compilers.map;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.visitors.map.MapVisitor;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class MapCompilerImpl implements MapCompiler {

    @Override
    public String compile(CharStream input, GameDefinition gameDefinition, String className) {
        MapContext mapContext = parseMap(input);
        MapVisitor visitor = new MapVisitor(gameDefinition, className);

        return visitor.visitMap(mapContext);
    }

    private MapContext parseMap(CharStream mapInput) {
        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        return mapParser.map();
    }
}