package KONIG.CENTRAL.MAIN;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/KONIG/CENTRAL/GUI/Fxmls/dashboard.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Project Fiscus Procuratio V1.0");
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }
}
