package com.vn.tim_viec_lam.controller.admin.add;

import com.vn.tim_viec_lam.service.JobCategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "add-category", value = "/admin/add/add-category")
public class AddCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String category_name = req.getParameter("jobCategoryName");
        JobCategoryService jobCategoryService = new JobCategoryService();
        jobCategoryService.addCategory(category,category_name);
        resp.sendRedirect(req.getContextPath() +"/admin/manager-category");

    }
}
