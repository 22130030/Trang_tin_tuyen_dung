<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 3/14/2025
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/upgrade_account.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
</head>
<body>
<div class="application">
    <%@include file="../header.jsp"%>
    <div class="upgrade__head">
        <p>Nâng cấp tài khoản</p>
        <span>Nâng cao cơ hội tìm được việc làm</span>
    </div>
    <div class="upgrade__container">
        <div class="upgrade-item upgrade__container-header">
            <div class="plan plan-vip">
                <div class="plan-title">
                    Loại tài khoản
                </div>
                <ul class="plan-feature">
                    <li class="plan-feature-row">
                        Thời hạn sử dụng
                    </li>
                    <li class="plan-feature-row">
                        Số lượng CV
                    </li>
                    <li class="plan-feature-row">
                        Ưu tiên đẩy Top hiển thị với NTD
                    </li>
                    <li class="plan-feature-row">
                        Biểu tượng xác minh tài khoản
                    </li>
                    <li class="plan-feature-row">
                        Sử dụng mẫu Cover Letter Cao Cấp
                    </li>
                    <li class="plan-feature-row">
                        Cho phép nhà tuyển dụng xem hồ sơ
                    </li>

                </ul>
            </div>
        </div>
        <div class="upgrade-item">
            <div class="plan plan-vip">
                <div class="plan-title">
                    <div>
                        <span class="desc">Thường</span>
                        <br>
                        <span class="price">Miễn phí</span>
                    </div>
                </div>
                <ul class="plan-feature">
                    <li class="plan-feature-row">
                        Vĩnh viễn
                    </li>
                    <li class="plan-feature-row bold">
                        2
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>

                </ul>
                <div class="action update">
                    <a href="javascript:void(0)" class="btn btn--disable"
                       data-original-title="" title="">Đã xác thực</a>
                </div>
            </div>
        </div>
        <div class="upgrade-item">
            <div class="plan plan-vip">
                <div class="plan-title">
                    <div>
                        <span class="desc">Đã xác thực</span>
                        <br>
                        <span class="price">Miễn phí</span>
                    </div>
                </div>
                <ul class="plan-feature">
                    <li class="plan-feature-row">
                        Vĩnh viễn
                    </li>
                    <li class="plan-feature-row bold">
                        2
                    </li>
                    <li class="plan-feature-row bold">
                        1 lần/ngày
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>
                    <li class="plan-feature-row">
                        <span class="not-active"></span>
                    </li>




                </ul>
                <div class="action update">
                    <a href="javascript:void(0)" class="btn btn--disable" data-original-title="" title="">Đã xác thực</a>
                </div>
            </div>
        </div>
        <div class="upgrade-item">
            <div class="plan plan-vip">
                <div class="plan-title">
                    <div>
                        <span class="desc">Pro</span>
                        <span class="type">VIP</span>
                        <br>
                        <span class="price">50,000 VNĐ </span>
                    </div>
                </div>
                <ul class="plan-feature">
                    <li class="plan-feature-row">
                        1 tháng
                    </li>
                    <li class="plan-feature-row bold">
                        6
                    </li>
                    <li class="plan-feature-row bold">
                        3 lần/ngày
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                </ul>
                <div class="action update">
                    <a href="payment.jsp?plan=pro"
                       class="btn btn--upgrade">Nâng cấp</a>
                </div>
            </div>
        </div>
        <div class="upgrade-item">
            <div class="plan plan-vip">
                <div class="plan-title">
                    <div>
                        <span class="desc">Premium</span>
                        <span class="type">VIP</span>
                        <br>
                        <span class="price">500,000 VNĐ </span>
                    </div>
                </div>
                <ul class="plan-feature">
                    <li class="plan-feature-row">
                        1 năm
                    </li>
                    <li class="plan-feature-row bold">
                        12
                    </li>
                    <li class="plan-feature-row bold">
                        5 lần/ngày
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>
                    <li class="plan-feature-row">
                        <i class="fa-solid fa-check"></i>
                    </li>

                </ul>
                <div class="action update">
                    <a href="payment.jsp?plan=premium"
                       class="btn btn--upgrade">Nâng cấp</a>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../footer.jsp"%>
</div>
</body>
</html>
