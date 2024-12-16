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
            String sql = "select * from job_posting";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jobs.addAll(getResultSet(rs));
//            jobs = getResultSet(rs);

            return jobs;
        }catch (Exception e) {

        }
        return null;
    }

    public List<Job> get4NewJob() {List<Job> jobs = new ArrayList<Job>();

        try {
            Connection con = DBconnect.getConnection();
            String sql = "select * from job_posting AS jp" +
                    " order by jp.created_at desc" +
                    " limit 4";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jobs.addAll(getResultSet(rs));
            return jobs;
        }catch (Exception e) {

        }
        return null;
    }
    public List<Job> getResultSet(ResultSet rs) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("jobPostID");
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
            Job job = new Job(id,title,img,desc,position,salary,status,requirement);
            jobs.add(job);
        }
        return jobs;
    }

    public static void main(String[] args) {
        JobDao jobDao = new JobDao();
        System.out.println(jobDao.get4NewJob().toString());
    }
}
