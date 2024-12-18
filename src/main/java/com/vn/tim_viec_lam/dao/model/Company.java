package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;

public class Company implements Serializable {
    private int id;
    private String companyName;
    private String img;
    private String address;
    private String website;
    private String description;

    public Company() {}
    public Company(int id, String companyName, String img, String address, String website, String description) {
        this.id = id;
        this.companyName = companyName;
        this.img = img;
        this.address = address;
        this.website = website;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", img='" + img + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '\n';
    }
}
