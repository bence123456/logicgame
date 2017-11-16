package com.bkonecsni.logicgame.antlr.validation;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import validation.validationLexer;
import validation.validationParser;

import java.io.IOException;

public class ValidationGrammarTest {

    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromFileName("games/parks/parks_validation.txt");
        validationLexer lexer = new validationLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validationParser parser = new validationParser(tokens);

        parser.validation();
    }
}
