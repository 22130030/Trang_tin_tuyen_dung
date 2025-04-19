package com.vn.tim_viec_lam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "employer-home",value = "/employer-home")
public class EmployerHomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.setAttribute("currentUrl","/employer-home");

        System.out.println(" currentUrl : "+ session.getAttribute("currentUrl"));
        resp.sendRedirect(req.getContextPath()+"/employer_home.jsp");
    }
}
