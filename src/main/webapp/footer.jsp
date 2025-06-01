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
