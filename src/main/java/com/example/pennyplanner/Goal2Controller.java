package com.example.pennyplanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Goal2Controller {
    @FXML
    private TextField goalDescriptionField;

    @FXML
    private TextField amountField;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private Button addButton;

    // MySQL connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/pennyplannerdb"; // Adjust as per your DB
    private final String DB_USER = "root"; // Adjust according to your MySQL user
    private final String DB_PASSWORD = "oracle"; // Enter your MySQL password here

    // Insert data into MySQL
    @FXML
    private void addGoal(ActionEvent event) {
        String description = goalDescriptionField.getText();
        double amount;

        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid number for the amount.", Alert.AlertType.ERROR);
            return;
        }

        LocalDate fromDate = fromDatePicker.getValue();
        LocalDate toDate = toDatePicker.getValue();

        if (description.isEmpty() || fromDate == null || toDate == null) {
            showAlert("Missing Fields", "Please fill in all fields.", Alert.AlertType.ERROR);
            return;
        }

        String insertQuery = "INSERT INTO goal_info (Goal_desc, Goal_amt, Date_from, Date_to) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, description);
            pstmt.setDouble(2, amount);
            pstmt.setDate(3, java.sql.Date.valueOf(fromDate));
            pstmt.setDate(4, java.sql.Date.valueOf(toDate));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Goal added successfully!", Alert.AlertType.INFORMATION);
                clearFields();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Failed to add the goal.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        goalDescriptionField.clear();
        amountField.clear();
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
    }
    @FXML
    private void BackGoal(ActionEvent event) {
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("goal 1.fxml"));
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
