package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.JobCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import com.vn.tim_viec_lam.service.JobCategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "manager-category", value = "/admin/manager-category")
public class ManagerCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        JobCategoryService jobCategoryService = new JobCategoryService();
        List<JobCategory> categoryList = jobCategoryService.getListCategory();
        req.setAttribute("category", categoryList);
        req.getRequestDispatcher("admin_category.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        JobCategoryService jobCategoryService = new JobCategoryService();
        String category = req.getParameter("name");
        List<JobCategory> categoryList = jobCategoryService.FindListCategoryByNameJob(category);
        req.setAttribute("category", categoryList);
        req.getRequestDispatcher("admin_category.jsp").forward(req, resp);

    }
}
