package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from users";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = excute(rs);
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUserByEmail(String email) {
        Connection con = DBconnect.getConnection();
        String sql = "select * from users where email = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            User user = null;
            if(rs.next()) {
                user = excute(rs);
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean getUser(String email,String password) {
        Connection con = DBconnect.getConnection();
        String sql = "select * from users where email = ? and password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User excute(ResultSet rs) throws SQLException {
        int id = rs.getInt("userID");
        String email = rs.getString("email");
//        String password = rs.getString("password");
        String name = rs.getString("name");
        String phoneNumber = rs.getString("phone_number");
        String status = rs.getString("status");
        LocalDateTime date = rs.getTimestamp("created_at").toLocalDateTime();
        return new User(id, email, null,name, phoneNumber, status, date);
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        System.out.println(dao.getAll());
    }
}
