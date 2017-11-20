package com.bkonecsni.logicgame.domain.common;

public class Item {

    private Character charValue;

    private Integer intValue;

    private String symbol;

    private Integer color;

    public Item(Character charValue, Integer intValue, String symbol, Integer color) {
        this.charValue = charValue;
        this.intValue = intValue;
        this.symbol = symbol;
        this.color = color;
    }

    public Item replaceFields(Item newItem) {
        Character newCharValue = newItem.getCharValue();
        Integer newIntValue = newItem.getIntValue();
        String newSymbol = newItem.getSymbol();
        Integer newColor = newItem.getColor();

        setFields(newCharValue, newIntValue, newSymbol, newColor);

        return this;
    }

    private void setFields(Character charValue, Integer intValue, String symbol, Integer color) {
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

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
