package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;

public class JobCategy implements Serializable {
    private int categoryID;
    private String categoryName;
    private String jobName;

    public JobCategy() {
    }

    public JobCategy(int categoryID, String categoryName, String jobName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.jobName = jobName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "JobCategy{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
