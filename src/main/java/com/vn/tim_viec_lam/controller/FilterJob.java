package com.vn.tim_viec_lam.controller;

import com.google.gson.JsonObject;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.JobPostCategory;
import com.vn.tim_viec_lam.service.CategoryService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="filterJob",value = "/employer/filter-job")
public class FilterJob extends HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        response.setContentType("application/json");
        String jobName = request.getParameter("jobName");
//        String jobStatus = request.getParameter("jobStatus");
        String jobCategory = request.getParameter("jobCategory");
        String jobLocation = request.getParameter("jobLocation");

        JobService js = new JobService();
        List<Job> jobList = null;
        // Kiểm tra và lọc jobList nếu có tham số tìm kiếm
//        if (jobName != null || jobCategory != null || jobLocation != null) {
            jobList = js.filterJob(jobName, jobCategory, jobLocation);
//            System.out.println(1);
//        }
        System.out.println(jobName + " " + jobCategory + " " + jobLocation);
        System.out.println(jobList.size());

        CategoryService cs = new CategoryService();
        List<JobPostCategory> categoryList = cs.getAllCategories();

        JSONObject resultObj = new JSONObject();
        // Add filtered job list to the response as JSON
        JSONArray result = new JSONArray();
        for (Job job : jobList) {
            JSONObject jobJson = new JSONObject();
            jobJson.put("jobId", job.getId());
            jobJson.put("title", job.getTitle());
            jobJson.put("city", job.getCity());
            jobJson.put("created", job.getConvertCreated());
            System.out.println(job.getId() + " " + job.getTitle() + " " + job.getCity());
            result.put(jobJson);
        }
        JSONArray categories = new JSONArray();
        for(JobPostCategory category : categoryList){
            JSONObject jobCategoryJson = new JSONObject();
            jobCategoryJson.put("category",category.getName());
            categories.put(jobCategoryJson);
        }
        resultObj.put("result", result);
        resultObj.put("categories", categories);

        PrintWriter out = response.getWriter();
        out.print(resultObj.toString());
        out.flush();

    }
}
