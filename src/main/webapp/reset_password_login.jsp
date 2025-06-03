<%--
 Created by IntelliJ IDEA.
 User: Asus
 Date: 3/30/2025
 Time: 3:40 PM
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">


<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
  <!-- Style -->
  <link rel="stylesheet" href="asserts/css/base.css">
  <link rel="stylesheet" href="asserts/css/reset_password_login.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- js -->
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
  <!-- title -->
  <title>Kiếm việc làm online</title>
</head>
<body>
<div class="application">
  <!-- header -->
  <%@include file="header.jsp" %>




  <!-- navigation -->
  <!-- content -->
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6 p-4">
        <h2 class="mb-4 text-center">Đặt lại mật khẩu</h2>


        <c:if test="${param.status == 'invalid'}">
          <div class="alert alert-danger text-center">Liên kết không hợp lệ!</div>
        </c:if>
        <c:if test="${param.status == 'expired'}">
          <div class="alert alert-danger text-center">Liên kết đã hết hạn!</div>
        </c:if>

        <form id="reset_password_form" action="${pageContext.request.contextPath}/update-password" method="post">
<%--          <input type="hidden" name="token" value="${requestScope.token}">--%>
<%--          <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">  <!-- Hoặc requestScope.redirectUrl -->--%>

          <div class="form-group">
            <input type="password" class="form-control" id="password" required placeholder="Mật khẩu mới" name="password">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" id="retypePassword" required placeholder="Nhập lại mật khẩu" name="retypePassword">
            <div class="invalid-feedback" id="passwordError" style="display: none; color: red; font-size: 14px;">
              Mật khẩu không khớp. Hãy nhập lại!
            </div>
          </div>

          <button class="btn btn-primary w-100" type="submit">Xác nhận</button>
        </form>
      </div>
    </div>
  </div>


  <!-- footer -->
  <%@include file="footer.jsp" %>
</div>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    const navUser = document.querySelector('.nav__has--form-login');
    const dropdownMenu = document.querySelector('.nav__dropdown-menu');




    navUser.addEventListener('click', function (event) {
      event.stopPropagation();
      dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });




    document.addEventListener('click', function (event) {
      if (!navUser.contains(event.target) && !dropdownMenu.contains(event.target)) {
        dropdownMenu.style.display = 'none';
      }
    });
  });
</script>
<script>


  document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("reset_password_form");
    const password = document.getElementById("password");
    const retypePassword = document.getElementById("retypePassword");
    const passwordError = document.getElementById("passwordError");


    form.addEventListener("submit", function (event) {
      if (password.value !== retypePassword.value) {
        event.preventDefault(); // Ngăn form gửi đi nếu mật khẩu không khớp
        passwordError.style.display = "block";
        retypePassword.classList.add("is-invalid");
      } else {
        passwordError.style.display = "none";
        retypePassword.classList.remove("is-invalid");
      }
    });
    retypePassword.addEventListener("input", function () {
      if (password.value === retypePassword.value) {
        passwordError.style.display = "none";
        retypePassword.classList.remove("is-invalid");
      }
    });
  });
</script>
</body>
</html>

