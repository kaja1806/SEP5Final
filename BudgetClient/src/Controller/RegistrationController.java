package Controller;

import Classes.User;
import DB.UserDAO;
import Model.IUserModel;
import Model.UserModel;
import Model.UserModel.RegistrationModel;
import Model.UserToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    public TextField FirstName;
    public TextField LastName;
    public TextField Email;
    public TextField Address;
    public PasswordField Password;
    public PasswordField PasswordConfirmation;
    public TextField PhoneNr;
    public ComboBox NameOfBank;
    public IUserModel IuserModel;

    public void init(IUserModel userModel) {
        this.IuserModel = userModel;
    }


    @FXML
    public void handleRegistration() {

        try {
            FXMLLoader loader = new FXMLLoader();
            Stage stage = new Stage();
            loader.setLocation(getClass().getResource("/View/Login.fxml"));
            Parent main = loader.load();

            stage.setTitle("Main Page");
            stage.setScene(new Scene(main, 600, 400));
            stage.show();
            // ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void registerUserToApplication() {

        RegistrationModel x = new RegistrationModel(
                FirstName.getText(),
                LastName.getText(),
                Email.getText(),
                Address.getText(),
                PhoneNr.getText(),
                Password.getText(),
                PasswordConfirmation.getText()
        );

        UserDAO a = new UserDAO();

        if (FirstName.getText().isEmpty() & (LastName.getText().isEmpty()) & !(Email.getText().isEmpty()) & !(Address.getText().isEmpty()) & (NameOfBank.toString().isEmpty()) & (PhoneNr.getText().isEmpty()) & (Password.getText().isEmpty()) & (PasswordConfirmation.getText().isEmpty())) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        } else {
            String temp = a.createUser(x);
            if (temp.equals("User added")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + FirstName.getText() + " has been added!", ButtonType.OK);
                a1.show();
                handleRegistration();

            } else if (temp.equals("Duplicate key")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + FirstName.getText() + " already exists!", ButtonType.OK);
                a1.show();
            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                a1.show();
            }
        }

    }
}