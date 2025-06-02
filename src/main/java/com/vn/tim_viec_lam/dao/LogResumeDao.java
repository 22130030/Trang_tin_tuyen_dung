package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.LogResume;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogResumeDao {
    public List<LogResume> getLogReById(int resmeID) {
        String sql = "select * from resume_views where resumeID=?";
        List<LogResume> resumeList = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, resmeID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LogResume resume = new LogResume();
                    resume.setResumeId(Integer.parseInt(rs.getString("resumeID")));
                    resume.setCompanyName(rs.getString("companyName"));
                    resume.setEmployeeId(Integer.parseInt(rs.getString("employerID")));
                    resume.setViewed_at(rs.getTimestamp("viewed_at").toLocalDateTime());
                    resumeList.add(resume);
                }
            }
            return resumeList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        LogResumeDao dao = new LogResumeDao();
        System.out.println(dao.getLogReById(1));
    }
}