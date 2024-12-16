<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/12/2024
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="asserts/css/main.css">
    <link rel="stylesheet" href="asserts/css/finding_profile.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Kiếm việc làm online</title>
</head>
<body>
    <div class="application">
    <!-- header -->
    <!-- navigation -->
        <%@include file="header.jsp" %>

        <div class="header">

            <!-- banner -->
            <div class="banner">
                <div class="banner__slide">
                    <div class="banner__list">

                        <div class="banner__img">
                            <img src="asserts/img/banner_home/ViecLamHCD.png" alt="">
                        </div>
                        <div class="banner__img">
                            <img src="asserts/img/banner_home/OIP.jpg" alt="">
                        </div>
                        <div class="banner__img">
                            <img src="asserts/img/banner_home/fpt.jpg" alt="">
                        </div>
                        <div class="banner__img">
                            <img src="asserts/img/banner_home/thuan_duc.jpg" alt="">
                        </div>
                        <div class="banner__img">
                            <img src="asserts/img/banner_home/tokyolife.jpg" alt="">
                        </div>
                    </div>
                </div>


                <div class="grid">
                    <div class="banner__header">
                        <div class="banner-search">
                            <div class="search__info search__city">
                                <i class="search__icon nav-item__icon fa-solid fa-magnifying-glass"></i>
                                <input type="text" class="banner__search-input search__city-info" placeholder="Nhập tên vị trí,công ty,từ khóa">
                            </div>
                            <div class="search__info search__address">
                                <i class="search__icon fa-solid fa-location-dot"></i>
                                <input type="text" class="banner__search-input search__address-info" placeholder="Nhập tỉnh,Thành phố">
                            </div>
                            <button class="banner__search-btn">
                                <i class="search-btn__icon fa-solid fa-magnifying-glass"></i>
                                <span class="search__label">Tìm kiếm</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="slick_action__buttons">
                    <button class="left_icon slick__action" id="banner__prev"> < </button>
                    <button class="right__icon slick__action" id="banner__next"> > </button>
                </div>
                <ul class="banner__dots">
                    <li class="dot__active banner__dot"></li>
                    <li class="banner__dot"></li>
                    <li class="banner__dot"></li>
                    <li class="banner__dot"></li>
                    <li class="banner__dot"></li>
                </ul>
            </div>
        </div>
        <div class="content__new-jobs">
            <div class="grid">
                <div class="content-head">
                    <h2 class="content__title">Việc làm mới nhất</h2>
                    <a href="/html/lastest_jobs.html" class="content__show-all">
                        <span class="show-all__lable">Xem tất cả</span>
                        <span class="show-all__right-icon"> > </span>
                    </a>
                </div>
            </div>
            <div class="new__jobs-container">
                <div class="grid">
                    <div class="grid__row jobs">
<%--                        <div class="new__job-list">--%>
                                <c:forEach var="nj" items="${newJob}">
                            <div class="grid__col-3">
                                <di class="content__job-item">
                                    <a href="/html/job_description.html" class="content__job-item-link">
                                        <div class="wrapper__logo">
                                            <a href="/html/Job.html" class="wrapper__logo-link">

                                                <img src="${nj.img}" alt="" class="wrapper__img">
                                            </a>
                                        </div>
                                        <div class="wrapper__info">
                                            <div class="wrapper__header">
                                                <div class="job__name">
                                                    <span class="name-status">NEW</span>
                                                    <div class="job__tag">

                                                        <a class="name__lable" href="/html/job_description.html">${nj.title}</a>
                                                    </div>

                                                    <div class="job__icon-like">
                                                        <i class="fa-regular fa-heart"></i>
                                                    </div>
                                                </div>
                                                <div class="job__company">
                                                            <span class="job__company-title">
                                                                <a href="/html/Job.html" class="job__company-link">


                                                                    Công Ty Cổ Phần Bán Lẻ Kĩ Thuật Số FPT
                                                                </a>
                                                            </span>
                                                </div>
                                            </div>
                                            <div class="wrapper__infomation">
                                                <div class="infomation__address">
                                                    <i class="infomation__address-icon fa-solid fa-location-dot"></i>
                                                    <span class="infomation__address-lable">${nj.position}</span>
                                                </div>
                                                <div class="infomation__bottom">
                                                    <div class="infomation__salary">
                                                        <i class="salary-icon fa-solid fa-coins"></i>
                                                        <span class="salary-lable">${nj.salary}</span>
                                                    </div>
                                                    <div class="infomation__time">
                                                        <span class="infomation__posing-time">Một ngày trước</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </di>
                            </div>
                                </c:forEach>
