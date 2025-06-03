<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 6/2/2025
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/admin/admin__base.css">
    <link rel="stylesheet" href="../asserts/css/admin/log_work.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Lịch sử hoạt động</title>
</head>
<body>
<div class="admin">
    <%@include file="header_admin.jsp"%>

    <div class="container">

        <!-- Sidebar -->
        <%@include file="sidebar_admin.jsp"%>





        <!-- Table Section -->
        <div id="table-container">
            <h3>Lịch sử hoạt động</h3>
            <div class="logWork__management">
<%--                <form action="candidate-user-find"  method="post" class="candidate__search">--%>
<%--                    <input class="search__input" type="text" name="email" class="search__candidate" placeholder="Nhập tên,email,...">--%>
<%--                    <div class="search__status-filter">--%>
<%--                        <span>Trạng thái : </span>--%>
<%--                        <select name="status" id="" class="search__filter">--%>
<%--                            <option value="">Đang xử lí</option>--%>
<%--                            <option value="">Đã phỏng vấn</option>--%>
<%--                            <option value="">Đã trúng tuyển</option>--%>
<%--                            <option value="">Đã bị từ chối</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <button class="search__submit">--%>
<%--                        <i class="fa-solid fa-magnifying-glass"></i>--%>
<%--                        <span>Tìm kiếm</span>--%>
<%--                    </button>--%>
<%--                </form>--%>

                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>userId</th>
                        <th>action</th>
                        <th>dữ liệu cũ</th>
                        <th>dữ liệu mới</th>
                        <th>Ngày thay đổi</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="lw" items="${logWorks}">

                        <tr>

                            <td>${lw.id}</td>
                            <td>${lw.userId}</td>
                            <td>${lw.action}</td>
                            <td class="logWork__data">${lw.oldData}</td>
                            <td class="logWork__data">${lw.newData}</td>
                            <td>${lw.convertChange}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
