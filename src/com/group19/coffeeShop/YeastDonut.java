package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.YEAST_PRICE;
import static com.group19.coffeeShop.Consts.df;

/**
 * Represents a YeastDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class YeastDonut extends MenuItem
{
    //object fields
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
        flavor = YDFlavor.OLD_FASHIONED;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param f String value, donut flavor
     */
    public YeastDonut(double p, YDFlavor f) {
        super(p);
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
    public void setFlavor(YDFlavor f) {
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
        setPrice(YEAST_PRICE);
    }

    /**
     * Returns a String containing current YeastDonut details.
     * @return String value, YeastDonut details
     */
    @Override
    public String toString() {
        return "Yeast Donut, " + flavor + " Flavor, "
                + df.format(getPrice()) + ".";
    }
}
