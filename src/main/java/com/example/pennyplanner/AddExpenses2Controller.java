package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddExpenses2Controller {

    @FXML
    private TextField descriptionField;
    @FXML
    private TextField amountField;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField transactionTypeField;
    @FXML
    private TextField paymentMethodField;
    @FXML
    private DatePicker datePicker;


    // MySQL Database URL and credentials
    private final String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
    private final String user = "root";
    private final String password = "oracle";
    private String time;

    @FXML
    private void AddButton() {
        String description = descriptionField.getText();
        String amount = amountField.getText();
        String category = choiceBox.getValue();
        String transactionType = transactionTypeField.getText();
        String paymentMethod = paymentMethodField.getText();
        String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : null;


        if (description.isEmpty() || amount.isEmpty() || (category == null) || transactionType.isEmpty() ||
                paymentMethod.isEmpty() || (date == null)) {
            // Show error if any field is empty
            showAlert("Error", "All fields must be filled out.", Alert.AlertType.ERROR);
        } else {
            // Insert into the database
            
            insertExpense(description, Double.parseDouble(amount), category, transactionType, paymentMethod, date,null);
        }
    }

    private void insertExpense(String description, double amount, String category, String transactionType, String paymentMethod, String date, String time) {
        String query = "INSERT INTO transactions (description, Tran_amt, category, Tran_type, payment_name, date ) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, description);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, transactionType);
            preparedStatement.setString(5, paymentMethod);
            preparedStatement.setString(6, date);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Add expense", "Added successfully !");
                clearFields();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Failed to add expense. Please try again.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        descriptionField.clear();
        amountField.clear();
        transactionTypeField.clear();
        paymentMethodField.clear();
        datePicker.setValue(null);
        choiceBox.setValue(null);
    }


    @FXML
    private void BackDash() {
        // Implement the logic to go back to the dashboard
    }


    @FXML
    private void BackDash(ActionEvent event) {
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Addexpense1.fxml"));
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

    // List of options for the ChoiceBox
    private String[] choices = { "Education", "Food", "Health", "Travelling","Bills","Utilities","Entertainment","Others" };

    @FXML
    public void initialize() {
        // Add items to the ChoiceBox
        choiceBox.getItems().addAll(choices);

        // Set default value
        choiceBox.setValue(choices[7]);
    }

    // Event handler for the submit button
    @FXML
    private void handleSubmit() {
        String selectedChoice = choiceBox.getValue();
        showAlert(Alert.AlertType.INFORMATION, "Selected Choice", "You selected: " + selectedChoice);
    }

    // Method to show an alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

