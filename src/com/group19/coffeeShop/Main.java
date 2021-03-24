package com.group19.coffeeShop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.group19.coffeeShop.Consts.*;
/**
 * Main class, driver for overall project.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(
                "MenuView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, DEFAULT_WIDTH,
                DEFAULT_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
