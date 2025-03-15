
package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="register",value = "/register")
public class RegisterCanidate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("email");
        String fName = req.getParameter("fName");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");
        String phone = req.getParameter("phone");

        UserService userService = new UserService();
        boolean res =userService.insetUser(mail,password,rePassword,fName,phone);
        if(res){

        }
        resp.sendRedirect("login.jsp");
    }
}
