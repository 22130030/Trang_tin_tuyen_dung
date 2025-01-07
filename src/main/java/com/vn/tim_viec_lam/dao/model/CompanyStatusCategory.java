package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;

public class CompanyStatusCategory implements Serializable {
    private int statusID;
    private String statusName;

    public CompanyStatusCategory() {
    }

    public CompanyStatusCategory(int statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "CompanyStatusCategory{" +
                "statusID=" + statusID +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
