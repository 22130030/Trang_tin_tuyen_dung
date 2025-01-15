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
    <link rel="stylesheet" href="../asserts/css/finding_profile.css">
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
                            <h1 class="h4 page-title p-3 px-md-0 m-0">Tìm Hồ Sơ</h1>
                        </div>
                    </div>

                    <div class="container2">
                        <form action="" class="content">
                            <div class="search-box">
                                <i class="fa-solid fa-magnifying-glass"></i>
                                <input name="titleInput" type="text" placeholder="Nhập từ khóa" class="search-input">
                            </div>
                            <div class="search-box">
                                <i class="fa-solid fa-location-dot"></i>
                                <input name="addressInput" type="text" placeholder="Nhập tỉnh, thành phố" class="search-input">
                            </div>
                            <button>Tìm kiếm</button>
                        </form>

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
                            <div class="grid__col-4">
                                <div class="item1">
                                    <div class="finding-wrap__title">
                                        <p class="finding-wrap__filter">Lọc theo</p>
                                        <p class="finding-wrap__remove-filter">Xóa lọc</p>
                                    </div>

                                    <!-- Ngành nghề Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-border-all"></i>Ngành nghề</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">Ngành nghề</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>Công nghệ thông tin</li>
                                                    <li>Kế toán</li>
                                                    <li>Quản trị kinh doanh</li>
                                                    <li>Marketing</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Mức lương Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-sack-dollar"></i>Mức lương</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">Mức lương</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>Dưới 5 triệu</li>
                                                    <li>5 - 10 triệu</li>
                                                    <li>10 - 20 triệu</li>
                                                    <li>Trên 20 triệu</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Trình độ học vấn Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-graduation-cap"></i>Trình độ học vấn</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">Học vấn</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>Trung học phổ thông</li>
                                                    <li>Trung cấp</li>
                                                    <li>Cao đẳng</li>
                                                    <li>Đại học</li>
                                                    <li>Thạc sĩ</li>
                                                    <li>Tiến sĩ</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Trường Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-school"></i>Trường</span>
                                        <div class="form__item-section">
                                            <input type="text" class="form__section-input" placeholder="Nhập tên trường">
                                        </div>
                                    </div>


                                    <!-- Giới tính Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-venus-mars"></i>Giới tính</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">Bất kì</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>Nam</li>
                                                    <li>Nữ</li>
                                                    <li>Khác</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Tình trạng hôn nhân Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-hand-holding-heart"></i>Tình trạng hôn nhân</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">Bất kì</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>Độc thân</li>
                                                    <li>Đã kết hôn</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Độ tuổi Filter -->
                                    <div class="form__item">
                                        <span class="form__item-title"><i class="fa-solid fa-user"></i>Độ tuổi</span>
                                        <div class="form__item-section">
                                            <button class="form__section-btn">
                                                <span class="form__section-lable">15 trở lên</span>
                                                <i class="fa-solid fa-chevron-down"></i>
                                            </button>
                                            <div class="dropdown">
                                                <ul>
                                                    <li>15 - 20</li>
                                                    <li>20 - 30</li>
                                                    <li>30 - 40</li>
                                                    <li>Trên 40</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="grid__col-8">
                                <div class="item3 no--has-profile" style="display: none;">
                                    <img class="no--has-profile-img" src="https://www.careerlink.vn/web/images/search_resume_banner.png" alt="Banner">
                                    <p>Khám phá hàng ngàn CV chất lượng cao với công cụ tìm kiếm thông minh của chúng tôi. Bắt đầu ngay bằng cách nhập từ khóa vào thanh tìm kiếm hoặc sử dụng bộ lọc chi tiết để tìm ứng viên phù hợp nhất.</p>
                                </div>
                                <div class="item3 item-has--profile">
                                    <c:forEach items="${resumesList}" var="r">

                                    <div class="profile-card">
                                        <!-- <div class="bookmark">&#9734;</div> -->
                                        <div class="profile-card-content">
                                            <img class="profile-card__img" src="../asserts/img/apartment.png" alt="Profile Picture">
                                            <div>
                                                <div class="title">${r.title}</div>
                                                <div class="location">
                                                    <i class="fa fa-map-marker">
                                                    </i>
                                                        ${r.address}
                                                </div>
                                                <div class="salary">
                                                    <i class="fa fa-money"></i> ${r.salary}
                                                </div>
                                                <div class="experience">
                                                    <i class="fa fa-briefcase"></i> 1 năm (Nhân viên)
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%@ include file="../footer.jsp"%>
    </div>
</body>
</html>
