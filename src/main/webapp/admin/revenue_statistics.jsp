<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 5/10/2025
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
  <link rel="stylesheet" href="../asserts/css/admin/revenue_statistics.css">
  <link rel="stylesheet" href="../asserts/css/base.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <title>Thống kê doanh thu</title>
</head>
<body>
<div class="admin">

  <%@include file="header_admin.jsp"%>
  <div class="container-statistics">

    <!-- Sidebar -->
    <%@include file="sidebar_admin.jsp"%>
    <div class="statistics-content">
    <div class="revenue-info">
      <p><strong>Tổng doanh thu:</strong> <span id="totalRevenue">0 VND</span></p>
      <p><strong>Số lượng giao dịch thành công:</strong> <span id="totalTransactions">0</span></p>
    </div>

    <!-- Biểu đồ doanh thu theo tháng -->
    <div class="chart-container">
      <h3>Biểu đồ Doanh thu theo tháng</h3>
      <canvas id="revenueChart" width="400" height="200"></canvas>
    </div>

    <!-- Biểu đồ giao dịch theo loại -->
    <div class="chart-container">
      <h3>Biểu đồ Giao dịch theo Loại Thanh Toán</h3>
      <canvas id="paymentTypeChart" width="400" height="200"></canvas>
    </div>

    <!-- Biểu đồ doanh thu theo thời gian (đường) -->
    <div class="chart-container">
      <h3>Doanh thu theo Thời gian</h3>
      <canvas id="timeRevenueChart" width="400" height="200"></canvas>
    </div>

    </div>




  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  // Giả sử chúng ta có dữ liệu doanh thu
  var totalRevenue = 10000000; // VND
  var totalTransactions = 150;

  // Cập nhật thông tin trên giao diện
  document.getElementById('totalRevenue').textContent = totalRevenue.toLocaleString() + " VND";
  document.getElementById('totalTransactions').textContent = totalTransactions;

  // Biểu đồ Doanh thu theo tháng (Bar Chart)
  var ctx = document.getElementById('revenueChart').getContext('2d');
  var revenueChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5'],
      datasets: [{
        label: 'Doanh thu theo tháng (VND)',
        data: [1200000, 1500000, 1800000, 2000000, 2500000],
        backgroundColor: '#007bff',
        borderColor: '#0056b3',
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });

  var paymentTypeCtx = document.getElementById('paymentTypeChart').getContext('2d');
  var paymentTypeChart = new Chart(paymentTypeCtx, {
    type: 'pie',
    data: {
      labels: ['Momo', 'ZaloPay', 'Ngân hàng', 'Khác'],
      datasets: [{
        data: [40, 30, 20, 10], // Tỷ lệ giao dịch
        backgroundColor: ['#ff5733', '#33c1ff', '#28a745', '#ffc107'],
        borderColor: ['#fff', '#fff', '#fff', '#fff'],
        borderWidth: 1
      }]
    }
  });

  var timeRevenueCtx = document.getElementById('timeRevenueChart').getContext('2d');
  var timeRevenueChart = new Chart(timeRevenueCtx, {
    type: 'line',
    data: {
      labels: ['Ngày 1', 'Ngày 2', 'Ngày 3', 'Ngày 4', 'Ngày 5'],
      datasets: [{
        label: 'Doanh thu theo thời gian (VND)',
        data: [1500000, 1800000, 2000000, 2500000, 3000000],
        borderColor: '#007bff',
        fill: false,
        borderWidth: 2
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
</script>
</body>
</html>
