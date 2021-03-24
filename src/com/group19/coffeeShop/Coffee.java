package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.EMPTY;

/**
 * Represents an order of a Coffee-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Coffee extends MenuItem
{
    //object fields
    private String size;
    private String addIn;

    /*
     * Default constructor.
     */
    public Coffee() {
        super();
        size = EMPTY;
        addIn = EMPTY;
    }

    public void itemPrice() {

    }


}
