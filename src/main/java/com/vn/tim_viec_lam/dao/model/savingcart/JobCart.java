package com.vn.tim_viec_lam.dao.model.savingcart;

import java.io.Serializable;

public class JobCart implements Serializable {
    private int id;
    private String title;
    private String img;
    private String companyName;
    private String salary;
    public JobCart() {

    }
    public JobCart(int id, String title,String img, String companyName, String salary) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
