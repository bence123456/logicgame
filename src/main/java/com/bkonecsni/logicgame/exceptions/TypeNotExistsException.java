package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class TypeNotExistsException extends ParseCancellationException {

    public TypeNotExistsException(String message) {
        super(message);
    }
}
