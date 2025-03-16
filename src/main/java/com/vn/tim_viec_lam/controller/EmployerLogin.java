package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="employerLogin",value="/employer-login")
public class EmployerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        CompanyUserService us = new CompanyUserService();
        if(us.login(email, password)) {
            CompanyUser u = us.getUser(email);
            int companyID = u.getCompanyID();
            int role = u.getRoleNum();
            session.setAttribute("companyUser", u);
            session.setAttribute("companyRole",role);
            session.setAttribute("companyId", companyID);
            if(role ==2){
                response.sendRedirect("employer/employer.jsp");
            }

        }
        else{
            response.sendRedirect("employer_home.jsp")  ;
        }
    }
}
