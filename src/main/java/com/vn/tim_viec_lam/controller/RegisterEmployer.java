package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "register-employer", value = "/register-employer")
public class RegisterEmployer extends HttpServlet {
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
            req.setAttribute("emailError", "Email này đã được đăng ký. Vui lòng nhập email khác.");
            req.setAttribute("fName", fName);
            req.setAttribute("phone", phone);
            req.getRequestDispatcher("/register_for_employer.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession(false);
        session.setAttribute("mail", mail);
        session.setAttribute("fName", fName);
        session.setAttribute("password", EncryptionService.hasPasswordToMD5(password));
        session.setAttribute("rePassword", EncryptionService.hasPasswordToMD5(rePassword));
        session.setAttribute("phone", phone);

        req.getRequestDispatcher("employer_home.jsp").forward(req,resp);
    }
}
