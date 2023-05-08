package com.currencymarket.dto.clientdto;

import java.io.Serializable;

public class HomePageDto implements Serializable {
    private int id;
    private String username;
    private double cash;

    private String role;

    private String activated;

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HomePageDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cash=" + cash +
                ", role='" + role + '\'' +
                ", activated='" + activated + '\'' +
                '}';
    }
}