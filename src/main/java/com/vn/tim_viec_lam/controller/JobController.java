package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.JobCategoryCount;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import com.vn.tim_viec_lam.service.JobCategoryService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/home")
public class JobController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.contains("/home")){

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


//            String i = request.getParameter("i");
//            if(i == null) {
//                i = "1";
//            }
//            int indexCategory = Integer.parseInt(i);
            JobCategoryService jobCategoryService = new JobCategoryService();
            int np = jobCategoryService.getNumberPage();
            int indexCategory = 1;
            String i = request.getParameter("i");
            try {
                    indexCategory = Integer.parseInt(i);
            } catch (NumberFormatException e) {
                indexCategory = 1;
            }
            if (indexCategory < 1) indexCategory = np;
            if (indexCategory > np) indexCategory = 1;
//            CategoryService cs = new CategoryService();
//            List<JobPostCategory> categories = cs.getCategoriesByNumberPage(indexCategory);
            List<JobCategoryCount> categoryCounts = null;
            categoryCounts = jobCategoryService.getCategoriesByPage(indexCategory);

            request.setAttribute("jobs", jobs);
            request.setAttribute("categoryCounts", categoryCounts);
            request.setAttribute("np", np);
            request.setAttribute("newJob", newJob);
            request.setAttribute("np", numberPage);
            HttpSession session = request.getSession(true);
            session.setAttribute("currentUrl","/home");
            if(session.getAttribute("user")!=null){
                session.setAttribute("role",1);
            }
            System.out.println("role : "+session.getAttribute("role"));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
