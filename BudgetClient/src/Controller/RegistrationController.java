package Controller;

import DB.UserDAO;
import Model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    public TextField FirstName;
    public TextField LastName;
    public TextField Email;
    public TextField Address;
    public PasswordField Password;
    public PasswordField PasswordConfirmation;
    public TextField PhoneNr;
    public ComboBox NameOfBank;

    @FXML
    public void handleRegistration() {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Overview.fxml"));
            stage.setTitle("Overview");
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerUserToApplication() {

        UserModel.RegistrationModel inputRegData = new UserModel.RegistrationModel(FirstName.getText(), LastName.getText(), Email.getText(), Address.getText(), PhoneNr.getText(), Password.getText(), PasswordConfirmation.getText());

        UserDAO userDAO = new UserDAO();

        if (FirstName.getText().isEmpty() & (LastName.getText().isEmpty()) & !(Email.getText().isEmpty()) & !(Address.getText().isEmpty()) & (NameOfBank.toString().isEmpty()) & (PhoneNr.getText().isEmpty()) & (Password.getText().isEmpty()) & (PasswordConfirmation.getText().isEmpty())) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        } else {
            //Trigger database call
            String temp = userDAO.createUser(inputRegData);
            if (temp.equals("User added")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " has been added!", ButtonType.OK);
                a1.show();
                //Show another view
                handleRegistration();

            } else if (temp.equals("Duplicate key")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " already exists!", ButtonType.OK);
                a1.show();
            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                a1.show();
            }
        }

    }

    public void backToLogin(ActionEvent event) {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            stage.show();
            // hides the parent window
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}