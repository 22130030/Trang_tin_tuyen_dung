package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Conversation implements Serializable {
    private int id;
    private int userSenderId;
    private int userReceiverId;
    private int jobPostId;
    private String jobTitle;
    private String companyName;
    private String candidateName;
    private String status;
    private LocalDateTime applicationDate;
    private LocalDateTime startDate;

    public Conversation() {
    }

    public Conversation(int id, int userSenderId, int userReceiverId, int jobPostId, String jobTitle, String companyName, LocalDateTime applicationDate, LocalDateTime startDate) {
        this.id = id;
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.applicationDate = applicationDate;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserSenderId() {
        return userSenderId;
    }

    public void setUserSenderId(int userSenderId) {
        this.userSenderId = userSenderId;
    }

    public int getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(int userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", userSenderId=" + userSenderId +
                ", userReceiverId=" + userReceiverId +
                ", jobPostId=" + jobPostId +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                ", startDate=" + startDate +
                '}';
    }
}
