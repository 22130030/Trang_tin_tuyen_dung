package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.controller.CompanyController;
import com.vn.tim_viec_lam.dao.CompanyDao;
import com.vn.tim_viec_lam.dao.model.Company;

import java.util.List;

public class CompanyService {
    private CompanyDao companyDao;

    public CompanyService() {
        companyDao = new CompanyDao();
    }

    public Company findCompanyById(int id) {
        return companyDao.getCompanyById(id);

    }
    public List<Company> getAllCompany() {
        return companyDao.getAll();
    }
    public List<Company> getCompanyByName(String name) {
        return companyDao.findByName(name);
    }
    public List<Company> filterByCity(List<String> city) {
        return companyDao.filterByCity(city);
    }
    public List<Company> findByEmail(String email) {
        return companyDao.findByEmail(email);
    }
    public List<Company> getUserCompany() {
        return companyDao.getListCompanyUser();
    }
    public void deleteUserCompany(int id) {
        companyDao.deleteUserCompany(id);
    }
    public Company getListCompanyUserById(int id) {
        return companyDao.getListCompanyUserbyID(id);
    }
    public void editUserCompany(int pid, String pname, String pemail, String pphone,String pstatus, String paddress) {
        companyDao.editUser(pid,pname,pemail,pphone,pstatus,paddress);
    }

    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        System.out.println(companyService.getUserCompany());
    }



}
