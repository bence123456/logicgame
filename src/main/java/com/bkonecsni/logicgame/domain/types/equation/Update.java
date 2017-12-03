package com.bkonecsni.logicgame.domain.types.equation;

import com.bkonecsni.logicgame.domain.common.Item;

import java.util.List;

public class Update extends Equation{

    public Update(Integer itemToUpdateIndex, Item newItem) {
        super(itemToUpdateIndex, newItem);
    }

    public void execute(List<Item> itemList) {
        Integer itemToUpdateIndex = getLeftItemIndex();
        Item newItem = getRightItem();

        if (itemToUpdateIndex == itemList.size()) {
            itemList.add(newItem);
        } else {
            Item oldItem = itemList.get(itemToUpdateIndex);

            // ItemList(x) = empty
            if (newItem == null) {
                itemList.remove(oldItem);
            } else {
                oldItem.replaceFields(newItem);
            }
        }
    }
}
