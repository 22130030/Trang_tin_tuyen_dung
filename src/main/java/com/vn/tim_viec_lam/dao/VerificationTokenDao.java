package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificationTokenDao {

    public int addToken(String email, String token) {
        String sql = "insert into verify_tokens(email, token, created_at, expires_at) values (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 3 MINUTE))";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            prep.setString(1, email);
            prep.setString(2, token);
            prep.executeUpdate();

            try (ResultSet rs = prep.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1; // Nếu không lấy được key
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailByToken(String token) {
        String sql = "SELECT email FROM verify_tokens WHERE token = ? AND created_at < expires_at";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, token);
            try (ResultSet rs = prep.executeQuery()) {
                return rs.next() ? rs.getString("email") : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteToken(String token) {
        String sql = "DELETE FROM verify_tokens WHERE token = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, token);
            prep.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTokenValid(String token) {
        String sql = "SELECT COUNT(*) FROM verify_tokens WHERE token = ? AND NOW() < expires_at";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setString(1, token);
            try (ResultSet rs = prep.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken(int id) {
        String sql = "SELECT token FROM verify_tokens WHERE id = ? AND created_at < expires_at";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql)) {

            prep.setInt(1, id);
            try (ResultSet rs = prep.executeQuery()) {
                return rs.next() ? rs.getString("token") : "";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        VerificationTokenDao verificationTokenDao = new VerificationTokenDao();
        System.out.println(verificationTokenDao.addToken("admin@gmail.com", "123456"));
    }
}
