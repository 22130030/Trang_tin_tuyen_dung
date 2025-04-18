package com.vn.tim_viec_lam.dao;


import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;


import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.vn.tim_viec_lam.service.EncryptionService.hasPasswordToMD5;


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
        String sql = "select * from users u" +
                " join user_auth ua on ua.userID = u.userID" +
                " where email = ? and password = ?";
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
        String image = rs.getString("image");
        return new User(id,email,"",name,phoneNumber,status,date,role,image);
    }




    public List<User> getListUser(){
        List<User> users = new ArrayList<User>();


        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum,ua.password,ua.provider_id " +
                "FROM users u " +
                " join user_auth ua on ua.userID = u.userID" +
                " JOIN roles r ON u.userId = r.userId";
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
        String sql = "SELECT u.*, r.roleNum,ua.password,ua.provider_id  " +
                "FROM users u " +
                "JOIN roles r ON u.userId = r.userId " +
                " join user_auth ua on ua.userID = u.userID" +
                " WHERE u.email LIKE ? ";
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
    public User findListUserbyID(int id) {
        User user = new User();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT u.*, r.roleNum, ua.password, ua.provider_id " +
                "FROM `users` u " +
                "JOIN `roles` r ON u.`userID` = r.`userID` " +
                "JOIN `user_auth` ua ON ua.`userID` = u.`userID` " +
                "WHERE u.`userID` = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
        String deleteUserAuthSQL = "DELETE FROM user_auth WHERE userID = ?";

        try (
                PreparedStatement deleteRolesStmt = conn.prepareStatement(deleteRolesSQL);
                PreparedStatement deleteUserAuthStmt = conn.prepareStatement(deleteUserAuthSQL);
                PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSQL)
        ) {
            // Xóa dữ liệu trong bảng roles
            deleteRolesStmt.setInt(1, userId);
            deleteRolesStmt.executeUpdate();

            // Xóa dữ liệu trong bảng user_auth
            deleteUserAuthStmt.setInt(1, userId);
            deleteUserAuthStmt.executeUpdate();

            // Xóa dữ liệu trong bảng users
            deleteUserStmt.setInt(1, userId);
            int rowsAffected = deleteUserStmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(int id, String email, String pass, int role, String status, String image) {
        Connection conn = DBconnect.getConnection();
        String updateUserSQL = "UPDATE users SET email = ?, status = ?, image = ? WHERE userID = ?";
        String updateRoleSQL = "UPDATE roles SET roleNum = ? WHERE userID = ?";
        String updatePassSQL = "UPDATE user_auth SET password = ? WHERE userID = ?";

        try {
            // Cập nhật bảng users
            try (PreparedStatement userStmt = conn.prepareStatement(updateUserSQL)) {
                userStmt.setString(1, email);
                userStmt.setString(2, status);
                userStmt.setString(3, image);
                userStmt.setInt(4, id);
                userStmt.executeUpdate();
            }


            // Cập nhật bảng roles
            try (PreparedStatement roleStmt = conn.prepareStatement(updateRoleSQL)) {
                roleStmt.setInt(1, role);
                roleStmt.setInt(2, id);
                roleStmt.executeUpdate();
            }
            try (PreparedStatement passStmt = conn.prepareStatement(updatePassSQL)) {
                passStmt.setString(1, pass);
                passStmt.setInt(2, id);
                passStmt.executeUpdate();
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
        String provider_id = rs.getString("provider_id");
        String image = rs.getString("image");
        user = new User(id, email, password, phone,status, created,provider_id,image);
        return user;
    }




    public boolean insertUser(String email, String pass, String fullName,String phone,String auth_provider,String provider_id) {
        Connection con = DBconnect.getConnection();
        String sql = "insert into users(email,phone_number,status,created_at,name) values(?,?,1,NOW(),?)";
        try {
            PreparedStatement prep = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1,email);
            prep.setString(2,phone);
            prep.setString(3,fullName);
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
                    int index = 1;
                    prep = con.prepareStatement(sql);
                    prep.setInt(index++,userID);
                    prep.setString(index++,fullName);
                    prep.setString(index++,email);
                    prep.setString(index++,phone);
                    prep.executeUpdate();
                    sql = " insert into user_auth(userID,auth_provider,provider_id,password,created_at) values(?,?,?,?,NOW())";
                    prep = con.prepareStatement(sql);
                    index = 1;
                    prep.setInt(index++,userID);
                    prep.setString(index++,auth_provider);
                    prep.setString(index++,provider_id);
                    prep.setString(index++,pass);
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
    public String getPasswordByEmail(String email) {
        Connection connection = DBconnect.getConnection();
        String sql = "SELECT ua.password FROM user_auth ua " +
                "JOIN users u ON ua.userID = u.userID " +
                "WHERE u.email = ? AND ua.auth_provider = 'local'";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving password for email: " + email, e);
        }

        return null; // Nếu không tìm thấy mật khẩu
    }
    public boolean NewPasswordByEmail(String email, String newPassword) {
        Connection connection = DBconnect.getConnection();
        String sql = "UPDATE user_auth ua " +
                "JOIN users u ON ua.userID = u.userID " +
                "SET ua.password = ? " +
                "WHERE u.email = ? AND ua.auth_provider = 'local'";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating password for email: " + email, e);
        }
    }
    public boolean updatePasswordByEmail(String email, String newPassword) {
        Connection connection = DBconnect.getConnection();
        String sql = "UPDATE user_auth ua" +
                " JOIN users u ON ua.userID = u.userID" + // Sửa user_id thành userID
                " SET ua.password = ?" +
                " WHERE u.email = ? AND ua.auth_provider = 'local';";

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
    public boolean getProviderID(String provider_id) {
        Connection con = DBconnect.getConnection();
        String sql = "SELECT provider_id FROM user_auth WHERE provider_id = ? and auth_provider = 'facebook'";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, provider_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateImage (int id, String image) {
        Connection con = DBconnect.getConnection();
        String sql = "UPDATE users SET image = ? WHERE userID = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
          stmt.setString(1,image);
          stmt.setInt(2,id);
          int rowsUpdated = stmt.executeUpdate();
          return rowsUpdated > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        System.out.println(dao.insertUser("22","1","vanduc","2222","local","g22"));
//         System.out.println(dao.updateImage(28,"https://moc247.com/wp-content/uploads/2023/12/loa-mat-voi-101-hinh-anh-avatar-meo-cute-dang-yeu-dep-mat_2.jpg")

}
}

