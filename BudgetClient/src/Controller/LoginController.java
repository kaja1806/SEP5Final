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

    
}


