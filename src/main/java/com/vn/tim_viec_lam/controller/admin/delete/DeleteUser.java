package com.vn.tim_viec_lam.controller.admin.delete;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "delete-user", value = "/admin/delete/delete-user")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UserService userService = new UserService();
        int id = Integer.parseInt(req.getParameter("uid"));
        userService.deleteUserByID(id);
        resp.sendRedirect(req.getContextPath() + "/admin/manager-user");

    }
}
