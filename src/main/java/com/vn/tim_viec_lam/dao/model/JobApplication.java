package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JobApplication implements java.io.Serializable {
    private int id;
    private int companyId;
    private int jobID;
    private int userID;
    private int resumesID;
    private String title;
    private String img;
    private String companyName;
    private String status;
    private LocalDateTime created;

    public JobApplication() {
    }

    public JobApplication(int id,int companyId, int jobID, int userID, int resumesID,String title,String img,String companyName, String status, LocalDateTime created) {
        this.id = id;
        this.companyId = companyId;
        this.jobID = jobID;
        this.userID = userID;
        this.resumesID = resumesID;
        this.title = title;
        this.img = img;
        this.companyName = companyName;
        this.status = status;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getResumesID() {
        return resumesID;
    }

    public void setResumesID(int resumesID) {
        this.resumesID = resumesID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public String getConvertCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String res = "";


        res = formatter.format(created);
        return  res;
    }
}
