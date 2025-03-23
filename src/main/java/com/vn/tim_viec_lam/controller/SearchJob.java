package com.vn.tim_viec_lam.controller;

import com.google.gson.Gson;
import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(name = "search-job", value = "/search-job")
public class SearchJob extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SearchJob.class.getName());
    private final JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String query = request.getParameter("searchName");
        String addressQuery = request.getParameter("searchAddress");

        if ((query != null && !query.isEmpty()) || (addressQuery != null && !addressQuery.isEmpty())) {
            handleSuggestions(request, response, query, addressQuery);
            return;
        }

        String title = "";
        List<Job> jobList = null;

        try {
            jobList = getJobsByRequest(request);
            title = getTitleByRequest(request);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Lỗi chuyển đổi số: {0}", e.getMessage());
            request.setAttribute("error", "Tham số không hợp lệ");
        }

        request.setAttribute("jobs", jobList);
        request.setAttribute("title", title);
        request.setAttribute("size", (jobList != null) ? jobList.size() : 0);

        request.getRequestDispatcher("search_job.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String txtSearch = request.getParameter("searchName");
        String txtAddress = request.getParameter("searchAddress");

        List<Job> jobs = jobService.getListSearchJob(txtSearch, txtAddress);
        request.setAttribute("jobs", jobs);
        request.setAttribute("size", (jobs != null) ? jobs.size() : 0);
        request.setAttribute("title", " cho kết quả tìm kiếm");

        request.getRequestDispatcher("search_job.jsp").forward(request, response);
    }

    private List<Job> getJobsByRequest(HttpServletRequest request) {
        if (request.getParameter("cid") != null) {
            int id = Integer.parseInt(request.getParameter("cid"));
            return jobService.getJobByJobPostCategoryId(id);
        } else if (request.getParameter("location") != null) {
            return jobService.getJobsByAddress(request.getParameter("location"));
        } else if (request.getParameter("show-all") != null) {
            return jobService.getAllJob();
        } else if (request.getParameter("all-newJob") != null) {
            return jobService.getAllNewJob();
        } else if (request.getParameter("jcid") != null) {
            int id = Integer.parseInt(request.getParameter("jcid"));
            return jobService.getJobByCategoryId(id);
        }
        return null;
    }

    private String getTitleByRequest(HttpServletRequest request) {
        if (request.getParameter("cid") != null) {
            return " cho " + request.getParameter("name");
        } else if (request.getParameter("location") != null) {
            return " tại " + request.getParameter("location");
        } else if (request.getParameter("all-newJob") != null) {
            return " mới nhất";
        } else if (request.getParameter("jcid") != null) {
            return " cho ngành " + request.getParameter("jcname");
        }
        return "";
    }

    private void handleSuggestions(HttpServletRequest request, HttpServletResponse response, String query, String addressQuery) throws IOException {
        Set<String> allTitles = jobService.getAllJob().stream()
                .map(Job::getTitle)
                .collect(Collectors.toSet());

        List<Job> allJobs = jobService.getAllJob(); // Lấy tất cả công việc để kiểm tra

        Set<String> allCities = allJobs.stream()
                .map(Job::getCity) // Sử dụng Job::getCity() thay vì Job::getAddress()
                .collect(Collectors.toSet());

        // Gỡ lỗi: In ra tất cả thành phố và công việc
        LOGGER.info("All Cities: " + allCities.toString());
        LOGGER.info("All Jobs: " + allJobs.toString());

        List<String> suggestions = new ArrayList<>();

        if (query != null && !query.isEmpty()) {
            suggestions.addAll(allTitles.stream()
                    .filter(title -> title.toLowerCase().contains(query.toLowerCase()))
                    .sorted((s1, s2) -> {
                        boolean s1ContainsNhanVien = s1.toLowerCase().contains("nhân viên");
                        boolean s2ContainsNhanVien = s2.toLowerCase().contains("nhân viên");

                        if (query.equalsIgnoreCase("nh") || query.toLowerCase().startsWith("nh")) {
                            if (s1ContainsNhanVien && !s2ContainsNhanVien) return -2;
                            if (!s1ContainsNhanVien && s2ContainsNhanVien) return 2;
                        }
                        return s1.compareToIgnoreCase(s2);
                    })
                    .collect(Collectors.toList()));
        }

        if (addressQuery != null && !addressQuery.isEmpty()) {
            suggestions.addAll(allCities.stream()
                    .filter(city -> city.toLowerCase().contains(addressQuery.toLowerCase())) // Sử dụng city thay vì address
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList()));
        }

        //Remove duplicates
        Set<String> uniqueSuggestions = new HashSet<>(suggestions);
        List<String> finalSuggestions = new ArrayList<>(uniqueSuggestions);

        String json = new Gson().toJson(finalSuggestions);

        // Gỡ lỗi: In ra kết quả cuối cùng
        LOGGER.info("Final Suggestions: " + finalSuggestions.toString());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}