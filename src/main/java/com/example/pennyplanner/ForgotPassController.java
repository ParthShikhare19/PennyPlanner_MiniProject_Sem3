package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPassController {

    @FXML
    private TextField emailField;

    @FXML
    private Button submitButton;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pennyplannerdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "oracle";

    // Email credentials - Replace with your email and app-specific password
    private static final String EMAIL_USER = "";
    private static final String EMAIL_PASSWORD = ""; // App-specific password here

    @FXML
    private void Submit() {
        String email = emailField.getText();

        if (email.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Email field cannot be empty.");
            return;
        }

        // Check if email exists in the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT User_Email FROM user_info WHERE User_Email = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Generate a new random password
                String newPassword = generateRandomPassword(8);

                // Update the password in the database
                updatePasswordInDatabase(email, newPassword);

                // Send email with the new password
                sendEmail(email, newPassword);

                // Show success alert with password to the user
                showAlert(AlertType.INFORMATION, "Success", "Your new password is sent to your email" );

            } else {
                showAlert(AlertType.ERROR, "Error", "Email is not registered.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Database Error", "Unable to connect to the database.");
        }
    }

    // Generate a random password
    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    // Update the password in the database
    private void updatePasswordInDatabase(String email, String newPassword) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String updateQuery = "UPDATE user_info SET User_Pass = ? WHERE User_Email = ?";
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, newPassword);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Send the new password via email
    private void sendEmail(String recipientEmail, String newPassword) {
        // Set email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "email-smtp.ap-south-1.amazonaws.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with the email credentials
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USER, EMAIL_PASSWORD);
            }
        });

        try {
            // Create the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Password Reset - Penny Planner");
            message.setText("Your new password is: " + newPassword);

            // Send the email
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

    // Show an alert message
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    private void Back(ActionEvent event) {
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
}

            // Get
