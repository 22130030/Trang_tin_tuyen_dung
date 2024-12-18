package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select jp.*,c.companyName from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID";
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
            String sql = "select jp.*,c.companyName from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID"+
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
        String sql = "select jp.*,c.companyName from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID"+
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
        String sql = "select jp.*,c.companyName from job_posting as jp" +
                " join companies as c on c.companyID = jp.companyID"+
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
//                LocalDateTime created = rs.getTimestamp("created_at").toLocalDateTime();
//                LocalDateTime updated = rs.getTimestamp("created_at").toLocalDateTime();
        String status = rs.getString("status");
        String requirement = rs.getString("requirement");
//
        job = new Job(id,companyId,companyName, title, img, desc, position, salary, status, requirement);
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
            String sql = "select jp.*,c.companyName from job_posting as jp" +
                    " join companies as c on c.companyID = jp.companyID"+
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
    public static void main(String[] args) {
        JobDao jobDao = new JobDao();
        System.out.println(jobDao.getJobsByCompanyId(1).toString());
    }

}
