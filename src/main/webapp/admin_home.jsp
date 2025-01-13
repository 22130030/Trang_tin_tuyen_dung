<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/13/2025
  Time: 3:06 PM
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
  <link rel="stylesheet" href="asserts/css/admin/admin.css">
  <link rel="stylesheet" href="asserts/css/admin/admin__base.css">
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
      <a class="sidebar--active" href="#">Thống kê và báo cáo</a>
      <a href="/html/admin/admin_employer.html">Quản lý nhà tuyển dụng</a>
      <a href="/html/admin/candidate.html">Quản lý ứng viên</a>
      <a href="/html/admin/admin_jobs.html">Quản lý bài đăng</a>
      <a href="/html/admin/admin_category.html">Quản lý ngành nghề</a>
      <a href="/html/admin/user.html">Quản lý tài khoản</a>
    </div>

    <!-- Main Content -->
    <div class="content">
      <h1>Thống kê và báo cáo</h1>
      <!-- Cards Section -->
      <div class="statistical">
        <div class="statistical__employer statistical__item">
          <h2>${size}</h2>
          <p>Nhà tuyển dụng</p>
        </div>
        <div class="statistical__user statistical__item">
          <h2>${size2}</h2>
          <p>Ứng viên</p>
        </div>
        <div class="statistical__jobs statistical__item">
          <h2>${size3}</h2>
          <p>Việc làm đã đăng</p>
        </div>
      </div>


      <!-- Table Section -->
      <div class="table-container">
        <h3>Những nhà tuyển dụng mới</h3>
        <div class="employers">


          <table>
            <thead>
            <tr>
              <th>ID</th>
              <th>Tên Công ty</th>
              <th>Email</th>
              <th>Số điện thoại</th>
              <th>Trạng thái</th>
              <th>Ngày đăng ký</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${com}" var="c">
              <tr>
                <td>${c.id}</td>
                <td>${c.companyName}</td>
                <td>${c.email}</td>
                <td>${c.phone_number}</td>
                <td>${c.status}</td>
                <td>${c.createDate}</td>
              </tr>
            </c:forEach>



            </tbody>
          </table>
        </div>
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
