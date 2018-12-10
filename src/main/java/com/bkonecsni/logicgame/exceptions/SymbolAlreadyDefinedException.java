package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SymbolAlreadyDefinedException extends ParseCancellationException {

    public SymbolAlreadyDefinedException(String type) {
        super(type);
    }
}