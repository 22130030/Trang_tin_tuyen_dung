package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.UserDao;
import com.vn.tim_viec_lam.dao.model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public UserService() {
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

}
