package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "search-job", value = "/search-job")
public class SearchJob extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        List<Job> jobList = null;
        String title = "";
        int size = 0;

        JobService jobService = new JobService(); // Tạo một instance duy nhất

        try {
            if (request.getParameter("cid") != null) {
                int id = Integer.parseInt(request.getParameter("cid"));
                String name = request.getParameter("name");
                title = " cho " + name;
                jobList = jobService.getJobByJobPostCategoryId(id);

            } else if (request.getParameter("location") != null) {
                String location = request.getParameter("location");
                title = " tại " + location;
                jobList = jobService.getJobsByAddress(location);

            } else if (request.getParameter("show-all") != null) {
                jobList = jobService.getAllJob();

            } else if (request.getParameter("all-newJob") != null) {
                title = " mới nhất";
                jobList = jobService.getAllNewJob();

            } else if (request.getParameter("jcid") != null) {
                int id = Integer.parseInt(request.getParameter("jcid"));
                String name = request.getParameter("jcname");
                title = " cho ngành " + name;
                jobList = jobService.getJobByCategoryId(id);
            }

            if (jobList != null) {
                size = jobList.size();
            }

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu tham số không phải số
            request.setAttribute("error", "Tham số không hợp lệ");
        }

        // Đặt các thuộc tính request
        request.setAttribute("jobs", jobList);
        request.setAttribute("title", title);
        request.setAttribute("size", size);

        // Điều hướng tới JSP
        request.getRequestDispatcher("search_job.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String txtSearch = request.getParameter("searchName");
        String txtAddress = request.getParameter("searchAddress");

        JobService jobService = new JobService();
        List<Job> jobs = jobService.getListSearchJob(txtSearch, txtAddress);

        int size = (jobs != null) ? jobs.size() : 0;
        String title = " cho kết quả tìm kiếm";

        // Đặt các thuộc tính request
        request.setAttribute("size", size);
        request.setAttribute("title", title);
        request.setAttribute("jobs", jobs);

        // Điều hướng tới JSP
        request.getRequestDispatcher("search_job.jsp").forward(request, response);
    }
}
