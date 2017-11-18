package com.bkonecsni.logicgame.domain.validation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public abstract class ValidationStatement {

    private String methodName;

    // TODO: introduce "area def" somehow
    private List<Item> methodParams;

    protected abstract boolean getExpectedValue();

    public ValidationStatement(String methodName, List<Item> methodParams) {
        this.methodName = methodName;
        this.methodParams = methodParams;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Item> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(List<Item> methodParams) {
        this.methodParams = methodParams;
    }
}
