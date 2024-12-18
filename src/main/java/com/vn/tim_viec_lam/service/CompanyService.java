package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CompanyDao;
import com.vn.tim_viec_lam.dao.model.Company;

public class CompanyService {
    private CompanyDao companyDao;
    public CompanyService() {
       companyDao =  new CompanyDao();
    }
    public Company findCompanyById(int id) {
        return companyDao.getCompanyById(id);

    }

    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        System.out.println(companyService.findCompanyById(1));
    }
}
