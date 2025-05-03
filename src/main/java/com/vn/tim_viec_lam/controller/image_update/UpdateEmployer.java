package com.vn.tim_viec_lam.controller.image_update;

import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/upload-avatar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class UpdateEmployer extends HttpServlet {

    private static final String UPLOAD_DIR = "D:/uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userID") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bạn chưa đăng nhập.");
            return;
        }

        int userId = (int) session.getAttribute("userID");

        Part filePart = req.getPart("uploadedImage");
        if (filePart == null || filePart.getSize() == 0) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không có ảnh được gửi lên.");
            return;
        }

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        String newFileName = "user_" + userId + "_" + System.currentTimeMillis() + extension;

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String fullPath = UPLOAD_DIR + File.separator + newFileName;
        filePart.write(fullPath);

        String imagePath = "/image/" + newFileName;

        UserService userService = new UserService();
        boolean isUpdated = userService.updateImage(userId, imagePath);

        if (isUpdated) {
            User updatedUser = userService.FindListUserByID(userId);
            session.setAttribute("user", updatedUser);
            session.setAttribute("image", updatedUser.getImage());
        }

        // Trả về trang cũ hoặc JSON (tùy frontend)
        resp.sendRedirect(req.getContextPath() + "/employer_see.jsp");
    }
}
