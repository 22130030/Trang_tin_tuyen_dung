package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.UserDao;
import com.vn.tim_viec_lam.dao.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
    public List<User> getListAll(){
      return userDao.getListUser();
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
    }public List<User> FindListUserByEmail(String  email){
        return userDao.findListUserbyEmail(email);
    }
    public User FindListUserByID(int  id){
        return userDao.findListUserbyID(id);
    }

    public void deleteUserByID(int id){
        userDao.deleteUser(id);
    }
    public void editUser(int id, String email, String pass, int role, String status){
        userDao.updateUser(id, email, pass, role, status);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.hasPasswordToMD5("1"));
    }
}
