package com.vn.tim_viec_lam.controller.mail;

import com.vn.tim_viec_lam.service.CandidateService;
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
        resp.setContentType("text/html");
        String tokenFromMail = req.getParameter("token");
        int id = Integer.parseInt(req.getParameter("key"));

        VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
        String tokenSystem = verifycationTokenService.getTokenById(id);
        
        HttpSession session = req.getSession(false);
        int userID = (Integer) session.getAttribute("userID");
        UserService userService = new UserService();
        userService.updateStatus(userID,1);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
