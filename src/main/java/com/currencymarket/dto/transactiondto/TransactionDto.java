package com.currencymarket.dto.transactiondto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TransactionDto implements Serializable {
    private String companyName;
    private LocalDateTime localDateTime;
    private int amount;
    private float price;
    private String transactionalType;
    private float result;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTransactionalType() {
        return transactionalType;
    }

    public void setTransactionalType(String transactionalType) {
        this.transactionalType = transactionalType;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "companyName='" + companyName + '\'' +
                ", localDateTime=" + localDateTime +
                ", amount=" + amount +
                ", price=" + price +
                ", transactionalType='" + transactionalType + '\'' +
                ", result=" + result +
                '}';
    }
}
