package com.currencymarket.controller.mainpage;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.dto.clientdto.StockPortfolio;
import com.currencymarket.dto.carddto.CardDto;
import com.currencymarket.dto.clientdto.UpdateCashDto;
import com.currencymarket.state.State;
import com.currencymarket.utils.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class Wallet implements Initializable {
    private ObservableList<StockPortfolio> tableData = FXCollections.observableArrayList();

    @FXML
    private TableView<StockPortfolio> bagTable;

    @FXML
    private TableColumn<?, ?> colCompany;

    @FXML
    private TableColumn<?, ?> colCounterOfStocks;

    @FXML
    private TableColumn<?, ?> colPersentOfCompanyAssets;

    @FXML
    private TextField sumField;

    @FXML
    private Label balance;

    @FXML
    void updateBalance(ActionEvent event) {
        float cash = Float.parseFloat(sumField.getText().trim());
        CardDto card = DBUtils.getCard(State.homePageDto.getId());
        if(Objects.equals(card,null)) {
            AlertBox.display("", "Не привязана карта. Пожулуйста, привяжите карту");

        } else {
            float assumedCash = (float) (State.homePageDto.getCash() + cash);
            if (assumedCash > 0 && assumedCash < Float.MAX_VALUE && cash > 0) {
                float cashFromCart = DBUtils.getCashFromCard(State.homePageDto.getId());
                if(cashFromCart - cash >= 0) {
                    UpdateCashDto updateCashDto = new UpdateCashDto();
                    updateCashDto.setCash(cash);
                    updateCashDto.setId(State.homePageDto.getId());
                    balance.setText(String.valueOf(DBUtils.updateCash(updateCashDto)));
                    State.homePageDto.setCash(Double.parseDouble(balance.getText()));

                } else {
                    AlertBox.display("", "На карте недостаточно средств");
                }
            } else {
                AlertBox.display("", "Введите корректные значения");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableData.clear();

        colCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCounterOfStocks.setCellValueFactory(new PropertyValueFactory<>("counterOfStocks"));
        colPersentOfCompanyAssets.setCellValueFactory(new PropertyValueFactory<>("percentAssetsOfCompany"));


        tableData = FXCollections.observableArrayList(DBUtils.getWalletOfAssets(State.homePageDto.getId()));
        bagTable.setItems(tableData);
        balance.setText(String.valueOf(State.homePageDto.getCash()));
    }


}
