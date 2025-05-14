package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Candidate implements Serializable {
    private int candidateID;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String appliedCompany;
    private LocalDateTime applyDate;
    private String status;
    private String gender;
    private String birth;
    public Candidate() {
    }



    public Candidate(int candidateID, String fullName, String address, String email, String phone, String appliedCompany, LocalDateTime applyDate, String status, String gender, String birth) {
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.appliedCompany = appliedCompany;
        this.applyDate = applyDate;
        this.status = status;
        this.gender = gender;
        this.birth = birth;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppliedCompany() {
        return appliedCompany;
    }

    public void setAppliedCompany(String appliedCompany) {
        this.appliedCompany = appliedCompany;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
    }
    public String getApplicationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return applyDate.format(formatter);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID=" + candidateID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", appliedCompany='" + appliedCompany + '\'' +
                ", applyDate=" + applyDate +
                ", status='" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
