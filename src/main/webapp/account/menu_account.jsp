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


    <title></title>
</head>
<body>
<%
    String fullPath = request.getRequestURI();
    String contextPath = request.getContextPath();
    String relativePath = fullPath.substring(contextPath.length());
%>
<c:set var="relativePath" value="<%= relativePath %>" />
        <div class="nav__menu">
    <div class="grid__1100">
        <ul class="nav__menu-list">
            <li class="nav__menu-item">
                <a href="${pageContext.request.contextPath}/account/home_account.jsp" class="nav__menu__link ${relativePath eq '/account/home_account.jsp' ? 'nav__menu-active' : ''}">
                    <c:if test="${relativePath eq '/account/home_account.jsp'}">
                        <div class="nav-menu__has-separated"></div>
                    </c:if>
                    <i class="fa-solid fa-house"></i>
                    <span class="nav__menu-title">Tổng quan</span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="${pageContext.request.contextPath}/account/upload-file" class="nav__menu__link ${relativePath eq '/account/job_application.jsp' ? 'nav__menu-active' : ''}">
                    <c:if test="${relativePath eq '/account/job_application.jsp'}">
                        <div class="nav-menu__has-separated"></div>
                    </c:if>

                    <i class="fa-regular fa-address-card"></i>
                    <span class="nav__menu-title">Hồ sơ xin việc(
                                <span class="nav__menu-toltal">${sessionScope.jac == null ? 0 : sessionScope.jac.size()}</span>
                                )
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="${pageContext.request.contextPath}/account/job_saving.jsp" class="nav__menu__link ${relativePath eq '/account/job_saving.jsp' ? 'nav__menu-active' : ''}">
                    <c:if test="${relativePath eq '/account/job_saving.jsp'}">
                        <div class="nav-menu__has-separated"></div>
                    </c:if>


                    <i class="fa-regular fa-heart"></i>
                    <span class="nav__menu-title">Việc làm đã lưu(
                                <span class="job__saving-toltal nav__menu-toltal">${sessionScope.cart == null ? 0 : sessionScope.cart.size}</span>
                                )
                            </span>
                </a>
            </li>
            <li class="nav__menu-item">
                <a href="${pageContext.request.contextPath}/account/job_applied.jsp" class="nav__menu__link ${relativePath eq '/account/job_applied.jsp' ? 'nav__menu-active' : ''}">
                    <c:if test="${relativePath eq '/account/job_applied.jsp'}">
                        <div class="nav-menu__has-separated"></div>
                    </c:if>
                    <i class="fa-regular fa-paper-plane"></i>

                    <span class="nav__menu-title">Việc làm đã ứng tuyển(
                                <span class="nav__menu-toltal">${sessionScope.jobAppliedCart == null ? 0 : sessionScope.jobAppliedCart.size()}</span>
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
</body>
</html>
