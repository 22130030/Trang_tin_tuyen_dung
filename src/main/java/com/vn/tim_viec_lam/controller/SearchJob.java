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

@WebServlet(name = "search-job",value = "/search-job")
public class SearchJob extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String txtSearch = request.getParameter("searchName");
        JobService jobService = new JobService();
        List<Job> jobs = jobService.getListSearchByName(txtSearch);
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("search_job.jsp").forward(request, response);

    }
}
