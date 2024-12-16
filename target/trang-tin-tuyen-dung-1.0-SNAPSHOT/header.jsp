<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/12/2024
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="asserts/css/main.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title></title>
</head>
<body>
    <div class="nav-sticky">
    <nav class="nav">
        <div class="grid nav__container">
            <div class="nav__logo">
                <a href="#" class="nav__logo-link">
                    <img src="asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                </a>
            </div>
            <ul class="nav__list">
                <li class="nav__item">
                    <a href="html/search_occupations_locat.html" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-magnifying-glass"></i>
                        Ngành nghề/Địa điểm
                    </a>
                </li>
                <li class="nav__item">
                    <a href="html/company.html" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-city"></i>
                        Công ty
                    </a>
                </li>

                <li class="nav__item">
                    <a href="html/career_handbook.html" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-book-open"></i>
                        Cẩm nang việc làm
                    </a>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <a href="" class="nav__item-link">
                        <i class="nav-item__icon fa-regular fa-message"></i>
                        Chat
                    </a>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <div class="nav__item-link nav__user nav__has--form-login">
                        <div class="nav__user-icon">
                            <i class="fa-regular fa-user"></i>
                        </div>
                        Đăng ký

                        <div class="nav__dropdown-menu">
                            <div class="menu__buttons">
                                <button class="btn menu__register" onclick="window.location.href='/html/candidate/register.html'">Đăng ký</button>
                                <button class="btn menu__login" onclick="window.location.href='/html/candidate/login.html'">Đăng nhập</button>
                            </div>


                            <ul class="menu__list">
                                <li class="menu__item">
                                    <a href="/html/candidate/account_Management/job_application.html" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-id-badge"></i>
                                        <span class="menu__link-title">Hồ sơ xin việc</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="/html/candidate/account_Management/job_saving.html" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-heart"></i>
                                        <span class="menu__link-title">Việc đã lưu</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="/html/candidate/account_Management/job_applied.html" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-paper-plane"></i>
                                        <span class="menu__link-title">Việc đã ứng tuyển</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-bell"></i>
                                        <span class="menu__link-title">Thông báo việc làm</span>
                                    </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <a href="/html/employer/home-employer.html" class="nav__item-link">
                        Nhà tuyển dụng

                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
