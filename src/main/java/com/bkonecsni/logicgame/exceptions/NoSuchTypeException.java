package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class NoSuchTypeException extends ParseCancellationException {

    public NoSuchTypeException(String message) {
        super(message);
    }
}
