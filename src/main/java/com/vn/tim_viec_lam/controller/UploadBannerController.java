package com.vn.tim_viec_lam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "UploadBannerController", value = "/upload-banner-img")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 5 * 1024 * 1024,   // 5MB
        maxRequestSize = 10 * 1024 * 1024 // 10MB
)
public class UploadBannerController extends HttpServlet {

    // ✅ Thư mục lưu file ngoài project (vĩnh viễn)
    private static final String UPLOAD_DIR = "D:/uploaded_banners";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            System.out.println(created ? "📁 Đã tạo thư mục: " + UPLOAD_DIR : "❌ Không thể tạo thư mục!");
        }

        try {
            boolean fileUploaded = false;

            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);

                if (fileName != null && !fileName.isEmpty()) {
                    String extension = getFileExtension(fileName).toLowerCase();

                    if (!extension.matches("png|jpg|jpeg|gif|webp")) {
                        response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                        response.getWriter().write("{\"status\":\"error\",\"message\":\"Chỉ chấp nhận file ảnh PNG, JPG, JPEG, GIF, WEBP!\"}");
                        return;
                    }

                    String uniqueName = System.currentTimeMillis() + "_" + fileName;
                    String fullPath = UPLOAD_DIR + File.separator + uniqueName;

                    part.write(fullPath);
                    System.out.println("✅ Ảnh đã lưu tại: " + fullPath);

                    // ✅ Trả về URL truy cập qua servlet
                    String imageUrl = request.getContextPath() + "/uploaded-img/" + uniqueName;

                    request.getSession().setAttribute("companyBanner", "/uploaded-img/" + uniqueName);

                    response.getWriter().write("{\"status\":\"success\",\"imageUrl\":\"" + imageUrl + "\"}");

                    fileUploaded = true;
                    break;
                }
            }

            if (!fileUploaded) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"status\":\"error\",\"message\":\"Không có file nào được gửi lên!\"}");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\":\"error\",\"message\":\"Lỗi khi upload ảnh.\"}");
        }
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return new File(token.substring(token.indexOf('=') + 1).replace("\"", "")).getName();
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        }
        return "";
    }
}
