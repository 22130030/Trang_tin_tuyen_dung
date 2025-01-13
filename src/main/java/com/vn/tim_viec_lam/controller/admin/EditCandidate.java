package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.service.CandidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "update_candidate",value = "/update_candidate")
public class EditCandidate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("id"));
        String cname = req.getParameter("name");
        String cemail = req.getParameter("email");
        String cphone = req.getParameter("phone");
        String cstatus = req.getParameter("status");
        CandidateService service = new CandidateService();
        service.editUserCandidate(cid,cname,cemail,cphone,cstatus);
        resp.sendRedirect("candidate-user-find");
    }
}
