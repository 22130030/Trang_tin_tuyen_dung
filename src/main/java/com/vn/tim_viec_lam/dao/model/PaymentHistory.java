package com.vn.tim_viec_lam.dao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentHistory implements java.io.Serializable {
    private int paymentHistoryId;
    private String transactionCode;
    private int userId;
    private LocalDateTime paymentDate;
    private int amount;
//    0 -fail
//    1 - success
//    2 - prcessing
    private int status;
    private String method;
    private String description;
    public PaymentHistory() {

    }

    public PaymentHistory(int paymentHistoryId, String transactionCode, int userId, LocalDateTime paymentDate, int amount, int status, String method, String description) {
        this.paymentHistoryId = paymentHistoryId;
        this.transactionCode = transactionCode;
        this.userId = userId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.method = method;
        this.description = description;
    }

    public int getPaymentHistoryId() {
        return paymentHistoryId;
    }

    public void setPaymentHistoryId(int paymentHistoryId) {
        this.paymentHistoryId = paymentHistoryId;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getConvertPaymentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return paymentDate.format(formatter);
    }
    @Override
    public String toString() {
        return "Payment_history{" +
                "paymentHistoryId=" + paymentHistoryId +
                ", transactionCode='" + transactionCode + '\'' +
                ", userId=" + userId +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", status=" + status +
                ", method='" + method + '\'' +
                '}';
    }
}
