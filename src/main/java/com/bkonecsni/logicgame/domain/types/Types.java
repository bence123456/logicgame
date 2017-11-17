package com.bkonecsni.logicgame.domain.types;

import java.util.List;

public class Types<T extends Type> {

    List<T> typeList;

    public List<T> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<T> typeList) {
        this.typeList = typeList;
    }
}
