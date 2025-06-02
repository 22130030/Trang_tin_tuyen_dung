package com.vn.tim_viec_lam.service;


import com.vn.tim_viec_lam.dao.UserDao;
import com.vn.tim_viec_lam.dao.model.User;
import io.github.cdimascio.dotenv.Dotenv;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class UserService {
    private UserDao userDao;


    public UserService() {
        userDao = new UserDao();
    }
//    public boolean login(String email, String password) {
//        return userDao.getUser(email,EncryptionService.hasPasswordToMD5(password));
//    }
public boolean login(String email, String password) {
    User user = userDao.getUserByEmail(email);
    if (user == null) {
        return false; // Email không tồn tại
    }
    String storedHashedPassword = userDao.getPasswordByUserId(user.getUserID());
    if (storedHashedPassword == null) {
        return false; // Không có mật khẩu lưu cho user này
    }

    String hashedInputPassword = EncryptionService.hasPasswordToMD5(password);
    return storedHashedPassword.equals(hashedInputPassword);
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
    public void editUser(int id, String email, String pass, int role, int status, String image){
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
    public int getUserIdByCandidateId(int candidateId) {
        return userDao.getUserIdByCandidateId(candidateId);
    }
    public boolean updateIsOnline(int id, int online) {
        return userDao.updateIsOnline(id,online);
    }
    public int getIsOnline(int id) {
        return userDao.getIsOnlineByUserID(id);
    }
    public boolean getLockStatus(int userId) {
        int status =  userDao.getLockStatus(userId);
        return status == -1 ? true : false;
    }
    public int getPermissionIdForAdmin(int userId) {
        return userDao.getPermissionIdForAdmin(userId);
    }

    public boolean updatePermissionIdForAdmin(int userId, int permissionId) {
        if(userDao.getPermissionIdForAdmin(userId) != 0){
            return userDao.updatePermissionIdForAdmin(userId, permissionId);
        }
        return userDao.insertPermissionIdForAdmin(userId,permissionId);
    }
    public User getUserById(int userID) {
        return userDao.getUserById(userID);
    }
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getPermissionIdForAdmin(2));
    }

}

