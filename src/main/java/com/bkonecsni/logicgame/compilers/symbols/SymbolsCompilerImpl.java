package com.bkonecsni.logicgame.compilers.symbols;

import com.bkonecsni.logicgame.exceptions.SymbolAlreadyDefinedException;
import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import symbols.symbolsLexer;
import symbols.symbolsParser;
import symbols.symbolsParser.*;

import java.util.Map;

public class SymbolsCompilerImpl implements SymbolsCompiler {

    @Override
    public void compile(CharStream input, GameDefinition gameDefinition, StringBuilder initCodeBuilder) {
        if (input.size() > 1) {
            SymbolsContext symbolsContext = parseSymbols(input);
            generateCode(initCodeBuilder, gameDefinition, symbolsContext);
        }
    }

    private SymbolsContext parseSymbols(CharStream symbolsInput) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symbolsParser = new symbolsParser(symbolsTokens);
        return symbolsParser.symbols();
    }

    private void generateCode(StringBuilder initCodeBuilder, GameDefinition gameDefinition, SymbolsContext symbolsContext) {
        for (SymbolContext symbolContext : symbolsContext.symbol()) {
            String symbolID = symbolContext.SYMBOL_ID().getText();
            String symbolName = symbolContext.NAME().getText();

            Map<String, String> symbolsMap = gameDefinition.getSymbolsMap();
            if (symbolsMap.containsKey(symbolID)) {
                throw new SymbolAlreadyDefinedException(symbolID);
            } else {
                initCodeBuilder.append("symbolsMap.put(\"" + symbolID + "\", \"" + symbolName + "\");");
                symbolsMap.put(symbolID, symbolName);
            }
        }
    }
}
