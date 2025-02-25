<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 7:58 PM
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
    <link rel="stylesheet" href="../asserts/css/change password.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
    <link rel="stylesheet" href="../asserts/css/main_search_occupations_locat.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div class="application">
        <%@include file="../header.jsp"%>
        <%@include file="menu_account.jsp"%>
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
                                        <div class="title font-weight-bold mb-lg-1">
                                            Đổi mật khẩu
                                        </div>
                                        <p class="small d-none d-lg-block mb-0">
                                            Đổi mật khẩu đăng nhập
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link py-lg-4" href="/html/candidate/notification.html">
                                        <div class="title-1 font-weight-bold mb-lg-1">
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
                        Thay đổi mật khẩu
                    </h1>
                    <div class="mt-4">
                        <form id="change_password_form" class="mt-3" action="/nguoi-tim-viec/config/thay-doi-mat-khau"
                              accept-charset="UTF-8" method="post">
                            <input name="utf8" type="hidden" value="✓"><input type="hidden" name="authenticity_token"
                                                                              value="dtLIFTZwUu+umoq80bpeoAlu6QyqV25pfD3tSrd4vBN9mEeBNjswB4Wl3uHc2+j1po3eH4A1nRRXDkFdA4j8rQ==">
                            <div class="form-group">
                                <label class="font-weight-bold" for="old_password">Mật khẩu hiện tại
                                </label><span class="text-danger">
                                *
                            </span>
                                <div class="d-flex flex-wrap align-items-center">
                                    <input required="required" id="old_password"
                                           class="form-control fluent-form-control password col-md-9" type="password"
                                           name="old_password" fdprocessedid="oky9bs">
                                    <a class="small text-nowrap ml-auto ml-md-2 mt-2 mt-md-0"
                                       href="/nguoi-tim-viec/reset/reset_request">Quên mật khẩu?</a>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <label class="font-weight-bold" for="job_seeker_password">Mật khẩu mới
                                </label><span class="text-danger">
                                *
                            </span>
                                <div class="d-flex flex-wrap align-items-center">
                                    <input required="required" id="job_seeker_password"
                                           class="form-control fluent-form-control password col-md-9" type="password"
                                           name="new_password" fdprocessedid="dptqgj">
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <label class="font-weight-bold" for="job_seeker_password_confirmation">Gõ lại mật
                                    khẩu mới
                                </label><span class="text-danger">
                                *
                            </span>
                                <div class="d-flex flex-wrap align-items-center">
                                    <input required="required" id="job_seeker_password_confirmation"
                                           class="form-control fluent-form-control password col-md-9" type="password"
                                           name="retype_password" fdprocessedid="xnowi">
                                    <div class="invalid-feedback col-md-9 p-0" id="invalid_password_feedback">
                                        Mật khẩu không khớp. Hãy nhập lại
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-n2 mb-4">
                                <label class="d-inline-flex fluent-checkbox mb-0">
                                    <input class="d-none" data-target=".password" data-toggle="password"
                                           id="toggle_password" type="checkbox">
                                    <span class="checkmark"></span>
                                    Hiển thị mật khẩu
                                </label>
                            </div>
                            <button class="btn btn-primary" type="submit" fdprocessedid="sc613o"
                                    style="font-size: 14px;">Cập nhật mật khẩu</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
</body>
</html>
