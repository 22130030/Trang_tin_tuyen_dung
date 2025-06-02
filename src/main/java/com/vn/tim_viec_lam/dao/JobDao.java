package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobDao {
    private int locationID;

    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();

        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Job> getAllNewJob() {
        List<Job> jobs = new ArrayList<>();

        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "order by jp.created_at desc";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Job> get4NewJob() {
        List<Job> jobs = new ArrayList<>();

        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "order by jp.created_at desc " +
                "limit 4";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Job findById(int id) {
        Job job = null;
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "where jobPostID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    job = getResultSet(rs);
                }
            }
            return job;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> getJobsByCompanyId(int companyID) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "where jp.companyID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, companyID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> getJobsByJobPostCategoryId(int categoryID) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "join job_post_categories jpc on jpc.jobPostID = jp.jobPostID " +
                "where jpc.jobPostCategoryID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, categoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> getJobsByCategoryId(int categoryID) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select DISTINCT jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "join job_post_categories jpc on jpc.jobPostID = jp.jobPostID " +
                "where jpc.categoryID = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, categoryID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Job getResultSet(ResultSet rs) throws SQLException {
        Job job = new Job();
        int id = rs.getInt("jobPostID");
        int companyId = rs.getInt("companyID");
        String companyName = rs.getString("companyName");
        String title = rs.getString("titleJob");
        String img = rs.getString("image");
        String position = rs.getString("position");
        String desc = rs.getString("jobDescription");
        String salary = rs.getString("salary");
        LocalDateTime created = rs.getTimestamp("created_at").toLocalDateTime();
//                LocalDateTime updated = rs.getTimestamp("updated_at").toLocalDateTime();
        String status = rs.getString("status");
        String requirement = rs.getString("requirement");
        String city = rs.getString("city");
//
        job = new Job(id, companyId, companyName, title, img, desc, position, salary, created, status, requirement, city);
        return job;
    }

    public int getNumberPage() {
        String sql = "select count(*) from job_posting";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int total = rs.getInt(1);
                int countPage = total % 12 > 0 ? total / 12 + 1 : total / 12;
                return countPage;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public List<Job> getPaging(int indexPage) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "LIMIT 12 OFFSET ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, (indexPage - 1) * 12);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int findCompanyIDByJobID(int jobID) {
        Connection con = DBconnect.getConnection();
        String sql = "select companyID from job_posting where jobPostID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobID);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getInt(1) : -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> searchEqualsByName(String name) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "where titleJob like ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> searchJobEqualsByNamejob(String name) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp " +
                "join companies as c on c.companyID = jp.companyID " +
                "join job_locations as jl on jl.locationID = jp.locationID " +
                "where jp.titleJob like ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteJobPosting(int id) {
        Connection con = DBconnect.getConnection();
        try {
            con.setAutoCommit(false); // Bắt đầu transaction

            // 1. Xóa dữ liệu trong bảng job_locations
            String deleteLocationsSQL = "DELETE FROM job_locations WHERE locationID IN " +
                    "(SELECT locationID FROM job_posting WHERE jobPostID = ?)";
            PreparedStatement ps1 = con.prepareStatement(deleteLocationsSQL);
            ps1.setInt(1, id);
            ps1.executeUpdate();

            // 2. Xóa dữ liệu trong bảng job_post_categories
            String deleteCategoriesSQL = "DELETE FROM job_post_categories WHERE jobPostID = ?";
            PreparedStatement ps2 = con.prepareStatement(deleteCategoriesSQL);
            ps2.setInt(1, id);
            ps2.executeUpdate();

            // 3. Xóa dữ liệu trong bảng chính job_posting
            String deleteJobSQL = "DELETE FROM job_posting WHERE jobPostID = ?";
            PreparedStatement ps3 = con.prepareStatement(deleteJobSQL);
            ps3.setInt(1, id);
            ps3.executeUpdate();

            con.commit(); // Commit transaction nếu mọi thứ thành công
        } catch (SQLException e) {
            try {
                con.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
    public boolean editJobPosting(int cid, String img, String titleJob, String companyName, String city, String salary, String status) {
        String sql = "UPDATE job_posting jp " +
                "JOIN job_locations jl ON jp.locationID = jl.locationID " +
                "JOIN companies c ON jp.companyID = c.companyID " +
                "SET jp.image = ?, jp.titleJob = ?, c.companyName = ?, jl.city = ?, jp.salary = ?, jp.status = ? " +
                "WHERE jp.jobPostID = ?";

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, img);
            pre.setString(2, titleJob);
            pre.setString(3, companyName);
            pre.setString(4, city);
            pre.setString(5, salary);
            pre.setString(6, status);
            pre.setInt(7, cid);

            return pre.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addJobPostWithJoin(String img, String titleJob, String companyName, String city, String salary, String status) {
        int companyID, locationID;

        // Tự động đóng Connection
        try (Connection conn = DBconnect.getConnection()) {

            // Truy vấn để lấy companyID từ bảng companies
            String companyQuery = "SELECT companyID FROM companies WHERE companyName = ?";
            try (PreparedStatement companyStmt = conn.prepareStatement(companyQuery)) {
                companyStmt.setString(1, companyName);
                try (ResultSet companyRs = companyStmt.executeQuery()) {
                    if (companyRs.next()) {
                        companyID = companyRs.getInt("companyID");
                    } else {
                        throw new SQLException("Không tìm thấy công ty với tên: " + companyName);
                    }
                }
            }

            // Truy vấn để lấy locationID từ bảng job_locations
            String locationQuery = "SELECT locationID FROM job_locations WHERE city = ?";
            try (PreparedStatement locationStmt = conn.prepareStatement(locationQuery)) {
                locationStmt.setString(1, city);
                try (ResultSet locationRs = locationStmt.executeQuery()) {
                    if (locationRs.next()) {
                        locationID = locationRs.getInt("locationID");
                    } else {
                        throw new SQLException("Không tìm thấy địa điểm với thành phố: " + city);
                    }
                }
            }

            // Chèn dữ liệu vào bảng job_posting
            String insertQuery = "INSERT INTO job_posting (companyID, titleJob, locationID, image, position, salary, status, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, companyID);         // companyID
                insertStmt.setString(2, titleJob);       // titleJob
                insertStmt.setInt(3, locationID);        // locationID
                insertStmt.setString(4, img);            // image
                insertStmt.setString(5, "Unknown");      // position (tạm thời là Unknown)
                insertStmt.setString(6, salary);         // salary
                insertStmt.setString(7, status);         // status

                return insertStmt.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi thêm bài đăng công việc: " + e.getMessage(), e);
        }
    }



    public List<Job> searchJobByAddress(String address) {
        List<Job> jobs = new ArrayList<>();

        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " where jl.city like ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + address + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jobs;
    }

    public List<Job> searchJobByNameAndAddress(String name, String address) {
        List<Job> jobs = new ArrayList<>();

        String sql = "select jp.*, c.companyName, jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID " +
                " where jl.city like ? and jp.titleJob like ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + address + "%");
            ps.setString(2, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Job job = getResultSet(rs);
                    jobs.add(job);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jobs;
    }
    public List<String> getAllLocation() {
        List<String> locations = new ArrayList<>();
        String sql = "select jl.city from job_posting jp" +
                " join job_locations jl on jl.locationID = jp.locationID" +
                " group by jl.city";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                locations.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return locations;
    }
    public List<Job> filterJobs(int companyID, String jobName, String jobCategory, String jobLocation) {
        List<Job> jobs = new ArrayList<>();
        StringBuilder query = new StringBuilder(
                "SELECT jp.*, c.companyName, jl.city FROM job_posting jp " +
                        "JOIN companies c ON jp.companyID = c.companyID " +
                        "JOIN job_locations jl ON jl.locationID = jp.locationID " +
                        "JOIN job_post_categories jpc ON jpc.jobPostID = jp.jobPostID " +
                        "JOIN job_categories jc ON jc.categoryID = jpc.categoryID " +
                        "WHERE c.companyID = ?"
        );

        if (jobName != null && !jobName.isEmpty()) {
            query.append(" AND jp.titleJob LIKE ?");
        }
        if (jobCategory != null && !jobCategory.isEmpty()) {
            query.append(" AND jc.categoryName LIKE ?");
        }
        if (jobLocation != null && !jobLocation.isEmpty()) {
            query.append(" AND jl.city LIKE ?");
        }

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query.toString())) {

            int paramIndex = 1;
            stmt.setInt(paramIndex++, companyID);

            if (jobName != null && !jobName.isEmpty()) {
                stmt.setString(paramIndex++, "%" + jobName + "%");
            }
            if (jobCategory != null && !jobCategory.isEmpty()) {
                stmt.setString(paramIndex++, "%" + jobCategory + "%");
            }
            if (jobLocation != null && !jobLocation.isEmpty()) {
                stmt.setString(paramIndex++, "%" + jobLocation + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    jobs.add(getResultSet(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi lọc công việc: " + e.getMessage(), e);
        }

        return jobs;
    }
    public boolean addJobPosting(int companyId,String companyName,String employerSize,String website,String jobName,String jobAddress,
                                 String salaryValue,String salaryUnit,String educationLevel,String experienceLevel,String jobType,String jobLocation,
                                 String jobCategory,String keywords,String age,String contactName,
                                 String contactEmail,String contactPhone,String contactAddress ,String jobPostingDate,String JobExpiryDate,String language){
        // Sử dụng try-with-resources để tự động đóng Connection
        try (Connection con = DBconnect.getConnection()) {
            con.setAutoCommit(false); // bắt đầu transaction

            String sqlLocation = "INSERT INTO job_locations (address, country, city) VALUES (?, ?, ?)";
            try (PreparedStatement stmtLocation = con.prepareStatement(sqlLocation, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmtLocation.setString(1, jobAddress);
                stmtLocation.setString(2, "VietNam");
                stmtLocation.setString(3, jobLocation);

                int rowsAffected = stmtLocation.executeUpdate();
                if(rowsAffected > 0){
                    try (ResultSet generatedKeys = stmtLocation.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int locationID = generatedKeys.getInt(1);  // Lấy locationID

                            String sqlJobPosting = "INSERT INTO job_posting (companyID, titleJob, locationID, image, position, jobdescription, salary, created_at, updated_at, status, requirement) "
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?, ?)";
                            try (PreparedStatement stmtJobPosting = con.prepareStatement(sqlJobPosting)) {
                                stmtJobPosting.setInt(1, companyId);
                                stmtJobPosting.setString(2, jobName);
                                stmtJobPosting.setInt(3, locationID);
                                stmtJobPosting.setString(4, ""); // Image, có thể lấy từ form nếu cần
                                stmtJobPosting.setString(5, "Full-time"); // Position, có thể lấy từ form
                                stmtJobPosting.setString(6, "Mô tả công việc tại đây");
                                stmtJobPosting.setString(7, salaryValue);
                                stmtJobPosting.setString(8, "active");
                                stmtJobPosting.setString(9, "Yêu cầu công việc tại đây");

                                int jobPostingRowsAffected = stmtJobPosting.executeUpdate();
                                if (jobPostingRowsAffected > 0) {
                                    con.commit(); // commit transaction
                                    System.out.println("Job posting added successfully.");
                                    return true;
                                } else {
                                    con.rollback();
                                    System.out.println("Failed to add job posting.");
                                }
                            }
                        } else {
                            con.rollback();
                            throw new SQLException("Không lấy được locationID.");
                        }
                    }
                } else {
                    con.rollback();
                    System.out.println("Failed to add job location.");
                }
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error executing update: " + e.getMessage());
        }
        return false;
    }

}