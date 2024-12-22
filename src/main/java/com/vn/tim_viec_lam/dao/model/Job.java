package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Job implements Serializable {
    private int id;
    private String title;
    private int companyId;
    private String companyName;
    private String img;
    private String description;
    private String position;
    private String salary;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String status;
    private String requirement;
    private String scale;

    public Job() {}

    public Job(int id,int companyId,String companyName, String title, String img, String description, String position, String salary,LocalDateTime created, String status, String requirement) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.title = title;
        this.img = img;
        this.description = description;
        this.position = position;
        this.salary = salary;
        this.created = created;
        this.status = status;
        this.requirement = requirement;
        this.scale = scale;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public String getConvertCreated() {
        LocalDateTime now = LocalDateTime.now();
        long day  = ChronoUnit.DAYS.between(created, now);
        String res = "";

        if(day == 0){
            res = ChronoUnit.HOURS.between(created,now)+" giờ trước";
        }else if(day > 0 && day < 31){
            res = day + " ngày trước";
        }
        else{
            res = ChronoUnit.MONTHS.between(created,now) + " tháng trước";
        }
        return  res;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getscale() {
        return scale;
    }

    public void setscale(String scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ",companyId=" + companyId +
                ",companyName='" + companyName + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", created=" + created +
                ", updated=" + updated +
                ", status=" + status +
                ", requirement='" + requirement + '\'' +
                ", scale='" + scale + '\'' +
                '\n';
    }


    }

