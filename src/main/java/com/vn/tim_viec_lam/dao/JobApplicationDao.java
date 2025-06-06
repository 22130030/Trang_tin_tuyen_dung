package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationDao {

    public boolean addJobApplicationFromAccount(int companyID, int jobPostID, int resumesID, int candidateID, String phone) {
        String sql = "insert into job_applications(companyID,jobPostID,resumeID,candidateID,status,created_at) values (?,?,?,?,?,NOW())";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            prep.setInt(1, companyID);
            prep.setInt(2, jobPostID);
            prep.setInt(3, resumesID);
            prep.setInt(4, candidateID);
            prep.setString(5, "Đã nộp");

            int res = prep.executeUpdate();
            if (res > 0) {
                try (ResultSet rs = prep.getGeneratedKeys()) {
                    if (rs.next()) {
                        int applicationId = rs.getInt(1);
                        sql = "insert into reviews(applicationID,companyID,rating,created_at,phone) values (?,?,?,NOW(),?)";
                        try (PreparedStatement prep2 = con.prepareStatement(sql)) {
                            prep2.setInt(1, applicationId);
                            prep2.setInt(2, companyID);
                            prep2.setString(3, "Chưa xem");
                            prep2.setString(4, phone);
                            return prep2.executeUpdate() > 0;
                        }
                    }
                }
            }
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addJobAppFromComputer(String path, String fileName, String type, int jobID, int companyID, int candidateId, String phone) {
        String sql = "INSERT INTO resumes (fileCv,title,type,updated_at,phone) VALUES (?,?,?,NOW(),?)";

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            prep.setString(1, path);
            prep.setString(2, fileName);
            prep.setString(3, type);
            prep.setString(4, phone);

            int res = prep.executeUpdate();
            if (res > 0) {
                try (ResultSet rs = prep.getGeneratedKeys()) {
                    if (rs.next()) {
                        int resumeID = rs.getInt(1);
                        return addJobApplicationFromAccount(companyID, jobID, resumeID, candidateId, phone);
                    }
                }
            }
            return res > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<JobApplication> getAll(int candidateId) {
        List<JobApplication> jobApplications = new ArrayList<>();
        String sql = "select jal.*,c.companyName,jp.titleJob,jp.image from job_applications jal " +
                " join companies c on jal.companyId = c.companyId" +
                " join job_posting jp on jal.jobPostId = jp.jobPostId" +
                " where jal.candidateId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, candidateId);
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("applicationID");
                    int companyID = rs.getInt("companyID");
                    int jobPostID = rs.getInt("jobPostID");
                    int resumeID = rs.getInt("resumeID");
                    int candidateID = rs.getInt("candidateID");
                    String title = rs.getString("titleJob");
                    String img = rs.getString("image");
                    String status = rs.getString("status");
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    String companyName = rs.getString("companyName");
                    JobApplication j = new JobApplication(id, companyID, jobPostID, candidateID, resumeID, title, img, companyName, status, createdAt);
                    jobApplications.add(j);
                }
            }
            return jobApplications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateStatus(String status, int applicationId) {
        String sql = "update job_applications set status = ? where applicationID = ?";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement prep = connection.prepareStatement(sql)) {

            prep.setString(1, status);
            prep.setInt(2, applicationId);
            return prep.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JobApplication getApplication(int applicationId, int companyID) {
        String sql = "select * from job_applications where applicationID = ? and companyID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, applicationId);
            prep.setInt(2, companyID);

            try (ResultSet rs = prep.executeQuery()) {
                JobApplication application = new JobApplication();
                if (rs.next()) {
                    int id = rs.getInt("applicationID");
                    int jobPostID = rs.getInt("jobPostID");
                    int resumeID = rs.getInt("resumeID");
                    int candidateID = rs.getInt("candidateID");
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    application.setId(id);
                    application.setJobID(jobPostID);
                    application.setCompanyId(companyID);
                    application.setUserID(candidateID);
                    application.setResumesID(resumeID);
                }
                return application;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getApplicationByJobIdAndCanId(int jobID, int candidateID) {
        String sql = "select * from job_applications where jobPostId = ? and candidateId = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, jobID);
            prep.setInt(2, candidateID);

            try (ResultSet rs = prep.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getJobApplicationInDay(int candidateId) {
        String sql = "select * from job_applications where candidateId = ? and DATE(created_at) = CURRENT_DATE";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement prep = con.prepareStatement(sql)) {

            prep.setInt(1, candidateId);
            try (ResultSet rs = prep.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}