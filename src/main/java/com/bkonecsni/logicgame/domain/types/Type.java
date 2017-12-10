package com.bkonecsni.logicgame.domain.types;

import java.util.ArrayList;
import java.util.List;

public class Type {

    private List<TypeStatement> typeStatementList;

    public Type(List<TypeStatement> typeStatementList) {
        this.typeStatementList = typeStatementList;
    }

    public boolean isBorderType() {
        return typeStatementList == null;
    }

    public boolean isUnmutableType() {
        return typeStatementList != null && typeStatementList.isEmpty();
    }

    public List<TypeStatement> getTypeStatementList() {
        return typeStatementList;
    }

    public void setTypeStatementList(List<TypeStatement> typeStatementList) {
        this.typeStatementList = typeStatementList;
    }

}
