<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/12/2025
  Time: 12:28 AM
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
    <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="../asserts/css/admin/user.css">
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





        <!-- Table Section -->
        <div class="table__container">
            <h3>Quản lý tài khoản</h3>
            <div class="user__managerment">
                <form action="manager-user" method="post" class="user__search">

                    <input class="search__input" type="text" name="email" class="search__candidate" placeholder="Nhập tên,email,...">
                    <div class="search__status-filter">

                        <span>Trạng thái : </span>
                        <select name="" id="" class="search__filter">
                            <option value="">Đang hoạt động</option>
                            <option value="">Đã bị vô hiệu</option>
                        </select>
                    </div>
                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </form>


                <table>
                    <thead>

                    <th>id</th>
                    <th>Email</th>
                    <th>Mật khẩu</th>
                    <th>Loại tài khoản</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>

                    </thead>
                    <tbody>
                    <c:forEach items="${user}" var="u">
                        <tr>
                            <td>${u.userID}</td>
                            <td>${u.email}</td>
                            <td>${u.password}</td>
                            <td>${u.roleNum}</td>
                            <td>${u.status}</td>
                            <td>
                                <div class="operations">
                                    <div class="operation operation__edit">
                                        <a  href="load-users?uid=${u.userID}">
                                            <i class="fa-solid fa-pen"></i>

                                        </a>
                                    </div>
                                    <div class="operation operation__remove">
                                        <a href="delete-user?uid=${u.userID}">
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

    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const navUser = document.querySelector('.nav__admin');
        const dropdownMenu = document.querySelector('.nav__form-admin');

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