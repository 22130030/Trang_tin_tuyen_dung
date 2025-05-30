package com.vn.tim_viec_lam.dao.model;

public class JobCategoryCount {
    private int id;
    private String name;
    private String img;
    private int count;

    public JobCategoryCount(int id, String name,String img, int count) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "JobCategoryCount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", count=" + count +
                '}';
    }
}


