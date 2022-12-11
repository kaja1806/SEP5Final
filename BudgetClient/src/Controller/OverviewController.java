package Controller;

import DB.ExpensesDAO;
import Model.OverviewModel;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class OverviewController {
    public PieChart pieChart;
    public Button statusBtn;
    public TableColumn<OverviewModel, Integer> amount;
    public TableColumn<OverviewModel, String> category;

    ExpensesDAO ex = new ExpensesDAO();

    public void initialize() {
        ObservableList<PieChart.Data> data = ex.getAllExpenses();
        pieChart.getData().addAll(data);
    }


    public void makePayment() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Payment.fxml"));
            stage.setTitle("Registration");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

