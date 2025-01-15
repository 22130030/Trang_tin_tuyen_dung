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
    public boolean deleteResume(int resumesId){
        return resumesDao.removeResumes(resumesId);
    }
    public static void main(String[] args) {
        ResumesService rs = new ResumesService();
        System.out.println(rs.addResume("D://","","docx"));
    }
}
