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
@WebServlet(name = "send-mail",value = "/send-mail")
public class SendMailController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");

        String token = EncryptionService.hasPasswordToMD5(UUID.randomUUID().toString());
        VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
        int id = verifycationTokenService.addVerificationToken(email,token);

        session.setAttribute("token",token);
        String header = "Xin chào " + email + ",<br><br>";
        String content = "Cảm ơn bạn đã đăng ký tài khoản trên trang web của chúng tôi.<br>" +
                "Vui lòng nhấn vào link dưới đây để xác thực tài khoản của bạn:<br><br>";
        String href = "<a href='http://localhost:8080/trang_tin_tuyen_dung/verify-email?token=" + token + "&key=" + id + "' " +
                "style='font-size: 16px; color: blue; text-decoration: none;'>Nhấp vào đây để xác thực tài khoản</a><br><br>";


        String footer = "Nếu bạn không thực hiện yêu cầu này, vui lòng bỏ qua email này.<br><br>" +
                "Trân trọng!";

        String container = header + content + href + footer;
        String subject = "=?UTF-8?B?" + Base64.getEncoder().encodeToString("Xác thực tài khoản - TimViecHCD".getBytes(StandardCharsets.UTF_8)) + "?=";
        MailService mailService = new MailService();
        mailService.sendMail(email, subject, container);

        request.getRequestDispatcher("verify_account.jsp").forward(request, response);
    }
}
