package com.vn.tim_viec_lam.controller.log;

import com.vn.tim_viec_lam.dao.model.LogResume;
import com.vn.tim_viec_lam.service.LogResumeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "log-resume",value = "/account/log-resume")
public class LogResumeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("resumeId") != null){

            int resumeId = Integer.parseInt(req.getParameter("resumeId"));
            String title = req.getParameter("title")!=null ? req.getParameter("title") : "";
            LogResumeService logResumeService = new LogResumeService();
            List<LogResume>  resumeLogs = logResumeService.getAllLogResumeById(resumeId);

            req.setAttribute("resumeLogs",resumeLogs);
            req.setAttribute("title",title);
            req.getRequestDispatcher("resume_log.jsp").forward(req, resp);
        }
    }
}
