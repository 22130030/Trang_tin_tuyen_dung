package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.service.CandidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "candidate-user-find",value = "/admin/candidate-user-find")
public class ManagerCandidate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        CandidateService service = new CandidateService();
        List<Candidate> candidateList = service.getListCandidate();
        req.setAttribute("candidateList", candidateList);
        req.getRequestDispatcher("admin_candidate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=utf-8");
        CandidateService service = new CandidateService();
        String email = req.getParameter("email");

        List<Candidate> candidateList = service.findListCandidateEmail(email);
        req.setAttribute("candidateList", candidateList);
        req.getRequestDispatcher("admin_candidate.jsp").forward(req, resp);
    }
}
