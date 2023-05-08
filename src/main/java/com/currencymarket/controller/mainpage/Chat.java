package com.currencymarket.controller.mainpage;

import com.currencymarket.dto.chatdto.MessageDto;
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
import java.util.ResourceBundle;

public class Chat implements Initializable {
    private ObservableList<MessageDto> tableData = FXCollections.observableArrayList();
    @FXML
    private TableView<MessageDto> chatTable;

    @FXML
    private TableColumn<?, ?> colMessage;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TextField messageField;
    @FXML
    private TableColumn<?, ?> colTime;
    @FXML
    private Button sendButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("username"));
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("date"));
        loadDataFromDB();
    }
    @FXML
    void sendButtonAction(ActionEvent event) {
        String text = messageField.getText();
        int id = State.homePageDto.getId();
        MessageDto messageDto = new MessageDto();
        messageDto.setId(id);
        messageDto.setMessage(text);
        DBUtils.sendMessage(messageDto);
        messageField.clear();
        loadDataFromDB();
    }

    @FXML
    void getMessageButton(ActionEvent event) {
        loadDataFromDB();
    }
    private void loadDataFromDB() {
        tableData.clear();
        tableData = FXCollections.observableArrayList(DBUtils.getMessage());
        System.out.println(tableData);
        chatTable.setItems(tableData);
    }

}
