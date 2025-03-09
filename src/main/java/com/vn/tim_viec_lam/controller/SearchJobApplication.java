package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.service.FileService;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "searchJobApplication", value = "/employer/search-job-application")
public class SearchJobApplication extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SearchJobApplication.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        FileService fileService = new FileService();
        JobService jobService = new JobService();

        try {
            // Lấy jobId từ request (nếu có)
            int jobId = Optional.ofNullable(request.getParameter("jobId"))
                    .map(Integer::parseInt)
                    .orElse(0);

            // Lấy companyId từ session (giả sử tạm thời là 1)
            int companyId = 1;
            List<Job> jobs = jobService.getJobByCompanyId(companyId);
            List<Resumes> files = (jobId > 0) ? fileService.getFiles(jobId) : List.of();

            // Xử lý phân trang
            int page = Optional.ofNullable(request.getParameter("page"))
                    .map(Integer::parseInt)
                    .orElse(1);
            int pageSize = 10; // Số lượng ứng dụng trên mỗi trang
            int totalRecords = files.size();
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
            int fromIndex = (page - 1) * pageSize;
            int toIndex = Math.min(fromIndex + pageSize, totalRecords);
            List<Resumes> paginatedFiles = files.subList(fromIndex, toIndex);

            request.setAttribute("files", paginatedFiles);
            request.setAttribute("jobs", jobs);
            request.setAttribute("selectedJobId", jobId);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("jobApplication_letter.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing request", e);
            request.setAttribute("errorMessage", "Có lỗi xảy ra, vui lòng thử lại sau.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
