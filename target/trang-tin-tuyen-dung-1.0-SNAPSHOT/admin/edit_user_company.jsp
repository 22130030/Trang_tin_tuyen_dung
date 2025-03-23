<%--
  Created by IntelliJ IDEA.
  User: Le Minh Cong
  Date: 1/8/2025
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin nhà tuyển dụng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f9f9f9;
            box-sizing: border-box;
        }
        .container {
            width: 700px;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            box-sizing: border-box; /* Đảm bảo padding không gây lỗi */
        }
        input, select, button {
            width: calc(100% - 20px); /* Chiều rộng của phần tử, trừ padding */
            margin: 10px auto; /* Tạo khoảng cách trên và dưới */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Gồm padding và border trong kích thước */
            display: block; /* Đảm bảo các phần tử là khối */
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            text-align: left;
        }
        input, select {
            width: 100%;
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        a {
            display: inline-block;
            margin-top: 10px;
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Chỉnh sửa thông tin nhà tuyển dụng</h2>
    <form action="edit" method="post">
        <label for="email">ID:</label>
        <input value="${ls.id}" type="text" id="id" name="id" readonly>

        <label for="email">Email:</label>
        <input value="${ls.email}" type="email" id="email" name="email" required>

        <label for="companyName">Tên công ty:</label>
        <input value="${ls.companyName}" type="text" id="companyName" name="companyName" required>

        <label for="phone">Số Điện Thoại:</label>
        <input value="${ls.phone_number}" type="text" id="phone" name="phone" required>

        <label for="address">Địa chỉ chi tiết:</label>
        <input value="${ls.address}" type="text" id="address" name="address">

        <label for="status">Trạng thái:</label>
        <select id="status" name="status" >
            <option value="Đã duyệt" ${ls.status == 'Đã duyệt' ? 'selected' : ''}>Đã duyệt</option>
            <option value="Chưa duyệt" ${ls.status == 'Chưa duyệt' ? 'selected' : ''}>Chưa duyệt</option>
            <option value="Đã từ chối " ${ls.status == 'Đã từ chối ' ? 'selected' : ''}>Đã từ chối </option>
        </select>

        <button type="submit" class="btn-primary">Lưu</button>
        <a href="company-user-job">← Quay lại</a>
    </form>
</div>
</body>
</html>
