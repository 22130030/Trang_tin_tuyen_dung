package com.vn.tim_viec_lam.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/account/*",
//        "/admin/*",
//        "/employer/*"
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
        String uri = req.getRequestURI();
            HttpSession session = req.getSession();

            if(session == null || session.getAttribute("user") == null) {
                if(uri.contains("/account/")){
                    if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
                        rsp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
                        rsp.getWriter().write("{\"message\": \"Unauthorized\"}");
                    }else {
                        rsp.sendRedirect(req.getContextPath() + "/login.jsp");

                    }
                }
//                } else if (uri.contains("/employer/")) {
////                    rsp.sendRedirect(req.getContextPath() + "/employer/employer_home.jsp");
//                }
            }else{
                    chain.doFilter(request, response);
            }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
