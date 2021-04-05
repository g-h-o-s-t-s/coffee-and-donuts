package com.group19.coffeeShop;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.group19.coffeeShop.Consts.*;

/**
 * Controller class associated with CoffeeView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CoffeeController
{
    /* -- Data Fields. -- */
    Coffee tempCoffee;

    //JavaFX Node element handles.
    @FXML private ToggleGroup size;
    @FXML private CheckBox creamBox;
    @FXML private CheckBox syrupBox;
    @FXML private CheckBox milkBox;
    @FXML private CheckBox caramelBox;
    @FXML private CheckBox whippedBox;
    @FXML private TextField subtotalText;
    @FXML private Button addToOrderButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Links Action Events to related JavaFX nodes.
     */
    public void initialize() {
        tempCoffee  = new Coffee();
        disableCheckboxes();
        addToOrderButton.setDisable(true);

        //Adds an Event Listener to the RadioButton ToggleGroup.
        //If any of the sizes are selected, the checkboxes are enabled.
        size.selectedToggleProperty().addListener(
                (observable, oldValue, newValue) -> {
            RadioButton r = (RadioButton) size.getSelectedToggle();

            if (r != null) {
                updateSize(r);
                enableCheckboxes();
            }
        });

        initCheckListeners();

        addToOrderButton.setOnMouseClicked((event) -> addToOrder());
    }

    /**
     * Helper to add on Event Listeners for each distinct CheckBox,
     * enables adding to the overall Order when clicked.
     */
    private void initCheckListeners() {
        creamBox.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateAddIn(creamBox);
                    addToOrderButton.setDisable(false);
                });

        syrupBox.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateAddIn(syrupBox);
                    addToOrderButton.setDisable(false);
                });

        milkBox.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateAddIn(milkBox);
                    addToOrderButton.setDisable(false);
                });

        caramelBox.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateAddIn(caramelBox);
                    addToOrderButton.setDisable(false);
                });

        whippedBox.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateAddIn(whippedBox);
                    addToOrderButton.setDisable(false);
                });
    }

    /**
     * Helper to disable checkboxes.
     */
    private void disableCheckboxes() {
        creamBox.setDisable(true);
        syrupBox.setDisable(true);
        milkBox.setDisable(true);
        caramelBox.setDisable(true);
        whippedBox.setDisable(true);
    }

    /**
     * Helper to enable checkboxes.
     */
    private void enableCheckboxes() {
        creamBox.setDisable(false);
        syrupBox.setDisable(false);
        milkBox.setDisable(false);
        caramelBox.setDisable(false);
        whippedBox.setDisable(false);
    }

    /**
     * Event function to set size of Coffee.
     * @param r RadioButton value, if selected
     */
    private void updateSize(RadioButton r) {
        String selected = r.getText();
        tempCoffee.setSize(selected);
        tempCoffee.itemPrice();
        updateSubtotal();
    }

    /**
     * Helper to update the AddIn for tempCoffee based on CheckBox values.
     * @param c CheckBox value, add String if checked, remove otherwise
     */
    private void updateAddIn(CheckBox c) {
        boolean selected = c.isSelected();
        if (selected)
            tempCoffee.add(c.getText());
        else
            tempCoffee.remove(c.getText());

        tempCoffee.itemPrice();
        updateSubtotal();
    }

    /**
     * Helper to update the subtotalText display in real-time (ideally).
     */
    private void updateSubtotal() {
        subtotalText.setText(String.valueOf(
                df.format(tempCoffee.getPrice())));
    }

    /**
     * Event function to finalize and add tempCoffee to mainOrder.
     */
    private void addToOrder() {
        try {
            if (tempCoffee != null) {
                MenuController.mainOrder.add(tempCoffee);
                //good to set null before closing out of sub-GUI
                tempCoffee = null;
                Stage stage = (Stage) addToOrderButton.getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }
}
