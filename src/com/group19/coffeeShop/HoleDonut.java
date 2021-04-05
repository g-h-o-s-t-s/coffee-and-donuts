package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents a HoleDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class HoleDonut extends Donut
{
    //object fields
    private int amount;
    private HDFlavor flavor;
    public enum HDFlavor {
        PUMPKIN_SPICE,
        CHOCOLATE_GLAZE,
        POWDERED
    }

    /**
     * Default constructor.
     */
    public HoleDonut() {
        super();
        amount = 0;
        flavor = HDFlavor.POWDERED;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param a int value, number of donuts
     * @param f String value, donut flavor
     */
    public HoleDonut(double p, int a, HDFlavor f) {
        super(p);
        amount = a;
        flavor = f;
    }

    /**
     * Getter for donut flavor.
     * @return enum value, flavor of donut
     */
    public HDFlavor getFlavor() {
        return flavor;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = HDFlavor.valueOf((String) f);
    }

    /**
     * Getter for donut amount.
     * @return int value, number of donuts
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter for donut amount.
     * @param a int value, number of donuts
     */
    public void setAmount(int a) {
        amount = a;
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
     * Assigns the price for this Donut item.
     */
    @Override
    public void itemPrice() {
        setPrice(HOLE_PRICE * amount);
    }

    /**
     * Returns a String containing current HoleDonut details.
     * @return String value, HoleDonut details
     */
    @Override
    public String toString() {
        return "Hole Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(HOLE_PRICE)
                + " each, " + df.format(getPrice()) + ".";
    }

    /**
     * Compares two objects of this type and determines their equality.
     * @return boolean value, true if objects equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof HoleDonut that)) {
            return false;
        }

        //'==' is better for null-safety for enum types.
        return Double.compare(this.getPrice(), that.getPrice()) == 0
                && this.getAmount() == that.getAmount()
                && this.flavor == that.flavor;
    }
}
