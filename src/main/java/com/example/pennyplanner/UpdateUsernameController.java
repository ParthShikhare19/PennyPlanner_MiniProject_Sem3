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

public class UpdateUsernameController {

    @FXML
    private TextField oldUsernameField;

    @FXML
    private TextField newUsernameField;

    @FXML
    private Button ApplyUsername;

    private Connection connect() {
        // Replace with your MySQL database credentials
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
    public void ApplyUsername(ActionEvent event) {
        String oldName = oldUsernameField.getText();
        String newName = newUsernameField.getText();

        if (oldName.isEmpty() || newName.isEmpty()) {
            showErrorAlert("Input Error", "Both fields must be filled.");
            return;
        }

        // Check if old name exists in the database
        String checkQuery = "SELECT * FROM user_info WHERE User_Name = ?";
        String updateQuery = "UPDATE user_info SET User_Name = ? WHERE User_Name = ?";

        try (Connection conn = connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            checkStmt.setString(1, oldName);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Old name exists, proceed with update
                updateStmt.setString(1, newName);
                updateStmt.setString(2, oldName);
                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    showInfoAlert("Success", "Username updated successfully.");
                } else {
                    showErrorAlert("Update Error", "Username update failed.");
                }
            } else {
                showErrorAlert("User Not Found", "Old Username not found in the database.");
            }

        } catch (SQLException e) {
            showErrorAlert("Database Error", "Error: " + e.getMessage());
        }
    }

    @FXML
    public void BackFromEditUsername(ActionEvent event) {
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
