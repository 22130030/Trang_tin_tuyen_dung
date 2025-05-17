package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.PaymentHistoryDao;
import com.vn.tim_viec_lam.dao.model.PaymentHistory;

import java.sql.Timestamp;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PaymentHistoryService {
    private PaymentHistoryDao paymentHistoryDao;
    public PaymentHistoryService() {
        paymentHistoryDao = new PaymentHistoryDao();
    }
    public List<PaymentHistory> getPaymentHistory(int userId){
        return paymentHistoryDao.getPaymentHistory(userId);
    }
    public boolean addPaymentHistory(int userId, String transactionCode, int amount, int status, String method, String description, Timestamp paymentDate){
        return paymentHistoryDao.addPaymentHistory(userId, transactionCode, amount, status, method, description, paymentDate);
    }
    public Map.Entry<Integer,Integer> getRevenue(int status) {
        return paymentHistoryDao.getRevenue(status);
    }
    public Map<String,Integer> getMethod() {
        return paymentHistoryDao.getMethod();
    }
    public Map<YearMonth,Integer> getRevenueByMonth() {
        return paymentHistoryDao.getRevenueByMonth();
    }
    public Map<Date,Integer> getRevenueByDay() {
        return paymentHistoryDao.getRevenueByDay();
    }
    public Map<Integer,Integer> getStatusAccount(){
        return paymentHistoryDao.getStatusAccount();
    }
    public List<PaymentHistory> getAllPaymentHistory(){
        return paymentHistoryDao.getAllPaymentHistory();
    }
        public static void main(String[] args) {
        PaymentHistoryService paymentHistoryService = new PaymentHistoryService();
        System.out.println(paymentHistoryService.getRevenueByDay());
    }
}
