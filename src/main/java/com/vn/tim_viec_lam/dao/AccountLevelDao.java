package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.AccountLevel;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountLevelDao {
    public AccountLevel getLimitByStatus(int status) {
        String sql = "select * from account_levels where status=?";
        AccountLevel accountLevel = new AccountLevel();

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, status);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int resumeLimit = rs.getInt("resume_limit");
                    int applicationLimit = rs.getInt("job_application_limit");
                    accountLevel.setResumeLimit(resumeLimit);
                    accountLevel.setApplicationLimit(applicationLimit);
                }
            }
            return accountLevel;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}