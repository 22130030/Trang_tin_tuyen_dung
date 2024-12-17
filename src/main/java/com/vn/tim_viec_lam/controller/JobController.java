package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class JobController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        JobService jsv = new JobService();
        List<Job> newJob = jsv.getNewJob();

//        paging
        int numberPage = jsv.getNumberPage();
        String index = request.getParameter("index");
        if(index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);

        List<Job> jobs = jsv.getJobByPage(indexPage);



        request.setAttribute("jobs", jobs);
        request.setAttribute("newJob", newJob);
        request.setAttribute("np", numberPage);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
