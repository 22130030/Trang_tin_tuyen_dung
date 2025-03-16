package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.ResumesDao;
import com.vn.tim_viec_lam.dao.model.Resumes;

import java.util.List;

public class ResumesService {
    ResumesDao resumesDao;
    public ResumesService() {
        resumesDao = new ResumesDao();
    }
    public boolean updateProfile(int resumesId,String title,int birthYear,String marital,String address,String education,
                                 String schoolName,String salary,String career,String gender){
        return resumesDao.updateProfile(resumesId,title,birthYear,marital,address,education,schoolName,salary,career,gender);
    }
    public Resumes findResumes(String title,String address){

        return null;
    }
    public int addResume(String fileName,String path,String type){
        return resumesDao.addResume(fileName,path,type);
    }
    public List<Resumes> getResumes(){
        return resumesDao.getResumes();
    }
    public List<Resumes> getResumesByStatus(){
        return resumesDao.getResumesByStatus();
    }
    public boolean deleteResume(int resumesId){
        return resumesDao.removeResumes(resumesId);
    }
    public List<Resumes> findResumesByNameOrAddress(String title,String address){
        return resumesDao.findResumesByNameOrAddress(title,address);
    }
    public List<Resumes> filterResume(String industry,String salary,String education, String school,String gender,String marialStatus,String age){
        return resumesDao.filterResumes( industry, salary, education,  school, gender,marialStatus,age);
    }
    public boolean updateStatus(int resumesId,int status){
        int res = status == 2 ? 1 : 2;

        return resumesDao.updateStatus(resumesId,status);
    }
    public static void main(String[] args) {
        ResumesService rs = new ResumesService();
        System.out.println(rs.findResumesByNameOrAddress("lap trinh vien",""));
    }
}
