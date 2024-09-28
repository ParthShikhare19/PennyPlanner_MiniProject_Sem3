package com.example.pennyplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class UpdateGoalCOntroller {

    public class Goal {
        private int id;
        private String description;
        private double amount;
        private LocalDate fromDate;
        private LocalDate toDate;

        // Constructor, getters, and setters
        public Goal(int id, String description, double amount, LocalDate fromDate, LocalDate toDate) {
            this.id = id;
            this.description = description;
            this.amount = amount;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        public LocalDate getFromDate() {
            return fromDate;
        }

        public LocalDate getToDate() {
            return toDate;
        }

        // Other methods if needed
    }

    @FXML
    private TextField goalDescriptionField1;
    @FXML
    private TextField amountField1;
    @FXML
    private DatePicker fromDatePicker1;
    @FXML
    private DatePicker toDatePicker1;
    @FXML
    private Button applyButton;

    private static Goal selectedGoal; // Store the selected goal to edit

    // Static method to set the selected goal from Goal1Controller
    public static void setSelectedGoal(Goal goal) {
        selectedGoal = goal;
    }

    @FXML
    public void initialize() {
        if (selectedGoal != null) {
            // Populate the fields with selected goal's data
            goalDescriptionField1.setText(selectedGoal.getDescription());
            amountField1.setText(String.valueOf(selectedGoal.getAmount()));
            fromDatePicker1.setValue(selectedGoal.getFromDate());
            toDatePicker1.setValue(selectedGoal.getToDate());
        }
    }

    @FXML
    private void AppplyGoal() {
        // Get updated data from the fields
        String description = goalDescriptionField1.getText();
        double amount = Double.parseDouble(amountField1.getText());
        LocalDate fromDate = fromDatePicker1.getValue();
        LocalDate toDate = toDatePicker1.getValue();

        // Update the goal in the database
        updateGoalInDatabase(selectedGoal.getId(), description, amount, fromDate, toDate);
    }

    private void updateGoalInDatabase(int id, String description, double amount, LocalDate fromDate, LocalDate toDate) {
        // Database connection and update logic
        String sql = "UPDATE goals SET description = ?, amount = ?, from_date = ?, to_date = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setDouble(2, amount);
            pstmt.setDate(3, java.sql.Date.valueOf(fromDate));
            pstmt.setDate(4, java.sql.Date.valueOf(toDate));
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void BackGoal() {
        // Code to go back to the previous screen (Goal1Controller)
        // Similar to handleUpdate in Goal1Controller
    }


}
