<%--
  Created by IntelliJ IDEA.
  User: Le Minh Cong
  Date: 1/13/2025
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa tài khoản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2{
            margin-left: 135px;
        }
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 95%;
            padding: 10px;
            font-size: 14px;
        }
        .form-group button {
            padding: 10px 15px;
            background-color:#007bff

        ;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #007bff;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Chỉnh sửa tài khoản</h2>
    <form action="edit/edit-user" method="post">
        <!-- User ID (Ẩn) -->
        <input type="hidden" id="userID" name="userId" value="${load.userID}" readonly>

        <!-- Email -->
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${load.email}" required>
        </div>

        <!-- Mật khẩu -->
        <div class="form-group">
            <label for="password">Mật khẩu hiện tại</label>
            <input type="text"  name="password" value="${load.password}" required>
        </div>

        <!-- Mật khẩu mới -->
        <div class="form-group">
            <label for="password">Mật khẩu mới</label>
            <input type="text"  name="password1" value="" readonly>
        </div>
        <!--Xác nhân lại Mật khẩu  -->
        <div class="form-group">
            <label for="re-password">Xác nhân lại mật khẩu </label>
            <input type="text" id="password2" name="password" value="" readonly>
        </div>

        <!-- Vai trò -->
        <div class="form-group">
            <label for="roleNum">Loại tài khoản</label>
            <select id="roleNum" name="roleNum" required>
                <option value="1" ${load.roleNum == 1 ? 'selected' : ''}>1</option>
                <option value="2" ${load.roleNum == 2 ? 'selected' : ''}>2</option>
                <option value="3" ${load.roleNum == 3 ? 'selected' : ''}>3</option>
            </select>
        </div>

        <!-- Trạng thái -->
        <div class="form-group">
            <label for="status">Trạng thái</label>
            <select id="status" name="status" required>
                <option value="1" ${load.status >= 0 ? 'selected' : ''}>Đang hoạt động</option>
                <option value="-1" ${load.status == -1 ? 'selected' : ''}>Đã bị vô hiệu</option>
            </select>
        </div>

        <!-- Nút Submit -->
        <div class="form-group">
            <button type="submit">Lưu</button>
            <a href="manager-user" class="btn-secondary">← Quay lại</a>
        </div>
    </form>
</div>
</body>
</html>
