package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.JobPostCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "job-posting", value = "/employer/job-posting")
public class JobPosting extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        CategoryService cs = new CategoryService();
        List<JobPostCategory> categoryList = cs.getAllCategories();

        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("jobPosting_employer.jsp").forward(request,response);
    }
}
