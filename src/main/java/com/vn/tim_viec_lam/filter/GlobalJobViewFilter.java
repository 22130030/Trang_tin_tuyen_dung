package com.vn.tim_viec_lam.filter;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.HistoryCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = {"/*"})
public class GlobalJobViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String uri = httpRequest.getRequestURI();
        if(uri.endsWith("/job-detail")){

            if(request.getParameter("jid") != null) {

                int id = Integer.parseInt(request.getParameter("jid"));
                JobService js = new JobService();

                Job job = js.getJobById(id);

                HttpSession session = httpRequest.getSession();

                HistoryCart historyCart = (HistoryCart) session.getAttribute("hsCart");
                if(historyCart == null) {
                    historyCart = new HistoryCart();
                }
                historyCart.addJobCart(job);
                session.setAttribute("hsCart", historyCart);
                }

        }
        chain.doFilter(request, response);
    }



    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
