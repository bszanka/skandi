package lotto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rt = FXMLLoader.load(getClass().getResource("lotto.fxml"));
        primaryStage.setTitle("Skandi App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(rt));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
