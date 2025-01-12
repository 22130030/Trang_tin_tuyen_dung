package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.CompanyStatusCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loaduser",value = "/loaduser")
public class LoadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CompanyService service = new CompanyService();
        int pid = Integer.parseInt(req.getParameter("pid"));
        service.getListCompanyUserById(pid);

        CategoryService categoryService = new CategoryService();
        List<CompanyStatusCategory> listStatusCompany = categoryService.getCompanyStatusCategories();

        req.setAttribute("ls", service.getListCompanyUserById(pid));
        req.setAttribute("status",listStatusCompany);
        req.getRequestDispatcher("edit_user_company.jsp").forward(req, resp);
    }
}
