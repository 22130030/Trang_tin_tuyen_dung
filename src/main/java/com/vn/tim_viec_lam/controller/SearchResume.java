package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="searchResume",value="/search-resume")
public class SearchResume extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

        String title = request.getParameter("titleInput");
        String address = request.getParameter("addressInput");


    }

    @WebServlet(name = "ResetPasswordServlet", value = "/reset-password")
    public static class ResetPasswordServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String token = request.getParameter("token");
            String key = request.getParameter("key");


            if (token == null || key == null) {
                response.sendRedirect("login_reset_request.jsp?status=invalid");
                return;
            }


            VerifycationTokenService tokenService = new VerifycationTokenService();


            // Kiểm tra token có hợp lệ và còn hạn không
            if (!tokenService.isTokenValid(token)) {
                response.sendRedirect("login_reset_request.jsp?status=expired");
                return;
            }


            // Nếu token hợp lệ, chuyển đến trang đặt lại mật khẩu
            request.setAttribute("token", token);
            request.getRequestDispatcher("reset_password_login.jsp").forward(request, response);
        }
    }
}
