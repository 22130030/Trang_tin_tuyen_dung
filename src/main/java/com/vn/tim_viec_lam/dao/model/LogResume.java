package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class LogResume implements Serializable {
    private int id;
    private int resumeId;
    private int employeeId;
    private String companyName;
    private LocalDateTime viewed_at;

    public LogResume() {
    }

    public LogResume(int id, int resumeId, int employeeId, String companyName, LocalDateTime viewed_at) {
        this.id = id;
        this.resumeId = resumeId;
        this.employeeId = employeeId;
        this.companyName = companyName;
        this.viewed_at = viewed_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getViewed_at() {
        return viewed_at;
    }

    public void setViewed_at(LocalDateTime viewed_at) {
        this.viewed_at = viewed_at;
    }
    public String getConvertViewedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatter.format(viewed_at);
    }
    @Override
    public String toString() {
        return "LogResume{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", employeeId=" + employeeId +
                ", companyName='" + companyName + '\'' +
                ", viewed_at=" + viewed_at +
                '}';
    }
}
