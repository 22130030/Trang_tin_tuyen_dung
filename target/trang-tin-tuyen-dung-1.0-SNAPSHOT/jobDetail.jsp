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
    <script src="ckeditor/ckeditor.js"></script>
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
                <c:forEach var="j" items="${jobs}">


                <div class="content__job-item">
                    <div class="wrapper__logo">
                        <img src="${j.img}" alt="picture" class="wrapper__img">
                    </div>
                    <div class="wrapper__info">
                        <div class="wrapper__header">
                            <div class="job__name">
                                <div class="job__tag">

                                    <a class="name__lable" href="">${j.title}</a>
                                </div>
                            </div>
                            <div class="job__company">
                                    <span class="job__company-title">
                                        ${j.companyName}
                                    </span>
                            </div>
                        </div>
                        <div class="wrapper__infomation">
                            <div class="infomation__address">
                                <i class="fa-solid fa-location-dot"></i>
                                <span class="infomation__address-lable">${j.city}</span>
                            </div>
                            <div class="infomation__bottom">
                                <div class="infomation__salary">
                                    <i class="salary-icon fa-solid fa-coins"></i>
                                    <span class="salary-lable">${j.salary}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
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

<!-- popup -->
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
        <div class="form--no-file">
            <p>Chọn hồ sơ</p>
            <button onclick="toggleFileAccountContainer()" class="file-btn upload-file--from-account active">Từ tài khoản <i class="fa-solid fa-chevron-down"></i>
                <div class="file-account-container">
                    <ul class="file-account__list">
                        <!-- Kiểm tra nếu có hồ sơ mới duyệt danh sách -->
                        <c:if test="${not empty sessionScope.jac.list}">
                            <c:forEach items="${sessionScope.jac.list}" var="f">
                                <li class="file-account-item">
                                    <i class="fa-regular fa-file"></i>
                                    <span class="file-account-item__title">${f.title}</span>
                                </li>
                            </c:forEach>
                        </c:if>

                        <!-- Nếu không có hồ sơ, hiển thị thông báo -->
                        <c:if test="${empty sessionScope.jac.list}">
                            <li class="file-account-item">
                                <span class="file-account-item__title">Bạn chưa có hồ sơ xin việc nào</span>
                            </li>
                        </c:if>
                    </ul>

                    <a href="job_application.jsp" class="add-file">
                        <i class="fa-solid fa-plus"></i>
                        <span>tạo hồ sơ mới</span>
                    </a>
                </div>
            </button>
            <input style="display: none" accept=".docx" type="file" id="file-input" />
            <button id="upload-btn" class="file-btn">Từ máy tính
            </button>
        </div>
        <div style="display: none" class="form--has-file">
            <p id="form--has-file__title"></p>
            <p id="form--has-file__type"></p>
            <p id="form--has-file__size"></p>
            <button id="remove-file">
                <i class="fa-solid fa-xmark"></i>
                <span class="remove-file__title">Bỏ chọn file</span>
                </button>
        </div>
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
        <button id="submit-btn" class="apply-btn">Nộp đơn ngay</button>
    </div>
    <p>Cho dù bạn chọn nút "Bảo mật" cho những thông tin hồ sơ trực tuyến mà bạn gởi cho Nhà tuyển dụng, nhưng Nhà tuyển dụng có thể truy cập đến tất cả nội dung thông tin có trong hồ sơ trực tuyến đó.</p>
</div>
<div id="popup__form-successful" class="form-container hidden">
    <button class="close-btn" onclick="closePopup()">✖</button>
    <div class="icon">✔</div>
    <div class="title">Nộp đơn thành công</div>
    <div class="message">
        Trạng thái đơn ứng tuyển của bạn sẽ được cập nhật tại
        <a href="job_applied.jsp" target="_blank">Việc đã ứng tuyển</a>. Hãy theo dõi thường xuyên.
    </div>
</div>

<script>
    const saveButton = document.getElementById('save__button');
    saveButton.addEventListener('click', () => handleSaveButton(saveButton));


    document.addEventListener('DOMContentLoaded', function () {
        const popupForm = document.getElementById('popupForm'); // Popup form
        const overlay = document.getElementById('overlay'); // Overlay
        const applyButton = document.getElementById('applyButton'); // Nút mở popup
        const footerApplyButton = document.getElementById('footerApplyButton');
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
            document.getElementById('popup__form-successful').classList.add('hidden');
        }
        //
        // // Gắn sự kiện mở popup
        applyButton.addEventListener('click', openPopup);
        footerApplyButton.addEventListener('click', openPopup);
        //
        // // Gắn sự kiện đóng popup
        closePopup.addEventListener('click', closePopupHandler);
        //
        overlay.addEventListener('click',closePopupHandler);
    });



    const fileInput = document.getElementById("file-input");
    const uploadBtn = document.getElementById("upload-btn");
    const fileNameDisplay = document.getElementById("form--has-file__title");
    const fileTypeDisplay = document.getElementById("form--has-file__type");
    const fileSizeDisplay = document.getElementById("form--has-file__size");
    const removeFile = document.getElementById("remove-file");
    const submitBtn = document.getElementById("submit-btn");
    const formNoFile = document.querySelector(".form--no-file");
    const formHasFile = document.querySelector(".form--has-file");
    const popupSuccess = document.getElementById("popup__form-successful");
    const popupForm = document.getElementById('popupForm'); // Popup form



    let selectedFile = null; // Biến lưu trữ file đã chọn

    // Khi nhấn "Từ máy tính" để chọn file
    uploadBtn.addEventListener("click", () => {
        fileInput.click();
    });

    // Khi người dùng chọn file
    fileInput.addEventListener("change", () => {
        if (fileInput.files.length > 0) {
            selectedFile = fileInput.files[0]; // Lưu file vào biến
            fileNameDisplay.textContent = `Tên file: ` + selectedFile.name;
            fileTypeDisplay.textContent=`Loại file : ` + selectedFile.name.split('.').pop().toLowerCase();
            fileSizeDisplay.textContent = `Kích thước: `+(selectedFile.size / 1024).toFixed(2)+ `KB`;
            formNoFile.style.display = "none";
            formHasFile.style.display = "block";
        }
    });

    // Khi nhấn "Bỏ chọn"
    removeFile.addEventListener("click", () => {
        selectedFile = null; // Reset file đã chọn
        fileInput.value = ""; // Reset input
        formNoFile.style.display = "block";
        formHasFile.style.display = "none";
    });

    // Khi nhấn "Nộp đơn"
    submitBtn.addEventListener("click", async () => {
        if (!selectedFile) {
            alert("Bạn chưa chọn file.");
            return;
        }

        const formData = new FormData();
        formData.append("file", selectedFile);

        try {
            const response = await fetch("job-applied?jid=${job.id}", {
                method: "POST",
                body: formData,
            });

            if (response.ok) {
                popupSuccess.classList.remove('hidden');
                popupForm.classList.add('hidden');
            } else {
                alert("Lỗi khi nộp đơn.");
            }
        } catch (error) {
            alert("Không thể gửi dữ liệu.");
        }
    });
                function closePopup() {
                    document.getElementById('popup__form-successful').classList.add('hidden');
                    document.getElementById('overlay').classList.add('hidden');
                }
    function toggleFileAccountContainer() {
        var container = document.querySelector('.file-account-container');
        if (container.style.display === 'none' || container.style.display === '') {
            container.style.display = 'block';
        } else {
            container.style.display = 'none';
        }
    }
</script>
</body>
</html>
