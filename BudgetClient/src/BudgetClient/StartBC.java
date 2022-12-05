package BudgetClient;

import Controller.LoginController;
import Controller.RegistrationController;
import Model.UserModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartBC extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        //  UserModel.NameOfBanks nameOfBanks = new UserModel.NameOfBanks();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Login.fxml"));
        Parent main = loader.load();
        // LoginController ctrl = loader.getController();

        //Populate the Combobox field with bank names

        primaryStage.setTitle("Budget");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}
