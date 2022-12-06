package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DB.Conn;
import DB.UserDAO;
import Helpers.User_Authentication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.IOException;
import java.rmi.RemoteException;


public class LoginController {
    @FXML
    public Button login;
    @FXML
    public Button registration;
    @FXML
    public PasswordField Password;
    @FXML
    public TextField username;
    @FXML
    public Label error;

    @FXML
    public void login(ActionEvent event) throws SQLException{
        Window owner = login.getScene().getWindow();

        System.out.println(username.getText());
        System.out.println(Password.getText());

        if (username.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your username!");
            return;
        }
if (Password.getText().isEmpty()) {
    showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
    return;
        }

String userName = username.getText();
String password = Password.getText();


        Connection conn = DriverManager.getConnection("postgresql://localhost:5432/postgres?currentSchema=dbo","postgres","Kaja1806");


//        UserDAO userDAO = new UserDAO();
//        boolean flag = Conn.getInstance(username,Password);
//
//        if(!flag) {
//            infoBox("Plase enter correct username and password", null, "Failed");
//        }
//        else {
//            infoBox("Login Successful !", null, "Failed");
//        }
    }

    private void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText("Something went wrong! ");
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    }
//    @FXML
//    public void handleLogin (ActionEvent event) throws RemoteException {
//        String name = username.getText();
//        String pass = Password.getText();
//
//        System.out.println(name + " " + pass);
//
//        int vid = User_Authentication.isValid(name,pass);
//
//        if (vid != -1) {
//            try{
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
//                stage.setTitle("Overview");
//                stage.setScene(new Scene(root));
//                stage.show();
//                ((Node) (event.getSource())).getScene().getWindow().hide();
//            }
//            catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            error.setText("Oops ! Something went wrong. Please try again!");
//        }
//
//    }

    public void goToRegistration(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Registration.fxml"));
            stage.setTitle("Registration");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToOverview(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Overview.fxml"));
            stage.setTitle("Overview");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

