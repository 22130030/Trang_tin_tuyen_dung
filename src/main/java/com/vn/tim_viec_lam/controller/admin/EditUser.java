package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit-user", value = "/edit-user")
public class EditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int uid = Integer.parseInt(req.getParameter("userId"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int role = Integer.parseInt(req.getParameter("roleNum"));
        String status = req.getParameter("status");
        UserService userService = new UserService();
        userService.editUser(uid, email, password, role, status);
        resp.sendRedirect("manager-user");
    }
}
