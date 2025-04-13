package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;

public class Message implements java.io.Serializable {
    private int id;
    private int canidateID;
    private int employerID;
    private int applicationID;
    private String message;
    private LocalDateTime sentDate;

    public Message() {
    }

    public Message(int id, int canidateID, int employerID, int applicationID, String message, LocalDateTime sentDate) {
        this.id = id;
        this.canidateID = canidateID;
        this.employerID = employerID;
        this.applicationID = applicationID;
        this.message = message;
        this.sentDate = sentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCanidateID() {
        return canidateID;
    }

    public void setCanidateID(int canidateID) {
        this.canidateID = canidateID;
    }

    public int getEmployerID() {
        return employerID;
    }

    public void setEmployerID(int employerID) {
        this.employerID = employerID;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
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
}
