package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private int userID;
    private String email;
    private String password;
    private String phone_number;
    private String status;
    private LocalDateTime created_at;
    private int roleNum;
    public User() {
    }

    public User(int userID, String email, String password, String status, String phone_number, LocalDateTime created_at, int roleNum) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.status = status;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.roleNum = roleNum;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public String getFormattedCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return created_at.format(formatter);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                ", roleNum=" + roleNum +
                '}';
    }
}
