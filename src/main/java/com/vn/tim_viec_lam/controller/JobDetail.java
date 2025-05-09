package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobApplicationService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "jobDetail",value = "/job-detail")
public class JobDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if(request.getParameter("jid") != null) {
            int id = Integer.parseInt(request.getParameter("jid"));

            JobService js = new JobService();
            Job job = js.getJobById(id);

            String city = job.getCity();
            List<Job> jobs = js.getJobsByAddress(city);
            int applied = 0;
            if(session != null) {
                int candidateId = (int)session.getAttribute("candidateId");
                System.out.println("candidate id: " + candidateId);
                JobApplicationService jobApplicationService = new JobApplicationService();
                if(jobApplicationService.getApplicationByJobIdAndCanId(id,candidateId)){
                    applied = 1;
                }
            }

            request.setAttribute("applied",applied);
            request.setAttribute("jobs",jobs);
            request.setAttribute("job",job);

        }
        request.getRequestDispatcher("jobDetail.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
