package com.vn.tim_viec_lam.controller.savingresume;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.cart.SavingResume;
import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="addResumes",value="/employer/add-resume")
public class AddResumes extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        if(request.getParameter("resumeId") != null){
            int fileId = Integer.parseInt(request.getParameter("resumeId"));

            ResumesService resumesService = new ResumesService();
            Resumes resumes = resumesService.getById(fileId);
            HttpSession session = request.getSession();
            SavingResume savingResume = (SavingResume) session.getAttribute("resumeCart");
            if(savingResume == null){
                savingResume = new SavingResume();
            }
            savingResume.addResume(resumes);
            session.setAttribute("resumeCart", savingResume);
            System.out.println(fileId);
        }
    }
}
