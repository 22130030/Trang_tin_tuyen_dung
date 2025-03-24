<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 3/23/2025
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Xác minh tài khoản</title>
    <link rel="stylesheet" href="asserts/css/verify_account.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/candidate/account_base.css">
</head>
<body>
<div class="application">
    <%@include file="header.jsp"%>
    <div class="container">
        <div class="content">

            <h2>Liên kết xác thực đã được gửi!</h2>
            <p>Chúng tôi đã gửi một email xác thực đến địa chỉ email của bạn.</p>
            <p>Vui lòng kiểm tra hộp thư đến và nhấn vào liên kết để hoàn tất xác thực tài khoản.</p>
            <p>Liên kết sẽ hết hạn sau: <span id="countdown" class="countdown">3 phút</span></p>
            <p id="verifyMessage"></p>
        </div>
    </div>
    <%@include file="footer.jsp"%>
</div>
<script>
    function startCountdown(duration) {
        let timer = duration, minutes, seconds;
        let countdownElement = document.getElementById('countdown');

        let interval = setInterval(function () {
            minutes = Math.floor(timer / 60);
            seconds = timer % 60;

            countdownElement.textContent = minutes + " phút " + seconds + " giây";

            if (--timer < 0) {
                clearInterval(interval);
                countdownElement.textContent = "Link đã hết hạn!";
                document.getElementById("verifyMessage").innerHTML = "Vui lòng yêu cầu gửi lại email xác thực.";
            }
        }, 1000);
    }

    window.onload = function () {
        startCountdown(180); // 3 phút = 180 giây
    };
    setInterval(function (){
        console.log(2)
        if(localStorage.getItem("closeMailTab") === "true") {
            console.log(3)
            localStorage.setItem("closeMailTab","false")
            window.close();
        }
    }, 1000);
</script>
</body>

</html>
