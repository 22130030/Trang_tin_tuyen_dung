<%--
  Created by IntelliJ IDEA.
  User: Le Minh Cong
  Date: 1/13/2025
  Time: 1:35 AM
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
    <title>Chỉnh sửa bài đăng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .title {
            text-align: center;
            color: #007bff;
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: bold;
        }

        form label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }

        form input[type="text"],
        form input[type="number"],
        form input[type="file"],
        form select {
            width: 97%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }

        form input:focus,
        form select:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .current-image {
            margin-bottom: 20px;
        }

        .current-image img {
            max-width: 100%;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 5px;
            background-color: #f9f9f9;
        }

        .form-buttons {
            display: flex;
            justify-content: space-between;
        }

        .form-buttons button,
        .form-buttons a {
            width: 48%;
            padding: 10px;
            text-align: center;
            font-size: 16px;
            text-decoration: none;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-secondary {
            background-color: #6c757d;
            text-align: center;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Chỉnh sửa bài đăng</h1>
    <form action="edit-job-posting" method="post">
        <!-- ID -->
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" value="${job.id}" readonly>

        <!-- Hình ảnh hiện tại -->
        <label>Hình ảnh hiện tại:</label>
        <div class="current-image">
            <img src="${job.img}" alt="Hình ảnh bài đăng" >
        </div>
        <label for="image">Thay đổi hình ảnh:</label>
        <input type="file" id="image" name="image" accept="image/*">

        <!-- Tiêu đề -->
        <label for="title">Tiêu đề:</label>
        <input type="text" id="title" name="titleJob" value="${job.title}" required>

        <!-- Tên công ty -->
        <label for="company">Tên công ty:</label>
        <input type="text" id="company" name="companyName" value="${job.companyName}" required>

        <!-- Địa chỉ -->
        <label for="address">Địa chỉ:</label>
        <input type="text" id="address" name="address" value="${job.city}" required>

        <!-- Mức lương -->
        <label for="salary">Mức lương:</label>
        <input type="text" id="salary" name="salary" value="${job.salary}" required>

        <!-- Trạng thái -->
        <label for="status">Trạng thái:</label>
        <select id="status" name="status">
            <option value="Đã duyệt" ${job.status == 'Đã duyệt' ? 'selected' : ''}>Đã duyệt</option>
            <option value="Chưa duyệt" ${job.status == 'Chưa duyệt' ? 'selected' : ''}>Chưa duyệt</option>
            <option value="Đã từ chối " ${job.status == 'Đã từ chối ' ? 'selected' : ''}>Đã từ chối </option>
        </select>

        <!-- Nút -->
        <div class="form-buttons">
            <button type="submit" class="btn-primary" >Lưu</button>
            <a href="job_manager" class="btn-secondary">← Quay lại</a>
        </div>
    </form>
</div>
</body>
</html>

