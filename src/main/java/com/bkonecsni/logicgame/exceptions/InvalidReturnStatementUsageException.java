package com.bkonecsni.logicgame.exceptions;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class InvalidReturnStatementUsageException extends ParseCancellationException {

    public InvalidReturnStatementUsageException() {
        super("Return statement cannot be used in types declaration!");
    }
}
