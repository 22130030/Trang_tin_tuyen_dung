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
    <style>
        .zalo-chat-mini {
            position: fixed;
            bottom: 20px;
            right: 20px;
            width: 60px;
            height: 60px;
            background-color: #fff;
            border-radius: 50%;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
            display: flex;
            align-items: center;
            justify-content: center;
            z-index: 9999;
            cursor: pointer;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }


        .zalo-chat-mini:hover {
            transform: scale(1.1);
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.3);
        }


        .zalo-chat-mini img {
            width: 32px;
            height: 32px;
        }
    </style>

</head>
<body>

<script src="<%= request.getContextPath() %>/js/account_lock.js"></script>
<script>
    const CONTEXT_PATH = "${pageContext.request.contextPath}";
    console.log(CONTEXT_PATH)
</script>
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
        <!-- Nút mini chat Zalo -->
        <a href="http://localhost:8080/trang_tin_tuyen_dung/chatbotZalo.jsp"
           class="zalo-chat-mini"
           target="_blank"
           aria-label="Chat với tôi qua Zalo">
            <img src="./asserts/img/zalo.png" alt="Zalo Icon">
        </a>
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
