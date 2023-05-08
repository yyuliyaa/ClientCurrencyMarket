package com.currencymarket.controller.admin;

import com.currencymarket.dto.admindto.CompanyRequestStatus;
import com.currencymarket.utils.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAllCompanies implements Initializable {

    private ObservableList<CompanyRequestStatus> tableData = FXCollections.observableArrayList();

    @FXML
    private javafx.scene.layout.VBox VBox;

    @FXML
    private TableColumn<?, ?> colCompanyname;

    @FXML
    private TableColumn<?, ?> colOwner;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<CompanyRequestStatus> companyTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCompanyname.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colOwner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("companyStatus"));

        tableData.clear();
        tableData = FXCollections.observableArrayList(DBUtils.getAllCompany());
        System.out.println(tableData);
        companyTable.setItems(tableData);
    }
}
