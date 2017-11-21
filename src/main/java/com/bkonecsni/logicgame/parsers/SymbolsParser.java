package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import symbols.symbolsLexer;
import symbols.symbolsParser;


public class SymbolsParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseSymbols(input, gameDefinition);
    }

    private void parseSymbols(CharStream symbolsInput, GameDefinition gameDefinition) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symbolsParser = new symbolsParser(symbolsTokens);
        symbols.symbolsParser.SymbolsContext symbolsContext = symbolsParser.symbols();

        for (ParseTree symbolChild : symbolsContext.children) {
            String symbolName = symbolChild.getChild(0).getText();
            String symbolPath = symbolChild.getChild(2).getText();
            gameDefinition.getSymbolsMap().put(symbolName, symbolPath);
        }
    }
}
