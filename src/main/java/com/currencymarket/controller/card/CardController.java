package com.currencymarket.controller.card;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.dto.carddto.CardDto;
import com.currencymarket.state.State;
import com.currencymarket.utils.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CardController implements Initializable {
    @FXML
    private TextField cardNumberField;

    @FXML
    private PasswordField cvField;

    @FXML
    private Button cardButton;


    @FXML
    void activeButton(ActionEvent event) {
        if(cardNumberField.getText().matches("\\d{16}") && cvField.getText().matches("\\d{3}")){
            DBUtils.activateCard(new CardDto(State.homePageDto.getId(),cardNumberField.getText(),  Integer.parseInt(cvField.getText()), 50000));
        } else {
            AlertBox.display("","Заполните данные корректно.\n 16 символов - длина карты. 3 символа - cv");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CardDto cardDto = DBUtils.getCard(State.homePageDto.getId());
        if(cardDto == null){
            cardButton.setDisable(false);
        } else {
            cardButton.setText("Карта активирована");
            cardNumberField.setText(cardDto.getNumber());
            cardButton.setDisable(true);
        }
    }
}
