package Controller;

import DB.CategoryDAO;
import DB.PaymentDAO;
import Model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

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
}
