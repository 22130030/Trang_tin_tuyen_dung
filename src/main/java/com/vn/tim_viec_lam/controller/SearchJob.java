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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        if(request.getParameter("cid")!=null){
            int id = Integer.parseInt(request.getParameter("cid"));
            JobService jobService = new JobService();
            List<Job> jobList = jobService.getJobByCategoryId(id);
            int size   = jobList.size();
            request.setAttribute("jobs",jobList);
            request.setAttribute("size",size);

        }
        request.getRequestDispatcher("search_job.jsp").forward(request,response);
   }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("searchName");
        String txtAddress = request.getParameter("searchAddress");

        JobService jobService = new JobService();
        List<Job> jobs = jobService.getListSearchJob(txtSearch,txtAddress);

        int size = jobs.size();

        request.setAttribute("size",size);
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("search_job.jsp").forward(request, response);

    }
}
