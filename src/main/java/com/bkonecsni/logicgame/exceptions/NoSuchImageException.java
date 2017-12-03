package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class NoSuchImageException extends ParseCancellationException {

    public NoSuchImageException(String path) {
        super(path);
    }
}
