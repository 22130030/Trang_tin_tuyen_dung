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

      <div  class="chart-circle">

        <div class="chart-container">
          <h3>Biểu đồ Giao dịch theo Loại Thanh Toán</h3>
          <canvas id="paymentTypeChart" width="400" height="200"></canvas>
        </div>
        <div class="chart-container">
          <h3>Biểu đồ Tỉ lệ Tài khoản Pro và Premium</h3>
          <canvas id="accountTypeChart" width="400" height="200"></canvas>
        </div>
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
  fetch('get-revenue-statistic')
          .then(response => response.json())
          .then(data => {
            document.getElementById('totalRevenue').textContent = data.totalRevenue.toLocaleString() + " VND";
            document.getElementById('totalTransactions').textContent = data.totalTransactions;

            const revenueMonths = Object.keys(data.revenueByMonth).sort();
            const revenueValues = revenueMonths.map(month => data.revenueByMonth[month]);

            new Chart(document.getElementById('revenueChart').getContext('2d'), {
              type: 'bar',
              data: {
                labels: revenueMonths.map(m => "Tháng " + m.split('-')[1]),
                datasets: [{
                  label: 'Doanh thu theo tháng (VND)',
                  data: revenueValues,
                  backgroundColor: '#007bff',
                  borderColor: '#0056b3',
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  y: { beginAtZero: true }
                }
              }
            });

            // Biểu đồ theo phương thức thanh toán
            const methodLabels = Object.keys(data.revenueByMethod);
            const methodData = methodLabels.map(label => data.revenueByMethod[label]);

            new Chart(document.getElementById('paymentTypeChart').getContext('2d'), {
              type: 'pie',
              data: {
                labels: methodLabels,
                datasets: [{
                  data: methodData,
                  backgroundColor: ['#ff5733', '#33c1ff', '#28a745', '#ffc107'],
                  borderColor: ['#fff', '#fff', '#fff', '#fff'],
                  borderWidth: 1
                }]
              }
            });

            // Biểu đồ doanh thu 5 ngày gần nhất
            const dayLabels = Object.keys(data.revenueByDay).sort(); // yyyy-MM-dd
            const dayData = dayLabels.map(day => data.revenueByDay[day]);

            new Chart(document.getElementById('timeRevenueChart').getContext('2d'), {
              type: 'line',
              data: {
                labels: dayLabels.map(d => "Ngày " + new Date(d).getDate()),
                datasets: [{
                  label: 'Doanh thu theo thời gian (VND)',
                  data: dayData,
                  borderColor: '#007bff',
                  fill: false,
                  borderWidth: 2
                }]
              },
              options: {
                scales: {
                  y: { beginAtZero: true }
                }
              }
            });

            // Biểu đồ Tỉ lệ Tài khoản Pro và Premium (Pie Chart)
            const statusData = data.statisticsAccount;
            const proCount = statusData["2"] || 0;
            const premiumCount = statusData["3"] || 0;

            new Chart(document.getElementById('accountTypeChart').getContext('2d'), {
              type: 'pie',
              data: {
                labels: ['Tài khoản Pro', 'Tài khoản Premium'],
                datasets: [{
                  data: [proCount, premiumCount],
                  backgroundColor: ['#28a745', '#ffc107'],
                  borderColor: ['#fff', '#fff'],
                  borderWidth: 1
                }]
              }
            });

          })

          .catch(error => {
            console.error('Lỗi khi lấy thống kê doanh thu:', error);
          });
</script>

</body>
</html>
