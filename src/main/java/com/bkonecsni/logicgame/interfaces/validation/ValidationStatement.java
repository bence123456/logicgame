package com.bkonecsni.logicgame.interfaces.validation;

import com.bkonecsni.logicgame.interfaces.Item;

import java.util.List;

public interface ValidationStatement {

    String getMethodName();

    void setMethodName(String methodName);

    List<Item> getMethodParams();

    void setMethodParams(List<Item> methodParams);

    boolean getExpectedValue();

    void setExpectedValue(boolean expectedValue);
}
