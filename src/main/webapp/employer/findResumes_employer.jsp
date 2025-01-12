<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.quilljs.com/1.3.7/quill.snow.css" rel="stylesheet">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
    <!-- Style -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="../asserts/css/main_job_posting.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts//css/finding_profile.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div class="application">
        <%@ include file="../header_employer.jsp"%>
        <div class="d-flex justify-content-start" id="main-screen" style="position: relative;">
            <%@include file="sidebar_employer.jsp"%>
            <div class="my-careerlink-screen">
                <div class="my-careerlink bg-white mb-md-4 mb-0">
                    <div class="container px-0 px-lg-3">
                        <h1 class="h4 page-title p-3 px-md-0 m-0">
                            Tìm Hồ Sơ
                        </h1>
                    </div>
                </div>
                <div class="container2">
                    <div class="content">
                        <div class="search-box">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <input type="text" placeholder="Nhập từ khóa" class="search-input">
                        </div>
                        <div class="search-box">
                            <i class="fa-solid fa-location-dot"></i>
                            <input type="text" placeholder="Nhập tỉnh, thành phố" class="search-input">
                        </div>
                        <button>Tìm kiếm</button>
                    </div>
                    <div class="content2">
                        <p>Tìm kiếm theo</p>
                        <label>
                            <input type="radio">
                            <p>Tất cả</p>
                        </label>
                        <label>
                            <input type="radio">
                            <p>Tiêu đề hồ sơ</p>
                        </label>
                    </div>
                    <div class="content3">
                        <div class="item1">
                            <div class="abc">
                                <div class="finding-wrap__title">
                                    <p class="finding-wrap__filter">Lọc theo</p>
                                    <p class="finding-wrap__remove-filter">Xóa lọc</p>
                                </div>
                                <div class="form__item">
                                    <span class="form__item-title">Công việc đang tuyển</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Công việc đang tuyển</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-border-all"></i>Ngành nghề</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Ngành nghề</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-hand-sparkles"></i>Kinh nghiệm làm việc</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Kinh nghiệm làm việc</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-signal"></i>Cấp bậc</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Cấp bậc</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-sack-dollar"></i>Mức lương</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Mức lương</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-briefcase"></i>Loại công việc</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Loại công việc</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-graduation-cap"></i>Trình độ học vấn</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Học vấn</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-school"></i>Trường</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Nhập tên trường</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-certificate"></i>Chuyên môn</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Chuyên môn</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-language"></i>Trình độ ngoại ngữ</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Ngoại ngữ</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-venus-mars"></i>Giới tính</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Bất kì</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-hand-holding-heart"></i>Tình trạng hôn nhân</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Bất kì</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-user"></i>Độ tuổi</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">15 trở lên</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--  -->
                                <div class="form__item">
                                    <span class="form__item-title"><i class="fa-solid fa-calendar-days"></i>Hồ sơ đăng trong vòng</span>
                                    <div class="form__item-section">
                                        <button class="form__section-btn">
                                            <span class="form__section-lable">Thời gian trong vòng</span>
                                            <i class="fa-solid fa-chevron-down"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="item2"></div>
                        <div class="item3">
                            <img src="https://www.careerlink.vn/web/images/search_resume_banner.png" alt="">
                            <p>Khám phá hàng ngàn CV chất lượng cao với công cụ tìm kiếm thông minh của chúng tôi. Bắt đầu ngay bằng cách nhập từ khóa vào thanh tìm kiếm hoặc sử dụng bộ lọc chi tiết để tìm ứng viên phù hợp nhất.</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <%@ include file="../footer.jsp"%>
    </div>
</body>
</html>
