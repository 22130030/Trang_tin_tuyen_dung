package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CategoryDao;
import com.vn.tim_viec_lam.dao.JobCategoryDao;
import com.vn.tim_viec_lam.dao.JobPostCategoryDAO;
import com.vn.tim_viec_lam.dao.model.JobCategory;
import com.vn.tim_viec_lam.dao.model.JobCategoryCount;

import java.sql.SQLException;
import java.util.List;

public class JobCategoryService {
    JobCategoryDao jobCategoryDao;
    private JobPostCategoryDAO dao = new JobPostCategoryDAO();

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
    public int addCategory(String jobCategory,String jobCategoryName) {
        return jobCategoryDao.addCategory(jobCategory, jobCategoryName);
    }
    public List<JobCategoryCount> getJobCategoryCounts() throws SQLException {
        return dao.getJobCategoryCounts();
    }
    public List<JobCategoryCount> getCategoriesByPage(int pageIndex) {
        return dao.getCategoriesByPage(pageIndex);
    }
    public int getNumberPage() {
        return dao.getNumberPage();
    }

    public static void main(String[] args) {
        JobCategoryService service = new JobCategoryService();
        System.out.println(service.addCategory("aa","222"));
    }
}
