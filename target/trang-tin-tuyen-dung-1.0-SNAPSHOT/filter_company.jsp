<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 20/12/2024
  Time: 4:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form id="employ_search_form">
          <div class="form-group">
            <i class="fa-solid fa-magnifying-glass"></i>
            <input class="text_search" placeholder="Tìm công ty" type="text">
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="container_3">
    <aside class="sidebar">
      <!-- FORM BỘ LỌC -->
      <form action="filter-company" method="POST">
        <h3>Nơi làm việc</h3>
        <ul id="location-list">
          <li><input type="checkbox" name="location" value="An Giang"> An Giang</li>
          <li><input type="checkbox" name="location" value="Bình Dương"> Bình Dương</li>
          <!-- Thêm các tỉnh thành khác -->
        </ul>

        <h3>Quy mô</h3>
        <ul>
          <li><input type="radio" name="scale" value="25 - 99 nhân viên"> 25 - 99 nhân viên</li>
          <li><input type="radio" name="scale" value="100 - 499 nhân viên"> 100 - 499 nhân viên</li>
          <!-- Thêm các tùy chọn khác -->
        </ul>

        <button type="submit">Lọc</button>
      </form>
    </aside>

    <!-- DANH SÁCH KẾT QUẢ SAU LỌC -->
    <main class="company-list">
      <header>
        <h2>
          <c:choose>
            <c:when test="${not empty filteredCompanies}">
              ${filteredCompanies.size()} công ty được tìm thấy
            </c:when>
            <c:otherwise>
              Không có công ty nào được tìm thấy
            </c:otherwise>
          </c:choose>
        </h2>
      </header>

      <div class="grid__company">
        <c:forEach var="company" items="${filteredCompanies}">
          <div class="company-card">
            <a href="company-detail?id=${company.id}" class="company-card__link">
              <img src="${company.image}" class="picture" alt="${company.name} Logo">
              <h3>${company.name}</h3>
              <p>${company.scale}</p>
              <p>${company.location}</p>
            </a>
          </div>
        </c:forEach>
      </div>
    </main>
  </div>
  <%@include file="footer.jsp" %>
</div>
</body>
</html>
