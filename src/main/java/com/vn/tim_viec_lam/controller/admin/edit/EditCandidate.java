package com.vn.tim_viec_lam.controller.admin.edit;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.dao.model.LogWork;
import com.vn.tim_viec_lam.service.CandidateService;
import com.vn.tim_viec_lam.service.LogWorkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "update_candidate",value = "/admin/edit/update_candidate")
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
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birth");

//        log
        HttpSession session = req.getSession(false);
        int userId = (int)session.getAttribute("userID");

        CandidateService service = new CandidateService();

        Candidate candidateOld = service.loadUserCandidate(cid);
        Candidate candidateNew = new Candidate();
        candidateNew.setCandidateID(cid);
        candidateNew.setFullName(cname);
        candidateNew.setEmail(cemail);
        candidateNew.setPhone(cphone);
        candidateNew.setStatus(cstatus);
        candidateNew.setGender(gender);
        candidateNew.setBirth(birthday);

        LogWorkService logWorkService = new LogWorkService();
        LogWork logWork = new LogWork(userId,"edit",candidateOld.toString(),candidateNew.toString());

        boolean  res = logWorkService.insertLogWork(logWork);
        if(res)
            System.out.println("insert success");

        service.editUserCandidate(cid,cname,cemail,cphone,cstatus,gender,birthday);
        resp.sendRedirect(req.getContextPath() + "/admin/candidate-user-find");
    }
}
