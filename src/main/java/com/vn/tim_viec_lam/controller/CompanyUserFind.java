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

@WebServlet(name = "company-user-job",value = "/company-user-job")
public class CompanyUserFind  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String txtEmail = req.getParameter("searchEmail");
        CompanyService service = new CompanyService();
        List<Company> listEmailCompany = service.findByEmail(txtEmail);
        req.setAttribute("email", listEmailCompany);
        req.getRequestDispatcher("admin_employer.jsp").forward(req, resp);
    }
}
