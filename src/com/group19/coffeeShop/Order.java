package com.group19.coffeeShop;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a list of MenuItems ordered by user.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Order implements Customizable
{
    //object fields
    private double orderCost;
    private int orderID;
    private ArrayList<MenuItem> itemList;

    /**
     * Default constructor.
     */
    public Order() {
        orderCost = Consts.ZERO;
        orderID = 0;
        itemList = new ArrayList<>();
    }

    /**
     * Parameterized constructor.
     * @param c double value, cost of order
     * @param o int value, assigned sequentially based on StoreOrders
     *          controller, based on order of creation of objects
     * @param l ArrayList of MenuItems, Donuts and Coffees in this Order
     */
    public Order(double c, int o, ArrayList<MenuItem> l) {
        orderCost = c;
        orderID = o;
        itemList = l;
    }

    /**
     * Getter for Order cost.
     * @return double value, Order cost
     */
    public double getOrderCost(){
        return orderCost;
    }

    /**
     * Setter for Order cost.
     * @param c double value, Order cost
     */
    public void setOrderCost(int c) {
        this.orderCost = c;
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
    public void setSize(int id){
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
    public void setAddIn(ArrayList<MenuItem> a) {
        this.itemList = a;
    }

    /**
     * Calculates cost of order overall.
     */
    public void orderPrice() {
        double total = Consts.ZERO;
        for (MenuItem i : itemList)
            total += i.getPrice();
        orderCost = total;
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
        if (obj instanceof YeastDonut || obj instanceof CakeDonut ||
            obj instanceof HoleDonut || obj instanceof Coffee)
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
        if (obj instanceof YeastDonut || obj instanceof CakeDonut ||
                obj instanceof HoleDonut || obj instanceof Coffee)
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
        return result.toString();
    }
}
