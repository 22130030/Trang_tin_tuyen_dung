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
                    <form id="loginForm" action="employer-login" method="post" onsubmit="return validateForm()">
                        <input type="email" id="email" name="email" placeholder="email@example.com" fdprocessedid="qvblwm">
                        <input type="password" id="password" name="password" placeholder="Mật khẩu" fdprocessedid="0nk9c4">


                        <label>
                            <input type="checkbox"> Hiển thị mật khẩu
                        </label>
                        <button type="submit" fdprocessedid="a6xg5e">Đăng nhập</button>
                        <a href="login_reset_request.jsp?redirectUrl=employer_home">Quên mật khẩu?</a>
                        <a href="register_for_employer.jsp">Đăng kí</a>
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
<script>
    // Bắt sự kiện checkbox hiển thị mật khẩu
    document.getElementById("showPassword").addEventListener("change", function () {
        const passwordField = document.getElementById("password");
        passwordField.type = this.checked ? "text" : "password";

        // Đảm bảo style nhất quán
        passwordField.style.height = "40px";
        passwordField.style.width = "100%";
        passwordField.style.border = "1px solid #ccc";
        passwordField.style.borderRadius = "5px";
        passwordField.style.padding = "10px";
    });

    // Xác thực form trước khi gửi
    function validateForm() {
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();
        const errorMessage = document.getElementById("error-message");

        if (email === "" && password === "") {
            errorMessage.textContent = "Vui lòng điền thông tin.";
            return false;
        }
        if (email === "") {
            errorMessage.textContent = "Vui lòng điền tên tài khoản.";
            return false;
        }
        if (password === "") {
            errorMessage.textContent = "Vui lòng nhập mật khẩu.";
            return false;
        }

        // Nếu không có lỗi
        errorMessage.textContent = "";
        return true;
    }
</script>

</html>
