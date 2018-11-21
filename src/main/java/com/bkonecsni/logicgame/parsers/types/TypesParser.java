package com.bkonecsni.logicgame.parsers.types;

import com.bkonecsni.logicgame.runner.GameDefinition;
import org.antlr.v4.runtime.CharStream;

import java.util.Map;

public interface TypesParser {

    Map<String, String> parse(CharStream input, GameDefinition gameDefinition);

    String parse(CharStream input, GameDefinition gameDefinition, String typeName);
}
