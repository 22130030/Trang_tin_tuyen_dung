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

import static com.vn.tim_viec_lam.service.EncryptionService.hasPasswordToMD5;

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
    public boolean isEmailExistsEmployer(String email) {
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
    public boolean insertUserEmployer(String email,String name, String password, String rePassword, String companyName, String phone, String address) {
        if (email == null || password == null || rePassword == null || companyName == null || phone == null || address == null) {
            return false;
        }

        if (!password.equals(rePassword)) {
            return false; // Mật khẩu nhập lại không khớp
        }

        Connection con = DBconnect.getConnection();
        PreparedStatement pstUser = null, pstCompany = null, pstCompanyUser = null, pstUserAuth = null, pstRole = null;
        ResultSet rsUser = null, rsCompany = null;

        try {
            con.setAutoCommit(false);

            // 1. Insert vào bảng users
            String sqlUser = "INSERT INTO users (email, phone_number,name, status, created_at) VALUES (?, ?, ?, ?, NOW())";
            pstUser = con.prepareStatement(sqlUser, PreparedStatement.RETURN_GENERATED_KEYS);
            pstUser.setString(1, email);
            pstUser.setString(2, phone);
            pstUser.setString(3, name);
            pstUser.setInt(4, 0);
            pstUser.executeUpdate();

            rsUser = pstUser.getGeneratedKeys();
            int userID = rsUser.next() ? rsUser.getInt(1) : -1;

            // 2. Insert vào bảng companies
            String sqlCompany = "INSERT INTO companies (logo, companyName, address, website, city) VALUES (?, ?, ?, ?, ?)";
            pstCompany = con.prepareStatement(sqlCompany, PreparedStatement.RETURN_GENERATED_KEYS);
            pstCompany.setString(1, ""); // logo mặc định rỗng
            pstCompany.setString(2, companyName);
            pstCompany.setString(3, address);
            pstCompany.setString(4, ""); // website mặc định rỗng
            pstCompany.setString(5, ""); // city mặc định rỗng
            pstCompany.executeUpdate();

            rsCompany = pstCompany.getGeneratedKeys();
            int companyID = rsCompany.next() ? rsCompany.getInt(1) : -1;

            // 3. Liên kết user và công ty
            String sqlCompanyUser = "INSERT INTO company_users (companyID, userID) VALUES (?, ?)";
            pstCompanyUser = con.prepareStatement(sqlCompanyUser);
            pstCompanyUser.setInt(1, companyID);
            pstCompanyUser.setInt(2, userID);
            pstCompanyUser.executeUpdate();

            // 4. Insert vào user_auth
            String hashedPassword = hasPasswordToMD5(password);
            String sqlUserAuth = "INSERT INTO user_auth (userID, auth_provider, password, created_at) VALUES (?, ?, ?, NOW())";
            pstUserAuth = con.prepareStatement(sqlUserAuth);
            pstUserAuth.setInt(1, userID);
            pstUserAuth.setString(2, "local");
            pstUserAuth.setString(3, hashedPassword);
            pstUserAuth.executeUpdate();

            // 5. Gán role employer = 2
            String sqlRole = "INSERT INTO roles (userID, roleNum) VALUES (?, ?)";
            pstRole = con.prepareStatement(sqlRole);
            pstRole.setInt(1, userID);
            pstRole.setInt(2, 2); // giả định roleNum = 2 là employer
            pstRole.executeUpdate();

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (rsUser != null) rsUser.close();
                if (rsCompany != null) rsCompany.close();
                if (pstUser != null) pstUser.close();
                if (pstCompany != null) pstCompany.close();
                if (pstCompanyUser != null) pstCompanyUser.close();
                if (pstUserAuth != null) pstUserAuth.close();
                if (pstRole != null) pstRole.close();
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        CompanyUserDao dao = new CompanyUserDao();
//        System.out.println(dao.insertUser("22","1","vanduc","2222","local","g22"));
//         System.out.println(dao.updateImage(28,"https://moc247.com/wp-content/uploads/2023/12/loa-mat-voi-101-hinh-anh-avatar-meo-cute-dang-yeu-dep-mat_2.jpg"));
        System.out.println(dao.insertUserEmployer("company@gmail.com","mailisa","1","1", "mailisa", "12345678", "quốc lộ 80"));
    }
}