<%--                        </div>--%>


                    </div>
                </div>
            </div>

        </div>
        <div class="content-main">
            <div class="grid">
                <div class="content-head">
                    <h2 class="content__title">Việc làm hấp dẫn</h2>
                    <a href="" class="content__show-all">
                        <span class="show-all__lable">Xem tất cả</span>
                        <span class="show-all__right-icon"> > </span>
                    </a>
                </div>
            </div>
            <div class="content__container">
                <div class="grid">
                    <div class="grid__row jobs">
                        <c:forEach var="aj" items="${allJob}">
                        <div class="grid__col-4">
                            <div class="content__job-item">
                                <a href="/html/job_description.html" class="content__job-item-link">
                                    <div class="wrapper__logo">
                                        <a href="/html/Job.html" class="wrapper__logo-link">

                                            <img src="${aj.img}" alt="" class="wrapper__img">
                                        </a>
                                    </div>
                                    <div class="wrapper__info">
                                        <div class="wrapper__header">
                                            <div class="job__name">
                                                <span class="name-status">HOT</span>
                                                <div class="job__tag">

                                                    <a class="name__lable" href="/html/job_description.html">${aj.title}</a>
                                                </div>

                                                <div class="job__icon-like">
                                                    <i class="fa-regular fa-heart"></i>
                                                </div>
                                            </div>
                                            <div class="job__company">
                                                    <span class="job__company-title">
                                                        <a href="/html/Job.html" class="job__company-link">


                                                            CÔNG TY UNI-PRESIDENT VIỆT NAM
                                                        </a>
                                                    </span>
                                            </div>
                                        </div>
                                        <div class="wrapper__infomation">
                                            <div class="infomation__address">
                                                <i class="infomation__address-icon fa-solid fa-location-dot"></i>
                                                <span class="infomation__address-lable">${aj.position}</span>
                                            </div>
                                            <div class="infomation__bottom">
                                                <div class="infomation__salary">
                                                    <i class="salary-icon fa-solid fa-coins"></i>
                                                    <span class="salary-lable">${aj.salary}</span>
                                                </div>
                                                <div class="infomation__time">
                                                    <span class="infomation__posing-time">Ba ngày trước</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <ul class="pagination home__pagination">
                        <li class="pagination__item">
                            <a href="" class="pagination__link--active pagination__item-link">1</a>
                        </li>
                        <li class="pagination__item">
                            <a href="" class="pagination__item-link">2</a>
                        </li>
                        <li class="pagination__item">
                            <a href="" class="pagination__item-link">3</a>
                        </li>
                        <li class="pagination__item">
                            <a href="" class="pagination__item-link">...</a>
                        </li>
                        <li class="pagination__item">
                            <a href="" class="pagination__item-link">6</a>
                        </li>
                    </ul>
                    <div class="slick_action__buttons">
                        <button class="right__icon slick__action"> < </button>
                        <button class="right__icon slick__action"> > </button>
                    </div>


                </div>
            </div>

        </div>

        <div class="content-categorys">
            <div class="grid">
                <div class="content-head">
                    <h2 class="content__title">Việc làm theo ngành nghề</h2>
                    <a href="" class="content__show-all">
                        <span class="show-all__lable">Xem tất cả</span>
                        <span class="show-all__right-icon"> > </span>
                    </a>
                </div>
            </div>
            <div class="category__container">
                <div class="grid">
                    <div class="grid__row jobs">
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="https://static.careerlink.vn/web/images/categories/1.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Kế toán / Kiểm toán</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="	https://static.careerlink.vn/web/images/categories/2.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Quảng cáo / Khuyến mãi / Đối ngoại</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="	https://static.careerlink.vn/web/images/categories/3.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Nông nghiệp / Lâm Nghiệp</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="	https://static.careerlink.vn/web/images/categories/4.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Nghệ thuật / Thiết kê giải trí</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="https://static.careerlink.vn/web/images/categories/5.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Ngân hàng / Chứng khoán</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                        <div class="grid__col-2">
                            <div class="category__card">
                                <div class="card__img">

                                    <img src="https://static.careerlink.vn/web/images/categories/6.svg" alt="">
                                </div>
                                <a href="" class="card__link">
                                    <span class="card__title">Thư ký / Hành chánh</span>
                                </a>
                                <span class="card__quantity-job">1513 việc làm</span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="slick_action__buttons">
                    <button class="right__icon slick__action"> < </button>
                    <button class="right__icon slick__action"> > </button>
                </div>
            </div>
        </div>
    <!-- footer -->
        <%@include file="footer.jsp" %>


    </div>
</body>
</html>