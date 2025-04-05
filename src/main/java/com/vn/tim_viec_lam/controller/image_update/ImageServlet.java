package com.vn.tim_viec_lam.controller.image_update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {
    private final String uploadFolder = "D:/uploads";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedImage = request.getPathInfo(); // Lấy đường dẫn ảnh từ URL
        File imageFile = new File(uploadFolder, requestedImage);

        if (imageFile.exists() && !imageFile.isDirectory()) {
            response.setContentType(getServletContext().getMimeType(imageFile.getName()));
            response.setContentLengthLong(imageFile.length());

            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(imageFile));
                 BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream())) {
                byte[] buffer = new byte[8192];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
