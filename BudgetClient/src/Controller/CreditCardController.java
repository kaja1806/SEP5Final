package Controller;

import BudgetClient.BudgetClient;
import BudgetClient.IBudgetClient;
import Handlers.ClientHelper;
import Handlers.IClientHelper;
import Model.Banks;
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

    public IClientHelper clientHelper;
    public ComboBox NameOfBank;


    public void init(IClientHelper handler) {

        this.clientHelper = handler;
        ObservableList<UserCardModel> cards = handler.ifCardExistsPerUser();
        int userIncome = handler.getIncomePerUser();

        if (cards.size() != 0) {
            displayUserCard(cards, userIncome);
        }
        ObservableList<Banks> banks = handler.getAllBanks();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Banks bank : banks) {
            String bankName = bank.NameOfBank;
            data.add(bankName);
        }
        NameOfBank.setItems(data);
    }

    public void goToOverview(ActionEvent event) throws Exception {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/Overview.fxml"));
            Parent main = loader.load();
            OverviewController ctrl = loader.getController();
            IBudgetClient cl = new BudgetClient();
            IClientHelper handler = new ClientHelper(cl);
            ctrl.init(handler);

            stage.setTitle("Overview");
            stage.setScene(new Scene(main));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ifCardExists(ActionEvent event) throws Exception {
        addCardToUser(event);
    }

    public void addCardToUser(ActionEvent event) throws Exception {

        String cvc = Cvc.getText();
        String income = EstimatedIncome.getText();
        if (NameOfBank.getValue() == null) {
            NameOfBank.setValue("");
        }
        if (income.equals("") || cvc.equals("")) {
            cvc = String.valueOf(0);
            income = String.valueOf(0);
        }
        int cvcParse = Integer.parseInt(cvc);
        int incomeParse = Integer.parseInt(income);

        UserCardModel cardInput = new UserCardModel(CardholderName.getText(), CardNumber.getText(),
                ValidDate.getValue(), cvcParse, Cardnickname.getText(), NameOfBank.getValue().toString());


        if (!(cardInput.CardholderName.isEmpty() || cardInput.getCardNumber().isEmpty() || cardInput.ValidDate == null || cvc.isEmpty())) {
            if (clientHelper.ifCardExistsPerUser().size() == 0) {
                String temp = clientHelper.createCard(cardInput, incomeParse);
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
                String temp = clientHelper.updateCard(cardInput, incomeParse);
                if (temp.equals("Card Edited")) {
                    //Show another view
                    ObservableList<UserCardModel> cards = clientHelper.ifCardExistsPerUser();
                    int userIncome = clientHelper.getIncomePerUser();
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
            backbutton.setOnAction(event -> {
                try {
                    goToOverview(event);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}