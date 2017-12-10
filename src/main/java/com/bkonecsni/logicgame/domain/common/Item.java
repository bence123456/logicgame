package com.bkonecsni.logicgame.domain.common;

import java.awt.*;

public class Item {

    private Character charValue;

    private Integer intValue;

    private String symbol;

    private Color color;

    public Item(Character charValue, Integer intValue, String symbol, Color color) {
        this.charValue = charValue;
        this.intValue = intValue;
        this.symbol = symbol;
        this.color = color;
    }

    private void setFields(Character charValue, Integer intValue, String symbol, Color color) {
        this.charValue = charValue;
        this.intValue = intValue;
        this.symbol = symbol;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (charValue != null ? !charValue.equals(item.charValue) : item.charValue != null) return false;
        if (intValue != null ? !intValue.equals(item.intValue) : item.intValue != null) return false;
        if (symbol != null ? !symbol.equals(item.symbol) : item.symbol != null) return false;
        return color != null ? color.equals(item.color) : item.color == null;
    }

    @Override
    public int hashCode() {
        int result = charValue != null ? charValue.hashCode() : 0;
        result = 31 * result + (intValue != null ? intValue.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    public Character getCharValue() {
        return charValue;
    }

    public void setCharValue(Character charValue) {
        this.charValue = charValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
