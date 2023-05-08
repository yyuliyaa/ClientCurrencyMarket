package com.currencymarket.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private int transactionId;
    private String transactionalType;
    private int userId;
    private int companyId;
    private int amount;
    private LocalDateTime localDateTime;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionalType() {
        return transactionalType;
    }

    public void setTransactionalType(String transactionalType) {
        this.transactionalType = transactionalType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionalType='" + transactionalType + '\'' +
                ", userId=" + userId +
                ", companyId=" + companyId +
                ", amount=" + amount +
                ", localDateTime=" + localDateTime +
                ", price=" + price +
                '}';
    }
}
