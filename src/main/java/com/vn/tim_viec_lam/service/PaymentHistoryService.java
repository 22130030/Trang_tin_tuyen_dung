package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.PaymentHistoryDao;
import com.vn.tim_viec_lam.dao.model.PaymentHistory;

import java.sql.Timestamp;
import java.util.List;

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

    public static void main(String[] args) {
        PaymentHistoryService paymentHistoryService = new PaymentHistoryService();
        System.out.println(paymentHistoryService.getPaymentHistory(30));
    }
}
