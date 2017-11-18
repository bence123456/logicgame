package com.bkonecsni.logicgame.main;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import types.typesLexer;
import types.typesParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CharStream typesInput = CharStreams.fromFileName("games/parks/parks_types.txt");
        CharStream symbolsInput = CharStreams.fromFileName("games/parks/parks_symbols.txt");
        CharStream mapInput = CharStreams.fromFileName("games/parks/map/parks_level1.txt");
        CharStream validationInput = CharStreams.fromFileName("games/parks/parks_validation.txt");



        typesLexer lexer = new typesLexer(typesInput);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        typesParser parser = new typesParser(tokens);

        parser.types();
    }
}
