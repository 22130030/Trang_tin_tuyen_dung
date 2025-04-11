package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.EncryptionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/change-password")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email"); // Lấy email từ session

        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");

        // Kiểm tra xác nhận mật khẩu mới
        if (!newPassword.equals(confirmPassword)) {
            response.sendRedirect("/account/change_pass.jsp?status=nomatch");
            return;
        }

        // Mã hóa mật khẩu cũ để kiểm tra
        String hashedOldPassword = EncryptionService.hasPasswordToMD5(oldPassword);

        UserService userService = new UserService();
        String currentPassword = userService.getPasswordByEmail(email);

        // Kiểm tra mật khẩu cũ đúng không
        if (currentPassword == null || !currentPassword.equals(hashedOldPassword)) {
            response.sendRedirect(request.getContextPath() + "/account/change_pass.jsp?status=incorrect_old_password");
            return;
        }

        // Mã hóa mật khẩu mới
        String hashedNewPassword = EncryptionService.hasPasswordToMD5(newPassword);

        // Cập nhật mật khẩu
        boolean isUpdated = userService.newPasswordByEmail(email, hashedNewPassword);

        if (isUpdated) {
            session.invalidate(); // Xóa session để đăng xuất
            response.sendRedirect("login.jsp?status=password_updated");
        } else {
            response.sendRedirect("/account/change_pass.jsp?status=error");
        }
    }
}
