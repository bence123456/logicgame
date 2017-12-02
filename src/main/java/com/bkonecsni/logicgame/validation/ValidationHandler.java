package com.bkonecsni.logicgame.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.GameMap;
import com.bkonecsni.logicgame.domain.validation.ValidationStatement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ValidationHandler {

    public boolean isValid(GameMap map, List<ValidationStatement> winStatementList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        for (ValidationStatement winStatement : winStatementList) {
            String methodName = winStatement.getMethodName();
            List<Item> methodParams = winStatement.getMethodParams();
            boolean expectedValue = winStatement.getExpectedValue();

            Method method = ValidationMethods.class.getMethod(methodName);
            boolean isValid = (boolean) method.invoke(map, methodParams) == expectedValue;

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

}
