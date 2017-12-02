package com.bkonecsni.logicgame.parsers.map;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;

public interface MapParser {

    void parse(CharStream input, GameDefinition gameDefinition, String levelKey);
}
