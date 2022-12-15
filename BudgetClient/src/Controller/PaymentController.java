package Controller;

import BudgetClient.BudgetClient;
import BudgetClient.IBudgetClient;
import Handlers.ClientHelper;
import Handlers.IClientHelper;
import Model.Category;
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

public class PaymentController {
    public Button registerPayment;
    public TextField amountField;
    public ComboBox Categories;
    public Button goToOverview;

    public IClientHelper clientHelper;


    public void init(IClientHelper handler) {

        this.clientHelper = handler;

        ObservableList<Category> categories = handler.getAllCategories();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Category cat : categories) {
            String categoryName = cat.CategoryName;
            data.add(categoryName);
        }
        Categories.setItems(data);
    }

    public void registerPayment() {

        int amount = Integer.parseInt(amountField.getText());
        String categoryName = Categories.getValue().toString();
        String paymentResponse = clientHelper.addPayment(categoryName, amount);
        Alert a1 = new Alert(Alert.AlertType.INFORMATION, paymentResponse, ButtonType.OK);
        a1.show();
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
}