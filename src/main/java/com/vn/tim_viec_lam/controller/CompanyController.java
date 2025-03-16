package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Company;
import com.vn.tim_viec_lam.service.CompanyService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "company",value = "/company")
public class CompanyController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        CompanyService cs = new CompanyService();
        List<Company> companies = cs.getAllCompany();

        int size = companies.size();

        request.setAttribute("companies",companies);
        request.setAttribute("size",size);
        request.setAttribute("c",companies);
        System.out.println(companies.size());
        request.getRequestDispatcher("company.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("txtName")!=null){

            CompanyService cs = new CompanyService();
            String companyName = request.getParameter("txtName");
            List<Company> companies = cs.getCompanyByName(companyName);

            int size = companies.size();

            request.setAttribute("companies",companies);
            request.setAttribute("size",size);
        }
        request.getRequestDispatcher("company.jsp").forward(request,response);
    }
}
