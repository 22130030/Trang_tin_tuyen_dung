package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.LogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "logout",value = "/logout")
public class CandidateLogout extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//
//        HttpSession session = request.getSession();
//        int role = (int) session.getAttribute("role");
//
//
//        if(session.getAttribute("user") != null && role == 1){
//            session.removeAttribute("jobAppliedCart");
//        }else if(session.getAttribute("user") != null && role == 2){
//        }
//        session.removeAttribute("user");
//        session.removeAttribute("role");
//        response.sendRedirect(request.getContextPath() + "/home");
//    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    HttpSession session = request.getSession();
    int role = (int) session.getAttribute("role");

    User user = (User) session.getAttribute("user");
    String ip = request.getRemoteAddr();
    String loginType = (String) session.getAttribute("loginType");

    // Ghi log trước khi xóa session
    if (user != null) {
        LogService logService = new LogService();
        String roleStr = (role == 1) ? "candidate" : (role == 2 ? "employer" : "admin");
        if (loginType == null) loginType = "local";
        logService.addLog(user, roleStr, "logout", loginType, "INFO", ip, "Logout");
    }

    if (user != null && role == 1) {
        session.removeAttribute("jobAppliedCart");
    } else if (user != null && role == 2) {
        // ...
    }
    session.removeAttribute("user");
    session.removeAttribute("role");
    session.removeAttribute("loginType");
    response.sendRedirect(request.getContextPath() + "/home");
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
