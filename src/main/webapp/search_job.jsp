<%--
 Created by IntelliJ IDEA.
 User: Le Minh Cong
 Date: 12/20/2024
 Time: 9:46 AM
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
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/lastest_jobs.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
    <title>Kiếm việc làm online</title>
</head>
<body>
<div class="application">
    <!-- header -->
    <!-- navigation -->
    <%@include file="header.jsp"%>


    <div class="app__container">
        <div class="grid">
            <div class="grid__row">


                <div class="grid__col-9">
                    <h3 class="container_head">Tất cả việc làm ${title} </h3>
                    <div class="container__filter">
                           <span class="filter__total-jobs">${size}
                               <span>Việc làm</span>
                           </span>


                    </div>
                    <div class="latest__jobs-list">
                        <c:forEach var="j" items="${jobs}">


                            <div class="latest__jobs-item">
                                <div class="latest__job-thumb">
                                    <img src="${j.img}" alt="">
                                </div>
                                <div class="latest__jobs-content">
                                    <div  class="latest__job-link">


                                        <a href="job-detail?jid=${j.id}" class="lj__content-lable">${j.title}</a href="#">
                                        <a href="company-detail?jid=${j.companyId}" class="lj__content-company">${j.companyName}</a>
                                        <div class="lj__content-info">
                                            <span class="lj__content-address">${j.city}</span>
                                            <span>Ngày đăng :
                                                   <span class="lj__content-time">${j.convertCreated}</span>
                                               </span>
                                        </div>
                                        <div class="lj__content-detail">
                                            <span class="lj__content-salary">${j.salary}</span>
                                            <div class="lj__detail-save">
                                                <i class="fa-regular fa-heart"></i>
                                                <a>Lưu</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </c:forEach>
                    </div>
                </div>




                <div class="grid__col-3">
                    <%@include file="suggest.jsp"%>
                </div>
            </div>
        </div>
    </div>


    <!-- footer -->
    <%@include file="footer.jsp"%>
</div>

<
</body>
</html>

