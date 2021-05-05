package DataVisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataVisualizer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        primaryStage.setTitle("Fudayl and Alonso");
        primaryStage.setScene(new Scene(root, 668, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
