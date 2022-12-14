package Controller;

import DB.User_Authentication;
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

    @FXML
    public void handleLogin(ActionEvent event) {
        String name = username.getText();
        String pass = password.getText();

        uid = User_Authentication.isValid(name, pass);

        if (uid != 0) {
            goToOverview(event);

        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + username.getText() + " doesn't exist !",
                    ButtonType.OK);
            a1.show();
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

    public void goToRegistration(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Registration.fxml"));
            stage.setTitle("Registration");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}