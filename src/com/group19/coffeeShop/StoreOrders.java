package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents a list of Orders placed by user throughout program runtime.
 @author Sagnik Mukherjee, Michael Choe
 */
public class StoreOrders implements Customizable
{
    //object fields
    private Order[] orderList;
    private int numOrders;

    /**
     * Default constructor.
     */
    public StoreOrders() {
        orderList = new Order[DEFAULT];
        numOrders = 0;
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
