package com.currencymarket.controller.admin;

import com.currencymarket.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminMainController implements Initializable {
    @FXML
    private Button getApplication;

    @FXML
    private Button getUsersButton;

    @FXML
    private VBox wrapper;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            onClickgetUsersButton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onClickGetApplication() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("admin_company_request.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    @FXML
    void onClickgetUsersButton() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("admin_clients.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }
    @FXML
    void onClickGetAllCompanies() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("admin_all_companies.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

}
