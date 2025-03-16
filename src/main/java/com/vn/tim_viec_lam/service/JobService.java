package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobDao;
import com.vn.tim_viec_lam.dao.model.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobService {
    JobDao jobDao = new JobDao();
    public JobService() {}

    public List<Job> getAllJob(){
        return jobDao.getAll();
    }
    public List<Job> getNewJob(){
        return jobDao.get4NewJob();
    }
    public List<Job> getAllNewJob(){
        return jobDao.getAllNewJob();
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
    public List<Job> getSearchJobByNameJob(String name){
        return jobDao.searchJobEqualsByNamejob(name);
    }
    public void deleteJobPosting(int id){
        jobDao.deleteJobPosting(id);
    }

    public  void editJobPosting(int cid, String img, String titleJob, String companyName,String city,String salary,String status ){
        jobDao.editJobPosting(cid,img,titleJob,companyName,city,salary,status);
    }
    public void addJobPosting(String img,String titleJob,String  companyName,String city,String salary,String status){
        jobDao.addJobPostWithJoin(img,titleJob,companyName,city,salary,status);
    }
    public List<Job> getJobsByAddress(String address){
        return jobDao.searchJobByAddress(address);
    }
    public List<Job> getJobByJobPostCategoryId(int categoryId){
        return jobDao.getJobsByJobPostCategoryId(categoryId);
    }
    public List<Job> getJobByCategoryId(int categoryId){
        return jobDao.getJobsByCategoryId(categoryId);
    }
    public Map<Character,List<String>> getFristLetterLocation(){
        Map<Character,List<String>> fristLetterLocation = new HashMap<Character,List<String>>();
        List<String> location = jobDao.getAllLocation();

        for(String str : location){
            if(fristLetterLocation.containsKey(str.charAt(0))){
                fristLetterLocation.get(str.charAt(0)).add(str);
            }else{
                List<String> word = new ArrayList<>();
                word.add(str);
                fristLetterLocation.put(str.charAt(0),word);
            }
        }
        return fristLetterLocation;
    }
    public boolean addJobPosting(String companyName,String employerSize,String website,String jobName,String jobAddress
    ,String salaryValue,String salaryUnit,String educationLevel,String experienceLevel,String jobType,String jobLocation,
                                 String jobCategory,String keywords,String age,String contactName
    ,String contactEmail,String contactPhone,String contactAddress ,String jobPostingDate,String JobExpiryDate,String language){
        return jobDao.addJobPosting(companyName,employerSize,website,jobName,jobAddress,salaryValue,salaryUnit,educationLevel,experienceLevel,jobType,jobLocation,jobCategory,keywords,age,contactName,contactEmail,contactPhone,contactAddress,jobPostingDate,JobExpiryDate,language);
    }
    public List<Job> filterJob(String jobName,String jobCategory,String jobLocation){
        return jobDao.filterJobs(jobName,jobCategory,jobLocation);
    }

    public static void main(String[] args) {
        JobService jobService = new JobService();
        System.out.println(jobService.filterJob("j","",""));
    }
}