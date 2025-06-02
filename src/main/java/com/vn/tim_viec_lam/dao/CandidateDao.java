package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Candidate;
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
        String sql = "SELECT " +
                "c.*, " +
                "j.status AS application_status, " +
                "j.created_at AS application_date, " +
                "co.companyName AS company_name " +
                "FROM candidates c " +
                "JOIN job_applications j ON c.candidateID = j.candidateID " +
                "JOIN job_posting jp ON j.jobPostID = jp.jobPostID " +
                "JOIN companies co ON jp.companyID = co.companyID";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

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
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) {

            pre.setString(1, "%" + email + "%");
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Candidate c = executeResult(rs);
                    listCandidate.add(c);
                }
            }
            return listCandidate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Candidate> FindListCandidateStatus(String status)  {
        List<Candidate> listCandidate = new ArrayList<>();
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
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) {

            pre.setString(1, "%" + status + "%");
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Candidate c = executeResult(rs);
                    listCandidate.add(c);
                }
            }
            return listCandidate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCandidateById(int candidateID) {
        String sqlJobApplications = "DELETE FROM job_applications WHERE resumeID IN (SELECT resumeID FROM resumes WHERE candidateID = ?)";
        String sqlResumes = "DELETE FROM resumes WHERE candidateID = ?";
        String sqlCandidates = "DELETE FROM candidates WHERE candidateID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre1 = con.prepareStatement(sqlJobApplications);
             PreparedStatement pre0 = con.prepareStatement(sqlResumes);
             PreparedStatement pre2 = con.prepareStatement(sqlCandidates)) {

            pre1.setInt(1, candidateID);
            pre1.executeUpdate();

            pre0.setInt(1, candidateID);
            pre0.executeUpdate();

            pre2.setInt(1, candidateID);
            int rowsAffected = pre2.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Candidate getCandidateById(int id) {
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
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? executeResult(rs) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean editUserCandidate(int cid, String fullname, String email, String phone, String status, String gender, String birth) {
        String sql = "UPDATE candidates c JOIN job_applications ja ON c.candidateID = ja.candidateID " +
                "SET c.fullname = ?, c.email = ?, c.phone = ?, ja.status = ?, c.gender = ?, c.birth_date = ? " +
                "WHERE c.candidateID = ?";
        try (Connection conn = DBconnect.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, fullname);
            pre.setString(2, email);
            pre.setString(3, phone);
            pre.setString(4, status);
            pre.setString(5, gender);
            pre.setString(6, birth);
            pre.setInt(7, cid);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Candidate getCandidateByUserId(int userId) {
        String sql = "SELECT candidateID, userID, fullname, address, email, phone, gender, birth_date FROM candidates WHERE userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Candidate candidate = new Candidate();
                    candidate.setCandidateID(rs.getInt("candidateID"));
                    candidate.setUserID(rs.getInt("userID"));
                    candidate.setFullName(rs.getString("fullname"));
                    candidate.setAddress(rs.getString("address"));
                    candidate.setEmail(rs.getString("email"));
                    candidate.setPhone(rs.getString("phone"));
                    candidate.setGender(rs.getString("gender"));
                    candidate.setBirth(rs.getString("birth_date"));
                    return candidate;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean updateCandidate(Candidate candidate) {
        String sql = "UPDATE candidates SET fullname = ?, address = ?, email = ?, phone = ?, gender = ?, birth_date = ? WHERE userID = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, candidate.getFullName());
            stmt.setString(2, candidate.getAddress());
            stmt.setString(3, candidate.getEmail());
            stmt.setString(4, candidate.getPhone());
            stmt.setString(5, candidate.getGender());
            stmt.setString(6, candidate.getBirth());
            stmt.setInt(7, candidate.getUserID());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Candidate executeResult(ResultSet rs) throws SQLException  {
        int candidateID = rs.getInt("candidateID");
        int userId = rs.getInt("userID");
        String fullName = rs.getString("fullName");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String appliedCompany = rs.getString("company_name");
        LocalDateTime applyDate = rs.getTimestamp("application_date").toLocalDateTime();
        String status = rs.getString("application_status");
        String gender = rs.getString("gender");
        String birthDate = rs.getString("birth_date");
        return new Candidate(candidateID, userId, fullName, address, email, phone, appliedCompany, applyDate, status, gender, birthDate);
    }

    public static void main(String[] args) {
        CandidateDao dao = new CandidateDao();
    }

    public int findCandidateIdByUserId(int userId) {
        String sql = "SELECT candidateId FROM candidates WHERE userId = ?";
        int res = -1;

        try (Connection con = DBconnect.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) {

            pre.setInt(1, userId);

            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    res = rs.getInt(1);
                }
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
