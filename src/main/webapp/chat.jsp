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
    <link rel="stylesheet" href="asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
</head>
<body>
<%--<c:set var="currentUrl" value="${pageContext.request.requestURL}" />--%>
<c:choose>
<c:when test="${sessionScope.currentUrl eq '/home'}">

<div class="candidate">
    <%@include file="header.jsp"%>
    <div class="wrapper">
        <div class="sidebar">
            <h2>Cuộc trò chuyện</h2>
            <c:forEach items="${conversations}" var="c">

                <a href="javascript:void(0);" class="conversation" data-job-id="${c.jobPostId}"  data-conversation-id="${c.id}">
                    <div class="conversation__img">
                        <img src="asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                    </div>
                    <div class="conversation__content">

                        <div class="title">${c.companyName}</div>
                        <div class="preview">${c.jobTitle}</div>
                    </div>
                </a>
            </c:forEach>

        </div>

        <div class="chat" id="chat-candidate">
            <div class="chat-header">
                <div class="conversation__img">
                    <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                </div>
                <div class="conversation__content">
                    <h3 class="conversation__content-header">${conversation.companyName}</h3>
                    <small class="conversation__content-title"> ${conversation.jobTitle}</small>
                </div>
            </div>


            <div class="chat-body">
                <c:forEach items="${messages}" var="m">
                    <c:choose>

                        <c:when test="${sessionScope.userID != m.senderId}">

                            <div class="date-label">${m.sentDate}</div>
                            <div class="message-box received">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="" class="avatar">
                                <div class="message-container">
                                    <span class="message-date">${m.converSentDetail}</span>
                                    <p class="message-content">${m.message}</p>
                                </div>
                            </div>

                        </c:when>
                        <c:when test="${sessionScope.userID == m.senderId}">

                            <div class="date-label">${m.sentDate}</div>
                            <div class="message-box sent">
                                <div class="message-container">
                                    <span class="message-date message-date--sent">${m.converSentDetail}</span>
                                    <p class="message-content">${m.message}</p>
                                </div>
                                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" class="avatar" alt="Avatar">
                            </div>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>

            <div class="chat-footer">
                <input id="message-ip-${jobPostId}" type="text" placeholder="Nhập tin nhắn ...">
                <button onclick="sendMessage(${jobPostId})">Gửi</button>
            </div>
        </div>

        <!-- Info panel -->
        <div class="info-panel">
            <div class="info-panel__img">

                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="Logo">
            </div>
            <h4>${conversation.companyName}</h4>
            <p><strong>Vị trí công việc:</strong><br> <a href="#" style="color:#007bff;text-decoration:none;">
                ${conversation.jobTitle}</a></p>
            <p><strong>Ngày ứng tuyển:</strong><br>${conversation.convertAppDate}</p>
            <p><strong>Trạng thái:</strong><br> <span class="tag">${conversation.status}</span></p>
        </div>

    </div>
</div>
</c:when>
    <c:when test="${sessionScope.currentUrl eq '/employer-home'}">
<div class="employer">
    <%@include file="header_employer.jsp"%>
    <div class="wrapper">
        <div class="sidebar">
            <h2>Cuộc trò chuyện</h2>
            <c:forEach items="${conversations}" var="c">

                <a href="javascript:void(0);" class="conversation" data-job-id="${c.jobPostId}"  data-conversation-id="${c.id}">
                <div class="conversation__img">
                    <img src="asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                </div>
                <div class="conversation__content">

                    <div class="title">${c.candidateName}</div>
                    <div class="preview">${c.jobTitle}</div>
                </div>
            </a>
            </c:forEach>

        </div>

        <div class="chat" id="company-chat">
            <div class="chat-header">
                <div class="conversation__img">
                    <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="">
                </div>
                <div class="conversation__content">
                    <h3 class="conversation__content-header">${conversation.candidateName}</h3>
                    <small class="conversation__content-title">${conversation.jobTitle}</small>
                </div>
            </div>


            <div class="chat-body">
                <c:forEach items="${messages}" var="m">
                    <c:choose>

                        <c:when test="${sessionScope.companyUserId != m.senderId}">

                            <div class="date-label">${m.sentDate}</div>
                            <div class="message-box received">
                                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="" class="avatar">
                                <div class="message-container">
                                    <span class="message-date">${m.converSentDetail}</span>
                                    <p class="message-content">${m.message}</p>
                                </div>
                            </div>

                        </c:when>
                        <c:when test="${sessionScope.companyUserId == m.senderId}">

                            <div class="date-label">${m.sentDate}</div>
                            <div class="message-box sent">
                                <div class="message-container">
                                    <span class="message-date message-date--sent">${m.converSentDetail}</span>
                                    <p class="message-content">${m.message}</p>
                                </div>
                                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" class="avatar" alt="Avatar">
                            </div>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>

            <div class="chat-footer">
                <input id="message-ip-${jobPostId}" type="text" placeholder="Nhập tin nhắn ...">
                <button onclick="sendMessage(${jobPostId})">Gửi</button>
            </div>
        </div>

        <!-- Info panel -->
        <div class="info-panel">
            <div class="info-panel__img">

                <img src="/asserts/img/anh_logo_congty/cong_ty_nextdoor.png" alt="Logo">
            </div>
            <h4>${conversation.candidateName}</h4>
            <p><strong>Vị trí công việc:</strong><br> <a href="#" style="color:#007bff;text-decoration:none;">
                ${conversation.jobTitle}</a></p>
            <p><strong>Ngày ứng tuyển:</strong><br> ${conversation.convertAppDate}</p>
            <p><strong>Trạng thái:</strong><br> <span class="tag">${conversation.status}</span></p>
        </div>

    </div>
