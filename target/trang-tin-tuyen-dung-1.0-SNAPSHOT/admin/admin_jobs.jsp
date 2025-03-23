<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/12/2025
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">;
    <link rel="stylesheet" href="../asserts/css/admin/admin_jobs.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Admin</title>

</head>

<body>
<div class="admin">

    <%@include file="header_admin.jsp"%>
    <div class="container">

        <!-- Sidebar -->
        <%@include file="sidebar_admin.jsp"%>

        <div class="content" id="content__section">
            <h3>Quản lý bài đăng</h3>
            <div class="jobs_management">
                <form action="job_manager" method="post" class="jobs__search">
                    <input class="search__input" type="text" name="name" class="search__candidate"
                           placeholder="Nhập tiêu đề,...">
                    <div class="search__status-filter">

                        <span>Trạng thái : </span>
                        <select name="" id="" class="search__filter">
                            <option value="">Đã duyệt</option>
                            <option value="">Chưa duyệt</option>
                            <option value="">Đã từ chối</option>
                        </select>
                    </div>
                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </form>
                <div class="jobs__add">

                    <h4 class="job__add-list">Danh sách bài đăng :
                        <a href="add" class="list__add-link">thêm mới</a>
                    </h4>
                </div>
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Hình ảnh</th>
                    <th>Tiêu đề</th>
                    <th>Tên công ty</th>
                    <th>Địa chỉ</th>
                    <th>Lương</th>
                    <th>Thời gian đăng</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>

                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="l">
                        <tr>
                            <td>${l.id}</td>
                            <td class="job__column-img">
                                <div class="job__column-item">
                                    <img src="${l.img}" alt="">
                                </div>
                            </td>
                            <td>${l.title}</td>
                            <td>${l.companyName}</td>
                            <td>${l.city}</td>
                            <td>${l.salary}</td>
                            <td>${l.created}</td>
                            <td>${l.status}</td>
                            <td>
                                <div class="operations">
                                    <div class="operation operation__edit">
                                       <a href="load-job-post?lid=${l.id}">
                                           <i class="fa-solid fa-pen"></i>
                                       </a>
                                    </div>
                                    <div class="operation operation__remove">
                                        <a href="delete-jobposting?jid=${l.id}">
                                            <i class="fa-solid fa-trash"></i>
                                        </a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <div id="addJobsForm">
            <h3 class="form__title">Thêm bài đăng</h3>
            <form class="form__content" action="">
                <div class="form__item">

                    <label for="name">Tiêu đề bài đăng : </label>
                    <input type="text" id="text" name="text" required><br>
                </div>
                <div class="form__item">

                    <label for="name">Thêm hình ảnh : </label>
                    <input class="upload__img" type="file" id="image" name="image" accept="image/*" required>
                </div>
                <div class="form__item">
                    <label for="company_name">Tên công ty :</label>
                    <input type="text" id="company" name="company" required><br>
                </div>
                <div class="form__item">
                    <label for="address">Thành phố :</label>
                    <input class="address__input" type="text" id="address" name="address" required><br>
                </div>
                <div class="form__item">
                    <label for="number">Mức lương :</label>
                    <input type="number" id="number" name="number" required><br>
                </div>



                <button class="form__submit" type="submit">Thêm bài đăng</button>

            </form>
        </div>



    </div>
</div>
</body>

</html>
