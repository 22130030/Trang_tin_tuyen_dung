package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobApplicationDao;
import com.vn.tim_viec_lam.dao.model.JobApplication;

import java.util.List;

public class JobApplicationService {
    private JobApplicationDao jobApplicationDao;
    public JobApplicationService(){
        jobApplicationDao = new JobApplicationDao();
    }
    public boolean addJobApplicationFromAccount(int companyID, int jobPostID,int resumesID,int candidateID,String phone){
        return jobApplicationDao.addJobApplicationFromAccount(companyID, jobPostID, resumesID, candidateID,phone);
    }
    public List<JobApplication> getAll(){
        return jobApplicationDao.getAll();
    }
    public boolean addJobAppFromComputer(String path, String fileName,String type,int jobID,int companyID,int candidateId,String phone) {
        return jobApplicationDao.addJobAppFromComputer(path, fileName, type, jobID, companyID, candidateId,phone);
    }
    public boolean updateStatus(String status,int applicationId){
        return jobApplicationDao.updateStatus(status,applicationId);
    }
    public static void main(String[] args) {
    }
}

