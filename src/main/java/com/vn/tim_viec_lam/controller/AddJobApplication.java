package com.vn.tim_viec_lam.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name="addJobApplication",value="/account/add-job-application")
public class AddJobApplication extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        if(request.getParameter("fileId") != null){
            int fileId = Integer.parseInt(request.getParameter("fileId").toString());

            request.setAttribute("fileId", fileId);
            request.getRequestDispatcher("addProfile.jsp").forward(request, response);
        }
    }
}
