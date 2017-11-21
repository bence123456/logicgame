package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.parsers.MapParser;
import com.bkonecsni.logicgame.parsers.SymbolsParser;
import com.bkonecsni.logicgame.parsers.TypesParser;
import com.bkonecsni.logicgame.parsers.ValidationParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;

public class LogicGame {

    private GameDefinition gameDefinition = new GameDefinition();

    private SymbolsParser symbolsParser = new SymbolsParser();
    private TypesParser typesParser = new TypesParser();
    private MapParser mapParser = new MapParser();
    private ValidationParser validationParser = new ValidationParser();

    public void run() throws IOException {
        CharStream symbolsInput = CharStreams.fromFileName("games/parks/parks_symbols.txt");
        symbolsParser.parse(symbolsInput, gameDefinition);

        CharStream typesInput = CharStreams.fromFileName("games/parks/parks_types.txt");
        typesParser.parse(typesInput, gameDefinition);

        CharStream mapInput = CharStreams.fromFileName("games/parks/maps/parks_level1.txt");
        mapParser.parse(mapInput, gameDefinition);

        CharStream validationInput = CharStreams.fromFileName("games/parks/parks_validation.txt");
        validationParser.parse(validationInput, gameDefinition);
    }
}
