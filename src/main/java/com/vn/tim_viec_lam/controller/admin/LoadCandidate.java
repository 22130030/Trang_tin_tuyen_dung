package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.CandidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "load-user-candidate",value = "/admin/load-user-candidate")
public class LoadCandidate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("cid"));
        CandidateService candidateService = new CandidateService();
        candidateService.loadUserCandidate(id);
        req.setAttribute("load",candidateService.loadUserCandidate(id));
        req.getRequestDispatcher("edit_user_candidate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
