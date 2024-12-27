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
    public Job getJobById(int id){
        return jobDao.findById(id);
    }
    public List<Job> getJobByCompanyId(int companyId) {
        return jobDao.getJobsByCompanyId(companyId);
    }

    public int getNumberPage(){
        return jobDao.getNumberPage();
    }
    public List<Job> getJobByPage(int page){

        return jobDao.getPaging(page);
    }
    public List<Job> getListSearchJob(String txtName,String txtAddress){
        if((txtName.isBlank() || txtName == null) && (!txtAddress.isBlank() || txtAddress != null) ){
            return jobDao.searchJobByAddress(txtAddress);

        }else if((txtAddress.isBlank() || txtAddress == null) && (!txtName.isBlank() || txtName != null) ){
            return jobDao.searchEqualsByName(txtName);

        }else if((!txtAddress.isBlank() || txtAddress != null) && (!txtName.isBlank() || txtName != null)){
            return jobDao.searchJobByNameAndAddress(txtName, txtAddress);
        }
        return null;
    }
//    public List<Job> getListSearchByAddress(String address){
//        return jobDao.searchEqualsByAddrress(address);
//    }
    public List<Job> getJobByCategoryId(int categoryId){
        return jobDao.getJobsByCategoryId(categoryId);
    }
    public static void main(String[] args) {
        JobService jobService = new JobService();
        System.out.println(jobService.getListSearchJob("nhan vien","Ho Chi Minh"));
    }
}