package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class NoSuchSymbolException extends ParseCancellationException {

    public NoSuchSymbolException(String symbol) {
        super(symbol);
    }
}
