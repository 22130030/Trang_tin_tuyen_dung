package com.vn.tim_viec_lam.dao;


import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from users u" +
                " join roles r on r.userID = u.userID";
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
        String sql = "select * from users u" +
                " join roles r on r.userId = u.userID" +
                " where email = ?";
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
        int role = rs.getInt("roleNum");
//        String password = rs.getString("password");
        String name = rs.getString("name");
        String phoneNumber = rs.getString("phone_number");
        String status = rs.getString("status");
        LocalDateTime date = rs.getTimestamp("created_at").toLocalDateTime();
        return new User(id,email,"",name,phoneNumber,status,date,role);
    }




    public List<User> getListUser(){
        List<User> users = new ArrayList<User>();


        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum " +
                "FROM users u " +
                "JOIN roles r ON u.userId = r.userId";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = getResultSet(rs);
                users.add(user);
            }
            return users;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            while(rs.next()){
                User user = getResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public User findListUserbyID(int id){
        User user = new User();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum " +
                "FROM users u " +
                "JOIN roles r ON u.userId = r.userId " +
                "WHERE u.userID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = getResultSet(rs);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


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
        user = new User(id, email, password, phone,status, created);
        return user;
    }




    public boolean insertUser(String email, String pass, String fullName,String phone) {
        Connection con = DBconnect.getConnection();
        String sql = "insert into users(email,password,phone_number,status,created_at,name) values(?,?,?,1,NOW(),?)";
        try {
            PreparedStatement prep = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1,email);
            prep.setString(2,pass);
            prep.setString(3,phone);
            prep.setString(4,fullName);
            int rowsAffected = prep.executeUpdate();
            if(rowsAffected>0){
                ResultSet rs = prep.getGeneratedKeys();
                if(rs.next()){
                    int userID = rs.getInt(1);
                    sql = " insert into roles(userID,roleNum) values(?,?)";
                    prep = con.prepareStatement(sql);
                    prep.setInt(1,userID);
                    prep.setInt(2,1);
                    prep.executeUpdate();
                    sql = " insert into candidates(userID,fullName,email,phone) values(?,?,?,?)";
                    prep = con.prepareStatement(sql);
                    prep.setInt(1,userID);
                    prep.setString(2,fullName);
                    prep.setString(3,email);
                    prep.setString(4,phone);
                    prep.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email.trim().toLowerCase()); // Chuẩn hóa email
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean setStatus(int userID, int status) {
        Connection con = DBconnect.getConnection();
        String sql = "UPDATE users SET status = ? WHERE userID = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, userID);
            int res = pre.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updatePasswordByEmail(String email, String newPassword) {
        Connection connection = DBconnect.getConnection();
        String sql = "UPDATE users SET password = ? WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        System.out.println(dao.setStatus(1,0));
        System.out.println(dao.isEmailExists("caominhhieunq@gmail.com"));
    }
}

