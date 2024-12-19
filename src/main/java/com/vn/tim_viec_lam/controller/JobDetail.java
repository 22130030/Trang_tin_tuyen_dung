package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "jobDetail",value = "/job-detail")
public class JobDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("jid") != null) {
            int id = Integer.parseInt(request.getParameter("jid"));
            System.out.println(request.getRequestURI());
            JobService js = new JobService();
            Job job = js.getJobById(id);

            request.setAttribute("job",job);

        }
        request.getRequestDispatcher("jobDetail.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
