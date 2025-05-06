package com.vn.tim_viec_lam.controller.payment;


import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@WebServlet("/vnpay-return")
public class VNPayReturn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String responseCode = request.getParameter("vnp_ResponseCode");
        boolean isSuccess = "00".equals(responseCode);

        HttpSession session = request.getSession();
        UserService us = new UserService();

        int amountInt = 0;
        int status = 0;
        String formattedAmount;
        try {
            amountInt = Integer.parseInt(request.getParameter("vnp_Amount")) / 100;
            if(amountInt == 50000){
                status = 2;
            }
            if(amountInt == 500000){
                status = 3;
            }
            DecimalFormat formatter = new DecimalFormat("#,###");
            formattedAmount = formatter.format(amountInt);
        } catch (Exception e) {
            formattedAmount = "Không xác định";
        }

        if(isSuccess){
            int userId = (int) session.getAttribute("userID");
            us.updateStatus(userId, status);
        }
        // Ngày thanh toán
        String rawDate = request.getParameter("vnp_PayDate");
        String formattedDate;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            formattedDate = outputFormat.format(inputFormat.parse(rawDate));
        } catch (Exception e) {
            formattedDate = "Không xác định";
        }
        session.setAttribute("status", status);
        request.setAttribute("isSuccess", isSuccess);
        request.setAttribute("formattedAmount", formattedAmount);
        request.setAttribute("txnRef", request.getParameter("vnp_TxnRef"));
        request.setAttribute("orderInfo", request.getParameter("vnp_OrderInfo"));
        request.setAttribute("formattedDate", formattedDate);

        // Chuyển tiếp sang trang JSP
        request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
    }
}

