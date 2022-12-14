package Controller;

import BudgetClient.IBudgetClient;
import DB.BanksDAO;
import DB.UserDAO;
import Handlers.IClientHelper;
import Interface.IServerClient;
import Model.Banks;
import Model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;

public class RegistrationController {

    public TextField FirstName;
    public TextField LastName;
    public TextField Email;
    public TextField Address;
    public PasswordField Password;
    public PasswordField PasswordConfirmation;
    public TextField PhoneNr;
    public ComboBox NameOfBank;
    public IClientHelper clientHelper;

    UserDAO ba = new UserDAO();


    public void init(IClientHelper handler) {

        this.clientHelper = handler;

        /*ObservableList<Banks> banks = ba.getAllBanks();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Banks bank : banks) {
            String bankName = bank.NameOfBank;
            data.add(bankName);
        }
        NameOfBank.setItems(data);*/

    }

/*    public void initialize() {
        ObservableList<Banks> banks = ba.getAllBanks();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Banks bank : banks) {
            String bankName = bank.NameOfBank;
            data.add(bankName);
        }
        NameOfBank.setItems(data);
    }*/

    public void registerUserToApplication(ActionEvent event) {

        if (NameOfBank.getValue() == null) {
            NameOfBank.setValue("");
        }

        UserModel inputRegData = new UserModel(FirstName.getText(),
                LastName.getText(), Email.getText(), Address.getText(), PhoneNr.getText(), Password.getText(),
                PasswordConfirmation.getText(), NameOfBank.getValue().toString());


        clientHelper.createUser(inputRegData);

        /*if (!(inputRegData.FirstName.isEmpty() || inputRegData.LastName.isEmpty() & inputRegData.Email.isEmpty() || inputRegData.Address.isEmpty() || inputRegData.PhoneNr.isEmpty() || inputRegData.Password.isEmpty() || inputRegData.PasswordConfirmation.isEmpty() )) {
            if (inputRegData.Password.equals(inputRegData.PasswordConfirmation)) {
                String temp = clientHelper.createUser(inputRegData);
                if (temp.equals("User added")) {
                    //Show another view
                    backToLogin(event);

                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " has been " +
                            "added!", ButtonType.OK);
                    a1.show();

                } else if (temp.equals("Duplicate key")) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + FirstName.getText() + " already " +
                            "exists!", ButtonType.OK);
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
        }*/
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