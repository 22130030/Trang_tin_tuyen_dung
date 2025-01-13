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
    <link rel="stylesheet" href="asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="asserts/css/admin/user.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Admin</title>
</head>
<body>
<div class="admin">

    <header class="header">
        <nav class="nav">
            <div class="grid nav__container">
                <div class="nav__logo">
                    <a href="#" class="nav__logo-link">
                        <img src="asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                    </a>
                </div>
                <ul class="nav__list">

                    <li class="nav__item ">
                        <div class="nav__item-link nav__admin nav__form-logged-in">
                            <div class="nav__admin-icon">
                                <i class="fa-regular fa-user"></i>
                            </div>
                            Admin

                            <div class="nav__form-admin">



                                <ul class="form-admin__list">
                                    <!-- <li class="form-admin__item">
                                        <a href="" class="form-admin__link">
                                            <i class="fa-solid fa-gear"></i>
                                            <span class="form-admin__link-title">Quản lí tài khoản</span>
                                        </a>
                                    </li> -->


                                    <li class="form-admin__item">
                                        <a href="/" class="form-admin__item-link">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <span class="form-admin__link-title">Đăng xuất</span>

                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <div class="container">

        <!-- Sidebar -->
        <div class="sidebar">
            <h3>Trang chủ admin</h3>
            <a  href="/html/admin/admin_home.html">Thống kê và báo cáo</a>
            <a  href="/html/admin/admin_employer.html">Quản lý nhà tuyển dụng</a>
            <a  href="/html/admin/candidate.html">Quản lý ứng viên</a>
            <a href="/html/admin/admin_jobs.html">Quản lý bài đăng</a>
            <a href="/html/admin/admin_category.html">Quản lý ngành nghề</a>
            <a class="sidebar--active" href="#">Quản lý tài khoản</a>
        </div>




        <!-- Table Section -->
        <div class="table__container">
            <h3>Quản lý ứng viên</h3>
            <div class="user__managerment">
                <div class="user__search">

                    <input class="search__input" type="text" name="name" class="search__candidate" placeholder="Nhập tên,email,...">
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
                </div>


                <table>
                    <thead>

                    <th>id</th>
                    <th>Email</th>
                    <th>Mật khẩu</th>
                    <th>Loại tài khoản</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>

                    </thead>
                    private int userID;
                    private String email;
                    private String password;
                    private String phone_number;
                    private String status;
                    private LocalDateTime created_at;
                    private int roleNum;
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
                                        <a class="operation__edit-link" href="">
                                            <i class="fa-solid fa-pen"></i>

                                        </a>
                                    </div>
                                    <div class="operation operation__remove">
                                        <i class="fa-solid fa-trash"></i>
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