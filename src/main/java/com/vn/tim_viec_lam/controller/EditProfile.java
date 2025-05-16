package com.vn.tim_viec_lam.controller;


import com.vn.tim_viec_lam.dao.model.UserProfileDTO;
import com.vn.tim_viec_lam.service.UserProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="editProfile",value="/editProfile")
public class EditProfile extends HttpServlet {
    private UserProfileService userProfileService = new UserProfileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object userIdObj = request.getSession().getAttribute("userID");
        if (userIdObj == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        int userId = (int) userIdObj;

        UserProfileDTO profileDTO = userProfileService.getUserProfile(userId);
        request.setAttribute("userProfile", profileDTO);
        request.getRequestDispatcher("editProfile.jsp").forward(request, response);
    }
}
