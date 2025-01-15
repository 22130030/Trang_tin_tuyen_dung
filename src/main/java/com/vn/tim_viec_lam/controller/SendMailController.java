package com.vn.tim_viec_lam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import jakarta.mail.PasswordAuthentication;
import java.util.Properties;

@WebServlet(name="sendMailController",value="/send-mail")
public class SendMailController extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String userEmail = "22130050@st.hcmuaf.edu.vn";
        final String password = "ducvan263";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        // Tạo phiên làm việc với SMTP server
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, password);
            }
        });

        try {
            // Tạo email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ducvan26324@gmail.com"));
            message.setSubject("Test Email");
            message.setText("Đây là email thử nghiệm được gửi từ ứng dụng Java.");
            // Gửi email
            Transport.send(message);

            // Thông báo gửi thành công
            response.getWriter().println("<h1>Email đã được gửi thành công!</h1>");
        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("<h1>Gửi email thất bại!</h1>");
        }
    }
}
