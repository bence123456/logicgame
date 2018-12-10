package com.bkonecsni.logicgame.compilers.symbols;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface SymbolsCompiler {

    void compile(CharStream input, GameDefinition gameDefinition, StringBuilder initCodeBuilder);
}
