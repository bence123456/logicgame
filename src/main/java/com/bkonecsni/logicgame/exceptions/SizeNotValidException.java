package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SizeNotValidException extends ParseCancellationException {

    public SizeNotValidException(String message) {
        super(message);
    }
}
