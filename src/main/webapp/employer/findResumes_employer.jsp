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
                        <form action="find-profile" method="post" class="content">
                            <div class="search-box">
                                <i class="fa-solid fa-magnifying-glass"></i>
                                <input name="titleInput" type="text" placeholder="Nhập từ khóa" class="search-input">
                            </div>
                            <div class="search-box">
                                <i class="fa-solid fa-location-dot"></i>
                                <input name="addressInput" type="text" placeholder="Nhập tỉnh, thành phố" class="search-input">
                            </div>
                            <button type="submit">Tìm kiếm</button>
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
                                        <label for="industry">Ngành nghề</label>
                                        <select name="industry" id="industry">
                                            <option value="IT">Công nghệ thông tin</option>
                                            <option value="Accounting">Kế toán</option>
                                            <option value="Business">Quản trị kinh doanh</option>
                                            <option value="Marketing">Marketing</option>
                                        </select>
                                    </div>

                                    <div class="form__item">
                                        <label for="salary">Mức lương</label>
                                        <select name="salary" id="salary">
                                            <option value="0M-5M">Dưới 5 triệu</option>
                                            <option value="5M-10M">5 - 10 triệu</option>
                                            <option value="10M-20M">10 - 20 triệu</option>
                                            <option value="over-20M">Trên 20 triệu</option>
                                        </select>
                                    </div>

                                    <div class="form__item">
                                        <label for="education">Trình độ học vấn</label>
                                        <select name="education" id="education">
                                            <option value="HighSchool">Trung học phổ thông</option>
                                            <option value="College">Cao đẳng</option>
                                            <option value="University">Đại học</option>
                                            <option value="Master">Thạc sĩ</option>
                                            <option value="PhD">Tiến sĩ</option>
                                        </select>
                                    </div>

                                    <div class="form__item">
                                        <label for="school">Trường</label>
                                        <input type="text" name="school" id="school" placeholder="Nhập tên trường">
                                    </div>

                                    <div class="form__item">
                                        <label for="gender">Giới tính</label>
                                        <select name="gender" id="gender">
                                            <option value="any">Bất kỳ</option>
                                            <option value="male">Nam</option>
                                            <option value="female">Nữ</option>
                                            <option value="other">Khác</option>
                                        </select>
                                    </div>

                                    <div class="form__item">
                                        <label for="marital-status">Tình trạng hôn nhân</label>
                                        <select name="marital-status" id="marital-status">
                                            <option value="any">Bất kỳ</option>
                                            <option value="single">Độc thân</option>
                                            <option value="married">Đã kết hôn</option>
                                        </select>
                                    </div>

                                    <div class="form__item">
                                        <label for="age">Độ tuổi</label>
                                        <select name="age" id="age">
                                            <option value="any">Bất kỳ</option>
                                            <option value="15-20">15 - 20</option>
                                            <option value="20-30">20 - 30</option>
                                            <option value="30-40">30 - 40</option>
                                            <option value="over-40">Trên 40</option>
                                        </select>
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
                                            <img class="profile-card__img" src="../asserts/img/user.png" alt="Profile Picture">
                                            <div>
                                                <a href="download-file?path=${r.encodingPath}" class="title">${r.title}</a>
                                                <div class="location">
                                                    <i class="fa fa-map-marker">
                                                    </i>
                                                        ${r.address}
                                                </div>
                                                <div class="salary">
                                                    <i class="fa-solid fa-dollar-sign"></i>
                                                    <i class="fa fa-money"></i> ${r.salary}
                                                </div>
                                                <div class="experience">
                                                    <i class="fa fa-briefcase"></i>
                                                    ${r.type}
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
    <script>
        $(document).ready(function() {
            // Lưu giá trị ban đầu của các trường
            var previousValues = {
                industry: $('select[name="industry"]').val(),
                salary: $('select[name="salary"]').val(),
                education: $('select[name="education"]').val(),
                school: $('input[name="school"]').val(),
                gender: $('select[name="gender"]').val(),
                maritalStatus: $('select[name="marital-status"]').val(),
                age: $('select[name="age"]').val()
            };

            // Lắng nghe sự kiện thay đổi trên các trường lọc
            $('input, select').change(function() {
                // Kiểm tra và chỉ gửi trường có sự thay đổi
                var formData = {};

                // Kiểm tra nếu giá trị trường đã thay đổi
                $('input, select').each(function() {
                    var fieldName = $(this).attr('name');
                    var currentValue = $(this).val();

                    // Nếu giá trị trường đã thay đổi, thêm vào formData
                    if (currentValue !== previousValues[fieldName]) {
                        formData[fieldName] = currentValue;
                        previousValues[fieldName] = currentValue;  // Cập nhật giá trị mới
                    }
                });

                // Kiểm tra nếu có trường thay đổi
                if (Object.keys(formData).length > 0) {
                    // Gửi yêu cầu AJAX nếu có sự thay đổi
                    $.ajax({
                        type: "POST",
                        url: "filter-profile",  // Địa chỉ servlet xử lý lọc hồ sơ
                        data: formData,
                        success: function(response) {
                            // Lấy dữ liệu JSON trả về
                            var data = JSON.parse(response);  // Phân tích dữ liệu JSON
                            var resumes = data.result;  // Lấy mảng kết quả

                            // Tạo nội dung mới cho các hồ sơ
                            var content = '';
                            resumes.forEach(function(resume) {
                                console.log(resume);
                                content += '<div class="profile-card">';
                                content += '<div class="profile-card-content">';
                                content += '<img class="profile-card__img" src="../asserts/img/user.png" alt="Profile Picture">';
                                content += '<div>';
                                content += '<a href="download-file?path=' + resume.encodingPath + '" class="title">' + resume.title + '</a>';
                                content += '<div class="location"><i class="fa fa-map-marker"></i>' + resume.address + '</div>';
                                content += '<div class="salary"><i class="fa-solid fa-dollar-sign"></i>' + resume.salary + '</div>';
                                content += '<div class="experience"><i class="fa fa-briefcase"></i>' + resume.type + '</div>';
                                content += '</div></div></div>';
                            });

                            // Cập nhật nội dung vào phần tử có class 'item-has--profile'
                            $(".item-has--profile").html(content);
                        },
                        error: function(xhr, status, error) {
                            console.error("Lỗi: " + error);
                        }
                    });                }
            });
        });
    </script>


</body>
</html>
