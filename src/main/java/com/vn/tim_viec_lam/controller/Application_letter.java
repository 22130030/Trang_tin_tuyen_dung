package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.controller.file.UploadFile;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/employer/application-letter")
public class Application_letter extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html;charset=UTF-8");

        FileService fs = new FileService();
        JobService j = new JobService();
        List<Job> jobs = j.getJobByCompanyId(1);
        List<Resumes> files = new ArrayList<>();
        int jobId = 0;
        if(request.getParameter("jobId") == null){

        if(!jobs.isEmpty()){
            jobId = jobs.get(0).getId();
        }

            files = fs.getFiles(jobId);
            System.out.println(jobId);
        }
//        if(request.getParameter("jobId") != null){
//            jobId = Integer.parseInt(request.getParameter("jobId"));
//            files = fs.getFiles(jobId);
//        }
        request.setAttribute("files", files);
        request.setAttribute("jobs", jobs);
//        request.setAttribute("selectedJobId", jobId);
        request.getRequestDispatcher("jobApplication_letter.jsp").forward(request, response);
    }
}
