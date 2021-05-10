package DataVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataVisualizer extends Application {
    Controller theController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Fudayl and Alonso");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();

        theController = loader.getController();
        theController.setMyStage(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        theController.gameSave();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
