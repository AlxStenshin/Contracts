package ru.alxstn.ContractsClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML(), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Contracts Viewer");
        stage.show();
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PrimaryWindow.fxml"));
        Parent parent = fxmlLoader.load();
        parent.setStyle("-fx-font-family: 'Times New Roman'");
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }
}