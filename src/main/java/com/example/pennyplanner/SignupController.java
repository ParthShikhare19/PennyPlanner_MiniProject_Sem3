package com.example.pennyplanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class SignupController {

    @FXML
    private TextField TxtName;

    @FXML
    private TextField TxtUname;

    @FXML
    private PasswordField TxtPass;

    @FXML
    private PasswordField TxtVerifyPass;

    @FXML
    private TextField TxtEmail;

    // Database URL, username, and password
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pennyplannerdb";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "oracle";

    // Event handler for the "Sign Up" button
    @FXML
    public void SignUpAc() {
        String name = TxtName.getText();
        String username = TxtUname.getText();
        String password = TxtPass.getText();
        String verifyPassword = TxtVerifyPass.getText();
        String email = TxtEmail.getText();

        // Validate inputs
        if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error", "Please enter all the required fields.");
            return;
        }

        if (!password.equals(verifyPassword)) {
            showAlert(Alert.AlertType.ERROR, "Form Error", "Passwords do not match.");
            return;
        }
        // Insert data into the database
        if (insertUser(name, username, password, email)) {
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "User has been registered successfully!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "An error occurred. Please try again.");
        }
    }

    // Method to insert user into the database
    private boolean insertUser(String name, String username, String password, String email) {
        String query = "INSERT INTO user_info (name, User_Name, user_pass, user_email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);

            int result = preparedStatement.executeUpdate();
            return result > 0; // If at least one row is affected, the insertion is successful.

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

    // Method for "Back" button (You can implement navigation here)
    @FXML
    private void Back() {
        showAlert(Alert.AlertType.INFORMATION, "Back", "Going back to the previous screen.");
    }

//    @FXML
//    private void SignUpAc(ActionEvent event) {
//        try {
//            // Load the dashboard FXML
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("acc_created_popup.fxml"));
//            Parent root = loader.load();
//
//            // Get the current stage
//            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
//
//            // Set the scene to the dashboard
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @FXML
    private void Back(ActionEvent event) {
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
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
}
