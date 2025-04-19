<%--
  Created by IntelliJ IDEA.
  User: PHUC
  Date: 1/11/2025
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home employer</title>
    <link rel="stylesheet" href="asserts/css/employer/employer_base.css">
    <link rel="stylesheet" href="asserts/css/base.css">
    <link rel="stylesheet" href="asserts/css/main_home_employer.css">
    <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
</head>
<body>
 <div class="application">
     <%@include file="header_employer.jsp"%>
     <div class="container">
         <!-- Header Section -->
         <h1>Nhà tuyển dụng</h1>
         <!-- Main Content Section -->
         <div class="main-content">
             <!-- Left Column -->
             <div class="left_column">
                 <img src="https://static.careerlink.vn/web/images/pages/employer/top/employer-banner.png" alt="Nhà tuyển dụng banner">
                 <div class="form">
                     <!-- Services Section -->
                     <div class="services">
                         <h2>Dịch vụ</h2>
                         <ul>
                             <li>
                                 <i class="fa-solid fa-briefcase"></i>
                                 Đăng tin tuyển dụng
                                 <P>Đăng việc làm của bạn lên trang web của chúng tôi để thu hút ứng viên tiềm năng</P>
                             </li>
                             <li>
                                 <i class="fa-solid fa-magnifying-glass"></i>
                                 Tìm kiếm hồ sơ ứng viên
                                 <p>Truy cập kho ứng viên chất lượng của CareerLink để tìm đúng nhân tài cho công ty bạn</p>
                             </li>
                             <li>
                                 <i class="fa-solid fa-user-tie"></i>
                                 Dịch vụ Nhân sự cao cấp
                                 <p>Executive Search - Giải pháp tối ưu cho nhân sự chủ chốt, nhân sự cấp cao và các vị trí đòi hỏi chuyên môn cao</p>
                             </li>

                         </ul>
                     </div>
                     <!-- Why Choose Section -->
                     <div class="services">
                         <h2>Tại sao chọn timviecDCH.vn?</h2>
                         <p>Là nhà cung cấp hàng đầu các dịch vụ tuyển dụng trực tuyến tại Việt Nam, CareerLink.vn có hơn 100,000 người tìm việc mỗi ngày. Đăng công việc trên CareerLink.vn là cách hiệu quả nhất để nhận hồ sơ phù hợp từ người tìm việc.</p>
                         <img src="https://static.careerlink.vn/web/images/pages/employer/top/toppage-capture.png" alt="CareerLink laptop">
                     </div>

                 </div>
                 <div class="recruitment-guide">
                     <h3>Cẩm nang tuyển dụng</h3>
                     <div class="guide-content">
                         <!-- Main Article -->
                         <div class="main-article">
                             <img src="https://cl-wpml.careerlink.vn/cam-nang-viec-lam/wp-content/uploads/2024/11/11144052/beauty-people-emotions-summer-leisure-vacation-concept-smiling-happy-asian-girl-straw-hat-showing-okay-gesture-recommend-perfect-hotel-tourist-resort-standing-pink-background-1.jpg" alt="Main article image">
                             <h4>Chiến thuật quảng bá bản thân giúp bạn "ghi điểm" khi phỏng vấn | Cẩm Nang Tuyển Dụng</h4>
                             <p>Quảng bá bản thân khi phỏng vấn là việc tạo ra một loạt các hành động, thái độ để lại ấn tượng tích cực lâu dài ngay từ khi bạn bước vào văn phòng.</p>
                         </div>
                         <!-- Side Articles -->
                         <div class="side-articles">
                             <div class="side-article">
                                 <img src="https://cl-wpml.careerlink.vn/cam-nang-viec-lam/wp-content/uploads/2024/11/04111733/lifestyle-people-young-brunette-woman-shows-peace-v-signs-smiles-stands-white-1.jpg" alt="Side article image">
                                 <h5>Làm gì để nhân viên ít hỏi lại và nâng cao tinh thần chủ động? | Cẩm Nang Tuyển Dụng</h5>
                                 <p>Bạn không có nhiều thời gian trả lời mọi thắc mắc của nhân viên và muốn nâng cao tinh thần...</p>
                             </div>
                             <div class="side-article">
                                 <img src="https://cl-wpml.careerlink.vn/cam-nang-viec-lam/wp-content/uploads/2024/10/28134915/positive-attractive-young-female-points-aside-with-cheerful-expression-shows-something-amazing-blank-space-isolated-white-backgroud-advertisement-concept-1.jpg" alt="Side article image">
                                 <h5>Khám phá cách đọc CV hiệu quả giúp tìm được ứng viên phù hợp | Cẩm Nang Tuyển Dụng</h5>
                                 <p>Ở vai trò nhà tuyển dụng, sàng lọc CV có thể là một nhiệm vụ khó khăn và tốn thời gian, đặc...</p>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>

             <div class="right_column">
                 <aside class="login-panel">
                     <h3>Nhà tuyển dụng đăng nhập</h3>
                     <form id="loginForm" action="employer-login" method="post" onsubmit="return validateForm()">
                         <input type="email" id="email" name="email" placeholder="email@example.com" >
                         <input type="password" id="password" name="password" placeholder="Mật khẩu" >

                         <% if (request.getAttribute("errorMessage") != null) { %>
                         <p id="error-message" style="color: red; font-size: 14px;">
                             <%= request.getAttribute("errorMessage") %>
                         </p>
                         <% } %>
                         <input type="checkbox" id="showPassword">
                         <label for="showPassword">Hiện mật khẩu</label>
                         <button type="submit">Đăng nhập</button>
                         <a href="login_reset_request.jsp?redirectUrl=employer_home">Quên mật khẩu?</a>
                         <a href="register_for_employer.jsp">Đăng kí</a>
                     </form>
                 </aside>

                 <div class="office-panel">
                     <h3>Văn phòng CareerLink</h3>

                     <!-- Ho Chi Minh Office -->
                     <div class="office-location">
                         <h4>Hồ Chí Minh</h4>
                         <div class="office-details">
                             <p><span class="icon"><i class="fa-solid fa-map-location-dot"></i></span>Phòng 302, 270-272 Cộng Hòa, P.13, Q.Tân Bình, TP. Hồ Chí Minh</p>
                             <p><span class="icon"><i class="fa-solid fa-phone"></i></span> <a href="tel:02838130501">028 3813 0501</a></p>
                             <p><span class="icon"><i class="fa-solid fa-envelope"></i></span> <a href="mailto:contact@careerlink.vn">contact@careerlink.vn</a></p>
                         </div>
                     </div>

                     <!-- Ha Noi Office -->
                     <div class="office-location">
                         <h4>Hà Nội</h4>
                         <div class="office-details">
                             <p><span class="icon"><i class="fa-solid fa-map-location-dot"></i></span> 307, DMC Tower, 535 Kim Mã, Ba Đình, Hà Nội</p>
                             <p><span class="icon"><i class="fa-solid fa-phone"></i></span> <a href="tel:02435190410">024 3519 0410</a></p>
                             <p><span class="icon"><i class="fa-solid fa-envelope"></i></span> <a href="mailto:contact@careerlink.vn">contact@careerlink.vn</a></p>
                         </div>
                     </div>

                     <!-- Da Nang Office -->
                     <div class="office-location">
                         <h4>Đà Nẵng</h4>
                         <div class="office-details">
                             <p><span class="icon"><i class="fa-solid fa-map-location-dot"></i></span> Tầng 8, 218 Bạch Đằng, Phước Ninh, Q.Hải Châu, Đà Nẵng</p>
                             <p><span class="icon"><i class="fa-solid fa-phone"></i></span> <a href="tel:02363221767">0236 3221 767</a></p>
                             <p><span class="icon"><i class="fa-solid fa-envelope"></i></span> <a href="mailto:contact@careerlink.vn">contact@careerlink.vn</a></p>
                         </div>
                     </div>
                 </div>
             </div>

         </div>
     </div>
     <%@include file="footer.jsp"%>
 </div>
</body>

<script>
    document.getElementById("showPassword").addEventListener("change", function () {
        var passwordField = document.getElementById("password");
        passwordField.style.height = "40px"; // Đảm bảo chiều cao không thay đổi
        passwordField.style.width = "100%"; // Giữ nguyên chiều rộng
        passwordField.style.border = "1px solid #ccc";
        passwordField.style.borderRadius = "5px";
        passwordField.style.padding = "10px";
        passwordField.type = this.checked ? "text" : "password";
    });

    function validateForm() {
        var email = document.getElementById("email").value.trim();
        var password = document.getElementById("password").value.trim();
        var errorMessage = document.getElementById("error-message");

        if (email === "" && password === "") {
            errorMessage.textContent = "Vui lòng điền thông tin.";
            return false;
        }
        if (email === "") {
            errorMessage.textContent = "Vui lòng điền tên tài khoản.";
            return false;
        }
        if (password === "") {
            errorMessage.textContent = "Vui lòng nhập mật khẩu.";
            return false;
        }
        return  true;
    }
</script>


</html>
