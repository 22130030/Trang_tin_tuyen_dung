package com.vn.tim_viec_lam.controller.mail;

import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.MailService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@WebServlet(name = "send-mail-employer", value = "/send-mail-employer")
public class SendMailControllerEmployer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");

        // 1. Tạo token
        String token = EncryptionService.hasPasswordToMD5(UUID.randomUUID().toString());

        // 2. Lưu token vào DB
        VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
        int id = verifycationTokenService.addVerificationToken(email, token);

        // 3. Lưu token vào session
        session.setAttribute("token", token);

        // 4. Soạn nội dung email
        String header = "Xin chào nhà tuyển dụng " + email + ",<br><br>";
        String content = "Cảm ơn bạn đã đăng ký tài khoản nhà tuyển dụng tại nền tảng TimViecHCD.<br>" +
                "Vui lòng nhấn vào đường dẫn dưới đây để xác thực tài khoản:<br><br>";
        String href = "<a href='http://localhost:8080/trang_tin_tuyen_dung/verify-email-employer?token=" + token + "&key=" + id + "' " +
                "style='font-size: 16px; color: green; text-decoration: none;'>Xác thực tài khoản</a><br><br>";
        String footer = "Nếu bạn không thực hiện hành động này, vui lòng bỏ qua email.<br><br>Trân trọng,<br>TimViecHCD";

        String container = header + content + href + footer;

        // 5. Subject chuẩn UTF-8
        String subject = "=?UTF-8?B?" + Base64.getEncoder().encodeToString("Xác thực tài khoản nhà tuyển dụng".getBytes(StandardCharsets.UTF_8)) + "?=";

        // 6. Gửi mail
        MailService mailService = new MailService();
        mailService.sendMail(email, subject, container);

        // 7. Chuyển đến trang thông báo
        request.setAttribute("email", email);
        request.getRequestDispatcher("verify_account.jsp").forward(request, response);
    }
}
