package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CompanyUserDao;
import com.vn.tim_viec_lam.dao.model.CompanyUser;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CompanyUserService {
    private CompanyUserDao userDao;
    public CompanyUserService(){
        userDao = new CompanyUserDao();
    }
    public boolean login(String email, String password) {
        return userDao.getUser(email,hasPasswordToMD5(password));
    }
    public CompanyUser getUser(String email) {
        return userDao.getUserByEmail(email);
    }
    public List<CompanyUser> getListAll(){
        return userDao.getAll();
    }
    public String hasPasswordToMD5(String password) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CompanyUserService companyService = new CompanyUserService();
        System.out.println(EncryptionService.hasPasswordToMD5("1"));
        System.out.println(companyService.login("company@gmail.com",EncryptionService.hasPasswordToMD5("1")));
    }
}
