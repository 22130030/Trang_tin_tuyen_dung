package com.vn.tim_viec_lam.controller;

import com.mysql.cj.xdevapi.JsonArray;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.ResumesService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name="filterProfile",value="/employer/filter-profile")
public class FilterProfile extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {

    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve parameters from the request
        String industry = request.getParameter("industry");
        String salary = request.getParameter("salary");
        String education = request.getParameter("education");
        String school = request.getParameter("school");
        String gender = request.getParameter("gender");
        String maritalStatus = request.getParameter("maritalStatus");
        String age = request.getParameter("age");

        ResumesService rs = new ResumesService();
        List<Resumes> resumesList = rs.filterResume(industry,salary,education,school,gender,maritalStatus,age);
        JSONObject resultObj = new JSONObject();

        JSONArray result = new JSONArray();
        for(Resumes resume : resumesList){
            JSONObject resumeObj = new JSONObject();
            resumeObj.put("id",resume.getId());
            resumeObj.put("title",resume.getTitle());
            resumeObj.put("address",resume.getAddress());
            resumeObj.put("industry",resume.getCareer());
            resumeObj.put("salary",resume.getSalary());
            resumeObj.put("encodingPath",resume.getEncodingPath());
            resumeObj.put("education",resume.getEducation());
            resumeObj.put("school",resume.getSchoolName());
            resumeObj.put("gender",resume.getGender());
            resumeObj.put("marital",resume.getMarital());
            resumeObj.put("age",resume.getBirthYear());
            resumeObj.put("type",resume.getType());
            result.put(resumeObj);
        }
        resultObj.put("result",result);
        response.getWriter().write(resultObj.toString());

    }
}
