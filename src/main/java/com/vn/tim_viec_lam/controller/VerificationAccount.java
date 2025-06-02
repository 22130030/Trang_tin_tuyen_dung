package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "verification-account", value = "/verification-account")
public class VerificationAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("token");
        String key = req.getParameter("key");

       HttpSession session = req.getSession(false);
        int userID = (Integer) session.getAttribute("userID");
        if (token == null || key == null) {
            resp.sendRedirect("login_reset_request.jsp?status=verify_failed");
            return;
        }

        VerifycationTokenService tokenService = new VerifycationTokenService();

        boolean isValid = tokenService.isTokenValid(token);

        if (isValid) {
            String email = tokenService.getEmailByToken(token);

            UserService userService = new UserService();
            boolean updated = userService.updateStatus(userID,1);

            tokenService.deleteToken(token);


            session.setAttribute("status",1);
            if (updated) {
                resp.sendRedirect("login_reset_request.jsp?status=verified");
            } else {
                resp.sendRedirect("login_reset_request.jsp?status=verify_failed");
            }
        } else {
            // Token không hợp lệ hoặc đã hết hạn
            resp.sendRedirect("login_reset_request.jsp?status=verify_failed");
        }

    }
}
