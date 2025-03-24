<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 3/23/2025
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xác minh tài khoản</title>
    <link rel="stylesheet" href="../asserts/css/verify_account.css">
</head>
<body>
<div class="container">
    <h1>Xác minh tài khoản</h1>

    <!-- Form gửi email -->
    <div id="emailForm">
        <form method="post" action="send-mail" id="emailVerificationForm">
            <label for="email">Nhập email của bạn:</label>
            <input type="email" id="email" name="email" placeholder="Email" required>
            <button type="submit">Gửi mã xác minh</button>
        </form>
        <div class="message" id="emailMessage"></div>
    </div>

    <!-- Form nhập mã xác minh -->
    <div id="codeForm" style="display: none;">
        <form id="codeVerificationForm">
            <label for="code">Nhập mã xác minh đã gửi:</label>
            <input type="text" id="code" name="code" placeholder="Mã xác minh" required>
            <button type="submit">Xác minh</button>
        </form>
        <div class="message" id="codeMessage"></div>
    </div>
</div>

</body>
</html>
