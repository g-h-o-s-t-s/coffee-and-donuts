package com.group19.coffeeShop;

import java.util.ArrayList;

/**
 * Represents a list of Orders placed by user throughout program runtime.
 @author Sagnik Mukherjee, Michael Choe
 */
public class StoreOrders implements Customizable
{
    //object fields
    private ArrayList<Order> orderList;

    /**
     * Default constructor.
     */
    public StoreOrders() {
        orderList = null;
    }

    /**
     * Parameterized constructor.
     * @param l ArrayList of Orders, overall list of order history
     */
    public StoreOrders(ArrayList<Order> l) {
        orderList = l;
    }

    /**
     * Getter for List of Orders.
     * @return ArrayList of Orders
     */
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    /**
     * Setter for List of Orders.
     * @param a ArrayList of Orders
     */
    public void setOrderList(ArrayList<Order> a) {
        this.orderList = a;
    }

    /**
     * Implementing function from Customizable.
     * Adds an Order to this StoreOrders object.
     * @param obj Object value to be added, given that it is an Order
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order)
            return orderList.add((Order) obj);
        return false;
    }

    /**
     * Implementing function from Customizable.
     * Removes an Order from this StoreOrders object.
     * @param obj Object value to be added, given that it is an Order
     * @return boolean value, indicates the success of add(Object)
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order)
            return orderList.remove(obj);
        return false;
    }

    /**
     * Returns a String containing StoreOrders' Orders.
     * @return String value, concatenates Orders' toString results
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Order o : orderList)
        {
            result.append(o.toString()).append("\n\n");
        }
        return result.toString();
    }
}
