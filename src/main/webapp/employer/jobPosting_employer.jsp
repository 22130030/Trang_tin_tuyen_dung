<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 10:52 PM
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
    <link rel="stylesheet" href="../asserts/css/employer.css">
    <link rel="stylesheet" href="../asserts/css/main_job_posting.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/employer/employer_base.css">
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
                            Đăng công việc
                        </h1>
                    </div>
                </div>
                <div class="formcontainer">
                    <h1>Thông tin công việc</h1>

                    <form action="add-job-posting" method="post" id="job-posting-form">
                        <!-- Company Information Section -->
                        <fieldset>
                            <legend>Thông tin công ty</legend>
                            <label for="company-name">Tên công ty*</label>
                            <input name="companyName" type="text" id="company-name" placeholder="Tên công ty" required>

                            <label for="employee-size">Số nhân viên*</label>
                            <select id="employee-size" name="employerSize" required>
                                <option value="">Chọn số lượng</option>
                                <option value="under10">Ít hơn 10</option>
                                <option value="10-24">10 - 24</option>
                                <option value="25-99">25 - 99</option>
                                <option value="100-499">100 - 499</option>
                                <option value="500-999">500 - 999</option>
                                <option value="1.000-4.999">1.000 - 4.999</option>
                                <option value="5.000-9.999">5.000 - 9.999</option>
                                <option value="10.000-19.999">10.000 - 19.999</option>
                                <option value="20.000-49999">20.000 - 49999</option>
                                <option value="Hơn 50.000">Hơn 50.000</option>
                            </select>

                            <label for="website">Website công ty</label>
                            <input name="website" type="url" id="website" placeholder="Website công ty">

                            <label for="company-description">Sơ lược công ty</label>
                            <div id="editor-company-summary"></div>
                        </fieldset>

                        <!-- Job Information Section -->
                        <fieldset>
                            <legend>Thông tin công việc</legend>
                            <label for="job-title">Tên Công việc*</label>
                            <input name="jobName" type="text" id="job-title" placeholder="Tên công việc" required>

                            <label for="job-location">Địa điểm làm việc</label>
                            <input name="jobAddress" type="text" id="job-location" placeholder="Địa điểm">

                            <label>Lương*</label>
                            <div class="salary-options">
                                <label>
                                    <input type="radio" name="salary-type" value="nhap" checked> Nhập
                                </label>
                                <label>
                                    <input type="radio" name="salary-type" value="hon"> Hơn
                                </label>
                                <label>
                                    <input type="radio" name="salary-type" value="thuong-luong"> Thương lượng
                                </label>
                                <label>
                                    <input type="radio" name="salary-type" value="canh-tranh"> Cạnh tranh
                                </label>
                            </div>

                            <div class="salary-inputs">
                                <div class="salary-range">
                                    <div class="input-nhap salary-group">
                                        <input type="text" placeholder="VD: 10 hoặc 10.5" name="salary-value">
                                        <select name="salary-unit">
                                            <option value="trieu">triệu VND</option>
                                            <option value="nghin">nghìn VND</option>
                                        </select>
                                    </div>

                                    <div class="input-hon salary-group hidden">
                                        <input type="text" placeholder="VD: 10 hoặc 10.5" name="salary-value-hon">
                                        <select name="salary-unit-hon">
                                            <option value="trieu">triệu VND</option>
                                            <option value="nghin">nghìn VND</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="input-thuong-luong salary-group hidden">
                <span class="info-text">
                    ⚠️ Không hiển thị mức lương có thể làm giảm 30% lượng CV ứng tuyển!
                </span>
                                </div>

                                <div class="input-canh-tranh salary-group hidden">
                <span class="info-text">
                    ⚠️ Không hiển thị mức lương có thể làm giảm 30% lượng CV ứng tuyển!
                </span>
                                </div>
                            </div>

                            <div class="salary-warning">
                                <span class="warning-text">Bắt buộc</span>
                            </div>

                            <script>
                                // Function to handle salary input visibility
                                // Function to handle salary input visibility
                                document.querySelectorAll('input[name="salary-type"]').forEach((input) => {
                                    input.addEventListener('change', function () {
                                        // Hide all salary inputs first
                                        document.querySelectorAll('.salary-group').forEach((group) => {
                                            group.classList.add('hidden');
                                        });

                                        // Show the relevant salary input based on selection
                                        const salaryType = this.value;
                                        if (salaryType === 'nhap') {
                                            document.querySelector('.input-nhap').classList.remove('hidden');
                                        } else if (salaryType === 'hon') {
                                            document.querySelector('.input-hon').classList.remove('hidden');
                                        } else if (salaryType === 'thuong-luong') {
                                            document.querySelector('.input-thuong-luong').classList.remove('hidden');
                                        } else if (salaryType === 'canh-tranh') {
                                            document.querySelector('.input-canh-tranh').classList.remove('hidden');
                                        }
                                    });
                                });

                                // Initial trigger to display the correct salary input based on default selection
                                document.querySelector('input[name="salary-type"]:checked').dispatchEvent(new Event('change'));

                            </script>



                            <label for="job-description">Mô tả công việc*</label>
                            <div id="editor-job-description"></div>

                            <label for="job-requirements">Yêu cầu công việc*</label>
                            <div id="editor-job-requirements"></div>

                            <label for="benefits">Phúc lợi*</label>
                            <div id="benefits-container"></div>
                            <button type="button" id="add-benefit-btn" class="add-benefit">+ Thêm (tối đa 10)</button>
                        </fieldset>

                        <fieldset>
                            <legend>Chi tiết công việc</legend>
                            <label for="education-level">Trình độ học vấn*</label>
                            <select id="education-level" name="educationLevel" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="Trung học">Trung học</option>
                                <option value="Cử nhân">Cử nhân</option>
                                <option value="Thạc sĩ">Thạc sĩ</option>
                                <option value="Tiến sĩ">Tiến sĩ</option>
                            </select>

                            <label for="experience-level">Mức kinh nghiệm*</label>
                            <select id="experience-level" name="experienceLevel" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="Mới tốt nghiệp">Mới tốt nghiệp</option>
                                <option value="Nhân viên">Nhân viên</option>
                                <option value="Trưởng nhóm">Trưởng nhóm</option>
                                <option value="Quản lý">Quản lý</option>
                            </select>

                            <label for="job-type">Loại công việc*</label>
                            <select id="job-type" name="jobType" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="Toàn thời gian">Toàn thời gian</option>
                                <option value="Bán thời gian">Bán thời gian</option>
                                <option value="Tự do">Tự do</option>
                            </select>

                            <label for="gender">Giới tính*</label>
                            <select id="gender" name="gender" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="Nam">Nam</option>
                                <option value="female">Nữ</option>
                                <option value="Không yêu cầu">Không yêu cầu</option>
                            </select>

                            <label for="location">Nơi làm việc*</label>
                            <select id="location" name="location" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="Hà Nội">Hà Nội</option>
                                <option value="TP. Hồ Chí Minh">TP. Hồ Chí Minh</option>
                                <option value="Đà Nẵng">Đà Nẵng</option>
                            </select>

                            <label for="industry">Ngành nghề*</label>
                            <div class="industry-input">
                                <select id="industry" name="jobCategory" required>
                                    <option value="">Vui lòng chọn</option>
                                    <c:forEach items="${categoryList}" var="cl">
                                        <option value="${cl.name}">${cl.name}</option>
                                    </c:forEach>
                                </select>
                                <button type="button" class="add-industry">+ Thêm danh mục</button>
                            </div>

                            <label for="keywords">Từ khóa</label>
                            <input name="keywords" type="text" id="keywords" placeholder="Nhập từ khóa">

                            <label for="age">Tuổi*</label>
                            <select id="age" name="age" required>
                                <option value="">Không yêu cầu</option>
                                <option value="18-25">18-25</option>
                                <option value="26-35">26-35</option>
                                <option value="36-45">36-45</option>
                            </select>
                        </fieldset>

                        <!-- Contact Information -->
                        <fieldset>
                            <legend>Thông tin liên hệ</legend>
                            <label for="contact-name">Người liên hệ*</label>
                            <input type="text" id="contact-name" placeholder="Tên người liên hệ" name="contactName" required>

                            <label for="contact-phone">Điện thoại liên lạc*</label>
                            <input type="text" id="contact-phone" placeholder="Số điện thoại" name="contactPhone" required>

                            <label for="contact-email">Email liên hệ*</label>
                            <input type="email" id="contact-email" placeholder="Email liên hệ" name="contactEmail" required>

                            <label for="contact-address">Nơi làm việc*</label>
                            <input type="text" id="contact-address" placeholder="Địa điểm liên hệ" name="contactAddress" required>

                            <label for="contact-description">Mô tả</label>
                            <div id="wysiwyg-editor"></div>
                        </fieldset>

                        <!-- Posting Dates -->
                        <fieldset>
                            <legend>Ngày đăng</legend>
                            <label for="posting-date">Ngày đăng*</label>
                            <input type="date" id="posting-date" value="2024-11-25" name="jobPostingDate" required>

                            <label for="expiry-date">Ngày hết hạn*</label>
                            <input type="date" id="expiry-date" name="JobExpiryDate" required>
                        </fieldset>

                        <!-- Applicant Language -->
                        <fieldset>
                            <legend>Ngôn ngữ nhận hồ sơ ứng viên</legend>
                            <label for="language">Ngôn ngữ*</label>
                            <select id="language" name="language" required>
                                <option value="">Vui lòng chọn</option>
                                <option value="vietnamese">Tiếng Việt</option>
                                <option value="english">Tiếng Anh</option>
                            </select>
                            <label>
                                <input type="checkbox"> Chỉ nhận hồ sơ theo ngôn ngữ đã chọn
                            </label>
                        </fieldset>

                        <div class="formbutton">
                            <button  class="save">Lưu việc làm</button>
                            <button type="submit" class="post">Đăng công việc</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="../footer.jsp"%>
    </div>
</body>
</html>
