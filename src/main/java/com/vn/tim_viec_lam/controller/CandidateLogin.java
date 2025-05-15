package com.vn.tim_viec_lam.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.dao.model.UserProfileDTO;
import com.vn.tim_viec_lam.service.*;
import io.github.cdimascio.dotenv.Dotenv;
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
    private Dotenv dotenv = Dotenv.load();
    private String clientId = dotenv.get("GOOGLE_CLIENT_ID");
    private  final String REDIRECT_URI = dotenv.get("REDIRECT_URI");

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authURL = "https://accounts.google.com/o/oauth2/auth" +
                "?client_id=" + clientId +
                "&redirect_uri=" + REDIRECT_URI +
                "&response_type=code" +
                "&scope=email profile" +
                "&access_type=online";

        response.sendRedirect(authURL);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);

        // Kiểm tra xem tài khoản đã bị khóa chưa
        Long lockTime = (Long) session.getAttribute("lockTime");
        Integer failedAttempts = (Integer) session.getAttribute("failedAttempts");
        Integer lockDuration = (Integer) session.getAttribute("lockDuration");

        if (failedAttempts == null) failedAttempts = 0;
        if (lockDuration == null) lockDuration = 1;

        if (lockTime != null) {
            long elapsedTime = System.currentTimeMillis() - lockTime;
            if (elapsedTime < lockDuration * 60 * 1000) {
                response.sendRedirect("login.jsp?error=locked");
                return;
            } else {
                // Hết thời gian khóa, reset số lần nhập sai
                session.removeAttribute("lockTime");
                session.removeAttribute("failedAttempts");
                session.setAttribute("lockDuration", 1);
            }

                }

                UserService us = new UserService();
                if (us.login(email, password)) {

                    User u = us.getUser(email);
                    boolean locked = us.getLockStatus(u.getUserID());
                    if(locked){
                        response.sendRedirect("login.jsp?error=locked");
                        return;
                    }


                    session.removeAttribute("failedAttempts");
                    session.removeAttribute("lockTime");
                    session.removeAttribute("lockDuration");


                    if (u == null) {
                        // Đề phòng user không tồn tại dù login trả về true
                        response.sendRedirect("login.jsp?error=nouser");
                        return;
                    }

                    int role = u.getRoleNum();
                    CandidateService cs = new CandidateService();
                    int candidateId = cs.getCandidateIdByUserId(u.getUserID());
                    List<JobApplication> jobApplicationList = new JobApplicationService().getAll(candidateId);
                    List<Resumes> resumesList = new ResumesService().getResumes(candidateId);

                    UserProfileService userProfileService = new UserProfileService();
                    UserProfileDTO userProfile = userProfileService.getUserProfile(u.getUserID());

                    session.setAttribute("user", u);
                    session.setAttribute("userProfile", userProfile);
                    session.setAttribute("email",u.getEmail());
                    session.setAttribute("jobAppliedCart", jobApplicationList);
                    session.setAttribute("jac", resumesList);
                    session.setAttribute("role", role);
                    session.setAttribute("status",u.getStatus());
                    session.setAttribute("userID",u.getUserID());
                    session.setAttribute("candidateId", candidateId);
                    session.setAttribute("image", u.getImage());

                    if (role == 1) {
                        response.sendRedirect("home");
                    } else if (role == 3) {
                        response.sendRedirect("admin/report");
                    } else {
                        response.sendRedirect("home");
                    }
                } else {
                    // Đăng nhập thất bại
                    failedAttempts++;
                    session.setAttribute("failedAttempts", failedAttempts);

                    if (failedAttempts >= 5) {
                        session.setAttribute("lockTime", System.currentTimeMillis());
                        session.setAttribute("lockDuration", Math.min(lockDuration * 2, 16)); // Tăng gấp đôi thời gian khóa, tối đa 16 phút
                        response.sendRedirect("login.jsp?error=locked");
                    } else {
                        response.sendRedirect("login.jsp?error=invalid");
                    }
                }
            }
        }