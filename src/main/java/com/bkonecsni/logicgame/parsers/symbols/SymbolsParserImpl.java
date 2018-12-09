package com.bkonecsni.logicgame.parsers.symbols;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import symbols.symbolsLexer;
import symbols.symbolsParser;
import symbols.symbolsParser.*;

public class SymbolsParserImpl implements SymbolsParser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition, StringBuilder initCodeBuilder) {
        if (input.size() > 3) {
            SymbolsContext symbolsContext = getSymbolsContext(input);
            parseSymbols(initCodeBuilder, gameDefinition, symbolsContext);
        }
    }

    private SymbolsContext getSymbolsContext(CharStream symbolsInput) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symbolsParser = new symbolsParser(symbolsTokens);
        return symbolsParser.symbols();
    }

    private void parseSymbols(StringBuilder initCodeBuilder, GameDefinition gameDefinition, SymbolsContext symbolsContext) {
        for (SymbolContext symbolContext : symbolsContext.symbol()) {
            String symbolID = symbolContext.SYMBOL_ID().getText();
            String symbolName = symbolContext.NAME().getText();

            initCodeBuilder.append("symbolsMap.put(\"" + symbolID + "\", \"" + symbolName + "\");");
            gameDefinition.getSymbolsMap().put(symbolID, symbolName);
        }
    }
}
