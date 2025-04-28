package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements java.io.Serializable {
    private int id;
    private String candidateName;
    private int senderId;
    private String companyName;
    private String titleJob;
    private String status;
    private LocalDateTime app_created_at;
    private String message;
    private LocalDateTime sentDate;

    public Message() {
    }

    public Message(int id,  int userID,int senderId, int jobPostId, String message, LocalDateTime sentDate) {
        this.id = id;
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

    public int getsenderId() {
        return senderId;
    }

    public void setsenderId(int senderId) {
        this.senderId = senderId;
    }






    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }




    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }


    public String getConverSentDetail(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return sentDate.format(dateTimeFormatter);
    }


}
