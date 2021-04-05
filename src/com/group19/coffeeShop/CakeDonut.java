package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.CAKE_PRICE;
import static com.group19.coffeeShop.Consts.df;

/**
 * Represents a CakeDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CakeDonut extends Donut
{
    //object fields
    private int amount;
    private CDFlavor flavor;
    public enum CDFlavor {
        BOSTON_KREME,
        STRAWBERRY,
        JELLY
    }

    /**
     * Default constructor.
     */
    public CakeDonut() {
        super();
        amount = 0;
        flavor = CDFlavor.JELLY;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param a int value, number of donuts
     * @param f String value, donut flavor
     */
    public CakeDonut(double p, int a, CDFlavor f) {
        super(p);
        amount = a;
        flavor = f;
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
     * Getter for donut flavor.
     * @return enum value, flavor of donut
     */
    public CDFlavor getFlavor() {
        return flavor;
    }

    /**
     * Setter for donut flavor.
     * @param f enum value, flavor of donut
     */
    public void setFlavor(Object f) {
        if (f instanceof String)
            flavor = CDFlavor.valueOf((String) f);
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
        setPrice(CAKE_PRICE * amount);
    }

    /**
     * Returns a String containing current CakeDonut details.
     * @return String value, CakeDonut details
     */
    @Override
    public String toString() {
        return "Cake Donut, " + flavor + " Flavor, " + amount +
                "@" + CAKE_PRICE + " each, " + df.format(getPrice()) + ".";
    }

    /**
     * Compares two objects of this type and determines their equality.
     * @return boolean value, true if objects equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof CakeDonut that)) {
            return false;
        }

        //'==' is better for null-safety for enum types.
        return Double.compare(this.getPrice(), that.getPrice()) == 0
                && this.getAmount() == that.getAmount()
                && this.flavor == that.flavor;
    }
}
