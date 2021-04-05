package com.group19.coffeeShop;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

import static com.group19.coffeeShop.Consts.*;

/**
 * Controller class associated with DonutsView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
public class DonutsController
{
    /* -- Data Fields. -- */
    static Order tempOrder = new Order();
    static Donut tempDonut;

    //JavaFX Node element handles.
    public ComboBox<String> donutType;
    public ListView<String> flavors = new ListView<>();
    public Button addButton;
    public Button removeButton;
    public ListView<String> currentDonuts = new ListView<>();
    public TextField quantityText;
    public TextArea subtotalText;
    public Button addToOrderButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Links Action Events to related JavaFX nodes.
     */
    public void initialize() {
        quantityText.setDisable(true);
        addButton.setDisable(true);

        donutType.getItems().addAll(TYPE1, TYPE2, TYPE3);
        donutType.setOnAction((event) -> showFlavors());
        //Each donut type has a default flavor, so clicking on
        //this when empty and adding that way still works.
        flavors.setOnMouseClicked((event) -> enableQuantity());
        quantityText.setOnKeyTyped((event) -> addButton.setDisable(false));

        addButton.setOnMouseClicked((event) -> addDonut());
        removeButton.setOnMouseClicked((event) -> removeDonut());
        addToOrderButton.setOnMouseClicked((event) -> addToOrder());
    }

    /**
     * Event function to show specific flavors depending on donut type.
     */
    private void showFlavors() {
        //Getting the values of the enum proved difficult w/o convoluted
        //regex. This is the most readable solution.
        String selected = donutType.getValue();
        switch (selected) {
            case TYPE1 -> {
                tempDonut = new CakeDonut();
                flavors.getItems().clear();
                flavors.getItems().addAll(
                        String.valueOf(CakeDonut.CDFlavor.BOSTON_KREME),
                        String.valueOf(CakeDonut.CDFlavor.JELLY),
                        String.valueOf(CakeDonut.CDFlavor.STRAWBERRY));
            }
            case TYPE2 -> {
                tempDonut = new HoleDonut();
                flavors.getItems().clear();
                flavors.getItems().addAll(
                        String.valueOf(HoleDonut.HDFlavor.CHOCOLATE_GLAZE),
                        String.valueOf(HoleDonut.HDFlavor.POWDERED),
                        String.valueOf(HoleDonut.HDFlavor.PUMPKIN_SPICE));
            }
            case TYPE3 -> {
                tempDonut = new YeastDonut();
                flavors.getItems().clear();
                flavors.getItems().addAll(
                        String.valueOf(YeastDonut.YDFlavor.CHOCOLATE),
                        String.valueOf(YeastDonut.YDFlavor.OLD_FASHIONED),
                        String.valueOf(YeastDonut.YDFlavor.VANILLA_GLAZE));
            }
            default -> MenuController.throwAlert("Illegal value.");
        }
    }

    /**
     * Event function to temporarily add Donut.
     * User cannot add same type twice in a row without switching
     * back and forth between types first.
     */
    private void addDonut() {
        try {
            setDonut();
            tempOrder.add(tempDonut);

            resetSelections();
            refreshTextFields();
        } catch (NumberFormatException | NullPointerException ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Quick helper to reset flavors and quantity, disable quantity.
     */
    private void resetSelections() {
        //forces user to start over each time
        tempDonut = null;
        flavors.getItems().clear();
        quantityText.setText("");
        quantityText.setDisable(true);
    }

    /**
     * Event function to remove most recently-added donut.
     */
    private void removeDonut() {
        try {
            setDonut();
            tempOrder.remove(tempDonut);

            refreshTextFields();
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Helper to create a new Donut object according to user input.
     */
    private void setDonut() {
        switch (donutType.getValue()) {
            case TYPE1 -> tempDonut = new CakeDonut();
            case TYPE2 -> tempDonut = new HoleDonut();
            case TYPE3 -> tempDonut = new YeastDonut();
        }

        tempDonut.setAmount(Integer.parseInt(quantityText.getText()));
        tempDonut.setFlavor(
                flavors.getSelectionModel().getSelectedItem());
        tempDonut.itemPrice();
    }

    /**
     * Update the contents of currentDonuts and subtotalText.
     */
    private void refreshTextFields() {
        currentDonuts.getItems().clear();
        currentDonuts.getItems().addAll(
                tempOrder.toString().split("\n"));
        tempOrder.orderPrice();
        double subtotal = tempOrder.getOrderCost();
        subtotalText.setText(df.format(subtotal));
    }

    /**
     * Event function to finalize and add current Donut choices to an Order.
     */
    private void addToOrder() {
        try {
            if (tempOrder != null) {
                MenuController.mainOrder = tempOrder;
                Stage stage = (Stage) addToOrderButton.getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Event function to show quantity and set flavor/price for tempDonut.
     */
    private void enableQuantity() {
        quantityText.setDisable(false);
    }


}
