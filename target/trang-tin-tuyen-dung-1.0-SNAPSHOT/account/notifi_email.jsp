<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
  <!-- Style -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../asserts/css/email notification.css">
  <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
  <link rel="stylesheet" href="../asserts/css/main.css">
  <link rel="stylesheet" href="../asserts/css/base.css">
  <link rel="stylesheet" href="../asserts/css/main_search_occupations_locat.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- js -->
  <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
  <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
  <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
  <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script></head>
<body>
<div class="application">
  <%@ include file="../header.jsp"%>
  <%@include file="menu_account.jsp"%>
  <!-- content -->
  <div class="container mt-lg-5 mb-5">
    <div class="row">
      <div class="col-lg-3 px-0 px-lg-3">
        <div class="profile-menu overflow-hidden mb-4">
          <div class="navbar p-0">
            <ul class="navbar-nav w-100">
              <li class="nav-item active">
                <a class="nav-link py-lg-4" href="/html/candidate/account.html">
                  <div class="title-1 font-weight-bold mb-lg-1">
                    Tài khoản
                  </div>
                  <p class="small d-none d-lg-block mb-0">
                    Tùy chỉnh thông tin cá nhân
                  </p>
                </a>
              </li>
              <li class="nav-item ">
                <a class="nav-link py-lg-4" href="/html/candidate/change_password.html">
                  <div class="title-1 font-weight-bold mb-lg-1">
                    Đổi mật khẩu
                  </div>
                  <p class="small d-none d-lg-block mb-0">
                    Đổi mật khẩu đăng nhập
                  </p>
                </a>
              </li>
              <li class="nav-item ">
                <a class="nav-link py-lg-4" href="/html/candidate/notification.html">
                  <div class="title font-weight-bold mb-lg-1">
                    Thông báo email
                  </div>
                  <p class="small d-none d-lg-block mb-0">
                    Tùy chỉnh nhận thông báo từ CareerLink qua email
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col-lg-9 pl-lg-5" style="margin-top: 50px;left: 50px;">
        <h1 class="h3">
          Thông báo email
        </h1>
        <p class="text-secondary">
          Thông báo được gửi tới email <strong>caominhhieunq@gmail.com</strong>
        </p>
        <ul class="list-group list-group-flush">
          <li class="list-group-item px-0 mt-3">
            <h5>
              Hoạt động quan trọng
            </h5>
            <div class="d-flex no-gutters">
              <p class="text-secondary flex-fill pr-3">
                Bạn không thể ngừng đăng kí email cho các hoạt động quan trọng: thông báo tin
                nhắn mới
                từ nhà tuyển dụng, xác nhận tài khoản,...
              </p>
              <div class='d-flex'>
                                <span class='switch ml-auto disabled'>
                                    <input checked type='checkbox'>
                                    <span class='switch-slider rounded-pill'></span>
                                </span>
              </div>
          </li>
          <li class="list-group-item px-0 mt-3">
            <h5>
              Bản tin việc làm
            </h5>
            <div class="d-flex no-gutters">
              <p class="text-secondary flex-fill pr-3">
                Nhận các bản tin mới nhất về Cẩm nang việc làm và các cơ hội nghề nghiệp phù hợp
                với hồ
                sơ của bạn.
              </p>
              <div class='d-flex'>
                                <span class='switch ml-auto disabled'>
                                    <input checked type='checkbox'>
                                    <span class='switch-slider rounded-pill'></span>
                                </span>
              </div>
            </div>
          </li>
          <li class="list-group-item px-0 mt-3">
            <h5>
              Lượt xem hồ sơ
            </h5>
            <div class="d-flex no-gutters">
              <p class="text-secondary flex-fill pr-3">
                Nhận email thông báo lượt xem hồ sơ mới từ nhà tuyển dụng mỗi tuần.
              </p>
              <div class='d-flex'>
                                <span class='switch ml-auto disabled'>
                                    <input checked type='checkbox'>
                                    <span class='switch-slider rounded-pill'></span>
                                </span>
              </div>
            </div>
          </li>
          <li class="list-group-item px-0 mt-3">
            <h5>
              Nhắc nhở từ Careerlink
            </h5>
            <div class="d-flex no-gutters">
              <p class="text-secondary flex-fill pr-3">
                Nhận email nhắc nhở sử dụng những tính năng của Careerlink dựa trên hoạt động
                của bạn
              </p>
              <div class='d-flex'>
                                <span class='switch ml-auto disabled'>
                                    <input checked type='checkbox'>
                                    <span class='switch-slider rounded-pill'></span>
                                </span>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <!-- footer -->
  <%@ include file="../footer.jsp"%>
</div>

</body>
</html>
