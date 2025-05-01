package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversation implements Serializable {
    private int id;
    private int userSenderId;
    private int userReceiverId;
    private int applicationId;
    private String jobTitle;
    private String companyName;
    private String candidateName;
    private String status;
    private int isOnline;
    private LocalDateTime applicationDate;
    private LocalDateTime startDate;
    private LocalDateTime lastActive;

    public Conversation() {
    }

    public Conversation(int id, int userSenderId, int userReceiverId, int applicationId, String jobTitle, String companyName, LocalDateTime applicationDate, LocalDateTime startDate) {
        this.id = id;
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.applicationId = applicationId;
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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
    public String getConvertAppDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return applicationDate.format(formatter);
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public LocalDateTime getLastActive() {
        return lastActive;
    }

    public void setLastActive(LocalDateTime lastActive) {
        this.lastActive = lastActive;
    }
    public String getConvertLastActive() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return lastActive.format(formatter);
    }
    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", userSenderId=" + userSenderId +
                ", userReceiverId=" + userReceiverId +
                ", applicationId=" + applicationId +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                ", startDate=" + startDate +
                '}';
    }
}
