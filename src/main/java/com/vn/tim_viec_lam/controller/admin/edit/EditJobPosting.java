package com.vn.tim_viec_lam.controller.admin.edit;

import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit-job-posting" , value = "/admin/edit/edit-job-posting")
public class EditJobPosting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String img = req.getParameter("image");
        String title = req.getParameter("titleJob");
        String company = req.getParameter("companyName");
        String city = req.getParameter("address");
        String salary = req.getParameter("salary");
        String status = req.getParameter("status");
        JobService service = new JobService();
        service.editJobPosting(id,img,title,company,city,salary,status);
        resp.sendRedirect(req.getContextPath() +"/admin/job_manager");
    }
}
