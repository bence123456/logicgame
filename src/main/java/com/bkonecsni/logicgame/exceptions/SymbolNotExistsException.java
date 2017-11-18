package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SymbolNotExistsException extends ParseCancellationException {

    public SymbolNotExistsException(String message) {
        super(message);
    }
}
