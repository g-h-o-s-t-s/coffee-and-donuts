package com.group19.coffeeShop;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.Arrays;
import static com.group19.coffeeShop.Consts.df;

/**
 * Controller class associated with OrderView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("FieldMayBeFinal")
public class OrderController
{
    /* -- Data Fields. -- */
    //JavaFX Node element handles.
    @FXML private TextArea subtotalText;
    @FXML private TextArea salesTaxText;
    @FXML private TextArea totalText;
    @FXML private ListView<String> currentItems = new ListView<>();

    @FXML private Button removeItemButton;
    @FXML private Button placeOrderButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Links Action Events to related JavaFX nodes.
     */
    public void initialize() {
        //calculate and display Order subtotal/tax/total
        updateFields();

        removeItemButton.setOnMouseClicked((event) -> removeMenuItem());
        placeOrderButton.setOnMouseClicked((event) -> placeOrder());
    }

    /**
     * Event function to add Order to overall StoreOrders.
     */
    private void placeOrder() {
        try {
            if (MenuController.mainOrder != null) {
                MenuController.mainStoreOrder.add(MenuController.mainOrder);
                MenuController.mainOrder = new Order();

                Stage stage = (Stage) placeOrderButton.getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Event function to remove the selected MenuItem from currentItems.
     * No action will occur if ListView has no selected item.
     */
    private void removeMenuItem() {
        try {
            if (!currentItems.getSelectionModel().isEmpty()) {
                int selected =
                        currentItems.getSelectionModel().getSelectedIndex();
                MenuController.mainOrder.getItemList().remove(selected);

                updateFields();
            }
        } catch(Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Helper to update the textArea/listView displays in real-time (ideally).
     */
    private void updateFields() {
        MenuController.mainOrder.orderPrice();
        updateTexts();

        //populate currentItems listView with all MenuItem
        //object details, but leave off the last line
        //which just reports the order's price field values
        currentItems.getItems().clear();
        String[] temp = MenuController.mainOrder.toString().split("\n");
        temp = Arrays.copyOf(temp, temp.length - 1);
        currentItems.getItems().addAll(temp);
    }

    /**
     * Another helper to update textAreas specifically.
     */
    private void updateTexts() {
        subtotalText.setText(String.valueOf(
                df.format(MenuController.mainOrder.getSubtotal())));
        salesTaxText.setText(String.valueOf(
                df.format(MenuController.mainOrder.getTax())));
        totalText.setText(String.valueOf(
                df.format(MenuController.mainOrder.getTotal())));
    }
}
