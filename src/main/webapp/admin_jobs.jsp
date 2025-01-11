<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 1/12/2025
  Time: 12:24 AM
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
    <link rel="stylesheet" href="asserts/css/admin/admin__base.css">;
    <link rel="stylesheet" href="asserts/css/admin/admin_jobs.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Admin</title>

    <script>
        function addJobForm() {
            var jobForm = document.getElementById("addJobsForm");
            var jobTable = document.getElementById("content__section");

            if (jobTable.style.display === 'block' || jobTable.style.display === '') {
                jobTable.style.display = 'none';
            } else {
                jobTable.style.display = 'block';
            }
            if (jobForm.style.display === 'none' || jobForm.style.display === '') {
                jobForm.style.display = 'block';
            } else {
                jobForm.style.display = 'none';
            }
        }
        document.addEventListener('DOMContentLoaded', function () {
            const navUser = document.querySelector('.nav__admin');
            const dropdownMenu = document.querySelector('.nav__form-admin');

            // Hiển thị menu khi click vào `.nav__has--form-login`
            navUser.addEventListener('click', function (event) {
                event.stopPropagation();
                dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
            });

            // Đóng menu khi click ra ngoài
            document.addEventListener('click', function (event) {
                if (!navUser.contains(event.target) && !dropdownMenu.contains(event.target)) {
                    dropdownMenu.style.display = 'none';
                }
            });
        });
    </script>

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
            <a href="/html/admin/admin_home.html">Thống kê và báo cáo</a>
            <a href="/html/admin/admin_employer.html">Quản lý nhà tuyển dụng</a>
            <a href="/html/admin/candidate.html">Quản lý ứng viên</a>
            <a class="sidebar--active" href="#">Quản lý bài đăng</a>
            <a href="/html/admin/admin_category.html">Quản lý ngành nghề</a>
            <a href="/html/admin/user.html">Quản lý tài khoản</a>
        </div>
        <div class="content" id="content__section">
            <h3>Quản lý bài đăng</h3>
            <div class="jobs_management">
                <div class="jobs__search">
                    <input class="search__input" type="text" name="name" class="search__candidate"
                           placeholder="Nhập tiêu đề,công ty,...">
                    <div class="search__status-filter">

                        <span>Trạng thái : </span>
                        <select name="" id="" class="search__filter">
                            <option value="">Đã duyệt</option>
                            <option value="">Chưa duyệt</option>
                            <option value="">Đã từ chối</option>
                        </select>
                    </div>
                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </div>
                <div class="jobs__add">

                    <h4 class="job__add-list">Danh sách bài đăng :
                        <a href="javascript:void(0)" onclick="addJobForm()" class="list__add-link">thêm mới</a>
                    </h4>
                </div>
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Hình ảnh</th>
                    <th>Tiêu đề</th>
                    <th>Tên công ty</th>
                    <th>Địa chỉ</th>
                    <th>Lương</th>
                    <th>Thời gian đăng</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>

                    </thead>
                    <tbody>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>

                        <td>1</td>
                        <td class="job__column-img">
                            <div class="job__column-item">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                            </div>
                        </td>
                        <td>Nhân viên phiên dịch tiếng Hàn</td>
                        <td>Công ty TNHH D&O CM VietNam</td>
                        <td>Hải Phòng</td>
                        <td>2 triệu</td>
                        <td>1/11/2024</td>
                        <td>Đã duyệt</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <i class="fa-solid fa-pen"></i>
                                </div>
                                <div class="operation operation__remove">
                                    <i class="fa-solid fa-trash"></i>
                                </div>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

            </div>
        </div>
        <div id="addJobsForm">
            <h3 class="form__title">Thêm bài đăng</h3>
            <form class="form__content" action="">
                <div class="form__item">

                    <label for="name">Tiêu đề bài đăng : </label>
                    <input type="text" id="text" name="text" required><br>
                </div>
                <div class="form__item">

                    <label for="name">Thêm hình ảnh : </label>
                    <input class="upload__img" type="file" id="image" name="image" accept="image/*" required>
                </div>
                <div class="form__item">
                    <label for="company_name">Tên công ty :</label>
                    <input type="text" id="company" name="company" required><br>
                </div>
                <div class="form__item">
                    <label for="address">Thành phố :</label>
                    <input class="address__input" type="text" id="address" name="address" required><br>
                </div>
                <div class="form__item">
                    <label for="number">Mức lương :</label>
                    <input type="number" id="number" name="number" required><br>
                </div>



                <button class="form__submit" type="submit">Thêm bài đăng</button>

            </form>
        </div>



    </div>
</div>
</body>

</html>
