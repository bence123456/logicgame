package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ValidationMethodParameterException extends ParseCancellationException {

    public ValidationMethodParameterException(String message) {
        super(message);
    }
}
