package com.currencymarket.utils;

import com.currencymarket.Application;
import com.currencymarket.alert.AlertBox;
import com.currencymarket.command.ClientAction;
import com.currencymarket.command.Status;
import com.currencymarket.connection.ClientServerConnection;
import com.currencymarket.dto.*;
import com.currencymarket.dto.admindto.ClientInformationDto;
import com.currencymarket.dto.admindto.CompanyRequestStatus;
import com.currencymarket.dto.carddto.CardDto;
import com.currencymarket.dto.chatdto.MessageDto;
import com.currencymarket.dto.clientdto.*;
import com.currencymarket.dto.companydto.CompanyMarketStatus;
import com.currencymarket.dto.companydto.CreateCompanyDto;
import com.currencymarket.dto.companydto.CurrentCompanyStatusDto;
import com.currencymarket.dto.transactiondto.BuySellDto;
import com.currencymarket.dto.transactiondto.HistoryDto;
import com.currencymarket.entity.Company;
import com.currencymarket.entity.Transaction;
import com.currencymarket.state.State;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static com.currencymarket.state.State.homePageDto;

public class DBUtils {
    public static ClientServerConnection clientServerConnection;

    static {
        try {
            clientServerConnection = new ClientServerConnection(new Socket("127.0.0.1", 8001));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeScene(Button button, String fxmlFile, String title) {
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Application.class.getResource(fxmlFile));
        Scene scene = null;

        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
//        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
//        stage.setX((primScreenBounds.getWidth() - scene.getWidth()) / 2);
//        stage.setY((primScreenBounds.getHeight() - scene.getHeight()) / 2);
//        stage.setHeight(800);
//        stage.setWidth(1500);
        stage.setMaxWidth(1600);
        stage.setMaxHeight(900);
//        stage.setFullScreen(true);
    }

    public static boolean signUpUser(String username, String password) {

        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUsername(username);
        signUpDto.setPassword(password);
        ClientAction clientAction = ClientAction.SIGN_UP;
        clientServerConnection.writeObject(clientAction);
        clientServerConnection.writeObject(signUpDto);
        boolean b = (boolean) clientServerConnection.readObject();
        if (b) {
            homePageDto  = (HomePageDto) clientServerConnection.readObject();
            AlertBox.display("", "Вы успешно зарегистрированы");
            getCompanies();
        } else {
            AlertBox.display("", "Такой пользователь уже существует");
        }

        return true;
    }

    private static void getCompanies() {
        clientServerConnection.writeObject(ClientAction.GET_COMPANIES);
        State.companyList = (List<Company>) clientServerConnection.readObject();
        System.out.println(State.companyList);
    }

    public static boolean logInUser(String username, String password) {
        try {
            clientServerConnection = new ClientServerConnection(new Socket("127.0.0.1", 8001));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUsername(username);
        signUpDto.setPassword(password);
        ClientAction clientAction = ClientAction.SIGN_IN;
        clientServerConnection.writeObject(clientAction);
        clientServerConnection.writeObject(signUpDto);

        Status status = (Status) clientServerConnection.readObject();

        if (status.equals(Status.ACCEPTED)) {
            homePageDto = (HomePageDto) clientServerConnection.readObject();
            getCompanies();
            return true;

        }
        if (status.equals(Status.BAN)) {
            AlertBox.display("", "Вы получили бан");
            return false;
        }
        if (status.equals(Status.INVALID_LOGIN_OR_PASSWORD)) {
            AlertBox.display("", "Неправильный логин или пароль");
            return false;
        }
        return false;
    }

    public static List<ClientInformationDto> getAllUsers() {
        clientServerConnection.writeObject(ClientAction.GET_ALL_CLIENTS);
        List<ClientInformationDto> clientInformationDtos = (List<ClientInformationDto>) clientServerConnection.readObject();
        System.out.println(clientInformationDtos);
        return clientInformationDtos;

    }

    private static List<ClientInformationDto> loadDataFromDB() {
        clientServerConnection.writeObject(ClientAction.GET_ALL_CLIENTS);
        return (List<ClientInformationDto>) clientServerConnection.readObject();
    }

    public static String updateClient(ClientInformationDto clientInformationDto) {
        clientServerConnection.writeObject(ClientAction.UPDATE);
        clientServerConnection.writeObject(clientInformationDto);
        return (String) clientServerConnection.readObject();
    }

    public static String updateCompanyStatus(CompanyRequestStatus companyRequestStatus) {
        clientServerConnection.writeObject(ClientAction.UPDATE_COMPANY_STATUS);
        clientServerConnection.writeObject(companyRequestStatus);
        String o = (String) clientServerConnection.readObject();
        getCompanies();
        return o;
    }

    public static List<CompanyRequestStatus> getAllCompany() {
        clientServerConnection.writeObject(ClientAction.GET_COMPANY_STATUS);
        List<CompanyRequestStatus> list = (List<CompanyRequestStatus>) clientServerConnection.readObject();
        System.out.println(list);
        return list;
    }

    public static void exit() {
        clientServerConnection.writeObject(ClientAction.EXIT);
        clientServerConnection.closeConnection();

    }

    public static String sendCompanyRequest(CreateCompanyDto companyDto) {
        clientServerConnection.writeObject(ClientAction.CREATE_COMPANY);
        clientServerConnection.writeObject(companyDto);
        return (String) clientServerConnection.readObject();
    }

    public static List<CurrentCompanyStatusDto> getCurrentCompanyStatus() {
        clientServerConnection.writeObject(ClientAction.GET_COMPANY_STATUS_FOR_USER);
        clientServerConnection.writeObject(homePageDto.getId());
        return (List<CurrentCompanyStatusDto>) clientServerConnection.readObject();
    }

    public static double updateCash(UpdateCashDto updateCashDto) {
        clientServerConnection.writeObject(ClientAction.UPDATE_CASH);
        clientServerConnection.writeObject(updateCashDto);
        return (double) clientServerConnection.readObject();
    }

    public static List<CompanyMarketStatus> getCompanyShares() {
        clientServerConnection.writeObject(ClientAction.GET_COMPANY_SHARES);
        return (List<CompanyMarketStatus>) clientServerConnection.readObject();
    }

    public static void sendMessage(MessageDto messageDto) {
        clientServerConnection.writeObject(ClientAction.SEND_MESSAGE);
        clientServerConnection.writeObject(messageDto);
    }

    public static List<MessageDto> getMessage() {
        clientServerConnection.writeObject(ClientAction.GET_MESSAGE);
        List<MessageDto> messageDtos = (List<MessageDto>) clientServerConnection.readObject();
        return messageDtos;
    }

    public static List<AssetDto> getAssetsData() {
        clientServerConnection.writeObject(ClientAction.GET_ASSETS);
        clientServerConnection.writeObject(homePageDto.getId());
        List<AssetDto> assetDtos = (List<AssetDto>) clientServerConnection.readObject();
        return assetDtos;
    }

    public static List<BuySellDto> getActiveTransaction() {
        clientServerConnection.writeObject(ClientAction.GET_ACTIVE_TRANSACTION);
        List<BuySellDto> list = (List<BuySellDto>) clientServerConnection.readObject();
        return list;
    }

    public static void sellAssets(BuySellDto buySellDto) {
        clientServerConnection.writeObject(ClientAction.SELL_ASSETS);
        clientServerConnection.writeObject(buySellDto);

    }

    public static void buyAssets(BuySellDto assetDto) {
        clientServerConnection.writeObject(ClientAction.BUY_ASSETS);
        clientServerConnection.writeObject(assetDto);
    }

    public static List<HistoryDto> getHistoryOfTransactionForCompany(int idForRequest) {
        clientServerConnection.writeObject(ClientAction.GET_HISTORY_OF_TRANSACTION_FOR_COMPANY);
        clientServerConnection.writeObject(idForRequest);
        return (List<HistoryDto>) clientServerConnection.readObject();
    }

    public static List<StockPortfolio> getWalletOfAssets(int id) {
        clientServerConnection.writeObject(ClientAction.GET_ASSETS);
        clientServerConnection.writeObject(id);
//        List<Wallet> walletList = (List<Wallet>) clientServerConnection.readObject();
//        List<Company> companyList = State.companyList;

        List<StockPortfolio> portfolioList =  (List<StockPortfolio>) clientServerConnection.readObject();

        return portfolioList;
    }

    private static List<StockPortfolio> getPortfolioList(List<Company> companyList,
                                                         List<com.currencymarket.entity.Wallet> walletOfAssets) {
        List<StockPortfolio> stockPortfolioList = new ArrayList<>();
        for (Company company : companyList) {
            for (com.currencymarket.entity.Wallet wallet : walletOfAssets) {
                StockPortfolio stockPortfolio = new StockPortfolio();
                if (company.getCompanyName().equals(wallet.getCompanyName())) {
                    stockPortfolio.setCompanyName(company.getCompanyName());
                    stockPortfolio.setCounterOfStocks(Double.valueOf(wallet.getCounterOfStocks()));
//                    stockPortfolio.setPercentAssetsOfCompany(wallet.getCounterOfStocks() * 100 / company.getCounterOfStocks());
                    stockPortfolioList.add(stockPortfolio);
                } else {
                    stockPortfolio.setCompanyName(company.getCompanyName());
                    stockPortfolio.setCounterOfStocks(0.0);
//                    stockPortfolio.setPercentAssetsOfCompany(0);
                    stockPortfolioList.add(stockPortfolio);

                }
            }
        }
        //        for (com.currencymarket.entity.Wallet wallet : walletOfAssets) {
//            List<StockPortfolio> stockPortfolioList = companyList.stream()
//                    .filter(company -> wallet.getCompanyName().equals(company.getCompanyName()))
//                    .map((company) -> {
//                        StockPortfolio stockPortfolio = new StockPortfolio();
//                        stockPortfolio.setCompanyName(company.getCompanyName());
//                        stockPortfolio.setCounterOfStocks(wallet.getCounterOfStocks());
//                        stockPortfolio.setPercentAssetsOfCompany((wallet.getCounterOfStocks() / company.getCounterOfStocks()) * 100);
//                        return stockPortfolio;
//                    }).toList();
//            System.out.println(stockPortfolioList);
//            tableData = FXCollections.observableArrayList(stockPortfolioList);
//
//        }
        return stockPortfolioList;
    }

    public static List<CompanyRequestStatus> getWaitingCompanies() {
        clientServerConnection.writeObject(ClientAction.GET_WAITING_COMPANIES);
        return (List<CompanyRequestStatus>) clientServerConnection.readObject();
    }

    public static boolean updatePassword(String oldPassword, String newPassword) {
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        changePasswordDto.setOldPassword(String.valueOf(oldPassword));
        changePasswordDto.setNewPassword(newPassword);
        changePasswordDto.setId(homePageDto.getId());
        clientServerConnection.writeObject(ClientAction.CHANGE_PASSWORD);
        clientServerConnection.writeObject(changePasswordDto);
        boolean s = (boolean) clientServerConnection.readObject();
        return s;
    }

    public static List<Transaction> getCompletedTransaction(int id) {
        clientServerConnection.writeObject(ClientAction.GET_COMPLETED_TRANSACTION);
        clientServerConnection.writeObject(id);
        List<Transaction> transactionList = (List<Transaction>) clientServerConnection.readObject();
        State.transactionList = transactionList;
        return transactionList;
    }

    public static List<ChartDto> getWeekChartReport(int id) {
        clientServerConnection.writeObject(ClientAction.GET_WEEK_CHART_REPORT);
        clientServerConnection.writeObject(id);
         List<ChartDto> chartDtoList = (List<ChartDto>) clientServerConnection.readObject();
         return chartDtoList;
    }

    public static String activateCard(CardDto cardDto) {
        clientServerConnection.writeObject(ClientAction.ACTIVATE_CARD);
        clientServerConnection.writeObject(cardDto);
        return (String) clientServerConnection.readObject();
    }

    public static CardDto getCard(int id) {
        clientServerConnection.writeObject(ClientAction.GET_CARD);
        clientServerConnection.writeObject(id);
        return (CardDto) clientServerConnection.readObject();
    }

    public static float getCashFromCard(int id) {
        clientServerConnection.writeObject(ClientAction.GET_CASH_FROM_CARD);
        clientServerConnection.writeObject(id);
        return (float) clientServerConnection.readObject();
    }
}
