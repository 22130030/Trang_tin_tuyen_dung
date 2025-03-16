<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 12:30 PM
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
  System.out.println(relativePath);
%>
<c:set  var="relativePath" value="<%= relativePath%>" />
<div class="d-lg-block sidebar sidebar-expanded" id="sidebar">
  <div class="sidebar__inner flex-column d-flex">
    <div class="sidebar-top">
      <div class="my-careerlink">
        <a class="nav-link bs-tooltip ${relativePath eq "/employer/employer.jsp" ? 'active' : ''}" role="button" title="" href="${pageContext.request.contextPath}/employer/employer.jsp">
          <i class="fa-solid fa-house"></i>
          <span class="item-label">
                             My TimviecDCH</span>
        </a>
      </div>
      <div class="sidebar-content">
        <div class="jobs-menu">
                            <span class="navbar-collapse-button ml-auto" ref="#jobsCollapse">
                                <span class="item-label">
                                    Công Việc</span>
                                </span>
          <div class="sidebar__item my__job-item">
            <a class="nav-link bs-tooltip ${relativePath eq "/employer/myJob_employer.jsp" ? 'active' : ''}" role="button" href="${pageContext.request.contextPath}/employer/myJob-controller">
              <span class="item-label text-truncate">Công việc của tôi</span>
            </a>
          </div>
          <div class="sidebar__item my__job-item">
            <a class="nav-link bs-tooltip ${relativePath eq "/employer/jobPosting_employer.jsp" ? 'active' : ''}" role="button" href="${pageContext.request.contextPath}/employer/job-posting">
              <span class="item-label text-truncate">Đăng Tuyển dụng</span>
            </a>
          </div>
        </div>
        <div class="my-candidates">
                            <span class="navbar-collapse-button ml-auto" href="#myCandidates">
                                <span class="item-label">
                                    Ứng viên của tôi</span>
                            </span>
          <div class="sidebar__item my__candidates-item">
            <a class="nav-link bs-tooltip ${relativePath eq "/employer/findResumes_employer.jsp" ? 'active' : ''}" href="${pageContext.request.contextPath}/employer/find-profile">
              <span class="item-label text-truncate">Tìm Hồ sơ</span>
            </a>
          </div>
          <div class="sidebar__item my__candidates-item">
            <a class="nav-link bs-tooltip ${relativePath eq "/employer/jobApplication_letter.jsp" ? 'active' : ''}" href="${pageContext.request.contextPath}/employer/application-letter">
              <span class="item-label text-truncate">Thư xin việc đã nhận</span>
            </a>
          </div>
          <div class="sidebar__item my__candidates-item">
            <a class="nav-link bs-tooltip" href="/html/employer/save_profile.html">
              <span class="item-label text-truncate">Hồ sơ đã lưu</span>
            </a>
          </div>

        </div>

      </div>
    </div>
    <div class="sidebar-bottom">
      <div class="sidebar__item get-helps">
        <a class="nav-link bs-tooltip" href="/html/employer/support.html">
          <i class="fa-regular fa-circle-question"></i>
          <span class="item-label">
                                Hỗ trợ</span>
        </a>
      </div>
      <div class="sidebar__item setting">
        <a class="nav-link bs-tooltip" title="" href="/html/employer/setting.html">
          <i class="fa-solid fa-gear"></i>
          <span class="item-label">
                                Cài đặt</span>
        </a>
      </div>
      <div class="account overflow-hidden">
        <a class="d-flex align-items-center mw-100" style="min-height: 48px" href="/html/employer/employer.html">
          <div class="avatar rounded-circle">
            <img alt="avatar" height="32" width="32" class="employer-logo rounded-circle border"
                 src="https://static.careerlink.vn/web/images/common/no-logo.png">
          </div>
          <div class="user-info d-flex flex-column item-label ml-2">
                                <span class="d-inline-block m-0 p-0 item-label text-truncate" style="max-width: 170px">
                                    công ty 3 thành viên
                                </span>
            <div class="email d-inline-block m-0 text-truncate" style="max-width: 170px">
              leminhcong8323@gmail.com
            </div>
          </div>
        </a>
      </div>
    </div>
    <div dir="ltr" class="resize-sensor"
         style="pointer-events: none; position: absolute; inset: 0px; overflow: hidden; z-index: -1; visibility: hidden; max-width: 100%;">
      <div class="resize-sensor-expand"
           style="pointer-events: none; position: absolute; inset: 0px; overflow: hidden; z-index: -1; visibility: hidden; max-width: 100%;">
        <div
                style="position: absolute; left: 0px; top: 0px; transition: all; width: 250px; height: 686px;">
        </div>
      </div>
      <div class="resize-sensor-shrink"
           style="pointer-events: none; position: absolute; inset: 0px; overflow: hidden; z-index: -1; visibility: hidden; max-width: 100%;">
        <div
                style="position: absolute; left: 0px; top: 0px; transition: all; width: 200%; height: 200%;">
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
