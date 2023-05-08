package com.currencymarket.controller.auth;

import com.currencymarket.utils.DBUtils;
import com.currencymarket.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

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
        signUpButton.setOnAction(event -> {
            if (usernameField.getText().trim().matches("[^\\d][a-zA-Z\\d]{5,30}")
                    && passwordField.getText().trim().matches("[^\s]{5,30}")) {
                if (DBUtils.signUpUser(usernameField.getText(), passwordField.getText())) {
                    DBUtils.changeScene(signUpButton, "main-page.fxml", "Hello page");
                } else {
                    usernameField.setText("try again");
                }
            } else {
                AlertBox.display("Ошибка", "Логин не должен начинаться с цифры и должен содержать от 5 до 30 символов\n" +
                        "Пароль должен содержать от 5 до 30 символом и не должен содержать пробелов.");
                throw new IllegalArgumentException();
            }
        });

        loginButton.setOnAction(event -> {
            DBUtils.changeScene(loginButton, "sing-in.fxml", "Sign up!");
        });
    }

    @FXML
    void signUpButtonAction(ActionEvent event) {

    }
}
