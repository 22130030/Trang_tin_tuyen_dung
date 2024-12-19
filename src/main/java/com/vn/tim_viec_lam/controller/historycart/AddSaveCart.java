package com.vn.tim_viec_lam.controller.historycart;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.cart.HistoryCart;
import com.vn.tim_viec_lam.service.JobService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AddSaveCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        if(request.getParameter("jid") != null) {

            int id = Integer.parseInt(request.getParameter("jid"));
            JobService js = new JobService();

            Job job = js.getJobById(id);

            HttpSession session = request.getSession();

            HistoryCart historyCart = (HistoryCart) session.getAttribute("hsCart");
            if(historyCart == null) {
                historyCart = new HistoryCart();
            }
            historyCart.addJobCart(job);
            session.setAttribute("hsCart", historyCart);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }
}
