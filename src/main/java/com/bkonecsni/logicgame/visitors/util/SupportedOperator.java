package com.bkonecsni.logicgame.visitors.util;

public enum SupportedOperator {

    EQUALS("=="),
    GREATER(">"),
    LESS("<"),
    GREATEREQUALS(">="),
    LESSEQUALS("<="),
    NOTEQUALS("!="),
    PLUS("+"),
    MINUS("-"),
    PLUSEQUALS("+="),
    MINUSEQUALS("-="),
    AND("&&"),
    OR("||");

    private String stringValue;

    SupportedOperator(String stringValue) {
        this.stringValue = stringValue;
    }
}