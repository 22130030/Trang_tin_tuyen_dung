<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/12/2025
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/admin/admin_category.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">


    <title>AdminCategory</title>

</head>
<body>
<div class="admin">
    <%@include file="header_admin.jsp"%>

    <div class="container">

        <!-- Sidebar -->
        <%@include file="sidebar_admin.jsp"%>
        <!-- Table Section -->
        <div id="table-container">
            <h3>Quản lý ngành nghề</h3>
            <div class="category_management">
                <form action="manager-category" method="post" class="category__search">
                    <input class="search__input" type="text" name="name" class="search__candidate" placeholder="Nhập tên ngành nghề">

                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </form>
                <div class="category__add">

                    <h4 class="category__add-list">Danh sách bài đăng :
                        <a href="add" class="list__add-link">thêm mới</a>
                    </h4>
                </div>
                </h4>

                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Phân loại</th>
                        <th>Tên ngành nghề</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${category}" var="c">
                        <tr>
                            <td>${c.categoryID}</td>
                            <td>${c.categoryName}</td>
                            <td class="classify__title">${c.jobPostCategoryName}</td>
                            <td>
                                <div class="operations">

                                    <div class="operation operation__edit">
                                        <a href="loadcategory?lid=${c.jobPostCategoryID}" class="operation__edit-link">
                                            <i class="fa-solid fa-pen"></i>
                                        </a>
                                    </div>
                                    <div class="operation operation__remove">
                                       <a href="delete-category?did=${c.jobPostCategoryID}">
                                           <i class="fa-solid fa-trash"></i>
                                       </a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <div id="addCategoryForm">
            <h3 class="form__title">Thêm ngành nghề</h3>
            <form class="form__content" action="">
                <div class="form__item">

                    <label for="name">Phân loại </label>
                    <select name="classify" id="classify">

                        <option value="classify-item">Hình thức làm việc
                        </option>
                        <option value="classify-item">Ngành nghề
                        </option>
                        <option value="classify-item">Cấp bậc
                        </option>
                    </select>
                </div>

                <div class="form__item">
                    <label for="classify_name">Tên Ngành nghề :</label>
                    <input type="text" id="classify_name" name="classify_name" required><br>
                </div>





                <div class="form__bottom">
                    <button class="form__submit" type="submit">lưu</button>
                    <a href="javascript:void(0)" onclick="addCategoryForm()"  class="form__back">
                        <i class="fa-solid fa-arrow-left"></i>
                        Quay lại
                    </a>
                </div>

            </form>
        </div>
        <div id="editCategoryForm" style="display: none;">
            <h3 class = "form__title">Chỉnh sửa thông tin nhà tuyển dụng</h3>
            <form class="form__content" action="">
                <div class="form__item">

                    <label for="name">Phân loại </label>
                    <select name="classify" id="classify">

                        <option value="classify-item">Hình thức làm việc
                        </option>
                        <option value="classify-item">Ngành nghề
                        </option>
                        <option value="classify-item">Cấp bậc
                        </option>
                    </select>
                </div>

                <div class="form__item">
                    <label for="classify_name">Tên Ngành nghề :</label>
                    <input type="text" id="classify_name" name="classify_name" required><br>
                </div>





                <div class="form__bottom">
                    <button class="form__submit" type="submit">lưu</button>
                    <a href="javascript:void(0)" onclick="editCategoryForm()"  class="form__back">
                        <i class="fa-solid fa-arrow-left"></i>
                        Quay lại
                    </a>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>
