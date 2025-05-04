<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 12/12/2024
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<script src="${pageContext.request.contextPath}/js/account_lock.js"></script>
<div id="lockPopup">
    <div class="popup-content">
        <h3>Tài khoản của bạn đã bị khóa</h3>
        <p>Vui lòng liên hệ để được hỗ trợ:</p>
        <p><strong>📞 Số điện thoại:</strong> 02929388</p>
        <p><strong>🌐 Hỗ trợ trực tuyến:</strong>
            <a href="https://example.com/ho-tro" target="_blank">example.com/ho-tro</a>
        </p>
        <button onclick="redirectToLogin()">Đăng xuất</button>
    </div>
</div>
    <div class="footer">
    <div class="grid">
        <div class="grid__row">
            <div class="grid__col-4">
                <h3 class = "footer__heading">Dành cho ứng viên</h3>
                <ul class="footer__list">
                    <li class="footer__item">Việc làm mới nhất</li>
                    <li class="footer__item">Tất cả việc làm</li>
                    <li class="footer__item">Việc làm theo ngành nghề</li>
                </ul>
            </div>
            <div class="grid__col-4">
                <h3 class = "footer__heading">Dành cho nhà tuyển dụng</h3>
                <ul class="footer__list">
                    <li class="footer__item">Đăng tin tuyển dụng</li>
                    <li class="footer__item">Đăng ký nhà tuyển dụng</li>
                    <li class="footer__item">Tìm hồ sơ</li>
                </ul>
            </div>
            <div class="grid__col-4">
                <h3 class = "footer__heading">Designer Website</h3>
                <ul class="footer__list">
                    <li class="footer__item">Ngô Văn Đức</li>
                    <li class="footer__item">Lê Minh Công</li>
                    <li class="footer__item">Cao Minh Hiếu</li>
                </ul>
            </div>
        </div>
    </div>


</div>

</body>
</html>
