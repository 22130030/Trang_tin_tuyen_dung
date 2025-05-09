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
    <link rel="stylesheet" href="../asserts/css/base.css">
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
                <th>Nội dung</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paymentHistory}" var="ph">
                <tr>
                    <td>${ph.transactionCode}</td>
                    <td>${ph.convertPaymentDate}</td>
                    <td>${ph.amount}</td>
                    <td>${ph.method}</td>
                    <td>${ph.description}</td>
                    <c:if test="${ph.status == 1}">
                        <td class="status-success">Thành công</td>

                    </c:if>
                    <c:if test="${ph.status == 0}">
                        <td class="status-failed">Thất bại</td>

                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
