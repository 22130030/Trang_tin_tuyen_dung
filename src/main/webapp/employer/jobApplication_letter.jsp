<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/14/2025
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.quilljs.com/1.3.7/quill.snow.css" rel="stylesheet">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
    <!-- Style -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="../asserts/css/main_job_posting.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/main_application_letter_received.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
    <!-- title -->
    <title>save_profile</title></head>
<body>
<div class="application">
    <%@include file="../header_employer.jsp"%>
    <div class="d-flex justify-content-start" id="main-screen" style="position: relative;">
        <%@include file="sidebar_employer.jsp"%>
        <div class="my-careerlink-screen">
            <div class="my-careerlink bg-white mb-md-4 mb-0">
                <div class="container px-0 px-lg-3">
                    <h1 class="h4 page-title p-3 px-md-0 m-0">
                        Thư xin việc đã nhận
                    </h1>
                </div>
            </div>
            <div class="filters">
                <label for="job-title">Tên công việc:</label>
                <select id="job-title" onchange="redirectToServlet()">
                    <c:forEach items="${jobs}" var="j">
                        <option value="${j.id}" <c:if test="${j.id == selectedJobId}">
                            selected
                        </c:if>>${j.title}</option>
                    </c:forEach>
                </select>
                <button>Chi Tiết</button>
            </div>
            <div class="summary">
                <div class="summary-item">
                    <p>Tổng số ứng viên</p>
                    <p>0<i class="fa-solid fa-folder"></i></p>
                </div>
                <div class="summary-item">
                    <p>Tổng số lượt xem</p>
                    <p>0<i class="fa-solid fa-eye"></i></p>
                </div>
                <div class="summary-item">
                    <p>Ngày đăng</p>
                    <p>25/11/2024</p>
                </div>
            </div>
            <div class="container2">
                <div class="table-filters">
                    <select>
                        <option>Tất cả thư xin việc (0)</option>
                    </select>
                    <select>
                        <option>Nhận trong vòng</option>
                    </select>
                </div>
                <div class="table-container">

                    <table>
                        <thead>
                        <tr>
                            <th>Thư xin việc</th>
                            <th>Nhận lúc</th>
                            <th>Trạng thái</th>
                            <th>Loại</th>
                            <th>Ghi chú</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
<%--                        <tr>--%>
<%--                            <td colspan="6" class="no-data">--%>
<%--                                <div class="empty-state">--%>
<%--                                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNPb-YTyZbu9OMLUJM5QRTN0o05ABeQbR7GA&s" alt="Empty" />--%>
<%--                                    <p>Chưa có ứng viên nào ứng tuyển</p>--%>
<%--                                    <button>Tìm ứng viên ngay</button>--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
                        <c:forEach items="${files}" var="f">
                        <tr>
                            <td  class="has-data">
                                <a href="download-file?path=${f.encodingPath}" class="text-truncate">
                                    ${f.title}
                                </a>
                            </td>
                            <td class="has-data">
                                    ${f.convertCreated}
                            </td>
                            <td class="has-data">
                                ${f.title}
                            </td>
                            <td class="has-data">
                                ${f.type}
                            </td>
                            <td class="has-data">
                                ${f.title}
                            </td>
                            <td class="has-data">
                                ${f.title}
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>



        </div>
    </div>
    <%@include file="../footer.jsp"%>
</div>
<script>
    function redirectToServlet() {
        const select = document.getElementById("job-title");
        const jobId = select.value; // Lấy ID của công việc
        if (jobId) {
            // Redirect đến servlet với jobId
            console.log(jobId);
            window.location.href = `search-job-application?jobId=` + jobId;
        }
    }
</script>
</body>
</html>
