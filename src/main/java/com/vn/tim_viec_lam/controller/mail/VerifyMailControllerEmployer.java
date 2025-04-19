package com.vn.tim_viec_lam.controller.mail;

import com.vn.tim_viec_lam.service.CompanyUserService;
import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "verify-email-employer", value = "/verify-email-employer")
public class VerifyMailControllerEmployer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String tokenFromMail = req.getParameter("token");
        int id = Integer.parseInt(req.getParameter("key"));

        VerifycationTokenService verifycationTokenService = new VerifycationTokenService();
        String tokenSystem = verifycationTokenService.getTokenById(id);

        if (tokenSystem != null && tokenSystem.equals(tokenFromMail)) {
            HttpSession session = req.getSession(false);

            if (session == null) {
                resp.getWriter().println("Phiên làm việc đã hết hạn.");
                return;
            }

            String email = (String) session.getAttribute("email");
            String name = (String) session.getAttribute("fName");
            String password = (String) session.getAttribute("password");
            String rePassword = (String) session.getAttribute("rePassword");
            String companyName = (String) session.getAttribute("companyName");
            String phone = (String) session.getAttribute("phone");
            String address = (String) session.getAttribute("address");

            CompanyUserService companyUserService = new CompanyUserService();
            System.out.println(">>> GỌI CompanyUserService.insertEmployer() <<<");
            boolean res = companyUserService.insetUserEmployer(email, name, password, rePassword, companyName, phone, address);

            if (res) {
                session.invalidate();
                System.out.println(" Đăng ký employer thành công");
                resp.sendRedirect("employer_home.jsp?verify=success");
            } else {
                resp.getWriter().println(" Đăng ký thất bại, vui lòng thử lại.");
            }
        } else {
            System.out.println(" Token không đúng hoặc hết hạn");
            resp.getWriter().println(" Token không hợp lệ hoặc đã hết hạn.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Không dùng POST
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST không được hỗ trợ.");
    }
}

