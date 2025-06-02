package com.vn.tim_viec_lam.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(urlPatterns = {
        "/admin/edit/*",
        "/admin/add/*",
        "/admin/delete/*"
})
public class PermissionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        // Không có session hoặc chưa đăng nhập
        if (session == null || session.getAttribute("permissionId") == null) {
            rsp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        int permissionId = (int) session.getAttribute("permissionId");

        if (permissionId == 7) {
            chain.doFilter(request, response);
            return;
        }

        boolean hasPermission = false;
        if (uri.contains("/admin/edit")) {
            hasPermission = (permissionId == 1 || permissionId == 3 || permissionId == 5);
        } else if (uri.contains("/admin/add")) {
            hasPermission = (permissionId == 2 || permissionId == 3 || permissionId == 6);
        } else if (uri.contains("/admin/delete")) {
            hasPermission = (permissionId == 4 || permissionId == 5 || permissionId == 6);
        }
        System.out.println(hasPermission);
        if (hasPermission) {
            chain.doFilter(request, response);
        } else {
            // Không đủ quyền
            req.setAttribute("message", "Bạn không có quyền thực hiện chức năng này.");
            req.getRequestDispatcher("/admin/access-denied.jsp").forward(req, rsp);
        }
    }
}
