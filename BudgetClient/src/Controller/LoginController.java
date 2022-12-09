package Controller;


import Helpers.User_Authentication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


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

    private void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText("Something went wrong! ");
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    }
    @FXML
    public void handleLogin(ActionEvent event) {
        String name = username.getText();
        String pass = password.getText();


        int uid = User_Authentication.isValid(name, pass);

        if (uid != -1) {
            goToOverview(event);

        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "User " + username.getText() + " doesn't exist !", ButtonType.OK);
            a1.show();;
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

