<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 3/30/2025
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="asserts/css/CandidateLoginGG.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
    <link rel="stylesheet" href="asserts/css/base.css">
</head>
<body>
<div class="application">
    <%@include file="header.jsp"%>
    <div class="login__google-content">
        <form action="login-by-google" class="container" method="post">
            <h2 class="container__title">Người tìm việc đăng ký</h2>
            <img src="${picture}" class="container__avatar"></img>
            <h3 class="container__name">Đức Ngô Văn</h3>
            <p class="container__email">cartoonreview0@gmail.com</p>
            <input name="password" class="container__password" type="password" placeholder="Mật khẩu">
            <input name="repassword" class="container__rePass" type="password" placeholder="Nhập lại mật khẩu">
            <p class="terms">Tôi đồng ý với việc xử lý và cung cấp thông tin dữ liệu cá nhân, đồng thời đã đọc và đồng ý với <a href="#">Thỏa thuận sử dụng</a> và <a href="#">Quy định bảo mật</a> của TimviecDCH.</p>
            <button type="submit">Xác nhận</button>
        </form>
    </div>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
