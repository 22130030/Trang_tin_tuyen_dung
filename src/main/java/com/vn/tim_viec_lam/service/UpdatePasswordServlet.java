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
            // Mã hóa mật khẩu mới
            String hashedPassword = EncryptionService.hasPasswordToMD5(password);


            // Cập nhật mật khẩu trong database
            UserService userService = new UserService();
            boolean updated = userService.updatePassword(email, hashedPassword);


            if (updated) {
                response.sendRedirect("login.jsp?status=success");
            } else {
                response.sendRedirect("reset_password_login.jsp?status=error");
            }
        } else {
            response.sendRedirect("reset_password_login.jsp?status=expired");
        }
    }
}

