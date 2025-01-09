package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CategoryDao;
import com.vn.tim_viec_lam.dao.CompanyDao;
import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.CompanyStatusCategory;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;

import java.util.List;
import java.util.Map;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    CompanyDao companyDao = new CompanyDao();
    public Map<JobPostCategory, List<Category>> getCategories(){
        return categoryDao.getMapCategories();
    }
    public List<JobPostCategory> getCategoriesByNumberPage(int number){
        return categoryDao.getPaging(number);
    }
    public List<CompanyStatusCategory> getCompanyStatusCategories(){
        return companyDao.getAllStatusCategory();
    }

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();
        System.out.println(categoryService.getCompanyStatusCategories());
    }
}
