package com.vn.tim_viec_lam.controller.mail;

import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.MailService;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@WebServlet(name = "ForgotPasswordController", value = "/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserService userService = new UserService();

        if (userService.isEmailExists(email)) {
            // Tạo token đặt lại mật khẩu
            String token = EncryptionService.hasPasswordToMD5(UUID.randomUUID().toString());
            VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
            int tokenId = verifycationTokenService.addVerificationToken(email, token);

            // Link đặt lại mật khẩu
            String resetLink = "http://localhost:8080/trang_tin_tuyen_dung/reset-password?token=" + token + "&key=" + tokenId;

            // Nội dung email
            String header = "Xin chào " + email + ",<br><br>";
            String content = "Bạn đã yêu cầu đặt lại mật khẩu. Nhấn vào liên kết sau để tiếp tục:<br><br>";
            String href = "<a href='" + resetLink + "' style='font-size: 16px; color: blue; text-decoration: none;'>Đặt lại mật khẩu</a><br><br>";
            String footer = "Nếu bạn không thực hiện yêu cầu này, vui lòng bỏ qua email này.<br><br>Trân trọng!";

            String emailContent = header + content + href + footer;
            String subject = "=?UTF-8?B?" + Base64.getEncoder().encodeToString("Đặt lại mật khẩu - TimViecHCD".getBytes(StandardCharsets.UTF_8)) + "?=";

            // Gửi email
            MailService mailService = new MailService();
            mailService.sendMail(email, subject, emailContent);

            response.sendRedirect("login_reset_request.jsp?status=success");
        } else {
            response.sendRedirect("login_reset_request.jsp?status=notfound");
        }
    }
}
