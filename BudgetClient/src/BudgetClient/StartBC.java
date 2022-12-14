package BudgetClient;

import Controller.LoginController;
import Controller.RegistrationController;
import Handlers.ClientHelper;
import Handlers.IClientHelper;
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

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Registration.fxml"));
        Parent main = loader.load();
        RegistrationController ctrl = loader.getController();

        IBudgetClient cl = new BudgetClient();

        IClientHelper handler = new ClientHelper(cl);

        ctrl.init(handler);


        primaryStage.setTitle("Budget");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}
