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
        String sql = "SELECT c.jobPostCategoryID, c.jobPostCategoryName, COUNT(j.jobPostID) AS jobCount " +
                "FROM job_post_categories c " +
                "LEFT JOIN job_posting j ON c.jobPostCategoryID = j.jobPostCategoryID " +
                "GROUP BY c.jobPostCategoryID, c.jobPostCategoryName";
        List<JobCategoryCount> result = new ArrayList<>();

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("jobPostCategoryID");
                String name = rs.getString("jobPostCategoryName");
                int count = rs.getInt("jobCount");

                JobCategoryCount item = new JobCategoryCount(id, name, count);
                result.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
