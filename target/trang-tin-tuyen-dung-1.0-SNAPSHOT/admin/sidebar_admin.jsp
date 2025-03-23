<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 10:58 AM
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
<%
    String fullPath = request.getRequestURI();
    String contextPath = request.getContextPath();
    String relativePath = fullPath.substring(contextPath.length());
    System.out.println(relativePath);
%>
<div class="sidebar">
    <c:set var="relativePath" value="<%=relativePath%>"/>
    <h3>Trang chủ admin</h3>

    <a href="${pageContext.request.contextPath}/admin/report" class="${relativePath eq "/admin/admin_home.jsp" ? 'sidebar--active' : ''}" href="#">Thống kê và báo cáo</a>
    <a href="${pageContext.request.contextPath}/admin/company-user-job" class="${relativePath eq "/admin/admin_employer.jsp" ? 'sidebar--active' : ''}">Quản lý nhà tuyển dụng</a>
    <a href="${pageContext.request.contextPath}/admin/candidate-user-find" class="${relativePath eq "/admin/admin_candidate.jsp" ? 'sidebar--active' : ''}">Quản lý ứng viên</a>
    <a href="${pageContext.request.contextPath}/admin/job_manager" class="${relativePath eq "/admin/admin_jobs.jsp" ? 'sidebar--active' : ''}">Quản lý bài đăng</a>
    <a href="${pageContext.request.contextPath}/admin/manager-category" class="${relativePath eq "/admin/admin_category.jsp" ? 'sidebar--active' : ''}">Quản lý ngành nghề</a>
    <a href="${pageContext.request.contextPath}/admin/manager-user" class="${relativePath eq "/admin/admin_user.jsp" ? 'sidebar--active' : ''}">Quản lý tài khoản</a>
</div>
</body>
</html>
