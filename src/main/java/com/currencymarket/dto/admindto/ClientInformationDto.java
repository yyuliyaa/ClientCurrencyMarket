package com.currencymarket.dto.admindto;

import java.io.Serializable;

public class ClientInformationDto implements Serializable {
    private int id;
    private String username;
    private String role;

    private String activated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "ClientInformationDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", activated='" + activated + '\'' +
                '}';
    }
}