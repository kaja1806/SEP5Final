package Controller;

import DB.UserDAO;
import Model.UserCardModel;
import com.sun.javafx.scene.control.IntegerField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardController {
    public TextField CardNumber;
    public DatePicker ValidDate;
    public TextField Cvc;
    public TextField CardholderName;
    public TextField EstimatedIncome;

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

    public void addCardToUser(ActionEvent event) {

        String cvc = Cvc.getText();
        String income = EstimatedIncome.getText();
        int cvcParse = Integer.parseInt(cvc);
        int incomeParse = Integer.parseInt(income);

        UserCardModel cardInput = new UserCardModel(CardholderName.getText(), CardNumber.getText(),
                ValidDate.getValue(), cvcParse);

        UserDAO userDAO = new UserDAO();


        if (!(cardInput.CardholderName.isEmpty() || cardInput.getCardNumber().isEmpty() || cardInput.ValidDate == null || cvc.isEmpty())) {
            String temp = userDAO.createCard(cardInput, incomeParse);
            if (temp.equals("Card Added")) {
                //Show another view
                goToOverview(event);

                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Card has been " + "added!", ButtonType.OK);
                a1.show();

            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                a1.show();
            }

        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        }
    }
}
