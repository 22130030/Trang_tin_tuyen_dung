package com.vn.tim_viec_lam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/uploaded-img/*")
public class ServeUploadedImage extends HttpServlet {

    // ✅ Trùng với đường dẫn lưu trong UploadBannerController
    private static final String UPLOAD_DIR = "D:/uploaded_banners";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String filename = req.getPathInfo().substring(1); // bỏ dấu /
        File file = new File(UPLOAD_DIR, filename);

        if (!file.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType = getServletContext().getMimeType(file.getName());
        resp.setContentType(contentType != null ? contentType : "application/octet-stream");
        resp.setContentLengthLong(file.length());

        Files.copy(file.toPath(), resp.getOutputStream());
    }
}
