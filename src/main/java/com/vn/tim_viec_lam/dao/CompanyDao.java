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
        List<Company> companies = new ArrayList<Company>();

        Connection con = DBconnect.getConnection();
        String sql = "select * from companies";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public Company getCompanyById(int id) {
        Connection con = DBconnect.getConnection();
        String sql = "select * from companies where companyID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? excuteResultSet(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Company> findByName(String nameCompany) {
        List<Company> companies = new ArrayList<Company>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from companies where companyName like ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nameCompany + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Company> findByEmail(String email) {
        List<Company> companies = new ArrayList<Company>();
        Connection con = DBconnect.getConnection();
        String sql = "SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n" +
                "WHERE u.email LIKE ?;\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + email + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Company getListCompanyUserbyID (int id) {
        List<Company> companies = new ArrayList<Company>();

        Connection con = DBconnect.getConnection();
        String sql ="SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n" +
                "WHERE u.userID = ?;\n";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? excuteResultSet(rs) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Company> getListCompanyUser (){
        List<Company> companies = new ArrayList<Company>();

        Connection con = DBconnect.getConnection();
        String sql = "SELECT c.*, u.email AS email, u.phone_number AS phone, u.status AS status, u.created_at AS createDate\n" +
                "FROM company_users cu\n" +
                "JOIN companies c ON cu.companyID = c.companyID\n" +
                "JOIN users u ON cu.userID = u.userID\n";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void deleteUserCompany(int userId) {
//        List<Company> companies = new ArrayList<Company>();
//        String sql = "DELETE c, cu, u \n" +
//                "FROM company_users cu\n" +
//                "JOIN companies c ON cu.companyID = c.companyID\n" +
//                "JOIN users u ON cu.userID = u.userID\n" +
//                "WHERE u.userID = ?;\n";
//        try {
//            Connection con = DBconnect.getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
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

                    ps1.executeUpdate(); // Xóa từ bảng job_locations
                    ps2.executeUpdate(); // Xóa từ bảng job_post_categories
                    ps3.executeUpdate(); // Xóa từ bảng job_posting
                    ps4.executeUpdate(); // Xóa từ bảng company_users
                    ps5.executeUpdate(); // Xóa từ bảng companies
                    ps6.executeUpdate(); // Xóa từ bảng users

                    con.commit(); // Commit nếu không có lỗi
                    System.out.println("Delete successful.");
                } catch (SQLException e) {
                    con.rollback(); // Rollback nếu có lỗi
                    throw e;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    public void editUser(int pid, String pname, String pemail, String pphone,String pstatus, String paddress ) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            conn = DBconnect.getConnection();

            // Cập nhật bảng companies
            String query1 = "UPDATE companies c " +
                    "JOIN company_users cu ON c.companyID = cu.companyID " +
                    "SET c.companyName = ?, c.address = ? " +
                    "WHERE cu.userID = ?";
            ps1 = conn.prepareStatement(query1);
            ps1.setString(1, pname);
            ps1.setString(2, paddress);
            ps1.setInt(3, pid);
            ps1.executeUpdate();

            // Cập nhật bảng users
            String query2 = "UPDATE users " +
                    "SET email = ?, phone_number = ?, status = ? " +
                    "WHERE userID = ?";
            ps2 = conn.prepareStatement(query2);

            ps2.setString(1, pemail);
            ps2.setString(2, pphone);
            ps2.setString(3, pstatus);
            ps2.setInt(4, pid);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public  List<CompanyStatusCategory> getAllStatusCategory() {
        List<CompanyStatusCategory> list = new ArrayList<CompanyStatusCategory>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from category_status_for_company";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new CompanyStatusCategory(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }




    public List<Company> filterByCity(List<String> cityList) {
        List<Company> companies = new ArrayList<>();
        Connection con = DBconnect.getConnection();
        String sql = "select * from companies where city in (" +
                String.join(",",Collections.nCopies(cityList.size(),"?")) + ")" ;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            for(int i = 1;i<=cityList.size();i++) {
                ps.setString(i, cityList.get(i-1));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = excuteResultSet(rs);
                companies.add(company);
            }
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public Company excuteResultSet(ResultSet rs) {
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