package com.vn.tim_viec_lam.controller.admin.edit;

import com.vn.tim_viec_lam.service.JobCategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit-category", value = "/admin/edit/edit-category")
public class EditCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String categoryName = req.getParameter("category");
        String  jobcategoryName = req.getParameter("jobCategoryName");
        JobCategoryService service = new JobCategoryService();
        service.editCategory(id,categoryName,jobcategoryName);
        resp.sendRedirect(req.getContextPath() + "/admin/manager-category");
    }
}
