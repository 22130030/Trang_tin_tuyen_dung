<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/27/2024
  Time: 11:26 PM
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
  <link rel="stylesheet" href="../asserts/css/candidate/job_applied.css">
  <link rel="stylesheet" href="../asserts/fonts/fontawesome-free-6.4.0-web/css/all.css">
  <link rel="stylesheet" href="../asserts/css/candidate/account_base.css">
  <title>Việc đã đã ứng tuyển</title>
</head>
<body>
<div class="application">
    <%@include file="../header.jsp"%>
    <%@include file="menu_account.jsp"%>

    <div class="container">
    <div class="grid__1100">

      <div class="job__applied">

        <div class="grid__row">
          <div class="grid__col-9">
            <h3 class="job-applied__head">Việc làm đã ứng tuyển(
              <span class="job__applied-toltal">${sessionScope.jobAppliedCart == null ? 0 : sessionScope.jobAppliedCart.size()}</span>
              )
            </h3>
            <span class="job-applied__saved-at">30 ngày qua</span>
            <div class="job__applied-list">
              <c:forEach items="${sessionScope.jobAppliedCart}" var="jac">

              <div class="job__applied-item">
                <div href="/html/job_description.html" class="job__applied-link">
                  <div class="job__applied-thumb">
                    <img src="${jac.img}" alt="">
                  </div>
                  <div class="job__applied-content">

                    <a href="/html/job_description.html" class="la__content-lable">${jac.title}</a>
                    <a href="/html/Job.html" class="la__content-company">${jac.companyName}</a>

                    <span class="la-content__applied-at">Ngày nộp :
                                                <span class="la__applied-date">
                                                    ${jac.convertCreated}
                                                </span>
                                            </span>
                    <div class="job__applied-status
                    <c:if test="${jac.status eq 'Đã xem'}">job__applied-status--viewed</c:if>
                     <c:if test="${jac.status eq 'Đã nộp'}">job__applied-status--sent</c:if>
">
                      <span>${jac.status}</span>
                    </div>
                </div>

              </div>
            </div>
              </c:forEach>
          </div>


        </div>



        <div class="grid__col-3">
          <%@include file="../suggest.jsp"%>
        </div>
      </div>
    </div>
  </div>
</div>
  <%@include file="../footer.jsp"%>
</div>
</body>
</html>
