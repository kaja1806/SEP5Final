package Controller;

import DB.BanksDAO;
import DB.UserDAO;
import Model.Banks;
import Model.Category;
import Model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    BanksDAO ba = new BanksDAO();

    public void initialize() {
        ObservableList<Banks> banks = ba.getAllBanks();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Banks bank : banks) {
            String bankName = bank.NameOfBank;
            data.add(bankName);
        }
        NameOfBank.setItems(data);
    }


    @FXML
    public void handleRegistration(ActionEvent event) {

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

    public void registerUserToApplication(ActionEvent event) {

        if (NameOfBank.getValue() == null) {
            NameOfBank.setValue("");
        }

        UserModel.RegistrationModel inputRegData = new UserModel.RegistrationModel(FirstName.getText(), LastName.getText(), Email.getText(), Address.getText(), PhoneNr.getText(), Password.getText(), PasswordConfirmation.getText(), NameOfBank.getValue().toString());

        UserDAO userDAO = new UserDAO();


        if (!(inputRegData.FirstName.isEmpty() || inputRegData.LastName.isEmpty() & inputRegData.Email.isEmpty() || inputRegData.Address.isEmpty() || inputRegData.PhoneNr.isEmpty() || inputRegData.Password.isEmpty() || inputRegData.PasswordConfirmation.isEmpty() || inputRegData.NameOfBank.equals(""))) {
            if (inputRegData.Password.equals(inputRegData.PasswordConfirmation)) {
                String temp = userDAO.createUser(inputRegData);
                if (temp.equals("User added")) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " has been added!", ButtonType.OK);
                    a1.show();
                    //Show another view
                    handleRegistration(event);

                } else if (temp.equals("Duplicate key")) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " already exists!", ButtonType.OK);
                    a1.show();
                } else {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                    a1.show();
                }
            } else {
                Alert a1 = new Alert(Alert.AlertType.ERROR, "Passwords don't match!", ButtonType.OK);
                a1.show();
            }
        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        }
    }

    public void addCreditCard(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/CreditCard.fxml"));
            stage.setTitle("Add credit card");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
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