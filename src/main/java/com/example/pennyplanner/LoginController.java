package com.example.pennyplanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField TxtUname;

    @FXML
    private PasswordField TxtPass;

    private static String username;

    // Database URL, username, and password
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pennyplannerdb";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "oracle";

    // Event handler for the "Login" button
    @FXML
    private void Login(ActionEvent event) {
         username = TxtUname.getText();
        String password = TxtPass.getText();


        if (validateLogin(username, password)) {
            try {
                // Assuming you set the userID when the user logs in
                Session.getInstance().setUserID(username);
                // Load the dashboard FXML

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Parent root = loader.load();



                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the scene to the dashboard
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }
    public static String getUserName () {
        return username;
    }

    // Method to validate user login
    private boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM user_info WHERE User_Name = ? AND User_Pass = ?";


        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If a user is found, login is successful.

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to display alert messages
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void ForgotPassword(ActionEvent event) {
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotpass1.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the scene to the dashboard
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void SignUp(ActionEvent event) {
        // Perform login validation here
        boolean isValidLogin = true; // Replace with actual validation logic

        if (isValidLogin) {
            try {
                // Load the dashboard FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("sign up.fxml"));
                Parent root = loader.load();

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the scene to the dashboard
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error message for invalid login
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}