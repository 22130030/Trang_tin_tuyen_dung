<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--<%--%>
<%--    String fullPath = request.getRequestURI();--%>
<%--    String contextPath = request.getContextPath();--%>
<%--    String relativePath = fullPath.substring(contextPath.length());--%>
<%--%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:set var="relativePath" value="<%= relativePath %>" />--%>
<ul class="navbar-nav w-100">
    <li class="nav-item  ${relativePath eq '/account/account_candidate.jsp' ? 'active' : ''}">
        <a class="nav-link py-lg-4" href="${pageContext.request.contextPath}/account/account_candidate.jsp">
            <div class="title font-weight-bold mb-lg-1">
                Tài khoản
            </div>
            <p class="small d-none d-lg-block mb-0">
                Tùy chỉnh thông tin cá nhân
            </p>
        </a>
    </li>
    <li class="nav-item ${ relativePath eq "/account/change_pass.jsp" ? 'active' : ''}">
        <a class="nav-link py-lg-4" href="${pageContext.request.contextPath}/account/change_pass.jsp">
            <div class="title-1 font-weight-bold mb-lg-1">
                Đổi mật khẩu
            </div>
            <p class="small d-none d-lg-block mb-0">
                Đổi mật khẩu đăng nhập
            </p>
        </a>
    </li>
    <li class="nav-item ${ relativePath eq "/account/notifi_email.jsp" ? 'active' : ''}">
        <a class="nav-link py-lg-4" href="${pageContext.request.contextPath}/account/notifi_email.jsp">
            <div class="title-1 font-weight-bold mb-lg-1">
                Thông báo email
            </div>
            <p class="small d-none d-lg-block mb-0">
                Tùy chỉnh nhận thông báo từ timviecDCH qua email
            </p>
        </a>
    </li>
</ul>
</body>
</html>
