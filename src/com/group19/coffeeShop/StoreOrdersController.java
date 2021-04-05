package com.group19.coffeeShop;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class associated with StoreOrdersView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
public class StoreOrdersController
{
    @FXML private TextField totalText;
    @FXML private ListView<String> displayOrderList = new ListView<>();
    @FXML private ComboBox<String> orderList;
}
