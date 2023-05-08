package com.currencymarket.state;

import com.currencymarket.dto.SignUpDto;
import com.currencymarket.dto.clientdto.HomePageDto;
import com.currencymarket.entity.Company;
import com.currencymarket.entity.Transaction;
import com.currencymarket.entity.Wallet;

import java.util.List;

public class State {
    public static SignUpDto signUpDto;
    public static HomePageDto homePageDto;
    public static List<Company> companyList;
    public static List<Wallet> walletAssetsList;

    public static List<Transaction> transactionList;
}
