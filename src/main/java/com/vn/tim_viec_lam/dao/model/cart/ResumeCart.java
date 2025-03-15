package com.vn.tim_viec_lam.dao.model.cart;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResumeCart {
    private int id;
    private String title;
    private String path;
    private String type;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String phone;
    public ResumeCart() {
    }
    public ResumeCart(int id, String title,String path, String type,LocalDateTime created,String phone) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.type = type;
        this.created = created;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreated(LocalDateTime updated) {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEncodingPath(){
        try {
            return URLEncoder.encode(this.path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public String getConvertCreated(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(this.created);
    }
    public String getConvertUpdated(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(this.updated);
    }
}
