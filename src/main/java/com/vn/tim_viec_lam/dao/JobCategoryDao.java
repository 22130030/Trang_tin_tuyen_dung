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
       String sql = "SELECT jp.*, j.categoryName\n" +
               "FROM job_post_categories jp\n" +
               "JOIN job_categories j ON jp.categoryID = j.categoryID;\n";
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
        String sql = "SELECT jp.*, j.categoryName " +
                "FROM job_post_categories jp " +
                "JOIN job_categories j ON jp.categoryID = j.categoryID " +
                "WHERE jp.jobPostCategoryName LIKE ?;";
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
    public JobCategory FindListJobCategroyByID(int jobPostCategoryNameID) {
        JobCategory jc = new JobCategory();
        Connection conn = DBconnect.getConnection();
        String sql = "SELECT jp.*, j.categoryName " +
                "FROM job_post_categories jp " +
                "JOIN job_categories j ON jp.categoryID = j.categoryID " +
                "WHERE jp.jobPostCategoryID = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,  jobPostCategoryNameID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                jc = executeResult(rs);
            }
            return jc;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteJobPostCategory(int id) {
       Connection conn = DBconnect.getConnection();
       String sql = "DELETE FROM job_post_categories\n" +
               "WHERE jobPostCategoryID = ?;\n";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            if(pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean addCategory(String categoryName, String jobPostCategoryName) {
        String sql = "INSERT INTO job_post_categories (categoryID, jobPostCategoryName) " +
                "VALUES ((SELECT categoryID FROM job_categories WHERE categoryName = ?), ?)";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            // Thiết lập tham số cho câu truy vấn
            pre.setString(1, categoryName); // Tên phân loại
            pre.setString(2, jobPostCategoryName); // Tên ngành nghề

            // Thực thi câu lệnh
            int rowsAffected = pre.executeUpdate();

            // Kiểm tra nếu có ít nhất một dòng được chèn
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Hàm sinh giá trị duy nhất cho jobPostID
    private int generateUniqueID() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }



    private JobCategory executeResult(ResultSet rs) throws SQLException {
       JobCategory jc = new JobCategory();
       int id = rs.getInt("categoryID");
       String category = rs.getString("categoryName");
       int idjob = rs.getInt("jobPostCategoryID");
       String categoryjob = rs.getString("jobPostCategoryName");
       jc = new JobCategory(id, category,idjob, categoryjob);
       return jc;
    }
    public void editCategory(int jobPostCategoryID, String categoryName, String jobPostCategoryName) {
        // SQL query to update the job_post_categories table
        String sql = "UPDATE job_post_categories " +
                "SET jobPostCategoryName = ?, " +
                "    categoryID = (SELECT categoryID FROM job_categories WHERE categoryName = ?) " +
                "WHERE jobPostCategoryID = ?";

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameters for the query
            preparedStatement.setString(1, jobPostCategoryName);
            preparedStatement.setString(2, categoryName);
            preparedStatement.setInt(3, jobPostCategoryID);

            // Execute the update
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Category updated successfully.");
            } else {
                System.out.println("No category found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        JobCategoryDao daoc = new JobCategoryDao();
//        List<JobCategory> list = daoc.getListJobCategroy();
//        for (JobCategory jc1 : list) {
//            System.out.println(jc1);
//        }
       // System.out.println(daoc.FindListJobCategroy("Giáo viên mầm non"));
       //System.out.println(daoc.deleteJobPostCategory(86));

       String categoryName = "IT & Công nghệ";
//
//        int jobPostCategoryID = 63;
      String jobPostCategoryName = "Lập trình viên cơ bản";
//        daoc.editCategory(jobPostCategoryID,categoryName,jobPostCategoryName);
      //  System.out.println(daoc.FindListJobCategroyByID(64));
        System.out.println(daoc.addCategory(categoryName,jobPostCategoryName));
    }
}
