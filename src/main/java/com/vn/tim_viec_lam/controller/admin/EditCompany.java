package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.CompanyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="edit",value = "/edit")
public class EditCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
//        CompanyService service = new CompanyService();
//        List<Company> listUserCompany = service.getUserCompany();
//        req.setAttribute("listUserCompany", listUserCompany);
//        req.getRequestDispatcher("edit-user-company.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
       int pid = Integer.parseInt(req.getParameter("id"));
       String pname = req.getParameter("companyName");
       String pemail = req.getParameter("email");
       String pphone = req.getParameter("phone");
       String pstatus = req.getParameter("status");
       String paddress = req.getParameter("address");
       CompanyService service = new CompanyService();
       service.editUserCompany(pid,pname,pemail,pphone,pstatus,paddress);
       resp.sendRedirect("company-user-job");




    }
}
