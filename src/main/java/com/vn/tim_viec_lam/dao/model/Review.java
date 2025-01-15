package com.vn.tim_viec_lam.dao.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Review implements java.io.Serializable {
    private int id;
    private int companyId;
    private int applicationId;
    private String type;
    private String path;
    private String title;
    private String status;
    private LocalDateTime created;

    public Review() {
    }

    public Review(int id, int companyId, int applicationId, String type,String path, String title, String status, LocalDateTime created) {
        this.id = id;
        this.companyId = companyId;
        this.applicationId = applicationId;
        this.path = path;
        this.type = type;
        this.title = title;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getEncodingPath(){
        try {
            return URLEncoder.encode(this.path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return formatter.format(created);
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", applicationId=" + applicationId +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", created=" + created +
                '}';
    }
}
