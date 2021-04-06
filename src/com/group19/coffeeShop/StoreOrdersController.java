package com.group19.coffeeShop;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.PrintWriter;

/**
 * Controller class associated with StoreOrdersView.fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("FieldMayBeFinal")
public class StoreOrdersController
{
    /* -- Data Fields. -- */
    //JavaFX Node element handles.
    @FXML private ListView<String> currentOrders = new ListView<>();

    @FXML private Button cancelOrderButton;
    @FXML private Button exportHistoryButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Links Action Events to related JavaFX nodes.
     */
    public void initialize() {
        //update currentOrders ListView
        updateFields();

        cancelOrderButton.setOnMouseClicked((event) -> removeOrder());
        exportHistoryButton.setOnMouseClicked((event) -> exportHistory());
    }

    /**
     * Event function to export currentOrders to text file.
     */
    private void exportHistory() {
        try {
            if (MenuController.mainStoreOrder != null) {
                //allows user to select their own save location,
                //restricted to text file type output
                FileChooser.ExtensionFilter extFilter =
                        new FileChooser.ExtensionFilter(
                                "TXT files (*.txt)",
                                "*.txt");
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(extFilter);
                File fileOut = fileChooser.showSaveDialog(null);

                //write company contents to output file
                String data = MenuController.mainStoreOrder.toString();
                if (fileOut != null)
                    writeText(data, fileOut);
            }
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * PrintWriter helper to write String contents to file
     * @param str data to be written to file
     * @param file destination .txt file getting written to
     */
    private void writeText(String str, File file)
    {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(str);
            writer.close();
        } catch (Exception ex) {
            MenuController.throwAlert(ex.getMessage());
        }
    }

    /**
     * Event function to remove the selected Order from currentOrders.
     * No action will occur if ListView has no selected item.
     */
    private void removeOrder() {
        try {
            if (!currentOrders.getSelectionModel().isEmpty()) {
                int selected =
                        currentOrders.getSelectionModel().getSelectedIndex();
                MenuController.mainStoreOrder.getOrderList().remove(selected);

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
        //populate currentItems listView with all MenuItem
        //object details, but leave off the last line
        //which just reports the order's price field values
        currentOrders.getItems().clear();
        String[] temp = MenuController.mainStoreOrder
                .toString().split("\n==================\n");
        currentOrders.getItems().addAll(temp);
    }
}
