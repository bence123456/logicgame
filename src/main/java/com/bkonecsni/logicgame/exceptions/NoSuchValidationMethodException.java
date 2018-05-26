package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class NoSuchValidationMethodException extends ParseCancellationException {

    public NoSuchValidationMethodException(String methodName, String paramTypes) {
        super(methodName + " with given param types: " + paramTypes);
    }
}