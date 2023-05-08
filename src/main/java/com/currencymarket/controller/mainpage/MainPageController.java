package com.currencymarket.controller.mainpage;

import com.currencymarket.Application;
import com.currencymarket.utils.DBUtils;
import com.currencymarket.state.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    private Button admin;
    @FXML
    private Label cash;
    @FXML
    private Label nickname;
    @FXML
    private Button exit;

    @FXML
    private Label nicknameInfo;

    @FXML
    private VBox wrapper;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
//            nickname.setText(State.homePageDto.getUsername());
//            cash.setText(String.valueOf(State.homePageDto.getCash()));
            if (State.homePageDto.getRole().equals("USER")) {
                admin.setVisible(false);
            }
            home();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chat() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("chat.fxml")));
        System.out.println("fhikasdja");
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    public void wallet() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("wallet.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);


    }

    public void home() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("home.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    public void adminButton() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("admin_main.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    public void marketButton() throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("market.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }

    @FXML
    public void exitAction(ActionEvent event) {
        DBUtils.exit();
        DBUtils.changeScene(exit, "sing-in.fxml", "Sign-in!");
    }

    @FXML
    void createCardButton(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(Application.class.getResource("card.fxml")));
        wrapper.getChildren().removeAll();
        wrapper.getChildren().setAll(fxml);
    }
}
