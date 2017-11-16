package com.bkonecsni.logicgame.antlr.symbols;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import symbols.symbolsLexer;
import symbols.symbolsParser;

import java.io.IOException;

public class SymbolsGrammarTest {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("games/parks/parks_symbols.txt");
        symbolsLexer lexer = new symbolsLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        symbolsParser parser = new symbolsParser(tokens);

        parser.symbols();
    }
}
