package com.bkonecsni.logicgame.visitors.statementlist;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.bkonecsni.logicgame.visitors.statementlist.SupportedOperator.*;

public enum SupportedType {

    MAP(LevelBase.class, Collections.EMPTY_LIST),
    TILE(TileBase.class, Collections.EMPTY_LIST),
    ITEM(Item.class, Collections.EMPTY_LIST),
    STRING(String.class, Arrays.asList(PLUS, PLUSEQUALS)),
    BOOL(boolean.class, Arrays.asList(EQUALS, NOTEQUALS, AND, OR)),
    CHAR(Character.class, Collections.EMPTY_LIST),
    INT(int.class, Arrays.asList(EQUALS, GREATER, LESS, GREATEREQUALS, LESSEQUALS, NOTEQUALS, PLUS, MINUS, PLUSEQUALS, MINUSEQUALS, DIV, MUL)),
    LIST(List.class, Collections.EMPTY_LIST);

    private Class clazz;
    private List<SupportedOperator> supportedOperators;

    SupportedType(Class clazz, List<SupportedOperator> supportedOperators) {
        this.clazz = clazz;
        this.supportedOperators = supportedOperators;
    }

    public Class getClazz() {
        return clazz;
    }

    public List<SupportedOperator> getSupportedOperators() {
        return supportedOperators;
    }

    @Override
    public String toString() {
        return clazz.getName();
    }

    public static SupportedType fromString(String text) {
        for (SupportedType supportedType : SupportedType.values()) {
            if (supportedType.clazz.getSimpleName().equals(text)) {
                return supportedType;
            }
        }
        return null;
    }
}
