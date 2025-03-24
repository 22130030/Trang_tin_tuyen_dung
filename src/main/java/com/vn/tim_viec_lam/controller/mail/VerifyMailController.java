package com.vn.tim_viec_lam.controller.mail;

import com.vn.tim_viec_lam.service.CandidateService;
import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "verify-email",value = "/verify-email")
public class VerifyMailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String tokenFromMail = req.getParameter("token");
        int id = Integer.parseInt(req.getParameter("key"));

        VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
        String tokenSystem = verifycationTokenService.getTokenById(id);
        if(tokenSystem.equals(tokenFromMail)){
            HttpSession session = req.getSession(false);
            String mail = (String) session.getAttribute("mail");
            String fname = (String) session.getAttribute("fName");
            String pass = (String) session.getAttribute("password");
            String rePaass = (String) session.getAttribute("rePassword");
            String phone = (String) session.getAttribute("phone");
            UserService userService = new UserService();
            boolean res = userService.insetUser(mail,pass,rePaass,fname,phone);
            if(res){
                session.invalidate();
                System.out.println("Đăng ký thành công");
                resp.sendRedirect("login.jsp?status=success");
            }
        }else{
            System.out.println("mã không đúng");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
