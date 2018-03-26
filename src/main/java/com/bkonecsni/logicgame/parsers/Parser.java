package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface Parser {

    String parse(CharStream input, GameDefinition gameDefinition);
}
