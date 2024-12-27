package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Category;
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
    private Map<String, List<Category>> categories;
    public CategoryDao() {
    }
    public Map<String, List<Category>> getMapCategories() {
        Connection con = DBconnect.getConnection();
        String sql = "select * from job_categories";
        categories = new HashMap<String, List<Category>>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("categoryID");
                String name = rs.getString("categoryName");
                List<Category> list = getCategories(id);
                categories.put(name, list);
            }
            return  categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Category> getCategories(int id) {
        Connection con = DBconnect.getConnection();
        List<Category> categories = new ArrayList<Category>();
        String sql = "select * from job_post_categories where categoryID = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int jobPostID= rs.getInt("jobPostCategoryID");
                String name = rs.getString("jobPostCategoryName");
                categories.add(new Category(jobPostID, name));
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CategoryDao dao = new CategoryDao();
        Map<String, List<Category>> mapCategories = dao.getMapCategories();
        for(Map.Entry<String, List<Category>> entry : mapCategories.entrySet()) {
            System.out.println(entry.getKey());
            for(Category category : entry.getValue()) {
                System.out.println(category);
            }
        }
    }
}
