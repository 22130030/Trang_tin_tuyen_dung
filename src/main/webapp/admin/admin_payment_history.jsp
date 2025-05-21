<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 5/17/2025
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../asserts/css/base.css">
  <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
  <link rel="stylesheet" href="../asserts/css/admin/admin_payment_history.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Quản lý giao dịch</title>
</head>
<body>
<div class="admin">
  <%@include file="header_admin.jsp"%>

  <div class="container">

    <!-- Sidebar -->
    <%@include file="sidebar_admin.jsp"%>





    <!-- Table Section -->
    <div id="table-container">
      <h3>Quản lý lịch sử giao dịch</h3>
      <div class="payment__management">
        <form action="payment-user-find"  method="post" class="payment__search">
          <input class="search__input" type="text" name="email" class="search__payment" placeholder="Nhập mã giao dịch">
          <div class="search__status-filter">
            <span>Trạng thái : </span>
            <select name="status" id="" class="search__filter">
              <option value="">Đang xử lí</option>
              <option value="">Thành công</option>
              <option value="">Thất bại</option>
            </select>
          </div>
          <button class="search__submit">
            <i class="fa-solid fa-magnifying-glass"></i>
            <span>Tìm kiếm</span>
          </button>
        </form>

        <table>
          <thead>
          <tr>
            <th>Mã giao dịch</th>
            <th>UserId</th>
            <th>Tên người chuyển</th>
            <th>Ngày thanh toán</th>
            <th>số tiền</th>
            <th>phương thức</th>
            <th>Nội dung</th>
            <th>Trạng thái</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${paymentHistories}" var="ph">

            <tr>
              <td class="payment_code">${ph.transactionCode}</td>
              <td class="">${ph.userId}</td>
              <td class="payment_name">${ph.name}</td>
              <td>${ph.convertPaymentDate}</td>
              <td class="">${ph.amount}</td>
              <td class="">${ph.method}</td>
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
  </div>
</div>

</body>
</html>
