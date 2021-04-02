package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents an order of a Donut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Donut extends MenuItem implements Customizable
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

    public Donut(double p, String t, String f){
        super(p);
        type = t;
        flavor = f;
    }

    public String getType(){
        return type;
    }

    public void setType(String t){
        type = t;
    }

    public String getFlavor(){
        return flavor;
    }

    public void setFlavor(String f){
        flavor = f;
    }


    public void itemPrice() {
        double price = 0.0;
        if(type.equals(Consts.TYPE1)){
            price += Consts.YEAST_PRICE;
        }else if(type.equals(Consts.TYPE2)){
            price += Consts.CAKE_PRICE;
        }else if(type.equals(Consts.TYPE3)){
            price += Consts.HOLE_PRICE;
        }
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
