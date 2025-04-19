package com.vn.tim_viec_lam.service;




import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "UpdatePasswordServlet", value = "/update-password")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");
        String redirectUrl = request.getParameter("redirectUrl"); // Lấy tham số redirectUrl từ form
        String role = request.getParameter("role");

        if (token == null || password == null || retypePassword == null) {
            response.sendRedirect("reset_password_login.jsp?status=invalid");
            return;
        }

        if (!password.equals(retypePassword)) {
            response.sendRedirect("reset_password_login.jsp?status=nomatch");
            return;
        }

        VerifycationTokenService tokenService = new VerifycationTokenService();
        String email = tokenService.getEmailByToken(token);

        if (email != null) {
            String hashedPassword = EncryptionService.hasPasswordToMD5(password);
            UserService userService = new UserService();
            boolean updated = userService.updatePassword(email, hashedPassword);

            if (updated) {
                // Trường hợp có redirectUrl
                if (redirectUrl != null && !redirectUrl.trim().isEmpty()) {

                    if (redirectUrl.equals("login")) {
                        response.sendRedirect("login.jsp?status=success");
                    } else if (redirectUrl.equals("login_employer")) {
                        response.sendRedirect("login_employer.jsp?status=success");
                    } else if (redirectUrl.equals("employer_home")) {
                        response.sendRedirect("employer_home.jsp?status=success");
                    } else {
                        // Nếu redirectUrl không hợp lệ, fallback về login.jsp
                        response.sendRedirect("login.jsp?status=success");
                    }
                    return; // Kết thúc xử lý sau chuyển hướng
                } else {
                    // Nếu không có redirectUrl, chuyển hướng dựa trên role
                    if ("employer".equals(role)) {
                        response.sendRedirect("employer_home.jsp?status=success");
                    } else {
                        response.sendRedirect("home?status=success");
                    }
                    return; // Kết thúc xử lý sau chuyển hướng
                }
            }

            // Nếu cập nhật mật khẩu thất bại
            response.sendRedirect("reset_password_login.jsp?status=error");
        }
    }
    }
