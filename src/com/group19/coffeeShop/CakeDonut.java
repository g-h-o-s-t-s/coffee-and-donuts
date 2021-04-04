package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.CAKE_PRICE;
import static com.group19.coffeeShop.Consts.df;

/**
 * Represents a CakeDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CakeDonut extends MenuItem
{
    //object fields
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
        flavor = CDFlavor.JELLY;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param f String value, donut flavor
     */
    public CakeDonut(double p, CDFlavor f) {
        super(p);
        flavor = f;
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
    public void setFlavor(CDFlavor f) {
        flavor = f;
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
     * Setter for periodEarnings of this Donut.
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
        setPrice(CAKE_PRICE);
    }

    /**
     * Returns a String containing current CakeDonut details.
     * @return String value, CakeDonut details
     */
    @Override
    public String toString() {
        return "Cake Donut, " + flavor + " Flavor, "
                + df.format(getPrice()) + ".";
    }
}
