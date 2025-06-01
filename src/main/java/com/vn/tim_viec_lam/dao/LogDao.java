package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.dao.model.Log;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.dao.model.UserLog;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class LogDao {
    public List<Log> getLogs(){
        List<Log> logs = new ArrayList<>();
        Connection connection = DBconnect.getConnection();

        String sql = "select * from logworks";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("logID");
                LocalDateTime dateTime = resultSet.getTimestamp("logTime").toLocalDateTime();
                String res = resultSet.getString("resource");
                String dataNew = resultSet.getString("dataNew");
                String dataOld = resultSet.getString("dataOld");
                logs.add(new Log(id,dateTime,res,dataNew,dataOld));

            }
            return logs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean addLog(String resource,String dataNew){
        Connection connection = DBconnect.getConnection();

        String sql = "insert into logworks(logTime,resource,dataNew,dataOld)" +
                " values(NOW(),?,?,?)";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1,resource);
            prep.setString(2,dataNew);
            prep.setString(3,dataNew);
            int res = prep.executeUpdate();

            return res == 1 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public boolean insertUserLog(UserLog userlog) {
//        try {
//            Connection con = DBconnect.getConnection();
//            String sql = "INSERT INTO user_log (userID, username, role, action, login_type, status, ip_address, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            if (userlog.getUserId() != null) {
//                ps.setInt(1, userlog.getUserId());
//            } else {
//                ps.setNull(1, Types.INTEGER);
//            }
//            ps.setString(2, userlog.getUsername());
//            ps.setString(3, userlog.getRole());
//            ps.setString(4, userlog.getAction());
//            ps.setString(5, userlog.getLoginType());
//            ps.setString(6, userlog.getStatus());
//            ps.setString(7, userlog.getIpAddress());
//            ps.setString(8, userlog.getDescription());
//            int rows = ps.executeUpdate();
//            return rows > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
public boolean insertUserLog(User user, String role, String action, String loginType, String status, String ipAddress, String description) {
    try {
        Connection con = DBconnect.getConnection();
        String sql = "INSERT INTO user_log (userID, username, role, action, login_type, status, ip_address, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        // userID và username lấy từ User (nếu có)
        if (user != null) {
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getEmail());
        } else {
            ps.setNull(1, Types.INTEGER);
            ps.setNull(2, Types.VARCHAR);
        }

        ps.setString(3, role);
        ps.setString(4, action);
        ps.setString(5, loginType);
        ps.setString(6, status);
        ps.setString(7, ipAddress);
        ps.setString(8, description);

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
    public boolean insertUserCompanyLog(CompanyUser user, String role, String action, String loginType, String status, String ipAddress, String description) {
        try {
            Connection con = DBconnect.getConnection();
            String sql = "INSERT INTO user_log (userID, username, role, action, login_type, status, ip_address, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            // userID và username lấy từ User (nếu có)
            if (user != null) {
                ps.setInt(1, user.getUserID());
                ps.setString(2, user.getEmail());
            } else {
                ps.setNull(1, Types.INTEGER);
                ps.setNull(2, Types.VARCHAR);
            }

            ps.setString(3, role);
            ps.setString(4, action);
            ps.setString(5, loginType);
            ps.setString(6, status);
            ps.setString(7, ipAddress);
            ps.setString(8, description);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        LogDao logDao = new LogDao();

        // Test 1: Insert log với user
        User user = new User();
        user.setUserID(2);
        user.setEmail("testuser@gmail.com");

        boolean result1 = logDao.insertUserLog(user, "ung_vien", "login", "password", "success", "127.0.0.1", "Test insert log có user");
        if (result1) {
            System.out.println("Thêm log (có user) thành công!");
        } else {
            System.out.println("Thêm log (có user) thất bại!");
        }
    }
}
