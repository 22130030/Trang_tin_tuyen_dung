package com.vn.tim_viec_lam.service;


import com.vn.tim_viec_lam.dao.UserDao;
import com.vn.tim_viec_lam.dao.model.User;
import io.github.cdimascio.dotenv.Dotenv;


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
    public void editUser(int id, String email, String pass, int role, String status, String image){
        userDao.updateUser(id, email, pass, role, status, image);
    }
    public boolean insetUser(String email,String pass, String rePass,String fName,String phone,String auth_provider,String provider_id){
        if(rePass.equals(pass)){
            return userDao.insertUser(email,pass,fName,phone,auth_provider,provider_id);
        }
        return false;
    }
    public boolean addUser(String email,String pass,String fName,String phone,String auth_provider,String provider_id){
        return userDao.insertUser(email,EncryptionService.hasPasswordToMD5(pass),fName,phone,auth_provider,provider_id);
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
    public boolean updateImage(int id , String image) {
        return userDao.updateImage(id , image);
    }
    public String getPasswordByEmail(String email) {
        return userDao.getPasswordByEmail(email);
    }
    public boolean newPasswordByEmail(String email, String newPassword) {
        return userDao.NewPasswordByEmail(email, newPassword);
    }
    public static void main(String[] args) {
           Dotenv dotenv = Dotenv.load();
           String clientId = dotenv.get("GOOGLE_CLIENT_ID");
           String clientSecret = dotenv.get("GOOGLE_CLIENT_SECRET");
           String REDIRECT_URI = dotenv.get("REDIRECT_URI");
           System.out.println(REDIRECT_URI);
    }
}

