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

    // Directory to save the uploaded files
    private static final String SAVE_DIR = "D:\\Trang_tin_tuyen_dung\\src\\main\\webapp\\assets\\img";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type to JSON
        response.setContentType("application/json;charset=UTF-8");

        // Create the directory if it doesn't exist
        File fileSaveDir = new File(SAVE_DIR);
        if (!fileSaveDir.exists()) {
            boolean created = fileSaveDir.mkdirs();
            if (!created) {
                System.out.println("Không thể tạo thư mục!");
            } else {
                System.out.println("Thư mục đã được tạo!");
            }
        }

        try {
            boolean fileUploaded = false;

            // Loop through the parts (uploads) in the request
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);

                if (fileName != null && !fileName.isEmpty()) {
                    // Generate a unique filename to avoid conflicts
                    String uniqueName = System.currentTimeMillis() + "_" + fileName;

                    // Save the file
                    part.write(SAVE_DIR + File.separator + uniqueName);
                    System.out.println("✅ Ảnh đã lưu tại: " + SAVE_DIR + "\\" + uniqueName);

                    // Set response status and send success message with the image path
                    response.getWriter().write("{\"status\":\"success\",\"imageUrl\":\"/assets/img/" + uniqueName + "\"}");
                    fileUploaded = true;
                    break;  // Exit the loop after successful file upload
                }
            }

            // If no file was uploaded, send an error response
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

    // Extracts the filename from the content-disposition header of the Part
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return new File(token.substring(token.indexOf('=') + 1).replace("\"", "")).getName();
            }
        }
        return null;
    }
}
