package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.service.EncryptionService;
import com.vn.tim_viec_lam.service.ResumesService;
import com.vn.tim_viec_lam.service.UserService;
import com.vn.tim_viec_lam.service.VerifycationTokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name="updateJobApplication",value="/account/update-application")
public class UpdateJobApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONObject jsonObject = new JSONObject(json);
        long fileId = jsonObject.getLong("fileId");
        int status = jsonObject.getInt("status");

        // Cập nhật trạng thái trong cơ sở dữ liệu
        ResumesService rs = new ResumesService();
        rs.updateStatus((int)fileId,status);

        // Giả sử đây là phần xử lý thành công
        resp.setContentType("application/json");
        resp.getWriter().write("{\"success\": true}");
    }

    @WebServlet(name = "UpdatePasswordServlet", value = "/update-password")
    public static class UpdatePasswordServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String token = request.getParameter("token");
            String password = request.getParameter("password");
            String retypePassword = request.getParameter("retypePassword");


            if (token == null || password == null || retypePassword == null) {
                response.sendRedirect("reset_password_login.jsp?status=invalid");
                return;
            }


            if (!password.equals(retypePassword)) {
                response.sendRedirect("reset_password_login.jsp?status=nomatch");
                return;
            }


            VerifycationTokenService tokenService = new VerifycationTokenService();
            String email = tokenService.getEmailByToken(token);


            if (email != null) {
                // Mã hóa mật khẩu mới
                String hashedPassword = EncryptionService.hasPasswordToMD5(password);


                // Cập nhật mật khẩu trong database
                UserService userService = new UserService();
                boolean updated = userService.updatePassword(email, hashedPassword);


                if (updated) {
                    response.sendRedirect("login.jsp?status=success");
                } else {
                    response.sendRedirect("reset_password_login.jsp?status=error");
                }
            } else {
                response.sendRedirect("reset_password_login.jsp?status=expired");
            }
        }
    }
}
