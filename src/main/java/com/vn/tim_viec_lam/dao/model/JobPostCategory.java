package com.vn.tim_viec_lam.dao.model;

public class JobPostCategory {
    private int id;
    private String name;
    private String img;

    public JobPostCategory() {
    }
    public JobPostCategory(int id,String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "JobPostCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '\n';
    }
}
