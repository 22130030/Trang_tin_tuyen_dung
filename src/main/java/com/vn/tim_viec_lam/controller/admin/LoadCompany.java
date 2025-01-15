package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loaduser",value = "/loaduser")
public class LoadCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        CompanyService service = new CompanyService();
        int pid = Integer.parseInt(req.getParameter("pid"));
        service.getListCompanyUserById(pid);
        req.setAttribute("ls", service.getListCompanyUserById(pid));
        req.getRequestDispatcher("edit_user_company.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
