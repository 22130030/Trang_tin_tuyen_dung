package com.vn.tim_viec_lam.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name="editJobApplication",value="/account/edit-job-application")
public class EditJobApplication extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        if(request.getParameter("fileId") != null && request.getParameter("fileName") != null){
            int fileId = Integer.parseInt(request.getParameter("fileId").toString());
            String fileName = request.getParameter("fileName");

            request.setAttribute("fileId", fileId);
            request.setAttribute("fileName", fileName);
            request.getRequestDispatcher("addProfile.jsp").forward(request, response);
        }
    }
}
