package com.bkonecsni.logicgame.interfaces.map;

import com.bkonecsni.logicgame.interfaces.Item;
import java.awt.Point;
import java.util.List;

public interface ITile {

    Point getPosition();

    void setPosition(Point position);

    Point getSize();

    void setSize(Point size);

    List<Item> getItemList();

    void setItemList(List<Item> itemList);

    void onClick();
}
