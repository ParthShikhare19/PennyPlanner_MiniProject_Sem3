package com.example.pennyplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PennyPlanner");
        stage.setScene(scene);
        stage.show();
        Image image = new Image(getClass().getResourceAsStream("budget.png"));
        stage.getIcons().add(image);
    }

    public static void main(String[] args) {
        launch();
    }
}