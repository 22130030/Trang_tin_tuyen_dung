<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/6/2025
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
    <!-- Style -->
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
    <!-- title -->
    <title>Kiếm việc làm online</title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script type="text/javascript">
        function checkCaptcha(){
            var form = document.getElementById("login-form");
            var error =document.getElementById("error");
            const response = grecaptcha.getResponse();
            if(response){
                form.submit();
            }else{
                error.textContent = "Vui lòng xác minh rằng bạn không phải là người máy";
            }
        }

    </script>
</head>

<body>
<div class="application">
    <!-- header -->
    <%@include file="header.jsp" %>


    <!-- navigation -->
    <!-- content -->

    <div class="d-md-flex half">
        <div class="bg" style="background-image: url('asserts/img/bg_1.jpg');"></div>
        <div class="contents">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-12">
                        <div class="form-block mx-auto">
                            <div class="text-center mb-5">
                                <h3 class="text-uppercase"><strong>Người tìm việc đăng nhập</strong></h3>
                            </div>
                            <div id="error-message" style="display: none; text-align: center; color: red; font-size: 18px; font-weight: bold;">
                                Tài khoản của bạn đã bị khóa trong <span id="countdown"></span>. Vui lòng thử lại sau!
                            </div>
                            <form id="login-form" action="login" method="post">
                                <div class="form-group first">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" placeholder="email" id="email" name="email">
                                </div>
                                <div class="form-group last mb-3">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" placeholder="Mật khẩu"
                                           id="password" name="password" required>
                                </div>
                                <div class="g-recaptcha" data-sitekey="6Le1O_UqAAAAAJ2e7eQrw35TOiST05hjCmWFk3Fy"></div>
                                <div style="color: red" id="error"></div>

                                <div class="d-sm-flex mb-5 align-items-center">
                                    <label class="control control--checkbox mb-3 mb-sm-0"><span
                                            class="caption">Hiển thị mật khẩu</span>
                                        <input type="checkbox"  onclick="togglePassword()">
                                        <div class="control__indicator"></div>
                                    </label>
                                    <span class="ml-auto"><a href="html/login.html" class="forgot-pass">Quên
                                                    mật khẩu</a></span>
                                </div>

                                <button
                                        class="btn btn-block py-2 btn-primary text-center" type="button" onclick="checkCaptcha()">Đăng nhập</button>
                                <span class="text-center my-3 d-block">hoặc</span>

                                <div class="icon">
                                    <a href="html/login.html" class="btn btn-block py-2 btn-facebook">
                                        <img src="asserts/img/fb.png" alt="" class="icon-fb">Đăng nhập với
                                        facebook</a>
                                    <a href="login" class="btn btn-block py-2 btn-google"
                                       style="margin-left: 0px;">
                                        <img src="asserts/img/gg.png" alt="" class="icon-gg">Đăng nhập với
                                        Google</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <%@include file="footer.jsp" %>
</div>
</body>

<%
    String error = request.getParameter("error");
    long lockTime = session.getAttribute("lockTime") != null ? (Long) session.getAttribute("lockTime") : 0;
    long currentTime = System.currentTimeMillis();
    long remainingTime = (lockTime + (1 * 60 * 1000)) - currentTime; // Thời gian còn lại (1 phút)
    boolean isLocked = remainingTime > 0;
%>

<script>
    function togglePassword() {
        var passwordField = document.getElementById("password");
        if (passwordField.type === "password") {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    }
    function startCountdown(duration) {
        let countdownElement = document.getElementById("countdown");
        let form = document.getElementById("login-form");
        let errorMessage = document.getElementById("error-message");

        if (duration > 0) {
            form.style.display = "none"; // Ẩn form đăng nhập
            errorMessage.style.display = "block"; // Hiện thông báo lỗi

            let countdown = duration / 1000;
            let interval = setInterval(function () {
                if (countdown <= 0) {
                    clearInterval(interval);
                    window.location.reload(); // Reload trang sau khi hết thời gian khóa
                } else {
                    countdownElement.innerText = countdown + " giây";
                    countdown--;
                }
            }, 1000);
        } else {
            form.style.display = "block";
            errorMessage.style.display = "none";
        }
    }

    window.onload = function () {
        let remainingTime = <%= remainingTime %>;
        startCountdown(remainingTime);
        const urlParams = new URLSearchParams(window.location.search);
        var status = urlParams.get("status");

        if (status === "success") {
            console.log(status);
            localStorage.setItem("closeMailTab", "true");
        }
    };

</script>

</html>
