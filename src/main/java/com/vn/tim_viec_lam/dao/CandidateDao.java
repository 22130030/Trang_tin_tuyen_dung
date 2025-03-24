package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class CandidateDao {
    public List<Candidate> getListCandidate()  {
        List<Candidate> listCandidate = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "SELECT " +
                "c.*, " +
                "j.status AS application_status, " +
                "j.created_at AS application_date, " +
                "co.companyName AS company_name " +
                "FROM candidates c " +
                "JOIN job_applications j ON c.candidateID = j.candidateID " +
                "JOIN job_posting jp ON j.jobPostID = jp.jobPostID " +
                "JOIN companies co ON jp.companyID = co.companyID";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Candidate c = executeResult(rs);
                listCandidate.add(c);
            }
            return listCandidate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Candidate> FindListCandidateEmail(String email)  {
        List<Candidate> listCandidate = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "SELECT " +
                "c.candidateID, " +
                "c.fullname, " +
                "c.address, " +
                "c.email, " +
                "c.phone, " +
                "j.status AS application_status, " +
                "j.created_at AS application_date, " +
                "co.companyName AS company_name " +
                "FROM candidates c " +
                "JOIN job_applications j ON c.candidateID = j.candidateID " +
                "JOIN job_posting jp ON j.jobPostID = jp.jobPostID " +
                "JOIN companies co ON jp.companyID = co.companyID " +
                "WHERE c.email LIKE ?;";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%"+email+"%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Candidate c = executeResult(rs);
                listCandidate.add(c);
            }
            return listCandidate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Candidate> FindListCandidateStatus(String status)  {
        List<Candidate> listCandidate = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "SELECT " +
                "c.candidateID, " +
                "c.fullname, " +
                "c.address, " +
                "c.email, " +
                "c.phone, " +
                "j.status AS application_status, " +
                "j.created_at AS application_date, " +
                "co.companyName AS company_name " +
                "FROM candidates c " +
                "JOIN job_applications j ON c.candidateID = j.candidateID " +
                "JOIN job_posting jp ON j.jobPostID = jp.jobPostID " +
                "JOIN companies co ON jp.companyID = co.companyID " +
                "WHERE j.status LIKE ?;";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%"+status+"%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Candidate c = executeResult(rs);
                listCandidate.add(c);
            }
            return listCandidate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteCandidateById(int candidateID) {
        Connection con = DBconnect.getConnection();
        try {
            // Bước 1: Xóa trong bảng job_applications
            String sqlJobApplications = "DELETE FROM job_applications WHERE resumeID IN (SELECT resumeID FROM resumes WHERE candidateID = ?)";
            PreparedStatement pre1 = con.prepareStatement(sqlJobApplications);
            pre1.setInt(1, candidateID);
            pre1.executeUpdate();

            // Bước 2: Xóa trong bảng resumes
            String sqlResumes = "DELETE FROM resumes WHERE candidateID = ?";
            PreparedStatement pre0 = con.prepareStatement(sqlResumes);
            pre0.setInt(1, candidateID);
            pre0.executeUpdate();

            // Bước 3: Xóa trong bảng candidates
            String sqlCandidates = "DELETE FROM candidates WHERE candidateID = ?";
            PreparedStatement pre2 = con.prepareStatement(sqlCandidates);
            pre2.setInt(1, candidateID);
            int rowsAffected = pre2.executeUpdate();
            if(rowsAffected > 0) { // Trả về true nếu xóa thành công
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;

    }

    public Candidate getCandidateById(int id) {
        Connection con = DBconnect.getConnection();
        String sql = "SELECT " +
                "c.candidateID, " +
                "c.fullname, " +
                "c.address, " +
                "c.email, " +
                "c.phone, " +
                "j.status AS application_status, " +
                "j.created_at AS application_date, " +
                "co.companyName AS company_name " +
                "FROM candidates c " +
                "JOIN job_applications j ON c.candidateID = j.candidateID " +
                "JOIN job_posting jp ON j.jobPostID = jp.jobPostID " +
                "JOIN companies co ON jp.companyID = co.companyID " +
                "WHERE c.candidateID = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? executeResult(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean editUserCandidate(int cid, String fullname, String email, String phone,String status ) {
        Connection conn = DBconnect.getConnection();
        String sql = "UPDATE candidates c JOIN job_applications ja ON c.candidateID = ja.candidateID SET c.fullname = ?, c.email = ?, c.phone = ?, ja.status = ? WHERE c.candidateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, fullname);
            pre.setString(2, email);
            pre.setString(3, phone);
            pre.setString(4, status);
            pre.setInt(5, cid);
            if(pre.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }





    private Candidate executeResult(ResultSet rs) throws SQLException  {
        int candidateID = rs.getInt("candidateID");
        String fullName = rs.getString("fullName");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String appliedCompany = rs.getString("company_name");
        LocalDateTime applyDate = rs.getTimestamp("application_date").toLocalDateTime();
        String status = rs.getString("application_status");
        Candidate candidate = new Candidate(candidateID, fullName, address, email, phone, appliedCompany, applyDate, status);
        return candidate;
    }

    public static void main(String[] args) {
        CandidateDao dao = new CandidateDao();
        System.out.println(dao.getListCandidate());
    }


    public int findCandidateIdByUserId(int userId) {
        Connection con = DBconnect.getConnection();
        int res = -1;
        String sql = "SELECT candidateId FROM candidates WHERE userId = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            if(rs.next()) {
                res = rs.getInt(1);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
