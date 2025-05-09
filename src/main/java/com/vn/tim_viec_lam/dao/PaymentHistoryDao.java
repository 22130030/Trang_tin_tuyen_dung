package com.vn.tim_viec_lam.dao;

import com.google.api.client.util.DateTime;
import com.vn.tim_viec_lam.dao.model.PaymentHistory;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentHistoryDao {
    public List<PaymentHistory>  getPaymentHistory(int userId){
        Connection con = DBconnect.getConnection();
        String sql = "select * from payment_histories where userId=?" +
                " order by payment_date desc";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            List<PaymentHistory> list = new ArrayList<PaymentHistory>();
            while(rs.next()){
                int id = rs.getInt("paymentHistoryId");
                String transactionCode = rs.getString("transaction_code");
                int amount = rs.getInt("amount");
                LocalDateTime paymentDate = rs.getTimestamp("payment_Date").toLocalDateTime();
                String method = rs.getString("method");
                int status = rs.getInt("status");
                String description = rs.getString("description");
                PaymentHistory ph = new PaymentHistory(id,transactionCode,userId,paymentDate,amount,status,method,description);
                list.add(ph);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addPaymentHistory(int userId, String transactionCode, int amount, int status, String method, String description, Timestamp paymentDate) {
        Connection con = DBconnect.getConnection();
        String sql = "INSERT INTO payment_histories(transaction_code, userId, payment_date, amount, method, status, description) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, transactionCode);
            pstmt.setInt(2, userId);
            pstmt.setTimestamp(3, paymentDate);
            pstmt.setInt(4, amount);
            pstmt.setString(5, method);
            pstmt.setInt(6, status); // hoặc setString nếu cột là ENUM
            pstmt.setString(7, description);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
