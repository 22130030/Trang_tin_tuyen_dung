<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 5/9/2025
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lịch sử thanh toán</title>
    <link rel="stylesheet" href="../asserts/css/candidate/payment_history.css">
</head>
<body>
<%@include file="../header.jsp"%>
<div class="container">


    <h2>Lịch Sử Thanh Toán</h2>

    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Mã giao dịch</th>
                <th>Ngày thanh toán</th>
                <th>Số tiền</th>
                <th>Phương thức</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>TXN001</td>
                <td>2025-05-08</td>
                <td>500.000₫</td>
                <td>Momo</td>
                <td class="status-success">Thành công</td>
            </tr>
            <tr>
                <td>TXN002</td>
                <td>2025-05-01</td>
                <td>300.000₫</td>
                <td>Chuyển khoản</td>
                <td class="status-success">Thành công</td>
            </tr>
            <tr>
                <td>TXN003</td>
                <td>2025-04-25</td>
                <td>700.000₫</td>
                <td>Thẻ tín dụng</td>
                <td class="status-failed">Thất bại</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
