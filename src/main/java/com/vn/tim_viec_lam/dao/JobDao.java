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
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID" +
                    " join job_locations as jl on jl.locationID = jp.locationID";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }

            return jobs;
        } catch (Exception e) {

        }
        return null;
    }

    public List<Job> getAllNewJob() {
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID" +
                    " join job_locations as jl on jl.locationID = jp.locationID" +
                    " order by jp.created_at desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (Exception e) {

        }
        return null;

    }

    public List<Job> get4NewJob() {
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID" +
                    " join job_locations as jl on jl.locationID = jp.locationID" +
                    " order by jp.created_at desc" +
                    " limit 4";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (Exception e) {

        }
        return null;

    }

    public Job findById(int id) {
        Job job = new Job();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " where jobPostID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                job = getResultSet(rs);
            }
            return job;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> getJobsByCompanyId(int companyID) {
        List<Job> jobs = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " where jp.companyID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, companyID);
            ResultSet rs = ps.executeQuery();
            Job job = new Job();
            while (rs.next()) {
                job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Job> getJobsByJobPostCategoryId(int categoryID) {
        List<Job> jobs = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " join job_post_categories jpc on jpc.jobPostID = jp.jobPostID" +
                " where jpc.jobPostCategoryID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();
            Job job = new Job();
            while (rs.next()) {
                job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Job> getJobsByCategoryId(int categoryID) {
        List<Job> jobs = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select DISTINCT jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " join job_post_categories jpc on jpc.jobPostID = jp.jobPostID" +
                " where jpc.categoryID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();
            Job job = new Job();
            while (rs.next()) {
                job = getResultSet(rs);
                jobs.add(job);
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
        Connection con = DBconnect.getConnection();
        String sql = "select count(*) from job_posting";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID" +
                    " join job_locations as jl on jl.locationID = jp.locationID" +
                    " LIMIT 12 OFFSET ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (indexPage - 1) * 12);
            ResultSet rs = ps.executeQuery();
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
        List<Job> jobs = new ArrayList<Job>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " where titleJob like ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Job> searchJobEqualsByNamejob(String name) {
        List<Job> jobs = new ArrayList<Job>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID" +
                " where jp.titleJob like ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
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
    public boolean editJobPosting(int cid, String img, String titleJob, String companyName,String city,String salary,String status ) {
        Connection conn = DBconnect.getConnection();
        String sql = "UPDATE job_posting jp" +
                " JOIN job_locations jl ON jp.locationID = jl.locationID" +
                " JOIN companies c ON jp.companyID = c.companyID" +
                " SET jp.image = ?, jp.titleJob = ?, c.companyName = ?, jl.city = ?,jp.salary = ? ,jp.status = ? WHERE  jp.jobPostID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, img);
            pre.setString(2, titleJob);
            pre.setString(3, companyName);
            pre.setString(4, city);
            pre.setString(5, salary);
            pre.setString(6, status);
            pre.setInt(7, cid);
            if(pre.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean addJobPostWithJoin(String img, String titleJob, String companyName, String city, String salary, String status) {
        Connection conn = DBconnect.getConnection();

        int companyID, locationID;

        try {
            // Truy vấn để lấy companyID từ bảng companies
            String companyQuery = "SELECT companyID FROM companies WHERE companyName = ?";
            try (PreparedStatement companyStmt = conn.prepareStatement(companyQuery)) {
                companyStmt.setString(1, companyName);
                ResultSet companyRs = companyStmt.executeQuery();

                if (companyRs.next()) {
                    companyID = companyRs.getInt("companyID");
                } else {
                    throw new SQLException("Không tìm thấy công ty với tên: " + companyName);
                }
            }

            // Truy vấn để lấy locationID từ bảng job_locations
            String locationQuery = "SELECT locationID FROM job_locations WHERE city = ?";
            try (PreparedStatement locationStmt = conn.prepareStatement(locationQuery)) {
                locationStmt.setString(1, city);
                ResultSet locationRs = locationStmt.executeQuery();

                if (locationRs.next()) {
                    locationID = locationRs.getInt("locationID");
                } else {
                    throw new SQLException("Không tìm thấy địa điểm với thành phố: " + city);
                }
            }

            // Chèn dữ liệu vào bảng job_posting
            String insertQuery = "INSERT INTO job_posting (companyID, titleJob, locationID, image, position, salary, status, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, companyID);         // companyID
                insertStmt.setString(2, titleJob);      // titleJob
                insertStmt.setInt(3, locationID);       // locationID
                insertStmt.setString(4, img);           // image
                insertStmt.setString(5, "Unknown");     // position (tạm thời là Unknown nếu không có giá trị)
                insertStmt.setString(6, salary);        // salary
                insertStmt.setString(7, status);        // status

                // Thực thi câu lệnh INSERT
                return insertStmt.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi thêm bài đăng công việc: " + e.getMessage(), e);
        }
    }



    public List<Job> searchJobByAddress(String address) {
        List<Job> jobs = new ArrayList<Job>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID " +
                " where jl.city like ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + address + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Job> searchJobByNameAndAddress(String name,String address) {
        List<Job> jobs = new ArrayList<Job>();
        Connection con = DBconnect.getConnection();
        String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID" +
                " join job_locations as jl on jl.locationID = jp.locationID " +
                " where jl.city like ? and jp.titleJob like ?";

        try {
              PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + address + "%");
            ps.setString(2, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = getResultSet(rs);
                jobs.add(job);
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<String> getAllLocation() {
        List<String> rs = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select jl.city from job_posting jp" +
                "  join job_locations jl on jl.locationID = jp.locationID" +
                " group by jl.city";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                rs.add(resultSet.getString(1));
            }
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Job> filterJobs(int companyID,String jobName,String jobCategory,String jobLocation) {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT jp.*, c.companyName,jl.city FROM job_posting jp " +
                " Join companies c ON jp.companyID = c.companyID " +
                " JOIN job_locations jl ON jl.locationID = jp.locationID " +
                " join job_post_categories jpc on jpc.jobPostID = jp.jobPostID " +
                " Join Job_categories jc on jc.categoryID = jpc.categoryID " +
                " WHERE c.companyID = ?";

        if (jobName != null && !jobName.isEmpty()) {
            query += " AND jp.titleJob LIKE ?";
        }
        if (jobCategory != null && !jobCategory.isEmpty()) {
            query += " AND jc.categoryName LIKE ?";
        }
        if (jobLocation != null && !jobLocation.isEmpty()) {
            query += " AND jl.city like ?";
        }

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            int index = 1;
            statement.setInt(index++, companyID);
            if (jobName != null && !jobName.isEmpty()) {
                statement.setString(index++, "%" + jobName + "%");
            }
            if (jobCategory != null && !jobCategory.isEmpty()) {
                statement.setString(index++, "%" + jobCategory + "%");
            }
            if (jobLocation != null && !jobLocation.isEmpty()) {
                statement.setString(index++, "%" + jobLocation + "%");
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                jobs.add(getResultSet(resultSet));
            }
            return jobs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        public boolean addJobPosting(int companyId,String companyName,String employerSize,String website,String jobName,String jobAddress
            ,String salaryValue,String salaryUnit,String educationLevel,String experienceLevel,String jobType,String jobLocation,
                                 String jobCategory,String keywords,String age,String contactName
            ,String contactEmail,String contactPhone,String contactAddress ,String jobPostingDate,String JobExpiryDate,String language){
        Connection con = DBconnect.getConnection();
        String sqlLocation = "INSERT INTO job_locations (address, country, city) VALUES (?, ?, ?)";
        try (PreparedStatement stmtLocation = con.prepareStatement(sqlLocation, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmtLocation.setString(1, jobAddress);
            stmtLocation.setString(2, "VietNam");
            stmtLocation.setString(3, jobLocation);
            int rowsAffected = stmtLocation.executeUpdate();
            if(rowsAffected >0){
                try (ResultSet generatedKeys = stmtLocation.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int locationID = generatedKeys.getInt(1);  // Lấy locationID
                        // Tiến hành thêm dữ liệu vào bảng job_posting
                        String sqlJobPosting = "INSERT INTO job_posting (companyID, titleJob, locationID, image, position, jobdescription, salary, created_at, updated_at, status, requirement) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?, ?)";
                        try (PreparedStatement stmtJobPosting = con.prepareStatement(sqlJobPosting)) {
                            stmtJobPosting.setInt(1, companyId);  // companyID, giả sử là 1 (có thể lấy từ form)
                            stmtJobPosting.setString(2, jobName);
                            stmtJobPosting.setInt(3, locationID);  // Sử dụng locationID vừa lấy
                            stmtJobPosting.setString(4, ""); // Image, có thể lấy từ form nếu cần
                            stmtJobPosting.setString(5, "Full-time"); // Position, có thể lấy từ form
                            stmtJobPosting.setString(6, "Mô tả công việc tại đây"); // Job description
                            stmtJobPosting.setString(7, salaryValue);  // Salary
                            stmtJobPosting.setString(8, "active");  // Status
                            stmtJobPosting.setString(9, "Yêu cầu công việc tại đây");
                            int jobPostingRowsAffected = stmtJobPosting.executeUpdate();
                            if (jobPostingRowsAffected > 0) {
                                System.out.println("Job posting added successfully.");
                                return true;
                            } else {
                                System.out.println("Failed to add job posting.");
                            }
                        }
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace(); // In chi tiết lỗi để biết nguyên nhân
            System.out.println("Error executing update: " + e.getMessage());
        }
        return false;
    }}

