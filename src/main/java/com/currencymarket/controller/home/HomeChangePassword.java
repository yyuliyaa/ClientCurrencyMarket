package com.currencymarket.controller.home;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.utils.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.util.Optional;

public class HomeChangePassword {

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private PasswordField repeatNewPassword;

    @FXML
    void changePassword() {
        String newPassword = this.newPassword.getText();
        String oldPassword = this.oldPassword.getText();
        String repeatNewPassword  = this.repeatNewPassword.getText();

        if (newPassword.length() != 0 && oldPassword.length() != 0  && repeatNewPassword.length() != 0 ) {
            if (newPassword.equals(repeatNewPassword)) {
                boolean response = DBUtils.updatePassword(oldPassword, newPassword);
                if(response) {
                    AlertBox.display("","Пароль успешно изменен!");
                } else {
                    AlertBox.display("","Старый пароль не совпадает!");
                }
            } else {
                AlertBox.display("Ошибка", "Пароли не совпадают. Попробуйте снова!");
            }
        } else {
            AlertBox.display("Ошибка", "Заполните все поля!");
        }

    }
}
