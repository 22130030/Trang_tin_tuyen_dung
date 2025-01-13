package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Job;
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
    public List<User> getListUser(){
        List<User> users = new ArrayList<User>();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum " +
                "FROM users u " +
                "JOIN roles r ON u.userId = r.userId";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = getResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return users;
    }
    public List<User> findListUserbyEmail(String email){
        List<User> users = new ArrayList<User>();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum " +
                "FROM users u " +
                "JOIN roles r ON u.userId = r.userId " +
                "WHERE u.email LIKE ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + email + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User user = getResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public boolean deleteUser(int userId) {
        Connection conn = DBconnect.getConnection();
        String deleteRolesSQL = "DELETE FROM roles WHERE userID = ?";
        String deleteUserSQL = "DELETE FROM users WHERE userID = ?";

        try (PreparedStatement deleteRolesStmt = conn.prepareStatement(deleteRolesSQL);
             PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSQL)) {

            // Xóa dữ liệu trong bảng roles
            deleteRolesStmt.setInt(1, userId);
            deleteRolesStmt.executeUpdate();

            // Xóa dữ liệu trong bảng users
            deleteUserStmt.setInt(1, userId);
            int rowsAffected = deleteUserStmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateUser(int id, String email, String pass, int role, String status) {
        Connection conn = DBconnect.getConnection();
        String updateUserSQL = "UPDATE users SET email = ?, password = ?, status = ? WHERE userID = ?";
        String updateRoleSQL = "UPDATE roles SET roleNum = ? WHERE userID = ?";

        try {
            // Cập nhật bảng users
            try (PreparedStatement userStmt = conn.prepareStatement(updateUserSQL)) {
                userStmt.setString(1, email);
                userStmt.setString(2, pass);
                userStmt.setString(3, status);
                userStmt.setInt(4, id);
                userStmt.executeUpdate();
            }

            // Cập nhật bảng roles
            try (PreparedStatement roleStmt = conn.prepareStatement(updateRoleSQL)) {
                roleStmt.setInt(1, role);
                roleStmt.setInt(2, id);
                roleStmt.executeUpdate();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public User getResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        int id = rs.getInt("userID");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String phone = rs.getString("phone_number");
        String status = rs.getString("status");
        LocalDateTime created = rs.getTimestamp("created_at").toLocalDateTime();
        int roleNum = rs.getInt("roleNum");
        user = new User(id, email, password, phone, status, created, roleNum);
        return user;
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
     //   System.out.println(dao.getListUser());
//        System.out.println(dao.findListUserbyEmail("user9"));
      //  System.out.println(dao.deleteUser(7));
        int userId = 1; // ID user muốn cập nhật
        String newEmail = "newemail@example.com";
        String newPassword = "111111";
        int newRole = 2; // Vai trò mới
        String newStatus = "Da duyet";
        System.out.println(dao.updateUser(userId, newEmail, newPassword, newRole, newStatus));
    }

}
