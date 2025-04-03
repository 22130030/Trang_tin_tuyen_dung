<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 4/2/2025
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../asserts/css/base.css">
    <link rel="stylesheet" href="../asserts/css/candidate/resume_log.css">
    <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
    <title></title>
</head>
<body>
    <div class="application">
        <%@include file="../header.jsp"%>
        <%@include file="menu_account.jsp"%>
        <div class="container">
            <div class="grid__1100">

                <div class="resume_log">
                    <h2 class="resume_log-head">
                        Danh sách những nhà tuyển dụng đã xem hồ sơ :
                        <lable class="resume__log-title">
                            ${title}
                        </lable>
                    </h2>
                    <div class="resume_log-content">
                        <table>
                            <thead>
                            <th>Tên công ty</th>
                            <th>Thời gian xem</th>
                            <th>Trạng thái</th>

                            </thead>
                            <tbody>
                            <c:forEach items="${resumeLogs}" var="r">
                                <tr>
                                    <td class="log__content-company">${r.companyName}</td>
                                    <td>${r.convertViewedAt}</td>
                                    <td>Đã xem</td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
</body>
</html>
