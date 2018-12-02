package com.bkonecsni.logicgame.visitors.statementlist;

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
    OR("||"),
    DIV("/"),
    MUL("*");

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