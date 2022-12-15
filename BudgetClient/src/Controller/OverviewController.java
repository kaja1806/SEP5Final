package Controller;

import DB.ExpensesDAO;

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

    ExpensesDAO ex = new ExpensesDAO();

    public void initialize() {
        if (pieChart != null) {
            ObservableList<PieChart.Data> data = ex.getAllExpenses();
            pieChart.getData().addAll(data);
        }
    }

    public void makePayment() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Payment.fxml"));
            stage.setTitle("Registration");
            stage.setScene(new Scene(root));
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

    public void addCard() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/CreditCard.fxml"));
            stage.setTitle("Credit Card");
            stage.setScene(new Scene(root));
            stage.show();
            border.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goToSettings(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void goToOverview(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}

