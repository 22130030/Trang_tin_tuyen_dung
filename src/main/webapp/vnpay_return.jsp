<%@ page import="java.util.*, java.text.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả thanh toán VNPay</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            padding: 40px;
        }
        .result-box {
            background: white;
            border-radius: 10px;
            padding: 30px;
            max-width: 600px;
            margin: auto;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #0074d9;
        }
        .status-success {
            color: green;
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            margin: 20px 0;
        }
        .status-fail {
            color: red;
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            margin: 20px 0;
        }
        .info {
            margin-top: 20px;
            font-size: 16px;
        }
        .info p {
            margin: 8px 0;
        }
        .info span {
            font-weight: bold;
        }
        .btn-home {
            display: block;
            text-align: center;
            margin-top: 30px;
        }
        .btn-home a {
            background-color: #0074d9;
            color: white;
            padding: 10px 25px;
            border-radius: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<%
    String responseCode = request.getParameter("vnp_ResponseCode");
    boolean isSuccess = "00".equals(responseCode);

    // Xử lý số tiền
    int amountInt = 0;
    String formattedAmount = "";
    try {
        amountInt = Integer.parseInt(request.getParameter("vnp_Amount")) / 100;
        DecimalFormat formatter = new DecimalFormat("#,###");
        formattedAmount = formatter.format(amountInt);
    } catch (Exception e) {
        formattedAmount = "Không xác định";
    }

    // Xử lý ngày giờ
    String rawDate = request.getParameter("vnp_PayDate");
    String formattedDate = rawDate;
    try {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        formattedDate = outputFormat.format(inputFormat.parse(rawDate));
    } catch (Exception e) {
        formattedDate = "Không xác định";
    }
%>

<div class="result-box">
    <h2>Kết quả thanh toán VNPay</h2>
    <div class="<%= isSuccess ? "status-success" : "status-fail" %>">
        <%= isSuccess ? "✔ Giao dịch thành công!" : "✘ Giao dịch thất bại hoặc bị huỷ!" %>
    </div>

    <div class="info">
        <p><span>Số tiền:</span> <%= formattedAmount %> VNĐ</p>
        <p><span>Mã giao dịch:</span> <%= request.getParameter("vnp_TxnRef") %></p>
        <p><span>Nội dung:</span> <%= request.getParameter("vnp_OrderInfo") %></p>
        <p><span>Thời gian:</span> <%= formattedDate %></p>
    </div>

    <div class="btn-home">
        <a href="<%= request.getContextPath() %>/home">⬅ Về trang chủ</a>
    </div>
</div>
</body>
</html>
