package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

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
        double price = 0.0;
        if(size == Consts.SHORT) {
            price += Consts.BASE_PRICE;
        }else if(size == Consts.TALL) {
            price += Consts.BASE_PRICE + Consts.SIZE_COST;
        }else if(size == Consts.GRANDE) {
            price += Consts.BASE_PRICE + (Consts.DOUBLE * Consts.SIZE_COST);
        }else if(size == Consts.VENTI){
            price += Consts.BASE_PRICE + (Consts.TRIPLE * Consts.SIZE_COST);
        }
        if(addIn == Consts.ADD1 || addIn == Consts.ADD2 || addIn == Consts.ADD3 || addIn == Consts.ADD4 || addIn == Consts.ADD5) {
            price += Consts.ADD_IN_COST;
        }
    }


}
