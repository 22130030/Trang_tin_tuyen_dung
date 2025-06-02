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
        List<JobCategory> list = new ArrayList<>();
        String sql = "SELECT jp.*, j.categoryName " +
                "FROM job_post_categories jp " +
                "JOIN job_categories j ON jp.categoryID = j.categoryID";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                JobCategory jc = executeResult(rs);
                list.add(jc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<JobCategory> FindListJobCategroy(String jobPostCategoryName) {
        List<JobCategory> list = new ArrayList<>();
        String sql = "SELECT jp.*, j.categoryName " +
                "FROM job_post_categories jp " +
                "JOIN job_categories j ON jp.categoryID = j.categoryID " +
                "WHERE jp.jobPostCategoryName LIKE ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, "%" + jobPostCategoryName + "%");
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    JobCategory jc = executeResult(rs);
                    list.add(jc);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public JobCategory FindListJobCategroyByID(int jobPostCategoryNameID) {
        JobCategory jc = null;
        String sql = "SELECT jp.*, j.categoryName " +
                "FROM job_post_categories jp " +
                "JOIN job_categories j ON jp.categoryID = j.categoryID " +
                "WHERE jp.jobPostCategoryID = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, jobPostCategoryNameID);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    jc = executeResult(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jc;
    }

    public boolean deleteJobPostCategory(int id) {
        String sql = "DELETE FROM job_post_categories WHERE jobPostCategoryID = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addCategory(String categoryName, String jobPostCategoryName) {
        String sql = "INSERT INTO job_post_categories (categoryID, jobPostCategoryName) " +
                "VALUES ((SELECT categoryID FROM job_categories WHERE categoryName = ?), ?)";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, categoryName);
            pre.setString(2, jobPostCategoryName);
            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private JobCategory executeResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("categoryID");
        String category = rs.getString("categoryName");
        int idjob = rs.getInt("jobPostCategoryID");
        String categoryjob = rs.getString("jobPostCategoryName");
        return new JobCategory(id, category, idjob, categoryjob);
    }

    public void editCategory(int jobPostCategoryID, String categoryName, String jobPostCategoryName) {
        String sql = "UPDATE job_post_categories " +
                "SET jobPostCategoryName = ?, " +
                "    categoryID = (SELECT categoryID FROM job_categories WHERE categoryName = ?) " +
                "WHERE jobPostCategoryID = ?";
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, jobPostCategoryName);
            preparedStatement.setString(2, categoryName);
            preparedStatement.setInt(3, jobPostCategoryID);
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

    // Nếu có hàm này để tạo id duy nhất thì vẫn giữ hoặc sửa lại nếu cần
    private int generateUniqueID() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        JobCategoryDao daoc = new JobCategoryDao();
//        List<JobCategory> list = daoc.getListJobCategroy();
//        for (JobCategory jc1 : list) {
//            System.out.println(jc1);
//        }
        // System.out.println(daoc.FindListJobCategroy("Giáo viên mầm non"));
        // System.out.println(daoc.deleteJobPostCategory(86));

        String categoryName = "IT & Công nghệ";
        String jobPostCategoryName = "Lập trình viên cơ bản";

        // daoc.editCategory(63, categoryName, jobPostCategoryName);
        // System.out.println(daoc.FindListJobCategroyByID(64));
        System.out.println(daoc.addCategory(categoryName, jobPostCategoryName));
    }
}
