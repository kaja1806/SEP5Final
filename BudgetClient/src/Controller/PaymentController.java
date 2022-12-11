package Controller;

import DB.CategoryDAO;
import DB.PaymentDAO;
import Model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    public Button registerPayment;
    public TextField amountField;
    public ComboBox Categories;

    CategoryDAO ca = new CategoryDAO();

    public void initialize() {

        ObservableList<Category> categories = ca.getAllCategories();
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
        PaymentDAO payment = new PaymentDAO();

        payment.addPayment(categoryName, amount);
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
}