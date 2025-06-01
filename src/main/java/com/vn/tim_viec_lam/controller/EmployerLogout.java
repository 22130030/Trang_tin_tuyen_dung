package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.service.LogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "employer_logout",value = "/employer_logout")
public class EmployerLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CompanyUser companyUser = (CompanyUser) req.getSession().getAttribute("companyUser");
        String ip = req.getRemoteAddr();

        // Ghi log logout employer
        if (companyUser != null) {
            LogService logService = new LogService();
            logService.addLogCompany(
                    companyUser,   // user
                    "employer",    // role
                    "logout",      // action
                    "local",     // loginType
                    "INFO",        // status
                    ip,
                    "Employer logout"
            );
        }
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/employer_home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
