<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/18/2024
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/candidate/account_main.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">

    <title>Quản lý tài khoản</title>
</head>
<body>
    <div class="application">
    <%@include file="../header.jsp"%>
    <%@include file="menu_account.jsp"%>

    <div class="container">
        <div class="grid__1100">
            <div class="grid__row">
                <div class="grid__col-4">
                    <div class="container-user">
                        <div class="user__info">
                            <div class="user__info-detail">
                                <div class="user__detail-avatar">
                                    <img
                                            src="${sessionScope.image != null ? pageContext.request.contextPath.concat(sessionScope.image) : pageContext.request.contextPath.concat('/assets/img/user.png')}"                                         style="width: 100px; height: 100px;"
                                         alt="">

                                </div>
                                <div class="user__detail-contact">
                                    <div class="user__detail-content">
                                        <span class="user__detail-name">${sessionScope.user.name}</span>
                                        <a  class="user__detail-status
                                            <c:if test='${sessionScope.status eq 0}'> user__status--unverified</c:if>
                                            <c:if test='${sessionScope.status eq 1}'> user__status--verified</c:if>
                                            <c:if test='${sessionScope.status eq 2}'> user__status--pro</c:if>
                                            <c:if test='${sessionScope.status eq 3}'> user__status--premium</c:if>">
                                            <c:choose>
                                                <c:when test="${sessionScope.status eq 0}">Chưa xác thực</c:when>
                                                <c:when test="${sessionScope.status eq 1}">Đã xác thực</c:when>
                                                <c:when test="${sessionScope.status eq 2}">Tài khoản Pro</c:when>
                                                <c:when test="${sessionScope.status eq 3}">Tài khoản premium</c:when>
                                                <c:otherwise>Trạng thái không xác định</c:otherwise>
                                            </c:choose>
                                        </a>
                                    </div>
                                    <span class="user__detail-email">${sessionScope.user.email}</span>
                                </div>
                            </div>
                            <div class="user__info-edit">
                                <i class="fa-solid fa-pen"></i>
                            </div>
                            <div class="user__info-status">
                                    <span class="user__status-created">Ngày đăng ký
                                        <span>${sessionScope.user.convertCreated}</span>
                                    </span>
                                <div class="user__status-logout">
                                    <i class="fa-solid fa-right-from-bracket"></i>
                                    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                                </div>
                            </div>
                        </div>
                        <div class="user__profile">
                            <div class="user__profile-container">

                                <h3 class="user__profile-head">Hồ sơ xin việc</h3>
                                <span class="user__profile-description">Bạn được tạo tối đa 06 hồ sơ (03 hồ sơ trực
                                        tuyến và 03 hồ sơ đính kèm file từ máy tính).</span>
                                <div class="user__profile-submit">
                                    <button class="user__profile-btn">
                                        <i class="fa-solid fa-plus"></i>
                                        Tạo hồ sơ mới
                                    </button>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="grid__col-8">
                    <div class="job__status-list">
                        <div class="grid__col-4">
                            <div class="job__status-resumes job__status-item">
                                <span class="job__status-toltal">0</span>
                                <span class="job__status-title">Nhà tuyển dụng đã xem hồ sơ</span>
                            </div>
                        </div>
                        <div class="grid__col-4">
                            <div class="job__status-item job__status-saved">
<%--                                <a href="job_saving.jsp" class="job__status-saved job__status-saved-link">--%>
                                    <span class="job__status-toltal">${sessionScope.cart == null ? 0 : sessionScope.cart.size}</span>
                                    <span class="job__status-title">Việc làm đã lưu</span>
<%--                                </a>--%>
                            </div>
                        </div>
                        <div class="grid__col-4">
                            <div class="job__status-applied job__status-item">
                                <span class="job__status-toltal">${sessionScope.jobAppliedCart == null ? 0 : sessionScope.jobAppliedCart.size()}</span>
                                <span class="job__status-title">Việc làm đã ứng tuyển</span>
                            </div>
                        </div>
                    </div>
                    <div class="section-recommended-jobs">
                        <h3 class="recomended__job-head">Gợi ý việc làm</h3>
                        <span class="recomended__job-description">Gợi ý việc làm
                                Dựa trên việc làm đã xem.
                                <a href="remove-saveCart" class="recomended__job-remove">
                                    Xóa lịch sử việc làm đã xem
                                </a>
                                để nhận gợi ý mới
                            </span>
                        <div class="recomended__job-list">


                            <div class="grid__row">

                                <c:forEach var="hsj" items="${sessionScope.hsCart.list}">
                                <div class="grid__col-6">
                                    <div class="recomended__job-item">

                                        <a href="/html/job_description.html" class="suggest__link">
                                            <div class="suggest-thumb">
                                                <img src="${hsj.img}
                                                    " alt="">
                                            </div>
                                            <div class="suggest-content">

                                                <a href="/html/job_description.html" class="suggest-lable">${hsj.title}</a>
                                                <a href="/html/Job.html" class=" suggest-company">${hsj.companyName}</a>
                                                <div class="suggest-info">
                                                    <i class="fa-solid fa-location-dot"></i>
                                                    <span class="suggest-address">Hà nội</span>

                                                </div>
                                                <div class="suggest-detail">
                                                    <span class="suggest-salary">${hsj.salary}</span>
                                                    <div class="suggest-save">
                                                        <i class="fa-regular fa-heart"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

        <%@include file="../footer.jsp"%>
</div>
</body>
</html>
