<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liên kết nghề nghiệp - Zalo</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
</head>
<body>
<%
    // Enhanced sample data
    request.setAttribute("companyName", "Liên kết nghề nghiệp");
    request.setAttribute("companyDescription", "Tuyển dụng & Việc làm chuyên nghiệp");
    request.setAttribute("isVerified", true);
    request.setAttribute("address", "270 - 272 Đường Cộng Hòa, Quận Tân Bình, Hồ Chí Minh");
    request.setAttribute("phone", "02838130501");
    request.setAttribute("website", "http://localhost:8080/trang_tin_tuyen_dung/");
    request.setAttribute("status", "Hoạt động 24/24");
    request.setAttribute("avatarUrl", "https://s120-ava-talk.zadn.vn/4/3/f/8/2/120/c1f0fd3dff802843f07dbf405e32efc0.jpg");
    request.setAttribute("totalJobs", "1,250");
    request.setAttribute("activeUsers", "15,000+");
    request.setAttribute("companiesConnected", "850");
%>

<div class="background-pattern"></div>

<div class="container">
    <!-- Profile Card -->
    <div class="profile-card">
        <div class="profile-left">
            <div class="profile-header">
                <div class="profile-avatar">
                    <img src="${avatarUrl}" alt="Avatar">
                </div>
                <div class="profile-info">
                    <h1>
                        ${companyName}
                        <c:if test="${isVerified}">
                            <span class="verified-badge">
                                <i class="fas fa-check"></i>
                            </span>
                        </c:if>
                    </h1>
                    <div class="profile-subtitle">${companyDescription}</div>
                    <div class="action-buttons">
                        <a href="#" class="message-btn" id="messageBtn">
                            <i class="fas fa-comment"></i>
                            Nhắn tin
                        </a>
                        <button class="secondary-btn" id="followBtn">
                            <i class="fas fa-heart"></i>
                            Theo dõi
                        </button>
                    </div>
                </div>
            </div>

            <!-- Stats Section -->
            <div class="stats-container">
                <div class="stat-item">
                    <span class="stat-number">${totalJobs}</span>
                    <span class="stat-label">Việc làm</span>
                </div>
                <div class="stat-item">
                    <span class="stat-number">${activeUsers}</span>
                    <span class="stat-label">Người dùng</span>
                </div>
                <div class="stat-item">
                    <span class="stat-number">${companiesConnected}</span>
                    <span class="stat-label">Doanh nghiệp</span>
                </div>
            </div>

            <div class="profile-details">
                <h3 class="details-title">Thông tin chi tiết</h3>

                <div class="detail-item">
                    <div class="detail-icon">
                        <i class="fas fa-map-marker-alt"></i>
                    </div>
                    <div class="detail-text">${address}</div>
                </div>

                <div class="detail-item">
                    <div class="detail-icon">
                        <i class="fas fa-phone"></i>
                    </div>
                    <div class="detail-text">
                        <a href="tel:${phone}">${phone}</a>
                    </div>
                </div>

                <div class="detail-item">
                    <div class="detail-icon">
                        <i class="fas fa-clock"></i>
                    </div>
                    <div class="detail-text status-active">${status}</div>
                </div>

                <div class="detail-item">
                    <div class="detail-icon">
                        <i class="fas fa-globe"></i>
                    </div>
                    <div class="detail-text">
                        <a href="${website}" target="_blank">${website}</a>
                    </div>
                </div>
            </div>

            <div class="additional-info">
                <i class="fas fa-info-circle"></i>
                Nền tảng tuyển dụng được tin tùng hàng đầu Việt Nam
            </div>
        </div>

        <div class="profile-right">
            <div class="qr-container">
                <div class="qr-content">
                    <div class="qr-code" id="qrCode">
                        <img src="./asserts/img/zalo.jpg" alt="QR Code">
                    </div>
                    <p class="qr-description">
                        <i class="fas fa-qrcode"></i><br>
                        Mở Zalo, ấn quét QR để kết nối<br>
                        và xem trên điện thoại
                    </p>
                </div>
            </div>
        </div>
    </div>

    <!-- Services Section -->
    <div class="services-card">
        <h2 class="services-title">
            <i class="fas fa-cogs"></i>
            Dịch vụ cung cấp
        </h2>
        <div class="services-grid">
            <div class="service-item" data-service="contact">
                <div class="service-icon">
                    <i class="fas fa-envelope"></i>
                </div>
                <div class="service-name">Liên hệ tư vấn</div>
                <div class="service-description">Hỗ trợ tư vấn tuyển dụng 24/7</div>
            </div>
            <div class="service-item" data-service="website">
                <div class="service-icon">
                    <i class="fas fa-laptop"></i>
                </div>
                <div class="service-name">Trang web</div>
                <div class="service-description">Truy cập portal tuyển dụng</div>
            </div>
            <div class="service-item" data-service="register">
                <div class="service-icon">
                    <i class="fas fa-user-plus"></i>
                </div>
                <div class="service-name">Đăng ký tuyển dụng</div>
                <div class="service-description">Đăng tin tuyển dụng miễn phí</div>
            </div>
            <div class="service-item" data-service="search">
                <div class="service-icon">
                    <i class="fas fa-search"></i>
                </div>
                <div class="service-name">Tìm kiếm việc làm</div>
                <div class="service-description">Khám phá cơ hội nghề nghiệp</div>
            </div>
        </div>
    </div>
</div>

<!-- Notification -->
<div class="notification" id="notification">
    <span id="notificationText">Thông báo</span>
</div>


</body>
</html>