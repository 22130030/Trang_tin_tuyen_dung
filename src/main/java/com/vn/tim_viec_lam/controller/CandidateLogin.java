package com.vn.tim_viec_lam.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.CandidateService;
import com.vn.tim_viec_lam.service.JobApplicationService;
import com.vn.tim_viec_lam.service.ResumesService;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet(name="login",value = "/login")
public class CandidateLogin extends HttpServlet {
//    private static final String CLIENT_ID = "m";
//    private static final String CLIENT_SECRET = "m";
//    private static final String REDIRECT_URI = "m";
//
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//    private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET,
//                Arrays.asList("https://www.googleapis.com/auth/userinfo.profile", "https://www.googleapis.com/auth/userinfo.email"))
//                .build();
//
//        String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
//        response.sendRedirect(authorizationUrl);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        // Kiểm tra xem tài khoản đã bị khóa chưa
        Long lockTime = (Long) session.getAttribute("lockTime");
        Integer failedAttempts = (Integer) session.getAttribute("failedAttempts");

        if (lockTime != null) {
            long elapsedTime = System.currentTimeMillis() - lockTime;
            if (elapsedTime < 1 * 60 * 1000) { // 1 phút
                response.sendRedirect("login.jsp?error=locked");
                return;
            } else {
                // Hết thời gian khóa, reset số lần nhập sai
                session.removeAttribute("lockTime");
                session.removeAttribute("failedAttempts");
            }
        }
        if ((email == null || email.trim().isEmpty()) && (password == null || password.trim().isEmpty())) {
            response.sendRedirect("login.jsp?error=empty_username_password"); // Không nhập cả tài khoản & mật khẩu
            return;
        }
        if (email == null || email.trim().isEmpty()) {
            response.sendRedirect("login.jsp?error=empty_username"); // Không nhập tài khoản
            return;
        }
        if (password == null || password.trim().isEmpty()) {
            // Nếu không nhập mật khẩu, hiển thị thông báo lỗi mà không tăng số lần nhập sai
            response.sendRedirect("login.jsp?error=empty_password");
            return;
        }

        UserService us = new UserService();
        if (us.login(email, password)) {
            // Đăng nhập thành công, reset bộ đếm
            session.removeAttribute("failedAttempts");
            session.removeAttribute("lockTime");

            User u = us.getUser(email);
            int role = u.getRoleNum();
            CandidateService cs = new CandidateService();
            int candidateId = cs.getCandidateIdByUserId(u.getUserID());
            List<JobApplication> jobApplicationList = new JobApplicationService().getAll();
            List<Resumes> resumesList = new ResumesService().getResumes(candidateId);

            session.setAttribute("user", u);
            session.setAttribute("email", u.getEmail());
            session.setAttribute("jobAppliedCart", jobApplicationList);
            session.setAttribute("jac", resumesList);
            session.setAttribute("role", role);
            session.setAttribute("status", u.getStatus());
            session.setAttribute("userID", u.getUserID());
            session.setAttribute("candidateId", candidateId);

            if (role == 1) {
                response.sendRedirect("home");
            } else if (role == 3) {
                response.sendRedirect("admin/report");
            } else {
                response.sendRedirect("home");
            }
        } else {
            // Đăng nhập thất bại, chỉ tăng failedAttempts khi có nhập mật khẩu
            failedAttempts = (failedAttempts == null) ? 1 : failedAttempts + 1;
            session.setAttribute("failedAttempts", failedAttempts);

            if (failedAttempts >= 3) { // Khóa sau 3 lần nhập sai
                session.setAttribute("lockTime", System.currentTimeMillis());
                response.sendRedirect("login.jsp?error=locked");
            } else {
                response.sendRedirect("login.jsp?error=invalid");
            }
        }
    }
}