package com.vn.tim_viec_lam.controller.payment;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/account/momo-payment")
public class PaymentController extends HttpServlet {
    private static final String MOMO_API_URL = "https://test-payment.momo.vn/v2/gateway/api/create";
    private static final String PARTNER_CODE = "MOMOLRJZ2018206";
    private static final String ACCESS_KEY = "mTCKt9W3eU1m39TW";
    private static final String SECRET_KEY = "SetA5RDnLHvt51AULf51DyauxUo3kDU6";
    private static final String RETURN_URL = "http://localhost:8080/payment-success.jsp";
    private static final String NOTIFY_URL = "http://localhost:8080/payment-notify";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = "ORDER" + System.currentTimeMillis();
        String requestId = orderId;
        String amount = request.getParameter("amount");

        // Tạo payload
        Map<String, String> payload = new HashMap<>();
        payload.put("partnerCode", PARTNER_CODE);
        payload.put("accessKey", ACCESS_KEY);
        payload.put("requestId", requestId);
        payload.put("amount", amount);
        payload.put("orderId", orderId);
        payload.put("orderInfo", "Thanh toán đơn hàng");
        payload.put("returnUrl", RETURN_URL);
        payload.put("notifyUrl", NOTIFY_URL);
        payload.put("requestType", "captureWallet");
        payload.put("extraData", "");

        // Chuỗi rawData để ký HMAC
        String rawData = "accessKey=" + ACCESS_KEY +
                "&amount=" + amount +
                "&extraData=" +
                "&ipnUrl=" + NOTIFY_URL +
                "&orderId=" + orderId +
                "&orderInfo=Thanh toán đơn hàng" +
                "&partnerCode=" + PARTNER_CODE +
                "&redirectUrl=" + RETURN_URL +
                "&requestId=" + requestId +
                "&requestType=captureWallet";

        // Ký HMAC-SHA256
        String signature = hmacSHA256(rawData, SECRET_KEY);
        payload.put("signature", signature);

        // Chuyển payload thành JSON
        Gson gson = new Gson();
        String jsonPayload = gson.toJson(payload);

        // Gửi yêu cầu HTTP đến MoMo
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(MOMO_API_URL);
            httpPost.setEntity(new StringEntity(jsonPayload, StandardCharsets.UTF_8));
            httpPost.setHeader("Content-type", "application/json");

            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8))) {

                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                // Parse JSON phản hồi
                Map<?, ?> responseMap = gson.fromJson(result.toString(), Map.class);
                if (responseMap.containsKey("payUrl")) {
                    response.sendRedirect(responseMap.get("payUrl").toString());
                } else {
                    response.getWriter().println("Lỗi khi tạo URL thanh toán.");
                }
            }
        }
    }

    // Hàm tạo chữ ký HMAC-SHA256
    private String hmacSHA256(String data, String secretKey) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
