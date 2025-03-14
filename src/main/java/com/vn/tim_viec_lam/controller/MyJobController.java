package com.vn.tim_viec_lam.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "myJobController", value = "/employer/myJob-controller")
public class MyJobController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        CompanyUser user = (CompanyUser) session.getAttribute("companyUser");
        int companyId = user.getCompanyID();
        JobService js = new JobService();
        CategoryService cs = new CategoryService();

        List<Job> jobList = js.getJobByCompanyId(companyId);
        List<JobPostCategory> categoryList = cs.getAllCategories();


        request.setAttribute("jobList", jobList);
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("myJob_employer.jsp").forward(request, response);
    }
}
