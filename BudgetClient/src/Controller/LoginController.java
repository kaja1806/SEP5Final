package Controller;

import BudgetClient.BudgetClient;
import BudgetClient.IBudgetClient;
import Handlers.ClientHelper;
import Handlers.IClientHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    @FXML
    public Button login;
    @FXML
    public Button registration;
    @FXML
    public TextField username;
    @FXML
    public Label error;
    public PasswordField password;

    public int uid;

    public IClientHelper clientHelper;

    public void init(IClientHelper handler) {

        this.clientHelper = handler;
    }

    @FXML
    public void handleLogin(ActionEvent event) throws Exception {
        String name = username.getText();
        String pass = password.getText();

        uid = clientHelper.validateUser(name, pass);

        if (uid != 0) {
            goToOverview(event);

        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + username.getText() + " doesn't exist !",
                    ButtonType.OK);
            a1.show();
        }
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

    public void goToRegistration(ActionEvent event) throws Exception {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/Registration.fxml"));
            Parent main = loader.load();
            RegistrationController ctrl = loader.getController();
            IBudgetClient cl = new BudgetClient();
            IClientHelper handler = new ClientHelper(cl);
            ctrl.init(handler);

            stage.setTitle("Registration");
            stage.setScene(new Scene(main));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}