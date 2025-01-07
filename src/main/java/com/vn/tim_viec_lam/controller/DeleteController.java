package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet(name="delete-company",value = "/delete-company")
public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int pid = Integer.parseInt(req.getParameter("pid"));
        CompanyService service  = new CompanyService();
        service.deleteUserCompany(pid);
        resp.sendRedirect(req.getContextPath() + "/company-user-job");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
