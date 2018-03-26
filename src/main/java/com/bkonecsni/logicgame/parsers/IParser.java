package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface IParser {

    void parse(CharStream input, GameDefinition gameDefinition);
}
