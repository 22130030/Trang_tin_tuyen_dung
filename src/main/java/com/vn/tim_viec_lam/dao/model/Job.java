package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.sql.Date;

public class Job implements Serializable {
    private int id;
    private String title;
    private String img;
    private String description;
    private String position;
    private double salary;
    private Date created;
    private Date updated;
    private int status;
    private String requirement;

    public Job() {}

    public Job(int id, String title, String img, String description, String position, double salary, Date created, Date updated, int status, String requirement) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.description = description;
        this.position = position;
        this.salary = salary;
        this.created = created;
        this.updated = updated;
        this.status = status;
        this.requirement = requirement;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", created=" + created +
                ", updated=" + updated +
                ", status=" + status +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}
