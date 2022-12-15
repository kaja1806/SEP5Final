package Controller;

import BudgetClient.BudgetClient;
import BudgetClient.IBudgetClient;
import Handlers.ClientHelper;
import Handlers.IClientHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class OverviewController {
    public PieChart pieChart;
    public AnchorPane border;

    public IClientHelper clientHelper;

    public void init(IClientHelper handler) {
        this.clientHelper = handler;
        if (pieChart != null) {
            ObservableList<PieChart.Data> data = handler.getAllExpenses();
            pieChart.getData().addAll(data);
        }
    }

    public void makePayment() throws Exception {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/Payment.fxml"));
            Parent main = loader.load();
            PaymentController ctrl = loader.getController();
            IBudgetClient cl = new BudgetClient();
            IClientHelper handler = new ClientHelper(cl);
            ctrl.init(handler);

            stage.setTitle("Expense");
            stage.setScene(new Scene(main));
            stage.show();
            border.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seePremium() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/About.fxml"));
            stage.setTitle("Premium");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToSettings() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
            stage.setTitle("Premium");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extraUser() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load((getClass().getResource("/View/ExtraUser.fxml")));
            stage.setTitle("Extra User");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCard() throws Exception {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/CreditCard.fxml"));
            Parent main = loader.load();
            CreditCardController ctrl = loader.getController();
            IBudgetClient cl = new BudgetClient();
            IClientHelper handler = new ClientHelper(cl);
            ctrl.init(handler);

            stage.setTitle("Credit Card");
            stage.setScene(new Scene(main));
            stage.show();
            border.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void goToOverview(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}

