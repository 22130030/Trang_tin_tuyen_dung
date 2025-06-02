package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {
    private Map<JobPostCategory, List<Category>> categories;
    public CategoryDao() {
    }

    public int getNumberPage() {
        String sql = "select count(*) from job_categories";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total % 6 > 0 ? total / 6 + 1 : total / 6;
                return countPage;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public List<JobPostCategory> getAllCategories() {
        List<JobPostCategory> categoryList = new ArrayList<>();
        String sql = "select * from job_categories";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String img = rs.getString(3);
                JobPostCategory category = new JobPostCategory(id, name, img);
                categoryList.add(category);
            }
            return categoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<JobPostCategory> getPaging(int indexPage) {
        List<JobPostCategory> categoryList = new ArrayList<>();
        String sql = "select * from job_categories LIMIT 6 OFFSET ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, (indexPage - 1) * 6);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String img = rs.getString(3);
                    JobPostCategory category = new JobPostCategory(id, name, img);
                    categoryList.add(category);
                }
            }
            return categoryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<JobPostCategory, List<Category>> getMapCategories() {
        String sql = "select * from job_categories";
        categories = new HashMap<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("categoryID");
                String name = rs.getString("categoryName");
                String img = rs.getString("img");
                List<Category> list = getCategories(id);
                categories.put(new JobPostCategory(id, name, img), list);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getCategories(int id) {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from job_post_categories where categoryID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int jobPostID = rs.getInt("jobPostCategoryID");
                    String name = rs.getString("jobPostCategoryName");
                    categories.add(new Category(jobPostID, name));
                }
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CategoryDao dao = new CategoryDao();
    }
}
