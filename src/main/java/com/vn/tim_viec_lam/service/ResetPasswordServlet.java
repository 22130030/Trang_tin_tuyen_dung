package com.vn.tim_viec_lam.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ResetPasswordServlet", value = "/reset-password")
public class ResetPasswordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String key = request.getParameter("key");
        String redirectUrl = request.getParameter("redirectUrl"); // lấy thông tin từ link

        // Kiểm tra token và key có hợp lệ không
        if (token == null || token.isEmpty() || key == null || key.isEmpty()) {
            response.sendRedirect("login_reset_request.jsp?status=invalid");
            return;
        }

        VerifycationTokenService tokenService = new VerifycationTokenService();

        // Kiểm tra token có hợp lệ và còn hạn không
        if (!tokenService.isTokenValid(token)) {
            response.sendRedirect("login_reset_request.jsp?status=expired");
            return;
        }

        // Truyền token và redirectUrl cho trang reset_password_login.jsp
        request.setAttribute("token", token);
        request.setAttribute("redirectUrl", redirectUrl);

        // Forward tới trang reset_password_login.jsp
        request.getRequestDispatcher("reset_password_login.jsp").forward(request, response);
    }
}
