package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents a list of MenuItems ordered by user.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Order implements Customizable
{
    //object fields
    private MenuItem[] itemList;
    private int numItems;
    private int orderID;

    /**
     * Default constructor.
     */
    public Order() {
        itemList = new MenuItem[DEFAULT];
        numItems = 0;
        orderID = 0;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
