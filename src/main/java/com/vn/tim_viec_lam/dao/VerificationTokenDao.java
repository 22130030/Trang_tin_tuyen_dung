package com.vn.tim_viec_lam.dao;


import com.vn.tim_viec_lam.database.DBconnect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VerificationTokenDao {
    public int addToken(String email,String token) {
        Connection connnect = DBconnect.getConnection();
        String sql = "insert into verify_tokens(email,token,created_at,expires_at) values(?,?,NOW(), DATE_ADD(NOW(), INTERVAL 3 MINUTE))";
        try {
            PreparedStatement prep = connnect.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1, email);
            prep.setString(2, token);
            prep.executeUpdate();
            ResultSet rs = prep.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailByToken(String token) {
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT email FROM verify_tokens WHERE token=? AND created_at < expires_at";
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, token);
            ResultSet rs = prep.executeQuery();
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteToken(String token) {
        Connection conn = DBconnect.getConnection();
        String sql = "DELETE FROM verify_tokens WHERE token=?";
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, token);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isTokenValid(String token) {
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT COUNT(*) FROM verify_tokens WHERE token = ? AND NOW() < expires_at";
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, token);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu có token hợp lệ thì trả về true
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false; // Token không hợp lệ hoặc đã hết hạn
    }
    public String getToken(int id) {
        Connection connnect = DBconnect.getConnection();
        String sql = "select token from verify_tokens where id=? and created_at < expires_at";
        try {
            PreparedStatement prep = connnect.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();


            return rs.next() ? rs.getString(1) : "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        VerificationTokenDao verificationTokenDao = new VerificationTokenDao();
        System.out.println(verificationTokenDao.addToken("admin@gmail.com","123456"));
    }
}

