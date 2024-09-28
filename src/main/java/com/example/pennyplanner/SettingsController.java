package com.example.pennyplanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class SettingsController {

    @FXML
    private Label nameField;

    @FXML
    private Label usernameField;

    @FXML
    private Label emailField;

    @FXML
    private Label passwordField;

    @FXML
    private RadioButton adminRadio;

    @FXML
    private RadioButton memberRadio;

    private Connection connection;

    private static String username ;

    //private static String username =LoginController.getUserName();
    // Database connection
    public void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
            String user = "root";
            String password = "oracle";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch user data from the database and display it
    @FXML
    private void loadUserData() {
        connectToDatabase();
        String query = "SELECT name, User_Name, User_Email, User_Pass FROM user_info WHERE User_ID = ?";
        try {
            username =LoginController.getUserName();
            int userId = UserSession.getUserId();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,userId); // Replace with dynamic user ID logic
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nameField.setText(resultSet.getString("name"));
                usernameField.setText(resultSet.getString("User_Name"));
                emailField.setText(resultSet.getString("User_Email"));
                passwordField.setText(resultSet.getString("User_Pass"));
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
               // connection.close();
            }
        }
    }

    // Initialize method to load user data on screen load
    @FXML
    public void initialize() {
        loadUserData();
    }

    // Button action for switching to the Dashboard
    @FXML
    private void SettingsToDash(ActionEvent event) {
        // Code to switch to dashboard scene
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

    // Button action for switching to Add Expenses
    @FXML
    private void SettingsToAddexpenses(ActionEvent event) {
        System.out.println("Navigating to Add Expenses");
        // Code to switch to Add Expenses scene
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

    // Button action for switching to Analysis
    @FXML
    private void SettingsToAnalysis(ActionEvent event) {
        System.out.println("Navigating to Analysis");
        // Code to switch to Analysis scene
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

    // Button action for switching to Goals
    @FXML
    private void SettingsToGoals(ActionEvent event) {
        System.out.println("Navigating to Goals");
        // Code to switch to Goals scene
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

    // Button action for editing the Name field
    @FXML
    private void editName(ActionEvent event) {
        System.out.println("Editing Name");
        // Add logic to handle name editing
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings 2.fxml"));
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

    // Button action for editing the Username field
    @FXML
    private void editUsername(ActionEvent event) {
        System.out.println("Editing Username");
        // Add logic to handle username editing
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings3.fxml"));
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

    // Button action for editing the Password field
    @FXML
    private void editPassword(ActionEvent event) {
        System.out.println("Editing Password");
        // Add logic to handle password editing
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings4.fxml"));
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

    // Button action for editing the Email field
    @FXML
    private void editEmail(ActionEvent event) {
        System.out.println("Editing Email");
        // Add logic to handle email editing
        try {
            // Load the dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings5.fxml"));
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

    // Button action for logging out
    @FXML
    private void LogoutBtn(ActionEvent event) {
        System.out.println("Logging out");
        // Add logic to handle logout
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

    // Button action for confirming account deletion
  @FXML
  private void confirmDeleteAccount() {
      String username = LoginController.getUserName();
      String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
      String user = "root";
      String password = "oracle";

      if (username.isEmpty()) {
          showErrorMessage("Error", "Username field is empty.");
          return;
      }

      String query = "DELETE FROM user_info WHERE User_Name = ?";

      try  {
          int userId = UserSession.getUserId();
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setString(1,username); // Replace with dynamic user ID logic
         // ResultSet resultSet = preparedStatement.executeQuery(query);
          //preparedStatement.setString(1, String.valueOf(userId));

          int rowsAffected = preparedStatement.executeUpdate();
          if (rowsAffected > 0) {
              showSuccessMessage("Success", "Your account has been deleted.");
              // Optionally, log the user out or redirect to the login page after deletion
          } else {
              showErrorMessage("Error", "Account not found or could not be deleted.");
          }

      } catch (SQLException e) {
          showErrorMessage("Database Error", "An error occurred while deleting your account: " + e.getMessage());
      }

  }

    // Handle role change between Admin and Member
    @FXML
    private void handleRoleChange(ActionEvent event) throws SQLException {
        if (adminRadio.isSelected()) {
            int homeId = generateRandomHomeId();
            // Store homeId in database (e.g., in users table)
            storeHomeIdInDatabase(homeId);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Home ID Generated");
            alert.setHeaderText(null);
            alert.setContentText("Generated Home ID: " + homeId);
            alert.showAndWait();
        } else if (memberRadio.isSelected()) {
            // Allow user to enter home ID for validation
            // You can prompt for input in a dialog or provide a text field
            // For simplicity, let's assume you have a method to prompt for the home ID
            String homeId = promptForHomeId();
            if (isHomeIdValid(homeId)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Home ID Valid");
                alert.setHeaderText(null);
                storeHomeIdInDatabase(Integer.parseInt(homeId));
                alert.setContentText("Home ID is valid.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Home ID Invalid");
                alert.setHeaderText(null);
                alert.setContentText("Home ID does not exist in the database.");
                alert.showAndWait();
            }
        }
    }
    public class UserSession {
        private static int userId;

        public static void setUserId(int id) {
            userId = id;
        }

        public static int getUserId() {

            int userId = -1; // Default value if user is not found
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Establish database connection
                String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
                String user = "root";
                String password = "oracle";
                connection = DriverManager.getConnection(url, user, password);

                // Prepare the SQL query
                String query = "SELECT User_ID FROM user_info WHERE User_Name = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username); // Set the username parameter

                // Execute the query
                resultSet = preparedStatement.executeQuery();

                // Check if a result was returned
                if (resultSet.next()) {
                    userId = resultSet.getInt("User_ID"); // Fetch the User_ID
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return userId; // Return the user ID (or -1 if not found)

        }
    }
    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showSuccessMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private int generateRandomHomeId() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000); // Generate a random 4-digit number
    }
    private void storeHomeIdInDatabase(int homeId) throws SQLException {
        // Replace with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
        String user = "root";
        String password = "oracle";
        connection = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE user_info SET home_ID = ? WHERE User_ID = ?"; // Adjust as necessary

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, homeId);
            pstmt.setInt(2, UserSession.getUserId()); // Replace with actual user ID retrieval
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean isHomeIdValid(String homeId) {
        // Replace with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/pennyplannerdb";
        String user = "root";
        String password = "oracle";
        String sql = "SELECT COUNT(*) FROM user_info WHERE home_ID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, homeId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Return true if home ID exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Home ID does not exist
    }
    private String promptForHomeId() {
        // Here you can implement a dialog or prompt to enter the home ID
        // For example, using a TextInputDialog
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Enter Home ID");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your Home ID:");


        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }


}
