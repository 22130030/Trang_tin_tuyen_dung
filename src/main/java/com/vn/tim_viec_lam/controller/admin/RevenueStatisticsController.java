package com.vn.tim_viec_lam.controller.admin;

import com.google.gson.Gson;
import com.vn.tim_viec_lam.service.PaymentHistoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "get-revenue-statistics",value = "/admin/get-revenue-statistic")
public class RevenueStatisticsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PaymentHistoryService paymentHistoryService = new PaymentHistoryService();

        Map.Entry<Integer, Integer> revenue = paymentHistoryService.getRevenue(1);
        Map<String, Integer> methods = paymentHistoryService.getMethod();
        Map<Integer,Integer> status = paymentHistoryService.getStatusAccount();
        Map<YearMonth, Integer> revenueByMonth = paymentHistoryService.getRevenueByMonth();
        Map<Date, Integer> revenueByDay = paymentHistoryService.getRevenueByDay();

        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("totalRevenue", revenue.getKey());
        jsonResponse.put("totalTransactions", revenue.getValue());
        jsonResponse.put("revenueByMethod", methods);
        jsonResponse.put("statisticsAccount", status);
        jsonResponse.put("revenueByMonth", revenueByMonth);
        jsonResponse.put("revenueByDay", revenueByDay);

        // Chuyển về JSON
        Gson gson = new Gson();
        String json = gson.toJson(jsonResponse);

        // Gửi về client
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
