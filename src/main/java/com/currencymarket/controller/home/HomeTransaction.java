package com.currencymarket.controller.home;

import com.currencymarket.dto.transactiondto.TransactionDto;
import com.currencymarket.entity.Transaction;
import com.currencymarket.state.State;
import com.currencymarket.utils.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeTransaction implements Initializable {
    private ObservableList<TransactionDto> tableData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> col_amount;

    @FXML
    private TableColumn<?, ?> col_company;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private TableColumn<?, ?> col_price;

    @FXML
    private TableColumn<?, ?> col_result;

    @FXML
    private Button reportButton;

    @FXML
    private TableColumn<?, ?> col_type;

    @FXML
    private TableView<TransactionDto> transactionTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_date.setCellValueFactory(new PropertyValueFactory<>("localDateTime"));
        col_company.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("transactionalType"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col_result.setCellValueFactory(new PropertyValueFactory<>("result"));
        List<Transaction> completedTransaction = DBUtils.getCompletedTransaction(State.homePageDto.getId());
        tableData.clear();
        tableData = FXCollections.observableArrayList(convertTransactionToTableStyle(completedTransaction));
        transactionTable.setItems(tableData);
    }


    private List<TransactionDto> convertTransactionToTableStyle(List<Transaction> transactionList) {
        System.out.println(transactionList);
        return transactionList.stream().map((transaction -> {
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setAmount(transaction.getAmount());
            transactionDto.setCompanyName("");
//                    State.companyList.stream()
//                            .filter(company -> company.getCompanyId() == (transaction.getCompanyId()))
//                            .findFirst()
//                            .get()
//                            .getCompanyName());
            transactionDto.setTransactionalType(transaction.getTransactionalType());
            transactionDto.setPrice(transaction.getPrice());
            transactionDto.setLocalDateTime(transaction.getLocalDateTime());
            transactionDto.setResult(transaction.getAmount() * transaction.getPrice());
            return transactionDto;
        })).toList();
    }

    @FXML
    void reportButton() {
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null) {
            job.showPrintDialog(reportButton.getScene().getWindow());
            job.printPage(transactionTable);
            job.endJob();
        }
    }
}
