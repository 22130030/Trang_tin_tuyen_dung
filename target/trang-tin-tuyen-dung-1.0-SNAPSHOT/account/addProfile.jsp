<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/13/2025
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../asserts/css/candidate/addProfile.css">
  <link rel="stylesheet" href="../asserts/css/base.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
  <title>Thông tin hồ sơ</title>
</head>
<body>
<div class="application">
  <%@include file="../header.jsp"%>

  <%@include file="menu_account.jsp"%>
<div class="container">
  <h2>Thông tin hồ sơ</h2>
  <form action="add-profile?fileId=${fileId}" method="post">
    <label for="profile-title">Tiêu đề hồ sơ</label>
    <input type="text" id="profile-title" name="profile-title" placeholder="Nhập tiêu đề hồ sơ" value="${fileName == null ? '' : fileName}">

    <label for="full-name">Họ và tên</label>
    <input type="text" id="full-name" name="full-name" placeholder="Nhập họ và tên" value="${sessionScope.user.name}">

    <label for="birth-year">Năm sinh</label>
    <input type="number" id="birth-year" name="birth-year" placeholder="Nhập năm sinh">

    <label for="phone">Nhập số điện thoại</label>
    <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại">

    <label for="marital-status">Tình trạng hôn nhân</label>
    <select id="marital-status" name="marital-status">
      <option value="single">Độc thân</option>
      <option value="married">Đã kết hôn</option>
    </select>

    <label for="gender">Giới tính</label>
    <select id="gender" name="gender">
      <option value="male">Nam</option>
      <option value="female">Nữ</option>
      <option value="other">Khác</option>
    </select>
    <label for="address">Địa chỉ làm việc mong muốn</label>
    <input type="text" id="address" name="address" placeholder="Nhập địa chỉ">
    <label for="education-level">Trình độ học vấn</label>
    <input type="text" id="education-level" name="education-level" placeholder="Nhập trình độ học vấn">

    <label for="school-name">Tên trường</label>
    <input type="text" id="school-name" name="school-name" placeholder="Nhập tên trường">

    <label for="expected-salary">Mức lương mong muốn</label>
    <input type="text" id="expected-salary" name="expected-salary" placeholder="Nhập mức lương mong muốn(đơn vị VND)">

    <label for="career">Ngành nghề</label>
    <input type="text" id="career" name="career" placeholder="Nhập ngành nghề">

    <input type="submit" value="Gửi thông tin">
  </form>
</div>
  <%@include file="../footer.jsp"%>
</div>
</body>
</html>

