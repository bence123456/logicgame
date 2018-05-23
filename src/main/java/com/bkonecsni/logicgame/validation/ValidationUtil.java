package com.bkonecsni.logicgame.validation;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.TileBase;

import java.awt.*;
import java.util.*;
import java.util.List;

public class  ValidationUtil {

    public static Map<String, List<Class>> validationFuncNameParamsMap;

    public static Map<String, List<Class>> getValidationFuncNameParamsMap() {
        if (validationFuncNameParamsMap == null) {
            validationFuncNameParamsMap = new HashMap<>();
            validationFuncNameParamsMap.put("getRowNumber", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getColumnNumber", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getPlayableRowNumber", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getPlayableColumnNumber", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getFirstPlayableColumnIndex", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getFirstPlayableRowIndex", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getTile", Arrays.asList(Integer.class, Integer.class));
            validationFuncNameParamsMap.put("getTilesFromRow", Arrays.asList(Integer.class));
            validationFuncNameParamsMap.put("getTilesFromColumn", Arrays.asList(Integer.class));
            validationFuncNameParamsMap.put("getColorList", Collections.EMPTY_LIST);
            validationFuncNameParamsMap.put("getTilesForColor", Arrays.asList(Color.class));
            validationFuncNameParamsMap.put("getNeighboursForTile", Arrays.asList(TileBase.class));
            validationFuncNameParamsMap.put("getTilesWithGivenItem", Arrays.asList(Item.class));
            validationFuncNameParamsMap.put("numberOfItemsInAllRow", Arrays.asList(Item.class, Integer.class));
            validationFuncNameParamsMap.put("numberOfItemsInAllColumn", Arrays.asList(Item.class, Integer.class));
            validationFuncNameParamsMap.put("numberOfItemsInAllAreaWithSameColor", Arrays.asList(Item.class, Integer.class));
            validationFuncNameParamsMap.put("twoNeighbouringSymbolsExists", Arrays.asList(Item.class));
            validationFuncNameParamsMap.put("neighboursHaveCorrectNumberOfItems", Arrays.asList(Item.class));
        }

        return validationFuncNameParamsMap;
    }
}
