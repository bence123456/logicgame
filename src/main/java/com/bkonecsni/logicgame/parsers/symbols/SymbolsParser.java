package com.bkonecsni.logicgame.parsers.symbols;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface SymbolsParser {

    void parse(CharStream input, GameDefinition gameDefinition, StringBuilder initCodeBuilder);
}
