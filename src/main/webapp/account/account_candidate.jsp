<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/15/2025
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
    <!-- Style -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
    <link rel="stylesheet" href="../asserts/css/account.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
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
    <%@ include file="../header.jsp"%>
    <%@include file="menu_account.jsp"%>
    <!-- content -->
    <div class="container mt-lg-5 mb-5">
        <div class="row">
            <div class="col-lg-3 px-0 px-lg-3">
                <div class="profile-menu overflow-hidden mb-4">
                    <div class="navbar p-0">
                        <%@include file="siderBar_account.jsp"%>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 pl-lg-5">
                <h1 class="h3 d-none">
                    Tài khoản
                </h1>
                <div data-turbolinks-permanent="" id="profile_container">
                    <div class="profile-0-2-1">
                        <div class="d-flex">
                            <div class="flex-fill pr-3">
                                <h1 class="h3">Tài khoản</h1>
                                <p class="text-secondary mb-0">Hãy cập nhật thông tin mới nhất.</p>
                                <p class="text-secondary">Thông tin cá nhân dưới đây sẽ tự động điền khi bạn tạo
                                    hồ sơ
                                    mới.</p>
                            </div>
                            <form action="${pageContext.request.contextPath}/update-candidate"  method="post" enctype="multipart/form-data"
                                  class="avatar-container row no-gutters align-items-start justify-content-center position-relative">
                                <input type="file" name="uploadedImage" id="upload" accept="image/*" style="display: none;" onchange="loadFile(this)">
                                <label for="upload">
                                    <div class="avatar-0-2-18">
                                        <img id="preview" class="rounded-circle border"
                                             data-default-src="${sessionScope.image != null ? pageContext.request.contextPath.concat(sessionScope.image) : pageContext.request.contextPath.concat('/assets/img/user.png')}"
                                             src="${sessionScope.image != null ? pageContext.request.contextPath.concat(sessionScope.image) : pageContext.request.contextPath.concat('/assets/img/user.png')}"                                         style="width: 100px; height: 100px;">
                                        <div class="align-items-center justify-content-center avatar-upload"
                                             id="avatar-upload"><i class="fa fa-camera fa-3x text-white"></i>
                                        </div>
                                    </div>
                                </label>
                                <p class="text-secondary small mt-2 w-100 text-center" style="font-size: 12px;">
                                    (JPEG/PNG/GIF, ≦ 1MB)</p>
                                <div class="share_avatar d-flex gap-2" style="margin-top: -12px; font-size: 15px;">
                                    <button class="btn-primary btn-sm font-weight-bold" type="submit">Lưu</button>
                                    <button class="btn-light btn-sm font-weight-bold text-primary" onclick="cancelPreview()">Huy</button>
                                </div>
                            </form>
                        </div>

                       <form>
                        <ul class="list-group list-group-flush mt-4">
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Họ và tên<span class="text-danger">
                                        *</span></div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="full-name font-weight-bold">${sessionScope.user.name}</div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-3 px-0" data-toggle="modal"
                                data-target="#changeEmailModal">
                                <div class="col-12 col-lg-3 mb-2">Địa chỉ email<span class="text-danger">
                                        *</span></div>
                                <div class="d-flex flex-fill col-lg-9 no-gutters">
                                    <div class="flex-fill col-lg-9">
                                        <div class="email font-weight-bold">${sessionScope.user.email}</div>
                                        <p class="text-secondary mt-2 mb-0">Đây là địa chỉ email để đăng nhập.
                                            Chúng tôi
                                            cũng sẽ gửi thông báo đến địa chỉ này.</p>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Giới tính</div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="gender font-weight-bold">...</div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Ngày sinh</div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="birth-date"><span class="text-secondary">Nhập ngày sinh của
                                                bạn</span></div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Tình trạng hôn nhân</div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="marital-status font-weight-bold">...</div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Số điện thoại</div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="phone"><span class="text-secondary">${sessionScope.user.phoneNumber}</span></div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item d-flex flex-wrap no-gutters py-4 px-0">
                                <div class="col-12 col-lg-3 mb-2 title-0-2-21">Địa chỉ</div>
                                <div class="d-flex col-lg-9 no-gutters">
                                    <div class="col-lg-9">
                                        <div class="address font-weight-bold">, Viet Nam</div>
                                    </div>
                                </div>
                            </li>
                            <div class="text-center">
                                <button type="submit" class="btn" style="background-color: #007bff; color: white; border: none; mt-3;">Chỉnh sửa cá nhân</button>
                            </div>
                            <p class="text-center bg-light text-muted font-weight-bolder p-2 mt-2">Ngày đăng ký:
                                ${sessionScope.user.convertCreated}</p><button type="button" data-toggle="modal"
                                                                               data-target="#delete-account-modal" class="btn btn-light d-flex text-danger shadow-none"
                                                                               fdprocessedid="vr79fj" style="width:max-content"><i class="fa fa-minus-circle mr-2"
                                                                                                                                   style="font-size: 25px;"></i><span style="font-size: 18px;"> Xóa tài
                                    khoản</span></button>
                        </ul>
                       </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <%@ include file="../footer.jsp"%>
</div>

</body>
<script>
    function loadFile(e) {
        const output = document.getElementById('preview');
        output.src = URL.createObjectURL(event.target.files[0]);
        output.onload = () => URL.revokeObjectURL(output.src); // tránh rò rỉ bộ nhớ
    }
    function cancelPreview() {
        const preview = document.getElementById('preview');
        const fileInput = document.getElementById('upload');
        preview.src = preview.dataset.defaultSrc;
        fileInput.value = ""; // clear input file
    }
</script>
</html>