package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "search-company",value = "/search-company")
public class FindCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("company.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       String search = req.getParameter("searchCompany");
        CompanyService companyService = new CompanyService();
        List<Company> companyList = companyService.getListCompany(search);
        req.setAttribute("companyList",companyList);
        req.getRequestDispatcher("company.jsp").forward(req, resp);
    }
}
