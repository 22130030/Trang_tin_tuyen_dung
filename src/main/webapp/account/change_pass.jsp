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
                                    <a class="nav-link py-lg-4" href="${pageContext.request.contextPath}/account/account_candidate.jsp">
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
                        <form id="reset_password_form" action="${pageContext.request.contextPath}/change-password" method="post">
                            <!-- Hiển thị thông báo lỗi nếu có -->
                            <c:if test="${param.status == 'incorrect_old_password'}">
                                <div class="alert alert-danger mt-3" role="alert">
                                    Mật khẩu hiện tại không đúng!
                                </div>
                            </c:if>

                            <c:if test="${param.status == 'error'}">
                                <div class="alert alert-danger mt-3" role="alert">
                                    Đã xảy ra lỗi. Vui lòng thử lại sau!
                                </div>
                            </c:if>

                            <div class="form-group">
                                <label class="font-weight-bold" for="old_password">Mật khẩu hiện tại</label><span class="text-danger">*</span>
                                <div class="d-flex flex-wrap align-items-center">
                                    <input required id="old_password" class="form-control col-md-9" type="password" name="old_password">
                                    <a class="small text-nowrap ml-auto ml-md-2 mt-2 mt-md-0" href="reset_password.jsp">Quên mật khẩu?</a>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <label class="font-weight-bold" for="new_password">Mật khẩu mới</label><span class="text-danger">*</span>
                                <input required id="new_password" class="form-control col-md-9" type="password" name="new_password">
                            </div>
                            <div class="form-group mt-3">
                                <label class="font-weight-bold" for="confirm_password">Gõ lại mật khẩu mới</label><span class="text-danger">*</span>
                                <input required id="confirm_password" class="form-control col-md-9" type="password" name="confirm_password">
                                <small id="password_error" class="text-danger" style="display:none; font-size: 14px; font-weight: bold;">
                                    Mật khẩu không khớp!
                                </small>
                            </div>
                            <div class="form-group mt-n2 mb-4">
                                <label class="d-inline-flex mb-0">
                                    <input type="checkbox" id="toggle_password_visibility"> Hiển thị mật khẩu
                                </label>
                            </div>
                            <button class="btn btn-primary" type="submit">Cập nhật mật khẩu</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let form = document.getElementById("reset_password_form"); // ID sửa thành đúng với form
            let oldPasswordInput = document.getElementById("old_password");
            let newPasswordInput = document.getElementById("new_password");
            let confirmPasswordInput = document.getElementById("confirm_password");
            let passwordError = document.getElementById("password_error");
            let togglePasswordCheckbox = document.getElementById("toggle_password_visibility");

            // Kiểm tra khi người dùng nhập vào ô xác nhận mật khẩu
            confirmPasswordInput.addEventListener("input", function () {
                checkPasswordMatch();
            });

            // Kiểm tra khi người dùng thay đổi mật khẩu mới
            newPasswordInput.addEventListener("input", function () {
                checkPasswordMatch();
            });

            // Kiểm tra khi bấm nút "Cập nhật mật khẩu"
            form.addEventListener("submit", function (event) {
                if (!checkPasswordMatch()) {
                    event.preventDefault(); // Ngăn form gửi đi nếu mật khẩu không khớp
                }
            });

            // Hàm kiểm tra mật khẩu có trùng khớp không
            function checkPasswordMatch() {
                let newPassword = newPasswordInput.value;
                let confirmPassword = confirmPasswordInput.value;

                // Nếu ô "Gõ lại mật khẩu" trống, ẩn thông báo lỗi
                if (confirmPassword === "") {
                    passwordError.style.display = "none";
                    return false;
                }

                // Kiểm tra sự khớp giữa mật khẩu mới và mật khẩu xác nhận
                if (newPassword !== confirmPassword) {
                    passwordError.style.display = "block"; // Hiển thị lỗi nếu không khớp
                    return false;
                } else {
                    passwordError.style.display = "none"; // Ẩn lỗi nếu mật khẩu khớp
                    return true;
                }
            }

            // Hiển thị/ẩn mật khẩu khi nhấn checkbox
            togglePasswordCheckbox.addEventListener("change", function () {
                let passwordFields = [oldPasswordInput, newPasswordInput, confirmPasswordInput];
                let type = togglePasswordCheckbox.checked ? "text" : "password";

                passwordFields.forEach(field => field.type = type);
            });
        });

    </script>
</body>
</html>
