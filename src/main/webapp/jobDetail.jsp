<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/17/2024
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/owl.carousel.min.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/bootstrap.min.css">
  <!-- Style -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="asserts/css/Job.css">
  <link rel="stylesheet" href="asserts/css/base.css">
  <link rel="stylesheet" href="asserts/css/main_search_occupations_locat.css">
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

      <%@include file="header.jsp"%>

      <div class="bg-light py-lg-3">
        <div class="container px-0">
          <div class="company-header rounded-sm bg-white">
            <div class="company-banner position-relative" id="company-banner-container">
              <div class="company-banner-content overflow-hidden">
                <img class="img-fluid" style="top: 0%"
                     src="https://static.careerlink.vn/web/images/default_banner_0.svg"
                     alt="Default banner 0">
              </div>
            </div>
            <div class="company-summary position-relative d-flex">
              <div class="company-logo position-relative d-flex flex-center bg-white overflow-hidden shadow"
                   id="company-logo-container">
                <img class="mw-100"
                     src="${c.img}"
                     alt="7f1e8d88bba6dc19f8a4dc14a80872d1">
              </div>
              <div class="company-information flex-fill pl-lg-3 pt-3 pt-lg-0">
                <div class="d-flex">
                  <h5 class="company-name d-flex align-items-center" itemprop="name"
                      style="font-size: 25px;">
                    ${c.companyName}
                  </h5>
                </div>
                <div class="row no-gutters mt-2 mt-lg-0">
                  <div class="flex-fill row no-gutters">
                    <div class="col-lg-6 pr-lg-3">
                      <div class="d-flex">
                        <i class="cli-map-pin-line d-flex mr-2"></i>
                        <span>
                                                <img src="asserts/img/marker.png" style="width: 20px">
                                                ${c.address}
                                            </span>
                      </div>
                    </div>
                    <div class="col-lg-6 mt-2 mt-lg-0">
                      <div class="d-flex">
                        <i class="cli-users d-flex mr-2"></i>
                        <span itemprop="numberOfEmployees">
                                                <img src="asserts/img/users-alt.png" style="width:20px">
                                                5.000 - 9.999 nhân viên
                                            </span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="d-lg-flex mt-lg-3">
            <div class="col-lg-8 bg-white p-0 p-lg-4 rounded-sm">
              <div class="company-description text-secondary p-3 p-lg-0" id="company-description">
                <div class="d-flex align-items-center mb-3">
                  <h4 class="company-section-title mb-0" style="font-size: 25px;">
                    Về công ty
                  </h4>
                </div>
                <div class="text-collapse">
                  <div class="text-collapse--content company-profile mb-0" itemprop="description">
                    <p><strong>${c.description}</strong></p>
                    <p><strong>Thông tin chi tiết tham khảo tại website: ${c.website}</strong></p>
                  </div>
                </div>
              </div>

              <div class="mobile-divider"></div>
              <div class="mt-3 mt-lg-4 p-2 p-lg-0" id="company-jobs">
                <div class="px-2 px-lg-0">
                  <div class="d-flex flex-wrap align-items-center">
                    <h4 class="company-section-title">
                      Việc đang tuyển
                    </h4>
                    <div class="ml-auto">
                      <div class="d-flex align-items-center job-alert-box mb-2">
                        <i class="cli-bell mr-2"></i>
                        <p class="m-0">
                          <img src="asserts/img/bell-ring.png" style="width:20px">
                          Gửi thông báo cho tìm kiếm này
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="d-flex align-items-center mt-3">
                    <p class="m-0 text-secondary">
                                        <span class="jobs-count-number font-weight-semi-bold">
                                            180
                                        </span>
                      việc làm
                    </p>
                    <div class="jobs-sort d-flex align-items-center ml-auto">
                      <p class="m-0 mr-2">
                        Sắp xếp
                      </p>
                      <div class="dropdown"></div>
                      <a class="dropdown-toggle border px-2 py-1" role="button" href="#">Mới cập nhật
                      </a>
                    </div>
                  </div>
                </div>
                <ul class="list-group mt-4">
                      <c:forEach var="j" items="${jobs}">
                  <li class="list-group-item job-item p-0 rounded-lg mb-2 position-relative overflow-hidden  tlp-job">
                    <div class="media p-3 p-lg-4 align-items-lg-center">
                      <div
                              class="job-logo d-flex align-items-center justify-content-center mr-3 rounded-lg bg-white border">
                        <img alt="FPT Telecom" class="rounded-lg"
                             src="${j.img}">
                      </div>
                      <div class="media-body overflow-hidden">
                        <button
                                class="align-items-center border-0 d-flex pr-0 save-bottom-right save-btn text-primary">
                          <i class="cli-heart-light mr-1"></i>
                          <span class="d-none d-lg-inline-block">
                                                    <strong>
                                                        Lưu
                                                    </strong>
                                                </span>
                        </button>
                        <a class="job-link clickable-outside"
                           title="Nhân Viên Kỹ Thuật Viễn Thông - Bình Dương"
                           href="/html/job_description.html">
                          <h5 class="job-name text-line-clamp-2 mb-1 font-weight-bolder red">
                            ${j.title}
                          </h5>
                        </a><a class="text-dark job-company mb-1 d-inline-block line-clamp-1"
                               title="FPT Telecom" href="">${j.companyName}</a>
                        <div class="d-flex justify-content-between mb-1">
                          <div
                                  class="job-location text-secondary text-truncate d-flex align-items-center">
                            <i
                                    class="fa fa-map-marker-alt d-inline-block d-lg-none mr-1 text-center"></i>
                            <div class="list-with-comma mobile-disabled-link">
                              <a title="Bình Dương" class="text-reset"
                                 href="">${j.position}</a>
                            </div>
                          </div>
                          <span class="job-update-time d-none d-lg-block text-secondary">
                                                    Cập nhật:
                                                    <span class="cl-datetime">6 giờ trước</span>
                                                </span>
                        </div>
                        <div class="d-lg-flex justify-content-between">
                          <div class="d-flex align-items-center">
                                                    <span class="job-salary text-primary d-flex align-items-center">
                                                        <span class="font-weight-bolder d-lg-none">
                                                            <i
                                                                    class="fa fa-dollar-sign d-inline-block mr-1 text-center"></i>
                                                        </span>
                                                        ${j.salary}
                                                    </span>
                            <span class="text-muted px-2 d-none d-lg-block">|</span>
                            <a class="job-position text-secondary d-none d-lg-block"
                               href="/html/job_description.html">Mới đi làm
                            </a>
                          </div>
                          <div class="align-items-center justify-content-between">
                                                    <span class="job-update-time d-lg-none text-secondary">
                                                        Cập nhật:
                                                        <span class="cl-datetime">6 giờ
                                                            trước</span>
                                                    </span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                    </c:forEach>
                </ul>
                <nav>
                  <ul class="pagination">

                    <li class="page-item active">
                      <a class="page-link">1</a>
                    </li>

                    <li class="page-item">
                      <a rel="next" class="page-link" href="/html/Job.html">2</a>
                    </li>

                    <li class="page-item">
                      <a class="page-link" href="/html/Job.html">3</a>
                    </li>

                    <li class="page-item disabled">
                      <a class="page-link" href="/html/Job.html">…</a>
                    </li>

                    <li class="page-item">
                      <a class="page-link" href="/html/Job.html">9</a>
                    </li>

                    <li class="page-item">
                      <a rel="next" class="page-link d-none d-md-block" href="/html/Job.html">Sau
                        <i class="lni lni-arrow-right ml-1"></i>
                      </a>
                    </li>

                  </ul>
                </nav>


              </div>
              <div class="mobile-divider"></div>
              <div class="mt-lg-3">
                <div class="offices-map-container py-4 px-3 px-lg-0 mt-lg-4">
                  <div class="d-flex align-items-center w-100 mb-3">
                    <h4 class="company-section-title mb-0">
                      Nơi làm việc (218)
                    </h4>
                  </div>
                  <div class="overflow-hidden row no-gutters">
                    <div class="col-lg-6 mb-3">
                      <div class="list-group office-list-container beauty-scrollbar pr-lg-2">
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Tòa nhà FPT Tân Thuận
                                                    </span>
                          </h6>
                          <a class="text-primary d-inline-block mb-1" target="_parent"
                             href="/viec-lam-cua/fpt-telecom/14340/149">3 công việc đang tuyển
                          </a>
                          <p class="mb-0 office-address">
                            Lô L29B-31B-33B, Đường Tân Thuận, Kcx Tân Thuận, Quận 7, Hồ Chí Minh
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Lào Cai
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            228 đường Hoàng Liên, phường Cốc Lếu, Thành phố Lào Cai, Lào Cai
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Gia Lai
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            67 Tăng Bạt Hổ, Yên Đỗ, Thành phố Pleiku, Gia Lai
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Hưng Yên
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            Số 6, Đường 196 Phố Nối, TT Bần, Huyện Mỹ Hào, Hưng Yên
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Hậu Giang
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            10 Ngô Quốc Trị, Phường 5, Thi xa Vi Thanh, Hậu Giang
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Hà Nội
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            Tầng 5, tòa nhà PVI, 168 Trần Thái Tông, Yên Hòa, Quận Cầu Giấy, Hà
                            Nội
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Đà Lạt
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            38C Trần Phú, Phường 4, Thành phố Đà Lạt, Lâm Đồng
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Văn Phòng Thái Nguyên
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            156, Lương Ngọc Quyến, Thành phố Thái Nguyên, Thái Nguyên
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Thanh Hóa
                                                    </span>
                          </h6>
                          <a class="text-primary d-inline-block mb-1" target="_parent"
                             href="/html/Job.html">1 công việc đang tuyển
                          </a>
                          <p class="mb-0 office-address">
                            Lô 09 Phan Chu Trinh, Phường Điện Biên, Thành phố Thanh Hóa, Thanh
                            Hóa
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        FPT Chương Mỹ
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            55 Hòa Sơn, T.T Chúc Sơn, Huyện Chương Mỹ, Hà Nội
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        FPT Thống Nhất - Đồng Nai
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            48/1A, Ấp Đức Long, Xã Gia Tân 2, Huyện Thống Nhất, Đồng Nai
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        FPT Nguyễn Khang - Cầu Giấy
                                                    </span>
                          </h6>
                          <a class="text-primary d-inline-block mb-1" target="_parent"
                             href="/html/Job.html">1 công việc đang tuyển
                          </a>
                          <p class="mb-0 office-address">
                            51 ngõ 155 Nguyễn Khang, Quận Cầu Giấy, Hà Nội
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Phú Yến
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            A11 Khu Đô Thị Hưng Phú, Đường Trần Phú, Phường 5, Thành phố Tuy
                            Hòa,
                            Phú Yên
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Hà Tĩnh
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            16 Nguyễn Công Trứ, P Nam Hà, Thành phố Hà Tĩnh, Hà Tĩnh
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Tây Ninh
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            565 - 567 Cách mạng tháng 8, khu phố 6, phường 3, Thành phố Tây
                            Ninh,
                            Tây Ninh
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Tiền Giang
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            284 Ấp Bắc, phường 10, Thành phố Mỹ Tho, Tiền Giang
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Cao Bằng
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            8 Kim Đồng, Phường Hợp Giang, Thành phố Cao Bằng, Cao Bằng
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Lạng Sơn
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            312 Bà Triệu, phường Vĩnh Trại, Thành phố Lạng Sơn, Lạng Sơn
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Hà Nam
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            132 Trần Hưng Đạo, Phường Trần Hưng Đạo, Thành phố Phủ Lý, Hà Nam
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Ninh Thuận
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            256 Ngô Gia Tự, P. Tấn Tài, Thành phố Phan Rang - Tháp Chàm, Ninh
                            Thuận
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Vũng Tàu
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            408B Lê Hồng Phong, P.Thắng Tam, Thành phố Vũng Tàu, Bà Rịa - Vũng
                            Tàu
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Nha Trang
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            Tầng 1, 2 tòa nhà 42 Lê Thành Phương, Thành phố Nha Trang, Khánh Hòa
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Quảng Trị
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            159 QL9, Thành phố Đông Hà, Quảng Trị
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Quảng Bình
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            22 Trần Hưng Đạo, Đồng Phú, Thành phố Đồng Hới, Quảng Bình
                          </p>
                        </div>
                        <div class="office-item border border-light rounded-sm p-2 mb-2">
                          <h6
                                  class="d-flex align-items-baseline mb-1 office-name text-line-clamp-2">
                            <i class="cli-office d-flex mr-2"></i>
                            <span class="text-primary">
                                                        <img src="asserts/img/apartment.png" style="width:20px">
                                                        Chi Nhánh Ninh Bình
                                                    </span>
                          </h6>
                          <p class="mb-0 office-address">
                            195 Lê Đại Hành, Phố Thanh Sơn, Phường Thanh Bình, Thành phố Ninh
                            Bình,
                            Ninh Bình
                          </p>
                        </div>
                        <div class="d-flex justify-content-center" id="work-location-fetch-more">
                          <div class="spinner-border text-primary d-none" role="status">
                            <span class="sr-only">Loading...</span>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-6 pl-lg-2">
                      <div id="office-map">
                        <img class="map" src="asserts/img/map.jpg">
                      </div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
            <div class="mobile-divider"></div>
            <div class="col-lg-4 px-0 pl-lg-3">
              <div class="bg-white p-3 px-lg-4 rounded-sm" id="company-media">
                <div class="mb-3">
                  <div class="d-flex align-items-center mb-2 mx-n2">
                    <h6 class="px-2 mb-0">
                      Website
                    </h6>
                  </div>
                </div>
                <div class="company-links">
                  <h6 class="mb-2">
                    Theo dõi
                  </h6>
                  <div class="d-flex align-items-center">
                    <a class="cli-facebook" href="/html/Job.html" target="_blank" rel="nofollow">
                      <img class="social-icon mr-3 text-facebook border-facebook"
                           src="asserts/img/fb.png" style="width:40px" alt="Facebook">
                    </a>
                    <a class="cli-google" href="/html/Job.html" target="_blank" rel="nofollow"></a>
                    <img class="social-icon disabled mr-3 text-google border-google"
                         src="asserts/img/gg.png" style="width:40px">
                    </a>
                  </div>
                </div>
                <div class="company-images mt-3">
                  <div class="d-flex align-items-center mb-2 mx-n2">
                    <h6 class="px-2">
                      Hình ảnh công ty
                    </h6>
                  </div>
                  <div class="company-image-gallery">
                    <div class="gallery-img-box">
                      <img src="https://blob-careerlinkvn.careerlink.vn/company_photos/7c57e9a3564bf6e9968babb30e4b8ee3"
                           alt="" style="width:320px">
                    </div>
                    <div class="gallery-items mx-n1 mt-3 cl-scrollbar pb-2">
                      <div class="gallery-img-container mx-1 flex-shrink-0">
                        <div class="gallery-img-box">
                          <img class="img-thumbnail gallery-img"
                               src="https://blob-careerlinkvn.careerlink.vn/company_photos/7c57e9a3564bf6e9968babb30e4b8ee3"
                               alt="" style="width:80px">
                        </div>
                      </div>
                      <div class="gallery-img-container mx-1 flex-shrink-0">
                        <div class="gallery-img-box">
                          <img class="img-thumbnail gallery-img"
                               src="https://blob-careerlinkvn.careerlink.vn/company_photos/80ca1d6536755160a07dbc6d6dcb9308"
                               alt="" style="width:93px">
                        </div>
                      </div>
                      <div class="gallery-img-container mx-1 flex-shrink-0">
                        <div class="gallery-img-box">
                          <img class="img-thumbnail gallery-img"
                               src="https://blob-careerlinkvn.careerlink.vn/company_photos/c60ca006d9065842e6064509f8cc4e9f"
                               alt="" style="width:88px">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="mobile-divider"></div>
              <div class="bg-white rounded p-3 pt-4 pt-lg-3 mt-lg-3">
                <iframe allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"
                        height="400" src="" style="border:none;overflow:hidden" width="100%"></iframe>
              </div>
            </div>
          </div>
        </div>
      </div>

    <%@include file="footer.jsp"%>
    </div>
</body>
</html>
