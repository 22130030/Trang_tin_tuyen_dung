package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.LogWork;
import com.vn.tim_viec_lam.service.LogWorkService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "get-log-work",value = "/admin/get-log-works")
public class LogWorkController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        LogWorkService logWorkService = new LogWorkService();
        List<LogWork> logWorks = logWorkService.getAll();

        req.setAttribute("logWorks",logWorks);
        req.getRequestDispatcher("log_work.jsp").forward(req,resp);
    }
}
