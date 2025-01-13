package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "job_manager",value = "/job_manager")
public class ManagerJobPosting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        JobService service = new JobService();
        List<Job> listJob = service.getAllJob();
        req.setAttribute("list", listJob);
        req.getRequestDispatcher("admin_jobs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        JobService service = new JobService();
        String name = req.getParameter("name");
        List<Job> listJob = service.getSearchJobByNameJob(name);
        req.setAttribute("list", listJob);
        req.getRequestDispatcher("admin_jobs.jsp").forward(req, resp);

    }
}
