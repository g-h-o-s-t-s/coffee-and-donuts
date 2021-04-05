package com.group19.coffeeShop;

import static com.group19.coffeeShop.Consts.*;
import java.util.ArrayList;

/**
 * Represents a list of MenuItems ordered by user.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Order implements Customizable
{
    //object fields
    private double total;
    private double tax;
    private double subtotal;
    private int orderID;
    private ArrayList<MenuItem> itemList;

    /**
     * Default constructor.
     */
    public Order() {
        total = ZERO;
        tax = ZERO;
        subtotal = ZERO;
        orderID = 0;
        itemList = new ArrayList<>();
    }

    /**
     * Parameterized constructor.
     * @param to double value, order total
     * @param ta double value, tax total
     * @param s double value, subtotal before tax
     * @param o int value, assigned sequentially based on StoreOrders
     *          controller, based on order of creation of objects
     * @param l ArrayList of MenuItems, Donuts and Coffees in this Order
     */
    public Order(double to, double ta, double s,
            int o, ArrayList<MenuItem> l) {
        total = to;
        tax = ta;
        subtotal= s;
        orderID = o;
        itemList = l;
    }

    /**
     * Getter for Order total.
     * @return double value, Order total
     */
    public double getTotal(){
        return total;
    }

    /**
     * Getter for Order tax.
     * @return double value, Order tax
     */
    public double getTax(){
        return tax;
    }

    /**
     * Getter for Order subtotal.
     * @return double value, Order subtotal
     */
    public double getSubtotal(){
        return subtotal;
    }

    /**
     * Getter for Order ID.
     * @return int value, Order ID number
     */
    public int getOrderID(){
        return orderID;
    }

    /**
     * Setter for Order ID.
     * @param id int value, Order ID number
     */
    public void setOrderID(int id){
        this.orderID = id;
    }

    /**
     * Getter for List of MenuItems.
     * @return ArrayList of MenuItems, items in current order
     */
    public ArrayList<MenuItem> getItemList() {
        return itemList;
    }

    /**
     * Setter for List of MenuItems.
     * @param a ArrayList of MenuItems, items in current order
     */
    public void setItemList(ArrayList<MenuItem> a) {
        this.itemList = a;
    }

    /**
     * Calculates cost of order overall.
     */
    public void orderPrice() {
        double sub = Consts.ZERO;
        for (MenuItem i : itemList)
            sub += i.getPrice();
        subtotal = sub;

        tax = subtotal * SALES_TAX;
        total = subtotal + tax;
    }

    /**
     * Implementing function from Customizable.
     * Adds a MenuItem to this Order.
     * @param obj Object value to be added, given that it is both a MenuItem
     *            value and a valid type of Donut or Coffee; of course,
     *            having type Donut/Coffee implies having type MenuItem
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Donut || obj instanceof Coffee)
            return itemList.add((MenuItem) obj);
        return false;
    }

    /**
     * Implementing function from Customizable.
     * Removes a MenuItem from this Order.
     * @param obj Object value to be removed, given that it is
     *            a valid type of Donut or Coffee
     * @return boolean value, indicates the success of remove(Object)
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Donut || obj instanceof Coffee)
            return itemList.remove(obj);
        return false;
    }

    /**
     * Returns a String containing current Order details neatly.
     * @return String value, concatenates MenuItems' toString results
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (MenuItem m : itemList)
        {
            result.append(m.toString()).append("\n");
        }
        result.append("Subtotal ").append(df.format(subtotal))
            .append(", Tax ").append(df.format(tax)).append(", Total ")
            .append(df.format(total));
        return result.toString();
    }
}
