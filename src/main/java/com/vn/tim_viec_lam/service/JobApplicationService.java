package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobApplicationDao;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import jakarta.ws.rs.core.Application;

import java.util.List;

public class JobApplicationService {
    private JobApplicationDao jobApplicationDao;
    public JobApplicationService(){
        jobApplicationDao = new JobApplicationDao();
    }
    public boolean addJobApplicationFromAccount(int companyID, int jobPostID,int resumesID,int candidateID,String phone){
        return jobApplicationDao.addJobApplicationFromAccount(companyID, jobPostID, resumesID, candidateID,phone);
    }
    public List<JobApplication> getAll(int candidateId){
        return jobApplicationDao.getAll(candidateId);
    }
    public int getJobApplicationInDay(int candidateId){
        return jobApplicationDao.getJobApplicationInDay(candidateId);
    }
    public boolean addJobAppFromComputer(String path, String fileName,String type,int jobID,int companyID,int candidateId,String phone) {
        return jobApplicationDao.addJobAppFromComputer(path, fileName, type, jobID, companyID, candidateId,phone);
    }
    public boolean updateStatus(String status,int applicationId){
        return jobApplicationDao.updateStatus(status,applicationId);
    }
    public JobApplication getApplication(int applicationId,int companyID){
        return jobApplicationDao.getApplication(applicationId,companyID);
    }
    public boolean getApplicationByJobIdAndCanId(int jobID,int candidateID){
        return jobApplicationDao.getApplicationByJobIdAndCanId(jobID,candidateID);
    }
    public static void main(String[] args) {
        JobApplicationService jobApplicationService = new JobApplicationService();
        System.out.println(jobApplicationService.getApplicationByJobIdAndCanId(2,53));
    }
}

