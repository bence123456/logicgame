package com.bkonecsni.logicgame.parsers.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface ValidationParser {

    void parse(CharStream input, GameDefinition gameDefinition);
}
