package com.vn.tim_viec_lam.controller.google;

import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "login-by-google",value = "/login-by-google")
public class CandiateLoginGG extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String rePassword = req.getParameter("repassword");

        HttpSession s = req.getSession(true);
        String mail =(String) s.getAttribute("email");
        String fname =(String) s.getAttribute("fName");
        String auth_provider =(String) s.getAttribute("auth_provider");
        UserService userService = new UserService();
        boolean res = false;
        if(auth_provider.equals("google")){
            res = userService.insetUser(mail, EncryptionService.hasPasswordToMD5(password),EncryptionService.hasPasswordToMD5(rePassword),fname,"003939394","google","");

        }
        if(auth_provider.equals("facebook")){
            String providerId = (String) s.getAttribute("providerId");
            res = userService.insetUser(mail, EncryptionService.hasPasswordToMD5(password),EncryptionService.hasPasswordToMD5(rePassword),fname,"003939394","facebook",providerId);

        }
        s.invalidate();
        if(res){
            HttpSession session = req.getSession(true);
            if(session == null){
                System.out.println("session is null");
            }
            User u = userService.getUser(mail);
            int role = u.getRoleNum();
            CandidateService cs = new CandidateService();
            int candidateId = cs.getCandidateIdByUserId(u.getUserID());
            List<JobApplication> jobApplicationList = new JobApplicationService().getAll();
            List<Resumes> resumesList = new ResumesService().getResumes(candidateId);

            session.setAttribute("user", u);
            session.setAttribute("jobAppliedCart", jobApplicationList);
            session.setAttribute("jac", resumesList);
            session.setAttribute("role", role);
            session.setAttribute("status",u.getStatus());
            session.setAttribute("userID",u.getUserID());
            session.setAttribute("candidateId", candidateId);
            System.out.println("đăng ký thành công");
            resp.sendRedirect("home");


        }
    }
}
