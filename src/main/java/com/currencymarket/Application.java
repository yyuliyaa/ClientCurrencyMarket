package com.currencymarket;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("sing-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log in!");
        stage.setScene(scene);
        stage.show();
        stage.setMaxWidth(1600);
        stage.setMaxHeight(900);

    }

    public static void main(String[] args) {
        launch();
    }
}