</div>
    </c:when>
</c:choose>

<%@include file="footer.jsp"%>
<script>
    const socket = new WebSocket("ws://" + location.host + "/trang_tin_tuyen_dung/chat-web-socket");

    socket.onopen = function () {
        console.log("WebSocket đã kết nối");
    };

    socket.onmessage = function(event) {
        const chatBody = document.querySelector(".chat-body");

        const now = new Date();
        const timeStr = now.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
        const messageText = event.data.split(": ").slice(1).join(": "); // Bỏ phần tiền tố id:

        const msgBox = document.createElement("div");
        msgBox.className = "message-box received";

        msgBox.innerHTML = `
            <img src="/asserts/img/anh_logo_cong_ty/cong_ty_nextdoor.png" alt="" class="avatar">
            <div class="message-container">
                <span class="message-date">`+timeStr+`</span>
                <p class="message-content">`+messageText+`</p>
            </div>
        `;

        chatBody.appendChild(msgBox);
        chatBody.scrollTop = chatBody.scrollHeight;
    };

    function sendMessage(jobPostId){
        const input = document.getElementById("message-ip-" + jobPostId);
        const content = input.value.trim();

        if (!content) return;

        if (socket.readyState === WebSocket.OPEN) {
            socket.send(JSON.stringify({content, jobPostId}));

            const chatBody = document.querySelector(".chat-body");

            const now = new Date();
            const timeStr = now.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });

            const msgBox = document.createElement("div");
            msgBox.className = "message-box sent";

            msgBox.innerHTML = `
            <div class="message-box sent">
                <div class="message-container">
                    <span class="message-date message-date--sent">`+timeStr+`</span>
                    <p class="message-content">`+content+`</p>
                </div>
                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" class="avatar" alt="Avatar">
            </div>`;

            chatBody.appendChild(msgBox);
            chatBody.scrollTop = chatBody.scrollHeight;

            input.value = "";
        } else {
            console.error("Socket chưa sẵn sàng:", socket.readyState);
            alert("Không thể gửi tin nhắn. Kết nối WebSocket đã đóng.");
        }
    }
    window.addEventListener("DOMContentLoaded", () => {
        const chatBody = document.querySelector(".chat-body");
        if (chatBody) {
            chatBody.scrollTop = chatBody.scrollHeight;
        }
    });
    document.querySelectorAll(".conversation").forEach(item => {
        item.addEventListener("click", function () {
            const jobPostId = this.dataset.jobId;
            const conversationId = this.dataset.conversationId;
            const isEmployer = "${sessionScope.role}" === '2';
            const userId = +("${sessionScope.role}" === '2' ? "${sessionScope.companyUserId}" : "${sessionScope.userID}");
            const chatSelector = isEmployer ? "#company-chat" : "#chat-candidate";
            const chatBody = document.querySelector(chatSelector + " .chat-body");

            chatBody.innerHTML = "";

            fetch(`get-message?jobPostId=`+jobPostId+`&conversationId=`+conversationId)
                .then(res => res.json())
                .then(data => {
                    const chatHeader = document.querySelector(".chat-header .conversation__content");
                    chatHeader.innerHTML =
                        "<h3 class='conversation__content-header'>" + (isEmployer ? data.candidateName : data.companyName) + "</h3>" +
                        "<small class='conversation__content-title'>" + data.jobTitle + "</small>"

                    // Cập nhật info-panel
                    document.querySelector(".info-panel h4").textContent = isEmployer ? data.candidateName : data.companyName;
                    document.querySelector(".info-panel p:nth-of-type(1) a").textContent = data.jobTitle;
                    document.querySelector(".info-panel p:nth-of-type(2)").innerHTML = "<strong>Ngày ứng tuyển:</strong><br>" + data.convertAppDate;
                    document.querySelector(".info-panel p:nth-of-type(3) .tag").textContent = data.status;

                    // Cập nhật input gửi tin nhắn
                    document.querySelector(".chat-footer").innerHTML = `
                        <input id="message-ip-`+jobPostId+`" type="text" placeholder="Nhập tin nhắn ..." />
                        <button onclick="sendMessage(`+jobPostId+`)">Gửi</button>
                    `;

                    // Cập nhật danh sách tin nhắn
                    const chatBody = document.querySelector(".chat-body");
                    chatBody.innerHTML = "";

                    data.messages.forEach(msg => {
                        const isSender = msg.senderId === userId;
                        const msgBox = document.createElement("div");
                        msgBox.className = "message-box " + (isSender ? "sent" : "received");
                        msgBox.innerHTML = isSender ? `
                            <div class="message-container">
                                <span class="message-date message-date--sent">`+msg.sentDate+`</span>
                                <p class="message-content">`+msg.message+`</p>
                            </div>
                            <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" class="avatar" alt="Avatar">
                        ` : `
                            <img src="/asserts/img/anh_logo_cong_ty/cong_ty_nextdoor.png" alt="" class="avatar">
                            <div class="message-container">
                                <span class="message-date">`+msg.sentDate+`</span>
                                <p class="message-content">`+msg.message+`</p>
                            </div>
                        `;
                        chatBody.appendChild(msgBox);
                    });

                    chatBody.scrollTop = chatBody.scrollHeight;
                });
        });
    });

</script>
</body>
</html>
