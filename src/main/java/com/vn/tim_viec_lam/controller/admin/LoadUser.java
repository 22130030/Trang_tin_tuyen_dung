package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "load-users", value = "/load-users")
public class LoadUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("uid"));
        UserService userService = new UserService();
        userService.FindListUserByID(id);
        req.setAttribute("load",userService.FindListUserByID(id));
        req.getRequestDispatcher("/edit_user.jsp").forward(req, resp);
    }
}
