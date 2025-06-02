<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
  <link rel="stylesheet" href="asserts/css/base.css">
  <link rel="stylesheet" href="asserts/css/login_reset_request.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Kiếm việc làm online</title>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="application">
  <%@include file="header.jsp" %>

  <div class="container">
    <div class="row">
      <div class="col-md-6 mx-auto mt-5">

        <c:choose>
          <c:when test="${sessionScope.user == null}">
            <h2 class="text-center">Quên mật khẩu</h2>
            <p class="text-center text-secondary">Nhập email của bạn để nhận hướng dẫn đặt lại mật khẩu.</p>
            <p class="text" style="font-size: 16px;color: red;">Liên kết đặt lại mật khẩu của bạn có hiệu lực trong 3 phút</p>

            <c:if test="${param.status == 'notfound'}">
              <div class="alert alert-danger">Email không tồn tại trong hệ thống!</div>
            </c:if>

            <c:if test="${param.status == 'success'}">
              <div class="alert alert-success">Liên kết đặt lại mật khẩu đã được gửi đến email của bạn.</div>
            </c:if>

            <%
              String status = request.getParameter("status");
              if ("expired".equals(status)) {
            %>
            <div style="color: red; font-weight: bold;font-size:16px">
              Liên kết đặt lại mật khẩu đã hết hạn. Vui lòng yêu cầu lại.
            </div>
            <% } %>

            <form id="reset_request_form" action="${pageContext.request.contextPath}/forgot-password" method="post">
              <div class="form-group">
                <input type="email" class="form-control" required placeholder="Nhập email của bạn" name="email">
              </div>
              <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
              <button class="btn btn-primary btn-block" type="submit">Gửi yêu cầu</button>
            </form>
          </c:when>

          <c:otherwise>
            <h2 class="text-center">Xác thực tài khoản</h2>
            <p class="text-center text-secondary">Nhập email để nhận lại liên kết xác thực tài khoản. Liên kết chỉ có hiệu lực trong thời gian ngắn.</p>

            <c:if test="${param.status == 'verified'}">
              <div class="alert alert-success">Tài khoản đã được xác thực thành công.</div>
            </c:if>

            <c:if test="${param.status == 'verify_failed'}">
              <div class="alert alert-danger">Xác thực thất bại hoặc liên kết đã hết hạn.</div>
            </c:if>
            <c:if test="${param.status == 'success'}">
              <div class="alert alert-success">Email xác thực đã được gửi. Vui lòng kiểm tra hộp thư của bạn.</div>
            </c:if>
            <form action="${pageContext.request.contextPath}/send-verification-account" method="post">
              <div class="form-group">
                <input type="email" class="form-control" name="email"
                       value="${sessionScope.user.email}" readonly>
              </div>
              <button class="btn btn-warning btn-block" type="submit">Gửi email xác thực</button>
            </form>


          </c:otherwise>
        </c:choose>

      </div>
    </div>
  </div>

  <%@include file="footer.jsp" %>
</div>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    const navUser = document.querySelector('.nav__has--form-login');
    const dropdownMenu = document.querySelector('.nav__dropdown-menu');

    navUser?.addEventListener('click', function (event) {
      event.stopPropagation();
      dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });

    document.addEventListener('click', function (event) {
      if (!navUser?.contains(event.target) && !dropdownMenu?.contains(event.target)) {
        dropdownMenu.style.display = 'none';
      }
    });
  });
</script>

<style>
  .alert {
    font-size: 16px;
  }
</style>

</body>
</html>
