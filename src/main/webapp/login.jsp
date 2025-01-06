<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/6/2025
  Time: 2:51 PM
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
    <link rel="stylesheet" href="asserts/css/style.css">
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

</div>

<!-- navigation -->
<!-- content -->

<div class="d-md-flex half">
    <div class="bg" style="background-image: url('asserts/img/bg_1.jpg');"></div>
    <div class="contents">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="form-block mx-auto">
                        <div class="text-center mb-5">
                            <h3 class="text-uppercase"><strong>Người tìm việc đăng nhập</strong></h3>
                        </div>
                        <form>
                            <div class="form-group first">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" placeholder="Email" id="username">
                            </div>
                            <div class="form-group last mb-3">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" placeholder="Mật khẩu"
                                       id="password">
                            </div>

                            <div class="d-sm-flex mb-5 align-items-center">
                                <label class="control control--checkbox mb-3 mb-sm-0"><span
                                        class="caption">Nhớ mật khẩu</span>
                                    <input type="checkbox" checked="checked">
                                    <div class="control__indicator"></div>
                                </label>
                                <span class="ml-auto"><a href="html/login.html" class="forgot-pass">Quên
                                                    mật khẩu</a></span>
                            </div>

                            <a href="html/admin/admin_home.html"
                               class="btn btn-block py-2 btn-primary text-center" type="submit">Đăng nhập</a>
                            <span class="text-center my-3 d-block">hoặc</span>

                            <div class="icon">
                                <a href="html/login.html" class="btn btn-block py-2 btn-facebook">
                                    <img src="asserts/img/fb.png" alt="" class="icon-fb">Đăng nhập với
                                    facebook</a>
                                <a href="html/login.html" class="btn btn-block py-2 btn-google"
                                   style="margin-left: 0px;">
                                    <img src="asserts/img/gg.png" alt="" class="icon-gg">Đăng nhập với
                                    Google</a>
                            </div>
                        </form>
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
</body>

</html>





