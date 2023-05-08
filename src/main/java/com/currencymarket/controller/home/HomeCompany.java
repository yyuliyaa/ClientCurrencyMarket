package com.currencymarket.controller.home;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.dto.companydto.CreateCompanyDto;
import com.currencymarket.dto.companydto.CurrentCompanyStatusDto;
import com.currencymarket.state.State;
import com.currencymarket.utils.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeCompany implements Initializable {
    private ObservableList<CurrentCompanyStatusDto> tableData = FXCollections.observableArrayList();
    @FXML
    private TableView<CurrentCompanyStatusDto> companyTable;
    @FXML
    private TableColumn<?, ?> colNumberOfRequest;

    @FXML
    private TableColumn<?, ?> comCompanyStatus;

    @FXML
    private TextField fieldCompanyInfo;

    @FXML
    private TextField fieldCompanyName;

    @FXML
    private TextField fieldPriceOfStocks;

    @FXML
    private TextField fieldStockAmount;

    @FXML
    void checkStatusOfRequestButton(ActionEvent event) {
        tableData.clear();
        tableData = FXCollections.observableArrayList(DBUtils.getCurrentCompanyStatus());
        System.out.println(tableData);
        companyTable.setItems(tableData);
    }

    @FXML
    void sendRequestButton(ActionEvent event) {
        boolean companyName = fieldCompanyName.getText().trim().matches("[a-zA-Z]{3,20}");
//        boolean companyInfo = fieldCompanyInfo.getText().trim().matches("[a-zA-Z\\d]{0,250}");
        boolean stock = fieldStockAmount.getText().matches("\\d{0,20000}[.]?\\d{0,5}");
        boolean stockPrice = fieldPriceOfStocks.getText().matches("\\d{0,20000}[.]?\\d{0,5}");
        if (companyName && stock && stockPrice) {
            CreateCompanyDto companyDto = new CreateCompanyDto();
            companyDto.setOwner_id(State.homePageDto.getId());
            companyDto.setCompanyName(fieldCompanyName.getText().trim());
            companyDto.setStockPrice(Float.parseFloat(fieldPriceOfStocks.getText()));
            companyDto.setCounterOfStocks(Float.parseFloat(fieldStockAmount.getText()));
            companyDto.setCompanyInfo(fieldCompanyInfo.getText());
            String message = DBUtils.sendCompanyRequest(companyDto);
            AlertBox.display("","Заявка на создание компании успешно отправлена!");
        } else {
            AlertBox.display("", "Введите корректные данные!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comCompanyStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colNumberOfRequest.setCellValueFactory(new PropertyValueFactory<>("id"));
    }
}
