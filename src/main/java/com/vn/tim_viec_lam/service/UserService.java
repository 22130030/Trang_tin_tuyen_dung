package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.UserDao;
import com.vn.tim_viec_lam.dao.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    private UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }
    public boolean login(String email, String password) {
        return userDao.getUser(email,hasPasswordToMD5(password));
    }
    public User getUser(String email) {
        return userDao.getUserByEmail(email);
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
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.hasPasswordToMD5("1"));
    }
}
