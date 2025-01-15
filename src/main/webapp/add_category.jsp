<%--
  Created by IntelliJ IDEA.
  User: Le Minh Cong
  Date: 1/15/2025
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm nghề nghiệp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin: 15px 0 5px;
            font-weight: bold;
            color: green;
        }
        select, input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        .btn-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .btn-save {
            background-color: orange;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-save:hover {
            background-color: #e69500;
        }
        .btn-back {
            color: blue;
            text-decoration: none;
            font-size: 14px;
        }
        .btn-back:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Thêm nghề nghiệp</h2>
    <form action="add-category" method="post">
        <label for="category">Phân loại</label>
        <select id="category" name="category">
            <option value="Công nghệ thông tin" ${loadcate.categoryName == 'Công nghệ thông tin' ? 'selected': ' '}>Công nghệ thông tin</option>
            <option value="Kinh doanh - Marketing" ${loadcate.categoryName == 'Kinh doanh - Marketing' ? 'selected': ' '}>Kinh doanh - Marketing</option>
            <option value="Tài chính - Ngân hàng" ${loadcate.categoryName == 'Tài chính - Ngân hàng' ? 'selected': ' '}>Tài chính - Ngân hàng</option>
            <option value="Xây dựng" ${loadcate.categoryName == 'Xây dựng' ? 'selected': ' '}>Xây dựng</option>
            <option value="Y tế" ${loadcate.categoryName == 'Y tế' ? 'selected': ' '}>Y tế</option>
            <option value="Giáo dục" ${loadcate.categoryName == 'Giáo dục' ? 'selected': ' '}>Giáo dục</option>
            <option value="Du lịch - Nhà hàng - Khách sạn" ${loadcate.categoryName == 'Du lịch - Nhà hàng - Khách sạn' ? 'selected': ' '}>Du lịch - Nhà hàng - Khách sạn</option>
            <option value="Sản xuất - Cơ khí" ${loadcate.categoryName == 'Sản xuất - Cơ khí' ? 'selected': ' '}>Sản xuất - Cơ khí</option>
            <option value="Nhân sự" ${loadcate.categoryName == 'Nhân sự' ? 'selected': ' '}>Nhân sự</option>
            <option value="Logistics" ${loadcate.categoryName == 'Logistics' ? 'selected': ' '}>Logistics</option>
            <!-- Thêm các tùy chọn khác tại đây -->
        </select>

        <label for="jobCategoryName">Tên Ngành nghề:</label>
        <input type="text"  id="jobCategoryName" name="jobCategoryName" placeholder="Nhập tên ngành nghề">

        <div class="btn-container">
            <button type="submit" class="btn-save">Lưu</button>
            <a href="manager-category" class="btn-back">← Quay lại</a>
        </div>
    </form>
</div>
</body>
</html>

