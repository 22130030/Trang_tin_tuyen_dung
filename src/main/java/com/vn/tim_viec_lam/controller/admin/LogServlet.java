package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.LogDao;
import com.vn.tim_viec_lam.dao.model.UserLog;
import com.vn.tim_viec_lam.service.LogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "log", value = "/admin/log")
public class LogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        LogService logService = new LogService();
        List<UserLog> logs = logService.getListLog();

        req.setAttribute("log", logs); // Đẩy danh sách log sang JSP
        req.getRequestDispatcher("log.jsp").forward(req, resp); // Forward tới trang JSP hiển thị log
    }
}
