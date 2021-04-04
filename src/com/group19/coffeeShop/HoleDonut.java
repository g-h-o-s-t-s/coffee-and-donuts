package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.HOLE_PRICE;
import static com.group19.coffeeShop.Consts.df;

/**
 * Represents a HoleDonut-type MenuItem.
 @author Sagnik Mukherjee, Michael Choe
 */
public class HoleDonut extends MenuItem
{
    //object fields
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
        flavor = HDFlavor.POWDERED;
    }

    /**
     * Parameterized constructor.
     * @param p double value, price, assigned w/ super method
     * @param f String value, donut flavor
     */
    public HoleDonut(double p, HDFlavor f) {
        super(p);
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
    public void setFlavor(HDFlavor f) {
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
        setPrice(HOLE_PRICE);
    }

    /**
     * Returns a String containing current HoleDonut details.
     * @return String value, HoleDonut details
     */
    @Override
    public String toString() {
        return "Hole Donut, " + flavor + " Flavor, "
                + df.format(getPrice()) + ".";
    }
}
