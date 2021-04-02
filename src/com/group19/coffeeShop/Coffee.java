package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents an order of a Coffee-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Coffee extends MenuItem implements Customizable
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

    public Coffee(double p, String s, String a){
        super(p);
        size = s;
        addIn = a;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String s){
        size = s;
    }

    public String getAddIn(){
        return addIn;
    }

    public void setAddIn(String a){
        addIn = a;
    }

    public void itemPrice() {
        double price = Consts.ZERO;
        if(size.equals(Consts.SHORT)) {
            price += Consts.BASE_PRICE;
        }else if(size.equals(Consts.TALL)) {
            price += Consts.BASE_PRICE + Consts.SIZE_COST;
        }else if(size.equals(Consts.GRANDE)) {
            price += Consts.BASE_PRICE + (Consts.DOUBLE * Consts.SIZE_COST);
        }else if(size.equals(Consts.VENTI)){
            price += Consts.BASE_PRICE + (Consts.TRIPLE * Consts.SIZE_COST);
        }
        if(addIn.equals(Consts.ADD1) || addIn.equals(Consts.ADD2) || addIn.equals(Consts.ADD3) || addIn.equals(Consts.ADD4) || addIn.equals(Consts.ADD5)) {
            price += Consts.ADD_IN_COST;
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
