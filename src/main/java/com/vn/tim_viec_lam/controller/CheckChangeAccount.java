package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "check-change-status", value = "/check-change-status")
public class CheckChangeAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (session == null || session.getAttribute("user") == null) {
            response.getWriter().write("{\"changed\": false}");
            return;
        }

        try {
            int userId = (int) session.getAttribute("userID");
            UserService userService = new UserService();
            boolean changed = userService.getChanged(userId);

            System.out.println("changed = " + changed);
            if (changed) {
                session.invalidate();
            }

            response.getWriter().write("{\"changed\": " + changed + "}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Internal error\"}");
        }
    }
}

