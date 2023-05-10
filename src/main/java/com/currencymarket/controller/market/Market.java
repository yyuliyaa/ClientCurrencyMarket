package com.currencymarket.controller.market;

import com.currencymarket.alert.AlertBox;
import com.currencymarket.dto.ChartDto;
import com.currencymarket.dto.clientdto.StockPortfolio;
import com.currencymarket.dto.companydto.CompanyMarketStatus;
import com.currencymarket.dto.transactiondto.BuySellDto;
import com.currencymarket.dto.transactiondto.HistoryDto;
import com.currencymarket.dto.transactiondto.SellAssetDto;
import com.currencymarket.state.State;
import com.currencymarket.utils.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Market implements Initializable {

    private ObservableList<CompanyMarketStatus> tableData = FXCollections.observableArrayList();
    private ObservableList<StockPortfolio> assetData = FXCollections.observableArrayList();
    private ObservableList<BuySellDto> buySellData = FXCollections.observableArrayList();
    private ObservableList<HistoryDto> marketData = FXCollections.observableArrayList();

    @FXML
    private TableView<StockPortfolio> activeTable;
    @FXML
    private TableColumn<?, ?> colCompanyNameActive;
    @FXML
    private TableColumn<?, ?> colCounterOfStockActive;
    @FXML
    private TableColumn<?, ?> colPercentOfCompanyStock;


    @FXML
    private TableView<BuySellDto> byuSellTable;
    @FXML
    private TableColumn<?, ?> colCompanyName;
    @FXML
    private TableColumn<?, ?> colCounterOfStock;
    @FXML
    private TableColumn<?, ?> colPriceOfStock;
    @FXML
    private TableColumn<?, ?> colBuySell;


    @FXML
    private TableView<HistoryDto> historyMarketTable;
    @FXML
    private TableColumn<?, ?> colBuySellHistoryTable;
    @FXML
    private TableColumn<?, ?> colCounterOfBuySell;
    @FXML
    private TableColumn<?, ?> colStatus;
    @FXML
    private TableColumn<?, ?> colTime;


    @FXML
    private TableView<CompanyMarketStatus> marketTable;
    @FXML
    private TableColumn<?, ?> colCompanyNameMarketTable;

    @FXML
    private TableColumn<?, ?> colChanging;

    @FXML
    private TableColumn<?, ?> colCompanyPrice;


    @FXML
    private AnchorPane ChartWrapper;


    @FXML
    private TextField fieldCompany;

    @FXML
    private TextField fieldCounter;

    @FXML
    private TextField fieldPrice;


    private List<ChartDto> chartDtoList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCompanyNameMarketTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colChanging.setCellValueFactory(new PropertyValueFactory<>("percent"));

        colCompanyNameActive.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCounterOfStockActive.setCellValueFactory(new PropertyValueFactory<>("counterOfStocks"));
        colPercentOfCompanyStock.setCellValueFactory(new PropertyValueFactory<>("percentAssetsOfCompany"));

        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCounterOfStock.setCellValueFactory(new PropertyValueFactory<>("counterOfStocks"));
        colPriceOfStock.setCellValueFactory(new PropertyValueFactory<>("price"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("status"));

        colBuySellHistoryTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCounterOfBuySell.setCellValueFactory(new PropertyValueFactory<>("counterOfStocks"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("localDateTime"));


        loadDataFromDB();
    }

    List<StockPortfolio> walletOfAssets;

    @FXML
    void updateButton(ActionEvent event) {
        loadDataFromDB();
    }

    private void loadDataFromDB() {
        tableData.clear();
        assetData.clear();
        buySellData.clear();
        walletOfAssets = DBUtils.getWalletOfAssets(State.homePageDto.getId());
        assetData = FXCollections.observableArrayList(DBUtils.getWalletOfAssets(State.homePageDto.getId()));
        tableData = FXCollections.observableArrayList(DBUtils.getCompanyShares());
        buySellData = FXCollections.observableArrayList(DBUtils.getActiveTransaction());


        activeTable.setItems(assetData);
        marketTable.setItems(tableData);
        byuSellTable.setItems(buySellData);


    }

    @FXML
    void buyButton(ActionEvent event) {
        BuySellDto assetDto = byuSellTable.getSelectionModel()
                .getSelectedItem();
        if (!assetDto.equals(null)) {
            System.out.println(assetDto);
            assetDto.setUserId(State.homePageDto.getId());
            DBUtils.buyAssets(assetDto);
        } else {
            AlertBox.display("", "Выберите значение.");
        }
    }

    @FXML
    void clickBuySellButton(MouseEvent event) {

    }

    @FXML
    void click(MouseEvent event) {
        Optional<StockPortfolio> assetDto = Optional.ofNullable(activeTable.getSelectionModel()
                .getSelectedItem());
        if (assetDto.isPresent()) {
            fieldCompany.setText(assetDto.get()
                    .getCompanyName());
        }
    }

    @FXML
    void getAllTransactionForCompany(MouseEvent event) {
        CompanyMarketStatus companyMarketStatus = marketTable.getSelectionModel()
                .getSelectedItem();
        int idForRequest = companyMarketStatus.getId();
        marketData.clear();
        marketData = FXCollections.observableArrayList(DBUtils.getHistoryOfTransactionForCompany(idForRequest));
        historyMarketTable.setItems(marketData);
        chartDtoList = DBUtils.getWeekChartReport(companyMarketStatus.getId());
        initChart();

    }

    @FXML
    void sellButton(ActionEvent event) {
        SellAssetDto sellAssetDto = new SellAssetDto();
        String companyName = fieldCompany.getText();
        StockPortfolio stockPortfolio = walletOfAssets.stream()
                .filter(wallet -> wallet.getCompanyName()
                        .equals(companyName))
                .findFirst()
                .get();
        float price = Float.parseFloat(fieldPrice.getText());
        int counterOfStocks = Integer.parseInt(fieldCounter.getText());
        //FIXME: load all entity after sign in or sign up
        if (stockPortfolio.getCounterOfStocks() < counterOfStocks || counterOfStocks < 0 || (price < 0 || price > Float.MAX_VALUE)) {
            AlertBox.display("", "Введите корректные данные");
        } else {
            BuySellDto buySellDto = new BuySellDto();
            buySellDto.setPrice(price);
            buySellDto.setCompanyName(companyName);
            buySellDto.setCounterOfStocks(counterOfStocks);
            buySellDto.setStatus("SELL");
            buySellDto.setUserId(State.homePageDto.getId());
            DBUtils.sellAssets(buySellDto);
            loadDataFromDB();
        }

    }


    private void initChart() {
        LineChart lc_chart = new LineChart(new CategoryAxis(), new NumberAxis());
        lc_chart.setMaxHeight(500);
        lc_chart.setMaxWidth(350);
        ChartWrapper.getChildren()
                .clear();
        ChartWrapper.getChildren()
                .add(lc_chart);

        XYChart.Series expenseSeries = new XYChart.Series();

        for (ChartDto chartDto : chartDtoList) {
            expenseSeries.getData()
                    .add(new XYChart.Data(chartDto.getTime(), chartDto.getPrice()));
        }


        lc_chart.getData()
                .addAll(expenseSeries);
        lc_chart.setLegendVisible(false);
        lc_chart.setCreateSymbols(false);
        lc_chart.lookup(".chart-plot-background")
                .setStyle("-fx-background-color: transparent");
        lc_chart.getXAxis()
                .setStyle("-fx-border-color: black transparent transparent");
        lc_chart.getYAxis()
                .setStyle("-fx-border-color: transparent black transparent transparent;");
        expenseSeries.getNode()
                .setStyle("-fx-stroke: #910000");
    }


}
