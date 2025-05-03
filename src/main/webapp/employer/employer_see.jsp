<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/20/2025
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
    <!-- Style -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="../asserts/css/employer_see.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="application">
    <%@include file="../header_employer.jsp"%>
    <div class="d-flex justify-content-start" id="main-screen" style="position: relative;">
        <%@include file="sidebar_employer.jsp"%>
        <div class="my-careerlink-screen">
            <div class="my-careerlink bg-white mb-md-4 mb-0">
                <div class="container px-0 px-lg-3">
                    <h1 class="h4 page-title p-3 px-md-0 m-0">
                        My TimviecDCH
                    </h1>
                </div>
            </div>
                    <div class="bg-light py-lg-3">
                        <div class="container px-0">
                            <div class="company-header rounded-sm bg-white">
                                <div class="company-banner-content overflow-hidden">
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.companyBanner}">
                                            <img class="img-fluid" id="company-banner-image"
                                                 src="${pageContext.request.contextPath}${sessionScope.companyBanner}"
                                                 alt="Ảnh bìa công ty">
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-fluid" id="company-banner-image"
                                                 src="${pageContext.request.contextPath}/asserts/img/banner_home/1746259408108_png1.png"
                                                 alt="Ảnh bìa mặc định">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="dropdown" id="edit-company-banner-dropdown">
                                    <button class="btn btn-transparent bg-white shadow-sm py-2"
                                            onclick="document.getElementById('banner-image-upload').click();">
                                        <i class="fas fa-camera mr-lg-2"></i>
                                        <span class="d-none d-lg-inline">Thay đổi ảnh bìa</span>
                                    </button>
                                    <input type="file" name="file" accept="image/*" id="banner-image-upload" style="display:none;" onchange="uploadBannerImage()" />
                                </div>
                                <div>
                                <button class="btn btn-primary mt-3" id="save-banner-button" onclick="saveBannerImage()">Lưu</button>
                                </div>
                                <div class="company-summary position-relative d-flex">
                                    <div class="company-logo position-relative d-flex flex-center bg-white overflow-hidden shadow"
                                         id="company-logo-container">
                                        <img class="mw-100" src="https://static.careerlink.vn/web/images/common/no-logo.png"
                                             alt="No logo">
                                        <div class="flex-center" id="upload-company-logo-container">
                                            <div class="upload-company-logo-button">
                                                <input accept="image/*" type="file" class="d-none" value="">
                                                <div class="upload-file-button">
                                                    <div class="bg-white rounded-circle d-flex flex-center">
                                                        <i class="fas fa-camera"></i>
                                                    </div>
                                                </div>
                                                <div class="invalid-feedback"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                    <div class="company-information flex-fill pl-lg-3 pt-3 pt-lg-0">
                                        <div class="d-flex">
                                            <h5 class="company-name d-flex align-items-center" itemprop="name">
                                                Công ty 3 ae
                                            </h5>
                                            <button class="company-edit-button btn ml-auto"
                                                    id="edit-employer-information-button">
                                                <i class="cli-pen-outline d-flex mr-lg-2"></i>
                                                <span>
                                            Chỉnh sửa
                                        </span>
                                            </button>
                                        </div>
                                        <div class="row no-gutters mt-2 mt-lg-0">
                                            <div class="flex-fill row no-gutters">
                                                <div class="col-lg-6 pr-lg-3">
                                                    <div class="d-flex">
                                                        <i class="cli-map-pin-line d-flex mr-2"></i>
                                                        <span class="icon-text">
                                                    <img src="${pageContext.request.contextPath}/asserts/img/marker.png" style="width:16px">
                                                    Ninh Trung, Thành Phố Thủ Đức, Hồ Chí Minh
                                                </span>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 mt-2 mt-lg-0">
                                                    <div class="d-flex">
                                                        <i class="cli-users d-flex mr-2"></i>
                                                        <span class="icon-text">
                                                    <img src="${pageContext.request.contextPath}/asserts/img/users-alt.png" style="width:16px">
                                                    Ít hơn 10 nhân viên
                                                </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="sticky-top d-md-none" style="z-index: 1000; top: 58px;">
                                <nav class="bg-white overflow-auto mw-100" id="portal-navigation">
                                    <ul class="nav border-bottom w-100 justify-content-between d-flex flex-nowrap"
                                        style="height: 44px;">
                                        <li class="nav-item px-3 w-100 h-100 text-nowrap d-flex flex-center"
                                            data-target="#company-description">
                                            <div class="nav-link px-0">
                                                Mô tả
                                            </div>
                                        </li>
                                        <li class="nav-item px-3 w-100 h-100 text-nowrap d-flex flex-center"
                                            data-target="#company-media">
                                            <div class="nav-link px-0">
                                                Hình ảnh
                                            </div>
                                        </li>
                                        <li class="nav-item px-3 w-100 h-100 text-nowrap d-flex flex-center"
                                            data-target="#company-jobs">
                                            <div class="nav-link px-0">
                                                Công việc
                                            </div>
                                        </li>
                                        <li class="nav-item px-3 w-100 h-100 text-nowrap d-flex flex-center"
                                            data-target="#company-work-locations">
                                            <div class="nav-link px-0">
                                                Địa điểm
                                            </div>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="d-lg-flex mt-lg-3">
                                <div class="col-lg-8 bg-white p-0 p-lg-4 rounded-sm">
                                    <div class="company-description text-secondary p-3 p-lg-0" id="company-description">
                                        <div class="d-flex align-items-center mb-3">
                                            <h4 class="company-section-title mb-0">
                                                Về công ty
                                            </h4>
                                            <button class="company-edit-button btn ml-auto"
                                                    id="edit-company-description-button">
                                                <i class="cli-pen-outline d-flex mr-lg-2"></i>
                                                <span>
                                            Chỉnh sửa
                                        </span>
                                            </button>
                                        </div>
                                        <div class="text-collapse">
                                            <div class="text-collapse--content company-profile mb-0" itemprop="description">

                                            </div>
                                            <span
                                                    class="font-weight-bold btn btn-link text-left pl-0 text-collapse--toggle mt-2"
                                                    data-toggle="text-collapse" style="display: none;">
                                        <span class="see-more">
                                            Xem thêm
                                        </span>
                                        <span class="see-less">
                                            Thu gọn
                                        </span>
                                    </span>
                                        </div>
                                    </div>
                                    <div class="mt-3 mt-lg-4 p-2 p-lg-0" id="company-jobs">
                                        <div class="px-2 px-lg-0">
                                            <div class="d-flex flex-wrap align-items-center">
                                                <h4 class="company-section-title">
                                                    Việc đang tuyển
                                                </h4>
                                                <div class="ml-auto">
                                                    <a class="btn btn-primary d-flex align-items-center mb-2 py-2 px-lg-3"
                                                       target="_parent" href="/nha-tuyen-dung/vieclam/moi"><i
                                                            class="cli-plus-square d-flex mr-lg-2"></i>
                                                        <span class="d-none d-lg-inline">
                                                    Đăng công việc mới
                                                </span>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="d-flex align-items-center mt-3">
                                                <p class="m-0 text-secondary">
                                            <span class="jobs-count-number font-weight-semi-bold">
                                                0
                                            </span>
                                                    việc làm
                                                </p>
                                                <div class="jobs-sort d-flex align-items-center ml-auto">
                                                    <p class="m-0 mr-2">
                                                        Sắp xếp
                                                    </p>
                                                    <div class="dropdown"></div>
                                                    <a class="dropdown-toggle border px-2 py-1" role="button"
                                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                                                       href="#">Mới cập nhật
                                                    </a>
                                                    <div class="dropdown-menu sort-content">
                                                        <a class="dropdown-item py-2 active" target="_self"
                                                           href="/nha-tuyen-dung/tai-khoan/preview?company_profile_number=388812&amp;order=date&amp;sort=desc">Mới
                                                            cập nhật
                                                        </a><a class="dropdown-item py-2 " target="_self"
                                                               href="/nha-tuyen-dung/tai-khoan/preview?company_profile_number=388812&amp;order=posted_date&amp;sort=desc">Mới
                                                        đăng
                                                    </a><a class="dropdown-item py-2 " target="_self"
                                                           href="/nha-tuyen-dung/tai-khoan/preview?company_profile_number=388812&amp;order=expires_date&amp;sort=desc">Sắp
                                                        hết hạn
                                                    </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="list-group mt-4">
                                            <div class="mb-5 px-2 px-lg-0">
                                                <h6>
                                                    Chúng tôi không tìm thấy việc nào phù hợp với tìm
                                                    kiếm của bạn.
                                                </h6>
                                                <div class="my-3">
                                                    Hãy thử như sau:
                                                </div>
                                                <ul>
                                                    <li class="mb-1">
                                                        Xin bạn chắc chắn rằng tất cả các từ đều
                                                        đúng chính tả.
                                                    </li>
                                                    <li class="mb-1">
                                                        Thử các từ khóa khác nhau.
                                                    </li>
                                                    <li class="mb-1">
                                                        Thử những từ khóa phổ biến hơn.
                                                    </li>
                                                </ul>
                                            </div>
                                        </ul>
                                        <div class="offices-map-container py-4 px-3 px-lg-0 mt-lg-4"
                                             id="work-locations-section">
                                            <div class="d-flex align-items-center w-100 mb-3">
                                                <h4 class="company-section-title mb-0">
                                                    Nơi làm việc (0)
                                                </h4>
                                                <button class="company-edit-button btn ml-auto"
                                                        id="edit-company-work-locations-button">
                                                    <i class="cli-pen-outline d-flex mr-md-2"></i>
                                                    <span>
                                                Chỉnh sửa
                                            </span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="bg-white p-3 px-lg-4 rounded-sm" id="company-media"
                                     style="margin-left: 30px; width:30%;">
                                    <div class="mb-3">
                                        <div class="d-flex align-items-center mb-2 mx-n2">
                                            <h6 class="px-2 mb-0">
                                                Website
                                            </h6>
                                            <button class="company-edit-button ml-auto rounded-circle" style="width:30px;">
                                                <img src="${pageContext.request.contextPath}/asserts/img/write.png" style="width:20px">
                                            </button>
                                        </div>
                                    </div>
                                    <div class="company-links">
                                        <h6 class="mb-2">
                                            Theo dõi
                                        </h6>
                                        <div class="d-flex align-items-center">
                                    <span class="social-icon disabled mr-3 text-facebook border-facebook">
                                        <i class="cli-facebook"></i>
                                    </span>
                                            <span class="social-icon disabled mr-3 text-linkedin border-linkedin">
                                        <i class="cli-linkedin"></i>
                                    </span>
                                            <span class="social-icon disabled mr-3 text-youtube border-youtube">
                                        <i class="cli-youtube"></i>
                                    </span>
                                            <span class="social-icon disabled mr-3 text-twitter border-twitter">
                                        <i class="cli-twitter"></i>
                                    </span>
                                            <span class="social-icon disabled mr-3 text-google border-google">
                                        <i class="cli-google"></i>
                                    </span>
                                        </div>
                                    </div>
                                    <div class="company-images mt-3">
                                        <div class="d-flex align-items-center mb-2 mx-n2">
                                            <h6 class="px-2">
                                                Hình ảnh công ty
                                            </h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    <%@include file="../footer.jsp"%>
        </div>

            <script>
                document.addEventListener('DOMContentLoaded', function () {
                    const navUser = document.querySelector('.nav__employer-user');
                    const dropdownMenu = document.querySelector('.nav__employer-logged-in');


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
<script>
    // Biến toàn cục lưu file người dùng chọn
    let selectedBannerFile = null;

    // Khi người dùng chọn ảnh → hiển thị xem trước
    function uploadBannerImage() {
        const fileInput = document.getElementById('banner-image-upload');
        const bannerImage = document.getElementById('company-banner-image');

        if (fileInput.files && fileInput.files[0]) {
            selectedBannerFile = fileInput.files[0];

            const reader = new FileReader();
            reader.onload = function (e) {
                bannerImage.src = e.target.result; // Hiển thị ảnh xem trước
            };
            reader.readAsDataURL(selectedBannerFile);
        }
    }

    // Khi người dùng nhấn "Lưu"
    function saveBannerImage() {
        if (!selectedBannerFile) {
            alert('Vui lòng chọn ảnh trước khi lưu.');
            return;
        }

        const bannerImage = document.getElementById('company-banner-image');
        const saveButton = document.getElementById('save-banner-button');

        const formData = new FormData();
        formData.append('file', selectedBannerFile);

        // UI trạng thái đang xử lý
        bannerImage.style.opacity = '0.5';
        saveButton.disabled = true;
        saveButton.textContent = 'Đang lưu...';

        // Lấy context path (ví dụ: /trang_tin_tuyen_dung)
        const pathParts = window.location.pathname.split('/');
        const contextPath = '/' + (pathParts[1] || '');

        // Gửi file lên server
        fetch(contextPath + '/upload-banner-img', {
            method: 'POST',
            body: formData
        })
            .then(res => res.json())
            .then(data => {
                if (data.status === 'success') {
                    const baseUrl = data.imageUrl.split('?')[0];
                    const updatedUrl = baseUrl + '?r=' + Date.now(); // Tránh cache ảnh cũ

                    console.log("✅ Đường dẫn ảnh từ server:", data.imageUrl);
                    bannerImage.src = data.imageUrl + '?r=' + Date.now();

                    alert('✅ Ảnh đã được cập nhật!');
                    selectedBannerFile = null;
                    document.getElementById('banner-image-upload').value = '';
                } else {
                    alert('❌ ' + (data.message || 'Lỗi không xác định khi lưu ảnh.'));
                }
            })
            .catch(err => {
                console.error('❌ Lỗi upload:', err);
                alert('❌ Lỗi kết nối server: ' + err.message);
            })
            .finally(() => {
                bannerImage.style.opacity = '1';
                saveButton.disabled = false;
                saveButton.textContent = 'Lưu';
            });
    }
</script>

</body>
</html>
