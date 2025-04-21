package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements java.io.Serializable {
    private int id;
    private int canidateId;
    private String candidateName;
    private int companyId;
    private String companyName;
    private int jobPostId;
    private String titleJob;
    private String status;
    private LocalDateTime app_created_at;
    private int senderId;
    private String message;
    private LocalDateTime sentDate;

    public Message() {
    }

    public Message(int id, int canidateId, int companyId, int jobPostId,int senderId, String message, LocalDateTime sentDate) {
        this.id = id;
        this.canidateId = canidateId;
        this.companyId = companyId;
        this.jobPostId = jobPostId;
        this.senderId = senderId;
        this.message = message;
        this.sentDate = sentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcanidateId() {
        return canidateId;
    }

    public void setcanidateId(int canidateId) {
        this.canidateId = canidateId;
    }

    public int getcompanyId() {
        return companyId;
    }

    public void setcompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getjobPostId() {
        return jobPostId;
    }

    public void setjobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public int getCanidateId() {
        return canidateId;
    }

    public void setCanidateId(int canidateId) {
        this.canidateId = canidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getTitleJob() {
        return titleJob;
    }

    public void setTitleJob(String titleJob) {
        this.titleJob = titleJob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getApp_created_at() {
        return app_created_at;
    }

    public void setApp_created_at(LocalDateTime app_created_at) {
        this.app_created_at = app_created_at;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getsenderId() {
        return senderId;
    }

    public void setsenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }
    public String getConverSentDetail(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return sentDate.format(dateTimeFormatter);
    }
}
