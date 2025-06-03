package com.vn.tim_viec_lam.controller.admin.add;

import com.vn.tim_viec_lam.dao.model.Category;
import com.vn.tim_viec_lam.dao.model.LogWork;
import com.vn.tim_viec_lam.service.JobCategoryService;
import com.vn.tim_viec_lam.service.LogWorkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "add-category", value = "/admin/add/add-category")
public class AddCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int userId = (int)session.getAttribute("userID");

        LogWorkService logWorkService = new LogWorkService();


        String category = req.getParameter("category");
        String category_name = req.getParameter("jobCategoryName");

        JobCategoryService jobCategoryService = new JobCategoryService();
        int id = jobCategoryService.addCategory(category,category_name);
        Category categoryObj = new Category(id,category);

        LogWork logWork = new LogWork(userId,"add","()",categoryObj.toString());
        logWorkService.insertLogWork(logWork);


        resp.sendRedirect(req.getContextPath() +"/admin/manager-category");

    }
}
