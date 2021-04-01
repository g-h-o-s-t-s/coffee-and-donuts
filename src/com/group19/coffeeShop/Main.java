package com.group19.coffeeShop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.group19.coffeeShop.Consts.*;

/**
 * Driver class, calls primary Client class, MenuController().
 @author Sagnik Mukherjee, Michael Choe
 */
public class Main extends Application
{
    public static Stage primaryStage;
    /**
     * Sets primary Menu stage for program.
     * @param primaryStage top-level container
     * @throws Exception handles any unpredictable, invalid inputs
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource(
                "MenuView.fxml"));
        primaryStage.setTitle("RecUperationCafe");
        primaryStage.setScene(new Scene(root, DEFAULT_WIDTH,
                DEFAULT_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Main method to create instance of primary client, Menu.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
