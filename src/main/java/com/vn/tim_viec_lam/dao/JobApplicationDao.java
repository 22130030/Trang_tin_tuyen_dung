package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Job;
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
    public boolean addJobApplicationFromAccount(int companyID, int jobPostID,int resumesID,int candidateID) {
        Connection con = DBconnect.getConnection();
        String sql = "insert into job_applications(companyID,jobPostID,resumeID,candidateID,status,created_at) values (?,?,?,?,?,NOW())";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, companyID);
            prep.setInt(2, jobPostID);
            prep.setInt(3, resumesID);
            prep.setInt(4, 1);
            prep.setString(5, "Đã nộp");
            int res = prep.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean addJobAppFromComputer(String path, String fileName,String type,int jobID,int companyID,int candidateId) {
            Connection connection = DBconnect.getConnection();
            String sql = "INSERT INTO resumes (fileCv,title,type) VALUES (?,?,?)";
            try {
                PreparedStatement prep = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                prep.setString(1,path);
                prep.setString(2,fileName);
                prep.setString(3,type);
                int res = prep.executeUpdate();
                if(res > 0){
                    try(ResultSet rs = prep.getGeneratedKeys()){
                        if(rs.next()){
                            int resumeID = rs.getInt(1);
                            return addJobApplicationFromAccount(companyID,jobID,resumeID,candidateId);
                        }
                    }
                }
                return res > 0;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
    public List<JobApplication> getAll() {
        List<JobApplication> jobApplications = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select jal.*,c.companyName,jp.titleJob,jp.image from job_applications jal " +
                " join companies c on jal.companyId = c.companyId" +
                " join job_posting jp on jal.jobPostId = jp.jobPostId";

        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
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
                JobApplication j = new JobApplication(id,companyID,jobPostID,candidateID,resumeID,title,img,companyName,status,createdAt);
                jobApplications.add(j);
            }
            return jobApplications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        JobApplicationDao dao = new JobApplicationDao();
        System.out.println(dao.getAll());
    }
}

