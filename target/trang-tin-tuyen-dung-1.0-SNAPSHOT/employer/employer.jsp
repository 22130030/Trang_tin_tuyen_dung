<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="../asserts/css/employer.css">
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
                <div class="container pb-4 px-0 px-lg-3">
                    <div class="row no-gutters">
                        <div class="employer-info col-12 d-flex flex-column flex-md-row">
                            <div class="col-md-5 p-0 bg-white">
                                <div class="employer-info-box overflow-hidden">
                                    <div class="employer-company-banner position-relative">
                                        <div class="employer-company-banner-content overflow-hidden">
                                            <img alt="công ty 3 thành viên" class="img-fluid" style="top: 0%"
                                                 src="https://static.careerlink.vn/web/images/default_banner_1.svg">
                                        </div>
                                    </div>
                                    <div class="employer-info-content d-flex">
                                        <div class="d-flex align-items-start flex-column mr-3 flex-grow-1">
                                            <div class="employer-header d-flex">
                                                <div
                                                        class="employer-company-logo d-flex align-items-center justify-content-center overflow-hidden border rounded bg-white ml-3">
                                                    <img alt="công ty 3 thành viên" class="mw-100"
                                                         src="https://static.careerlink.vn/web/images/common/no-logo.png">
                                                </div>
                                                <div class="employer-status m-2">
                                                    <div>
                                                        <span class="text-secondary text-small">Trạng thái: </span>
                                                        <b class="text-small">
                                                            Chưa làm gì
                                                        </b>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="ml-3 mt-2">
                                                <h5 class="employer-company-name mb-1">
                                                    công ty 3 thành viên
                                                </h5>
                                                <div class="text-secondary text-line-clamp-1 text-break text-small">
                                                    leminhcong8323@gmail.com
                                                </div>
                                            </div>
                                        </div>
                                        <div class="employer-action-btn px-2">
                                            <a class="btn btn-primary w-100 mt-2 text-small text-white px-2 py-1"
                                               href="/html/employer.html">Yêu cầu truy cập hồ sơ
                                            </a>
                                        </div>
                                    </div>
                                    <div class="employer-info-footer d-flex justify-content-between py-2 px-3">
                                        <div class="text-secondary">
                                        <span class="text-small d-flex align-items-center">
                                            <i class="mr-1 mt-1 cli-calendar"></i>
                                            <img src="/asserts/img/calendar-check.png" style="width:12px">
                                            Đăng kí vào: 15 Thg 11, 2024
                                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div
                                    class="col-md-7 employer-short-info p-0 d-flex flex-wrap justify-content-between mt-md-0 mt-2">
                                <div class="short-info d-flex align-items-center bg-white col-4 p-4 ml-md-3">
                                    <div>
                                        <span class="consumed-quota-credits d-block">0</span>
                                        <span class="text-secondary text-small d-block">Credits Left</span>
                                    </div>

                                </div>
                                <div class="short-info d-flex align-items-center bg-white col-4 p-4 ml-md-3">
                                    <div class="employer-active-jobs">
                                        <div>
                                        <span class="active-job-count">
                                            0
                                            <img src="/asserts/img/briefcase.png">
                                        </span>
                                            <i class="cli-suitcase-simple ml-2"></i>
                                        </div>
                                        <div>
                                            <div class="text-secondary text-small"> Việc đang kích hoạt</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="short-info d-flex align-items-center bg-white col-4 p-4 ml-md-3 mt-lg-0">
                                    <div class="employer-active-jobs">
                                        <div>
                                        <span class="latest-applications-count">0
                                            <img src="/asserts/img/envelope-open-text.png">
                                        </span>
                                            <i class="lni lni-folder ml-2"></i>
                                        </div>
                                        <div>
                                            <div class="text-secondary text-small">Thư xin việc gần đây</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mobile-divider d-md-none"></div>
                        <div class="col-lg-12 mt-3">
                            <div class="employer-latest-applications bg-white">
                                <div class="d-flex justify-content-between align-items-md-center mb-3 px-3 pt-3">
                                    <div class="section-header d-flex align-items-center">
                                        <h5 class="page-title mr-auto mb-md-0 mt-1 mt-md-0">
                                            Đơn ứng tuyển gần đây
                                        </h5>
                                        <div class="mr-md-4 overflow-hidden d-flex ml-md-3" id="applications-filter">
                                            <div
                                                    class="filter-option d-flex align-items-center cursor-pointer active px-2 py-1">
                                            <span class="text-line-clamp-1">
                                                Tất cả
                                            </span>
                                            </div>
                                            <div class="filter-option d-flex align-items-center cursor-pointer px-2 py-1">
                                            <span class="text-line-clamp-1">
                                                Chưa xem
                                            </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="view-all">
                                        <a class="btn btn-link d-flex text-decoration-none px-0" id="see-all-applications"
                                           href="/html/employer/employer.html">Xem tất cả
                                            <i class="cli-right-arrow d-flex ml-md-1"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="section-with-loading">
                                    <div class="loading-box box rounded-lg m-3">
                                        <div class="spinner-bounce">
                                            <div class="bounce1"></div>
                                            <div class="bounce2"></div>
                                            <div class="bounce3"></div>
                                        </div>
                                    </div>
                                    <div class="loading-content my-3 overflow-hidden">
                                        <div id="employer-latest-applications-section" class="">
                                            <div class="latest-applications-header px-3 d-none d-md-block py-2">
                                                <div class="row no-gutters py-2 bg-light">
                                                    <div class="col-7 d-flex align-items-center">
                                                        <div class="col-6">
                                                            <span>Đơn ứng tuyển</span>
                                                        </div>
                                                        <div class="col-3">
                                                            <span>Nhận lúc</span>
                                                        </div>
                                                        <div class="col-3">
                                                            <span>Trạng thái</span>
                                                        </div>
                                                    </div>
                                                    <div class="col-5 d-flex align-items-center">
                                                        <div class="col-9">
                                                            <span>Công việc</span>
                                                        </div>
                                                        <div class="col-3">
                                                            <span>Tin nhắn</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="latest-applications-list beauty-scrollbar px-3">
                                                <div class="text-center">
                                                    <p class="text-muted my-4">
                                                        Bạn không có thư xin việc nào phù hợp
                                                    </p>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                            <div class="mobile-divider d-md-none"></div>
                            <section class="employer-latest-jobs bg-white rounded shadow-sm p-3">
                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <h5 class="page-title font-weight-bold mb-0 text-primary">
                                        Công việc đang kích hoạt
                                    </h5>
                                    <a class="text-decoration-none d-flex align-items-center text-secondary" href="/html/employer/employer.html">
                                        Xem tất cả (3)
                                        <i class="cli-right-arrow ml-2"></i>
                                    </a>
                                </div>

                                <div class="employer-latest-jobs-content">
                                    <!-- Header của bảng -->
                                    <div class="row no-gutters text-secondary font-weight-bold py-2 d-none d-lg-flex border-bottom">
                                        <div class="col-lg-7 col-xl-8 row no-gutters">
                                            <div class="col-lg-2">Trạng thái</div>
                                            <div class="col-lg-6">Công việc</div>
                                            <div class="col-lg-2 text-center">Đơn ứng tuyển</div>
                                            <div class="col-lg-2 text-center">Lượt xem</div>
                                        </div>
                                        <div class="col-lg-5 col-xl-4 row no-gutters">
                                            <div class="col-lg-5">Ngày đăng</div>
                                            <div class="col-lg-4 text-center">Làm mới</div>
                                        </div>
                                    </div>

                                    <!-- Danh sách công việc -->
                                    <div class="row no-gutters py-3 border-bottom job-item">
                                        <div class="col-lg-7 col-xl-8 row no-gutters">
                                            <div class="col-lg-2">
                                                <span class="badge badge-success">Kích hoạt</span>
                                            </div>
                                            <div class="col-lg-6">
                                                <a href="#" class="job-title">Quản lý dự án IT</a>
                                            </div>
                                            <div class="col-lg-2 text-center">5</div>
                                            <div class="col-lg-2 text-center">125</div>
                                        </div>
                                        <div class="col-lg-5 col-xl-4 row no-gutters">
                                            <div class="col-lg-5">11/01/2025</div>
                                            <div class="col-lg-4 text-center">
                                                <button class="btn btn-outline-primary btn-sm">Làm mới</button>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Another job entry -->
                                    <div class="row no-gutters py-3 border-bottom job-item">
                                        <div class="col-lg-7 col-xl-8 row no-gutters">
                                            <div class="col-lg-2">
                                                <span class="badge badge-warning">Chờ duyệt</span>
                                            </div>
                                            <div class="col-lg-6">
                                                <a href="#" class="job-title">Chuyên viên Marketing</a>
                                            </div>
                                            <div class="col-lg-2 text-center">3</div>
                                            <div class="col-lg-2 text-center">80</div>
                                        </div>
                                        <div class="col-lg-5 col-xl-4 row no-gutters">
                                            <div class="col-lg-5">10/01/2025</div>
                                            <div class="col-lg-4 text-center">
                                                <button class="btn btn-outline-primary btn-sm">Làm mới</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>


                        </div>
                    </div>
                    <div class="mobile-divider d-md-none"></div>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
</body>
</html>
