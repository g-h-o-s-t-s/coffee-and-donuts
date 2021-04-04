package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Object superclass for all menu item types.
 @author Sagnik Mukherjee, Michael Choe
 */
public abstract class MenuItem
{
    //object fields
    private double price;

    /**
     * Default constructor.
     */
    public MenuItem() {
        price = ZERO;
    }

    /**
     * Parameterized constructor.
     * @param p price to be assigned to MenuItem
     */
    public MenuItem(double p) {
        price = p;
    }

    /**
     * Getter for MenuItem price field.
     * @return double value for price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for MenuItem price field.
     * @param p double value to set price to
     */
    public void setPrice(double p) {
        price = p;
    }

    /**
     * Abstract method to be implemented by subclasses as needed.
     */
    public abstract void itemPrice();

    /**
     * Abstract method to be implemented by subclasses as needed.
     * @return String value, detailed contents of this MenuItem.
     */
    @Override
    public abstract String toString();
}
