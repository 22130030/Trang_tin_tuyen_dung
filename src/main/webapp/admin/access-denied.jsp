<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Truy cập bị từ chối</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            padding-top: 100px;
        }

        .box {
            display: inline-block;
            padding: 30px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        h2 {
            color: #dc3545;
            font-size: 28px;
        }

        p {
            font-size: 18px;
            margin: 20px 0;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="box">
    <h2>❌ Truy cập bị từ chối</h2>
    <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "Bạn không có quyền truy cập chức năng này." %></p>
    <a href="javascript:history.back()">← Quay lại</a>
</div>
</body>
</html>
