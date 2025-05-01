

<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/6/2025
  Time: 2:52 PM
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
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="asserts/css/style1.css">
  <link rel="stylesheet" href="asserts/css/base.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- js -->
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
  <script src="asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
  <!-- title -->
  <title>Kiếm việc làm online</title>
</head>
<body>
<div class="application">
  <%@include file="header.jsp" %>
  <div class="header">
    <!-- navigation -->
    <!-- content -->
    <div class="d-lg-flex half">
      <div class="bg order-1 order-md-2">
        <h1 class="text-white">
          Xây dựng<br><b>Sự nghiệp<br><span class="text-warning">thành công</span></b><br>cùng
          CareerLink.vn
        </h1>
      </div>
      <div class="contents order-2 order-md-1">

        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-7 py-5">
              <h3>Đăng kí</h3>
              <p class="mb-4">Nơi tìm việc và đăng tuyển dụng tốt nhất tại Việt Nam</p>
              <a class="note">Lưu ý:</a>
              <p class="note-1"> Hãy dùng tên thật. Nhà tuyển dụng có thể thấy tên bạn khi xem hồ sơ
              </p>
              <form id="register-form" action="register" method="post">
                <div class="form-block mx-auto">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group first">
                        <label for="fName">Họ và tên</label>
                        <input name="fName" type="text" class="form-control" placeholder="Họ và tên"
                               id="fName">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group first">
                        <label for="email">Địa chỉ Email</label>
                        <input type="email" class="form-control ${emailError != null ? 'is-invalid' : ''}"
                               placeholder="xxx@gmail.com" name="email" id="email" value="${param.email}">
                        <c:if test="${emailError != null}">
                          <div class="text-danger small mt-1">${emailError}</div>
                        </c:if>
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="form-group first">
                        <label for="phone">Số điện thoại</label>
                        <input type="text" class="form-control" placeholder="84+"
                               name = "phone" id="phone">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-6">

                      <div class="form-group last mb-3">
                        <label for="password">Nhập mật khẩu</label>
                        <input type="password" class="form-control"
                               name="password" placeholder="Mật khẩu của bạn" id="password">
                        <div style="position: relative;">
                          <div id="criteria-box" style="font-size: 14px; margin-top: 10px; border: 1px solid #ccc; padding: 10px; border-radius: 6px; background-color: black; width: 300px; display: none; position: absolute; left: 105%; top: 0; z-index: 1000;">
                            <p id="check-length">• Mật khẩu phải có độ dài từ 8 đến 50 ký tự</p>
                            <p id="check-lower">• Ít nhất một chữ thường (a-z)</p>
                            <p id="check-upper">• Ít nhất một chữ hoa (A-Z)</p>
                            <p id="check-digit">• Ít nhất một số (0-9)</p>
                            <p id="check-special">• Ít nhất một ký tự đặc biệt (!@#$)</p>
                            <p id="check-repeated">• Không được chứa quá 10 ký tự trùng nhau liên tiếp</p>
                            <p id="check-email">• Không được chứa phần tên email</p>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-7">

                      <div class="form-group last mb-3">
                        <label for="re-password">Nhập lại mật khẩu</label>
                        <input type="password" class="form-control"
                               name ="re-password" placeholder="Mật khẩu của bạn" id="re-password">
                      </div>
                    </div>
                  </div>
                  <div class="d-flex mb-5 mt-4 align-items-center">
                    <div class="d-flex align-items-center">
                      <label class="control control--checkbox mb-0"><span class="caption">Bằng
                                                        cách đăng nhập vào tài
                                                        khoản của bạn, bạn đồng ý với <a href="#">Các điều khoản và điều
                                                            kiện</a> và <a href="#">Chính Sách Bảo Mật</a>.</span>
                        <input type="checkbox" checked="checked">
                        <div class="control__indicator"></div>
                      </label>
                    </div>
                  </div>
                  <input type="submit" value="Đăng kí" class="btn px-5 btn-primary">
                  <span class="text-center my-3 d-block">hoặc</span>
                  <span class="text-center my-4 d-block">Đăng nhập với dịch vụ này.</span>
                  <div class="row">
                    <div class="col-6 px-1">
                      <a role="button" class="btn w-100 btn-outline-secondary" rel="nofollow"
                         data-method="post" href="/html/register.html"><img alt="Google"
                                                                            height="16" width="16" class="mt-n1 mr-2"
                                                                            src="asserts/img/gg.png">
                        Google
                      </a>
                    </div>
                    <div class="col-6 px-1">
                      <a role="button" class="btn w-100 btn-outline-secondary" rel="nofollow"
                         data-method="post" href="/html/register.html"><img alt="facebook"
                                                                            height="16" width="16" class="mt-n1 mr-2"
                                                                            src="asserts/img/fb.png">
                        Facebook
                      </a>
                    </div>
                    <label class="control control--checkbox mb-1"><span class="caption">Tôi đã
                                                    là thành viên rồi! <a href="/html/login.html">Đăng nhập</a></span>
                    </label>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

</div>
<!-- footer -->
<div class="footer-1" style="margin-top: -80px;">
  <%@include file="footer.jsp" %>
</div>
<script>
  function validatePasswordCriteria(password, email) {
    const criteria = {
      length: /^.{8,50}$/,
      lowercase: /[a-z]/,
      uppercase: /[A-Z]/,
      number: /[0-9]/,
      specialChar: /[!@#$]/,
      repeatedChar: /(.)\1{10,}/,
      emailPortion: new RegExp(email.split('@')[0], 'i')
    };

    const result = {
      length: criteria.length.test(password),
      lowercase: criteria.lowercase.test(password),
      uppercase: criteria.uppercase.test(password),
      number: criteria.number.test(password),
      specialChar: criteria.specialChar.test(password),
      repeatedChar: !criteria.repeatedChar.test(password),
      emailPortion: !criteria.emailPortion.test(password)
    };

    return result;
  }

  function validateForm() {
    const email = document.getElementById("email").value.trim();
    const pw = document.getElementById("password").value.trim();
    const repw = document.getElementById("re-password").value.trim();
    const criteriaBox = document.getElementById("criteria-box");
    const error = document.getElementById("pw-error") || document.createElement("small");

    if (!document.getElementById("pw-error")) {
      error.id = "pw-error";
      error.style.color = "red";
      error.style.display = "block";
      error.style.marginTop = "4px";
      document.querySelector('input[name="re-password"]').insertAdjacentElement("afterend", error);
    }

    if (pw === "" || repw === "") {
      error.textContent = "Vui lòng nhập mật khẩu và xác nhận.";
      return false;
    }

    const check = validatePasswordCriteria(pw, email);
    document.getElementById("check-length").style.color = check.length ? "green" : "red";
    document.getElementById("check-lower").style.color = check.lowercase ? "green" : "red";
    document.getElementById("check-upper").style.color = check.uppercase ? "green" : "red";
    document.getElementById("check-digit").style.color = check.number ? "green" : "red";
    document.getElementById("check-special").style.color = check.specialChar ? "green" : "red";
    document.getElementById("check-repeated").style.color = check.repeatedChar ? "green" : "red";
    document.getElementById("check-email").style.color = check.emailPortion ? "green" : "red";

    if (Object.values(check).includes(false)) {
      error.textContent = "Mật khẩu không đáp ứng đủ điều kiện.";
      return false;
    }

    if (pw !== repw) {
      error.textContent = "Mật khẩu không khớp.";
      return false;
    }

    error.textContent = "";
    return true;
  }

  document.addEventListener("DOMContentLoaded", function () {
    const passwordInput = document.getElementById("password");
    const criteriaBox = document.getElementById("criteria-box");

    passwordInput.addEventListener("focus", function () {
      criteriaBox.style.display = "block";
    });

    passwordInput.addEventListener("blur", function () {
      setTimeout(() => {
        criteriaBox.style.display = "none";
      }, 200);
    });
  });
</script>
</body>
</html>

