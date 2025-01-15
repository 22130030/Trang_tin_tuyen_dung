package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.CandidateService;
import com.vn.tim_viec_lam.service.CompanyService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "report", value = "/report")
public class Report extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        CompanyService cs = new CompanyService();
        List<Company> companies = cs.getUserCompany();
        req.setAttribute("com",companies);

        int size = companies.size();
        req.setAttribute("size", size);

        CandidateService service = new CandidateService();
        List<Candidate> candidateList = service.getListCandidate();
        int size2 = candidateList.size();
        req.setAttribute("size2", size2);

        JobService js = new JobService();
        List<Job> jobList = js.getAllJob();
        int size3 = jobList.size();
        req.setAttribute("size3", size3);


        req.getRequestDispatcher("admin_home.jsp").forward(req, resp);
//        int size = companies.size();
//        req.setAttribute("size",size);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
