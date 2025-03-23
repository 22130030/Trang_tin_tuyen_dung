<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/26/2024
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>search</title>
    <link rel="stylesheet" href="asserts/css/main_search_occupations_locat.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">>
</head>
<body>
<div class="application">
    <%@include file="header.jsp"%>
<%--    <div class="boxmenu">--%>
<%--        <ul>--%>
<%--            <li><a href="/"><i class="fa-solid fa-border-all"></i> Ngành nghề <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">An Ninh / Bảo Vệ</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">An Toàn / Lao Động</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Bán Hàng / Kinh Doanh</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Bán lẻ / Bán sỉ</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Bảo hiểm</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>
<%--            <li><a href="/"><i class="fa-solid fa-layer-group"></i> Cấp bậc <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">Thực tập</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Mới đi làm</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Nhân viên</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Trưởng phòng / Quản lý</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Giám đốc</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="/"><i class="fa-solid fa-stopwatch"></i> Kinh nghiệm <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">Dưới 1 năm</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">1 - 2 năm</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">2 - 5 năm</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">5 - 10 năm</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Trên 10 năm</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>
<%--            <li><a href="/"><i class="fa-solid fa-hand-holding-dollar"></i> Mức lương <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">1 - 20 triệu</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">21 - 40 triệu</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">41 - 60 triệu</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">61 - 80 triệu</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">81 - 100 triệu</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>


<%--            <li><a href="/"><i class="fa-solid fa-graduation-cap"></i> Học vấn <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">Trung học phổ thông</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Trung cấp</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Cao đẳng / Đại học</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Thạc sĩ</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Tiến sĩ</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>

<%--            <li><a href="/"><i class="fa-solid fa-briefcase"></i> Loại công việc <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">Toàn thời gian</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Bán thời gian</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">Thời vụ</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>

<%--            <li><a href="/"><i class="fa-solid fa-calendar-days"></i> Đăng trong <i class="fa-solid fa-angle-down"></i></a>--%>
<%--                <div class="box-submenu">--%>
<%--                    <ul>--%>
<%--                        <li><input type="checkbox"><a href="">Hôm nay</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">3 ngày</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">1 tuần</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">2 tuần</a></li>--%>
<%--                        <li><input type="checkbox"><a href="">1 tháng</a></li>--%>
<%--                        <p class="delete"><i class="fa-solid fa-trash-can"></i> Xóa lọc</p>--%>
<%--                    </ul>--%>
<%--                </div></li>--%>
<%--        </ul>--%>
<%--    </div>--%>

    <div class="container">

        <div class="header">
            <h1>Tìm kiếm việc làm nhanh</h1>
            <p>
                <a href="">Việc làm hấp dẫn</a>
                |
                <a href="">Việc làm cao cấp($1000+)</a>
                |
                <a href="">Việc làm tuyển gấp</a>
            </p>
        </div>
        <div class="foother">

        </div>
    </div>
    <div class="container2">
        <div class="main-content">
            <div class="job">
                <div class="job-categories">

                    <h2>Tìm kiếm việc làm nhanh theo ngành nghề</h2>
                    <c:forEach var="entry" items="${categories}">

                    <div class="category">
                        <h3>${entry.key.name}</h3>
                        <c:forEach var="value" items="${entry.value}">
                            <ul class="list_unstyled">
                                <li class="border_bottom">
                                    <a href="search-job?cid=${value.id}&name=${value.name}" class="text_body">${value.name} </a>
                                    <span></span>
                                </li>
                            </ul>
                        </c:forEach>
                    </div>
                    </c:forEach>
                </div>
                <div class="job-categories">
                    <h2>Tìm kiếm việc làm nhanh theo địa điểm</h2>
                    <c:forEach var="l" items="${locations}">

                    <div class="category">
                        <h3>${l.key}</h3>
                        <ul class="list_unstyled">
                            <c:forEach var="value" items="${l.value}">

                            <li class="border_bottom">
                                <a href="search-job?location=${value}" class="text_body">
                                    ${value} </a>
                                <span></span>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                    </c:forEach>
                </div>
            </div>

            <div class="location">
                <h3>Địa điểm phổ biến</h3>
                <ul>
                    <li>Hồ Chí Minh <span>(5930)</span></li>
                    <li>Hà Nội <span>(5479)</span></li>
                    <li>Đà Nẵng <span>(1619)</span></li>
                    <li>Bình Dương <span>(1201)</span></li>
                    <li>Đồng Nai <span>(1094)</span></li>
                    <li>Bắc Ninh <span>(882)</span></li>
                    <li>Hải Phòng <span>(868)</span></li>
                    <li>Kiên Giang <span>(698)</span></li>
                </ul>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>

</body>
</html>
