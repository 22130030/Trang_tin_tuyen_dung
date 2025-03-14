<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/16/2025
  Time: 7:19 AM
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
    <link rel="stylesheet" href="../asserts/css/main_save_profile.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div class="application">
        <%@include file="../header_employer.jsp"%>
        <div class="d-flex justify-content-start" id="main-screen" style="position: relative;">
            <%@include file="sidebar_employer.jsp"%>
            <div class="my-careerlink-screen">
                <div class="my-careerlink bg-white mb-md-4 mb-0">
                    <div class="container px-0 px-lg-3">
                        <h1 class="h4 page-title p-3 px-md-0 m-0">
                            Hồ sơ đã lưu
                        </h1>
                    </div>
                </div>
                <!-- container2 -->
                <div class="container2">
                    <div class="header">
                        <input type="text" placeholder="Không có thư mục nào" class="search-bar">
                        <button class="more-options">...</button>
                    </div>
                    <div class="dropdown">
                        <button class="dropdown-button">
                            Lưu lúc <span class="arrow">&#9662;</span>
                        </button>
                        <div class="dropdown-menu">
                            <label>
                                <input type="radio" name="filter" checked>
                                <span>All</span>
                            </label>
                            <label>
                                <input type="radio" name="filter">
                                <span>Past 3 days</span>
                            </label>
                            <label>
                                <input type="radio" name="filter">
                                <span>Past 7 days</span>
                            </label>
                            <label>
                                <input type="radio" name="filter">
                                <span>Past 30 days</span>
                            </label>
                            <label>
                                <input type="radio" name="filter">
                                <span>Past 120 days</span>
                            </label>
                        </div>
                    </div>
                    <script>
                        const button = document.querySelector('.dropdown-button');
                        const menu = document.querySelector('.dropdown-menu');

                        button.addEventListener('click', () => {
                            menu.classList.toggle('show');
                        });

                        window.addEventListener('click', (e) => {
                            if (!document.querySelector('.dropdown').contains(e.target)) {
                                menu.classList.remove('show');
                            }
                        });
                    </script>
                    <table class="table">
                        <thead class="table-header">
                        <tr>
                            <th>Lưu lúc</th>
                            <th>Số điện thoại</th>
                            <th>Tiêu Đề</th>
                            <th>Lần Cuối Cập Nhật</th>
                            <th>loại hồ sơ</th>
                        </tr>
                        </thead>
                        <tbody class="table-body">
                        <c:forEach items="${sessionScope.resumeCart.list}" var="r">

                        <tr>
                            <td>${r.convertCreated}</td>
                            <td>${r.phone}</td>
                            <td>
                                <a href="download-file?path=${r.encodingPath}" class="title">${r.title}</a>

                            </td>
                            <td>${r.convertUpdated}</td>
                            <td>${r.type}</td>
                        </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
             </div>
            <%@include file="../footer.jsp"%>
    </div>
</body>
</html>
