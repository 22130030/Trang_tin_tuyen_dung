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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(name = "search-job", value = "/search-job")
public class SearchJob extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SearchJob.class.getName());
    private final JobService jobService = new JobService(); // Có thể thay bằng DI

    // Danh sách gợi ý tìm kiếm tổng quát
    private final List<String> allSuggestions = Arrays.asList(
            "lập trình viên",
            "kế toán",
            "bán hàng",
            "marketing",
            "thiết kế đồ họa",
            "quản lý dự án",
            "nhân sự",
            "kỹ sư",
            "chăm sóc khách hàng",
            "nhân viên kế toán",
            "nhân viên bán hàng",
            "nhân viên marketing",
            "nhân viên IT",
            "nhân viên kho",
            "trưởng phòng kinh doanh",
            "kỹ sư phần mềm",
            "chuyên viên tuyển dụng",
            "thực tập sinh marketing",
            "nhân viên chăm sóc khách hàng"
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String query = request.getParameter("searchName");
        if (query != null && !query.isEmpty()) {
            handleSuggestions(request, response, query);
            return; // Dừng xử lý nếu là yêu cầu gợi ý
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

    // Xử lý gợi ý tìm kiếm
    private void handleSuggestions(HttpServletRequest request, HttpServletResponse response, String query) throws IOException {
        List<String> suggestions = allSuggestions.stream()
                .filter(suggestion -> suggestion.toLowerCase().contains(query.toLowerCase()))
                .sorted((s1, s2) -> {
                    boolean s1ContainsNhanVien = s1.toLowerCase().contains("nhân viên");
                    boolean s2ContainsNhanVien = s2.toLowerCase().contains("nhân viên");

                    // Nếu nhập "n" hoặc bắt đầu bằng "n", ưu tiên hiển thị các gợi ý có "nhân viên"
                    if (query.equalsIgnoreCase("nhân") || query.toLowerCase().startsWith("nhân")) {
                        if (s1ContainsNhanVien && !s2ContainsNhanVien) return -1;
                        if (!s1ContainsNhanVien && s2ContainsNhanVien) return 1;
                    }
                    return s1.compareToIgnoreCase(s2);
                })
                .collect(Collectors.toList());

        String json = new Gson().toJson(suggestions);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
