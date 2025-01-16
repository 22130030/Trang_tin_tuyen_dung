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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Company</title>
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
                <c:forEach var="location" items="${locations}">
                    <li class="${location.hidden ? 'hidden-location' : ''}">
                        <input type="checkbox" name="location" value="${location.name}"> ${location.name}
                    </li>
                </c:forEach>
                <li><a href="#" id="show-all">Tất cả</a></li>
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
                                <img src="${c.img}" class="picture" alt="Company Logo">
                                <h3>${c.companyName}</h3>
                                <p>${c.jobCount} việc đang tuyển</p>
                                <p>${c.city}</p>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <%@include file="footer.jsp" %>
</div>



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