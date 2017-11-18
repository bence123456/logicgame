package com.bkonecsni.logicgame.antlr.map;

import com.bkonecsni.logicgame.visitors.mapVisitor;
import map.mapLexer;
import map.mapParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;

public class MapGrammarTest {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("games/parks/maps/parks_level1.txt");
        mapLexer lexer = new mapLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mapParser parser = new mapParser(tokens);

        mapVisitor visitor = new mapVisitor();
        visitor.visit(parser.map());
    }
}
