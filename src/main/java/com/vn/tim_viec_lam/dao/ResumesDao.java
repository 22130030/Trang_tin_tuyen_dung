package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResumesDao {
    public ResumesDao() {
    }
    public boolean updateProfile(int resumesId,String title,int birthYear,String marital,String address,String education,
                                 String schoolName,String salary,String career,String gender){
        Connection connection = DBconnect.getConnection();

        String sql = "UPDATE resumes " +
                "SET title = ?, " +
                "birthYear = ?, " +
                "marital = ?, " +
                "address = ?, " +
                "education = ?, " +
                "schoolName = ?, " +
                "salary = ?, " +
                "career = ?, " +
                "gender = ?, " +
                "status = 1, " +
                "updated_at = NOW() " +
                "WHERE resumeID = ?";
        int index = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(++index, title);
            ps.setInt(++index, birthYear);
            ps.setString(++index, marital);
            ps.setString(++index,address);
            ps.setString(++index, education);
            ps.setString(++index, schoolName);
            ps.setString(++index, salary);
            ps.setString(++index, career);
            ps.setString(++index, gender);
            ps.setInt(++index, resumesId);
            index = ps.executeUpdate();
            if(index > 0) return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public int addResume(String fileName,String path,String type){
        Connection connection = DBconnect.getConnection();
        String sql = "INSERT INTO resumes (fileCv,title,type,updated_at) VALUES (?,?,?,NOW())";
        try {
            PreparedStatement prep = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setString(1,path);
            prep.setString(2,fileName);
            prep.setString(3,type);
            int res = prep.executeUpdate();
            int resumeID = 0;
            if(res > 0){
                try(ResultSet rs = prep.getGeneratedKeys()){
                    if(rs.next()){
                        resumeID = rs.getInt(1);
                        return resumeID;
                    }
                }
            }
            return resumeID;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Resumes> findReByTitleOrAddress(String title, String address){
        Connection con = DBconnect.getConnection();
        List<Resumes> resumes = new ArrayList<>();
        String sql = "select * from resumes where 1=1";
        if(title != null && !title.isBlank()) sql  += " and title like ?";
        if(address != null && !address.isBlank()) sql += " and address like ?";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            int index = 0;
            if(title != null && !title.isBlank()) prep.setString(++index,"%"+title+"%");
            if(address != null && !address.isBlank()) prep.setString(++index,"%" + address + "%");
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                resumes.add(excute(rs));
            }
            return resumes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Resumes> getResumes(){
        Connection con = DBconnect.getConnection();
        String sql = "select * from resumes";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            List<Resumes> resumes = new ArrayList<>();
            while(rs.next()){
                resumes.add(excute(rs));
            }
            return resumes;
        } catch (SQLException e) {

        }
        return null;
    }
    public boolean removeResumes(int id){
        Connection con = DBconnect.getConnection();
        String sql = "delete from resumes where resumeID = ?";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1,id);
            int res = prep.executeUpdate();
            return res > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Resumes excute(ResultSet rs) throws SQLException {
        int resumeID = rs.getInt("resumeID");
        String title = rs.getString("title");
        int birthYear = rs.getInt("birthYear");
        String marital = rs.getString("marital");
        String address = rs.getString("address");
        String education = rs.getString("education");
        String schoolName = rs.getString("schoolName");
        String salary = rs.getString("salary");
        String career = rs.getString("career");
        int status = rs.getInt("status");
        LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
        Resumes resumes = new Resumes();
        resumes.setId(resumeID);
        resumes.setTitle(title);
        resumes.setBirthYear(birthYear);
        resumes.setMarital(marital);
        resumes.setAddress(address);
        resumes.setEducation(education);
        resumes.setSchoolName(schoolName);
        resumes.setSalary(salary);
        resumes.setCareer(career);
        resumes.setGender(rs.getString("gender"));
        resumes.setStatus(status);
        resumes.setUpdated(updatedAt);
        return resumes;
    }


    public List<Resumes> getAll() {
        List<Resumes> res = new ArrayList<>();
        Connection con = DBconnect.getConnection();

        String sql = "select * from resumes";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int resumeID = rs.getInt("resumeID");
                int candidateID = rs.getInt("candidateID");
                String fileCv = rs.getString("fileCv");
                String title = rs.getString("title");
                int birthYear = rs.getInt("birthYear");
                String marital = rs.getString("marital");
                String address = rs.getString("address");
                String education = rs.getString("education");
                String schoolName = rs.getString("schoolName");
                String salary = rs.getString("salary");
                String career = rs.getString("career");
                String gender = rs.getString("gender");
                int status = rs.getInt("status");
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                Resumes resumes = new Resumes(resumeID,candidateID,fileCv,title,"",birthYear,marital
                ,address,education,schoolName,salary,career,gender);
                resumes.setStatus(status);
                resumes.setUpdated(updatedAt);
                res.add(resumes);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Resumes> getResumesByJobID(int jobID) {
        List<Resumes> res = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from resumes r " +
                " join job_applications ja on ja.resumeID = r.resumeID" +
                " where ja.jobPostId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int resumeID = rs.getInt("resumeID");
                int candidateID = rs.getInt("candidateID");
                String fileCv = rs.getString("fileCv");
                String type = rs.getString("type");
                String title = rs.getString("title");
                int status = rs.getInt("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                Resumes r = new Resumes();
                r.setId(resumeID);
                r.setCandidateId(candidateID);
                r.setPath(fileCv);
                r.setType(type);
                r.setTitle(title);
                r.setStatus(status);
                r.setCreated(created_at);
                res.add(r);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ResumesDao dao = new ResumesDao();
        System.out.println(dao.getAll());
    }
}
