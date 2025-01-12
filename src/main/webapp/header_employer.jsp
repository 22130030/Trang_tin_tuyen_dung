<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="nav-sticky">
    <div class="header">
        <!-- navigation -->
        <nav class="nav__employer">
            <div class="grid">
                <div class="nav__employer-container">

                    <div class="nav__logo">
                        <a href="${pageContext.request.contextPath}/employer_home.jsp" class="nav__logo-link">
                            <img src="${pageContext.request.contextPath}/asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                        </a>
                    </div>
                    <div class="nav__employer-list">
                        <li class="nav__employer-user">
                            <i class="fa-solid fa-building"></i>
                            <span>Đăng ký</span>
                            <div class="nav__employer-form">
                                <div class="menu__buttons">
                                    <button class="btn menu__register" onclick="window.location.href=''">Đăng ký</button>
                                    <button class="btn menu__login" onclick="window.location.href=''">Đăng nhập</button>
                                </div>
                            </div>

                            <div class="nav__employer-logged-in">
                                <div class="nav__employer-info-company">
                                    <div class="ne__info-logo">
                                        <img src="https://static.careerlink.vn/web/images/common/no-logo.png" alt="">
                                    </div>
                                    <div class="ne__info-edit">
                                        <span class="ne__info-name">Công ty 3 thành viên</span>
                                        <a href="" class="ne__info-edit-info">Chỉnh sửa thông tin công ty</a>

                                    </div>
                                </div>
                                <ul class="ne__info-list">
                                    <li class="ne__info-item">
                                        <i class="fa-solid fa-gear"></i>
                                        <a href="/html/employer/setting.html" class="ne__info-link">
                                            Cài đặt tài khoản
                                        </a>
                                    </li>
                                    <li class="ne__info-item ne__info-logout">
                                        <i class="fa-solid fa-right-from-bracket"></i>
                                        <a href="/html/employer/home-employer.html" class="ne__info-link">
                                            Đăng xuất

                                        </a>
                                    </li>
                                </ul>

                            </div>

                        </li>
                        <li class="nav__employer-item">
                            <a href="${pageContext.request.contextPath}/home" class="nav__item-link">

                                <li class="nav__employer-item nav__item-link--separated">
                                    <span style="color : white" class="nav__item-link">
                                        Cho người tìm việc

                                    </span>
                                </li>
                            </a>
                        </li>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const navUser = document.querySelector('.nav__employer-user');
        const dropdownMenu = document.querySelector('.nav__employer-form');

        // Hiển thị menu khi click vào `.nav__has--form-login`
        navUser.addEventListener('click', function (event) {
            event.stopPropagation();
            dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
        });

        // Đóng menu khi click ra ngoài
        document.addEventListener('click', function (event) {
            if (!navUser.contains(event.target) && !dropdownMenu.contains(event.target)) {
                dropdownMenu.style.display = 'none';
            }
        });
    });
</script>
</body>
</html>
