package com.currencymarket.alert;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();

        window.setTitle(title);
        window.setMinWidth(200);
        window.setMinHeight(200);
        window.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Закрыть");
        closeButton.setOnAction(actionEvent -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().add(label);
        layout.getChildren().add(closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
