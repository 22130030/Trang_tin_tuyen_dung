<%-- Created by IntelliJ IDEA. User: PHUC Date: 1/11/2025 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employer Navigation</title>
</head>
<body>
<div class="nav-sticky">
    <div class="header">
        <!-- navigation -->
        <nav class="nav__employer">
            <div class="grid">
                <div class="nav__employer-container">
                    <div class="nav__logo">
                        <a href="${pageContext.request.contextPath}/employer-home" class="nav__logo-link">
                            <img src="${pageContext.request.contextPath}/asserts/img/brand-logo@2x.png" alt="Brand Logo" class="nav-logo__img">
                        </a>
                    </div>
                    <div class="nav__employer-list">
                        <li class="nav__item nav__item-link--separated">
                            <a href="${pageContext.request.contextPath}/employer-chat" class="nav__item-link nav__item-link--employer">
                                <i class="nav-item__icon fa-regular fa-message"></i>
                                Chat
                            </a>
                        </li>
                        <li class="nav__employer-user">
                            <i class="fa-solid fa-building"></i>
                            <span>${sessionScope.companyUser == null ? 'Đăng ký' : sessionScope.companyUser.name}</span>
                            <c:if test="${empty sessionScope.companyUser}">
                                <div class="nav__employer-logged-in">
                                    <div class="menu__buttons">
                                        <button class="btn menu__register" onclick="window.location.href='${pageContext.request.contextPath}/register_for_employer.jsp'">Đăng ký</button>
                                        <button class="btn menu__login" onclick="window.location.href='${pageContext.request.contextPath}/login_employer.jsp'">Đăng nhập</button>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${not empty sessionScope.companyUser}">
                                <div class="nav__employer-logged-in" style="display: none;">
                                    <div class="nav__employer-info-company">
                                        <div class="ne__info-logo">
                                            <img src="https://static.careerlink.vn/web/images/common/no-logo.png" alt="Company Logo">
                                        </div>
                                        <div class="ne__info-edit">
                                            <span class="ne__info-name">${sessionScope.companyUser.name}</span>
                                            <a href="${pageContext.request.contextPath}/employer/edit_info.jsp" class="ne__info-edit-info">Chỉnh sửa thông tin công ty</a>
                                        </div>
                                    </div>
                                    <ul class="ne__info-list">
                                        <li class="ne__info-item">
                                            <i class="fa-solid fa-gear"></i>
                                            <a href="${pageContext.request.contextPath}/employer/settings.jsp" class="ne__info-link">Cài đặt tài khoản</a>
                                        </li>
                                        <li class="ne__info-item ne__info-logout">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a href="${pageContext.request.contextPath}/employer_logout" class="ne__info-link">Đăng xuất</a>
                                        </li>
                                    </ul>
                                </div>
                            </c:if>
                        </li>
                        <li class="nav__employer-item">
                            <a href="${pageContext.request.contextPath}/home" class="nav__item-link">
                                <span style="color: white;">Cho người tìm việc</span>
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
        const dropdownMenu = document.querySelector('.nav__employer-logged-in');

        // Kiểm tra null trước khi thêm sự kiện
        if (navUser && dropdownMenu) {
            // Hiển thị menu khi click vào `.nav__employer-user`
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
        }
    });
</script>
</body>
</html>
