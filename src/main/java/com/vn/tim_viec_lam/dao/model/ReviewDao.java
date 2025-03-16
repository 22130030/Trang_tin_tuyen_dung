package com.vn.tim_viec_lam.dao.model;

import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    public List<Review> getAll(){
        List<Review> reviews = new ArrayList<>();
        Connection connect = DBconnect.getConnection();
        String sql = "SELECT * FROM reviews" +
                " join job_applications ja on ja.applicationID = reviews.applicationID" +
                " join resumes r on ja.resumeID = r.resumeID";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("reviewID");
                int applicationID = resultSet.getInt("applicationID");
                int companyID = resultSet.getInt("companyID");
                String type = resultSet.getString("type");
                String path = resultSet.getString("fileCv");
                String title = resultSet.getString("title");
                String status = resultSet.getString("rating");
                LocalDateTime created = resultSet.getTimestamp("created_at").toLocalDateTime();
                Review r = new Review(id,companyID,applicationID,type,path,title,status,created);
                r.setPhone(resultSet.getString("phone"));
                reviews.add(r);
            }
            return reviews;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Review> getAllReviewByJobId(int jobId) {
        List<Review> reviews = new ArrayList<>();
        Connection connect = DBconnect.getConnection();
        String sql = "SELECT * FROM reviews" +
                " join job_applications ja on ja.applicationID = reviews.applicationID" +
                " join resumes r on ja.resumeID = r.resumeID" +
                " where ja.jobPostID = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,jobId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("reviewID");
                int applicationID = resultSet.getInt("applicationID");
                int companyID = resultSet.getInt("companyID");
                String type = resultSet.getString("type");
                String path = resultSet.getString("fileCv");
                String title = resultSet.getString("title");
                String status = resultSet.getString("rating");
                String phone = resultSet.getString("phone");
                LocalDateTime created = resultSet.getTimestamp("created_at").toLocalDateTime();
                Review r = new Review(id,companyID,applicationID,type,path,title,status,created);
                r.setPhone(phone);
                reviews.add(r);
            }
            return reviews;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
    }

}
