package com.currencymarket.dto.carddto;

import java.io.Serializable;

public class CardDto implements Serializable {
    private int userId;
    private String number;
    private int cv;
    private float cash;

    public CardDto() {
    }

    public CardDto(int userId, String number, int cv, float cash) {
        this.userId = userId;
        this.number = number;
        this.cv = cv;
        this.cash = cash;
    }

    public CardDto(int userId, String number, int cv) {
        this.userId = userId;
        this.number = number;
        this.cv = cv;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "userId=" + userId +
                ", number='" + number + '\'' +
                ", cv=" + cv +
                ", cash=" + cash +
                '}';
    }
}
