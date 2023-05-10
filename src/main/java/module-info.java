module com.currencymarket.courseproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.currencymarket to javafx.fxml;
    exports com.currencymarket;
////    exports com.currencymarket.controllers;
//    opens com.currencymarket.controllers to javafx.fxml;
    exports com.currencymarket.alert;
    opens com.currencymarket.alert to javafx.fxml;
    exports com.currencymarket.dto.admindto;
    opens com.currencymarket.dto.admindto to javafx.base, javafx.fxml;
    exports com.currencymarket.controller.admin;
    opens com.currencymarket.controller.admin to javafx.fxml;
    exports com.currencymarket.controller.mainpage;
    opens com.currencymarket.controller.mainpage to javafx.fxml;
    exports com.currencymarket.state;
    opens com.currencymarket.state to javafx.fxml;
    exports com.currencymarket.utils;
    opens com.currencymarket.utils to javafx.fxml;
    exports com.currencymarket.controller.home;
    opens com.currencymarket.controller.home to javafx.fxml;
    exports com.currencymarket.dto;
    opens com.currencymarket.dto to javafx.base, javafx.fxml;
    exports com.currencymarket.dto.chatdto;
    opens com.currencymarket.dto.chatdto to javafx.base, javafx.fxml;
    exports com.currencymarket.dto.companydto;
    opens com.currencymarket.dto.companydto to javafx.base, javafx.fxml;
    exports com.currencymarket.controller.auth;
    opens com.currencymarket.controller.auth to javafx.fxml;
    exports com.currencymarket.controller.market;
    opens com.currencymarket.controller.market to javafx.fxml;
    exports com.currencymarket.dto.transactiondto;
    opens com.currencymarket.dto.transactiondto to javafx.base, javafx.fxml;
    opens com.currencymarket.entity to javafx.base;
    exports com.currencymarket.controller.card to  javafx.fxml;
    opens com.currencymarket.controller.card to  javafx.fxml;
    exports com.currencymarket.dto.clientdto;
    opens com.currencymarket.dto.clientdto to javafx.base, javafx.fxml;

}