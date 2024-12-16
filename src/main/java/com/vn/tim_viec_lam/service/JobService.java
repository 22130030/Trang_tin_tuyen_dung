package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobDao;
import com.vn.tim_viec_lam.dao.model.Job;

import java.util.ArrayList;
import java.util.List;

public class JobService {
    JobDao jobDao = new JobDao();
    public JobService() {}

    public List<Job> getAllJob(){
        return jobDao.getAll();
    }
    public List<Job> getNewJob(){
        return jobDao.get4NewJob();
    }

    public static void main(String[] args) {
        JobService jobService = new JobService();
        System.out.println(jobService.getAllJob());
    }
}
