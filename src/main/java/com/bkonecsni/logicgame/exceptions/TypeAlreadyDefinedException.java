package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class TypeAlreadyDefinedException extends ParseCancellationException {

    public TypeAlreadyDefinedException(String type) {
        super(type);
    }
}
