package com.vn.tim_viec_lam.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

    @WebFilter(urlPatterns = {"/account/*",
            "/admin/*",
            "/employer/*"
    })
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rsp = (HttpServletResponse) response;
        response.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        if(uri.contains("/account/") || uri.contains("/admin/")) {
            if (session == null || session.getAttribute("user") == null) {
                if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
                    rsp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
                    rsp.getWriter().write("{\"message\": \"Unauthorized\"}");
                } else {
                    rsp.sendRedirect(req.getContextPath() + "/login.jsp");
                }
                return;
            }else {
                Integer role = (Integer) session.getAttribute("role");
                if (uri.contains("/account/") && role != 1) { // Candidate
                    rsp.sendRedirect(req.getContextPath() + "/login.jsp");
                } else if (uri.contains("/admin/") && role != 3) { // Admin
                    rsp.sendRedirect(req.getContextPath() + "/login.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
        if(uri.contains("/employer/")) {
            if (session == null || session.getAttribute("companyUser") == null) {
                rsp.sendRedirect(req.getContextPath() + "/employer_home.jsp");
                return;
            }
            else{
                int role = (Integer) session.getAttribute("role");
                if(role != 2) {
                    rsp.sendRedirect(req.getContextPath() + "/employer_home.jsp");
                }
                else {
                    chain.doFilter(request, response);
                }
            }
        }


    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
