<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Link Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5" style="max-width: 600px;">
  <h2 class="mb-4 text-center">Chỉnh sửa thông tin cá nhân</h2>

  <c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
        ${error}
    </div>
  </c:if>

  <form action="${pageContext.request.contextPath}/user-profile" method="post">
    <div class="mb-3">
      <label for="fullName" class="form-label">Họ và tên:</label>
      <input type="text" class="form-control" id="fullName" name="fullName"
             value="${sessionScope.userProfile.name}" required />
    </div>

    <div class="mb-3">
      <label for="gender" class="form-label">Giới tính:</label>
      <select class="form-select" id="gender" name="gender">
        <option value="" ${sessionScope.userProfile.gender == null ? "selected" : ""}>...</option>
        <option value="Nam" ${sessionScope.userProfile.gender == 'Nam' ? "selected" : ""}>Nam</option>
        <option value="Nữ" ${sessionScope.userProfile.gender == 'Nữ' ? "selected" : ""}>Nữ</option>
        <option value="Khác" ${sessionScope.userProfile.gender == 'Khác' ? "selected" : ""}>Khác</option>
      </select>
    </div>

    <div class="mb-3">
      <label for="birth" class="form-label">Ngày sinh:</label>
      <input type="date" class="form-control" id="birth" name="birth"
             value="${sessionScope.userProfile.birth}" />
    </div>

    <div class="mb-3">
      <label for="address" class="form-label">Địa chỉ:</label>
      <input type="text" class="form-control" id="address" name="address"
             value="${sessionScope.userProfile.address}" />
    </div>

    <div class="mb-3">
      <label for="phone" class="form-label">Số điện thoại:</label>
      <input type="text" class="form-control" id="phone" name="phone"
             value="${sessionScope.userProfile.phoneNumber}" />
    </div>

    <div class="d-flex justify-content-between">
      <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
      <a href="${pageContext.request.contextPath}/user-profile" class="btn btn-secondary">Hủy thay đổi</a>
    </div>
  </form>
</div>

<!-- Link Bootstrap JS (tùy chọn, nếu bạn dùng JS Bootstrap) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
