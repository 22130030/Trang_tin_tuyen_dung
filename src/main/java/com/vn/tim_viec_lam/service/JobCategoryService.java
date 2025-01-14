package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.JobCategoryDao;
import com.vn.tim_viec_lam.dao.model.JobCategory;

import java.util.List;

public class JobCategoryService {
    JobCategoryDao jobCategoryDao;

    public JobCategoryService() {
        jobCategoryDao = new JobCategoryDao();
    }
    public List<JobCategory> getListCategory() {
        return jobCategoryDao.getListJobCategroy();
    }
    public List<JobCategory> FindListCategoryByNameJob(String jobName) {
        return jobCategoryDao.FindListJobCategroy(jobName);
    }
    public JobCategory FindListCategoryNameJobByID(int id) {
        return jobCategoryDao.FindListJobCategroyByID(id);
    }
    public void deleteCategory(int id) {
        jobCategoryDao.deleteJobPostCategory(id);
    }
    public void editCategory(int id,String jobCategory,String jobCategoryName) {
        jobCategoryDao.editCategory(id, jobCategory, jobCategoryName);
    }
}
