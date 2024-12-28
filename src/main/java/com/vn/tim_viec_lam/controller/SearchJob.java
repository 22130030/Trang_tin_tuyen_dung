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
        List<Job> jobList = null;
        int size = 0;
        String title = "";
        if(request.getParameter("cid")!=null){
            int id = Integer.parseInt(request.getParameter("cid"));
            String name = request.getParameter("name");
            JobService jobService = new JobService();
            title = " cho "+name;
            jobList = jobService.getJobByCategoryId(id);
            size   = jobList.size();
        }else if(request.getParameter("location")!=null){
            String location = request.getParameter("location");
            JobService js = new JobService();
            title = " tại "+location;
            jobList = js.getJobsByAddress(location);
            size   = jobList.size();
        }else if(request.getParameter("show-all") != null){
            JobService js = new JobService();
            jobList = js.getAllJob();
            size   = jobList.size();
        } else if (request.getParameter("all-newJob") != null) {
            JobService js = new JobService();
            title = " mới nhất";
            jobList = js.getAllNewJob();
            size   = jobList.size();
        }
        request.setAttribute("jobs",jobList);
        request.setAttribute("title",title);
        request.setAttribute("size",size);
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
        String title = " cho kết quả tìm kiếm";


        request.setAttribute("size",size);
        request.setAttribute("title",title);
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("search_job.jsp").forward(request, response);

    }
}
