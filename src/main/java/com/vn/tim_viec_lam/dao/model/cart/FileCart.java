package com.vn.tim_viec_lam.dao.model.cart;

import java.io.Serializable;
import java.util.Date;

public class FileCart implements Serializable {
    private int id;
    private String title;
    private String path;
    private String type;
    private long size;
    private Date updated;

    public FileCart() {
    }

    public FileCart(int id, String title,String path, String type,long size, Date updated) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.type = type;
        this.size = size;
        this.updated = updated;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
