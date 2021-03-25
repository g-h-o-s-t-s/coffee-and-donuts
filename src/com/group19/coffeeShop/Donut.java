package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents an order of a Donut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Donut extends MenuItem
{
    //object fields
    private String type;
    private String flavor;

    /*
     * Default constructor.
     */
    public Donut() {
        super();
        type = EMPTY;
        flavor = EMPTY;
    }

    public void itemPrice() {
        double price = 0.0;
        if(type == Consts.TYPE1){
            price += Consts.YEAST_PRICE;
        }else if(type == Consts.TYPE2){
            price += Consts.CAKE_PRICE;
        }else if(type == Consts.TYPE3){
            price += Consts.HOLE_PRICE;
        }

    }
    
}
