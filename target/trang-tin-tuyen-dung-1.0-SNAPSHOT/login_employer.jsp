<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/16/2025
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login for employer</title>
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="asserts/css/main_login_for_employer.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css"></head>
<body>
    <div class="application">
        <%@include file="header_employer.jsp"%>
        <div class="login-container">
            <div class="login-box">
                <div class="login-left">
                    <h2>Nhà tuyển dụng đăng nhập</h2>
                    <form>
                        <input type="email" placeholder="Email" required>
                        <input type="password" placeholder="Mật khẩu" required>
                        <label>
                            <input type="checkbox"> Hiển thị mật khẩu
                        </label>
                        <button onclick="window.location.href='/html/employer/employer.html'" type="submit">
                            Đăng nhập
                        </button>
                        <a href="#">Quên mật khẩu</a>
                    </form>
                </div>
                <div class="login-right">
                    <h3>Bạn chưa có tài khoản?</h3>
                    <button class="register-btn">Đăng ký</button>
                    <p>Tham gia ngay hôm nay và truy cập hàng ngàn ứng cử viên sáng giá!</p>
                    <hr>
                    <h4>Tại sao đăng ký?</h4>
                    <ul>
                        <li>Đăng công việc để nhận được những hồ sơ phù hợp</li>
                        <li>Nhận thông báo hồ sơ qua email</li>
                    </ul>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </div>
</body>
</html>
