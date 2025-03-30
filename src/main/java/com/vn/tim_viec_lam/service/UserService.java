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
        return userDao.getUser(email,EncryptionService.hasPasswordToMD5(password));
    }
    public User getUser(String email) {
        return userDao.getUserByEmail(email);
    }
    public List<User> getListAll(){
        return userDao.getListUser();
    }


    public List<User> FindListUserByEmail(String  email){
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
    public boolean insetUser(String email,String pass, String rePass,String fName,String phone){
        if(rePass.equals(pass)){
            return userDao.insertUser(email,pass,fName,phone);
        }
        return false;
    }
    public boolean addUser(String email,String pass,String fName,String phone){
        return userDao.insertUser(email,EncryptionService.hasPasswordToMD5(pass),fName,phone);
    }
    public boolean updateStatus(int id,int status)  {
        return userDao.setStatus(id,status);
    }
    public boolean isEmailExists(String email){
        return userDao.isEmailExists(email);
    }
    public boolean updatePassword(String email, String newPassword) {
        return userDao.updatePasswordByEmail(email, newPassword);
    }
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.insetUser("email@gmail.com","1","1","van duc","03545162839"));
    }
}

