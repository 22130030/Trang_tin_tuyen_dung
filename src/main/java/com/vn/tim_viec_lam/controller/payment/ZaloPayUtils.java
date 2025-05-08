package com.vn.tim_viec_lam.controller.payment;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@WebServlet(name = "zalo_payment", value = "/zalo_payment")
public class ZaloPayUtils extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Dotenv dotenv = Dotenv.load();
        String APP_ID = dotenv.get("APP_ID");
        String KEY1 = dotenv.get("KEY1");
        String CREATE_ORDER_URL = "https://sb-openapi.zalopay.vn/v2/create";

        String amount = request.getParameter("amount");
        String app_trans_id = new SimpleDateFormat("yyMMddHHmmss").format(new Date());

        long appTime = System.currentTimeMillis();
        String appUser = "user123";
        String item = "[]"; // giữ nguyên chuỗi JSON
        String description = "Payment for order #" + app_trans_id;

        //  Tạo chuỗi dữ liệu để ký
        String data = APP_ID + "|" + app_trans_id + "|" + appUser + "|" + amount + "|" + appTime + "|" + item + "|" + description;
        System.out.println("Raw data for MAC: " + data);

        //  Ký HMAC
        String mac = hmacSha256(data, KEY1);
        System.out.println("MAC: " + mac);

        //  Tạo JSON request
        Map<String, Object> order = new HashMap<>();
        order.put("app_id", APP_ID); // để nguyên là String
        order.put("app_trans_id", app_trans_id);
        order.put("app_user", appUser);
        order.put("app_time", appTime);
        order.put("amount", amount); // để nguyên là String
        order.put("item", new JSONArray(item)); // CHUẨN nhất
        order.put("description", description);
        order.put("mac", mac);

        JSONObject orderJson = new JSONObject(order);

        //  Gửi POST đến ZaloPay
        URL url = new URL(CREATE_ORDER_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStream os = conn.getOutputStream();
        os.write(orderJson.toString().getBytes("UTF-8"));
        os.close();

        //  Nhận phản hồi
        Scanner sc = new Scanner(conn.getInputStream());
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) sb.append(sc.nextLine());
        sc.close();

        JSONObject resp = new JSONObject(sb.toString());
        System.out.println("ZaloPay response: " + resp.toString());

        if (!resp.has("order_url")) {
            response.getWriter().write("Lỗi từ ZaloPay: " + resp.toString());
            return;
        }

        //  Redirect sang giao diện thanh toán
        String paymentUrl = resp.getString("order_url");
        response.sendRedirect(paymentUrl);
    }

    private String hmacSha256(String data, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256"));
            byte[] hash = mac.doFinal(data.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("HMAC-SHA256 Error: " + e.getMessage());
        }
    }
}
