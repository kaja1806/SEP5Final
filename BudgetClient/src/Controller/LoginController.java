package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Helpers.User_Authentication;
import java.io.IOException;
import java.rmi.RemoteException;

public class LoginController {
    @FXML
    public Button login;

    @FXML
    public PasswordField Password;

    @FXML
    public TextField username;

    @FXML
    public Label error;

    @FXML
    public void handleLogin(ActionEvent event) throws RemoteException {
        String name = username.getText();
        String pass = Password.getText();

        System.out.println(name + " " + pass);

        int vid = User_Authentication. isValid(name, pass);

        /*if(vid != -1) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                stage.setTitle("Main Page");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            error.setText("Oops something went wrong! Try again !");
        }*/
    }
}


