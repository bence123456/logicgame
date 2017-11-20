package com.bkonecsni.logicgame.domain.types;

import java.util.List;

public class Types<T extends Type> {

    private List<T> typeList;

    public Types(List<T> typeList) {
        this.typeList = typeList;
    }

    public void addType(T type) {
        typeList.add(type);
    }

    public List<T> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<T> typeList) {
        this.typeList = typeList;
    }
}
