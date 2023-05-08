package com.currencymarket.controller.auth;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.utils.DBUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            if (!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty()) {
                if (DBUtils.logInUser(usernameField.getText(), passwordField.getText())) {
                    DBUtils.changeScene(signUpButton, "main-page.fxml", "Hello page");
                }
            } else {
                AlertBox.display("", "Заполните поля");
                throw new IllegalArgumentException();
            }
        });

        signUpButton.setOnAction(event -> {
            DBUtils.changeScene(signUpButton, "sing-up.fxml", "Sign-up!");
        });
    }


}