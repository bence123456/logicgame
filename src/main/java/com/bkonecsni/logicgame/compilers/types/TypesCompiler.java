package com.bkonecsni.logicgame.compilers.types;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

import java.util.Map;

public interface TypesCompiler {

    Map<String, String> compile(CharStream input, GameDefinition gameDefinition);

    String compile(CharStream input, GameDefinition gameDefinition, String typeName);
}
