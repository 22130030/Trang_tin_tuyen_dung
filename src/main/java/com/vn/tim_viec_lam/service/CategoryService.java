package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CategoryDao;
import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;

import java.util.List;
import java.util.Map;

public class CategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public Map<JobPostCategory, List<Category>> getCategories(){
        return categoryDao.getMapCategories();
    }
    public List<JobPostCategory> getCategoriesByNumberPage(int number){
        return categoryDao.getPaging(number);
    }
}
