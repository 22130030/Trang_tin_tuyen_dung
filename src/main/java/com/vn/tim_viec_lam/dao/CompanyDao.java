package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<Company> searchCompany(String nameCompany) {
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
    public Company excuteResultSet(ResultSet rs) {
        try {
            int id = rs.getInt("companyID");
            String companyName = rs.getString("companyName");
            String logo = rs.getString("logo");
            String address = rs.getString("address");
            String website = rs.getString("website");
            String description = rs.getString("description");
            Company com = new Company(id, companyName, logo, address, website, description);

            return com;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        }


    public static void main(String[] args) {
        System.out.println(new CompanyDao().searchCompany("FE CREDIT").toString());
    }


}
