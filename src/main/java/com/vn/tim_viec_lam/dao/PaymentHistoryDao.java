package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.PaymentHistory;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;
import java.util.Date;

public class PaymentHistoryDao {
    public List<PaymentHistory> getPaymentHistory(int userId) {
        String sql = "select * from payment_histories where userId=? order by payment_date desc";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<PaymentHistory> list = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("paymentHistoryId");
                    String transactionCode = rs.getString("transaction_code");
                    int amount = rs.getInt("amount");
                    LocalDateTime paymentDate = rs.getTimestamp("payment_Date").toLocalDateTime();
                    String method = rs.getString("method");
                    int status = rs.getInt("status");
                    String description = rs.getString("description");
                    PaymentHistory ph = new PaymentHistory(id, transactionCode, userId, paymentDate, amount, status, method, description);
                    list.add(ph);
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addPaymentHistory(int userId, String transactionCode, int amount, int status, String method, String description, Timestamp paymentDate) {
        String sql = "INSERT INTO payment_histories(transaction_code, userId, payment_date, amount, method, status, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, transactionCode);
            pstmt.setInt(2, userId);
            pstmt.setTimestamp(3, paymentDate);
            pstmt.setInt(4, amount);
            pstmt.setString(5, method);
            pstmt.setInt(6, status);
            pstmt.setString(7, description);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map.Entry<Integer, Integer> getRevenue(int status) {
        String sql = "select sum(amount) as revenue,count(*) as totalStatus from payment_histories where status=?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, status);
            try (ResultSet rs = pstmt.executeQuery()) {
                int revenue = 0;
                int totalStatus = 0;
                if (rs.next()) {
                    revenue = rs.getInt("revenue");
                    totalStatus = rs.getInt("totalStatus");
                }
                return new AbstractMap.SimpleEntry<>(revenue, totalStatus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<YearMonth, Integer> getRevenueByMonth() {
        String sql = "SELECT  DATE_FORMAT(payment_date, '%Y-%m') AS month, SUM(amount) AS monthly_revenue FROM payment_histories WHERE status = 1 AND payment_date >= DATE_SUB(CURDATE(), INTERVAL 5 MONTH) GROUP BY month ORDER BY month";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            Map<YearMonth, Integer> res = new HashMap<>();
            while (rs.next()) {
                YearMonth yearMonth = YearMonth.parse(rs.getString("month"));
                int revenue = rs.getInt("monthly_revenue");
                res.put(yearMonth, revenue);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> getMethod() {
        String sql = "SELECT method, count(amount) AS total_method FROM payment_histories WHERE status = 1 GROUP BY method";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            Map<String, Integer> res = new HashMap<>();
            while (rs.next()) {
                String method = rs.getString("method");
                res.put(method, rs.getInt("total_method"));
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Date, Integer> getRevenueByDay() {
        String sql = "SELECT d.date, COALESCE(SUM(p.amount), 0) AS daily_revenue FROM ( " +
                "SELECT CURDATE() AS date UNION ALL " +
                "SELECT DATE_SUB(CURDATE(), INTERVAL 1 DAY) UNION ALL " +
                "SELECT DATE_SUB(CURDATE(), INTERVAL 2 DAY) UNION ALL " +
                "SELECT DATE_SUB(CURDATE(), INTERVAL 3 DAY) UNION ALL " +
                "SELECT DATE_SUB(CURDATE(), INTERVAL 4 DAY) " +
                ") AS d LEFT JOIN payment_histories p ON DATE(p.payment_date) = d.date AND p.status = 1 " +
                "GROUP BY d.date ORDER BY d.date";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            Map<Date, Integer> res = new HashMap<>();
            while (rs.next()) {
                Date date = rs.getDate("date");
                int revenue = rs.getInt("daily_revenue");
                res.put(date, revenue);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, Integer> getStatusAccount() {
        String sql = "SELECT status, COUNT(*) AS total_accounts FROM users WHERE status IN (2, 3) GROUP BY status";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            Map<Integer, Integer> res = new HashMap<>();
            while (rs.next()) {
                int status = rs.getInt("status");
                int totalAccounts = rs.getInt("total_accounts");
                res.put(status, totalAccounts);
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PaymentHistory> getAllPaymentHistory() {
        String sql = "select ph.*,u.name from payment_histories ph join users u on u.userId = ph.userId order by payment_date desc";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<PaymentHistory> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("paymentHistoryId");
                String transactionCode = rs.getString("transaction_code");
                int amount = rs.getInt("amount");
                LocalDateTime paymentDate = rs.getTimestamp("payment_Date").toLocalDateTime();
                String method = rs.getString("method");
                int status = rs.getInt("status");
                int userId = rs.getInt("userId");
                String name = rs.getString("name");
                String description = rs.getString("description");
                PaymentHistory ph = new PaymentHistory(id, transactionCode, userId, paymentDate, amount, status, method, description);
                ph.setName(name);
                list.add(ph);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
