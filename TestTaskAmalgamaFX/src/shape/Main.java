package shape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane loginNode = (AnchorPane)FXMLLoader.load(getClass().getResource("shape.fxml"));
        Scene loginScene = new Scene(loginNode);
        primaryStage.setTitle("Test Task Amalgama");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
