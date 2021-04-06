package com.group19.coffeeShop;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Arrays;

import static com.group19.coffeeShop.Consts.*;

/**
 * Controller class associated with DonutsView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("FieldMayBeFinal")
public class DonutsController
{
    /* -- Data Fields. -- */
    Order tempOrder;
    Donut tempDonut;

    //JavaFX Node element handles.
    @FXML private ComboBox<String> donutType;
    @FXML private ListView<String> flavors = new ListView<>();
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private ListView<String> currentDonuts = new ListView<>();
    @FXML private TextField quantityText;
    @FXML private TextArea subtotalText;
    @FXML private Button addToOrderButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Links Action Events to related JavaFX nodes.
     */
    public void initialize() {
        tempOrder = new Order();
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
                flavors.getItems().clear();
                flavors.getItems().addAll(
                        String.valueOf(CakeDonut.CDFlavor.BOSTON_KREME),
                        String.valueOf(CakeDonut.CDFlavor.JELLY),
                        String.valueOf(CakeDonut.CDFlavor.STRAWBERRY));
            }
            case TYPE2 -> {
                flavors.getItems().clear();
                flavors.getItems().addAll(
                        String.valueOf(HoleDonut.HDFlavor.CHOCOLATE_GLAZE),
                        String.valueOf(HoleDonut.HDFlavor.POWDERED),
                        String.valueOf(HoleDonut.HDFlavor.PUMPKIN_SPICE));
            }
            case TYPE3 -> {
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
     * Event function to show quantity and set flavor/price for tempDonut.
     */
    private void enableQuantity() {
        quantityText.setDisable(false);
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
     * Event function to remove the selected Donut item from currentDonuts.
     * No action will occur if any item in the ListView is not selected.
     */
    private void removeDonut() {
        try {
            if (!currentDonuts.getSelectionModel().isEmpty()) {
                int selected =
                        currentDonuts.getSelectionModel().getSelectedIndex();
                tempOrder.getItemList().remove(selected);

                refreshTextFields();
            }
        } catch(Exception ex) {
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
        String[] temp = tempOrder.toString().split("\n");
        temp = Arrays.copyOf(temp, temp.length - 1);
        currentDonuts.getItems().addAll(temp);

        tempOrder.orderPrice();
        double subtotal = tempOrder.getSubtotal();
        subtotalText.setText(df.format(subtotal));
    }

    /**
     * Event function to finalize and add current Donut choices to an Order.
     */
    private void addToOrder() {
        try {
            if (tempOrder != null) {
                for (MenuItem i : tempOrder.getItemList())
                    MenuController.mainOrder.add(i);
                //good to set null before closing out of sub-GUI
                tempOrder = null;
                Stage stage = (Stage) addToOrderButton.getScene().getWindow();
                stage.close();
            }
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }
}
