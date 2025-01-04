<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 20/12/2024
  Time: 1:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>company</title>
    <link rel="stylesheet" href="asserts/css/main_company.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
    <link rel="stylesheet" href="asserts/css/base.css">
</head>

<body>
<div class="application">
    <%@include file="header.jsp" %>
    <div class="container_2">
        <div class="wrap_flex">
            <h1 class="flex_fill">Nhà tuyển dụng hàng đầu</h1>
            <div class="d_flex" id="employ_search_container">
                <form action="company" method="post" id="employ_search_form">
                    <div class="form-group">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <input class="text_search" name="txtName" placeholder="Tìm công ty" type="text">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container_3">
        <aside class="sidebar">
            <h3>Nơi làm việc</h3>
            <ul id="location-list">
                <li><input type="checkbox" name="location" value="An Giang"> An Giang</li>
                <li><input type="checkbox" name="location" value="Bình Dương"> Bình Dương</li>
                <li><input type="checkbox" name="location" value="Bình Định"> Bình Định</li>
                <li><input type="checkbox" name="location" value="Bắc Giang"> Bắc Giang</li>
                <li><input type="checkbox" name="location" value="Bắc Cạn"> Bắc Cạn</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Bạc Liêu"> Bạc Liêu</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Bắc Ninh"> Bắc Ninh</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Bình Phước"> Bình Phước</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Bà Rịa - Vũng Tàu"> Bà Rịa - Vũng Tàu</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Bình Thuận"> Bình Thuận</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Cà Mau"> Cà Mau</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Cần Thơ"> Cần Thơ</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Đà Nẵng"> Đà Nẵng</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Đắk Lắk"> Đắk Lắk</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Điện Biên"> Điện Biên</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Đồng Nai"> Đồng Nai</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Đồng Tháp"> Đồng Tháp</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Hà Nội"> Hà Nội</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Hồ Chí Minh"> Hồ Chí Minh</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Khánh Hòa"> Khánh Hòa</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Lâm Đồng"> Lâm Đồng</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Nghệ An"> Nghệ An</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Quảng Bình"> Quảng Bình</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Thanh Hóa"> Thanh Hóa</li>
                <li class="hidden-location"><input type="checkbox" name="location" value="Thừa Thiên - Huế"> Thừa Thiên - Huế</li>
                <li><a href="#" id="show-all">Tất cả</a></li>
            </ul>
            <h3>Quy mô</h3>
            <ul>
                <li><input type="radio" name="size"> 25 - 99 nhân viên</li>
                <li><input type="radio" name="size"> 100 - 499 nhân viên</li>
                <li><input type="radio" name="size"> 500 - 999 nhân viên</li>
                <li><input type="radio" name="size"> 1.000 - 4.999 nhân viên</li>
                <li><input type="radio" name="size"> 5.000 - 9.999 nhân viên</li>
                <li><input type="radio" name="size"> 10.000 - 19.999 nhân viên</li>
            </ul>
        </aside>


        <div class="grid__col-10">
        <div class="company-list">
            <header>
                <h2>${size} công ty được tìm thấy</h2>
            </header>
                     <div class="grid__company">
                    <c:forEach var="c" items="${companies}">
                        <div class="company-card">
                            <a href="company-detail?jid=${c.id}" class="company-card__link">
                                <img src="${c.img}" class="picture" alt="NEXTDOOR Logo">
                                <h3>${c.companyName}</h3>
                                <p>0 việc đang tuyển</p>
                                <p> An Giang</p>
                            </a>
                        </div>


                    </c:forEach>
                </div>

            </div>
        </div>
    </div>
    <!-- footer -->
    <%@include file="footer.jsp" %>


        <script>

            document.getElementById("show-all").addEventListener("click", function (e) {
                e.preventDefault();

                // Toggle class để mở rộng danh sách
                const locationList = document.getElementById("location-list");
                locationList.classList.toggle("expanded");

                // Hiển thị các tỉnh bị ẩn
                const hiddenLocations = document.querySelectorAll(".hidden-location");
                hiddenLocations.forEach(location => {
                    if (location.style.display === "none" || location.style.display === "") {
                        location.style.display = "list-item";
                    } else {
                        location.style.display = "none";
                    }
                });

                // Thay đổi nội dung của "Tất cả" thành "Thu gọn" khi danh sách mở rộng
                if (locationList.classList.contains("expanded")) {
                    this.textContent = "Thu gọn";
                } else {
                    this.textContent = "Tất cả";
                }
            });

            // Lắng nghe sự kiện change trên tất cả checkbox
            const checkboxes = document.querySelectorAll('input[name="location"]');
            checkboxes.forEach(checkbox => {
                checkbox.addEventListener('change', function () {
                    const selectedLocations = Array.from(checkboxes)
                        .filter(cb => cb.checked)
                        .map(cb => cb.value);

                    // Gửi AJAX request
                    const xhr = new XMLHttpRequest();
                    xhr.open('POST', 'filter-company', true);
                    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                            const response = JSON.parse(xhr.responseText);
                            const companyListDiv = document.querySelector('.grid__company');
                            companyListDiv.innerHTML = '';  // Xóa kết quả hiện tại

                            // Cập nhật danh sách công ty
                            response.forEach(company => {
                                const companyCardHTML = `
                        <div class="company-card">
                            <a href="/html/job.html" class="company-card__link">
                                <img src="`+company.img+`" class="picture" alt="Company Logo">
                                <h3>`+company.companyName+`</h3>
                                <p>0 việc đang tuyển</p>
                                <p>`+company.city+`</p>
                            </a>
                        </div>
                    `;

                                // Append the HTML to the container
                                companyListDiv.innerHTML += companyCardHTML;  // Cộng thêm HTML mới vào
                            });
                        }
                    };

                    // Gửi dữ liệu (danh sách địa điểm đã chọn)
                    xhr.send(JSON.stringify({ locations: selectedLocations }));
                });
            });

        </script>
</body>
</html>