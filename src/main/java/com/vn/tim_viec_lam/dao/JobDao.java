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
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName,jl.city from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID"+
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
                    " join job_locations as jl on jl.locationID = jp.locationID"+
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
                    " join job_locations as jl on jl.locationID = jp.locationID"+
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
        job = new Job(id, companyId, companyName, title, img, desc, position, salary, created, status, requirement,city);
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
                    " join job_locations as jl on jl.locationID = jp.locationID"+
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
                " join job_locations as jl on jl.locationID = jp.locationID"+
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
    public List<Job> filterJobs(String jobName,String jobCategory,String jobLocation) {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT jp.*, c.companyName,jl.city FROM job_posting jp" +
                " Join companies c ON jp.companyID = c.companyID" +
                " JOIN job_locations jl ON jl.locationID = jp.locationID" +
                " join job_post_categories jpc on jpc.jobPostID = jp.jobPostID" +
                " Join Job_categories jc on jc.categoryID = jpc.categoryID" +
                " WHERE 1=1";

        if (jobName != null && !jobName.isEmpty()) {
            query += " AND jp.titleJob like ?";
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
            if (jobName != null && !jobName.isEmpty()) {
                statement.setString(index++, "%"+jobName+"%");
            }
            if (jobCategory != null && !jobCategory.isEmpty()) {
                statement.setString(index++, "%" + jobCategory + "%");
            }
            if (jobLocation != null && !jobLocation.isEmpty()) {
                statement.setString(index++, "%"+jobLocation+"%");
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Job job = getResultSet(resultSet);
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
    public boolean addJobPosting(){
        return false;
    }
    public static void main(String[] args) {
        JobDao jobDao = new JobDao();
        System.out.println(jobDao.filterJobs("Nhân viên","Công nghệ thông tin","Hải Phòng"));

    }
}
