package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWork implements java.io.Serializable {
    private int id;
    private int userId;
    private String action;
    private String oldData;
    private String newData;
    private LocalDateTime changed;

    public LogWork() {
    }

    public LogWork( int userId, String action, String oldData, String newData) {
        this.userId = userId;
        this.action = action;
        this.oldData = oldData;
        this.newData = newData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public LocalDateTime getChanged() {
        return changed;
    }

    public void setChanged(LocalDateTime changed) {
        this.changed = changed;
    }
    public String getConvertChange() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return changed.format(formatter);
    }
    @Override
    public String toString() {
        return "LogWork{" +
                "id=" + id +
                ", userId=" + userId +
                ", action='" + action + '\'' +
                ", oldData='" + oldData + '\'' +
                ", newData='" + newData + '\'' +
                ", changed=" + changed +
                '}';
    }
}
