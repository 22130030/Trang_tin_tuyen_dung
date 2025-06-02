package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.dao.model.CompanyStatusCategory;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class CompanyDao {
    public List<Company> getAll() {
        List<Company> companies = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM companies";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Đóng ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng PreparedStatement
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng Connection
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return companies;
    }
    public Company excuteResultSet(ResultSet rs){
        try {
        int id = rs.getInt("companyID");
        String companyName = rs.getString("companyName");
        String logo = rs.getString("logo");
        String address = rs.getString("address");
        String website = rs.getString("website");
        String description = rs.getString("description");
        String city = rs.getString("city");
        Company  company = new Company(id, companyName,"","","",null, logo, address,city, website, description);
            return company;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Company getCompanyById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from companies where companyID = ?";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs.next() ? excuteResultSet(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

    public List<Company> findByName(String nameCompany) {
        List<Company> companies = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from companies where companyName like ?";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nameCompany + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return companies;
    }

    public List<Company> findByEmail(String email) {
        List<Company> companies = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n" +
                "WHERE u.email LIKE ?;";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + email + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResult(rs);
                companies.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return companies;
    }

    public Company getListCompanyUserbyID(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n" +
                "WHERE u.userID = ?;";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs.next() ? excuteResult(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public List<Company> getListCompanyUser() {
        List<Company> companies = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResult(rs);
                companies.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return companies;
    }
    public void deleteUserCompany(int userId) {
        String deleteJobLocationsSql = "DELETE FROM job_locations " +
                "WHERE locationID IN ( " +
                "    SELECT locationID FROM job_posting " +
                "    WHERE companyID IN ( " +
                "        SELECT companyID FROM company_users " +
                "        WHERE userID = ? " +
                "    ) " +
                ");";
        String deleteJobPostCategoriesSql = "DELETE FROM job_post_categories " +
                "WHERE jobPostID IN ( " +
                "    SELECT jobPostID FROM job_posting " +
                "    WHERE companyID IN ( " +
                "        SELECT companyID FROM company_users " +
                "        WHERE userID = ? " +
                "    ) " +
                ");";
        String deleteJobPostingSql = "DELETE FROM job_posting " +
                "WHERE companyID IN ( " +
                "    SELECT companyID FROM company_users " +
                "    WHERE userID = ? " +
                ");";
        String deleteCompanyUsersSql = "DELETE FROM company_users WHERE userID = ?;";
        String deleteCompaniesSql = "DELETE FROM companies " +
                "WHERE companyID IN ( " +
                "    SELECT companyID FROM company_users " +
                "    WHERE userID = ? " +
                ");";
        String deleteUserSql = "DELETE FROM users WHERE userID = ?;";

        try (Connection con = DBconnect.getConnection()) {
            con.setAutoCommit(false); // Bắt đầu transaction

            try (PreparedStatement ps1 = con.prepareStatement(deleteJobLocationsSql);
                 PreparedStatement ps2 = con.prepareStatement(deleteJobPostCategoriesSql);
                 PreparedStatement ps3 = con.prepareStatement(deleteJobPostingSql);
                 PreparedStatement ps4 = con.prepareStatement(deleteCompanyUsersSql);
                 PreparedStatement ps5 = con.prepareStatement(deleteCompaniesSql);
                 PreparedStatement ps6 = con.prepareStatement(deleteUserSql)) {

                ps1.setInt(1, userId);
                ps2.setInt(1, userId);
                ps3.setInt(1, userId);
                ps4.setInt(1, userId);
                ps5.setInt(1, userId);
                ps6.setInt(1, userId);

                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();
                ps4.executeUpdate();
                ps5.executeUpdate();
                ps6.executeUpdate();

                con.commit();
                System.out.println("Delete successful.");
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editUser(int pid, String pname, String pemail, String pphone, String pstatus, String paddress) {
        String query1 = "UPDATE companies c " +
                "JOIN company_users cu ON c.companyID = cu.companyID " +
                "SET c.companyName = ?, c.address = ? " +
                "WHERE cu.userID = ?";
        String query2 = "UPDATE users " +
                "SET email = ?, phone_number = ?, status = ? " +
                "WHERE userID = ?";

        try (Connection conn = DBconnect.getConnection();
             PreparedStatement ps1 = conn.prepareStatement(query1);
             PreparedStatement ps2 = conn.prepareStatement(query2)) {

            ps1.setString(1, pname);
            ps1.setString(2, paddress);
            ps1.setInt(3, pid);
            ps1.executeUpdate();

            ps2.setString(1, pemail);
            ps2.setString(2, pphone);
            ps2.setString(3, pstatus);
            ps2.setInt(4, pid);
            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public List<CompanyStatusCategory> getAllStatusCategory() {
        List<CompanyStatusCategory> list = new ArrayList<>();
        String sql = "select * from category_status_for_company";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new CompanyStatusCategory(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }




    public List<Company> filterByCity(List<String> cityList) {
        List<Company> companies = new ArrayList<>();
        if (cityList == null || cityList.isEmpty()) {
            return companies; // Trả về rỗng nếu danh sách thành phố trống
        }

        String placeholders = String.join(",", Collections.nCopies(cityList.size(), "?"));
        String sql = "SELECT * FROM companies WHERE city IN (" + placeholders + ")";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (int i = 0; i < cityList.size(); i++) {
                ps.setString(i + 1, cityList.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Company company = excuteResultSet(rs);
                    companies.add(company);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companies;
    }
    public Company excuteResult(ResultSet rs) {
        try {
            int id = rs.getInt("companyID");
            String companyName = rs.getString("companyName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String status = rs.getString("status");
            LocalDateTime createDate = rs.getTimestamp("createDate").toLocalDateTime();
            String logo = rs.getString("logo");
            String address = rs.getString("address");
            String website = rs.getString("website");
            String description = rs.getString("description");
            String city = rs.getString("city");
            Company com = new Company(id, companyName,email,phone,status,createDate, logo, address,city, website, description);

            return com;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) {
        CompanyDao dao = new CompanyDao();
        //List<String> test = new ArrayList<>();
//       dao.editUser(3,"CÔNG TY TNHH THẨM MỸ NGỌC DUNG","user33@example.com","+1-800-792-9935","Đã duyệt");
       dao.editUser(17,"CÔNG TY TNHH HOJEONG","user1717@example.com","+1-800-532-1520 ","Đã duyệt","Lô R13, 14, 15 KCN Hải Sơn Xã Đức Hòa Hạ, Huyện Đức Hòa, Long An");
      //  dao.deleteUserCompany(6);
    }



}