package com.group19.coffeeShop;

import java.util.ArrayList;
import static com.group19.coffeeShop.Consts.*;

/**
 * Represents a Coffee-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Coffee extends MenuItem implements Customizable
{
    //object fields
    private String size;
    private ArrayList<String> addIns;

    /**
     * Default constructor.
     */
    public Coffee() {
        super();
        size = EMPTY;
        addIns = new ArrayList<>();
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param s String value, coffee size
     * @param a ArrayList of Strings, coffee add-ins
     */
    public Coffee(double p, String s, ArrayList<String> a) {
        super(p);
        size = s;
        addIns = a;
    }

    /**
     * Getter for Coffee size.
     * @return String value, size of coffee
     */
    public String getSize(){
        return size;
    }

    /**
     * Setter for Coffee size.
     * @param s String value, size of coffee
     */
    public void setSize(String s){
        this.size = s;
    }

    /**
     * Getter for List of add-ins.
     * @return ArrayList of Strings, add-in values
     */
    public ArrayList<String> getAddIn() {
        return addIns;
    }

    /**
     * Setter for List of add-ins.
     * @param a ArrayList of Strings, add-in values
     */
    public void setAddIn(ArrayList<String> a) {
        this.addIns = a;
    }

    /**
     * Getter for price of this Coffee.
     * @return super.price field value
     */
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Setter for periodEarnings of this Coffee.
     * @param p value to set super.price to
     */
    @Override
    public void setPrice(double p) {
        super.setPrice(p);
    }

    /**
     * Assigns the price for this Donut item.
     */
    @Override
    public void itemPrice() {
        double price = ZERO;
        switch (size) {
            case SHORT -> price += BASE_PRICE;
            case TALL -> price += BASE_PRICE + SIZE_COST;
            case GRANDE -> price += BASE_PRICE + (DOUBLE * SIZE_COST);
            case VENTI -> price += BASE_PRICE + (TRIPLE * SIZE_COST);
        }
        price += ADD_IN_COST * addIns.toArray().length;
        setPrice(price);
    }

    /**
     * Implementing function from Customizable.
     * Adds an add-in option to this Coffee.
     * @param obj Object value to be added, given that it is both a String
     *            value and a valid type of add-in
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean add(Object obj) {
        //obj must be casted before it can be added to an ArrayList
        //of String values.
        if (obj instanceof String)
            return addIns.add((String) obj);
        return false;
    }

    /**
     * Implementing function from Customizable.
     * Removes an add-in option from this Coffee.
     * @param obj Object value to be removed, given that it is both a String
     *            value and a valid type of add-in
     * @return boolean value, indicates the success of remove(Object)
     */
    @Override
    public boolean remove(Object obj) {
        //obj is implied to be String if we are even to remove its matching
        // value from the ArrayList, thus there is no casting necessary.
        if (obj instanceof String)
            return addIns.remove(obj);
        return false;
    }

    /**
     * Returns a String containing current Coffee details.
     * @return String value, Coffee details
     */
    @Override
    public String toString() {
        return size + " Coffee, with " + printAddIns()
                + df.format(getPrice()) + ".";
    }

    /**
     * Returns a String of selected addIns.
     * @return String value, addIn details
     */
    private String printAddIns() {
        StringBuilder result = new StringBuilder();
        for (String s : addIns)
        {
            result.append(s).append(", ");
        }
        return result.toString();
    }
}
