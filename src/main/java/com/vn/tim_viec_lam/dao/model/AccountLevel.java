package com.vn.tim_viec_lam.dao.model;

public class AccountLevel {
    private int status;
    private int resumeLimit;
    private int applicationLimit;

    public AccountLevel() {
    }

    public AccountLevel(int status, int resumeLimit, int applicationLimit) {
        this.status = status;
        this.resumeLimit = resumeLimit;
        this.applicationLimit = applicationLimit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResumeLimit() {
        return resumeLimit;
    }

    public void setResumeLimit(int resumeLimit) {
        this.resumeLimit = resumeLimit;
    }

    public int getApplicationLimit() {
        return applicationLimit;
    }

    public void setApplicationLimit(int applicationLimit) {
        this.applicationLimit = applicationLimit;
    }

    @Override
    public String toString() {
        return "AccountLevel{" +
                "status=" + status +
                ", resumeLimit=" + resumeLimit +
                ", applicationLimit=" + applicationLimit +
                '}';
    }
}
