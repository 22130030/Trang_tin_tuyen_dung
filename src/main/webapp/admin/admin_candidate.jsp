<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12/26/2024
  Time: 9:51 AM
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
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="../asserts/css/admin/candidate.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Admin</title>

</head>
<body>
<div class="admin">
    <%@include file="header_admin.jsp"%>

    <div class="container">

        <!-- Sidebar -->
        <%@include file="sidebar_admin.jsp"%>





        <!-- Table Section -->
        <div id="table-container">
            <h3>Quản lý ứng viên</h3>
            <div class="candidate__management">
                <form action="candidate-user-find"  method="post" class="candidate__search">
                    <input class="search__input" type="text" name="email" class="search__candidate" placeholder="Nhập tên,email,...">
                    <div class="search__status-filter">
                        <span>Trạng thái : </span>
                        <select name="status" id="" class="search__filter">
                            <option value="">Đang xử lí</option>
                            <option value="">Đã phỏng vấn</option>
                            <option value="">Đã trúng tuyển</option>
                            <option value="">Đã bị từ chối</option>
                        </select>
                    </div>
                    <button class="search__submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <span>Tìm kiếm</span>
                    </button>
                </form>

                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên ứng viên</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Công ty ứng tuyển</th>
                        <th>Ngày ứng tuyển</th>
                        <th>Trạng thái</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidateList}" var="cu">
                        <tr>
                        <td>${cu.candidateID}</td>
                        <td class="candidate__name">${cu.fullName}</td>
                        <td>${cu.email}</td>
                        <td>${cu.phone}</td>
                        <td class="candidate__company">${cu.appliedCompany}</td>
                        <td>${cu.applyDate}</td>
                        <td class = "candidate_status">${cu.status}</td>
                        <td>
                            <div class="operations">
                                <div class="operation operation__edit">
                                    <a href="load-user-candidate?cid=${cu.candidateID}" >
                                        <i class="fa-solid fa-pen"></i>
                                    </a>
                                </div>
                                <div class="operation operation__remove">
                                   <a href="delete-user-candidate?cid=${cu.candidateID}" class="delete">
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
    <div id="editCandidateForm">
        <h3 class = "form__title">Chỉnh sửa thông tin ứng viên</h3>
        <form class="form__content" action="" method="POST">
            <div class="form__item">
                <label for="candidate_name">Tên ứng viên :</label>
                <input type="text" id="candidate" name="candidate" required><br>
            </div>
            <div class="form__item">

                <label for="name">Email : </label>
                <input type="email" id="email" name="email" required placeholder="Email"><br>
            </div>
            <div class="form__item">
                <label for="phone">Số Điện Thoại:</label>
                <input type="text" id="phone" name="phone" required><br>
            </div>
            <div class="form__item">
                <label for="company">Công ty ứng tuyển :</label>
                <input type="text" id="company" name="company" required><br>
            </div>


            <div class="form__item">
                <label for="status">Trạng thái</label>
                <select class="status" name="status" id="status">
                    <option value="enable">duyệt</option>
                    <option value="disable">vô hiệu hóa</option>
                </select>
            </div>
            <div class="form__bottom">
                <button class="form__submit" type="submit">lưu</button>
                <a href="javascript:void(0)" onclick="editCandidateForm()"  class="form__back">
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