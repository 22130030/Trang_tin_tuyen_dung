package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.JobCategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loadcategory", value = "/admin/loadcategory")
public class LoadCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        JobCategoryService jobCategoryService = new JobCategoryService();
        int id = Integer.parseInt(req.getParameter("lid"));
        jobCategoryService.FindListCategoryNameJobByID(id);
        req.setAttribute("loadcate",jobCategoryService.FindListCategoryNameJobByID(id));
        req.getRequestDispatcher("edit_category.jsp").forward(req, resp);
    }
}
