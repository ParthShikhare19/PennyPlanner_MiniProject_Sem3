package com.example.pennyplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class ChoiceBox1Controller {

    @FXML
    private ChoiceBox<String> choiceBox;

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
