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
    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        String sql = "select * from logworks";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql);
             ResultSet resultSet = prep.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("logID");
                LocalDateTime dateTime = resultSet.getTimestamp("logTime").toLocalDateTime();
                String res = resultSet.getString("resource");
                String dataNew = resultSet.getString("dataNew");
                String dataOld = resultSet.getString("dataOld");
                logs.add(new Log(id, dateTime, res, dataNew, dataOld));
            }
            return logs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addLog(String resource, String dataNew) {
        String sql = "insert into logworks(logTime,resource,dataNew,dataOld) values(NOW(),?,?,?)";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1, resource);
            prep.setString(2, dataNew);
            prep.setString(3, dataNew);
            int res = prep.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertUserLog(User user, String role, String action, String loginType, String status, String ipAddress, String description) {
        String sql = "INSERT INTO user_log (userID, username, role, action, login_type, status, ip_address, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertUserCompanyLog(CompanyUser user, String role, String action, String loginType, String status, String ipAddress, String description) {
        String sql = "INSERT INTO user_log (userID, username, role, action, login_type, status, ip_address, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserLog> getListLog() {
        List<UserLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM user_log ORDER BY id ASC";

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
                log.setLogTime(rs.getTimestamp("log_time"));
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