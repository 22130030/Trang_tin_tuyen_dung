package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.CompanyUserService;
import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.LogService;
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
        String email = req.getParameter("email");
        String fName = req.getParameter("fName");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");
        String companyName = req.getParameter("fName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address_detail");

        CompanyUserService companyUserService = new CompanyUserService();
        LogService logService = new LogService();
        String ip = req.getRemoteAddr();
       if(companyUserService.isEmailExists(email)){
           logService.addLogCompany(
                   null,                 // user chưa có
                   "employer",           // role
                   "register",           // action
                   "local",           // loginType
                   "ERROR",              // status
                   ip,
                   "Employer registration Failed"
           );
           req.setAttribute("emailError", "Email này đã được đăng ký. Vui lòng nhập email khác.");
           req.setAttribute("fName", fName);
           req.setAttribute("phone", phone);
           req.getRequestDispatcher("/register_for_employer.jsp").forward(req, resp);
           return;
       }
        logService.addLogCompany(
                null,                 // user chưa có
                "employer",           // role
                "register",           // action
                "local",           // loginType
                "INFO",              // status
                ip,
                "Employer registration Success"
        );

        HttpSession session = req.getSession(false);
        session.setAttribute("email", email);
        session.setAttribute("fName", fName);
        session.setAttribute("password",password);
        session.setAttribute("rePassword",rePassword);
        //session.setAttribute("rePassword", EncryptionService.hasPasswordToMD5(rePassword));
        session.setAttribute("companyName", companyName);
        session.setAttribute("phone", phone);
        session.setAttribute("address", address);

        req.getRequestDispatcher("send-mail-employer").forward(req,resp);
    }
}
