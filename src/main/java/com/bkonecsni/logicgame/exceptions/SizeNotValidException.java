package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SizeNotValidException extends ParseCancellationException {

    public SizeNotValidException(String actualSize) {
        super("Size must be greater than 0! Actual size: " + actualSize);
    }
}
