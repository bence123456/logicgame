package com.bkonecsni.logicgame.compilers.map;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface MapCompiler {

    String compile(CharStream input, GameDefinition gameDefinition, String className);
}
