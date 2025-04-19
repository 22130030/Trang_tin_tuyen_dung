package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements java.io.Serializable {
    private int id;
    private int canidateId;
    private int employerId;
    private int jobPostId;
    private int senderId;
    private String message;
    private LocalDateTime sentDate;

    public Message() {
    }

    public Message(int id, int canidateId, int employerId, int jobPostId,int senderId, String message, LocalDateTime sentDate) {
        this.id = id;
        this.canidateId = canidateId;
        this.employerId = employerId;
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

    public int getemployerId() {
        return employerId;
    }

    public void setemployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getjobPostId() {
        return jobPostId;
    }

    public void setjobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
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
