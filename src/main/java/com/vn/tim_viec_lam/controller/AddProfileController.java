package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(name = "addProfile", value = "/account/add-profile")
public class AddProfileController extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        String title = request.getParameter("profile-title");
        int birthYear =  Integer.parseInt(request.getParameter("birth-year"));
        String marital = request.getParameter("marital-status");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String education = request.getParameter("education-level");
        String schoolName = request.getParameter("school-name");
        String salary = request.getParameter("expected-salary");
        String career = request.getParameter("career");

        ResumesService rs = new ResumesService();
        int fileId = request.getParameter("fileId") != null ?  Integer.parseInt(request.getParameter("fileId")) : 1;
        System.out.println(fileId);
        rs.updateProfile(fileId,title,birthYear,marital,address,education,schoolName,salary,career,gender);


        request.getRequestDispatcher("job_application.jsp").forward(request, response);
    }
}
