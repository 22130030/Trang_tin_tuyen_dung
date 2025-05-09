package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class User implements Serializable {
    private int userID;
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private int status;
    private String provider_id;
    private LocalDateTime created_at;
    private int roleNum;
    private String image;
    public User() {
    }


    public User(int userID, String email, String password, int status, String phone_number, LocalDateTime created_at, String provider_id, String image) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.status = status;
        this.created_at = created_at;
        this.roleNum = roleNum;
        this.provider_id = provider_id;
        this.image = image;
    }
    public User(int userID, String email, String password, String name, String phone_number, int status, LocalDateTime created_at, int roleNum) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.status = status;
        this.created_at = created_at;
        this.roleNum = roleNum;
    }
    public User(int userID, String email, String password, String name, String phone_number, int status, LocalDateTime created_at, int roleNum, String image) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.status = status;
        this.created_at = created_at;
        this.roleNum = roleNum;
        this.image = image;
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

    public String getPhoneNumber() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
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

    public String getPhone_number() {
        return phone_number;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {

        this.provider_id = provider_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                ", roleNum=" + roleNum +
                ", image='" + image + '\'' +
                '}';
    }
}
