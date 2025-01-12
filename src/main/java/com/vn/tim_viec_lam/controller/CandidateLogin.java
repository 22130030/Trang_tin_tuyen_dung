package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="login",value = "/login")
public class CandidateLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        System.out.println(email);
        System.out.println(password);
        UserService us = new UserService();
        if(us.login(email, password)) {
            User u = us.getUser(email);
            session.setAttribute("user", u);
            response.sendRedirect("home");
        }
        else{
            response.sendRedirect("login.jsp")  ;
        }
    }
}
