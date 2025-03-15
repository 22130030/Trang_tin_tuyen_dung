package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "add-job-posting", value = "/employer/add-job-posting")
public class AddJobPosting extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        int companyId = (int) session.getAttribute("companyId");

        String companyName = request.getParameter("companyName");
        String employerSize = request.getParameter("employerSize");
        String website = request.getParameter("website");
        String jobName = request.getParameter("jobName");
        String jobAddress = request.getParameter("jobAddress");

        String salaryType = request.getParameter("salary-type");
        String salaryValue = "";
        String salaryUnit = "";
        // Xử lý dựa trên loại lương
        if ("nhap".equals(salaryType) || "hon".equals(salaryType)) {
            salaryValue = request.getParameter("salary-value");
            salaryUnit = request.getParameter("salary-unit");
        }
        String educationLevel = request.getParameter("educationLevel");
        String experienceLevel = request.getParameter("experienceLevel");
        String jobType = request.getParameter("jobType");
        String jobLocation = request.getParameter("location");
        String jobCategory = request.getParameter("jobCategory");
        String keywords = request.getParameter("keywords");
        String age = request.getParameter("age");
        String contactName = request.getParameter("contactName");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String contactAddress  = request.getParameter("contactAddress");
        String jobPostingDate = request.getParameter("jobPostingDate");
        String JobExpiryDate = request.getParameter("JobExpiryDate");
        String language = request.getParameter("language");

        JobService js = new JobService();
        boolean res = js.addJobPosting(companyId,companyName,employerSize,website,jobName,jobAddress,salaryValue,salaryUnit,educationLevel,experienceLevel,jobType,jobLocation,jobCategory,keywords,age,contactName,contactEmail,contactPhone,contactAddress,jobPostingDate,JobExpiryDate,language);

        request.getRequestDispatcher("employer.jsp").forward(request,response);


    }
}
