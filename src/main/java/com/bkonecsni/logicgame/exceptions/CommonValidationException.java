package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class CommonValidationException extends ParseCancellationException {

    public CommonValidationException(String message) {
        super(message);
    }
}
