<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/13/2025
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../asserts/css/admin/admin.css">
  <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
  <link rel="stylesheet" href="../asserts/css/base.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <title>Admin</title>

</head>
<body>
<div class="admin">
  <%@include file="header_admin.jsp"%>
  <div class="container">

    <!-- Sidebar -->
    <%@include file="sidebar_admin.jsp"%>


    <!-- Main Content -->
    <div class="content">
      <h1>Thống kê và báo cáo</h1>
      <!-- Cards Section -->
      <div class="statistical">
        <div class="statistical__employer statistical__item">
          <h2>${size}</h2>
          <p>Nhà tuyển dụng</p>
        </div>
        <div class="statistical__user statistical__item">
          <h2>${size2}</h2>
          <p>Ứng viên</p>
        </div>
        <div class="statistical__jobs statistical__item">
          <h2>${size3}</h2>
          <p>Việc làm đã đăng</p>
        </div>
      </div>


      <!-- Table Section -->
      <div class="table-container">
        <h3>Những nhà tuyển dụng mới</h3>
        <div class="employers">


          <table>
            <thead>
            <tr>
              <th>ID</th>
              <th>Tên Công ty</th>
              <th>Email</th>
              <th>Số điện thoại</th>
              <th>Trạng thái</th>
              <th>Ngày đăng ký</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${com}" var="c">
              <tr>
                <td>${c.id}</td>
                <td>${c.companyName}</td>
                <td>${c.email}</td>
                <td>${c.phone_number}</td>
                <td>${c.status}</td>
                <td>${c.createDate}</td>
              </tr>
            </c:forEach>



            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
