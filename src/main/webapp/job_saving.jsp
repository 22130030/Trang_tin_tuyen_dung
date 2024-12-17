<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/17/2024
  Time: 10:09 AM
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
    <link rel="stylesheet" href="asserts/css/candidate/job_saving.css">
    <link rel="stylesheet" href="asserts/css/candidate/account_base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Việc đã lưu</title>
</head>
<body>
<div class="application">
    <%@include file="header.jsp" %>
    <%@include file="menu_account.jsp" %>

    <div class="container">
        <div class="grid__1100">

            <div class="job__application">

                <div class="grid__row">
                    <div class="grid__col-9">
                        <h3 class="job-saving__head">Việc làm đã lưu(
                            <span class="job__saving-toltal">${sessionScope.cart.size==0?0:sessionScope.cart.size}</span>
                            )
                        </h3>
                        <span class="job-saving__saved-at">Tháng 11</span>
                        <div class="job__saving-list">
                            <c:set var="jobList" value="${sessionScope.cart.list}"/>
                            <c:forEach var="job" items="${jobList}">

                                <div class="job__saving-item">


                                    <div class="job__saving-thumb">
                                        <img src="${job.img}" alt="">
                                    </div>
                                    <div class="job__saving-content">
                                        <a href="/html/job_description.html" class="job__saving-link">

                                            <a href="/html/job_description.html"
                                               class="ls__content-lable">${job.title}</a>
                                            <a href="/html/Job.html" class="ls__content-company">Công ty cổ phần Người
                                                Bạn Vàng</a>
                                            <div class="ls__content-detail">
                                                <span class="ls__content-salary">${job.salary}</span>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="#" onclick="return removeJobCart(event, ${job.id})" class="ls__detail-save">
                                        <i class="fa-solid fa-heart"></i>
                                        <span class="saved-span">Đã lưu</span>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>


                    <div class="grid__col-3">


                        <div class="suggest__container">


                            <h3 class="suggest__head">Gợi ý việc làm</h3>

                            <div class="suggest-list">

                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="suggest-item">
                                    <a href="/html/job_description.html" class="suggest__link">
                                        <div class="suggest-thumb">
                                            <img src="	https://blob-careerlinkvn.careerlink.vn/company_logos/82c29a21edc8aae52392753e21d1ee36.png
                                                " alt="">
                                        </div>
                                        <div class="suggest-content">

                                            <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư
                                                Vấn Tuyển Sinh</a>
                                            <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom
                                                Việt Nam
                                            </a>
                                            <div class="suggest-info">
                                                <i class="fa-solid fa-location-dot"></i>
                                                <span class="suggest-address">Hà nội</span>

                                            </div>
                                            <div class="suggest-detail">
                                                <span class="suggest-salary">1,500 USD - 2000 USD</span>
                                                <div class="suggest-save">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>

</div>
<script>
    function updateTotalJobCart() {
        fetch('updateJob')
            .then(response => response.json())
            .then(data =>{
                document.getElementsByClassName("job__saving-toltal")[0].innerText = data.items;
                document.getElementsByClassName("job__saving-toltal")[1].innerText = data.items;
            })
    }

    function removeJobCart(event, jobId) {
        event.preventDefault();  // Ngừng hành động mặc định của liên kết (không chuyển trang)

        fetch('removeJob?jid=' + jobId, {
            method: 'GET'
        })
            .then(response => {
                if(response.ok){
                updateTotalJobCart();

                    const jobItem =  event.target.closest('.job__saving-item');
                    if (jobItem)
                        jobItem.remove();
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Có lỗi xảy ra!');
            });

        return false;  // Đảm bảo không chuyển trang
    }
</script>
</body>
</html>
