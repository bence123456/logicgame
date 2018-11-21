package com.bkonecsni.logicgame.parsers.validation;

import com.bkonecsni.logicgame.runner.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface ValidationParser {

    String parse(CharStream input, GameDefinition gameDefinition);
}
