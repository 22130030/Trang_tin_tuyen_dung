<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 4/2/2025
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>regist for employer</title>
  <link rel="stylesheet" href="asserts/css/employer/employer_base.css">
  <link rel="stylesheet" href="asserts/css/base.css">
  <link rel="stylesheet" href="asserts/css/main_register_for_employer.css">
  <link rel="stylesheet" href="asserts/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
</head>

<body>
<!-- header -->
<div class="nav-sticky">
  <div class="header">
    <div class="application">
      <%@include file="header_employer.jsp"%>
<!-- container -->
<div class="register-container">
  <div class="register-box">
    <h2>Nhà tuyển dụng đăng ký</h2>
    <p>Tạo tài khoản để tiếp cận kho ứng viên chất lượng và bắt đầu đăng việc ngay</p>
    <form action="register-employer" method="post" onsubmit="return validateForm()">
      <input type="email"
             class="form-control ${emailError != null ? 'is-invalid' : ''}"
             placeholder="xxx@gmail.com" name="email" id="email" value="${param.email}" required>
      <c:if test="${emailError != null}">
        <small style="color: red; display: block; margin-top: 4px;" >${emailError}</small>
      </c:if>
      <small>Sử dụng email công việc để xác thực nhanh hơn</small>
      <input type="password" name="password" id="password" placeholder="Mật khẩu" required>
      <div style="position: relative;">
        <div id="criteria-box" style="font-size: 14px; margin-top: 10px; border: 1px solid #ccc; padding: 10px; border-radius: 6px; background-color: black; width: 300px; display: none; position: absolute; right: 105%; top: 0; z-index: 1000;">
          <p id="check-length">• Mật khẩu phải có độ dài từ 8 đến 50 ký tự</p>
          <p id="check-lower">• Ít nhất một chữ thường (a-z)</p>
          <p id="check-upper">• Ít nhất một chữ hoa (A-Z)</p>
          <p id="check-digit">• Ít nhất một số (0-9)</p>
          <p id="check-special">• Ít nhất một ký tự đặc biệt (!@#$)</p>
          <p id="check-repeated">• Không được chứa quá 10 ký tự trùng nhau liên tiếp</p>
          <p id="check-email">• Không được chứa phần tên email</p>
        </div>
      </div>
      <input type="password" name="re-password" id="re-password" placeholder="Nhập lại mật khẩu" required>
      <small id="pw-error" style="color: red; display: block; margin-top: 4px;"></small>
      <label>
        <input type="checkbox" onclick="togglePasswordVisibility()"> Hiển thị mật khẩu
      </label>

      <h3>Thông tin công ty</h3>
      <input type="text" name="fName" placeholder="Tên công ty" required>
      <select required>
        <option value="" disabled selected>Số nhân viên</option>
        <option value="1-50">1-50</option>
        <option value="51-200">51-200</option>
        <option value="201-500">201-500</option>
        <option value="500+">500+</option>
      </select>
      <input type="text" placeholder="Người liên hệ" required>
      <input type="tel" name="phone" placeholder="Điện thoại" required>
      <h4>Địa chỉ</h4>
      <div class='form-group'>
        <div class='input-group location-select' required data-select='location' >
          <!-- Quốc gia -->
          <select class="custom-select" required data-select-target="country" name="country">
            <option value="2">Albania</option>
            <option value="3">Algeria</option>
            <option value="4">American Samoa</option>
            <option value="5">Andorra</option>
            <option value="6">Angola</option>
            <option value="7">Anguilla</option>
            <option value="8">Antarctica</option>
            <option value="9">Antigua and Barbuda</option>
            <option value="10">Argentina</option>
            <option value="11">Armenia</option>
            <option value="12">Aruba</option>
            <option value="13">Australia</option>
            <option value="14">Austria</option>
            <option value="15">Azerbaijan</option>
            <option value="16">Bahamas</option>
            <option value="17">Bahrain</option>
            <option value="18">Bangladesh</option>
            <option value="19">Barbados</option>
            <option value="20">Belarus</option>
            <option value="21">Belgium</option>
            <option value="22">Belize</option>
            <option value="23">Benin</option>
            <option value="24">Bermuda</option>
            <option value="25">Bhutan</option>
            <option value="26">Bolivia</option>
            <option value="27">Bosnia and Herzegowina</option>
            <option value="28">Botswana</option>
            <option value="29">Bouvet Island</option>
            <option value="30">Brazil</option>
            <option value="31">British Indian Ocean Territory</option>
            <option value="32">Brunei Darussalam</option>
            <option value="33">Bulgaria</option>
            <option value="34">Burkina Faso</option>
            <option value="35">Burundi</option>
            <option value="36">Cambodia</option>
            <option value="37">Cameroon</option>
            <option value="38">Canada</option>
            <option value="39">Cape Verde</option>
            <option value="40">Cayman Islands</option>
            <option value="41">Central African Republic</option>
            <option value="42">Chad</option>
            <option value="43">Chile</option>
            <option value="44">China</option>
            <option value="45">Christmas Island</option>
            <option value="46">Cocos (Keeling) Islands</option>
            <option value="47">Colombia</option>
            <option value="48">Comoros</option>
            <option value="49">Congo</option>
            <option value="50">Cook Islands</option>
            <option value="51">Costa Rica</option>
            <option value="52">Cote D&#39;Ivoire</option>
            <option value="53">Croatia</option>
            <option value="54">Cuba</option>
            <option value="55">Cyprus</option>
            <option value="56">Czech Republic</option>
            <option value="57">Denmark</option>
            <option value="58">Djibouti</option>
            <option value="59">Dominica</option>
            <option value="60">Dominican Republic</option>
            <option value="61">East Timor</option>
            <option value="62">Ecuador</option>
            <option value="63">Egypt</option>
            <option value="64">El Salvador</option>
            <option value="65">Equatorial Guinea</option>
            <option value="66">Eritrea</option>
            <option value="67">Estonia</option>
            <option value="68">Ethiopia</option>
            <option value="69">Falkland Islands (Malvinas)</option>
            <option value="70">Faroe Islands</option>
            <option value="71">Fiji</option>
            <option value="72">Finland</option>
            <option value="73">France</option>
            <option value="74">France, Metropolitan</option>
            <option value="75">French Guiana</option>
            <option value="76">French Polynesia</option>
            <option value="77">French Southern Territories</option>
            <option value="78">Gabon</option>
            <option value="79">Gambia</option>
            <option value="80">Georgia</option>
            <option value="81">Germany</option>
            <option value="82">Ghana</option>
            <option value="83">Gibraltar</option>
            <option value="84">Greece</option>
            <option value="85">Greenland</option>
            <option value="86">Grenada</option>
            <option value="87">Guadeloupe</option>
            <option value="88">Guam</option>
            <option value="89">Guatemala</option>
            <option value="90">Guinea</option>
            <option value="91">Guinea-bissau</option>
            <option value="92">Guyana</option>
            <option value="93">Haiti</option>
            <option value="94">Heard and Mc Donald Islands</option>
            <option value="95">Honduras</option>
            <option value="96">Hong Kong</option>
            <option value="97">Hungary</option>
            <option value="98">Iceland</option>
            <option value="99">India</option>
            <option value="100">Indonesia</option>
            <option value="101">Iran (Islamic Republic of)</option>
            <option value="102">Iraq</option>
            <option value="103">Ireland</option>
            <option value="104">Israel</option>
            <option value="105">Italy</option>
            <option value="106">Jamaica</option>
            <option value="107">Japan</option>
            <option value="108">Jordan</option>
            <option value="109">Kazakhstan</option>
            <option value="110">Kenya</option>
            <option value="111">Kiribati</option>
            <option value="112">Korea, Democratic People&#39;s Republic of</option>
            <option value="113">Korea, Republic of</option>
            <option value="114">Kuwait</option>
            <option value="115">Kyrgyzstan</option>
            <option value="116">Laos</option>
            <option value="117">Latvia</option>
            <option value="118">Lebanon</option>
            <option value="119">Lesotho</option>
            <option value="120">Liberia</option>
            <option value="121">Libyan Arab Jamahiriya</option>
            <option value="122">Liechtenstein</option>
            <option value="123">Lithuania</option>
            <option value="124">Luxembourg</option>
            <option value="125">Macau</option>
            <option value="126">Macedonia, The Former Yugoslav Republic of</option>
            <option value="127">Madagascar</option>
            <option value="128">Malawi</option>
            <option value="129">Malaysia</option>
            <option value="130">Maldives</option>
            <option value="131">Mali</option>
            <option value="132">Malta</option>
            <option value="133">Marshall Islands</option>
            <option value="134">Martinique</option>
            <option value="135">Mauritania</option>
            <option value="136">Mauritius</option>
            <option value="137">Mayotte</option>
            <option value="138">Mexico</option>
            <option value="139">Micronesia, Federated States of</option>
            <option value="140">Moldova, Republic of</option>
            <option value="141">Monaco</option>
            <option value="142">Mongolia</option>
            <option value="143">Montserrat</option>
            <option value="144">Morocco</option>
            <option value="145">Mozambique</option>
            <option value="146">Myanmar</option>
            <option value="147">Namibia</option>
            <option value="148">Nauru</option>
            <option value="149">Nepal</option>
            <option value="150">Netherlands</option>
            <option value="151">Netherlands Antilles</option>
            <option value="152">New Caledonia</option>
            <option value="153">New Zealand</option>
            <option value="154">Nicaragua</option>
            <option value="155">Niger</option>
            <option value="156">Nigeria</option>
            <option value="157">Niue</option>
            <option value="158">Norfolk Island</option>
            <option value="159">Northern Mariana Islands</option>
            <option value="160">Norway</option>
            <option value="161">Oman</option>
            <option value="162">Pakistan</option>
            <option value="163">Palau</option>
            <option value="164">Panama</option>
            <option value="165">Papua New Guinea</option>
            <option value="166">Paraguay</option>
            <option value="167">Peru</option>
            <option value="168">Philippines</option>
            <option value="169">Pitcairn</option>
            <option value="170">Poland</option>
            <option value="171">Portugal</option>
            <option value="172">Puerto Rico</option>
            <option value="173">Qatar</option>
            <option value="174">Reunion</option>
            <option value="175">Romania</option>
            <option value="176">Russian Federation</option>
            <option value="177">Rwanda</option>
            <option value="178">Saint Kitts and Nevis</option>
            <option value="179">Saint Lucia</option>
            <option value="180">Saint Vincent and the Grenadines</option>
            <option value="181">Samoa</option>
            <option value="182">San Marino</option>
            <option value="183">Sao Tome and Principe</option>
            <option value="184">Saudi Arabia</option>
            <option value="185">Senegal</option>
            <option value="186">Seychelles</option>
            <option value="187">Sierra Leone</option>
            <option value="188">Singapore</option>
            <option value="189">Slovakia (Slovak Republic)</option>
            <option value="190">Slovenia</option>
            <option value="191">Solomon Islands</option>
            <option value="192">Somalia</option>
            <option value="193">South Africa</option>
            <option value="194">South Georgia and the South Sandwich Islands</option>
            <option value="195">Spain</option>
            <option value="196">Sri Lanka</option>
            <option value="197">St. Helena</option>
            <option value="198">St. Pierre and Miquelon</option>
            <option value="199">Sudan</option>
            <option value="200">Suriname</option>
            <option value="201">Svalbard and Jan Mayen Islands</option>
            <option value="202">Swaziland</option>
            <option value="203">Sweden</option>
            <option value="204">Switzerland</option>
            <option value="205">Syrian Arab Republic</option>
            <option value="206">Taiwan</option>
            <option value="207">Tajikistan</option>
            <option value="208">Tanzania, United Republic of</option>
            <option value="209">Thailand</option>
            <option value="210">Togo</option>
            <option value="211">Tokelau</option>
            <option value="212">Tonga</option>
            <option value="213">Trinidad and Tobago</option>
            <option value="214">Tunisia</option>
            <option value="215">Turkey</option>
            <option value="216">Turkmenistan</option>
            <option value="217">Turks and Caicos Islands</option>
            <option value="218">Tuvalu</option>
            <option value="219">Uganda</option>
            <option value="220">Ukraine</option>
            <option value="221">United Arab Emirates</option>
            <option value="222">United Kingdom</option>
            <option value="223">United States</option>
            <option value="224">United States Minor Outlying Islands</option>
            <option value="225">Uruguay</option>
            <option value="226">Uzbekistan</option>
            <option value="227">Vanuatu</option>
            <option value="228">Vatican City State (Holy See)</option>
            <option value="229">Venezuela</option>
            <option selected="selected" value="230">Viet Nam</option>
            <option value="231">Virgin Islands (British)</option>
            <option value="232">Virgin Islands (U.S.)</option>
            <option value="233">Wallis and Futuna Islands</option>
            <option value="234">Western Sahara</option>
            <option value="235">Yemen</option>
            <option value="236">Yugoslavia</option>
            <option value="237">Zaire</option>
            <option value="238">Zambia</option>
            <option value="239">Zimbabwe</option>
          </select>
          <!-- Các quốc gia khác... -->
          </select>

          <!-- Tỉnh/Thành phố -->
          <select class="custom-select province-select" required data-select-target="province"
                  name="province">
            <option value="" disabled selected>Chọn tỉnh / thành phố</option>
            <option value="23">Hồ Chí Minh</option>
            <option value="27">Hà Nội</option>
            <option value="17">Đà Nẵng</option>
            <option value="1">An Giang</option>
            <option value="9">Bà Rịa - Vũng Tàu</option>
            <option value="5">Bắc Cạn</option>
            <option value="4">Bắc Giang</option>
            <option value="6">Bạc Liêu</option>
            <option value="7">Bắc Ninh</option>
            <option value="11">Bến Tre</option>
            <option value="3">Bình Định</option>
            <option value="2">Bình Dương</option>
            <option value="8">Bình Phước</option>
            <option value="10">Bình Thuận</option>
            <option value="13">Cà Mau</option>
            <option value="14">Cần Thơ</option>
            <option value="12">Cao Bằng</option>
            <option value="16">Đắk Lắk</option>
            <option value="18">Đăk Nông</option>
            <option value="15">Điện Biên</option>
            <option value="19">Đồng Nai</option>
            <option value="20">Đồng Tháp</option>
            <option value="21">Gia Lai</option>
            <option value="25">Hà Giang</option>
            <option value="28">Hà Nam</option>
            <option value="31">Hà Tĩnh</option>
            <option value="24">Hải Dương</option>
            <option value="29">Hải Phòng</option>
            <option value="26">Hậu Giang</option>
            <option value="22">Hòa Bình</option>
            <option value="32">Hưng Yên</option>
            <option value="33">Kiên Giang</option>
            <option value="34">Khánh Hòa</option>
            <option value="35">Kon Tum</option>
            <option value="65">Lai Châu</option>
            <option value="38">Lâm Đồng</option>
            <option value="39">Lạng Sơn</option>
            <option value="66">Lào Cai</option>
            <option value="36">Long An</option>
            <option value="42">Nam Định</option>
            <option value="40">Nghệ An</option>
            <option value="41">Ninh Bình</option>
            <option value="43">Ninh Thuận</option>
            <option value="44">Phú Thọ</option>
            <option value="45">Phú Yên</option>
            <option value="46">Quảng Bình</option>
            <option value="47">Quảng Nam</option>
            <option value="49">Quảng Ngãi</option>
            <option value="48">Quảng Ninh</option>
            <option value="50">Quảng Trị</option>
            <option value="52">Sóc Trăng</option>
            <option value="51">Sơn La</option>
            <option value="56">Tây Ninh</option>
            <option value="53">Thái Bình</option>
            <option value="57">Thái Nguyên</option>
            <option value="55">Thanh Hóa</option>
            <option value="74">Thành Phố Huế</option>
            <option value="54">Tiền Giang</option>
            <option value="75">Trà Vinh</option>
            <option value="73">Tuyên Quang</option>
            <option value="76">Vĩnh Long</option>
            <option value="77">Vĩnh Phúc</option>
            <option value="78">Yên Bái</option>
            <option value="79">Khác</option>
          </select>

          <!-- Quận/Huyện -->
          <select class="custom-select district-select" required data-select-target="district"
                  name="district">
            <option value="" disabled selected>Chọn quận / huyện</option>
          </select>

          <!-- Địa chỉ chi tiết -->
          <input type="text" class="form-control" placeholder="Số nhà, phường, xã" required name="address_detail">
        </div>
      </div>

      <label>
        <input type="checkbox"> Nhận bản tin việc làm
      </label>

      <button type="submit">Đăng ký ngay</button>

      <p class="policy-text">
        Tôi đồng ý với việc xử lý và cung cấp thông tin dữ liệu cá nhân, đồng thời đã đọc và đồng ý với
        <a href="#">Thoả thuận sử dụng</a> và <a href="#">Quy định bảo mật</a> của CareerLink.
      </p>
    </form>
  </div>
</div>
<!-- footer -->
<  <%@include file="footer.jsp"%>
</div>
    <script>
  function validatePasswordCriteria(password, email) {
    const criteria = {
      length: /^.{8,50}$/,
      lowercase: /[a-z]/,
      uppercase: /[A-Z]/,
      number: /[0-9]/,
      specialChar: /[!@#$]/,
      repeatedChar: /(.)\1{10,}/,
      emailPortion: new RegExp(email.split('@')[0], 'i')
    };

    const result = {
      length: criteria.length.test(password),
      lowercase: criteria.lowercase.test(password),
      uppercase: criteria.uppercase.test(password),
      number: criteria.number.test(password),
      specialChar: criteria.specialChar.test(password),
      repeatedChar: !criteria.repeatedChar.test(password),
      emailPortion: !criteria.emailPortion.test(password)
    };

    return result;
  }

  function validateForm() {
    const email = document.getElementById("email").value.trim();
    const pw = document.getElementById("password").value.trim();
    const repw = document.getElementById("re-password").value.trim();
    const criteriaBox = document.getElementById("criteria-box");
    const error = document.getElementById("pw-error") || document.createElement("small");

    if (!document.getElementById("pw-error")) {
      error.id = "pw-error";
      error.style.color = "red";
      error.style.display = "block";
      error.style.marginTop = "4px";
      document.querySelector('input[name="re-password"]').insertAdjacentElement("afterend", error);
    }

    if (pw === "" || repw === "") {
      error.textContent = "Vui lòng nhập mật khẩu và xác nhận.";
      return false;
    }

    const check = validatePasswordCriteria(pw, email);
    document.getElementById("check-length").style.color = check.length ? "green" : "red";
    document.getElementById("check-lower").style.color = check.lowercase ? "green" : "red";
    document.getElementById("check-upper").style.color = check.uppercase ? "green" : "red";
    document.getElementById("check-digit").style.color = check.number ? "green" : "red";
    document.getElementById("check-special").style.color = check.specialChar ? "green" : "red";
    document.getElementById("check-repeated").style.color = check.repeatedChar ? "green" : "red";
    document.getElementById("check-email").style.color = check.emailPortion ? "green" : "red";

    if (Object.values(check).includes(false)) {
      error.textContent = "Mật khẩu không đáp ứng đủ điều kiện.";
      return false;
    }

    if (pw !== repw) {
      error.textContent = "Mật khẩu không khớp.";
      return false;
    }

    error.textContent = "";
    return true;
  }

  function togglePasswordVisibility() {
    const pw1 = document.getElementsByName("password")[0];
    const pw2 = document.getElementsByName("re-password")[0];
    const type = pw1.type === "password" ? "text" : "password";
    pw1.type = type;
    pw2.type = type;
  }

  document.addEventListener("DOMContentLoaded", function () {
    const passwordInput = document.getElementById("password");
    const criteriaBox = document.getElementById("criteria-box");

    passwordInput.addEventListener("focus", function () {
      criteriaBox.style.display = "block";
    });

    passwordInput.addEventListener("blur", function () {
      setTimeout(() => {
        criteriaBox.style.display = "none";
      }, 200);
    });
  });

  document.addEventListener('DOMContentLoaded', function () {
    const navUser = document.querySelector('.nav__employer-user');
    const dropdownMenu = document.querySelector('.nav__employer-form');

    // Hiển thị menu khi click vào `.nav__has--form-login`
    navUser.addEventListener('click', function (event) {
      event.stopPropagation();
      dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
    });

    // Đóng menu khi click ra ngoài
    document.addEventListener('click', function (event) {
      if (!navUser.contains(event.target) && !dropdownMenu.contains(event.target)) {
        dropdownMenu.style.display = 'none';
      }
    });
  });
</script>
<script>
  // Dữ liệu tỉnh/huyện (bạn có thể thay thế bằng dữ liệu thực tế)
  const districts = {
    "23": ["Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Thạnh", "Quận Bình Tân", "Quận Gò Vấp", "Quận Phú Nhuận", "Quận Tân Bình", "Quận Tân Phú", "Thành phố Thủ Đức", "Huyện Bình Chánh", "Huyện Cần Giờ", "Huyện Củ Chi", "Huyện Hóc Môn", "Huyện Nhà Bè"], // Hồ Chí Minh
    "27": ["Quận Ba Đình", "Quận Hoàn Kiếm", "Quận Đống Đa", "Quận Hai Bà Trưng", "Quận Tây Hồ", "Quận Thanh Xuân", "Quận Cầu Giấy", "Quận Long Biên", "Quận Hoàng Mai", "Quận Hà Đông", "Quận Bắc Từ Liêm", "Quận Nam Từ Liêm", "Huyện Thanh Trì", "Huyện Gia Lâm", "Huyện Đông Anh", "Huyện Sóc Sơn", "Quận Hà Đông", "Thị xã Sơn Tây", "Huyện Ba Vì", "Huyện Chương Mỹ", "Huyện Đan Phượng", "Huyện Hoài Đức", "Huyện Mỹ Đức", "Huyện Phú Xuyên", "Huyện Phúc Thọ", "Huyện Quốc Oai", "Huyện Thạch Thất", "Huyện Thanh Oai", "Huyện Thường Tín", "Huyện Ứng Hòa"], // Hà Nội
    "17": ["Quận Cẩm Lệ", "Quận Hải Châu", "Quận Liên Chiểu", "Quận Ngũ Hành Sơn", "Quận Sơn Trà", "Quận Thanh Khê", "Huyện Hòa Vang", "Huyện Hoàng Sa"], // Đà Nẵng
    "1": ["Thành phố Long Xuyên", "Thành phố Châu Đốc", "Thị xã Tân Châu", "Huyện An Phú", "Huyện Châu Phú", "Huyện Châu Thành", "Huyện Chợ Mới", "Huyện Phú Tân", "Huyện Thoại Sơn", "Huyện Tịnh Biên", "Huyện Tri Tôn"], // An Giang
    "9": ["Thành phố Vũng Tàu", "Thành phố Bà Rịa", "Thị xã Phú Mỹ", "Huyện Châu Đức", "Huyện Côn Đảo", "Huyện Đất Đỏ", "Huyện Long Điền", "Huyện Xuyên Mộc"], // Bà Rịa - Vũng Tàu
    "5": ["Thành phố Bắc Kạn", "Huyện Ba Bể", "Huyện Bạch Thông", "Huyện Chợ Đồn", "Huyện Chợ Mới", "Huyện Na Rì", "Huyện Ngân Sơn", "Huyện Pác Nặm"], // Bắc Kạn
    "4": ["Thành phố Bắc Giang", "Huyện Hiệp Hòa", "Huyện Lạng Giang", "Huyện Lục Nam", "Huyện Lục Ngạn", "Huyện Sơn Động", "Huyện Tân Yên", "Huyện Việt Yên", "Huyện Yên Dũng", "Huyện Yên Thế"], // Bắc Giang
    "6": ["Thành phố Bạc Liêu", "Thị xã Giá Rai", "Huyện Đông Hải", "Huyện Hòa Bình", "Huyện Hồng Dân", "Huyện Phước Long", "Huyện Vĩnh Lợi"], // Bạc Liêu
    "7": ["Thành phố Bắc Ninh", "Thị xã Từ Sơn", "Huyện Gia Bình", "Huyện Lương Tài", "Huyện Quế Võ", "Huyện Thuận Thành", "Huyện Tiên Du", "Huyện Yên Phong"], // Bắc Ninh
    "11": ["Thành phố Bến Tre", "Huyện Ba Tri", "Huyện Bình Đại", "Huyện Châu Thành", "Huyện Chợ Lách", "Huyện Giồng Trôm", "Huyện Mỏ Cày Bắc", "Huyện Mỏ Cày Nam", "Huyện Thạnh Phú"], // Bến Tre
    "3": ["Thành phố Quy Nhơn", "Thị xã An Nhơn", "Thị xã Hoài Nhơn", "Huyện An Lão", "Huyện Hoài Ân", "Huyện Phù Cát", "Huyện Phù Mỹ", "Huyện Tây Sơn", "Huyện Tuy Phước", "Huyện Vân Canh", "Huyện Vĩnh Thạnh"], // Bình Định
    "2": ["Thành phố Thủ Dầu Một", "Thành phố Dĩ An", "Thành phố Thuận An", "Thành phố Tân Uyên", "Thị xã Bến Cát", "Huyện Bắc Tân Uyên", "Huyện Bàu Bàng", "Huyện Dầu Tiếng", "Huyện Phú Giáo"], // Bình Dương
    "8": ["Thành phố Đồng Xoài", "Thị xã Bình Long", "Thị xã Phước Long", "Huyện Bù Đăng", "Huyện Bù Đốp", "Huyện Bù Gia Mập", "Huyện Chơn Thành", "Huyện Đồng Phú", "Huyện Hớn Quản", "Huyện Lộc Ninh", "Huyện Phú Riềng"], // Bình Phước
    "10": ["Thành phố Phan Thiết", "Thị xã La Gi", "Huyện Bắc Bình", "Huyện Đức Linh", "Huyện Hàm Tân", "Huyện Hàm Thuận Bắc", "Huyện Hàm Thuận Nam", "Huyện Phú Quý", "Huyện Tánh Linh", "Huyện Tuy Phong"], // Bình Thuận
    "13": ["Thành phố Cà Mau", "Huyện Cái Nước", "Huyện Đầm Dơi", "Huyện Năm Căn", "Huyện Ngọc Hiển", "Huyện Phú Tân", "Huyện Thới Bình", "Huyện Trần Văn Thời", "Huyện U Minh"], // Cà Mau
    "14": ["Quận Bình Thủy", "Quận Cái Răng", "Quận Ninh Kiều", "Quận Ô Môn", "Quận Thốt Nốt", "Huyện Cờ Đỏ", "Huyện Phong Điền", "Huyện Thới Lai", "Huyện Vĩnh Thạnh"], // Cần Thơ
    "12": ["Thành phố Cao Bằng", "Huyện Bảo Lạc", "Huyện Bảo Lâm", "Huyện Hạ Lang", "Huyện Hà Quảng", "Huyện Hòa An", "Huyện Nguyên Bình", "Huyện Phục Hòa", "Huyện Quảng Hòa", "Huyện Thạch An", "Huyện Thông Nông", "Huyện Trà Lĩnh", "Huyện Trùng Khánh"], // Cao Bằng
    "16": ["Thành phố Buôn Ma Thuột", "Thị xã Buôn Hồ", "Huyện Buôn Đôn", "Huyện Cư Kuin", "Huyện Cư M'gar", "Huyện Ea H'leo", "Huyện Ea Kar", "Huyện Ea Súp", "Huyện Krông Ana", "Huyện Krông Bông", "Huyện Krông Buk", "Huyện Krông Năng", "Huyện Krông Pắc", "Huyện Lắk", "Huyện M'Drắk"], // Đắk Lắk
    "18": ["Thành phố Gia Nghĩa", "Huyện Cư Jút", "Huyện Đắk Glong", "Huyện Đắk Mil", "Huyện Đắk R'lấp", "Huyện Đắk Song", "Huyện Krông Nô", "Huyện Tuy Đức"], // Đắk Nông
    "15": ["Thành phố Điện Biên Phủ", "Thị xã Mường Lay", "Huyện Điện Biên", "Huyện Điện Biên Đông", "Huyện Mường Ảng", "Huyện Mường Chà", "Huyện Mường Nhé", "Huyện Nậm Pồ", "Huyện Tủa Chùa", "Huyện Tuần Giáo"], // Điện Biên
    "19": ["Thành phố Biên Hòa", "Thành phố Long Khánh", "Huyện Cẩm Mỹ", "Huyện Định Quán", "Huyện Long Thành", "Huyện Nhơn Trạch", "Huyện Tân Phú", "Huyện Thống Nhất", "Huyện Trảng Bom", "Huyện Vĩnh Cửu", "Huyện Xuân Lộc"], // Đồng Nai
    "20": ["Thành phố Cao Lãnh", "Thành phố Sa Đéc", "Thành phố Hồng Ngự", "Huyện Cao Lãnh", "Huyện Châu Thành", "Huyện Hồng Ngự", "Huyện Lai Vung", "Huyện Lấp Vò", "Huyện Tam Nông", "Huyện Tân Hồng", "Huyện Thanh Bình", "Huyện Tháp Mười"], // Đồng Tháp
    "21": ["Thành phố Pleiku", "Thị xã An Khê", "Thị xã Ayun Pa", "Huyện Chư Păh", "Huyện Chư Prông", "Huyện Chư Sê", "Huyện Đắk Đoa", "Huyện Đắk Pơ", "Huyện Đức Cơ", "Huyện Ia Grai", "Huyện Ia Pa", "Huyện K'Bang", "Huyện Kông Chro", "Huyện Krông Pa", "Huyện Mang Yang", "Huyện Phú Thiện"], // Gia Lai
    "25": ["Thành phố Hà Giang", "Huyện Bắc Mê", "Huyện Bắc Quang", "Huyện Đồng Văn", "Huyện Hoàng Su Phì", "Huyện Mèo Vạc", "Huyện Quản Bạ", "Huyện Quang Bình", "Huyện Vị Xuyên", "Huyện Xín Mần", "Huyện Yên Minh"],
    "28": ["Thành phố Phủ Lý", "Huyện Bình Lục", "Huyện Duy Tiên", "Huyện Kim Bảng", "Huyện Lý Nhân", "Huyện Thanh Liêm"],
    "31": ["Thành phố Hà Tĩnh", "Thị xã Hồng Lĩnh", "Thị xã Kỳ Anh", "Huyện Cẩm Xuyên", "Huyện Can Lộc", "Huyện Đức Thọ", "Huyện Hương Khê", "Huyện Hương Sơn", "Huyện Lộc Hà", "Huyện Nghi Xuân", "Huyện Thạch Hà", "Huyện Vũ Quang"],
    "24": ["Thành phố Hải Dương", "Thị xã Chí Linh", "Huyện Bình Giang", "Huyện Cẩm Giàng", "Huyện Gia Lộc", "Huyện Kim Thành", "Huyện Kinh Môn", "Huyện Nam Sách", "Huyện Ninh Giang", "Huyện Thanh Hà", "Huyện Thanh Miện", "Huyện Tứ Kỳ"],
    "29": ["Quận Hồng Bàng", "Quận Lê Chân", "Quận Ngô Quyền", "Quận Hải An", "Quận Kiến An", "Quận Đồ Sơn", "Quận Dương Kinh", "Huyện An Dương", "Huyện An Lão", "Huyện Bạch Long Vĩ", "Huyện Cát Hải", "Huyện Kiến Thụy", "Huyện Thủy Nguyên", "Huyện Tiên Lãng", "Huyện Vĩnh Bảo"],
    "26": ["Thành phố Vị Thanh", "Thị xã Ngã Bảy", "Huyện Châu Thành", "Huyện Châu Thành A", "Huyện Long Mỹ", "Huyện Phụng Hiệp", "Huyện Vị Thủy"],
    "22": ["Thành phố Hòa Bình", "Huyện Cao Phong", "Huyện Đà Bắc", "Huyện Kim Bôi", "Huyện Kỳ Sơn", "Huyện Lạc Sơn", "Huyện Lạc Thủy", "Huyện Lương Sơn", "Huyện Mai Châu", "Huyện Tân Lạc", "Huyện Yên Thủy"],
    "32": ["Thành phố Hưng Yên", "Huyện Ân Thi", "Huyện Khoái Châu", "Huyện Kim Động", "Huyện Mỹ Hào", "Huyện Phù Cừ", "Huyện Tiên Lữ", "Huyện Văn Giang", "Huyện Văn Lâm", "Huyện Yên Mỹ"],
    "33": ["Thành phố Rạch Giá", "Thị xã Hà Tiên", "Huyện An Biên", "Huyện An Minh", "Huyện Châu Thành", "Huyện Giang Thành", "Huyện Giồng Riềng", "Huyện Gò Quao", "Huyện Hòn Đất", "Huyện Kiên Hải", "Huyện Kiên Lương", "Huyện Phú Quốc", "Huyện Tân Hiệp", "Huyện U Minh Thượng", "Huyện Vĩnh Thuận"],
    "34": ["Thành phố Nha Trang", "Thành phố Cam Ranh", "Thị xã Ninh Hòa", "Huyện Cam Lâm", "Huyện Diên Khánh", "Huyện Khánh Sơn", "Huyện Khánh Vĩnh", "Huyện Trường Sa", "Huyện Vạn Ninh"],
    "35": ["Thành phố Kon Tum", "Huyện Đắk Glei", "Huyện Đắk Hà", "Huyện Đắk Tô", "Huyện Ia H’Drai", "Huyện Kon Plông", "Huyện Kon Rẫy", "Huyện Ngọc Hồi", "Huyện Sa Thầy", "Huyện Tu Mơ Rông"],
    "65": ["Thành phố Lai Châu", "Huyện Mường Tè", "Huyện Nậm Nhùn", "Huyện Phong Thổ", "Huyện Sìn Hồ", "Huyện Tam Đường", "Huyện Tân Uyên", "Huyện Than Uyên"],
    "38": ["Thành phố Đà Lạt", "Thành phố Bảo Lộc", "Huyện Bảo Lâm", "Huyện Cát Tiên", "Huyện Đạ Huoai", "Huyện Đạ Tẻh", "Huyện Đam Rông", "Huyện Di Linh", "Huyện Đơn Dương", "Huyện Đức Trọng", "Huyện Lạc Dương", "Huyện Lâm Hà"],
    "39": ["Thành phố Lạng Sơn", "Huyện Bắc Sơn", "Huyện Bình Gia", "Huyện Cao Lộc", "Huyện Chi Lăng", "Huyện Đình Lập", "Huyện Hữu Lũng", "Huyện Lộc Bình", "Huyện Tràng Định", "Huyện Văn Lãng", "Huyện Văn Quan"],
    "66": ["Thành phố Lào Cai", "Huyện Bảo Thắng", "Huyện Bảo Yên", "Huyện Bắc Hà", "Huyện Bát Xát", "Huyện Mường Khương", "Huyện Sa Pa", "Huyện Si Ma Cai", "Huyện Văn Bàn"],
    "36": ["Thành phố Tân An", "Huyện Bến Lức", "Huyện Cần Đước", "Huyện Cần Giuộc", "Huyện Châu Thành", "Huyện Đức Hòa", "Huyện Đức Huệ", "Huyện Mộc Hóa", "Huyện Tân Hưng", "Huyện Tân Thạnh", "Huyện Tân Trụ", "Huyện Thạnh Hóa", "Huyện Thủ Thừa", "Huyện Vĩnh Hưng"],
    "42": ["Thành phố Nam Định", "Huyện Giao Thủy", "Huyện Hải Hậu", "Huyện Mỹ Lộc", "Huyện Nam Trực", "Huyện Nghĩa Hưng", "Huyện Trực Ninh", "Huyện Vụ Bản", "Huyện Xuân Trường", "Huyện Ý Yên"],
    "40": ["Thành phố Vinh", "Thị xã Cửa Lò", "Thị xã Hoàng Mai", "Thị xã Thái Hòa", "Huyện Anh Sơn", "Huyện Con Cuông", "Huyện Diễn Châu", "Huyện Đô Lương", "Huyện Hưng Nguyên", "Huyện Kỳ Sơn", "Huyện Nam Đàn", "Huyện Nghi Lộc", "Huyện Nghĩa Đàn", "Huyện Quế Phong", "Huyện Quỳ Châu", "Huyện Quỳ Hợp", "Huyện Quỳnh Lưu", "Huyện Tân Kỳ", "Huyện Thanh Chương", "Huyện Tương Dương", "Huyện Yên Thành"],
    "41": ["Thành phố Ninh Bình", "Thành phố Tam Điệp", "Huyện Gia Viễn", "Huyện Hoa Lư", "Huyện Kim Sơn", "Huyện Nho Quan", "Huyện Yên Khánh", "Huyện Yên Mô"],
    "43": ["Thành phố Phan Rang – Tháp Chàm", "Huyện Bác Ái", "Huyện Ninh Hải", "Huyện Ninh Phước", "Huyện Ninh Sơn", "Huyện Thuận Bắc", "Huyện Thuận Nam"],
    "44": ["Thành phố Việt Trì", "Thị xã Phú Thọ", "Huyện Cẩm Khê", "Huyện Đoan Hùng", "Huyện Hạ Hòa", "Huyện Lâm Thao", "Huyện Phù Ninh", "Huyện Tam Nông", "Huyện Tân Sơn", "Huyện Thanh Ba", "Huyện Thanh Sơn", "Huyện Yên Lập"],
    "45": ["Thành phố Tuy Hòa", "Thị xã Sông Cầu", "Huyện Đông Hòa", "Huyện Đồng Xuân", "Huyện Phú Hòa", "Huyện Sơn Hòa", "Huyện Sông Hinh", "Huyện Tây Hòa"],
    "46": ["Thành phố Đồng Hới", "Thị xã Ba Đồn", "Huyện Bố Trạch", "Huyện Lệ Thủy", "Huyện Minh Hóa", "Huyện Quảng Ninh", "Huyện Quảng Trạch"],
    "47": ["Thành phố Hội An", "Thành phố Tam Kỳ", "Thị xã Điện Bàn", "Huyện Bắc Trà My", "Huyện Đại Lộc", "Huyện Duy Xuyên", "Huyện Hiệp Đức", "Huyện Nam Giang", "Huyện Nam Trà My", "Huyện Nông Sơn", "Huyện Núi Thành", "Huyện Phú Ninh", "Huyện Phước Sơn", "Huyện Tây Giang"],
    "49": ["Thành phố Quảng Ngãi", "Thị xã Đức Phổ", "Huyện Ba Tơ", "Huyện Bình Sơn", "Huyện Lý Sơn", "Huyện Minh Long", "Huyện Mộ Đức", "Huyện Nghĩa Hành", "Huyện Sơn Hà", "Huyện Sơn Tây", "Huyện Sơn Tịnh", "Huyện Trà Bồng"],
    "48": ["Thành phố Hạ Long", "Thành phố Móng Cái", "Thành Phố Uông Bí", "Thành Phố Cẩm Phả", "Thị Xã Quảng Yên", "Thị Xã Đông Triều", "Huyện Ba Chẽ", "Huyện Bình Liêu", "Huyện Cô Tô", "Huyện Đầm Hà", "Huyện Hải Hà", "Huyện Tiên Yên", "Huyện Vân Đồn"],
    "50": ["Thành phố Đông Hà", "Thị xã Quảng Trị", "Huyện Cam Lộ", "Huyện Cồn Cỏ", "Huyện Đa Krông", "Huyện Gio Linh", "Huyện Hải Lăng", "Huyện Hướng Hóa", "Huyện Triệu Phong"],
    "52": ["Thành phố Sóc Trăng", "Thị xã Ngã Năm", "Thị xã Vĩnh Châu", "Huyện Châu Thành", "Huyện Cù Lao Dung", "Huyện Kế Sách", "Huyện Long Phú", "Huyện Mỹ Tú", "Huyện Thạnh Trị", "Huyện Trần Đề"],
    "51": ["Thành phố Sơn La", "Huyện Bắc Yên", "Huyện Mai Sơn", "Huyện Mộc Châu", "Huyện Mường La", "Huyện Phù Yên", "Huyện Quỳnh Nhai", "Huyện Sông Mã", "Huyện Sốp Cộp", "Huyện Thuận Châu", "Huyện Vân Hồ", "Huyện Yên Châu"],
    "56": ["Thành Phố Tây Ninh", "Thị Xã Trảng Bàng", "Thị Xã Hòa Thành", "Huyện Bến Cầu", "Huyện Châu Thành", "Huyện Dương Minh Châu", "Huyện Gò Dầu", "Huyện Tân Biên", "Huyện Tân Châu"],
    "53": ["Thành phố Thái Bình", "Huyện Đông Hưng", "Huyện Hưng Hà", "Huyện Kiến Xương", "Huyện Quỳnh Phụ", "Huyện Thái Thụy", "Huyện Tiền Hải", "Huyện Vũ Thư"],
    "57": ["Thành phố Thái Nguyên", "Thành phố Sông Công", "Thị xã Phổ Yên", "Huyện Đại Từ", "Huyện Định Hóa", "Huyện Đồng Hỷ", "Huyện Phú Bình", "Huyện Phú Lương", "Huyện Võ Nhai"],
    "55": ["Thành phố Thanh Hóa", "Thị xã Bỉm Sơn", "Thị xã Nghi Sơn", "Huyện Bá Thước", "Huyện Cẩm Thủy", "Huyện Đông Sơn", "Huyện Hà Trung", "Huyện Hậu Lộc", "Huyện Hoằng Hóa", "Huyện Lang Chánh", "Huyện Mường Lát", "Huyện Nga Sơn", "Huyện Ngọc Lặc", "Huyện Như Thanh", "Huyện Như Xuân", "Huyện Nông Cống", "Huyện Quan Hóa", "Huyện Quan Sơn", "Huyện Quảng Xương", "Huyện Thạch Thành", "Huyện Thiệu Hóa", "Huyện Thọ Xuân", "Huyện Thường Xuân", "Huyện Triệu Sơn", "Huyện Vĩnh Lộc", "Huyện Yên Định"],
    "74": ["Thành phố Huế", "Thị xã Hương Thủy", "Thị xã Hương Trà", "Huyện A Lưới", "Huyện Nam Đông", "Huyện Phong Điền", "Huyện Phú Lộc", "Huyện Phú Vang"],
    "54": ["Thành phố Mỹ Tho", "Thị xã Cai Lậy", "Thị xã Gò Công", "Huyện Cái Bè", "Huyện Châu Thành", "Huyện Chợ Gạo", "Huyện Gò Công Đông", "Huyện Gò Công Tây", "Huyện Tân Phú Đông", "Huyện Tân Phước"],
    "75": ["Thành phố Trà Vinh", "Thị xã Duyên Hải", "Huyện Càng Long", "Huyện Châu Thành", "Huyện Duyên Hải", "Huyện Tiểu Cần", "Huyện Trà Cú"],
    "73": ["Thành phố Tuyên Quang", "Huyện Chiêm Hóa", "Huyện Hàm Yên", "Huyện Lâm Bình", "Huyện Na Hang", "Huyện Sơn Dương", "Huyện Yên Sơn"],
    "76": ["Thành phố Vĩnh Long", "Thị xã Bình Minh", "Huyện Bình Tân", "Huyện Long Hồ", "Huyện Mang Thít", "Huyện Tam Bình", "Huyện Trà Ôn", "Huyện Vũng Liêm"],
    "77": ["Thành phố Vĩnh Yên", "Thành phố Phúc Yên", "Huyện Bình Xuyên", "Huyện Lập Thạch", "Huyện Sông Lô", "Huyện Tam Đảo", "Huyện Tam Dương", "Huyện Vĩnh Tường", "Huyện Yên Lạc"],
    "78": ["Thành phố Yên Bái", "Thị xã Nghĩa Lộ", "Huyện Lục Yên", "Huyện Mù Cang Chải", "Huyện Trạm Tấu", "Huyện Trấn Yên", "Huyện Văn Chấn", "Huyện Văn Yên", "Huyện Yên Bình"]
  };



  const countrySelect = document.querySelector('[name="country"]');
  const provinceSelect = document.querySelector('[name="province"]');
  let districtSelect = document.querySelector('[name="district"]');

  /**
   * Cập nhật danh sách huyện dựa trên tỉnh được chọn.
   */
  function updateDistricts() {
    const selectedProvince = provinceSelect.value;
    districtSelect.innerHTML = '<option value="" disabled selected>Chọn quận / huyện</option>';

    if (districts[selectedProvince]) {
      districts[selectedProvince].forEach((district) => {
        const option = document.createElement("option");
        option.value = district;
        option.textContent = district;
        districtSelect.appendChild(option);
      });
    }
  }

  /**
   * Xử lý sự kiện khi quốc gia thay đổi.
   */
  countrySelect.addEventListener("change", function () {
    const isVietnam = this.value === "230";

    // Hiển thị/ẩn tỉnh và huyện dựa trên quốc gia
    if (isVietnam) {
      provinceSelect.style.display = "block";
      // Chuyển đổi ô huyện thành select
      if (districtSelect.tagName.toLowerCase() === 'input') {
        const newSelect = document.createElement('select');
        newSelect.className = 'custom-select district-select';
        newSelect.name = 'district';
        newSelect.required = true;
        newSelect.innerHTML = '<option value="" disabled selected>Chọn quận / huyện</option>';
        districtSelect.replaceWith(newSelect);
        districtSelect = newSelect;
      }
      updateDistricts();
    } else {
      provinceSelect.style.display = "none";
      // Chuyển đổi ô huyện thành input
      if (districtSelect.tagName.toLowerCase() === 'select') {
        const newInput = document.createElement('input');
        newInput.type = 'text';
        newInput.className = 'form-control';
        newInput.placeholder = 'Nhập tỉnh / Thành phố';
        newInput.name = 'district';
        newInput.required = true;
        districtSelect.replaceWith(newInput);
        districtSelect = newInput;
      }
    }
  });

  /**
   * Xử lý sự kiện khi tỉnh thay đổi.
   */
  provinceSelect.addEventListener("change", updateDistricts);

  // Cập nhật ban đầu khi trang tải
  const isVietnamInitial = countrySelect.value === "230";

  if (isVietnamInitial) {
    provinceSelect.style.display = "block";
    updateDistricts();
  } else {
    provinceSelect.style.display = "none";
    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.className = 'form-control';
    newInput.placeholder = 'Nhập quận / huyện';
    newInput.name = 'district';
    newInput.required = true;
    districtSelect.replaceWith(newInput);
    districtSelect = newInput;
  }
</script>
</body>
</html>
