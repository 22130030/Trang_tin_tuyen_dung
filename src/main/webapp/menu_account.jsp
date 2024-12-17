<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/17/2024
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/candidate/account_base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
</head>
<body>
    <div class="application">
        <div class="nav__menu">
    <div class="grid__1100">
        <ul class="nav__menu-list">
            <li class="nav__menu-item">
                <a href="/html/candidate/account_Management/account_main.html" class=" nav__menu__link">

                    <i class="fa-solid fa-house"></i>
                    <span class=" nav__menu-title">Tổng quan
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="/html/candidate/account_Management/job_application.html" class=" nav__menu__link">

                    <i class="fa-regular fa-address-card"></i>
                    <span class="nav__menu-title">Hồ sơ xin việc(
                                <span class="nav__menu-toltal">0</span>
                                )
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="#" class="nav__menu-active nav__menu__link">
                    <div class="nav-menu__has-separated"></div>
                    <i class="fa-regular fa-heart"></i>
                    <span class="nav__menu-title">Việc làm đã lưu(
                                <span class="nav__menu-toltal">${sessionScope.addJobCart.size}</span>
                                )
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="/html/candidate/account_Management/job_applied.html" class="nav__menu__link">
                    <i class="fa-regular fa-paper-plane"></i>
                    <span class="nav__menu-title">Việc làm đã ứng tuyển(
                                <span class="nav__menu-toltal">1</span>
                                )
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="/html/candidate/account.html" class=" nav__menu__link">

                    <i class="fa-regular fa-user"></i>
                    <span class="nav__menu-title">Quản lý tài khoản
                            </span>
                </a>
            </li>
        </ul>
    </div>
</div>
    </div>
</body>
</html>
