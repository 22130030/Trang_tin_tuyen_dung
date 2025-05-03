package com.vn.tim_viec_lam.controller.image_update;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "update-company-logo", value = "/update-company-logo")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB
public class UpdateEmployer extends HttpServlet {

    private static final String UPLOAD_FOLDER = "D:/uploads";
    private static final String[] ALLOWED_EXTENSIONS = {".png", ".jpg", ".jpeg", ".gif", ".webp"};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        int userId = (int) req.getSession().getAttribute("userID");
        Part filePart = req.getPart("uploadedImage");

        if (filePart == null || filePart.getSize() == 0) {
            resp.getWriter().write("{\"status\":\"error\",\"message\":\"Không có file được chọn.\"}");
            return;
        }

        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();

        boolean validExtension = false;
        for (String ext : ALLOWED_EXTENSIONS) {
            if (extension.equals(ext)) {
                validExtension = true;
                break;
            }
        }

        if (!validExtension) {
            resp.getWriter().write("{\"status\":\"error\",\"message\":\"Định dạng không hợp lệ!\"}");
            return;
        }

        String newFileName = "user_" + userId + "_" + System.currentTimeMillis() + extension;
        File uploadDir = new File(UPLOAD_FOLDER);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        File savedFile = new File(uploadDir, newFileName);
        filePart.write(savedFile.getAbsolutePath());

        String imagePath = "/image/" + newFileName;

        // Update DB
        UserService userService = new UserService();
        boolean isUpdated = userService.updateImage(userId, imagePath);

        if (isUpdated) {
            User updatedUser = userService.FindListUserByID(userId);
            req.getSession().setAttribute("user", updatedUser);
            req.getSession().setAttribute("image", updatedUser.getImage());

            resp.getWriter().write("{\"status\":\"success\",\"imageUrl\":\"" + req.getContextPath() + imagePath + "\"}");
        } else {
            resp.getWriter().write("{\"status\":\"error\",\"message\":\"Không thể cập nhật ảnh.\"}");
        }
    }
}
