package BudgetClient;

import Controller.BController;
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
        loader.setLocation(getClass().getResource("/View/BClient.fxml"));
        Parent main = loader.load();
        BController ctrl = loader.getController();
        IBudgetClient cl = new BudgetClient();
        /*IECModel model = new ECModel(cl);
        ctrl.init(model);*/
        primaryStage.setTitle("Budget");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}
