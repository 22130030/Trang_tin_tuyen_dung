package com.vn.tim_viec_lam.service;


import com.vn.tim_viec_lam.dao.VerificationTokenDao;
import com.vn.tim_viec_lam.dao.model.VerificationToken;


public class VerifycationTokenService {
    private VerificationTokenDao verificationTokenDao;


    public VerifycationTokenService() {
        verificationTokenDao = new VerificationTokenDao();
    }


    public int addVerificationToken(String email, String token) {
        return verificationTokenDao.addToken(email,token);
    }
    public String getTokenById(int id) {
        return verificationTokenDao.getToken(id);
    }
    public String getEmailByToken(String token) {
        return verificationTokenDao.getEmailByToken(token);
    }
    public void deleteToken(String token) {
        verificationTokenDao.deleteToken(token);
    }
    public boolean isTokenValid(String token) {
        return verificationTokenDao.isTokenValid(token);
    }
}

