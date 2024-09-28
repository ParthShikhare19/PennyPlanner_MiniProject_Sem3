package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class UpdateExpenseController {


    public class Transaction {

        private String description;
        private double amount;
        private String category;
        private String type; // Transaction type (e.g., income, expense)
        private String paymentMethod;
        private LocalDate date;

        // Constructor
        public Transaction(String description, double amount, String category, String type, String paymentMethod, LocalDate date) {

            this.description = description;
            this.amount = amount;
            this.category = category;
            this.type = type;
            this.paymentMethod = paymentMethod;
            this.date = date;
        }

        // Getters


        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }

        public String getType() {
            return type;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public LocalDate getDate() {
            return date;
        }
    }

        @FXML
        private  TextField descriptionField1;
        @FXML
        private  TextField amountField1;
        @FXML
        private  ChoiceBox<String> choiceBox1; // For category
        @FXML
        private  TextField transactionTypeField1;
        @FXML
        private  TextField paymentMethodField1;
        @FXML
        private  DatePicker datePicker1;

        private  Transaction currentTransaction; // Store the current transaction

        // Method to set the transaction data into fields
        public void setTransactionData(Transaction transaction) {
            currentTransaction = transaction;

            descriptionField1.setText(transaction.getDescription());
            amountField1.setText(String.valueOf(transaction.getAmount()));
            choiceBox1.setValue(transaction.getCategory());
            transactionTypeField1.setText(transaction.getType());
            paymentMethodField1.setText(transaction.getPaymentMethod());
            datePicker1.setValue(transaction.getDate());
        }

        @FXML
        private void ApplyUpdate(ActionEvent event) {
            // Gather updated data from fields
            String description = descriptionField1.getText();
            double amount = Double.parseDouble(amountField1.getText());
            String category = choiceBox1.getValue();
            String transactionType = transactionTypeField1.getText();
            String paymentMethod = paymentMethodField1.getText();
            LocalDate date = datePicker1.getValue();

            // Update the transaction in the database
            updateTransaction(description, amount, category, transactionType, paymentMethod, date);
        }

        private void updateTransaction(String description, double amount, String category, String transactionType, String paymentMethod, LocalDate date) {
            String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
            String user = "root";
            String password = "oracle";
            String sql = "UPDATE transactions SET description = ?, amount = ?, category = ?, type = ?, payment_method = ?, date = ? WHERE Tran_ID = ?";

            try (Connection conn = DriverManager.getConnection(url, user, password); // Your DB connection method
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, description);
                pstmt.setDouble(2, amount);
                pstmt.setString(3, category);
                pstmt.setString(4, transactionType);
                pstmt.setString(5, paymentMethod);
                pstmt.setDate(6, java.sql.Date.valueOf(date)); // Convert LocalDate to java.sql.Date


                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    showAlert("Success", "Transaction updated successfully.");
                } else {
                    showAlert("Error", "Transaction update failed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error", "Database error: " + e.getMessage());
            }
        }

        private void showAlert(String title, String message) {
            // Implement your alert dialog here
        }
    @FXML
    private void BackAddExpense(ActionEvent event) {
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

}

