package com.vn.tim_viec_lam.controller.admin.edit;

import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "edit-user", value = "/admin/edit/edit-user")
public class EditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserService userService = new UserService();
        int uid = Integer.parseInt(req.getParameter("userId"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int role = Integer.parseInt(req.getParameter("roleNum"));

        int status = Integer.parseInt(req.getParameter("status"));
        String image = req.getParameter("image");
        boolean res = userService.editUser(uid, email, password, role, status, image);
        if(res){
            boolean lock = false;
            if(role == 3){
                int permission = Integer.parseInt(req.getParameter("permissionId"));
                userService.updatePermissionIdForAdmin(uid,permission);

            }
            int changed = userService.updateChanged(uid,1) ? 1 : 0;
            lock = userService.getLockStatus(uid);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/manager-user");
    }
}
