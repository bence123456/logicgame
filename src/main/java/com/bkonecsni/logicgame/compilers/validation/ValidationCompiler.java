package com.bkonecsni.logicgame.compilers.validation;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface ValidationCompiler {

    String compile(CharStream input, GameDefinition gameDefinition);
}
