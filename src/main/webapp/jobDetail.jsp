<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/18/2024
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="asserts/css/main_job_description.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <script type="text/javascript" src="js/save.js"></script>
    <title>Thông Tin Tuyển Dụng</title>
</head>
<body>
<div class="application">

    <%@include file="header.jsp" %>

    <!-- Phần nội dung chính -->
    <div class="container">
        <!-- Phần thông tin chi tiết công việc -->
        <div class="main-content">
            <div class="header-background"></div>
            <div class="job-header">
                <img src="${job.img}" alt="Logo Công Ty" class="company-logo">
                <div class="job-details">
                    <h1>${job.title}</h1>
                    <a href="/html/Job.html" class="job-details__link">${job.companyName}</a>
                    <p><i class="fas fa-map-marker-alt"></i> Quận Cầu Giấy, Hà Nội</p>
                    <p><strong><i class="fa-solid fa-sack-dollar"></i>Lương:</strong> ${job.salary}</p>
                    <p><strong><i class="fa-solid fa-briefcase"></i>Kinh nghiệm:</strong> 2 - 5 năm kinh nghiệm</p>
                    <p><strong><i class="fa-regular fa-calendar-check"></i>Ngày đăng tuyển:</strong> ${job.convertCreated} | Hết hạn trong: <span class="highlight">5 Ngày tới</span></p>
                    <button id="applyButton" class="apply-button">Nộp đơn ngay</button>
                    <a href="#" onclick="return addJobToCartAjax(event, ${job.id});"  id="save__button" class="save-button" >
                        <i class="fa-regular fa-heart"></i>
                        Lưu
                    </a>
                </div>
            </div>

            <div class="job-description">
                <h2>Mô tả công việc</h2>
                <ul>
                    <li>- Nắm chắc hệ thống các khóa học trực tiếp và trực tuyến của Smartcom English.</li>
                    <li>- Tư vấn phụ huynh và học sinh vào đúng lớp học và trình độ tiếng Anh thông qua danh sách học viên có sẵn của công ty.</li>
                    <li>- Chăm sóc học viên, hỗ trợ giải đáp các thắc mắc của khách hàng thông qua hình thức điện thoại/chat/tư vấn trực tiếp, mời tham gia test đầu vào, học thử tại trung tâm.</li>
                    <li>- Tổ chức kiểm tra đầu vào, các buổi hội thảo giới thiệu chương trình tiếng Anh chuẩn tại các thị trường được chỉ định.</li>
                    <li>- Theo dõi, hỗ trợ giáo vụ các chương trình chăm sóc học viên của trung tâm.</li>
                    <li>- Phối hợp với các giáo viên nắm bắt được nhu cầu, nguyện vọng của phụ huynh, học sinh để đưa ra phương án hỗ trợ kịp thời.</li>
                    <li>- Phối hợp với phòng Marketing thực hiện các chiến dịch truyền thông khóa học tiếng Anh.</li>
                    <li>- Phát triển và duy trì mỗi quan hệ vững chắc với học viên để nâng cao tỷ lệ chuyển đổi khách hàng thân thiết.</li>
                    <li>- Phối hợp với phòng Marketing thực hiện các chiến dịch truyền thông khóa học tiếng Anh.</li>
                    <li>- Phát triển và duy trì mỗi quan hệ vững chắc với học viên để nâng cao tỷ lệ chuyển đổi khách hàng thân thiết.</li>
                    <li>- Hoàn thành chỉ tiêu doanh số phòng theo sự phân công của cấp trên.</li>
                    <li>- Lập báo cáo, theo dõi, đánh giá tiến độ thực hiện công việc.</li>
                </ul>
            </div>

            <div class="job-description">
                <h2>Phúc lợi</h2>
                <ul>
                    <li>Được đi du lịch 1 lần trong 1 năm</li>
                    <li>Được hưởng chế độ BHYT, BHXH, BHTN theo quy địn</li>
                    <li>12 ngày nghỉ phép có lương</li>
                    <li>Được review 2 lần trong năm</li>
                    <li>Môi trường làm việc hòa đồng, thân thiện</li>
                </ul>
            </div>

            <div class="job-description">
                <h2>Kinh  nghiệm / Kĩ năng chi tiết</h2>
                <ul>
                    <li>Tốt nghiệp Cao đẳng, Đại học trở lên.
                    </li>
                    <li>Kinh nghiệm làm việc tối thiểu 2 năm, có kinh nghiệm ngành đào tạo là lợi thế.
                    </li>
                    <li>Khả năng giao tiếp tốt, giọng nói chuẩn, ngoại hình ưa nhìn.
                    </li>
                    <li>Thành thạo kỹ năng tin học văn phòng, lập báo cáo excel, google doc.
                    </li>
                    <li>Kỹ năng làm việc độc lập, chịu được áp lực công việc.
                    </li>
                    <li>Khả năng lập kế hoạch, thuyết trình, quản lý công việc, lập báo cáo.

                    </li>
                    <li>Sáng tạo nhiệt tình, thái độ làm việc tích cực.

                    </li>
                    <li>Có máy tính cá nhân và phương tiện đi lại.


                    </li>
                </ul>
            </div>
            <div class="job-info-section">

                <h2>Mô tả</h2>
                <div class="info-container">
                    <div class="info-box">
                        <p><i class="fas fa-briefcase"></i> <strong>Loại công việc</strong>Nhân viên toàn thời gian</p>
                        <p><i class="fas fa-layer-group"></i> <strong>Cấp bậc</strong>Nhân viên</p>
                        <p><i class="fas fa-graduation-cap"></i> <strong>Học vấn</strong>Cao đẳng</p>
                    </div>
                    <div class="info-box">
                        <p><i class="fas fa-briefcase"></i> <strong>Kinh nghiệm</strong>2 - 5 năm kinh nghiệm</p>
                        <p><i class="fas fa-venus-mars"></i> <strong>Giới tính</strong>Nam / Nữ</p>
                        <p><i class="fas fa-th"></i> <strong>Ngành nghề</strong>Tư vấn, Dịch vụ khách hàng, Giáo dục / Đào tạo / Thư viện</p>
                    </div>
                </div>
            </div>

            <div class="contact-info-section">
                <h2>Thông tin liên hệ</h2>
                <div class="contact-box">
                    <p><i class="fas fa-user-circle"></i> <strong>Tên liên hệ:</strong> Giang Hoàng</p>
                    <p><i class="fas fa-map-marker-alt"></i> Tầng 4 nhà 29T2, đường Hoàng Đạo Thúy, khu đô thị Trung Hòa Nhân Chính, Quận Cầu Giấy, Hà Nội, Viet Nam</p>
                    <p><i class="fas fa-calendar-alt"></i> <em>- Các ứng viên quan tâm vui lòng nộp hồ sơ trực tuyến qua Careerlink, công ty sẽ liên hệ phỏng vấn ứng viên phù hợp.</em></p>
                </div>
                <p >Nhận hồ sơ bằng ngôn ngữ: Tiếng Việt</p>
            </div>
            <div class="job-description">
                <h2>Về công ty</h2>
                <h3>Công Ty Cổ Phần Smartcom Việt Nam</h3>
                <h4>
                    <a class="link" href="">https://smartcom.vn/</a> |
                    25 - 99 nhân viên |
                    Liên hệ: Giang Hoàng</h4>
                <p>Giới thiệu Công ty Smartcom Việt Nam
                    Smartcom English (là thương hiệu Hệ thống Anh ngữ Smartcom)
                    Thành lập từ tháng 9/2006, Smartcom tiên phong sáng tạo công nghệ 4.0 trong giảng dạy tiếng Anh.
                    Với một lượng khách hàng rất lớn gồm: hơn 3 triệu lượt học viên học trực tuyến, trên 200.000 học viên học trực tiếp tại các trung tâm, hàng trăm khách hàng là tập đoàn, tổ chức lớn như: Bộ Giáo dục & Đào tạo, Đài truyền hình Việt Nam (VTV), Sở GDĐT Hà Nội, Sở GD Hải Dương, Tập đoàn Vingroup, Viettel, FPT, Mobifone, Vinaconex, Honda, LG, Canon v.v… các trường đại học: Ngoại Thương, ĐH Bách Khoa HN, Học viện Công nghệ Bưu Chính Viễn Thông, ĐH Công nghiệp HN, ĐH Công nghiệp TP HCM, ĐH Công...
                </p>
                <a class="link" href="">Xem thêm</a>
            </div>

            <div class="share-section">
                <span>Chia sẻ</span>
                <div class="share-icons">
                    <a href="#" class="share-icon fb"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="share-icon linkedin"><i class="fab fa-linkedin-in"></i></a>
                    <a href="#" class="share-icon twitter"><i class="fab fa-twitter"></i></a>
                    <a href="#" class="share-icon link"><i class="fas fa-link"></i></a>
                </div>
            </div>
        </div>
        <!-- Phần danh sách công việc tương tự -->
        <div class="sidebar">
            <button class="notify-button"><i class="fas fa-bell"></i> Gửi cho tôi việc tương tự</button>
            <div class="grid__row">
                <h2>Việc tương tự</h2>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://blob-careerlinkvn.careerlink.vn/company_logos/49770d19ebd2b01ed9d4debfd5eea62b.png" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">KẾ TOÁN TRƯỞNG</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        CÔNG TY OPPO VIỆT NAM
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Cạnh tranh</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/6481511d84e590fe1229ba45134e2f5b" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Nhân Viên Chăm Sóc Khách Hàng</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        CÔNG TY TNHH BỆNH VIỆN  ĐA KHOA TÂM TRÍ SÀI GÒN
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/fef478c7dd5a9b526fa99e7797517085" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Nhân Viên Chăm Sóc Khách Hàng</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        CÔNG TY CỔ PHẦN TẬP ĐOÀN KIM TÍN
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://blob-careerlinkvn.careerlink.vn/company_logos/d6ef11da31c499211d5e753c21d93a8e.png" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Nhân Viên Chăm Sóc Khách Hàng(Quận 12-HCM)</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        Công Ty TNHH Ô Tô Điện Miền Nam (Vifast Cộng Hòa)
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">8 triệu - 10 triệu</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/91374f7e0ce4c0a1db8dc0df3adb5229" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Nhân Viên  Kinh Doanh  Dịch Vụ Cảng</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        Công Ty Cổ Phần Đồng Tâm
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Thành phố Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/19014613b5c280b61e795e6f31559c9f" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">NHÂN VIÊN KINH DOANH</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        Công Ty Cổ Phần Sợi Thế Kỷ
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh, Tây Ninh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://blob-careerlinkvn.careerlink.vn/company_logos/49770d19ebd2b01ed9d4debfd5eea62b.png" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Call Center Agent(Tiếng Trung)</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        CÔNG TY OPPO VIỆT NAM
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/f3c05bd148493f375543af83bcf8baec" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Customer Service Specialist</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        Công Ty Cổ Phần  Vàng Bạc Đá  quý Phú Nhuận - PNJ
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/41046bd58f763fd70022b845b3535561" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">NHÂN VIÊN QC CÔNG ĐOẠN(PQC)</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        NIPRO VIETNAM CO.,LTD
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Cạnh tranh</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/41046bd58f763fd70022b845b3535561" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Tổ trưởng/Tổ phó QA</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        CÔNG TY TNHH SÀI GÒN PRECISION
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Thương lượng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="https://static.careerlink.vn/image/8e21cf2da00ad17e92fd05425978edd6" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">Trưởng Phòng Điều Hành Tour Inbound</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        Công Ty CP Du lịch Coxi
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">Hồ Chí Minh</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">Cạnh tranh</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- Sticky Footer Bar -->
    <div id="stickyFooter">
        <div class="job-summary" id="job-summary">
            <div class="block">
                <img src="https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png" alt="Company Logo" class="company-logo">
                <div class="summary-content">
                    <h2>Chuyên Viên Tư Vấn Tuyển Sinh</h2>
                    <p>Công Ty Cổ Phần Smartcom Việt Nam</p>
                </div>
                <div class="summary-buttons">
                    <button id="footerApplyButton" class="apply-btn">Nộp đơn ngay</button>
                    <button class="save-btn">Lưu</button>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <%@include file="footer.jsp"%>

