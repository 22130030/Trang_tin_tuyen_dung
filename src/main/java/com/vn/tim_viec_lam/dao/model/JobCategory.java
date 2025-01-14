package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;

public class JobCategory implements Serializable {
    private int categoryID;
    private String categoryName;
    private String jobPostCategoryName;

    public JobCategory() {
    }

    public JobCategory(int categoryID, String categoryName, String jobPostCategoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.jobPostCategoryName = jobPostCategoryName;
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

    public String getJobPostCategoryName() {
        return jobPostCategoryName;
    }

    public void setjobPostCategoryName(String jobPostCategoryName) {
        this.jobPostCategoryName =jobPostCategoryName;
    }

    @Override
    public String toString() {
        return "JobCategy{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", jobName='" + jobPostCategoryName + '\'' +
                '}';
    }
}
