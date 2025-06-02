package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.JobCategoryCount;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobPostCategoryDAO {
    public List<JobCategoryCount> getJobCategoryCounts() {
        String sql = "SELECT jc.categoryID, jc.categoryName, jc.img, COUNT(jp.jobPostID) AS jobCount " +
                "FROM job_categories jc " +
                "LEFT JOIN job_post_categories jpc ON jc.categoryID = jpc.categoryID " +
                "LEFT JOIN job_posting jp ON jpc.jobPostID = jp.jobPostID " +
                "GROUP BY jc.categoryID, jc.categoryName, jc.img " +
                "ORDER BY jc.categoryID";
        List<JobCategoryCount> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("categoryID");
                String name = rs.getString("categoryName");
                String img = rs.getString("img");
                int count = rs.getInt("jobCount");
                list.add(new JobCategoryCount(id, name, img, count));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<JobCategoryCount> getCategoriesByPage(int pageIndex) {
        int pageSize = 6;
        int offset = (pageIndex - 1) * pageSize;
        String sql = "SELECT jc.categoryID, jc.categoryName, jc.img, COUNT(jp.jobPostID) AS jobCount " +
                "FROM job_categories jc " +
                "LEFT JOIN job_post_categories jpc ON jc.categoryID = jpc.categoryID " +
                "LEFT JOIN job_posting jp ON jpc.jobPostID = jp.jobPostID " +
                "GROUP BY jc.categoryID, jc.categoryName, jc.img " +
                "ORDER BY jc.categoryID " +
                "LIMIT ? OFFSET ?";
        List<JobCategoryCount> list = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("categoryID");
                    String name = rs.getString("categoryName");
                    String img = rs.getString("img");
                    int count = rs.getInt("jobCount");
                    list.add(new JobCategoryCount(id, name, img, count));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public int getNumberPage() {
        String sql = "SELECT COUNT(*) FROM job_categories";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int total = rs.getInt(1);
                int pageSize = 6;
                // Nếu chia lẻ thì cộng thêm 1 trang cuối
                return (total + pageSize - 1) / pageSize;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }


    public static void main(String[] args) {
        JobPostCategoryDAO dao = new JobPostCategoryDAO();
        List<JobCategoryCount> results = dao.getJobCategoryCounts();
        for (JobCategoryCount c : results) {
            System.out.println(c); // hoặc dùng getter để in cụ thể từng trường
        }
    }
}
