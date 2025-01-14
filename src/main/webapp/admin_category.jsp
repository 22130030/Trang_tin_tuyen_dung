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
    <link rel="stylesheet" href="asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/admin/admin_category.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">


    <title>AdminCategory</title>

</head>
<body>
<div class="admin">

    <header class="header">
        <nav class="nav">
            <div class="grid nav__container">
                <div class="nav__logo">
                    <a href="/html/admin/admin_home.html" class="nav__logo-link">
                        <img src="asserts/img/brand-logo@2x.png" alt="" class="nav-logo__img">
                    </a>
                </div>
                <ul class="nav__list">

                    <li class="nav__item ">
                        <div class="nav__item-link nav__admin nav__form-logged-in">
                            <div class="nav__admin-icon">
                                <i class="fa-regular fa-user"></i>
                            </div>
                            Admin

                            <div class="nav__form-admin">



                                <ul class="form-admin__list">
                                    <!-- <li class="form-admin__item">
                                        <a href="" class="form-admin__link">
                                            <i class="fa-solid fa-gear"></i>
                                            <span class="form-admin__link-title">Quản lí tài khoản</span>
                                        </a>
                                    </li> -->


                                    <li class="form-admin__item">
                                        <a href="/" class="form-admin__item-link">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <span class="form-admin__link-title">Đăng xuất</span>

                                        </a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <div class="container">

        <!-- Sidebar -->
        <div class="sidebar">
            <h3>Trang chủ admin</h3>
            <a class="sidebar--active" href="#">Thống kê và báo cáo</a>
            <a href="company-user-job">Quản lý nhà tuyển dụng</a>
            <a href="candidate-user-find">Quản lý ứng viên</a>
            <a href="job_manager">Quản lý bài đăng</a>
            <a href="manager-category">Quản lý ngành nghề</a>
            <a href="manager-user">Quản lý tài khoản</a>
        </div>
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
