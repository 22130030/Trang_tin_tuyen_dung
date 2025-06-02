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
    <style>
        :root {
            --primary-color: #0084ff;
            --primary-hover: #0066cc;
            --secondary-color: #00c851;
            --background: #f5f7fa;
            --card-bg: #ffffff;
            --text-primary: #1a1a1a;
            --text-secondary: #666666;
            --border-color: #e4e6ea;
            --shadow: 0 4px 20px rgba(0,0,0,0.1);
            --shadow-hover: 0 8px 30px rgba(0,0,0,0.15);
            --gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            --border-radius: 16px;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', sans-serif;
            background: var(--background);
            color: var(--text-primary);
            line-height: 1.6;
            overflow-x: hidden;
        }

        .background-pattern {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background:
                    radial-gradient(circle at 20% 80%, rgba(120, 119, 198, 0.3) 0%, transparent 50%),
                    radial-gradient(circle at 80% 20%, rgba(255, 119, 198, 0.3) 0%, transparent 50%),
                    radial-gradient(circle at 40% 40%, rgba(120, 219, 255, 0.2) 0%, transparent 50%);
            z-index: -1;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            position: relative;
        }

        .header-animation {
            text-align: center;
            margin-bottom: 40px;
            animation: fadeInDown 1s ease-out;
        }

        .profile-card {
            background: var(--card-bg);
            border-radius: var(--border-radius);
            box-shadow: var(--shadow);
            padding: 40px;
            margin-bottom: 30px;
            display: grid;
            grid-template-columns: 1fr auto;
            gap: 40px;
            align-items: start;
            position: relative;
            overflow: hidden;
            transition: all 0.3s ease;
            animation: fadeInUp 1s ease-out;
        }

        .profile-card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: var(--gradient);
        }

        .profile-card:hover {
            box-shadow: var(--shadow-hover);
            transform: translateY(-2px);
        }

        .profile-header {
            display: flex;
            gap: 25px;
            align-items: flex-start;
            margin-bottom: 30px;
        }

        .profile-avatar {
            width: 100px;
            height: 100px;
            border-radius: var(--border-radius);
            overflow: hidden;
            position: relative;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }

        .profile-avatar:hover {
            transform: scale(1.05);
        }

        .profile-avatar img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .profile-info h1 {
            font-size: 28px;
            font-weight: 800;
            color: var(--text-primary);
            margin-bottom: 8px;
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .verified-badge {
            width: 24px;
            height: 24px;
            background: var(--secondary-color);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 14px;
            animation: pulse 2s infinite;
        }

        .profile-subtitle {
            color: var(--text-secondary);
            font-size: 18px;
            margin-bottom: 25px;
            font-weight: 500;
        }

        .action-buttons {
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
        }

        .message-btn, .secondary-btn {
            padding: 14px 28px;
            border-radius: 50px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            transition: all 0.3s ease;
            border: none;
            position: relative;
            overflow: hidden;
        }

        .message-btn {
            background: var(--gradient);
            color: white;
        }

        .message-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(0,132,255,0.3);
        }

        .secondary-btn {
            background: transparent;
            color: var(--primary-color);
            border: 2px solid var(--primary-color);
        }

        .secondary-btn:hover {
            background: var(--primary-color);
            color: white;
        }

        .profile-details {
            margin-top: 30px;
        }

        .details-title {
            font-size: 20px;
            font-weight: 700;
            color: var(--text-primary);
            margin-bottom: 25px;
            position: relative;
            padding-left: 15px;
        }

        .details-title::before {
            content: '';
            position: absolute;
            left: 0;
            top: 50%;
            transform: translateY(-50%);
            width: 4px;
            height: 20px;
            background: var(--gradient);
            border-radius: 2px;
        }

        .detail-item {
            display: flex;
            align-items: flex-start;
            gap: 20px;
            margin-bottom: 20px;
            padding: 15px;
            border-radius: 12px;
            transition: all 0.3s ease;
        }

        .detail-item:hover {
            background: rgba(0,132,255,0.05);
            transform: translateX(5px);
        }

        .detail-icon {
            width: 24px;
            height: 24px;
            flex-shrink: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 18px;
            color: var(--primary-color);
        }

        .detail-text {
            flex: 1;
            font-size: 16px;
            color: var(--text-primary);
        }

        .detail-text a {
            color: var(--primary-color);
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .detail-text a:hover {
            color: var(--primary-hover);
            text-decoration: underline;
        }

        .status-active {
            color: var(--secondary-color);
            font-weight: 600;
            position: relative;
        }

        .status-active::before {
            content: '';
            position: absolute;
            left: -10px;
            top: 50%;
            transform: translateY(-50%);
            width: 6px;
            height: 6px;
            background: var(--secondary-color);
            border-radius: 50%;
            animation: blink 1.5s infinite;
        }

        .qr-container {
            background: var(--card-bg);
            padding: 30px;
            border-radius: var(--border-radius);
            border: 2px solid var(--border-color);
            text-align: center;
            position: relative;
            overflow: hidden;
            transition: all 0.3s ease;
        }

        .qr-container::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: conic-gradient(from 0deg, transparent, rgba(0,132,255,0.1), transparent);
            animation: rotate 4s linear infinite;
            z-index: 1;
        }

        .qr-content {
            position: relative;
            z-index: 2;
        }

        .qr-code {
            width: 200px;
            height: 200px;
            border: 3px solid var(--border-color);
            border-radius: 12px;
            margin: 0 auto 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            background: white;
            transition: transform 0.3s ease;
            cursor: pointer;
        }

        .qr-code:hover {
            transform: scale(1.05);
            border-color: var(--primary-color);
        }

        .qr-code img {
            width: 90%;
            height: 90%;
            object-fit: contain;
            border-radius: 8px;
        }

        .qr-description {
            font-size: 14px;
            color: var(--text-secondary);
            line-height: 1.5;
        }

        .services-card {
            background: var(--card-bg);
            border-radius: var(--border-radius);
            box-shadow: var(--shadow);
            padding: 40px;
            animation: fadeInUp 1s ease-out 0.2s both;
        }

        .services-title {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 30px;
            text-align: center;
            position: relative;
        }

        .services-title::after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 60px;
            height: 3px;
            background: var(--gradient);
            border-radius: 2px;
        }

        .services-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 25px;
            margin-top: 30px;
        }

        .service-item {
            text-align: center;
            padding: 30px 20px;
            border: 2px solid var(--border-color);
            border-radius: var(--border-radius);
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
            background: var(--card-bg);
        }

        .service-item::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(0,132,255,0.1), transparent);
            transition: left 0.5s ease;
        }

        .service-item:hover::before {
            left: 100%;
        }

        .service-item:hover {
            border-color: var(--primary-color);
            box-shadow: 0 8px 25px rgba(0,132,255,0.15);
            transform: translateY(-5px);
        }

        .service-icon {
            width: 70px;
            height: 70px;
            background: var(--gradient);
            border-radius: 50%;
            margin: 0 auto 20px;
            font-size: 24px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            transition: transform 0.3s ease;
        }

        .service-item:hover .service-icon {
            transform: rotateY(360deg);
        }

        .service-name {
            font-size: 18px;
            font-weight: 600;
            color: var(--text-primary);
            margin-bottom: 10px;
        }

        .service-description {
            font-size: 14px;
            color: var(--text-secondary);
            line-height: 1.4;
        }

        .additional-info {
            background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
            padding: 25px;
            border-radius: 12px;
            margin-top: 30px;
            text-align: center;
            color: var(--text-secondary);
            font-size: 15px;
            border: 1px solid var(--border-color);
        }

        .stats-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
            gap: 20px;
            margin: 30px 0;
        }

        .stat-item {
            text-align: center;
            padding: 20px;
            background: rgba(0,132,255,0.05);
            border-radius: 12px;
            border: 1px solid rgba(0,132,255,0.1);
        }

        .stat-number {
            font-size: 24px;
            font-weight: 800;
            color: var(--primary-color);
            display: block;
        }

        .stat-label {
            font-size: 12px;
            color: var(--text-secondary);
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .notification {
            position: fixed;
            top: 20px;
            right: 20px;
            background: var(--card-bg);
            border: 1px solid var(--border-color);
            border-radius: 12px;
            padding: 15px 20px;
            box-shadow: var(--shadow);
            transform: translateX(100%);
            transition: transform 0.3s ease;
            z-index: 1000;
        }

        .notification.show {
            transform: translateX(0);
        }

        .notification.success {
            border-left: 4px solid var(--secondary-color);
        }

        .notification.info {
            border-left: 4px solid var(--primary-color);
        }

        /* Animations */
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.1); }
        }

        @keyframes blink {
            0%, 100% { opacity: 1; }
            50% { opacity: 0.3; }
        }

        @keyframes rotate {
            from { transform: rotate(0deg); }
            to { transform: rotate(360deg); }
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .container {
                padding: 15px;
            }

            .profile-card {
                grid-template-columns: 1fr;
                gap: 30px;
                padding: 30px 20px;
            }

            .profile-header {
                flex-direction: column;
                text-align: center;
                gap: 20px;
            }

            .profile-info h1 {
                font-size: 24px;
                justify-content: center;
            }

            .action-buttons {
                justify-content: center;
            }

            .services-grid {
                grid-template-columns: 1fr;
                gap: 20px;
            }

            .qr-container {
                order: -1;
            }
        }

        /* Dark mode support */
        @media (prefers-color-scheme: dark) {
            :root {
                --background: #1a1a1a;
                --card-bg: #2d2d2d;
                --text-primary: #ffffff;
                --text-secondary: #b0b0b0;
                --border-color: #404040;
            }
        }
    </style>
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

