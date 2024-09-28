package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.DatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AnalysisController {

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;

    private Connection connection;

    // Database connection setup
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
            String user = "root";
            String password = "oracle";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to load Pie Chart data (Amount vs. Category)
    @FXML
    private void loadPieChartData() {
        connectToDatabase();
        String query = "SELECT category, SUM(Tran_amt) AS total FROM transactions GROUP BY category";
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String category = resultSet.getString("category");
                double total = resultSet.getDouble("total");
                pieChartData.add(new PieChart.Data(category, total));
            }
            pieChart.setData(pieChartData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to load Bar Chart data (Amount per Month)
    @FXML
    private void loadBarChartData() {
        connectToDatabase();
        String query = "SELECT MONTHNAME(date ) AS month, SUM(Tran_amt) AS total FROM transactions WHERE date BETWEEN ? AND ? GROUP BY month";
        XYChart.Series<String, Number> barChartSeries = new XYChart.Series<>();
        barChartSeries.setName("Monthly Expenses");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(fromDate.getValue()));
            preparedStatement.setDate(2, java.sql.Date.valueOf(toDate.getValue()));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String month = resultSet.getString("month");
                double total = resultSet.getDouble("total");
                barChartSeries.getData().add(new XYChart.Data<>(month, total));
            }
            barChart.getData().add(barChartSeries);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to load Line Chart data (Daily Expense Trend)


    // Initialize the charts when the scene loads
    @FXML
    public void initialize() {
        // Set default date range to the current month
        fromDate.setValue(LocalDate.now().withDayOfMonth(1)); // Start of the month
        toDate.setValue(LocalDate.now()); // Today's date

        loadPieChartData();
        loadBarChartData();

    }

    @FXML
    private void AnalysisToDash(ActionEvent event) {
        try {
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
    }
    @FXML
    private void AddExpenseFromAnalysis(ActionEvent event) {
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
    @FXML
    private void AnalysisToGoal(ActionEvent event) {
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
    @FXML
    private void AnalysisToSettings(ActionEvent event) {
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
}
