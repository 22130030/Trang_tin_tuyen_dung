<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="<%= request.getContextPath() %>/js/account_change.js"></script>
<script>
    const CONTEXT_PATH = "${pageContext.request.contextPath}";
    console.log(CONTEXT_PATH)
</script>
<div id="changePopup">
    <div class="popup-content">
        <h3>Tài khoản của bạn đã bị thay đổi</h3>
        <p>Vui lòng đăng nhập lại.</p>
        <p><strong>🌐 Hỗ trợ trực tuyến:</strong>
            <a href="https://example.com/ho-tro" target="_blank">example.com/ho-tro</a>
        </p>
        <button onclick="redirectToLogin()">Đăng xuất</button>
    </div>
</div>
<header class="header">
    <nav class="nav">
        <div class="grid nav__container">
            <div class="nav__logo">
                <a href="${pageContext.request.contextPath}/admin/report" class="nav__logo-link">
                    <img src="../asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                </a>
            </div>
            <ul class="nav__list">

                <li class="nav__item ">
                    <div class="nav__item-link nav__admin nav__form-logged-in">
                        <div class="nav__admin-icon">
                            <i class="fa-regular fa-user"></i>
                        </div>
                        ${sessionScope.user.name}

                        <div class="nav__form-admin">



                            <ul class="form-admin__list">
                                <!-- <li class="form-admin__item">
                                    <a href="" class="form-admin__link">
                                        <i class="fa-solid fa-gear"></i>
                                        <span class="form-admin__link-title">Quản lí tài khoản</span>
                                    </a>
                                </li> -->


                                <li class="form-admin__item">
                                    <a href="${pageContext.request.contextPath}/logout" class="form-admin__item-link">
                                        <i class="fa-solid fa-right-from-bracket"></i>
                                        <span class="form-admin__link-title">Đăng xuất</span>

                                    </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </li>

            </ul>
        </div>
    </nav>
</header>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const navUser = document.querySelector('.nav__admin');
        const dropdownMenu = document.querySelector('.nav__form-admin');

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
