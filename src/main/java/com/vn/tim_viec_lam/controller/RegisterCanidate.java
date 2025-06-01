package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.*;
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

@WebServlet(name ="register",value = "/register")
public class RegisterCanidate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("email");
        String fName = req.getParameter("fName");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");
        String phone = req.getParameter("phone");

        // Kiểm tra email đã tồn tại chưa
        UserService userService = new UserService();
        if(userService.isEmailExists(mail)){
            LogService logService = new LogService();
            String ip = req.getRemoteAddr();
            logService.addLog(
                    null,                 // user = null vì chưa có tài khoản
                    "candidate",          // role
                    "register",           // action
                    "local",           // loginType
                    "ERROR",              // status (hoặc "FAILED")
                    ip,
                    "Candidate registration Failed"
            );            req.setAttribute("emailError", "Email này đã được đăng ký. Vui lòng nhập email khác.");
            req.setAttribute("fName", fName);
            req.setAttribute("phone", phone);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        LogService logService = new LogService();
        String ip = req.getRemoteAddr();
        logService.addLog(
                null,             // user = null vì chưa có user trong db
                "candidate",      // role
                "register",       // action
                "local",       // loginType
                "INFO",           // status
                ip,
                "Candidate Registration Successful"
        );


        HttpSession session = req.getSession(false);
        session.setAttribute("mail", mail);
        session.setAttribute("fName", fName);
        session.setAttribute("password", EncryptionService.hasPasswordToMD5(password));
        session.setAttribute("rePassword", EncryptionService.hasPasswordToMD5(rePassword));
        session.setAttribute("phone", phone);

        req.getRequestDispatcher("send-mail").forward(req,resp);
    }
}
