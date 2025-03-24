package com.vn.tim_viec_lam.controller.payment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet("/account/momo-payment")
public class PaymentController extends HttpServlet {
    private static final String MOMO_API_URL = "https://test-payment.momo.vn/v2/gateway/api/create";
    private static final String PARTNER_CODE = "MOMOLRJZ2018206";
    private static final String ACCESS_KEY = "mTCKt9W3eU1m39TW";
    private static final String SECRET_KEY = "SetA5RDnLHvt51AULf51DyauxUo3kDU6";
    private static final String RETURN_URL = "http://localhost:8080/trang_tin_tuyen_dung/home";
    private static final String NOTIFY_URL = "https://88b1-115-73-21-111.ngrok-free.app";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = "ORDER" + System.currentTimeMillis();
        String requestId = orderId;
        String amount = request.getParameter("amount");
        if (amount == null || amount.isEmpty()) {
            response.getWriter().write("Error: Amount is required!");
            return;
        }
        String orderInfo = "Thanh toán MoMo - " + orderId;
        String extraData = "";

        // ✅ Sửa notifyUrl trong rawData
        String rawData = "accessKey=" + ACCESS_KEY +
                "&amount=" + amount +
                "&extraData=" + extraData +
                "&notifyUrl=" + NOTIFY_URL +  // 🔥 Đã sửa lỗi notifyUrl
                "&orderId=" + orderId +
                "&orderInfo=" + orderInfo +
                "&partnerCode=" + PARTNER_CODE +
                "&returnUrl=" + RETURN_URL +
                "&requestId=" + requestId +
                "&requestType=captureWallet";

        String signature;
        try {
            signature = MoMoUtils.hmacSHA256(rawData, SECRET_KEY);
        } catch (Exception e) {
            response.getWriter().write("Error generating signature: " + e.getMessage());
            return;
        }

        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("partnerCode", PARTNER_CODE);
        jsonPayload.put("accessKey", ACCESS_KEY);
        jsonPayload.put("requestId", requestId);
        jsonPayload.put("amount", amount);
        jsonPayload.put("orderId", orderId);
        jsonPayload.put("orderInfo", orderInfo);
        jsonPayload.put("returnUrl", RETURN_URL);
        jsonPayload.put("notifyUrl", NOTIFY_URL);  // 🔥 Đảm bảo notifyUrl không rỗng
        jsonPayload.put("extraData", extraData);
        jsonPayload.put("requestType", "captureWallet");
        jsonPayload.put("signature", signature);

        // ✅ Debug JSON Payload
        System.out.println("Final JSON Payload: " + jsonPayload.toString());

        try {
            URL url = new URL(MOMO_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode != HttpURLConnection.HTTP_OK) {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine);
                }
                System.out.println("MoMo API Error Response: " + errorResponse.toString());
                response.getWriter().write("MoMo API Error: " + errorResponse.toString());
                return;
            }

            StringBuilder responseContent = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }

            System.out.println("MoMo API Response: " + responseContent.toString());

            JSONObject jsonResponse = new JSONObject(responseContent.toString());
            if (jsonResponse.has("payUrl")) {
                response.sendRedirect(jsonResponse.getString("payUrl"));
            } else {
                response.getWriter().write("Payment failed: " + jsonResponse.toString());
            }

        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
