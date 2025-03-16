package com.vn.tim_viec_lam.controller.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet("/account/momo-payment")
public class PaymentController extends HttpServlet {
    private static final String MOMO_API_URL = "https://test-payment.momo.vn/v2/gateway/api/create";
    private static final String PARTNER_CODE = "MOMOBKUN20180529";
    private static final String ACCESS_KEY = "klm05TvNBzhg7h7j";
    private static final String SECRET_KEY = "at67qH6mk8w5Y1nAyMoYKMWACiEi2bsa";
    private static final String RETURN_URL = "http://localhost:8080/home";
    private static final String NOTIFY_URL = "http://localhost:8080/home";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = "ORDER" + System.currentTimeMillis();
        String requestId = orderId;
        String amount = request.getParameter("amount");
        String orderInfo = "Thanh toán MoMo - " + orderId;
        String extraData = ""; // Có thể để trống

// Tạo chuỗi rawData theo định dạng yêu cầu của MoMo
        String rawData = "accessKey=" + ACCESS_KEY +
                "&amount=" + amount +
                "&extraData=" + extraData +
                "&ipnUrl=" + NOTIFY_URL +
                "&orderId=" + orderId +
                "&orderInfo=" + orderInfo +
                "&partnerCode=" + PARTNER_CODE +
                "&redirectUrl=" + RETURN_URL +
                "&requestId=" + requestId +
                "&requestType=captureWallet";

// Tạo chữ ký với SECRET_KEY
        String signature = null;
        try {
            signature = MoMoUtils.hmacSHA256(rawData, SECRET_KEY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

// Xây dựng JSON payload với chữ ký
        String jsonPayload = "{" +
                "\"partnerCode\":\"" + PARTNER_CODE + "\"," +
                "\"accessKey\":\"" + ACCESS_KEY + "\"," +
                "\"requestId\":\"" + requestId + "\"," +
                "\"amount\":\"" + amount + "\"," +
                "\"orderId\":\"" + orderId + "\"," +
                "\"orderInfo\":\"" + orderInfo + "\"," +
                "\"returnUrl\":\"" + RETURN_URL + "\"," +
                "\"notifyUrl\":\"" + NOTIFY_URL + "\"," +
                "\"extraData\":\"" + extraData + "\"," +
                "\"requestType\":\"captureWallet\"," +
                "\"signature\":\"" + signature + "\"" +
                "}";
        try {
            URL url = new URL(MOMO_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            StringBuilder responseContent = new StringBuilder();

            try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }

            // In phản hồi từ MoMo
            System.out.println("MoMo API Response: " + responseContent.toString());

            // Parse JSON response để lấy payUrl
            org.json.JSONObject jsonResponse = new org.json.JSONObject(responseContent.toString());
            if (jsonResponse.has("payUrl")) {
                response.sendRedirect(jsonResponse.getString("payUrl")); // Chuyển hướng tới trang thanh toán MoMo
            } else {
                response.getWriter().write("Payment failed: " + jsonResponse.toString());
            }

        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

}
