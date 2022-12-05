package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class OverviewController {
    public PieChart pieChart;
    /*public Button paymentBtn;
    public TableColumn<Payment, String> paymentDate;
    public TableColumn<Payment, Integer> paymentAmount;
    public TableView<Payment> paymentTable;
    private Model.OverviewModel OverviewModel;
    private Object model;*/


/*    public void updatePie() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(new PieChart.Data("Food - " + model.),
                        new PieChart.Data("Transport - " + model.),
                        new PieChart.Data("Grocery - " + model.),
                        new PieChart.Data("Night life- " + model.));

        pieChart.setData(pieChartData);
        pieChart.setLabelsVisible(false);

        for (PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    updatePie();
                    showAllStatues();
                }

                private void showAllStatues() {
                }
            });
        }
    }
    */

    public void makePayment(ActionEvent event) {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Payment.fxml"));
            stage.setTitle("Registration");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

