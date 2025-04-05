package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompanyUserDao {
    public List<CompanyUser> getAll() {
        List<CompanyUser> users = new ArrayList<CompanyUser>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from users u" +
                " join roles r on r.userID = u.userID" +
                " join company_users cu on cu.userID = u.userID" +
                " join companies c on c.companyID = cu.companyID";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CompanyUser u = excute(rs);
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CompanyUser getUserByEmail(String email) {
        Connection con = DBconnect.getConnection();
        String sql = "select * from users u" +
                " join roles r on r.userID = u.userID" +
                " join company_users cu on cu.userID = u.userID" +
                " join companies c on c.companyID = cu.companyID" +
                " where u.email = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            CompanyUser user = null;
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
        String sql = "select * from users u" +
                " join user_auth ua on ua.userID = u.userID" +
                " where u.email = ? and ua.password = ?";
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
    public CompanyUser excute(ResultSet rs) throws SQLException {
        int id = rs.getInt("userID");
        int companyID = rs.getInt("companyID");
        String email = rs.getString("email");
        int role = rs.getInt("roleNum");
//        String password = rs.getString("password");
        String name = rs.getString("companyName");
        String phoneNumber = rs.getString("phone_number");
        String status = rs.getString("status");
        LocalDateTime date = rs.getTimestamp("created_at").toLocalDateTime();
        return new CompanyUser(id,companyID,email,"",name,phoneNumber,status,date,role);
    }

}
