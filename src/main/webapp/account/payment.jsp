<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 3/15/2025
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <link rel="stylesheet" href="../asserts/css/payment.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
</head>
<body>
<div class="application">
    <%@include file="../header.jsp"%>
    <div class="container">

        <div class="payment__head">
            <h1>Thanh toán kích hoạt tài khoản</h1>
        </div>
        <div class="payment__container">
            <div class="container__step-payment">
                <h4>
                    <span class="container__step-payment-circle">1</span>
                    Chọn gói nâng cấp
                </h4>
                <div class="step-payment__content">
                    <label for="" class="step-payment__content--pro">
                        <input type="radio" name="group__payment" id="pro-inp"
                               <c:if test="${'pro' eq param.plan}">checked</c:if>
                        >
                        <strong class="">Tài khoản Pro
                            -
                            </strong>
                            <strong>50.000</strong>
                            <sup>VND</sup>
                            <span class="step-payment__date"> / 1 tháng sử dụng</span>
                    </label>

                    <label for="" class="step-payment__content--premium">
                        <input type="radio" name="group__payment" id="premium-inp"
                            <c:if test="${'premium' eq param.plan}">checked</c:if>
                        >
                        <strong class="">Tài khoản premium
                            -
                            </strong>
                            <strong>500.000</strong>
                            <sup>VND</sup>
                            <span class="step-payment__date"> / 1 năm sử dụng</span>
                    </label>
                </div>
            </div>
            <div class="payment__method">
                <h4>
                    <span class="container__step-payment-circle">2</span>
                    Chọn hình thức thanh toán
                </h4>
                <div class="payment-method__content">
                    <button  style="margin-bottom: 10px" class="btn-payment" id="btn-momo__payment">
                        <img class="payment-method__img" src="../asserts/img/payments/momo.webp">
                        Thanh toán bằng Ví MoMo
                    </button>
                    <button style="margin-bottom: 10px" class="btn-payment" id="btn-momo-transfer">
                        <img class="payment-method__img" src="../asserts/img/payments/logo_epay.webp">
                        Thanh toán bằng ATM
                    </button>
                </div>

            </div>
        </div>
    </div>
    <%@include file="../footer.jsp"%>
</div>
<script>
    document.getElementById("btn-momo__payment").addEventListener("click", function() {
        const proRadio = document.getElementById("pro-inp");
        const amount = proRadio.checked ? 50000 : 500000;

        fetch("${pageContext.request.contextPath}/account/momo-payment", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: "amount=" + amount
        })
            .then(response => response.text())
            .then(data => {
                if (data.startsWith("http")) {
                    window.location.href = data; // Redirect to MoMo payment page
                } else {
                    alert("Thanh toán thất bại: " + data);
                }
            })
            .catch(error => alert("Lỗi kết nối: " + error));
    });
</script>
</body>
</html>
