package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobApplicationDao;
import com.vn.tim_viec_lam.dao.model.JobApplication;

import java.util.List;

public class JobApplicationService {
    private JobApplicationDao jobApplicationDao;
    public JobApplicationService(){
        jobApplicationDao = new JobApplicationDao();
    }
    public boolean addJobApplicationFromAccount(int companyID, int jobPostID,int resumesID,int candidateID){
        return jobApplicationDao.addJobApplicationFromAccount(companyID, jobPostID, resumesID, candidateID);
    }
    public List<JobApplication> getAll(){
        return jobApplicationDao.getAll();
    }
    public boolean addJobAppFromComputer(String path, String fileName,String type,int jobID,int companyID,int candidateId) {
        return jobApplicationDao.addJobAppFromComputer(path, fileName, type, jobID, companyID, candidateId);
    }
}

