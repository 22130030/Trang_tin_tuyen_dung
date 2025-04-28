package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDate;

public class OnlineUser implements Serializable {
    private int userId;
    private boolean isOnline;
    private LocalDate lastActiveDate;

    public OnlineUser() {
    }

    public OnlineUser(int userId, boolean isOnline, LocalDate lastActiveDate) {
        this.userId = userId;
        this.isOnline = isOnline;
        this.lastActiveDate = lastActiveDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public LocalDate getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(LocalDate lastActiveDate) {
        this.lastActiveDate = lastActiveDate;
    }
}
