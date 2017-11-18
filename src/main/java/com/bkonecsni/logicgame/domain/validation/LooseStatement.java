package com.bkonecsni.logicgame.domain.validation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class LooseStatement extends ValidationStatement {

    public LooseStatement(String methodName, List<Item> methodParams) {
        super(methodName, methodParams);
    }

    @Override
    protected boolean getExpectedValue() {
        return false;
    }
}
