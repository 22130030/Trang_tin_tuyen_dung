package com.vn.tim_viec_lam.dao.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Resumes implements java.io.Serializable{
    private int id;
    private int candidateId;
    private String path;
    private String title;
    private String type;
    private int birthYear;
    private String marital;
    private String address;
    private String education;
    private String schoolName;
    private String salary;
    private String career;
    private String gender;
    private int status;
    private int numOfView;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String phone;
    public Resumes() {}
    public Resumes(int id, int candidateId, String path, String title, String type, int birthYear, String marital,String address
            , String education, String schoolName, String salary, String career, String gender,String phone) {
        this.id = id;
        this.candidateId = candidateId;
        this.path = path;
        this.title = title;
        this.type = type;
        this.birthYear = birthYear;
        this.marital = marital;
        this.address = address;
        this.education = education;
        this.schoolName = schoolName;
        this.salary = salary;
        this.career = career;
        this.gender = gender;
        this.phone = phone;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEncodingPath(){
        try {
            return URLEncoder.encode(this.path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getConvertStatus(){
        return status == 1 ? "Bản hoàn chỉnh" : "Bản tạm";
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getConvertUpdated(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String res = "";


        res = formatter.format(this.updated);
        return  res;
    }
    public String getConvertCreated(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String res = "";
        res = formatter.format(this.created);
        return  res;
    }

    public int getNumOfView() {
        return numOfView;
    }

    public void setNumOfView(int numOfView) {
        this.numOfView = numOfView;
    }

    @Override
    public String toString() {
        return "Resumes{" +
                "id=" + id +
                ", candidateId='" + candidateId + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", birthYear=" + birthYear +
                ", marital='" + marital + '\'' +
                ", education='" + education + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", salary='" + salary + '\'' +
                ", career='" + career + '\'' +
                ", gender='" + gender + '\'' +
                '\n';
    }
}
