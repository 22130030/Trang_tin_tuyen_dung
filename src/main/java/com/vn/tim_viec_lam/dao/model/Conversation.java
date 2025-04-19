package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Conversation implements Serializable {
    int id;
    int candidateId;
    int employerId;
    int jobPostId;
    String jobTitle;
    String companyName;
    LocalDateTime applicationDate;
    LocalDateTime startDate;

    public Conversation() {
    }

    public Conversation(int id, int candidateId, int employerId, int jobPostId, String jobTitle, String companyName, LocalDateTime applicationDate, LocalDateTime startDate) {
        this.id = id;
        this.candidateId = candidateId;
        this.employerId = employerId;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.applicationDate = applicationDate;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
