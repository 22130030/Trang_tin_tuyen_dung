package com.vn.tim_viec_lam.controller.payment;


import com.vn.tim_viec_lam.service.PaymentHistoryService;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        PaymentHistoryService phs = new PaymentHistoryService();


        // Ngày thanh toán
        String rawDate = request.getParameter("vnp_PayDate");
        String formattedDate;
        Timestamp sqlTimestamp = null;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            Date payDate = inputFormat.parse(rawDate); // Dùng Date này để lưu
            sqlTimestamp = new Timestamp(payDate.getTime());

            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            formattedDate = outputFormat.format(inputFormat.parse(rawDate));
        } catch (Exception e) {
            formattedDate = "Không xác định";
        }

        String vnp_TxnRef = request.getParameter("vnp_TxnRef");
        String vnp_OrderInfo = request.getParameter("vnp_OrderInfo");

        int userId = (int) session.getAttribute("userID");
        if(isSuccess){
            us.updateStatus(userId, status);
            phs.addPaymentHistory(userId,vnp_TxnRef,amountInt,1,"VNPay",vnp_OrderInfo,sqlTimestamp);
        }
        if(!isSuccess){
            phs.addPaymentHistory(userId,vnp_TxnRef,amountInt,0,"VNPay",vnp_OrderInfo,sqlTimestamp);
        }
        session.setAttribute("status", status);
        request.setAttribute("isSuccess", isSuccess);
        request.setAttribute("formattedAmount", formattedAmount);
        request.setAttribute("txnRef", vnp_TxnRef);
        request.setAttribute("orderInfo", vnp_OrderInfo);
        request.setAttribute("formattedDate", formattedDate);

        // Chuyển tiếp sang trang JSP
        request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
    }
}

