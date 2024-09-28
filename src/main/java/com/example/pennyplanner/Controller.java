package com.example.pennyplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller{

    //Page processing code


    @FXML
    private void SignUp(ActionEvent event) {
        // Perform login validation here
        boolean isValidLogin = true; // Replace with actual validation logic

        if (isValidLogin) {
            try {
                // Load the dashboard FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("sign up.fxml"));
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
        } else {
            // Show error message for invalid login
            System.out.println("Login failed. Please check your credentials.");
        }
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

     @FXML
     private void ForgotPassword(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotpass1.fxml"));
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
     private void Login(ActionEvent event) {
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
     private void DashToAddexpense(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Addexpense1.fxml"));
             Parent root;
             root = loader.load();

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
     private void Submit(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("fp_popup.fxml"));
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
     private void Ok(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotpass1.fxml"));
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
     private void SignUpAc(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("acc_created_popup.fxml"));
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
     private void DashToAnalysis(ActionEvent event) {
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
     private void DashToGoals(ActionEvent event) {
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
     private void AddGoalBtn(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("goal2.fxml"));
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
     private void GoalToDash(ActionEvent event) {
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
     private void GoalToAddExpenses(ActionEvent event) {
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
     private void GoalToAnalysis(ActionEvent event) {
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
     private void DashToSettings(ActionEvent event) {
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
     private void EditNameBtn(ActionEvent event) {
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

     @FXML
     private void EditUsernameBtn(ActionEvent event) {
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

     @FXML
     private void EditPassBtn(ActionEvent event) {
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

     @FXML
     private void EditEmailBtn(ActionEvent event) {
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

     @FXML
     private void BackFromEditName(ActionEvent event) {
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
     private void ApplyName(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("namechangedpopup.fxml"));
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
     private void BackFromEditUsername(ActionEvent event) {
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
     private void ApplyUsername(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("usernamechangedpopup.fxml"));
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
     private void BackFromEditPass(ActionEvent event) {
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
     private void ApplyPass(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("passwordchangedpopup.fxml"));
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
     private void BackFromEditEmail(ActionEvent event) {
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
     private void ApplyEmail(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("emailchangedpopup.fxml"));
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
     private void DelAccBtn(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteaccpopup.fxml"));
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
     private void LogoutBtn(ActionEvent event) {
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

     @FXML
     private void DelAccYes(ActionEvent event) {
         try {
             // Load the dashboard FXML
             FXMLLoader loader = new FXMLLoader(getClass().getResource("accdeletedpopup.fxml"));
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
     private void DelAccNo(ActionEvent event) {
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
     private void AccDeleted(ActionEvent event) {
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

     @FXML
     private void SettingsToGoals(ActionEvent event) {
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
     private void SettingsToAnalysis(ActionEvent event) {
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
     private void SettingsToAddexpenses(ActionEvent event) {
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
     private void SettingsToDash(ActionEvent event) {
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

     @FXML
     private void GoalToSettings(ActionEvent event) {
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
     private void NameChangedBtn(ActionEvent event) {
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
     private void UsernameChangeBtn(ActionEvent event) {
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
     private void PassChangedBtn(ActionEvent event) {
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
     private void EmailChangedBtn(ActionEvent event) {
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
     private void ForgotBtn(ActionEvent event) {
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

     @FXML
     private void AccCreated(ActionEvent event) {
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

    @FXML
    private void AddExp(ActionEvent event) {
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


}