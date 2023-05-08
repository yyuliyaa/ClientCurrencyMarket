package com.currencymarket.dto.transactiondto;

import java.io.Serializable;

public class BuySellDto implements Serializable {
    private int transaction_id;
    private int userId;
    private String companyName;
    private int counterOfStocks;
    private float price;
    // status means BUY or SELL
    private String status;

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BuySellDto{" +
                "transaction_id=" + transaction_id +
                ", userId=" + userId +
                ", companyName='" + companyName + '\'' +
                ", counterOfStocks=" + counterOfStocks +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
