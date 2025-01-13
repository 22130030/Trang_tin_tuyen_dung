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
<form action="update_candidate" method="post">
    <label for="name">Tên ứng viên:</label>
    <input value="${load.candidateID}" type="text" id="id" name="id"  readonly>

    <label for="name">Tên ứng viên:</label>
    <input value="${load.fullName}" type="text" id="name" name="name" placeholder="Nhập tên ứng viên" required>

    <label for="email">Email:</label>
    <input value="${load.email}" type="email" id="email" name="email" placeholder="Nhập email" required>

    <label for="phone">Số Điện Thoại:</label>
    <input value="${load.phone}" type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required>

    <label for="company">Công ty ứng tuyển:</label>
    <input value="${load.appliedCompany}" type="text" id="company" name="company" placeholder="Nhập tên công ty" required>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="Đang xử lí" ${load.status == 'Đang xử lí' ? 'selected' : ''}>Đang xử lí</option>
        <option value="Đã phỏng vấn" ${load.status == 'Đã phỏng vấn' ? 'selected' : ''} > Đã phỏng vấn</option>
        <option value="Đã trúng tuyến" ${load.status == 'Đã trúng tuyến' ? 'selected' : ''}>Đã trúng tuyến</option>
        <option value= "Đã bị từ chối"${load.status == 'Đã bị từ chối' ? 'selected' : ''}> Đã bị từ chối</option>
    </select>

    <button type="submit">Lưu</button>
</form>
<a href="candidate-user-find" class="back-link">← Quay lại</a>
</body>
</html>

