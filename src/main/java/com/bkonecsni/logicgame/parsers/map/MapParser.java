package com.bkonecsni.logicgame.parsers.map;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface MapParser {

    String parse(CharStream input, GameDefinition gameDefinition, String className);
}
