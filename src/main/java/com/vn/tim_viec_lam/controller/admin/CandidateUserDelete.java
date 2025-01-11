package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.CandidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "delete-user-candidate",value = "/delete-user-candidate")
public class CandidateUserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int cid = Integer.parseInt(req.getParameter("cid"));
        CandidateService candidateService = new CandidateService();
        candidateService.deleteUserCandidate(cid);
        resp.sendRedirect( "candidate-user-find");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