<script>
    // Enhanced JavaScript functionality
    const showNotification = (message, type = 'info') => {
        const notification = document.getElementById('notification');
        const notificationText = document.getElementById('notificationText');

        notificationText.textContent = message;
        notification.className = `notification ${type} show`;

        setTimeout(() => {
            notification.classList.remove('show');
        }, 3000);
    };

    // Message button functionality
    document.getElementById('messageBtn').addEventListener('click', function(e) {
        e.preventDefault();
        showNotification('Đang mở cuộc trò chuyện với ${companyName}...', 'info');

        // Simulate opening chat after delay
        setTimeout(() => {
            window.open('http://zaloapp.com/qr/p/in0vyfbibpbs', '_blank');
        }, 1000);
    });

    // Follow button functionality
    document.getElementById('followBtn').addEventListener('click', function() {
        const icon = this.querySelector('i');
        const text = this.querySelector('span') || this;

        if (icon.classList.contains('fas')) {
            icon.classList.remove('fas');
            icon.classList.add('far');
            showNotification('Đã bỏ theo dõi ${companyName}', 'info');
        } else {
            icon.classList.remove('far');
            icon.classList.add('fas');
            showNotification('Đã theo dõi ${companyName}', 'success');
        }
    });

    // QR Code functionality
    document.getElementById('qrCode').addEventListener('click', function() {
        showNotification('Quét mã QR bằng ứng dụng Zalo để kết nối', 'info');

        // Add visual feedback
        this.style.transform = 'scale(0.95)';
        setTimeout(() => {
            this.style.transform = 'scale(1)';
        }, 150);
    });

    // Service items functionality
    document.querySelectorAll('.service-item').forEach(item => {
        item.addEventListener('click', function() {
            const service = this.dataset.service;
            const serviceName = this.querySelector('.service-name').textContent;

            switch(service) {
                case 'contact':
                    showNotification(`Đang mở chức năng ${serviceName}...`, 'info');
                    setTimeout(() => {
                        alert('Liên hệ: ${phone} hoặc email: contact@lienketvnc.com');
                    }, 1000);
                    break;
                case 'website':
                    showNotification('Đang chuyển đến trang web...', 'info');
                    setTimeout(() => {
                        window.open('${website}', '_blank');
                    }, 1000);
                    break;
                case 'register':
                    showNotification('Đang chuyển đến trang đăng ký...', 'info');
                    setTimeout(() => {
                        window.open('${website}/register', '_blank');
                    }, 1000);
                    break;
                case 'search':
                    showNotification('Đang mở trang tìm kiếm việc làm...', 'info');
                    setTimeout(() => {
                        window.open('${website}/jobs', '_blank');
                    }, 1000);
                    break;
            }
        });
    });

    // Add smooth scrolling for internal links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // Add loading states for external links
    document.querySelectorAll('a[target="_blank"]').forEach(link => {
        link.addEventListener('click', function() {
            showNotification('Đang mở liên kết...', 'info');
        });
    });

    // Intersection Observer for animations
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
            }
        });
    }, observerOptions);

    // Observe all service items for scroll animations
    document.querySelectorAll('.service-item').forEach(item => {
        item.style.opacity = '0';
        item.style.transform = 'translateY(20px)';
        item.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
        observer.observe(item);
    });

    // Add typing effect for company name (optional)
    const companyNameElement = document.querySelector('.profile-info h1');
    if (companyNameElement) {
        const originalText = companyNameElement.textContent;
        // Keep the verification badge
        const badge = companyNameElement.querySelector('.verified-badge');
        companyNameElement.innerHTML = '';
        if (badge) companyNameElement.appendChild(badge);

        // Typing effect can be added here if desired
    }
</script>
</body>
</html>