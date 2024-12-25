<%@ page import="java.io.PrintWriter" %><%--
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
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <script type="text/javascript" src="js/save.js"></script>
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
                    <form action="search-job" method="post" class="banner__header">
                        <div class="banner-search">
                            <div class="search__info search__city">
                                <i class="search__icon nav-item__icon fa-solid fa-magnifying-glass"></i>
                                <input type="text" name="searchName" class="banner__search-input search__city-info" placeholder="Nhập tên vị trí,công ty,từ khóa">
                            </div>
                            <div class="search__info search__address">
                                <i class="search__icon fa-solid fa-location-dot"></i>
                                <input type="text" name="searchAddress" class="banner__search-input search__address-info" placeholder="Nhập tỉnh,Thành phố">
                            </div>
                            <button class="banner__search-btn">
                                <i class="search-btn__icon fa-solid fa-magnifying-glass"></i>
                                <span class="search__label">Tìm kiếm</span>
                            </button>
                        </div>
                    </form>
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
                                <div href="" class="content__job-item">
                                        <div class="wrapper__logo">
                                            <a href="company-detail?jid=${nj.companyId}" class="wrapper__logo-link">
                                                <img src="${nj.img}" alt="" class="wrapper__img">
                                            </a>
                                        </div>
                                        <div class="wrapper__info">
                                            <div class="wrapper__header">
                                                <div class="job__name">
                                                    <span class="name-status">NEW</span>
                                                    <div class="job__tag">

                                                        <a class="name__lable" href="job-detail?jid=${nj.id}">${nj.title}</a>
                                                    </div>

                                                    <a href="#" onclick="return addJobToCartAjax(event, ${nj.id});" class="job__icon-like">
                                                        <i class="fa-regular fa-heart"></i>
                                                    </a>



                                                </div>
                                                <div class="job__company">
                                                            <span class="job__company-title">
                                                                <a href="/html/Job.html" class="job__company-link">${nj.companyName}</a>
                                                            </span>
                                                </div>
                                            </div>
                                            <div class="wrapper__infomation">
                                                <div class="infomation__address">
                                                    <i class="infomation__address-icon fa-solid fa-location-dot"></i>
                                                    <span class="infomation__address-lable">${nj.city}</span>
                                                </div>
                                                <div class="infomation__bottom">
                                                    <div class="infomation__salary">
                                                        <i class="salary-icon fa-solid fa-coins"></i>
                                                        <span class="salary-lable">${nj.salary}</span>
                                                    </div>
                                                    <div class="infomation__time">
                                                        <span class="infomation__posing-time">${nj.convertCreated}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </div>
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
                        <c:forEach var="j" items="${jobs}">
                        <div class="grid__col-4">
                            <div class="content__job-item">
                                <a href="/html/job_description.html" class="content__job-item-link">
                                    <div class="wrapper__logo">
                                        <a href="company-detail?jid=${j.companyId}" class="wrapper__logo-link">

                                            <img src="${j.img}" alt="" class="wrapper__img">
                                        </a>
                                    </div>
                                    <div class="wrapper__info">
                                        <div class="wrapper__header">
                                            <div class="job__name">
                                                <span class="name-status">HOT</span>
                                                <div class="job__tag">

                                                    <a class="name__lable" href="job-detail?jid=${j.id}">${j.title}</a>
                                                </div>

                                                <a  href="#" onclick="return addJobToCartAjax(event,${j.id})" class="job__icon-like">
                                                    <i class="fa-regular fa-heart"></i>
                                                </a>
                                            </div>
                                            <div class="job__company">
                                                    <span class="job__company-title">
                                                        <a href="company-detail?jid=${j.id}" class="job__company-link">${j.companyName}</a>
                                                    </span>
                                            </div>
                                        </div>
                                        <div class="wrapper__infomation">
                                            <div class="infomation__address">
                                                <i class="infomation__address-icon fa-solid fa-location-dot"></i>
                                                <span class="infomation__address-lable">${j.city}</span>
                                            </div>
                                            <div class="infomation__bottom">
                                                <div class="infomation__salary">
                                                    <i class="salary-icon fa-solid fa-coins"></i>
                                                    <span class="salary-lable">${j.salary}</span>
                                                </div>
                                                <div class="infomation__time">
                                                    <span class="infomation__posing-time">${j.convertCreated}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>

                    <c:set var="currentPage" value="${param.index != null ? param.index :  1}"/>
                    <c:set var="startPage" value="${param.index - 3}"/>
                    <c:set var="endPage" value="${param.index + 4}"/>

                    <c:if test="${startPage < 4}" >
                        <c:set var="startPage" value="1"/>
                        <c:set var="endPage" value="8"/>
                    </c:if>
                    <c:if test="${endPage > np}" >
<%--                        <c:set var="startPage" value="${8-(8 -(np - param.index))}"/>--%>
                        <c:set var="endPage" value="${np}"/>
                    </c:if>


                    <ul class="pagination home__pagination">
                        <c:forEach begin="${startPage}" end="${endPage}" var="i">
                            <li class="pagination__item">
                                <a href="home?index=${i}" class="${currentPage==i?"pagination__link--active":""} pagination__item-link">${i}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="slick_action__buttons">
                        <c:if test="${currentPage > 0}">
                            <form action="home" method="get">
                                <button type="submit" name="index" value="${currentPage == 1 ? np : currentPage - 1}" class="right__icon slick__action"> < </button>
                            </form>
                        </c:if>

                        <c:if test="${currentPage <= np}">
                            <form action="home" method="get">
                                <button type="submit" name="index" value="${currentPage == np ? 1 : currentPage + 1}" class="right__icon slick__action"> > </button>
                            </form>
                        </c:if>
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
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    %>
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

//      phân trang dùng AJAX
    // function getAllJob(event, index) {
    //     event.preventDefault();
    //
    //     fetch(`home?index=` + index, {
    //         method: 'GET'
    //     })
    //         .then(response => {
    //             if (response.ok) {
    //
    //                 // Thay đổi biểu tượng trái tim sau khi lưu
    //                 const heartIcon = event.target.closest('a').querySelector('i');
    //                 heartIcon.classList.remove('fa-regular');
    //                 heartIcon.classList.add('fa-solid');
    //
    //             }
    //             else {
    //                 alert('Có lỗi xảy ra!');
    //             }
    //         })
    //         .catch(error => {
    //             console.error('Error:', error);
    //             alert('Có lỗi xảy ra!');
    //         });
    //
    //     return false; // Ngừng hành động mặc định (tránh thay đổi trang)
    // }
    </script>
</body>
</html>