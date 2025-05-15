package com.vn.tim_viec_lam.controller;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.dao.model.UserProfileDTO;
import com.vn.tim_viec_lam.service.UserProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "user-profile",value = "/user-profile")
public class UserProfile extends HttpServlet {
    private UserProfileService userProfileService = new UserProfileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = (int) request.getSession().getAttribute("userID");

        UserProfileDTO profile = userProfileService.getUserProfile(userID);
        request.getSession().setAttribute("userProfile", profile);

        // Dòng debug để kiểm tra dữ liệu userProfile trong session
        System.out.println("UserProfile in session: " + request.getSession().getAttribute("userProfile"));

        request.getRequestDispatcher("/account/account_candidate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int userID = (int) request.getSession().getAttribute("userID");
        UserProfileDTO currentProfile = (UserProfileDTO) request.getSession().getAttribute("userProfile");

        // Nếu currentProfile null thì lấy lại từ database
        if (currentProfile == null) {
            currentProfile = userProfileService.getUserProfile(userID);
            request.getSession().setAttribute("userProfile", currentProfile);
        }

        // Lấy dữ liệu từ form
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        // Lấy email từ currentProfile (không thay đổi email)
        String email = currentProfile.getEmail();
        String currentImage = currentProfile.getImage(); // giữ ảnh cũ

        // Tạo đối tượng User và Candidate cập nhật dữ liệu
        User user = new  User();
        user.setUserID(userID);
        user.setName(fullName);
        user.setPhone_number(phone);
        user.setEmail(email);
        // nếu không có upload ảnh mới thì giữ ảnh cũ
        user.setImage(currentImage);

        Candidate candidate = new Candidate();
        candidate.setUserID(userID);
        candidate.setGender(gender);
        candidate.setBirth(birth);
        candidate.setAddress(address);
        candidate.setFullName(fullName);
        candidate.setEmail(email);
        candidate.setPhone(phone);

        boolean updated = userProfileService.updateUserProfile(user, candidate);

        if (updated) {
            UserProfileDTO updatedProfile = userProfileService.getUserProfile(userID);
            request.getSession().setAttribute("userProfile", updatedProfile);

            // Cập nhật lại đối tượng `user` trong session để hiển thị tên đúng ở header
            User updatedUser = userProfileService.getUserService().getUserById(userID);
            request.getSession().setAttribute("user", updatedUser);

            response.sendRedirect(request.getContextPath() + "/user-profile");
        } else {
            request.setAttribute("error", "Cập nhật thất bại!");
            request.getRequestDispatcher("editProfile.jsp").forward(request, response);
        }
    }
}