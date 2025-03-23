<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/6/2025
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="suggest__container">


    <div class="suggest__head">
        <h3>Gợi ý việc làm</h3>
        <span>Gợi ý này dựa trên các việc làm bạn đã xem</span>

    </div>

    <div class="suggest-list">

        <c:forEach var="hsj" items="${sessionScope.hsCart.list}">
        <div class="suggest-item">
            <a href="/html/job_description.html" class="suggest__link">
                <div class="suggest-thumb">
                    <img src="${hsj.img}" alt="">
                </div>
                <div class="suggest-content">

                    <a href="job-detail?jid=${hsj.id}" class="suggest-lable">${hsj.title}</a>
                    <a href="company-detail?jid=${hsj.companyId}" class="suggest-company">${hsj.companyName}
                    </a>
                    <div class="suggest-info">
                        <i class="fa-solid fa-location-dot"></i>
                        <span class="suggest-address">Hà nội</span>

                    </div>
                    <div class="suggest-detail">
                        <span class="suggest-salary">${hsj.salary}</span>
                        <a href="#" onclick="return addJobToCartAjax(event, ${hsj.id});" class="job__icon-like">
                            <i class="fa-regular fa-heart"></i>
                        </a>
                    </div>
                </div>
            </a>
        </div>
        </c:forEach>

    </div>
</div>
    <script>
        function addJobToCartAjax(event, jobId) {
            event.preventDefault();

            fetch(`addJob?jid=` + jobId, {
                method: 'GET'
            })
                .then(response => {
                    if (response.ok) {

                        // Thay đổi biểu tượng trái tim sau khi lưu
                        const heartIcon = event.target.closest('a').querySelector('i');
                        heartIcon.classList.remove('fa-regular');
                        heartIcon.classList.add('fa-solid');

                    }
                    else {
                        alert('Có lỗi xảy ra!');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Có lỗi xảy ra!');
                });

            return false; // Ngừng hành động mặc định (tránh thay đổi trang)
        }

    </script>
</body>
</html>
