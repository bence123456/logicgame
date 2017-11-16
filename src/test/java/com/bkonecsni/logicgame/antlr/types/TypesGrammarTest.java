package com.bkonecsni.logicgame.antlr.types;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import types.typesLexer;
import types.typesParser;

import java.io.IOException;

public class TypesGrammarTest {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("games/parks/parks_types.txt");
        typesLexer lexer = new typesLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        typesParser parser = new typesParser(tokens);

        parser.types();
    }
}
