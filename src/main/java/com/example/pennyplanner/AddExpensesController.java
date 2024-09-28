package com.example.pennyplanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class AddExpensesController {


    //model class start
    public class Transactions {
        private String description;
        private int id;
        private LocalDate date;

        private String category;
        private Double amount;
        private String type;
        private String paymentMethod;

        public Transactions(int id, LocalDate date, String description, String category, Double amount, String type, String paymentMethod) {
            this.id = id;
            this.date = date;
            this.description = description;
            this.category = category;
            this.amount = amount;
            this.type = type;
            this.paymentMethod = paymentMethod;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        public String getCategory() {
            return category;
        }

        public Double getAmount() {
            return amount;
        }

        public String getType() {
            return type;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }
    }

        //model class ends
        @FXML
        private TableView<Transactions> transactions;
        @FXML
        private TableColumn<Transactions, String> dateColumn;
        @FXML
        private TableColumn<Transactions,String> descriptionColumn, categoryColumn, amountColumn, typeColumn, paymentMethodColumn;

        @FXML
        private Button deleteButton, updateButton;

        private ObservableList<Transactions> expensesList = FXCollections.observableArrayList();

        private Connection connection;
        private Transactions selectedExpense;

        @FXML
        public void initialize() {
            connectToDatabase();

            // Bind table columns to data properties
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
            amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

            loadExpensesData();

            transactions.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    selectedExpense = newSelection;
                    deleteButton.setVisible(true);
                    updateButton.setVisible(true);
                }
            });

            deleteButton.setVisible(false);
            updateButton.setVisible(false);
        }

        private void connectToDatabase() {
            String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
            String user = "root";
            String password = "oracle";

            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void loadExpensesData() {
            expensesList.clear();

            String query = "select Tran_ID , date , Description , category , Tran_amt,Tran_Type,Payment_name  from transactions;";
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    expensesList.add(new Transactions(rs.getInt("Tran_ID"),
                            rs.getDate("date").toLocalDate(),
                            rs.getString("Description"),
                            rs.getString("category"),
                            rs.getDouble("Tran_amt"),
                            rs.getString("Tran_Type"),
                            rs.getString("Payment_name")));
                }
                transactions.setItems(expensesList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void handleDelete(ActionEvent event) {
            if (selectedExpense != null) {
                String deleteQuery = "DELETE FROM transactions WHERE Tran_ID = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
                    pstmt.setInt(1, selectedExpense.getId());
                    pstmt.executeUpdate();
                    expensesList.remove(selectedExpense);
                    deleteButton.setVisible(false);
                    updateButton.setVisible(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



        @FXML
        private void ExportExp(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                exportToExcel(file);
            }
        }

        private void exportToExcel(File file) {
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Expenses");

                // Create headers
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Date");
                header.createCell(1).setCellValue("Description");
                header.createCell(2).setCellValue("Category");
                header.createCell(3).setCellValue("Amount");
                header.createCell(4).setCellValue("Type");
                header.createCell(5).setCellValue("Payment Method");

                // Fill data
                int rowIndex = 1;
                for (Transactions expense : expensesList) {
                    Row row = sheet.createRow(rowIndex++);
                    row.createCell(0).setCellValue(expense.getDate().toString());
                    row.createCell(1).setCellValue(expense.getDescription());
                    row.createCell(2).setCellValue(expense.getCategory());
                    row.createCell(3).setCellValue(expense.getAmount().toString());
                    row.createCell(4).setCellValue(expense.getType());
                    row.createCell(5).setCellValue(expense.getPaymentMethod());
                }

                // Write to file
                try (FileOutputStream fileOut = new FileOutputStream(file)) {
                    workbook.write(fileOut);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // FXML connections

        @FXML
        private void Dashboard(ActionEvent event) {
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
        private void AnalysisFromAddExpense(ActionEvent event) {
            try {
                // Load the dashboard FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Analysis_Slide.fxml"));
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
        private void AddExpensesToGoals(ActionEvent event) {
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
        private void AddexpenseToSettings(ActionEvent event) {
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

        @FXML
        private void ADD(ActionEvent event) {
            try {
                // Load the dashboard FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Addexpense2.fxml"));
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
    public void UpdateButton(ActionEvent event) {

    }
    @FXML
    public void handleUpdate(ActionEvent event) {
        // Your update logic here
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateExpense.fxml"));
            Parent root = loader.load();

          //1  UpdateExpenseController.setTransactionData(selectedExpense) = loader.getController();

            // Pass selected data
            Stage stage = (Stage) ((Node) updateButton).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
