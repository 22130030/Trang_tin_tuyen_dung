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
    public List<UserLog> getListLog() {
        List<UserLog> logs = new ArrayList<>();

        Connection conn = DBconnect.getConnection();
        String sql = "SELECT * FROM user_log ORDER BY log_time DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserLog log = new UserLog();
                log.setId(rs.getInt("id"));
                log.setUserId(rs.getInt("userID"));
                log.setUsername(rs.getString("username"));
                log.setRole(rs.getString("role"));
                log.setAction(rs.getString("action"));
                log.setLoginType(rs.getString("login_type"));
                log.setStatus(rs.getString("status"));
                log.setIpAddress(rs.getString("ip_address"));
                log.setLogTime(rs.getTimestamp("log_time")); // hoặc rs.getDate(...) nếu dùng Date
                log.setDescription(rs.getString("description"));
                logs.add(log);
            }
            return logs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        LogDao logDao = new LogDao();
        System.out.println(logDao.getListLog());
    }
}
