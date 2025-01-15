package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.ResumesDao;
import com.vn.tim_viec_lam.dao.model.Resumes;
import jakarta.servlet.http.Part;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class FileService {
    private ResumesDao resumesDao;
    public FileService() {
        resumesDao = new ResumesDao();
    }
    public String extractFile(Part Part){
        String contentDisposition = Part.getHeader("content-disposition");
        for(String content : contentDisposition.split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf("=")+2,content.length()-1);
            }
        }
        return null;
    }
    public void addFile(Part Part, String fileName) {

    }
    public List<Resumes> getFiles(int jobID){
        return resumesDao.getResumesByJobID(jobID);
    }

    public static void main(String[] args) {
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
            protected PasswordAuthentication getPasswordAuthentication() {
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
            System.out.println("gửi thành công");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
