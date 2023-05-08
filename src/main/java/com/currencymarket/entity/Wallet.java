package com.currencymarket.entity;

import java.io.Serializable;

public class Wallet implements Serializable {
    private int walletId;
    private int userId;
    private String companyName;
    private int counterOfStocks;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCounterOfStocks() {
        return counterOfStocks;
    }

    public void setCounterOfStocks(int counterOfStocks) {
        this.counterOfStocks = counterOfStocks;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", userId=" + userId +
                ", companyName=" + companyName +
                ", counterOfStocks=" + counterOfStocks +
                '}';
    }
}
