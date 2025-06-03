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


}
