package com.group19.coffeeShop;

/**
 * Donut superclass for three types of Donuts.
 @author Sagnik Mukherjee, Michael Choe
 */
public abstract class Donut extends MenuItem
{
    /**
     * Default constructor.
     */
    public Donut() {
        super();
    }

    /**
     * Parameterized constructor.
     * @param p price to be assigned to MenuItem
     */
    public Donut(double p) {
        super(p);
    }

    /**
     * Getter for price of this Donut.
     * @return super.price field value
     */
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    /**
     * Setter for price of this Donut.
     * @param p value to set super.price to
     */
    @Override
    public void setPrice(double p) {
        super.setPrice(p);
    }

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Gets amount of donuts for this object.
     */
    public abstract int getAmount();

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Sets amount of donuts for this object.
     */
    public abstract void setAmount(int amount);

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Gets donut flavor.
     */
    public abstract Object getFlavor();

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Sets donut flavor.
     */
    public abstract void setFlavor(Object o);

    /**
     * Abstract method to be implemented by subclasses as needed.
     * Calculates the price for a set of donuts.
     */
    public abstract void itemPrice();

    /**
     * Abstract method, toString for each Donut type.
     * @return String value, Donut contents
     */
    public abstract String toString();
}
