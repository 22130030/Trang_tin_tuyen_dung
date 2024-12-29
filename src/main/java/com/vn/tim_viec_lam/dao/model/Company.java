package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Company  implements Serializable {
    private int id;
    private String companyName;
    private String email;
    private String phone_number;
    private String status;
    private LocalDateTime createDate;
    private String img;
    private String address;
    private String city;
    private String website;
    private String description;

    public Company() {}
    public Company(int id, String companyName, String img, String address,String city, String website, String description) {
        this.id = id;
        this.companyName = companyName;
        this.img = img;
        this.address = address;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
                ", city='" + city + '\'' +
                '\n';
    }
}
