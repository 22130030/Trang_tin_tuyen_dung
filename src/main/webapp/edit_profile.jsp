<%--
  Created by IntelliJ IDEA.
  User: Le Minh Cong
  Date: 1/12/2025
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chỉnh sửa thông tin ứng viên</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      line-height: 1.6;
      margin: 0 auto;
      max-width: 600px;
      padding: 20px;
    }
    h1 {
      text-align: center;
      color: #333;
    }
    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
    }
    input[type="text"],
    input[type="email"],
    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    button {
      background-color: #007BFF;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    button:hover {
      background-color: #0056b3;
    }
    .back-link {
      display: inline-block;
      margin-top: 10px;
      color: #007BFF;
      text-decoration: none;
    }
    .back-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<h1>Chỉnh sửa thông tin ứng viên</h1>
<!-- Form chỉnh sửa thông tin cá nhân -->
<form action="${pageContext.request.contextPath}/update-candidate" method="post">
  <div class="list-group">
    <div class="list-group-item">
      <label >Họ và tên</label>
      <input type="text" name="name" class="form-control" value="${sessionScope.user.name}" required />
    </div>
    <div class="list-group-item">
      <label >Địa chỉ email</label>
      <input type="email" name="email" class="form-control" value="${sessionScope.user.email}" required />
    </div>
    <div class="list-group-item">
      <label >Giới tính</label>
      <input type="text" name="gender" class="form-control" value="${sessionScope.user.gender}" />
    </div>
    <div class="list-group-item">
      <label >Ngày sinh</label>
      <input type="text" name="birthDate" class="form-control" value="${sessionScope.user.birthDate}" />
    </div>
    <div class="list-group-item">
      <label >Tình trạng hôn nhân</label>
      <input type="text" name="maritalStatus" class="form-control" value="${sessionScope.user.maritalStatus}" />
    </div>
    <div class="list-group-item">
      <label >Số điện thoại</label>
      <input type="text" name="phone" class="form-control" value="${sessionScope.user.phoneNumber}" />
    </div>
    <div class="list-group-item">
      <label >Địa chỉ</label>
      <input type="text" name="address" class="form-control" value="${sessionScope.user.address}" />
    </div>
  </div>

  <!-- Nút lưu thông tin -->
  <div class="text-center mt-3">
    <button type="submit" class="btn btn-success">Lưu thông tin</button>
  </div>

  <!-- Nút hủy -->
  <div class="text-center mt-3">
    <a href="${pageContext.request.contextPath}/account/account_candidate.jsp" class="btn btn-danger">Hủy</a>
  </div>
</form>
</body>
</html>