</div>
<!-- Overlay -->
<div id="overlay" class="hidden"></div>

<!-- poppup -->
<div  id="popupForm" class="form-container hidden">
    <div class="form-content ">
        <div class="head">
            <h2>NỘP ĐƠN NHÂN VIÊN QA_GIẢI QUYẾT KHIẾU NẠI</h2>

        </div>

        <p class="user-info">03. Lê Minh Công</p>
        <p class="email">leminhcong8323@gmail.com</p>
        <div class="form-group">
<%--            <label for="resume">Hồ sơ xin việc*</label>--%>
            <div class="file-options">
                <p>Chọn hồ sơ</p>
                <button class="file-btn active">Từ tài khoản <i class="fa-solid fa-chevron-down"></i></button>
                <button class="file-btn">Từ máy tính</button>
            </div>
            <p class="file-note">File: doc, docx, xls, pdf (tối đa 3MB).</p>
            <p class="requirement">Nhà tuyển dụng yêu cầu hồ sơ: <span class="highlight">Tiếng Anh</span></p>
        </div>

        <div class="form-group">
            <label for="phone">Số điện thoại*</label>
            <div class="phone-input">
                <span class="phone-icon">📞</span>
                <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại của bạn">
            </div>
            <p class="contact-note">Nhà tuyển dụng có thể liên hệ với bạn qua số điện thoại này.</p>
        </div>

        <div class="form-group">
            <label for="cover-letter">Thư xin việc <span class="optional">(Không bắt buộc)</span></label>
            <select id="cover-letter" name="cover-letter">
                <option value="none">Không sử dụng</option>
            </select>
        </div>

        <div class="warning-message">
            <p>⚠️ 17 thg 8, 2023</p>
            <p>
                Một số kẻ mạo danh nhà tuyển dụng đã bị báo cáo về hành vi lừa đảo người dùng của chúng tôi, họ yêu cầu ứng viên phải trả phí thông qua việc tải về một ứng dụng. Chúng tôi muốn nhấn mạnh rằng các ứng viên không phải chi trả bất kỳ khoản phí nào khi nộp đơn ứng tuyển trên CareerLink.vn. Vui lòng báo cáo với chúng tôi nếu bạn bắt gặp nhà tuyển dụng nào yêu cầu bạn thanh toán phí. Xin cảm ơn.</p>
        </div>
    </div>

    <div class="form-actions">
        <button id="closePopup" class="save-btn">Hủy</button>
        <button class="apply-btn">Nộp đơn ngay</button>
    </div>
    <p>Cho dù bạn chọn nút "Bảo mật" cho những thông tin hồ sơ trực tuyến mà bạn gởi cho Nhà tuyển dụng, nhưng Nhà tuyển dụng có thể truy cập đến tất cả nội dung thông tin có trong hồ sơ trực tuyến đó.</p>
</div>
<script>
    const saveButton = document.getElementById('save__button');
    saveButton.addEventListener('click', () => handleSaveButton(saveButton));


    document.addEventListener('DOMContentLoaded', function () {
        const popupForm = document.getElementById('popupForm'); // Popup form
        const overlay = document.getElementById('overlay'); // Overlay
        const applyButton = document.getElementById('applyButton'); // Nút mở popup
        const closePopup = document.getElementById('closePopup'); // Nút đóng popup

        // Hàm mở popup và overlay
        function openPopup() {
            popupForm.classList.remove('hidden'); // Hiển thị popup
            overlay.classList.remove('hidden'); // Hiển thị overlay
        }

        // Hàm đóng popup và overlay
        function closePopupHandler() {
            popupForm.classList.add('hidden'); // Ẩn popup
            overlay.classList.add('hidden'); // Ẩn overlay
        }
        //
        // // Gắn sự kiện mở popup
        applyButton.addEventListener('click', openPopup);
        //
        // // Gắn sự kiện đóng popup
        closePopup.addEventListener('click', closePopupHandler);
        //
        overlay.addEventListener('click',closePopupHandler);
    });



</script>

</body>
</html>
