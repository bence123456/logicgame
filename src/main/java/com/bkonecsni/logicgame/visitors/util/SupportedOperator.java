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

    public String getStringValue() {
        return stringValue;
    }

    public static SupportedOperator fromString(String text) {
        for (SupportedOperator supportedOperator : SupportedOperator.values()) {
            if (supportedOperator.getStringValue().equals(text)) {
                return supportedOperator;
            }
        }
        return null;
    }
}