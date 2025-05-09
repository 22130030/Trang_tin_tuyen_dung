package com.vn.tim_viec_lam.controller.payment;

import com.vn.tim_viec_lam.dao.model.PaymentHistory;
import com.vn.tim_viec_lam.service.PaymentHistoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "get-payment-history",value = "/account/get-payment-history")
public class GetPaymentHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession(false);
        if(session.getAttribute("user") != null){
            int userId = (int)session.getAttribute("userID");
            PaymentHistoryService paymentHistoryService = new PaymentHistoryService();
            List<PaymentHistory> paymentHistory = paymentHistoryService.getPaymentHistory(userId);

            req.setAttribute("paymentHistory",paymentHistory);
        }

        req.getRequestDispatcher("payment_history.jsp").forward(req, resp);
    }
}
