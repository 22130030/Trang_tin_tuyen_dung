package com.vn.tim_viec_lam.controller.admin;

import com.vn.tim_viec_lam.dao.model.PaymentHistory;
import com.vn.tim_viec_lam.service.PaymentHistoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "manager-payment",value = "/admin/manager-payment")
public class ManagerPayment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PaymentHistoryService paymentHistoryService = new PaymentHistoryService();
        List<PaymentHistory> paymentHistories = paymentHistoryService.getAllPaymentHistory();

        req.setAttribute("paymentHistories",paymentHistories);
        req.getRequestDispatcher("admin_payment_history.jsp").forward(req,resp);
    }
}
