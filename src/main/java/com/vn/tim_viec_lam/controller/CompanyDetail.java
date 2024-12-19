package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.CompanyService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "companyDetail",value = "/company-detail")
public class CompanyDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("jid"));

        CompanyService cs = new CompanyService();
        Company c = cs.findCompanyById(id);

        JobService js = new JobService();
        List<Job> jobs = js.getJobByCompanyId(id);

        request.setAttribute("c",c);
        request.setAttribute("jobs",jobs);

        request.getRequestDispatcher("companyDetail.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
