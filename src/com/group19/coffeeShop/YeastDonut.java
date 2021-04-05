package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;

/**
 * Represents a YeastDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class YeastDonut extends Donut
{
    //object fields
    private int amount;
    private YDFlavor flavor;
    public enum YDFlavor {
        VANILLA_GLAZE,
        CHOCOLATE,
        OLD_FASHIONED
    }

    /**
     * Default constructor.
     */
    public YeastDonut() {
        super();
        amount = 0;
        flavor = YDFlavor.OLD_FASHIONED;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param a int value, number of donuts
     * @param f String value, donut flavor
     */
    public YeastDonut(double p, int a, YDFlavor f) {
        super(p);
        amount = a;
        flavor = f;
    }

    /**
     * Getter for donut flavor.
     * @return enum value, flavor of donut
     */
    public YDFlavor getFlavor() {
        return flavor;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = YDFlavor.valueOf((String) f);
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
        setPrice(YEAST_PRICE * amount);
    }

    /**
     * Returns a String containing current YeastDonut details.
     * @return String value, YeastDonut details
     */
    @Override
    public String toString() {
        return "Yeast Donut, " + flavor + " Flavor, " + amount +
                " @ " + df.format(YEAST_PRICE) +
                " each, " + df.format(getPrice()) + ".";
    }

    /**
     * Compares two objects of this type and determines their equality.
     * @return boolean value, true if objects equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof YeastDonut that)) {
            return false;
        }

        //'==' is better for null-safety for enum types.
        return Double.compare(this.getPrice(), that.getPrice()) == 0
                && this.getAmount() == that.getAmount()
                && this.flavor == that.flavor;
    }
}
