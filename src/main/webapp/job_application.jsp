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
                            <h3 class="job-application__head">Hồ sơ xin việc(
                                <span class="job__application-toltal">0</span>
                                )
                            </h3>
                            <div class="job__application-content">
                                <img src="https://www.careerlink.vn/web/images/pages/my_careerlink/resumes-empty.png" alt="">
                                <span class="ja__content-descripton">Hiện tại bạn chưa có hồ sơ nào, xin hãy chọn nút "Tạo hồ sơ mới" để tạo hồ sơ cho bạn.</span>
                                <div class="user__profile-submit">
                                    <button class="user__profile-btn">
                                        <i class="fa-solid fa-plus"></i>
                                        Tạo hồ sơ mới
                                    </button>

                                </div>
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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

                                                <a href="/html/job_description.html" class="suggest-lable">Chuyên Viên Tư Vấn Tuyển Sinh</a>
                                                <a href="/html/Job.html" class="suggest-company">Công Ty Cổ Phần Smartcom Việt Nam
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
        <%@include file="footer.jsp"%>
    </div>
</body>
</html>
