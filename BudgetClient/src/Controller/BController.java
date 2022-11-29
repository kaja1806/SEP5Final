package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BController {
    @FXML
    private Label loginInResultLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    /*private LoginVM loginVM;
    private ViewHandler viewHandler;

    public void init(LoginVM loginvm, ViewHandler viewHandler){
        this.loginVM = loginvm;
        this.viewHandler = viewHandler;
        usernameTextField.textProperty().bindBidirectional(loginVM.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(loginVM.passwordProperty());
        loginInResultLabel.textProperty().bindBidirectional(loginVM.loginResponseProperty());

        loginVM.loginResponseProperty().addListener((observableValue, s, t1) -> onLoginResult(t1));
    }

    private void onLoginResult(String t1) {
        if("OK".equals(t1)){
            viewHandler.openChatView();
        }
    }


    public void onRegisterButton(ActionEvent actionEvent) {

    }

    public void onLoginButton(ActionEvent actionEvent) {

        loginVM.login();
    }*/
}
