package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "add-job-posting",value = "/add-job-posting")
public class AddJobPosting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String img = req.getParameter("image");
        String title = req.getParameter("titleJob");
        String company = req.getParameter("companyName");
        String city = req.getParameter("address");
        String salary = req.getParameter("salary");
        String status = req.getParameter("status");
        JobService jobService = new JobService();
        jobService.addJobPosting(img, title, company, city, salary, status);
        resp.sendRedirect("job_manager");
    }
}
