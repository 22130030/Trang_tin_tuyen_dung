<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 10:48 PM
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
    <link rel="stylesheet" href="../asserts/css/main_job_posting.css">
    <link rel="stylesheet" href="../asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts//css/main_my_job.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <!-- js -->
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/bootstrap.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/main.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/popper.min.js"></script>
    <script src="../asserts/fonts/fontawesome-free-6.4.0-web/js/jquery-3.3.1.min.js"></script>
    <style>
        .badge-success{
            background-color: #28a745;
            color: white;
            font-size: 1.6rem;
        }
    </style>
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
                            Công việc của tôi
                        </h1>
                    </div>
                </div>
                <div class="container2">
                    <div class="search-bar">
                        <input id="jobName" name="jobName" type="text" placeholder="Tìm công việc" />
                        <select id="jobStatus">
                            <option>Trạng thái</option>
                            <option>Bản tạm</option>
                            <option>Đang chờ</option>
                            <option>Kích hoạt</option>
                            <option>Hết hạn</option>
                            <option>Ẩn</option>

                        </select>
                        <select id="jobCategory">
                            <option>Ngành nghề</option>
<%--                            <c:forEach items="${categoryList}" var="jc">--%>
<%--                                <option value="${jc.name}">${jc.name}</option>--%>

<%--                            </c:forEach>--%>
                        </select>
                        <select id="jobLocation">
                            <option>Nơi làm việc</option>
                            <option>Hồ Chí Minh</option>
                        </select>
                    </div>
                    <div class="pagination">
                        <div class="pagi">
                            <button class="page-button">&lt;</button>
                            <div class="page-number">1</div>
                            <button class="page-button">&gt;</button>
                        </div>
                        <div class="nation">
                            <p>Hiển thị:</p>
                            <select>
                                <option>25 Hàng</option>
                                <option>50 Hàng</option>
                                <option>75 Hàng</option>
                                <option>100 Hàng</option>
                            </select>
                        </div>
                    </div>
                    <table>
                        <thead>
                        <tr>
                            <th>Trạng thái</th>
                            <th>Công việc</th>
                            <th>Đơn ứng tuyển</th>
                            <th>Lượt xem</th>
                            <th>Cách hiển thị</th>
                            <th>Làm mới</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${jobList}" var="j">

                        <tr>
                            <td><span class="status badge-success">Hoạt động</span></td>
                            <td>
                                <div style="font-size : 1.7rem;color : var(--text-color);font-weight: bold">${j.title}</div>
                                <div>${j.convertCreated}</div>
                            </td>
                            <td>0 <i class="fa-regular fa-folder-closed"></i></td>
                            <td>0 <i class="fa-regular fa-eye"></i></td>
                            <td>Cách hiển thị: Bình thường</td>
                            <td>-

                            </td>
                            <td>
                                <a href="#">
                                    <i class="fa-regular fa-pen-to-square"></i>Sửa</a>
                                <a href="#">...</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
    <script>
        // Lắng nghe sự kiện change cho tất cả các trường input và select
        document.getElementById("jobName").addEventListener("change", sendData);
        document.getElementById("jobStatus").addEventListener("change", sendData);
        document.getElementById("jobCategory").addEventListener("change", sendData);
        document.getElementById("jobLocation").addEventListener("change", sendData);

        function sendData() {

        // Lấy giá trị từ các trường input và select
        var jobName = document.getElementById("jobName").value.trim();
        var jobStatus = document.getElementById("jobStatus").value.trim();
        var jobCategory = document.getElementById("jobCategory").value.trim();
        var jobLocation = document.getElementById("jobLocation").value.trim();

        // Xây dựng URL động chỉ với các tham số có giá trị
        var params = [];
        if (jobName) params.push("jobName=" + encodeURIComponent(jobName));
        if (jobStatus && jobStatus !== "Trạng thái") params.push("jobStatus=" + encodeURIComponent(jobStatus));
        if (jobCategory && jobCategory !== "Ngành nghề") params.push("jobCategory=" + encodeURIComponent(jobCategory));
        if (jobLocation && jobLocation !== "Nơi làm việc") params.push("jobLocation=" + encodeURIComponent(jobLocation));

        var queryString = params.length > 0 ? "?" + params.join("&") : "";

        // Tạo đối tượng XMLHttpRequest
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "filter-job" + queryString, true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            // Định nghĩa sự kiện khi nhận phản hồi từ server
            xhr.onload = function() {
                if (xhr.status === 200) {
                    // Xử lý phản hồi từ server và cập nhật bảng
                    const response = JSON.parse(xhr.responseText);

                    // Truy cập danh sách công việc
                    var jobList = response.result; // "result" chứa danh sách công việc
                    console.log("Job List:", jobList);
                    // Cập nhật bảng công việc
                    var tableBody = document.querySelector("table tbody");
                    tableBody.innerHTML = ""; // Xóa toàn bộ dữ liệu trong bảng

                    jobList.forEach(function(job) {
                        var row = document.createElement("tr");

                        var statusCell = document.createElement("td");
                        statusCell.innerHTML = "<span class='status badge-success'>Hoạt động</span>";
                        row.appendChild(statusCell);
                        console.log(job.title);
                        var jobCell = document.createElement("td");
                        jobCell.innerHTML = `<div style="font-size: 1.7rem;color: var(--text-color);font-weight: bold">`+job.title+`</div>`+
                                         `<div>`+job.created+`</div>`;
                        row.appendChild(jobCell);

                        var applyCell = document.createElement("td");
                        applyCell.innerHTML = "0 <i class='fa-regular fa-folder-closed'></i>";
                        row.appendChild(applyCell);

                        var viewCell = document.createElement("td");
                        viewCell.innerHTML = "0 <i class='fa-regular fa-eye'></i>";
                        row.appendChild(viewCell);

                        var displayCell = document.createElement("td");
                        displayCell.innerHTML = "Cách hiển thị: Bình thường";
                        row.appendChild(displayCell);

                        var refreshCell = document.createElement("td");
                        refreshCell.innerHTML = "-";
                        row.appendChild(refreshCell);

                        var actionCell = document.createElement("td");
                        actionCell.innerHTML = `<a href="#"> <i class='fa-regular fa-pen-to-square'></i>Sửa</a><a href="#">...</a>`;
                        row.appendChild(actionCell);

                        tableBody.appendChild(row);
                    });
                    var categoryList = response.categories;
                    console.log("Category List:", categoryList);
                    var categorySelect = document.getElementById("jobCategory");
                    categorySelect.innerHTML = '<option>Ngành nghề</option>'; // Xóa danh sách cũ
                    categoryList.forEach(function (category) {
                        var option = document.createElement("option");
                        option.value = category.category;
                        option.textContent = category.category;
                        categorySelect.appendChild(option);
                    });
                } else {
                    console.error("Lỗi trong quá trình gửi dữ liệu: " + xhr.status);
                }
            };

            // Xử lý lỗi nếu có
            xhr.onerror = function() {
                console.error("Đã xảy ra lỗi khi gửi yêu cầu.");
            };

            // Gửi yêu cầu AJAX
            xhr.send();
        }
    </script>

</body>
</html>
