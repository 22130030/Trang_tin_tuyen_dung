package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompanyUser implements Serializable {
    private int userID;
    private int companyID;
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private String status;
    private LocalDateTime created_at;
    private int roleNum;

    public CompanyUser() {
    }

    public CompanyUser(int userID, int companyID, String email, String password, String name, String phone_number, String status, LocalDateTime created_at, int roleNum) {
        this.userID = userID;
        this.companyID = companyID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.status = status;
        this.created_at = created_at;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
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

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }
    public String getConvertCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String res = "";


        res = formatter.format(created_at);
        return  res;
    }
    public String getFormattedCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return created_at.format(formatter);
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "userID=" + userID +
                ", companyID=" + companyID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                ", roleNum=" + roleNum +
                '}';
    }
}
