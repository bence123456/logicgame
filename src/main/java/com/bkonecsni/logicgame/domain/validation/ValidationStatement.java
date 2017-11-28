package com.bkonecsni.logicgame.domain.validation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class ValidationStatement {

    private String methodName;

    private List<Item> methodParams;

    private boolean expectedValue;

    public ValidationStatement(String methodName, List<Item> methodParams, boolean expectedValue) {
        this.methodName = methodName;
        this.methodParams = methodParams;
        this.expectedValue = expectedValue;
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

    public boolean getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(boolean expectedValue) {
        this.expectedValue = expectedValue;
    }
}
