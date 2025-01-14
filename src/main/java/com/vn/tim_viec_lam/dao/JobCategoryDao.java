package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.JobCategory;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobCategoryDao {
   public List<JobCategory> getListJobCategroy() {
       List<JobCategory> list = new ArrayList<JobCategory>();
       Connection conn = DBconnect.getConnection();
       String sql = "SELECT j.*, jp.jobPostCategoryName\n" +
               "FROM job_categories j\n" +
               "JOIN job_post_categories jp ON j.categoryID = jp.categoryID;\n";
       try {
           PreparedStatement pre = conn.prepareStatement(sql);
           ResultSet rs = pre.executeQuery();
           while (rs.next()) {
               JobCategory jc = executeResult(rs);
               list.add(jc);
           }
           return list;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
    public List<JobCategory> FindListJobCategroy(String jobPostCategoryName) {
        List<JobCategory> list = new ArrayList<JobCategory>();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT j.*, jp.jobPostCategoryName\n" +
                "FROM job_categories j\n" +
                "JOIN job_post_categories jp ON j.categoryID = jp.categoryID " +
                "WHERE jp.jobPostCategoryName LIKE ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + jobPostCategoryName + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                JobCategory jc = executeResult(rs);
                list.add(jc);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JobCategory executeResult(ResultSet rs) throws SQLException {
       JobCategory jc = new JobCategory();
       int id = rs.getInt("categoryID");
       String category = rs.getString("categoryName");
       String categoryjob = rs.getString("jobPostCategoryName");
       jc = new JobCategory(id, category, categoryjob);
       return jc;
    }

    public static void main(String[] args) {
        JobCategoryDao daoc = new JobCategoryDao();
//        List<JobCategory> list = daoc.getListJobCategroy();
//        for (JobCategory jc1 : list) {
//            System.out.println(jc1);
//        }
        System.out.println(daoc.FindListJobCategroy("Lập trình viên Frontend"));
    }
}
