package com.vn.tim_viec_lam.controller;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.internet.MimeBodyPart;

import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        final String userEmail = "ducvan26324@gmail.com";
        final String password = "Ducvan26324@@@##";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, password);
            }
        });

        try {
            // Tạo email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("22130050@st.hcmuaf.edu.vn"));
            message.setSubject("Thư thử nghiệm với nội dung tiếng Việt");

            // Tạo phần thân email với mã hóa UTF-8
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("Đây là email thử nghiệm với nội dung tiếng Việt. Chúc bạn một ngày tốt lành!", "UTF-8");

            // Đưa phần thân vào trong một Multipart để gửi đi
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);

            // Gửi email
            Transport.send(message);

            System.out.println("Gửi thành công");
        } catch (MessagingException e) {
            System.err.println("Lỗi khi gửi email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
