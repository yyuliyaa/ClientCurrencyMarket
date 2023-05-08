package com.currencymarket.controller.admin;

import com.currencymarket.utils.DBUtils;
import com.currencymarket.alert.AlertBox;
import com.currencymarket.command.ClientRole;
import com.currencymarket.command.ClientStatus;
import com.currencymarket.dto.admindto.ClientInformationDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminClientController implements Initializable {
    private ObservableList<ClientInformationDto> tableData = FXCollections.observableArrayList();

    @FXML
    private TableView<ClientInformationDto> adminTable;


    @FXML
    private TableColumn<?, ?> col_activated;

    @FXML
    private TableColumn<?, ?> col_id;

    @FXML
    private TableColumn<?, ?> col_role;

    @FXML
    private TableColumn<?, ?> col_username;
    @FXML
    private Button getUsersButton;

    @FXML
    private ComboBox<ClientStatus> activatedBox;

    @FXML
    private Label idField;
    @FXML
    private Label usernameField;
    @FXML
    private ComboBox<ClientRole> roleBox;

    @FXML
    private Button updateButton;

    @FXML
    private VBox wrapper;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_activated.setCellValueFactory(new PropertyValueFactory<>("activated"));

        roleBox.getItems().add(ClientRole.ADMIN);
        roleBox.getItems().add(ClientRole.USER);

        activatedBox.getItems().add(ClientStatus.ACTIVE);
        activatedBox.getItems().add(ClientStatus.BANNED);

        loadDataFromDB();

    }

    @FXML
    void onUpdateButton(ActionEvent event) {
        Optional<ClientInformationDto> selectedItem = Optional.ofNullable(adminTable.getSelectionModel().getSelectedItem());
        if (selectedItem.isPresent()) {
            ClientInformationDto clientInformationDto = new ClientInformationDto();
            clientInformationDto.setId(Integer.parseInt(idField.getText()));
            clientInformationDto.setUsername(usernameField.getText());
            clientInformationDto.setActivated(String.valueOf(activatedBox.getValue()));
            clientInformationDto.setRole(String.valueOf(roleBox.getValue()));
            String operationResult = DBUtils.updateClient(clientInformationDto);
            AlertBox.display("", operationResult);
        } else {
            AlertBox.display("Exception", "Выберите строку");
        }
        loadDataFromDB();
    }

    @FXML
    void getSelectedItem(MouseEvent event) {
        Optional<ClientInformationDto> selectedItem = Optional.ofNullable(adminTable.getSelectionModel().getSelectedItem());
        if (selectedItem.isPresent()) {
            idField.setText(String.valueOf(selectedItem.get().getId()));
            usernameField.setText(selectedItem.get().getUsername());
            roleBox.getSelectionModel().select(ClientRole.valueOf(selectedItem.get().getRole()));
            activatedBox.getSelectionModel().select(ClientStatus.valueOf(selectedItem.get().getActivated()));
        }
    }

    private void loadDataFromDB() {
        tableData.clear();
        tableData = FXCollections.observableArrayList(DBUtils.getAllUsers());
        System.out.println(tableData);
        adminTable.setItems(tableData);
    }


}