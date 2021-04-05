package com.group19.coffeeShop;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The Consts class houses all immutable constant values.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
public class Consts
{
    /* Constants which appear in multiple classes */
    public static final DecimalFormat df
            = new DecimalFormat("$#,##0.00");
    public static final String EMPTY = "";
    public static final double salesTax = 0.06625;
    public static final double ZERO = 0.0;

    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;
    public static final int REDUCED_WIDTH = 960,
            REDUCED_HEIGHT = 540;


    /* Controller() constants */
    public static final String SELECTED = "File selected: ";


    /* StoreOrders() constants */
    public static final int DEFAULT = 1;


    /* Donut() constants */
    public static final double YEAST_PRICE = 1.39,
            CAKE_PRICE = 1.59, HOLE_PRICE = 0.33;
    public static final String TYPE1 = "CakeDonut", TYPE2 = "HoleDonut",
            TYPE3  = "YeastDonut";


    /* Coffee() constants */
    public static final double BASE_PRICE = 1.99,
            ADD_IN_COST = 0.20, SIZE_COST = 0.50;
    public static final double DOUBLE = 2, TRIPLE = 3;
    public static final String SHORT = "Short", TALL = "Tall",
            GRANDE = "Grande", VENTI = "Venti";
    public static final String ADD1 = "cream", ADD2 = "syrup",
            ADD3 = "milk", ADD4 = "caramel", ADD5 = "whipped cream";


    /* Order() constants */


    /* StoreOrders() constants */


    /**
     * Constructor prevents other classes from instantiating objects of
     * type Consts when calling this class.
     */
    private Consts() {
        throw new AssertionError();
    }
}
