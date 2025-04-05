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

        @WebServlet(name="update-candidate", value="/update-candidate")
        @MultipartConfig(maxFileSize = 1024 * 1024)
        public class UpdateCandidate extends HttpServlet {
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setCharacterEncoding("UTF-8");
                int userId = (int) req.getSession().getAttribute("userID");

                Part filePart = req.getPart("uploadedImage");
                String imagePath = null;

                if (filePart != null && filePart.getSize() > 0) {
                    // Tạo tên file mới
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String extension = fileName.substring(fileName.lastIndexOf('.'));
                    String newFileName = "user_" + userId + "_" + System.currentTimeMillis() + extension;

                    // Lưu ảnh vào thư mục cố định (ví dụ: ổ D)
                    String uploadPath = "D:/uploads"; // chỉnh lại thư mục ổn định
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) uploadDir.mkdirs();

                    String fullPath = uploadPath + File.separator + newFileName;
                    filePart.write(fullPath);

                    imagePath = "/image/" + newFileName; // Lưu đường dẫn ảnh tương đối vào DB

                    // Cập nhật database
                    UserService userService = new UserService();
                    boolean isUpdated = userService.updateImage(userId, imagePath);

                    if (isUpdated) {
                        User updatedUser = userService.FindListUserByID(userId);
                        req.getSession().setAttribute("user", updatedUser);
                        req.getSession().setAttribute("image", updatedUser.getImage());
                    }
                }
                resp.sendRedirect(req.getContextPath() + "/account/account_candidate.jsp");
            }
        }
