<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 4/12/2025
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hộp tin nhắn</title>
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/chat.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="wrapper">
    <div class="sidebar">
        <h2>Cuộc trò chuyện</h2>
        <div class="conversation">
            <div class="conversation__img">
                <img src="asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
            </div>
            <div class="conversation__content">

                <div class="title">Công Ty Truyền Tải Điện 4 (PTC4)</div>
                <div class="preview">This message had been removed</div>
            </div>
        </div>

    </div>

    <div class="chat">
        <div class="chat-header">
            <div class="conversation__img">
                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
            </div>
            <div class="conversation__content">
                <h3>Công Ty Truyền Tải Điện 4 (PTC4)</h3>
                <small>Nhân Viên Vận Hành Trạm Biến Áp 220kV-500kV</small>
            </div>
        </div>

        <div class="chat-body">
            <c:forEach items="${chatMessages}" var="cm">

            <div class="date-label">${cm.sent}</div>
            <div class="message-box received">
                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="" class="avatar">
                <div class="meassage-container">
                    <span class="message-date">${cm.sent}</span>
                    <p class="message-content">${cm.message}</p>
                </div>
            </div>

            </c:forEach>
<%--            <div class="date-label">chủ nhật , 06/04</div>--%>
<%--            <div class="message-box sent">--%>
<%--                <div class="meassage-container">--%>
<%--                    <span class="message-date message-date--sent">Đã gửi mail</span>--%>
<%--                    <p class="message-content">Đã gửi ma sssssssssssss il</p>--%>
<%--                </div>--%>
<%--                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" class="avatar" alt="Avatar">--%>
<%--            </div>--%>
        </div>

        <div class="chat-footer">
            <input id="message-ip" type="text" placeholder="Nhập tin nhắn ...">
            <button>Gửi</button>
        </div>
    </div>

    <!-- Info panel -->
    <div class="info-panel">
        <div class="info-panel__img">

            <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="Logo">
        </div>
        <h4>Công Ty Truyền Tải Điện 4 (PTC4)</h4>
        <p><strong>Vị trí công việc:</strong><br> <a href="#" style="color:#007bff;text-decoration:none;">Nhân Viên
            Vận Hành Trạm Biến Áp 220kV-500kV</a></p>
        <p><strong>Ngày ứng tuyển:</strong><br> 02/12/2024</p>
        <p><strong>Trạng thái:</strong><br> <span class="tag">Đã gửi email</span></p>
    </div>

</div>

<%@include file="footer.jsp"%>
<script>
    const socket = new WebSocket("ws://" + location.host + "/chat")

    socket.onmessage = function (event){

    }

    function sendMessage(){
        const content = document.getElementById('message-ip').value;
        socket.send(JSON.stringify(content));
    }
</script>
</body>
</html>
