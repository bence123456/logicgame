package com.bkonecsni.logicgame.antlr.tiles;

import com.bkonecsni.logicgame.visitors.TilesVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import tiles.tilesLexer;
import tiles.tilesParser;

import java.io.IOException;

public class TilesGrammarTest {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("games/parks/parks_level1.txt");
        tilesLexer lexer = new tilesLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tilesParser parser = new tilesParser(tokens);

        TilesVisitor visitor = new TilesVisitor();
        visitor.visit(parser.tiles());
    }
}
