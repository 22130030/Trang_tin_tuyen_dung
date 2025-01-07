<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/5/2025
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/candidate/job_application.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <link rel="stylesheet" href="asserts/css/candidate/account_base.css">
    <title>Hồ sơ xin việc</title>

</head>
<body>
    <div class="application">
        <%@ include file="header.jsp"%>
        <%@include file="menu_account.jsp"%>
        <div class="container">
            <div class="grid__1100">

                <div class="job__application">

                    <div class="grid__row">
                        <div class="grid__col-9">
                            <div class="job-application__header">

                                <h3 class="job-application__head">Hồ sơ xin việc(
                                    <span class="job__application-toltal">${sessionScope.jac == null ? 0 : sessionScope.jac.size}</span>
                                    )
                                </h3>
                                <input style="display: none" accept=".docx" type="file" id="file-input" />
                                <button id="upload-btn" class="job-application--add-file">
                                    <i class="fa-solid fa-plus"></i>
                                    <span>Thêm hồ sơ mới</span>
                                </button>
                            </div>
                            <div class="job__application-content" style="${empty sessionScope.jac.list ? 'display: block;' : 'display: none;'}">
                                <img src="https://www.careerlink.vn/web/images/pages/my_careerlink/resumes-empty.png" alt="">
                                <span class="ja__content-descripton">Hiện tại bạn chưa có hồ sơ nào, xin hãy chọn nút "Tạo hồ sơ mới" để tạo hồ sơ cho bạn.</span>
                                <div class="user__profile-submit">
                                    <button class="user__profile-btn">
                                        <i class="fa-solid fa-plus"></i>
                                        Tạo hồ sơ mới
                                    </button>
                                </div>
                            </div>

                            <div class="job__application-content--has-file" style="${!empty sessionScope.jac.list ? 'display: block;' : 'display: none;'}">
                                <c:forEach items="${sessionScope.jac.list}" var="f">
                                    <!-- File Item -->
                                    <div class="file-item">
                                        <div class="file-thumbnail">
                                            <i class="fa-regular fa-file"></i>
                                        </div>
                                        <div class="file-details">
                                            <p class="file-name">${f.title}</p>
                                            <p class="file-date">Chỉnh sửa lần cuối: 27/12/2024</p>
                                        </div>
                                        <div class="file-actions">
                                            <button class="btn-disabled" disabled>Bản tạm</button>
                                            <button class="btn-edit-small">
                                                <i class="fa-solid fa-pen"></i>
                                            </button>
                                            <button onclick="removeFileCart(event, ${f.id})" class="btn-delete-small">
                                                <i class="fa-solid fa-trash"></i>
                                            </button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>



                        </div>
                        <div class="grid__col-3">
                            <%@include file="suggest.jsp"%>
                        </div>
                    </div>
                </div>
                <div class="job__application-upload">
                    <h2>Tải hồ sơ lên</h2>
                    <div class="upload-box">
                        <div class="upload-content">
                            <i class="upload-content-img fa-regular fa-file"></i>
                            <p>Kéo thả tệp đính kèm<br>hoặc</p>
                            <button id="upload-file">Tải hồ sơ lên</button>
                            <p class="file-info">
                                File: doc, docx, xls, pdf (tối đa 3MB)<br>
                                Vui lòng không chọn file hình ảnh, bằng cấp
                            </p>
                        </div>
                    </div>
                    <div style="display: none;" class="upload-box--saved-file">
                        <p id="form--has-file__title"></p>
                        <p id="form--has-file__type"></p>
                        <p id="form--has-file__size"></p>
                        <button id="saved-file-btn">
                            <span class="saved-file__title">Lưu file</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </div>

    <script>
        const fileInput = document.getElementById("file-input");
        const uploadBtn = document.getElementById("upload-btn");
        const uploadFile = document.getElementById('upload-file')
        const userProfileBtn = document.querySelector('.user__profile-btn');
        const jobApp = document.querySelector(".job__application")
        const jobAppUpload = document.querySelector(".job__application-upload")
        const uploadBox = document.querySelector('.upload-box')
        const uploadBoxSavedFile = document.querySelector('.upload-box--saved-file');
        const fileNameDisplay = document.getElementById("form--has-file__title");
        const fileTypeDisplay = document.getElementById("form--has-file__type");
        const fileSizeDisplay = document.getElementById("form--has-file__size");
        const jobApplicationContent = document.querySelector('.job__application-content');
        const jobAppConHasFile = document.querySelector('.job__application-content--has-file');
        const savedFile = document.getElementById('saved-file-btn');


        uploadBtn.addEventListener("click", () => {
            jobApp.style.display = 'none';
            jobAppUpload.style.display = 'block';

        });
        userProfileBtn.addEventListener("click",()=>{
            jobApp.style.display = 'none';
            jobAppUpload.style.display = 'block';
        });
        uploadFile.addEventListener("click",() =>{
            fileInput.click();
        });
        let selectedFile = null;
        fileInput.addEventListener("change",() =>{
            if (fileInput.files.length > 0) {
                selectedFile = fileInput.files[0]; // Lưu file vào biến
                fileNameDisplay.textContent = `Tên file: ` + selectedFile.name;
                fileTypeDisplay.textContent=`Loại file : ` + selectedFile.name.split('.').pop().toLowerCase();
                fileSizeDisplay.textContent = `Kích thước: `+(selectedFile.size / 1024).toFixed(2)+ `KB`;
                uploadBox.style.display = "none";
                uploadBoxSavedFile.style.display = "inline-block";
            }
        });
        savedFile.addEventListener("click", async () => {
            if (!selectedFile) {
                alert("Bạn chưa chọn file.");
                return;
            }

            const formData = new FormData();
            formData.append("file", selectedFile);

            try {
                const response = await fetch("upload-file", {
                    method: "POST",
                    body: formData,
                });

                if (response.ok) {
                    window.location.href = "job_application.jsp"; // Chuyển hướng tới trang sau khi tải thành công
                } else {
                    alert("Lỗi khi nộp đơn.");
                }
            } catch (error) {
                alert("Không thể gửi dữ liệu.");
            }
        });
        function updateTotalJobCart() {
            fetch('update-file')
                .then(response => response.json())
                .then(data =>{
                    document.getElementsByClassName("job__application-toltal")[0].innerText = data.items;
                    document.getElementsByClassName("job__application-toltal")[1].innerText = data.items;
                })
        }
        function removeFileCart(event, fileId) {
            event.preventDefault(); // Ngừng hành động mặc định của liên kết (không chuyển trang)

            fetch('remove-file?fileId=' + fileId, {
                method: 'GET',
            })
                .then((response) => {
                    if (response.ok) {
                        updateTotalJobCart()
                        const fileItem = event.target.closest('.file-item'); // Lấy thẻ chứa file-item
                        if (fileItem) fileItem.remove(); // Xóa file khỏi DOM

                        // Kiểm tra xem còn file nào trong danh sách không
                        const remainingFiles = document.querySelectorAll('.file-item').length;

                        if (remainingFiles === 0) {
                            // Hiển thị thông báo không có file
                            jobApplicationContent.style.display = 'block';
                            jobAppConHasFile.style.display = 'none';
                        }
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                    alert('Có lỗi xảy ra!');
                });

            return false; // Đảm bảo không chuyển trang
        }
    </script>
</body>
</html>
