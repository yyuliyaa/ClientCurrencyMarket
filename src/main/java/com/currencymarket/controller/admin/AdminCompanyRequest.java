package com.currencymarket.controller.admin;

import com.currencymarket.utils.DBUtils;
import com.currencymarket.alert.AlertBox;
import com.currencymarket.command.CompanyStatus;
import com.currencymarket.dto.admindto.CompanyRequestStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminCompanyRequest implements Initializable {
    private ObservableList<CompanyRequestStatus> tableData = FXCollections.observableArrayList();

    @FXML
    private VBox VBox;

    @FXML
    private ComboBox<CompanyStatus> comboStatus;


    @FXML
    private TableView<CompanyRequestStatus> companyTable;

    @FXML
    private TableColumn<?, ?> company_name_field;

    @FXML
    private TableColumn<?, ?> owner_field;

    @FXML
    private TableColumn<?, ?> status_field;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        company_name_field.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        owner_field.setCellValueFactory(new PropertyValueFactory<>("owner"));
        status_field.setCellValueFactory(new PropertyValueFactory<>("companyStatus"));

        comboStatus.getItems().add(CompanyStatus.CONFIRMED);
        comboStatus.getItems().add(CompanyStatus.WAITING);
        download();
    }

    @FXML
    void changeStatus() {
        Optional<CompanyRequestStatus> selectedItem = Optional.ofNullable(companyTable.getSelectionModel().getSelectedItem());
        if (selectedItem.isPresent()) {
            CompanyRequestStatus companyRequestStatus = new CompanyRequestStatus();
            companyRequestStatus.setCompanyName(company_name_field.getText());
            companyRequestStatus.setCompanyStatus(comboStatus.getValue().toString());
            companyRequestStatus.setOwner(owner_field.getText());
            System.out.println(companyRequestStatus);
            String operationResult = DBUtils.updateCompanyStatus(companyRequestStatus);
            AlertBox.display("", operationResult);
        } else {
            AlertBox.display("Exception", "Выберите строку");
        }
    }

    @FXML
    void download() {
        tableData.clear();
        tableData = FXCollections.observableArrayList(DBUtils.getWaitingCompanies());
        System.out.println(tableData);
        companyTable.setItems(tableData);
    }

    @FXML
    void getSelectItem() {
        Optional<CompanyRequestStatus> companyRequestStatus = Optional.ofNullable(companyTable.getSelectionModel().getSelectedItem());
        if (companyRequestStatus.isPresent()) {
            comboStatus.getSelectionModel().select(CompanyStatus.valueOf(companyRequestStatus.get().getCompanyStatus()));
            company_name_field.setText(companyRequestStatus.get().getCompanyName());
            owner_field.setText(companyRequestStatus.get().getOwner());
        }
    }
}
