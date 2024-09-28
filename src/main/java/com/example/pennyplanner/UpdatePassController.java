package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePassController {

    @FXML
    private TextField oldPasswordField;

    @FXML
    private TextField newPasswordField;

    @FXML
    private TextField reEnterPasswordField;

    @FXML
    private Button ApplyPass;

    // Database connection details
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
        String user = "root";
        String password = "oracle";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            showErrorAlert("Database Connection Failed", "Error: " + e.getMessage());
        }
        return conn;
    }

    @FXML
    public void ApplyPass(ActionEvent event) {
        String oldPassword = oldPasswordField.getText();
        String newPassword = newPasswordField.getText();
        String reEnterPassword = reEnterPasswordField.getText();

        if (oldPassword.isEmpty() || newPassword.isEmpty() || reEnterPassword.isEmpty()) {
            showErrorAlert("Input Error", "All fields must be filled.");
            return;
        }

        if (!newPassword.equals(reEnterPassword)) {
            showErrorAlert("Password Mismatch", "New passwords do not match.");
            return;
        }

        // Check if the old password is correct
        String checkQuery = "SELECT * FROM user_info WHERE User_Pass = ?";
        String updateQuery = "UPDATE user_info SET User_Pass = ? WHERE User_Pass = ?";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            checkStmt.setString(1, oldPassword);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Old password is correct, proceed with update
                updateStmt.setString(1, newPassword);
                updateStmt.setString(2, oldPassword);
                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    showInfoAlert("Success", "Password updated successfully.");
                } else {
                    showErrorAlert("Update Error", "Password update failed.");
                }
            } else {
                showErrorAlert("Old Password Incorrect", "The old password you entered is incorrect.");
            }

        } catch (SQLException e) {
            showErrorAlert("Database Error", "Error: " + e.getMessage());
        }
    }

    @FXML
    public void BackFromEditPass(ActionEvent event) {
        // Logic to return to the previous page or dashboard
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings1.fxml"));
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

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
