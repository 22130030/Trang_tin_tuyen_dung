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

</head>
<body>
    <div class="nav-sticky">
    <nav class="nav">
        <div class="grid nav__container">
            <div class="nav__logo">
                <a href="${pageContext.request.contextPath}/home" class="nav__logo-link">
                    <img src="${pageContext.request.contextPath}/asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                </a>
            </div>
            <ul class="nav__list">
                <li class="nav__item">
                    <a href="location-industry" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-magnifying-glass"></i>
                        Ngành nghề/Địa điểm
                    </a>
                </li>
                <li class="nav__item">
                    <a href="${pageContext.request.contextPath}/company" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-city"></i>
                        Công ty
                    </a>
                </li>

                <li class="nav__item">
                    <a href="${pageContext.request.contextPath}/career_handbook.jsp" class="nav__item-link">
                        <i class="nav-item__icon fa-solid fa-book-open"></i>
                        Cẩm nang việc làm
                    </a>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <a href="${pageContext.request.contextPath}/chat" class="nav__item-link">
                        <i class="nav-item__icon fa-regular fa-message"></i>
                        Chat
                    </a>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <div class="nav__item-link nav__user nav__has--form-login">
                        <c:if  test="${empty sessionScope.user}">

                            <div class="nav__user-icon">
                                <i class="fa-regular fa-user"></i>
                            </div>
                            Đăng ký

                        </c:if>
                        <c:if test="${not empty sessionScope.user}">
                            <div class="nav__user-icon">
                                <img class="nav__user-img"
                                     src="${sessionScope.image != null ? pageContext.request.contextPath.concat(sessionScope.image) : pageContext.request.contextPath.concat('/assets/img/user.png')}"                                     style="width: 30px; height: 30px;" alt="">
                            </div>
                            ${sessionScope.user.name}
                        </c:if>
                            <div class="nav__dropdown-menu">
                                <div style="display: ${sessionScope.user == null ? 'flex' : 'none'}"  class="menu__buttons">
                                    <button class="btn menu__register" onclick="window.location.href='${pageContext.request.contextPath}/register.jsp'">Đăng ký</button>
                                    <button class="btn menu__login" onclick="window.location.href='${pageContext.request.contextPath}/login.jsp'">Đăng nhập</button>
                                </div>
                            <ul class="menu__list">
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/upload-file" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-id-badge"></i>
                                        <span class="menu__link-title">Hồ sơ xin việc</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/job_saving.jsp" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-heart"></i>
                                        <span class="menu__link-title">Việc đã lưu</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/job_applied.jsp" class="menu__link">
                                        <i class="menu__link-icon fa-regular fa-paper-plane"></i>
                                        <span class="menu__link-title">Việc đã ứng tuyển</span>
                                    </a>
                                </li>
                            <c:if  test="${!empty sessionScope.user}">

                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/account_candidate.jsp" class="menu__link">
                                        <i class="fa-regular fa-user"></i>
                                        <span class="menu__link-title">Tài khoản của tôi</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/upgrade_account.jsp" class="menu__link">
                                        <i class="fa-solid fa-circle-up"></i>
                                        <span class="menu__link-title">Nâng cấp tài khoản</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/account/notifi_email.jsp" class="menu__link">
                                        <i class="fa-solid fa-bell"></i>
                                        <span class="menu__link-title">Quản lý thông báo</span>
                                    </a>
                                </li>
                                <li class="menu__item">
                                    <a href="${pageContext.request.contextPath}/logout" class="menu__link menu__link-logout">
                                        <i class="fa-solid fa-right-from-bracket"></i>
                                        <span class="menu__link-title">Đăng xuất</span>
                                    </a>
                                </li>
                            </c:if>
                            </ul>
                        </div>

                    </div>
                </li>
                <li class="nav__item nav__item-link--separated">
                    <a href="${pageContext.request.contextPath}/employer-home" class="nav__item-link">
                        Nhà tuyển dụng

                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const navUser = document.querySelector('.nav__has--form-login');
        const dropdownMenu = document.querySelector('.nav__dropdown-menu');


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
