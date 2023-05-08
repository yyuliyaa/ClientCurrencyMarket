package com.currencymarket.controller.mainpage;

import com.currencymarket.Application;
import com.currencymarket.state.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Button company;
    @FXML
    private Label cashField;

    @FXML
    private Label nameField;

    @FXML
    private VBox wrapper;

    @FXML
    void editProfile() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("home_change-password.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    @FXML
    void transaction() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("home-transaction.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    @FXML
    void openCompany() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("home-company.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameField.setText(State.homePageDto.getUsername());
        cashField.setText(String.valueOf(State.homePageDto.getCash()));
        if(State.homePageDto.getRole().equals("ADMIN")) {
            company.setVisible(false);
        }
        try {
            transaction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
