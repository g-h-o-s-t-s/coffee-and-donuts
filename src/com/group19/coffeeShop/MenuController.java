package com.group19.coffeeShop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

import static com.group19.coffeeShop.Consts.*;

/**
 * Controller class associated with .fxml and GUI.
 @author Sagnik Mukherjee, Michael Choe
 */
public class MenuController
{
    /* -- Data Fields. */
    //General Usage.

    //MenuItem Ordering Nodes, spawn new windows.
    @FXML private Button orderDonutButton;
    @FXML private Button orderCoffeeButton;

    //Order Management Nodes, spawn new windows.
    @FXML private Button viewOrderButton;
    @FXML private Button viewStoreOrdersButton;

    /**
     * A sort of "constructor" class for the Controller.
     * Initializes all the Action Events and MouseClicked Events associated
     * with MenuItems and Buttons.
     */
    public void initialize() {
        //Button Events, Ordering Items
        orderDonutButton.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "DonutsView.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),
                        REDUCED_WIDTH, REDUCED_HEIGHT);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(Main.primaryStage);
                stage.setTitle("New Donut Order");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                throwAlert(ex.getMessage());
            }
        });

        orderCoffeeButton.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "CoffeeView.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),
                        REDUCED_WIDTH, REDUCED_HEIGHT);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(Main.primaryStage);
                stage.setTitle("New Coffee Order");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                throwAlert(ex.getMessage());
            }
        });

        //Button Events, Reviewing Order Contents and Order History
        viewOrderButton.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "OrderView.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),
                        REDUCED_WIDTH, REDUCED_HEIGHT);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(Main.primaryStage);
                stage.setTitle("Review Contents of Current Order");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                throwAlert(ex.getMessage());
            }
        });

        viewStoreOrdersButton.setOnMouseClicked((event) -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "StoreOrdersView.fxml"));
                Scene scene = new Scene(fxmlLoader.load(),
                        REDUCED_WIDTH, REDUCED_HEIGHT);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(Main.primaryStage);
                stage.setTitle("Review Overall Order History");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                throwAlert(ex.getMessage());
            }
        });

    }

    /**
     * Helper to open Alert Dialog box when exception occurs.
     * @param exceptionMsg String literal containing exception details
     */
    public static void throwAlert(String exceptionMsg)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exception Occurred");
        alert.setHeaderText("Exception Details.");
        alert.setContentText(exceptionMsg);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                alert.close();
            }
        });
    }


}
