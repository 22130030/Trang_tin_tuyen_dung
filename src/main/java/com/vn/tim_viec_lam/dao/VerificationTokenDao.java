package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificationTokenDao {
    public int addToken(String email,String token) {
        Connection connnect = DBconnect.getConnection();
        String sql = "insert into verify_tokens(email,token,created_at) values(?,?,NOW())";
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
    public String getToken(int id) {
        Connection connnect = DBconnect.getConnection();
        String sql = "select token from verify_tokens where id=?";
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
