<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12/26/2024
  Time: 9:35 AM
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
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/admin/admin_employer.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Admin</title>

<%--    <script>--%>
<%--        function editEmployerForm(){--%>
<%--            var employerForm = document.getElementById("editEmployerForm");--%>

<%--            var employerTable = document.getElementById("table-container");--%>
<%--            if(employerForm.style.display === '' || employerForm.style.display === 'none'){--%>
<%--                employerForm.style.display = 'block';--%>
<%--            }else{--%>
<%--                employerForm.style.display = 'none';--%>
<%--            }--%>
<%--            if(employerTable.style.display === '' || employerTable.style.display === 'block'){--%>
<%--                employerTable.style.display = 'none';--%>
<%--            }else{--%>
<%--                employerTable.style.display = 'block';--%>
<%--            }--%>
<%--        }--%>
<%--        document.addEventListener('DOMContentLoaded', function () {--%>
<%--            const navUser = document.querySelector('.nav__admin');--%>
<%--            const dropdownMenu = document.querySelector('.nav__form-admin');--%>

<%--            // Hiển thị menu khi click vào `.nav__has--form-login`--%>
<%--            navUser.addEventListener('click', function (event) {--%>
<%--                event.stopPropagation();--%>
<%--                dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';--%>
<%--            });--%>

<%--            // Đóng menu khi click ra ngoài--%>
<%--            document.addEventListener('click', function (event) {--%>
<%--                if (!navUser.contains(event.target) && !dropdownMenu.contains(event.target)) {--%>
<%--                    dropdownMenu.style.display = 'none';--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

</head>
<body>
<div class="admin">

    <header class="header">
        <nav class="nav">
            <div class="grid nav__container">
                <div class="nav__logo">
                    <a href="/html/admin/admin_home.html" class="nav__logo-link">
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
            <a class="sidebar--active"  href="#">Quản lý nhà tuyển dụng</a>
            <a href="/html/admin/candidate.html">Quản lý ứng viên</a>
            <a href="/html/admin/admin_jobs.html">Quản lý bài đăng</a>
            <a href="/html/admin/admin_category.html">Quản lý ngành nghề</a>
            <a href="/html/admin/user.html">Quản lý tài khoản</a>
        </div>




        <!-- Table Section -->
        <div id="table-container">
            <h3>Quản lý nhà tuyển dụng</h3>
            <div  class="employer_management" >
                <form class="employer__search" action="company-user-job" method="post">
                    <input class="search__input" type="text" name="searchEmail" class="search__candidate" placeholder="Nhập tên,email,...">
                    <div class="search__status-filter">
                        <span>Trạng thái : </span>
                        <select name="" id="" class="search__filter">
                            <c:forEach var="s" items="${status}">
                                <a href="company-user-job?statusID=${s.statusID}">
                                <option value="${s.statusID}">${s.statusName}</option>
                                </a>
                            </c:forEach>
                        </select>

                    </div>
                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </form>
                </h4>

                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên Công ty</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Trạng thái</th>
                        <th>Ngày đăng ký</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>

                    <c:forEach var="e" items="${email}">
                    <tbody>
                    <tr>
                        <td>${e.id}</td>
                        <td class="company__name">${e.companyName}</td>
                        <td>${e.email}</td>
                        <td>${e.phone_number}</td>
                        <td class = "company_status">${e.status}</td>
                        <td>${e.createDate}</td>
                        <td>
                            <div class="operations">


                                <div class="operation operagit add .tion__edit">
                                    <a href="loaduser?pid=${e.id}" class="operation__edit-link">
                                        <i class="fa-solid fa-pen"></i>
                                    </a>
                                </div>
                                <div class="operation operation__remove">
                                    <a href="delete-company?pid=${e.id}" class="delete"> <i class="fa-solid fa-trash"></i></a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
<%--        <div id="editEmployerForm">--%>
<%--            <h3 class = "form__title">Chỉnh sửa thông tin nhà tuyển dụng</h3>--%>
<%--            <form class="form__content" action="company-user-job" method="post">--%>
<%--&lt;%&ndash;                <c:forEach var="e" items="${email}">&ndash;%&gt;--%>
<%--                <div class="form__item">--%>
<%--                    <label for="name">Email : </label>--%>
<%--&lt;%&ndash;                    <input value="${email}" type="email" id="email" name="email" required placeholder="Email"><br>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <div class="form__item">--%>
<%--                    <label for="company_name">Tên công ty :</label>--%>
<%--&lt;%&ndash;                    <input value="${companyName}" type="text" id="company" name="company" required><br>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <div class="form__item">--%>
<%--                    <label for="phone">Số Điện Thoại:</label>--%>
<%--&lt;%&ndash;                    <input value="${email.phone_number}" type="text" id="phone" name="phone" required><br>&ndash;%&gt;--%>
<%--                </div>--%>

<%--                <div class="form__item">--%>
<%--                    <label for="address">Địa chỉ : </label>--%>
<%--                    <div class="form__address-city">--%>

<%--                        <select id="province" name="province" required>--%>
<%--                            <option class="select__head" value=""> Chọn Tỉnh/Thành phố --</option>--%>
<%--                            <option value="hanoi">Hà Nội</option>--%>
<%--                            <option value="hochiminh">TP Hồ Chí Minh</option>--%>
<%--                            <option value="danang">Đà Nẵng</option>--%>
<%--                        </select>--%>

<%--                        <!-- Quận/Huyện -->--%>
<%--                        <select id="district" name="district" required>--%>
<%--                            <option class="select__head" value=""> Chọn Quận/Huyện --</option>--%>
<%--                        </select>--%>

<%--                        <!-- Phường/Xã -->--%>
<%--                        <select id="ward" name="ward" required>--%>
<%--                            <option class="select__head" value=""> Chọn Phường/Xã --</option>--%>
<%--                        </select>--%>

<%--                    </div>--%>
<%--                    <div class="form__item">--%>

<%--                        <!-- Địa chỉ chi  -->--%>
<%--                        <label class="address__detail" for="detail">Địa chỉ chi tiết:</label>--%>
<%--&lt;%&ndash;                        <input value="${email.address}" id="detail" name="detail" placeholder="Số nhà, tên đường..." required><br><br>&ndash;%&gt;--%>
<%--                    </div>--%>

<%--                </div>--%>
<%--                <div class="form__item">--%>
<%--                    <label for="status">Trạng thái</label>--%>
<%--                    <select class="status" name="status" id="status">--%>
<%--                        <option value="enable">duyệt</option>--%>
<%--                        <option value="disable">vô hiệu hóa</option>--%>
<%--                    </select>--%>
<%--                </div>--%>
<%--                <div class="form__bottom">--%>
<%--                    <button class="form__submit" type="submit">lưu</button>--%>
<%--                    <a href="javascript:void(0)" onclick="editEmployerForm()"  class="form__back">--%>
<%--                        <i class="fa-solid fa-arrow-left"></i>--%>
<%--                        Quay lại--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--&lt;%&ndash;                </c:forEach>&ndash;%&gt;--%>
<%--            </form>--%>
<%--        </div>--%>
    </div>
</div>

</body>
</html>