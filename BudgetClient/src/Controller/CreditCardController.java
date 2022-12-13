package Controller;

import DB.UserDAO;
import Model.UserCardModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardController {
    public TextField CardNumber;
    public DatePicker ValidDate;
    public TextField Cvc;
    public TextField CardholderName;
    public TextField EstimatedIncome;
    public ComboBox Cardnicknamedropdown;
    public TextField Cardnickname;
    public Button Addeditcard;
    public Button backbutton;
    public Text topText;

    UserDAO userDAO = new UserDAO();

    public void initialize() {
        ObservableList<UserCardModel> cards = userDAO.ifCardExistsPerUser();
        int userIncome = userDAO.getIncomePerUser();

        if (cards != null) {
            displayUserCard(cards, userIncome);
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

    public void ifCardExists(ActionEvent event) {
        addCardToUser(event);
    }

    public void addCardToUser(ActionEvent event) {

        String cvc = Cvc.getText();
        String income = EstimatedIncome.getText();
        if (income.equals("") || cvc.equals("")) {
            cvc = String.valueOf(0);
            income = String.valueOf(0);
        }
        int cvcParse = Integer.parseInt(cvc);
        int incomeParse = Integer.parseInt(income);

        UserCardModel cardInput = new UserCardModel(CardholderName.getText(), CardNumber.getText(),
                ValidDate.getValue(), cvcParse, Cardnickname.getText());

        UserDAO userDAO = new UserDAO();

        if (!(cardInput.CardholderName.isEmpty() || cardInput.getCardNumber().isEmpty() || cardInput.ValidDate == null || cvc.isEmpty())) {
            if (userDAO.ifCardExistsPerUser() == null) {
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
                String temp = userDAO.updateCard(cardInput, incomeParse);
                if (temp.equals("Card Edited")) {
                    //Show another view
                    ObservableList<UserCardModel> cards = userDAO.ifCardExistsPerUser();
                    int userIncome = userDAO.getIncomePerUser();
                    displayUserCard(cards, userIncome);
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Card has been " + "edited!", ButtonType.OK);
                    a1.show();

                } else {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                    a1.show();
                }
            }
        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        }
    }

    public void displayUserCard(ObservableList<UserCardModel> userCardModel, int userIncome) {
        ObservableList<String> data = FXCollections.observableArrayList();
        Addeditcard.setText("Edit Card");
        backbutton.setText("Go to Overview");
        topText.setText("Edit card");

        for (UserCardModel card : userCardModel) {
            CardholderName.setText(card.getCardholderName());
            CardNumber.setText(card.getCardNumber());
            ValidDate.setValue(card.getValidDate());
            Cvc.setText(String.valueOf(card.getCvc()));
            Cardnickname.setText(card.getCardNickname());
            EstimatedIncome.setText(String.valueOf(userIncome));
            backbutton.setOnAction(event -> goToOverview(event));
        }
    }
}