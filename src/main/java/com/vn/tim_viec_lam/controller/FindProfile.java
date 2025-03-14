package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name="findProfile",value="/employer/find-profile")
public class FindProfile extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        ResumesService rs = new ResumesService();
        List<Resumes> resumesList = new ArrayList<>();

        resumesList = rs.getResumesByStatus();

        request.setAttribute("resumesList", resumesList);
        request.getRequestDispatcher("findResumes_employer.jsp").forward(request, response);
    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        if(request.getParameter("titleInput") != null || request.getParameter("addressInput") != null){
            ResumesService rs = new ResumesService();
            List<Resumes> resumesList = new ArrayList<>();
            String title = request.getParameter("titleInput");
            String address = request.getParameter("addressInput");
            resumesList = rs.findResumesByNameOrAddress(title,address);

            request.setAttribute("resumesList", resumesList);
            request.getRequestDispatcher("findResumes_employer.jsp").forward(request, response);
        }

    }
}
