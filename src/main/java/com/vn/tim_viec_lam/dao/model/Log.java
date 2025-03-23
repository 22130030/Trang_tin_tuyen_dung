package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Log implements Serializable {
    private int id;
    private LocalDateTime logTime;
    private String res;
    private String dataNew;
    private String dataOld;

    public Log() {
    }

    public Log(int id, LocalDateTime logTime, String res, String dataNew, String dataOld) {
        this.id = id;
        this.logTime = logTime;
        this.res = res;
        this.dataNew = dataNew;
        this.dataOld = dataOld;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getDataNew() {
        return dataNew;
    }

    public void setDataNew(String dataNew) {
        this.dataNew = dataNew;
    }

    public String getDataOld() {
        return dataOld;
    }

    public void setDataOld(String dataOld) {
        this.dataOld = dataOld;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logTime=" + logTime +
                ", res='" + res + '\'' +
                ", dataNew='" + dataNew + '\'' +
                ", dataOld='" + dataOld + '\'' +
                '}';
    }
}
