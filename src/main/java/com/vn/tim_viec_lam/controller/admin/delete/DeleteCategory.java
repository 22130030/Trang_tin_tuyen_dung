package com.vn.tim_viec_lam.controller.admin.delete;

import com.vn.tim_viec_lam.dao.model.JobCategory;
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

@WebServlet(name = "delete-category", value ="/admin/delete/delete-category")
public class DeleteCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int userId = (int)session.getAttribute("userID");

        resp.setContentType("text/html;charset=utf-8");


        JobCategoryService service = new JobCategoryService();
        int id = Integer.parseInt(req.getParameter("did"));
        service.deleteCategory(id);

        LogWorkService logWorkService = new LogWorkService();
        LogWork logwork = new LogWork(userId,"delete","JobCategoryId : "+ id,"()");

        logWorkService.insertLogWork(logwork);

        resp.sendRedirect(req.getContextPath() + "/admin/manager-category");

    }
}
